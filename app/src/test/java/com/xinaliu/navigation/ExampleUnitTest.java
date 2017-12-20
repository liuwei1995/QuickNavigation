package com.xinaliu.navigation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
//        "[{\"name\":\"name1\"},{\"name\":\"name2\"}]"
        boolean s = toType("{}", boolean.class, "name");
//        boolean s = toType("{\"name\":\"false\"}", boolean.class, "name");
        System.out.println(s);
        Name name = toType("{\"name\":{\"name\":\"1\"}}", Name.class, "name");
        System.out.println(name);
    }

    private <T> void Test1(String str, Class<T> t) {
        Object o = Array.newInstance(t, 0);
        Gson gson = new Gson();
        T[] array = (T[]) gson.fromJson(str, o.getClass());
        Type type = new TypeToken<ArrayList<T>>() {
        }.getType();

        List<T> list = Arrays.asList(array);
        System.out.println(list.toString());
        String toJson = gson.toJson(list);
        System.out.println(toJson);
    }
    private static Gson gson = new Gson();
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

    public <T> List<T> toListType(String str, Class<T> t) {
//        jsonToList(str, UserJSON[].class);
//        ArrayList<T> list = new ArrayList<>();
//        T[] aa = (T[]) Array.newInstance(t);
//        try {
//            T [] aa = Class.forName(t.getName()).getClasses();
//            Gson gson = new Gson();
//            T[] array = gson.fromJson(str, clazz);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        T[] array = gson.fromJson(str, clazz);
        return Arrays.asList(null);
    }
    public class Name{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    private void Test() throws IOException, JSONException {
        Document document = Jsoup.connect("http://www.jikedaohang.com/index/index/part/id/9/name/Android.html").get();
        Elements elementsByClass = document.getElementsByClass("site-content");
        if (elementsByClass != null && elementsByClass.size() > 0) {
            Element element = elementsByClass.get(0);
            Elements elementsByClass_layui_tab = element.getElementsByClass("layui-tab layui-tab-card");
            for (Element element1 : elementsByClass_layui_tab) {
                Elements elementsByClass_layui_tab_li = element1.getElementsByClass("layui-tab-li");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", elementsByClass_layui_tab_li.toString());
                Elements elementsByClass_layui_tab_content = element1.getElementsByClass("layui-tab-content");
                Element element3 = elementsByClass_layui_tab_content.get(0);
                Elements a1 = element3.getElementsByTag("a");
//                StringBuilder sb_jsonarrar = new StringBuilder();
//                sb_jsonarrar.append("[");

                List<Object> list = new ArrayList<>();

                for (Element element2 : a1) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("contentTitle", element2.text());
                    map.put("contentUrl", element2.attr("href"));
                    map.put("is", false);
                    String mapToJson = mapToJson(map);
                    list.add(mapToJson);


//                    StringBuilder sb = new StringBuilder();
//                    sb.append("{");
//                    sb.append("\"contentTitle\":");
//                    sb.append("\"" + element2.text() + "\"");
//                    sb.append(",");
//                    sb.append("\"contentUrl\":");
//                    sb.append("\"" + element2.attr("href") + "\"");
//                    sb.append("}");
//                    sb_jsonarrar.append(sb.toString());
//                    sb_jsonarrar.append(",");
                }
//                sb_jsonarrar.deleteCharAt(sb_jsonarrar.length() - 1);
//                sb_jsonarrar.append("]");
//                System.out.println(sb_jsonarrar);
                String listToJson = listToJson(list);
                System.out.println(listToJson);
            }
        }
    }

    public static String mapToJson(Map<String, Object> map) {
        if (map == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String s : map.keySet()) {
            sb.append("\"" + s + "\":");
            if (map.get(s) instanceof String)
                sb.append("\"" + map.get(s) + "\"");
            else {
                sb.append(map.get(s));
            }
            sb.append(",");
        }
        if (sb.length() > 2)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static String listToJson(List<Object> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (list != null)
            for (Object o : list) {
                sb.append(o);
                sb.append(",");
            }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}