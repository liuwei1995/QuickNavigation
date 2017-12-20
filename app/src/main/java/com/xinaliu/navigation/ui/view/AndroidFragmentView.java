package com.xinaliu.navigation.ui.view;

import com.xinaliu.navigation.entity.AndroidFragmentEntity;

import java.util.List;

/**
 * Created by liuwei on 2017/12/20 10:39
 */

public interface AndroidFragmentView extends BaseView {

    void getDataCallBack(List<AndroidFragmentEntity> list);

}
