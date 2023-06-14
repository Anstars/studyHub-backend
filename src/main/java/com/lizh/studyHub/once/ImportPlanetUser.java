package com.lizh.studyHub.once;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is for xxxx.
 *
 * @author Mr.Li
 * @version 2023-05-20 下午 08:26
 */
public class ImportPlanetUser {
    public static void main(String[] args) {
        String fileName = "D:\\code\\studyHub-backend\\src\\main\\resources\\testExcel.xlsx";
        //这里 需要指定读用哪个class去读，然后读取第一个sheet，同步读取会自动finsh
        List<PlanetTableUserInfo> userInfoList =
                EasyExcel.read(fileName).head(PlanetTableUserInfo.class).sheet().doReadSync();
        System.out.println("总数 = " + userInfoList.size());
        Map<String, List<PlanetTableUserInfo>> listMap =
                userInfoList.stream()
                        .filter(userinfo -> StringUtils.isNotEmpty(userinfo.getUsername()))
                        .collect(Collectors.groupingBy(PlanetTableUserInfo::getUsername));
        System.out.println("不重复昵称" + listMap.keySet().size());
    }
}
