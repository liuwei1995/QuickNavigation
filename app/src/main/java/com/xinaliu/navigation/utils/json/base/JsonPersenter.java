package com.xinaliu.navigation.utils.json.base;

import java.util.List;

/**
 * Created by liuwei on 2017/12/20 13:29
 */

public interface JsonPersenter {

    <T> T toType(String str, Class<T> t);

    <T> T toType(String str, Class<T> t, String key);

    <T> List<T> toListType(String str, Class<T> t);

    <T> List<T> toListType(String str, Class<T> t, String key);


}
