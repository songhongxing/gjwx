package cn.yuxi.gjwx.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * UserEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@AllArgsConstructor
@NoArgsConstructor
@FluentMybatis(
    table = "user",
    schema = "gjwx"
)
public class UserEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "id",
      auto = false,
      desc = "玩家id"
  )
  private String id;

  @TableField(
      value = "all_jf",
      desc = "全服积分"
  )
  private Integer allJf;

  @TableField(
      value = "dlrq",
      desc = "登陆日期"
  )
  private Integer dlrq;

  @TableField(
      value = "dlsj",
      desc = "登陆时间"
  )
  private Date dlsj;

  @TableField(
      value = "fwq_id",
      desc = "服务器id"
  )
  private Integer fwqId;

  @TableField(
      value = "single_jf",
      desc = "服务器积分"
  )
  private Integer singleJf;


  @TableField(
      value = "zcsj",
      desc = "注册时间"
  )
  private Date zcsj;

  @TableField(
          value = "czrq",
          desc = "重置日期"
  )
  private Integer czrq;

  @Override
  public final Class entityClass() {
    return UserEntity.class;
  }
}
