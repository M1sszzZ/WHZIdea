package com.youcash.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.youcash.VO.StudentVO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Package: com.youcash
 * @FileName: directExportExcel
 * @Desc:
 * @Author: Wanghezi
 * @CreateTime: 2019-12-18 09:20
 */
@Component
@RequestMapping("/directExportExcel")
public class directExportExcel {
    @RequestMapping("test1")
    public void directExport() throws IOException {
        // Map作为每一行的数据容器，List作为行的容器
        List<Map<String, Object>> rowDataList = new ArrayList<>();
        // 每个ExcelExportEntity存放Map行数据的key
        List<ExcelExportEntity> keyList = new ArrayList<>();
        Map<String, Object> aRowMap;
        final int COMMON_KEY_INDEX = 10;
        for (int i = 0; i < 5; i++) {
            // 一个Map对应一行数据（如果需要导出多行数据，那么需要多个Map）
            aRowMap = new HashMap<>(16);
            for (int j = 0; j < COMMON_KEY_INDEX; j++) {
                String key = j + "";
                aRowMap.put(key, "坐标为(" + i + "," + j + ")");
            }
            rowDataList.add(aRowMap);
            // 同一列对应的cell,在从Map里面取值时，会共用同一个key
            // 因此ExcelExportEntity的个数要保持和列数做多的行 的map.size()大小一致
            if (i == 0) {
                ExcelExportEntity excelExportEntity;
                for (int j = 0; j < COMMON_KEY_INDEX; j++) {
                    excelExportEntity = new ExcelExportEntity();
                    excelExportEntity.setKey(j + "");
                    // 设置cell宽
                    excelExportEntity.setWidth(15D);
                    // 设置cell是否自动换行
                    excelExportEntity.setWrap(true);
                    keyList.add(excelExportEntity);
                }
            }
        }
        // excel总体设置
        ExportParams exportParams = new ExportParams();
        // 不需要标题
        exportParams.setCreateHeadRows(false);
        // 指定sheet名字
        exportParams.setSheetName("直接导出数据测试");
        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, keyList, rowDataList);
        File savefile = new File("C:/Users/Wanghezi/IdeaProjects/WHZ/easyPOI");
        if (!savefile.exists()) {
            boolean result = savefile.mkdirs();
            System.out.println("目录不存在，创建" + result);
        }
        FileOutputStream fos = new FileOutputStream("C:/Users/Wanghezi/IdeaProjects/WHZ/easyPOI/直接导出test.xlsx");
        workbook.write(fos);
        fos.close();
    }

    @RequestMapping("/test2")
    public void test2() throws IOException {
        List<StudentVO> list = new ArrayList<>(16);
        StudentVO student;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            student = new StudentVO(i + "",
                    "name" + i,
                    random.nextInt(2),
                    random.nextInt(22),
                    new Date(),
                    "className" + i, "学校名称" + i, "学校地址" + i);
            list.add(student);
        }
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("学生表");
        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, StudentVO.class, list);
        File savefile = new File("C:/Users/Wanghezi/IdeaProjects/WHZ/easyPOI");
        if (!savefile.exists()) {
            boolean result = savefile.mkdirs();
            System.out.println("目录不存在，创建" + result);
        }
        FileOutputStream fos = new FileOutputStream("C:/Users/Wanghezi/IdeaProjects/WHZ/easyPOI/Object导出.xls");
        workbook.write(fos);
        fos.close();
    }
}
