package com.xinaliu.navigation.utils.json.base;

import java.util.List;

/**
 * Created by liuwei on 2017/12/20 13:28
 */

public class JsonHepler implements JsonPersenter {

    private static JsonHepler mJsonHepler;

    private JsonHepler() {
    }

    public static JsonHepler newInstance() {
        if (mJsonHepler == null) {
            synchronized (JsonHepler.class) {
                if (mJsonHepler == null)
                    mJsonHepler = new JsonHepler();
            }
        }
        return mJsonHepler;
    }

    private JsonPersenter mJsonPersenter;

    public void init(JsonPersenter mJsonPersenter) {
        if (this.mJsonPersenter == null) {
            synchronized (JsonHepler.class) {
                if (this.mJsonPersenter == null)
                    this.mJsonPersenter = mJsonPersenter;
            }
        }
    }


    @Override
    public <T> T toType(String str, Class<T> t) {
        if (mJsonPersenter != null)return mJsonPersenter.toType(str, t);
        return null;
    }

    @Override
    public <T> T toType(String str, Class<T> t, String key) {
        if (mJsonPersenter != null)return mJsonPersenter.toType(str, t, key);
        return null;
    }

    @Override
    public <T> List<T> toListType(String str, Class<T> t) {
        if (mJsonPersenter != null)return mJsonPersenter.toListType(str, t);
        return null;
    }

    @Override
    public <T> List<T> toListType(String str, Class<T> t, String key) {
        if (mJsonPersenter != null)return mJsonPersenter.toListType(str, t, key);
        return null;
    }
}
