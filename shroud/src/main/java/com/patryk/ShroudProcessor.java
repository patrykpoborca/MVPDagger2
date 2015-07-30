package com.patryk;

import com.patryk.annotations.Shrouded;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import static com.squareup.javapoet.JavaFile.builder;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.patryk.annotations.Shrouded")
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class ShroudProcessor extends AbstractProcessor{

    private static final String ANNOTATION = "@" + Shrouded.class.getCanonicalName();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(Shrouded.class)){
            try {

                generateCode((TypeElement) annotatedElement);
            } catch (IOException e) {
            }

        }
        return true;
    }

    private void generateCode(TypeElement annotatedClass)  throws  IOException {

        String packageName = getPackageName(processingEnv.getElementUtils(), annotatedClass);

        CodeGenerator codeGenerator = new CodeGenerator(annotatedClass);
        TypeSpec generatedClass = codeGenerator.generateInterface();

        JavaFile javaFile = builder(packageName, generatedClass).build();
//        javaFile.writeTo(processingEnv.getFiler());
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Shrouded.class.getCanonicalName());
    }


    String getPackageName(Elements elementUtils, TypeElement type) {
        PackageElement pkg = elementUtils.getPackageOf(type);

        return pkg.getQualifiedName().toString();
    }


    public class UnnamedPackageException extends Exception {

        public UnnamedPackageException(TypeElement typeElement) {
            super("The package of " + typeElement.getSimpleName() + " is unnamed");
        }
    }
}
