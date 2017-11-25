package TestRarseUrl;

import java.util.HashMap;
import java.util.Map;

//import org.apache.catalina.util;

/**
 * 解析Url中的属性键值对到Map中。
 * Created by felix on 15/7/22.
 */
public class TestParseUrl {
    public static void main(String[] args) {
        String query = "cid=haha&vid=888";

        Map<String, String> values = new HashMap<String, String>();
//        RequestUtil.parseParameters(values, query, "UTF-8");
    }
}
