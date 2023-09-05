package cn.yuxi.gjwx;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;

/**
 * 根据数据库表生成entity、dao、mapper
 * @author songhongxing
 * @date 2022/05/24 5:20 下午
 */
public class EnityGenerator {

    public static final String url = "jdbc:mysql://101.43.157.72:3306/gjwx?useUnicode=true&characterEncoding=utf8";

    public static void main(String[] args) throws Exception {
        FileGenerator.build(Empty.class);
    }

    @Tables(
            // 设置数据库连接信息
            url = url, username = "root", password = "Xing@520025!",
            // 设置entity类生成src目录, 相对于 user.dir
            srcDir = "src/main/java/",
            // 设置entity类的package值
            basePack = "cn.yuxi.gjwx",
            // 设置dao接口和实现的src目录, 相对于 user.dir
            daoDir = "src/main/java/",
            /** 如果表定义记录创建，记录修改，逻辑删除字段 **/
//            gmtCreated = "gmt_create", gmtModified = "gmt_modified", logicDeleted = "is_deleted",
            // 设置哪些表要生成Entity文件
            tables = {@Table(value = {"user","user_info"})
                    //设置继承的实体类
                    //entity = IEntity.class
                    }
    )
    static class Empty {
    }
}
