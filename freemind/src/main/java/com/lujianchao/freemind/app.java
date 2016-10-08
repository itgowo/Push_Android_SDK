package com.lujianchao.freemind;

import android.app.Application;

import com.freemind.lujianchao.core_socket.Core.Base.ClientManager;
import com.freemind.lujianchao.core_socket.Core.Entity.PushMsgEntity;
import com.freemind.lujianchao.core_socket.Core.Interface.onReceivePushMsgListener;


/**
 * Created by Lu JianChao on 2016/7/26.
 */
public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ClientManager.InitServer(this);
        ClientManager.getPushManager().setOnReceivePushMsgListener(new onReceivePushMsgListener() {
            @Override
            public void onReceivePushUserMsgListener(PushMsgEntity mPushMsgEntity) {
                System.out.println("app.onReceivePushUserMsgListener");
                System.out.println(mPushMsgEntity);
            }

            @Override
            public void onReceivePushSystemMsgListener(PushMsgEntity mPushMsgEntity) {
                System.out.println("app.onReceivePushSystemMsgListener");
            }

            @Override
            public void onReceivePushUserFunctionListener(PushMsgEntity mPushMsgEntity) {
                System.out.println("app.onReceivePushUserFunctionListener");
            }

            @Override
            public void onReceivePushSystemFunctionListener(PushMsgEntity mPushMsgEntity) {
                System.out.println("app.onReceivePushSystemFunctionListener");
            }
        });
    }
}
