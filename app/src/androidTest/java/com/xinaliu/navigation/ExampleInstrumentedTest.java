package com.xinaliu.navigation;

import android.support.test.runner.AndroidJUnit4;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        Document document = Jsoup.connect("http://www.jikedaohang.com/index/index/part/id/9/name/Android.html").get();
        Elements elementsByClass = document.getElementsByClass("site-content");
        if (elementsByClass != null && elementsByClass.size() > 0){
            Element element = elementsByClass.get(0);
            Elements elementsByClass_layui_tab = element.getElementsByClass("layui-tab layui-tab-card");
            JSONArray jsonArray = new JSONArray();
            for (Element element1 : elementsByClass_layui_tab) {
                Elements elementsByClass_layui_tab_li = element1.getElementsByClass("layui-tab-li");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", elementsByClass_layui_tab_li.toString());
                Elements elementsByClass_layui_tab_content = element1.getElementsByClass("layui-tab-content");
                Element element3 = elementsByClass_layui_tab_content.get(0);
                Elements a1 = element3.getElementsByTag("a");
                JSONArray jsonArrayContent = new JSONArray();
                for (Element element2 : a1) {
                    JSONObject jsonObjectContent = new JSONObject();
                    jsonObjectContent.put("contentTitle", element2.toString());
                    jsonObjectContent.put("contentUrl", element2.toString());

                    jsonArrayContent.put(jsonObjectContent);
                }
                System.out.println(jsonArrayContent.toString());
                jsonArray.put(jsonArrayContent);
            }
        }
    }
}
