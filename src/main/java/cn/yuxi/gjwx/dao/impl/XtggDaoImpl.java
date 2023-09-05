package cn.yuxi.gjwx.dao.impl;

import cn.yuxi.gjwx.dao.base.XtggBaseDao;
import cn.yuxi.gjwx.dao.intf.XtggDao;
import cn.yuxi.gjwx.entity.XtggEntity;
import cn.yuxi.gjwx.wrapper.XtggQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * XtggDaoImpl: 数据操作接口实现
 * <p>
 * 这只是一个减少手工创建的模板文件
 * 可以任意添加方法和实现, 更改作者和重定义类名
 * <p/>@author Powered By Fluent Mybatis
 */
@Repository
public class XtggDaoImpl extends XtggBaseDao implements XtggDao {
    @Override
    public List<XtggEntity> wgqgg() {
        return new XtggQuery("").where.gqsj().gt(new Date()).end().of(super.mapper).listEntity();
    }

}
