package cn.yuxi.gjwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * .
 *
 * @author songhongxing
 * @date 2023/09/05 4:17 下午
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
@EnableScheduling
public class GjwxApplication {

    public static void main(String[] args) {
        SpringApplication.run(GjwxApplication.class, args);
    }

}
