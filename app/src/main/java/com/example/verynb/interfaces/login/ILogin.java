package com.example.verynb.interfaces.login;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.login.LoginBean;

public interface ILogin {
    interface View extends IBaseView{
        void getLogin(LoginBean loginBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void getLogin(String username,String pw);
    }
    interface Model extends IBaseModel{
        void getLogin(String username, String pw, Callback callback);
    }
}
