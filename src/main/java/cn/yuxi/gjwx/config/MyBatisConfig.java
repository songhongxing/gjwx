package cn.yuxi.gjwx.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

//import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by xiaohong on 2017/11/20.
 * springboot集成mybatis的基本入口
 * 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory
 * 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration // 该注解类似于spring配置文件
@MapperScan(basePackages = {"cn.yuxi.gjwx.mapper"})
public class MyBatisConfig {

    @Bean(name = "gjwx")
    @Primary
    @ConfigurationProperties("spring.datasource.druid.gjwx")
    public DataSource gameDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }

    @Bean
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    @Bean
    public WallConfig wallConfig() {
        WallConfig wallConfig = new WallConfig();
        // 允许一次执行多条语句
        wallConfig.setMultiStatementAllow(true);
        return wallConfig;
    }


    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(gameDataSource());// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLazyLoadingEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        fb.setConfiguration(configuration);
        return fb;
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(gameDataSource());
    }

    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}
