package com.se7en.biz.login.controller;

import com.se7en.biz.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TestController {

    private static String PHPID = "PHPSESSID=tnfn4ge9ehmdqfehc28i37ncb4;";
    private static String URLDATA = "http://dnfwujia.com/getdata.php";

    public static void main(String[] args) {
/*
        try {
            String url = "http://dnfwujia.com/index.php/Index/Index/search";
//            String url = "http://dnfwujia.com/index.php/Index/Index/search";
//            String http = http("typeid1=&typeid2=&typeid3=&page=0", url);
//            String http = HttpUtil.http("name=%2B7",PHPID, url);
String http="{\"count\":\"8\",\"size\":0,\"page\":null,\"alist\":[{\"id\":\"648\",\"goodname\":\"+7\\u9ec4\\u91d1\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1003\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535896934\",\"img\":\"uploads\\/149318935048825.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"649\",\"goodname\":\"+7\\u94c2\\u91d1\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1004\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535896945\",\"img\":\"uploads\\/149318933195624.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"650\",\"goodname\":\"+7\\u7fe1\\u7fe0\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1005\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535896991\",\"img\":\"uploads\\/149318929038526.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"651\",\"goodname\":\"+7\\u94bb\\u77f3\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1006\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897045\",\"img\":\"uploads\\/149318925936633.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"670\",\"goodname\":\"+7\\u9ec4\\u91d1\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1025\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897433\",\"img\":\"uploads\\/149318859079491.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"671\",\"goodname\":\"+7\\u94c2\\u91d1\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1026\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897445\",\"img\":\"uploads\\/149318856467840.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"672\",\"goodname\":\"+7\\u7fe1\\u7fe0\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1027\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897455\",\"img\":\"uploads\\/149318854140618.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"673\",\"goodname\":\"+7\\u94bb\\u77f3\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1028\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897464\",\"img\":\"uploads\\/149318851567439.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"}]}";
            Map map = JsonUtils.toBean(Map.class, http);
            List<Map<String, Object>> alist = (List<Map<String, Object>>) map.get("alist");
            String ids = "";
            String names = "";
            for (Map<String, Object> map1 : alist) {
                ids += "\"" + map1.get("id") + "\",";
                names += "\"" + new String(map1.get("goodname").toString().getBytes(), "utf-8") + "\",";
            }
            System.out.println(ids);
            System.out.println(names);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }


    @GetMapping("/hi")
    public String get() {
//        String stime = LocalDate.now().withDayOfMonth(1).toString();
        String stime = LocalDate.now().plusMonths(-1).withDayOfMonth(1).toString();
        String etime = LocalDate.now().toString();
        //aid 35 跨1
        String aid = "35";
//        String[] ids = {"646", "685", "693", "670"};
//        String[] names = {"挑战", "12黑增", "魔刹石", "7黄增"};
//        String[] ids = {"646", "647", "648", "649", "650", "651", "652", "653", "654", "655"};
//        String[] names = {"深渊派对挑战书", "装备强化保护券", "+7黄金装备强化券", "+7铂金装备强化券", "+7翡翠装备强化券", "+7钻石装备强化券", "+10黄金装备强化券", "+10铂金装备强化券", "+10翡翠装备强化券", "+10钻石装备强化券"};

//        String[] ids = {"646", "647","693", };
//        String[] names = {"深渊派对挑战书", "装备强化保护券","魔刹石", };


        String[] ids = {"685", "686", "687"};
        String[] names = {"+12黑铁装备增幅券", "+12青铜装备增幅券", "+12白银装备增幅券"};

        for (int i = 0; i < ids.length; i++) {
            String json = HttpUtil.http("id=" + ids[i] + "&aid=" + aid + "&types=1&stime=" + stime + "&etime=" + etime,PHPID, URLDATA);
            export(json, names[i]);
        }

        return "hi";
    }



    public static void export(String json, String name) {/*

        Map map = JsonUtils.toBean(Map.class, json);
        String datas = map.get("data1").toString() + map.get("data2").toString();
        String xAxis = map.get("xAxis").toString();
        String[] data = datas.split(",");
        String[] xAxi = xAxis.split(",");
        DataEntity dataEntity;
        List<DataEntity> list = new ArrayList<>();
        for (int i = 0; i < xAxi.length; i++) {
            dataEntity = new DataEntity();
            dataEntity.setDate(xAxi[i]);
            dataEntity.setValue(Float.parseFloat(data[i]));
            list.add(dataEntity);
        }
        String[] s = {"date", "value"};
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(name);

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("日期");
        cell = row.createCell(1);
        cell.setCellValue("数值");
        int i = 2;
        for (DataEntity entity : list) {
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(entity.getDate());
            cell = row.createCell(1);
            cell.setCellValue(entity.getValue());
            i++;
        }

        File file = new File("f://dnf//aa" + name + LocalDate.now().toString() + ".xls");
        try {
            wb.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

}
