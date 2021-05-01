package myblog;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 * @author gcwxf
 * Created on 2021/3/26 - 10:28
 */
public class MyGenerator {
    public static void main(String[] args) {
        // 构建 代码生成器 对象
        AutoGenerator mpg = new AutoGenerator();

        // 配置策略

        // 1.全局配置
        GlobalConfig gc = new GlobalConfig();
        // 输出目录
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("gcwxf");
        // 生成后是否打开资源管理器
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(false);
        // 去掉生成的iService的i前缀
        gc.setServiceName("%sService");
        // 主键生成策略
        gc.setIdType(IdType.AUTO);
        // gc.setDateType(DateType.ONLY_DATE);
        // gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);


        // 2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://8.140.157.40:3306/my_blog?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Lin862370422!");
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);


        // 3.包的配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName("");
        pc.setParent("myblog");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");

        mpg.setPackageInfo(pc);


        // 4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表名和字段名称下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        // *****设置要映射的表名*****
        strategy.setInclude("order_detail");

        // 自动lombok
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        strategy.setLogicDeleteFieldName("is_deleted");
        // 自动填充配置
        // TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        // TableFill updateTime = new TableFill("create_time", FieldFill.UPDATE);
        // ArrayList<TableFill> tableFills = new ArrayList<>();
        // tableFills.add(createTime);
        // tableFills.add(updateTime);
        // strategy.setTableFillList(tableFills);

        // 乐观锁
        // strategy.setVersionFieldName("version");

        // 驼峰转下划线
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);


        // 执行
        mpg.execute();


    }
}
