package cn.yuxi.gjwx.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * UserCdEntity: 数据映射实体定义
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
    table = "user_cd",
    schema = "gjwx"
)
public class UserCdEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "user_id",
      auto = false
  )
  private String userId;

  @TableField(
      value = "cs",
      desc = "参数辞典"
  )
  private String cs;

  @TableField(
      value = "gfjc",
      desc = "功法加成"
  )
  private String gfjc;

  @TableField(
      value = "hfjc",
      desc = "伙伴加成"
  )
  private String hfjc;

  @TableField(
      value = "hqgf",
      desc = "获取功法"
  )
  private String hqgf;

  @TableField(
      value = "hqhb",
      desc = "获取伙伴"
  )
  private String hqhb;

  @TableField(
      value = "jmjc",
      desc = "经脉加成"
  )
  private String jmjc;

  @TableField(
      value = "sygf",
      desc = "使用功法"
  )
  private String sygf;

  @TableField(
      value = "wjzb",
      desc = "玩家装备"
  )
  private String wjzb;

  @TableField(
      value = "xfjc",
      desc = "心法加成"
  )
  private String xfjc;

  @TableField(
      value = "zbjc",
      desc = "装备加成"
  )
  private String zbjc;

  @Override
  public final Class entityClass() {
    return UserCdEntity.class;
  }
}
