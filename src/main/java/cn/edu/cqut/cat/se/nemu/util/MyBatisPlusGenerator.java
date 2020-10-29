package cn.edu.cqut.cat.se.nemu.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Properties;

/**
 * 代码生成器演示
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) throws Exception {
        String packageName = "cn.edu.cqut.cat.se.nemu";
        AutoGenerator mpg = new AutoGenerator();
        Properties properties = ConfigUtil.getProperties(ConfigUtil.CONFIG_DEFAULT);
        if (properties == null) {
            throw new Exception("Please add a file named config.properties to src/main/resources");
        }
        String projectDir = properties.getProperty(ConfigUtil.PROJECT_DIR);
        if (projectDir == null || projectDir.isEmpty()) {
            throw new Exception("Configure your project directory in config.properties");
        }
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("CQUT CAT SE 2020");
        // 对应项目的 src/main/java 目录在磁盘上的真实路径（在 config.properties 文件里配置）
        gc.setOutputDir(projectDir + "/src/main/java");
        gc.setFileOverride(false); // 是否覆盖同名文件，默认是 false
        gc.setActiveRecord(true); // 不需要 ActiveRecord 特性的请改为 false
        gc.setEnableCache(false); // XML 二级缓存
        gc.setBaseResultMap(true); // XML ResultMap
        gc.setBaseColumnList(false); // XML columnList
        mpg.setGlobalConfig(gc);

        Properties appProperties = ConfigUtil.getProperties("application.properties");
        if (appProperties == null) return;
        String driverName = appProperties.getProperty("spring.datasource.driver-class-name");
        if (driverName == null || driverName.isEmpty()) return;
        String url = appProperties.getProperty("spring.datasource.url");
        if (url == null || url.isEmpty()) return;
        String userName = appProperties.getProperty("spring.datasource.username");
        if (userName == null || userName.isEmpty()) return;
        String pwd = appProperties.getProperty("spring.datasource.password");
        if (pwd == null) return;
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName); // 数据库用户名（在 application.properties 文件里配置）
        dsc.setPassword(pwd); // 数据库密码（在 application.properties 文件里配置）
        dsc.setUrl(url);
        mpg.setDataSource(dsc);
        String tables = properties.getProperty(ConfigUtil.DATASOURCE_UTIL_TABLES);
        if (tables == null || tables.isEmpty()) {
            throw new Exception("Configure tables to generate in config.properties");
        }
        String[] tableNames = tables.split(",");
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tableNames); // 需要生成的表（在 config.properties 文件里配置）
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName); // 项目的根包（启动类所在的包）
        pc.setController("controller"); // Controller 类所在的包
        pc.setService("service"); // Service 接口所在的包
        pc.setServiceImpl("service.impl"); // Service 实现类所在的包
        pc.setMapper("mapper"); // Mapper 接口所在的包
        pc.setEntity("entity"); // 实体类所在的包
        pc.setXml("mapper.xml"); // mapper 映射文件所在的包
        mpg.setPackageInfo(pc);
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null); // 不生成 xml 映射文件
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
}
