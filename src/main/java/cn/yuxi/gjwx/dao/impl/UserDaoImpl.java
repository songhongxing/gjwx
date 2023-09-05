package cn.yuxi.gjwx.dao.impl;

import cn.hutool.core.date.DateUtil;
import cn.yuxi.gjwx.dao.base.UserBaseDao;
import cn.yuxi.gjwx.dao.intf.UserDao;
import cn.yuxi.gjwx.wrapper.UserUpdate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * UserDaoImpl: 数据操作接口实现
 *
 * 这只是一个减少手工创建的模板文件
 * 可以任意添加方法和实现, 更改作者和重定义类名
 * <p/>@author Powered By Fluent Mybatis
 */
@Repository
public class UserDaoImpl extends UserBaseDao implements UserDao {
    @Override
    public void updateDlrq(String userId) {
        UserUpdate userUpdate = new UserUpdate().set.dlrq().is(Integer.valueOf(DateUtil.format(new Date(), "yyyyMMdd"))).dlsj().is(new Date()).czrq().is(0).end().where.id().eq(userId).end();
        super.mapper.updateBy(userUpdate);
    }
}
