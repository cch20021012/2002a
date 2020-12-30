package com.example.verynb.interfaces.me;



import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.me.UserInfoBean;

import java.util.Map;

public interface IUser {
    interface View extends IBaseView {
        void updateUserInfoReturn(UserInfoBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void updateUserInfo(Map<String, String> map);
    }


    interface Model extends IBaseModel {
        void updateUserInfo(Map<String, String> map, Callback callback);
    }
}
