package com.patryk.mvpdagger2.network;

import com.patryk.annotations.Shrouded;
import com.patryk.mvpdagger2.MVPApp;

import javax.inject.Inject;

/**
 * Created by Patryk on 7/23/2015.
 */
@Shrouded
public class TwitterAPI {

    private OKClient mOkClient;

    @Inject
    public TwitterAPI(OKClient okClient, MVPApp app) {
        mOkClient = okClient;
        //... do stuff//
    }

    public String fetchTweetFromServer(){
        return mOkClient.getResponse() + " some parsing done";
    }
}
