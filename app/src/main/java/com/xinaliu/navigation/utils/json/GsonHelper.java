package com.xinaliu.navigation.utils.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.xinaliu.navigation.utils.json.base.JsonPersenter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwei on 2017/12/20 15:30
 */

public class GsonHelper implements JsonPersenter {

    private GsonHelper() {
    }

    private static GsonHelper mGsonHelper;

    public static GsonHelper newInstance() {
        if (mGsonHelper == null) {
            synchronized (GsonHelper.class) {
                if (mGsonHelper == null)
                    mGsonHelper = new GsonHelper();
            }
        }
        return mGsonHelper;
    }

    private static Gson gson = new Gson();

    @Override
    public <T> T toType(String str, Class<T> t) {
        return gson.fromJson(str, t);
    }

    @Override
    public <T> T toType(String str, Class<T> t, String key) {
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(str);
        if (!root.isJsonObject())return null;
        JsonObject element = root.getAsJsonObject();

        JsonElement jsonElement = element.get(key);
        if (jsonElement == null){
            if (t == int.class || t == float.class || t == double.class){
                return gson.fromJson("0", t);
            }else if (t == boolean.class){
                return gson.fromJson("false", t);
            }else return null;
        }
        return gson.fromJson(jsonElement, t);
    }

    @Override
    public <T> List<T> toListType(String str, Class<T> t) {
        Type type = new TypeToken<List<T>>() {}.getType();
        return gson.fromJson(str, type);
    }

    @Override
    public <T> List<T> toListType(String str, Class<T> t, String key) {
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(str);
        if (!root.isJsonObject()) return new ArrayList<>();
        JsonObject element = root.getAsJsonObject();

        JsonElement jsonElement = element.get(key);
        if (jsonElement == null || !jsonElement.isJsonArray()) return new ArrayList<>();
        Type type = new TypeToken<List<T>>() {
        }.getType();
        return gson.fromJson(jsonElement, type);
    }


}
