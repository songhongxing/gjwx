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
 * CdkEntity: 数据映射实体定义
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
    table = "cdk",
    schema = "gjwx"
)
public class CdkEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "cdk",
      auto = false,
      desc = "cdk"
  )
  private String cdk;

  @TableField(
      value = "gqsj",
      desc = "过期时间"
  )
  private Date gqsj;

  @TableField(
      value = "jl1",
      desc = "奖励1"
  )
  private String jl1;

  @TableField(
      value = "jl2",
      desc = "奖励2"
  )
  private String jl2;

  @TableField(
      value = "jl3",
      desc = "奖励3"
  )
  private String jl3;

  @TableField(
      value = "jl4",
      desc = "奖励4"
  )
  private String jl4;

  @TableField(
      value = "jl5",
      desc = "奖励5"
  )
  private String jl5;

  @Override
  public final Class entityClass() {
    return CdkEntity.class;
  }
}
