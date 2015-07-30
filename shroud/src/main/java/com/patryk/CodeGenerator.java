package com.patryk;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import static com.squareup.javapoet.TypeSpec.interfaceBuilder;
import static com.squareup.javapoet.MethodSpec.methodBuilder;

import javax.lang.model.element.*;

/**
 * Created by Patryk on 7/26/2015.
 */
public class CodeGenerator {

    private static final String SUFFIX = "Shrouded";
    private final String className;
    private final String generatedName;
    private final TypeElement typeElement;


    public CodeGenerator(TypeElement typeElement){
        className = typeElement.getSimpleName().toString();
        generatedName = className + SUFFIX;
        this.typeElement = typeElement;
    }

    TypeSpec generateInterface(){
        TypeSpec.Builder builder = interfaceBuilder(generatedName);
        for(Element element : this.typeElement.getEnclosedElements()){
            if(element.getKind().equals(ElementKind.METHOD)){
                createMethod(element);
            }
        }

        return builder.build();
    }

    MethodSpec createMethod(Element element){
        MethodSpec.Builder builder = methodBuilder(element.getSimpleName().toString());
//
//        for(Modifier modifier : element.getModifiers()){
//            builder.addModifiers(modifier);
//        }

        for(Element parameter : element.getEnclosedElements()){
            if(parameter instanceof TypeParameterElement){

            }
        }

        return builder.build();
    }

}
