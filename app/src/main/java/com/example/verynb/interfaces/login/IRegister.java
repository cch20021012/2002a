package com.example.verynb.interfaces.login;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.login.RegisterBean;

public interface IRegister {
    interface View extends IBaseView{
        void getRegister(RegisterBean registerBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void getRegister(String username,String pw);
    }
    interface Model extends IBaseModel{
        void getRegister(String username, String pw, Callback callback);
    }
}
