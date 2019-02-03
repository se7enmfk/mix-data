package com.se7en.biz;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpUtil {
    private static String URLDATA = "http://dnfwujia.com/getdata.php";

    public static String http(String content, String phpId, String url) {
        String jsonStr = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8;");
            conn.setRequestProperty("Cookie", "PHPSESSID=" + phpId);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.6735.400 QQBrowser/10.2.2614.400");
            conn.connect();
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(content);
            out.flush();
            out.close();
            Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
            while (scanner.hasNext()) {
                jsonStr += scanner.next() + " ";
            }
            scanner.close();
            conn.disconnect();
            System.out.println(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
