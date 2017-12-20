package com.xinaliu.navigation.ui.view;

/**
 * Created by liuwei on 2017/11/17 14:45
 */

public interface BaseView<T> {

//    final String methodName = new Exception().getStackTrace()[0].getMethodName();

//    /**
//     * 开始请求
//     * @param methodName
//     */
//    void onBeginRequest(T methodName);//区别
//
//    /**
//     * 结束请求
//     * @param isSuccess
//     * @param methodName
//     */
//    void onEndRequest(boolean isSuccess, T methodName);
//
//    /**
//     * 登录超时
//     * @param timeCode
//     * @param methodName
//     */
//    void onLoginTimeout(int timeCode, T methodName);
//
//    /**
//     * 错误
//     * @param stateCode
//     * @param errorMsg
//     * @param methodName
//     */
//    void onStateCodeError(int stateCode, String errorMsg, T methodName);

    void showToast(Integer stateCode, String message, T methodName);

    void showLoading(T methodName);

    void hideLoading(boolean isSuccess, T methodName);

}
