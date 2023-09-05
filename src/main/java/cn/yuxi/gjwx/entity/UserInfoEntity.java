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
 * UserInfoEntity: 数据映射实体定义
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
    table = "user_info",
    schema = "gjwx"
)
public class UserInfoEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "user_id",
      auto = false,
      desc = "主键"
  )
  private String userId;

  @TableField(
      value = "bxdj",
      desc = "宝箱等级"
  )
  private Integer bxdj;

  @TableField(
          value = "wjdh",
          desc = "玩家动画"
  )
  private String wjdh;

  @TableField(
      value = "hbjc",
      desc = "伙伴加成"
  )
  private Integer hbjc;

  @TableField(
      value = "hj",
      desc = "黄金"
  )
  private Integer hj;

  @TableField(
      value = "jhl",
      desc = "江湖令"
  )
  private Integer jhl;

  @TableField(
      value = "jncj",
      desc = "技能残卷"
  )
  private Integer jncj;

  @TableField(
      value = "jz",
      desc = "交子"
  )
  private Integer jz;

  @TableField(
      value = "mj",
      desc = "美酒"
  )
  private Integer mj;

  @TableField(
      value = "name",
      desc = "昵称"
  )
  private String name;

  @TableField(
      value = "rwdj",
      desc = "任务等级"
  )
  private Integer rwdj;

  @TableField(
      value = "szhbzb",
      desc = "上阵伙伴坐标"
  )
  private Integer szhbzb;

  @TableField(
      value = "tq",
      desc = "铜钱"
  )
  private Long tq;

  @TableField(
      value = "tsgyj",
      desc = "太上感应经"
  )
  private Integer tsgyj;

  @TableField(
      value = "txz",
      desc = "头像帧"
  )
  private Integer txz;

  @TableField(
      value = "wjdj",
      desc = "玩家等级"
  )
  private Integer wjdj;

  @TableField(
      value = "wjjy",
      desc = "玩家经验"
  )
  private Long wjjy;

  @TableField(
      value = "wjxf",
      desc = "玩家心法"
  )
  private String wjxf;

  @TableField(
      value = "wxg",
      desc = "悟性果"
  )
  private Integer wxg;

  @TableField(
      value = "xfdj",
      desc = "心法等级"
  )
  private Integer xfdj;

  @TableField(
      value = "xsd",
      desc = "洗髓丹"
  )
  private Integer xsd;

  @TableField(
      value = "xw",
      desc = "修为"
  )
  private Long xw;

  @TableField(
      value = "ys",
      desc = "钥匙"
  )
  private Integer ys;

  @TableField(
      value = "zdl",
      desc = "战斗力"
  )
  private Long zdl;

  @TableField(
      value = "zxgq",
      desc = "主线关卡"
  )
  private Integer zxgq;

  @Override
  public final Class entityClass() {
    return UserInfoEntity.class;
  }
}
