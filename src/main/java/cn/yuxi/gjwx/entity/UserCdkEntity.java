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
 * UserCdkEntity: 数据映射实体定义
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
    table = "user_cdk",
    schema = "gjwx"
)
public class UserCdkEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "user_id",
      auto = false
  )
  private String userId;

  @TableField("cdk")
  private String cdk;

  @Override
  public final Class entityClass() {
    return UserCdkEntity.class;
  }
}
