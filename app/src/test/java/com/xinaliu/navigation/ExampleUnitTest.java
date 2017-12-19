package com.xinaliu.navigation;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

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
                StringBuilder sb_jsonarrar = new StringBuilder();
                sb_jsonarrar.append("[");

                for (Element element2 : a1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("{");
                    sb.append("\"contentTitle\":");
                    sb.append("\"" + element2.text() + "\"");
                    sb.append(",");
                    sb.append("\"contentUrl\":");
                    sb.append("\"" + element2.attr("href") + "\"");
                    sb.append("}");
                    sb_jsonarrar.append(sb.toString());
                    sb_jsonarrar.append(",");
                }
                sb_jsonarrar.deleteCharAt(sb_jsonarrar.length() - 1);
                sb_jsonarrar.append("]");
                System.out.println(sb_jsonarrar);
            }
        }
    }

    public static String mapToJson(Map<String, Object> map) {
        if (map == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String s : map.keySet()) {
            sb.append("\"" + s + "\":");
            sb.append(",");
        }
        if (sb.length() > 2)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
    public static String listToJson(List<Object> list){
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}