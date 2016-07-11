package com.yuen.yizu.web;


import com.yuen.yizu.base.BasePresenter;
import com.yuen.yizu.base.BaseView;

public class UserInfoContract {

    interface View extends BaseView {

       // void onGetTaskDetailSuccess(TaskDetailViewModel taskDetailViewModel);

        void onGetTaskDetailFailure();

    }

    interface UserInfoPresenter extends BasePresenter {
        /**
         *
         * @param context
         * @param uid
         */
        void requestUserInfo(String uid);
    }

}