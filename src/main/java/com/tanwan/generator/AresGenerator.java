package com.tanwan.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class AresGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        {
            GlobalConfig gc = new GlobalConfig();
            gc.setOutputDir("D:\\test");
            gc.setFileOverride(true);
            gc.setActiveRecord(true);
            // XML 二级缓存
            gc.setEnableCache(false);
            // XML ResultMap
            gc.setBaseResultMap(false);
            // XML columList
            gc.setBaseColumnList(false);
            // 实体属性 Swagger2 注解
            gc.setSwagger2(true);
            gc.setAuthor("ares");

            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            gc.setMapperName("%sMapper");
            gc.setXmlName("%sMapper");
            gc.setServiceName("%sService");
            gc.setServiceImplName("%sServiceImpl");
            gc.setControllerName("%sController");
            mpg.setGlobalConfig(gc);
        }

        // 数据源配置
        {
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("admin");
            dsc.setUrl("jdbc:mysql://localhost:3306/tanwan-dsp?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
            mpg.setDataSource(dsc);
        }

        // 包配置
        {
            PackageConfig pc = new PackageConfig();
            pc.setParent("com.tanwan");
            pc.setModuleName(null);
            mpg.setPackageInfo(pc);
        }

        // 策略配置
        {
            StrategyConfig strategy = new StrategyConfig();
            // 字段名生成策略
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
//        strategy.setNaming(NamingStrategy.remove_prefix_and_camel);// 表名生成策略
//        strategy.setNaming(NamingStrategy.removePrefixAndCamel());// 表名生成策略
            strategy.setEntityLombokModel(true);

            // 需要生成的表
            strategy.setInclude(new String[]{"sys_user"});
//        strategy.setExclude(new String[]{"test_user"}); // 排除生成的表

            // 自定义实体父类
            strategy.setSuperEntityClass("com.tanwan.entity.BaseEntity");
            // 自定义实体，公共字段
            strategy.setSuperEntityColumns(new String[]{"id,created,modified"});

            // 自定义 controller 父类
            strategy.setRestControllerStyle(true);
            strategy.setSuperControllerClass("com.tanwan.controller.BaseController");
            // 自定义 service 父类
            strategy.setSuperServiceClass("com.tanwan.service.BaseService");
            // 自定义 service 实现类父类
            strategy.setSuperServiceImplClass("com.tanwan.service.impl.BaseServiceImpl");
            // 自定义 mapper 父类
            // strategy.setSuperMapperClass("com.fcs.demo.TestMapper");

            // 【实体】是否生成字段常量（默认 false）
            // public static final String ID = "test_id";
//         strategy.setEntityColumnConstant(true);
            // 【实体】是否为构建者模型（默认 false）
            // public User setName(String name) {this.name = name; return this;}
            // strategy.setEntityBuliderModel(true);
            mpg.setStrategy(strategy);
        }

        // 执行生成
        mpg.execute();
    }
}