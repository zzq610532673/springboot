package com.zzq.zzqproject.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;

public class CodeGenerater {
    public static void main(String[] args) {
        AutoGenerator ag = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setAuthor("张志奇");
        gc.setOutputDir(projectPath + "/src/main/java/");
        gc.setFileOverride(false);
        gc.setServiceName("%service");
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        ag.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/zzq?serverTimezone=UTC");
        dsc.setUsername("root");
        dsc.setPassword("root");
        ag.setDataSource(dsc);
        //包的设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zzq.zzqproject");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setController("controller");
        ag.setPackageInfo(pc);
        //策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("user","computer","pinpai");//需要生成几张表的代码就把表名写入
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setLogicDeleteFieldName("deleted");
        ag.setStrategy(sc);
            //自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModify = new TableFill("gmt_modify", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModify);
        sc.setTableFillList(tableFills);
        sc.setVersionFieldName("version");
        ag.setStrategy(sc);

        ag.setTemplateEngine(new FreemarkerTemplateEngine());

        ag.execute();

    }
}
