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
 * UserMsgEntity: 数据映射实体定义
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
    table = "user_msg",
    schema = "gjwx"
)
public class UserMsgEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId("id")
  private Integer id;

  @TableField("jl1")
  private String jl1;

  @TableField("jl2")
  private String jl2;

  @TableField("jl3")
  private String jl3;

  @TableField("jl4")
  private String jl4;

  @TableField("jl5")
  private String jl5;

  @TableField("user_id")
  private String userId;

  @TableField(
      value = "xxnr",
      desc = "公告内容"
  )
  private String xxnr;

  @Override
  public final Class entityClass() {
    return UserMsgEntity.class;
  }
}
