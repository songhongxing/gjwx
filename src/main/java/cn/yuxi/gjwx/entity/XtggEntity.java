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
 * XtggEntity: 数据映射实体定义
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
    table = "xtgg",
    schema = "gjwx"
)
public class XtggEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId("id")
  private Integer id;

  @TableField(
      value = "cdk",
      desc = "cdk奖励"
  )
  private String cdk;

  @TableField(
      value = "ggnr",
      desc = "公告内容"
  )
  private String ggnr;

  @TableField(
      value = "gqsj",
      desc = "过期时间"
  )
  private Date gqsj;

  @TableField(
      value = "type",
      desc = "1奖励公告，2开屏公告"
  )
  private Integer type;

  @Override
  public final Class entityClass() {
    return XtggEntity.class;
  }
}
