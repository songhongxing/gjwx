package cn.yuxi.gjwx.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.yuxi.gjwx.Ref;
import cn.yuxi.gjwx.dao.intf.*;
import cn.yuxi.gjwx.entity.*;
import cn.yuxi.gjwx.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Userservice {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private XtggDao xtggDao;
    @Autowired
    private UserMsgDao userMsgDao;
    @Autowired
    private CdkDao cdkDao;

    public void zhuce(Integer fwqId) {
        //添加账号信息
        String userId = UUIDUtil.uuid();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setZcsj(new Date());
        userEntity.setDlrq(Integer.valueOf(DateUtil.format(new Date(), "yyyyMMdd")));
        userEntity.setDlsj(new Date());
        userEntity.setFwqId(fwqId);
        userDao.save(userEntity);
        //添加用户信息
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(userId);
        userInfoEntity.setName("玩家" + userId.substring(0, 5));
        userInfoDao.save(userInfoEntity);
        //查询未过期公告，并给用户发邮件
        List<XtggEntity> wgqggList = xtggDao.wgqgg();
        UserMsgEntity userMsgEntity;
        CdkEntity cdkEntity;
        List<UserMsgEntity> userMsgList = new ArrayList<>();
        if(CollUtil.isNotEmpty(wgqggList)){
            for(XtggEntity xtgg : wgqggList){
                userMsgEntity = new UserMsgEntity();
                userMsgEntity.setUserId(userId);
                userMsgEntity.setXxnr(xtgg.getGgnr());
                cdkEntity = cdkDao.selectById(xtgg.getCdk());
                userMsgEntity.setJl1(cdkEntity.getJl1());
                userMsgEntity.setJl2(cdkEntity.getJl2());
                userMsgEntity.setJl3(cdkEntity.getJl3());
                userMsgEntity.setJl4(cdkEntity.getJl4());
                userMsgEntity.setJl5(cdkEntity.getJl5());
                userMsgList.add(userMsgEntity);
            }
            userMsgDao.save(userMsgList);
        }
    }

    /**
     * 登陆用户
     * @param userId
     * @return
     */
    public UserEntity denglu(String userId){
        UserEntity userEntity = userDao.selectById(userId);
        userDao.updateDlrq(userId);
        return userEntity;
    }

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public UserEntity cxyhxx(String userId){
        UserEntity userEntity = userDao.selectById(userId);
        return userEntity;
    }

}
