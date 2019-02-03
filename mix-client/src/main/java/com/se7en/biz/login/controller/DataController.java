package com.se7en.biz.login.controller;

import com.se7en.biz.login.entity.DataEntity;
import com.se7en.conf.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {

    private static String URLDATA = "http://dnfwujia.com/getdata.php";

//    @Autowired
//    private basese
    @Autowired
    private SysProperties sysProperties;
    @PostMapping("/data")
    public List<DataEntity> get(@RequestBody DataEntity dataEntity) {
//        String stime = LocalDate.now().withDayOfMonth(1).toString();
        String stime = LocalDate.now().plusMonths(-1).toString();
        String etime = LocalDate.now().toString();
        //aid 35 跨1
        String aid = "35";
//        String[] ids = {"646", "685", "693", "670"};
//        String[] names = {"挑战", "12黑增", "魔刹石", "7黄增"};
//        String[] ids = {"646", "647", "648", "649", "650", "651", "652", "653", "654", "655"};
//        String[] names = {"深渊派对挑战书", "装备强化保护券", "+7黄金装备强化券", "+7铂金装备强化券", "+7翡翠装备强化券", "+7钻石装备强化券", "+10黄金装备强化券", "+10铂金装备强化券", "+10翡翠装备强化券", "+10钻石装备强化券"};


//        String[] ids = {"678", "679", "680","685", "686", "687"};
//        String[] names = {"+11黑铁装备增幅券", "+11青铜装备增幅券", "+11白银装备增幅券","+12黑铁装备增幅券", "+12青铜装备增幅券", "+12白银装备增幅券"};

//        for (int i = 0; i < ids.length; i++) {
//            export(json, names[i]);
//        }
       /* String http = HttpUtil.http("id="+dataEntity.getId()+"&aid=" + aid + "&types=1&stime=" + stime + "&etime=" + etime,sysProperties.getPhpId(), URLDATA);

//     http="{\"data1\":\"9155555,8600000,8886998,8469999,8200000,8333333,8529000,8666000,8300000,8100000,8388888,8399999,8300000,8200000,7777777,8688887,8111000,8222222,8488888,8400000,8400000,8299000,8300000,8222222,8200000,8379000,8099999,8344444,8300000,8300000,8388880,8570000,8299999,8300000,8388888,8100000,8088880,8277777,8099997,8300000,8100000,7111111,7388888,6888888,7250000,7350000,5477776,4399999,4499980,4800000,5000000,5222221,5277777,5189999,5533333,\",\"data2\":\"8888888,8888885,8888885,8821888,8821888,8666660,8666660,8666660,8500000,8500000,8500000,8500000,8400000,8400000,8388888,8388888,8388888,8388888,8388888,8400000,8400000,8400000,8400000,8400000,8388888,8388888,8377777,8377777,8377777,8388880,8388880,8388880,8388880,8444444,8444444,8388880,8388880,8388880,8388880,8333333,8333333,8300000,8300000,7530000,7530000,7288880,6979999,4499980,4499980,4499979,4499980,4499980,4800000,4800000,5000000,\",\"data3\":\"492,730,667,681,660,654,801,754,605,523,648,670,582,605,481,811,838,616,501,430,481,503,549,542,552,557,616,425,481,383,353,430,635,516,563,421,317,431,487,421,528,687,611,644,494,576,850,2990,1411,1519,1499,1586,1930,1827,1620,\",\"data4\":\"50,73,67,69,66,66,81,76,61,53,65,67,59,61,49,82,84,62,51,43,49,51,55,55,56,56,62,43,49,39,36,43,64,52,57,43,32,44,49,43,53,69,62,65,50,58,85,299,142,152,150,159,193,183,162,\",\"data5\":\"82.8036,122.859,112.2561,114.6123,111.078,110.0682,134.8083,126.8982,101.8215,88.0209,109.0584,112.761,97.9506,101.8215,80.9523,136.4913,141.0354,103.6728,84.3183,72.369,80.9523,84.6549,92.3967,91.2186,92.9016,93.7431,103.6728,71.5275,80.9523,64.4589,59.4099,72.369,106.8705,86.8428,94.7529,70.8543,53.3511,72.5373,81.9621,70.8543,88.8624,115.6221,102.8313,108.3852,83.1402,96.9408,143.055,503.217,237.4713,255.6477,252.2817,266.9238,324.819,307.4841,272.646,\",\"xAxis\":\"2018-12-08 23:25:24,2018-12-09 20:33:07,2018-12-10 00:40:47,2018-12-10 11:21:55,2018-12-10 21:26:36,2018-12-11 08:04:53,2018-12-11 18:00:18,2018-12-12 03:54:11,2018-12-12 13:47:43,2018-12-12 23:53:43,2018-12-13 17:42:40,2018-12-14 03:23:43,2018-12-14 13:44:21,2018-12-14 23:40:39,2018-12-15 09:47:21,2018-12-15 19:54:40,2018-12-16 05:50:08,2018-12-16 15:45:39,2018-12-17 01:48:50,2018-12-17 11:41:17,2018-12-17 21:40:31,2018-12-18 07:35:33,2018-12-18 17:30:34,2018-12-19 03:34:24,2018-12-19 13:29:54,2018-12-19 23:38:51,2018-12-20 09:34:33,2018-12-20 19:29:18,2018-12-21 05:51:12,2018-12-21 15:45:41,2018-12-22 02:30:35,2018-12-22 12:26:03,2018-12-22 22:21:17,2018-12-23 08:15:11,2018-12-23 18:10:24,2018-12-24 06:14:26,2018-12-24 16:22:12,2018-12-25 17:10:50,2018-12-26 03:17:31,2018-12-26 13:16:19,2018-12-26 23:12:23,2018-12-27 14:22:43,2018-12-28 00:51:04,2018-12-28 10:43:26,2018-12-28 23:01:31,2018-12-29 08:52:31,2019-01-01 12:41:25,2019-01-04 10:59:44,2019-01-05 03:08:22,2019-01-05 19:35:09,2019-01-06 09:02:42,2019-01-06 23:49:10,2019-01-07 12:17:37,2019-01-08 03:16:01,2019-01-08 15:33:24,\",\"info\":{\"goodname\":\"+12\\u9ed1\\u94c1\\u88c5\\u5907\\u589e\\u5e45\\u5238\"}} \n";
        Map map = JsonUtils.toBean(Map.class, http);
        String datas = map.get("data1").toString() + map.get("data2").toString();
        String xAxis = map.get("xAxis").toString();
        String[] data = datas.split(",");
        String[] xAxi = xAxis.split(",");
        DataEntity dataEntity1;
        List<DataEntity> list = new ArrayList<>();
        for (int i = 0; i < xAxi.length; i++) {
            dataEntity1 = new DataEntity();
            dataEntity1.setDate(xAxi[i]);
            dataEntity1.setValue(Float.parseFloat(data[i]));
            list.add(dataEntity1);
        }*/
        List<DataEntity> list = new ArrayList<>();

        return list;
    }

    public static void export(String json, String name) {

        /*Map map = JsonUtils.toBean(Map.class, json);
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
        }*/

    }

}
