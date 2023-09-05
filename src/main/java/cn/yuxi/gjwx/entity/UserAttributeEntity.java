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
 * UserAttributeEntity: 数据映射实体定义
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
    table = "user_attribute",
    schema = "gjwx"
)
public class UserAttributeEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "wjid",
      auto = false,
      desc = "玩家id"
  )
  private String wjid;

  @TableField(
      value = "baoji",
      desc = "暴击"
  )
  private Double baoji;

  @TableField(
      value = "fangyu",
      desc = "防御"
  )
  private Integer fangyu;

  @TableField(
      value = "fanji",
      desc = "反击"
  )
  private Double fanji;

  @TableField(
      value = "gongji",
      desc = "攻击"
  )
  private Integer gongji;

  @TableField(
      value = "jiyun",
      desc = "击晕"
  )
  private Double jiyun;

  @TableField(
      value = "kbaoji",
      desc = "抗暴击"
  )
  private Double kbaoji;

  @TableField(
      value = "kfanji",
      desc = "抗反击"
  )
  private Double kfanji;

  @TableField(
      value = "kjiyun",
      desc = "抗击晕"
  )
  private Double kjiyun;

  @TableField(
      value = "klianji",
      desc = "抗连击"
  )
  private Double klianji;

  @TableField(
      value = "kshanbi",
      desc = "抗闪避"
  )
  private Double kshanbi;

  @TableField(
      value = "kxixue",
      desc = "抗吸血"
  )
  private Double kxixue;

  @TableField(
      value = "lianji",
      desc = "连击"
  )
  private Double lianji;

  @TableField(
      value = "shanbi",
      desc = "闪避"
  )
  private Double shanbi;

  @TableField(
      value = "shengming",
      desc = "生命"
  )
  private Integer shengming;

  @TableField(
      value = "sudu",
      desc = "速度"
  )
  private Integer sudu;

  @TableField(
      value = "xixue",
      desc = "吸血"
  )
  private Double xixue;

  @Override
  public final Class entityClass() {
    return UserAttributeEntity.class;
  }
}
