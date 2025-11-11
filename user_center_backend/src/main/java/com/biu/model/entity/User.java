
package com.biu.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.*;

/**
* @description:用户表数据表：user表的持久类
* @author Biu
* @date 2025-11-11
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Schema( description = "用户表")
public class User implements Serializable {

private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @Schema(description = "账号")
    @TableField("userAccount")
    private String userAccount;

    @Schema(description = "密码")
    @TableField("userPassword")
    private String userPassword;

    @Schema(description = "用户头像")
    @TableField("avatarUrl")
    private String avatarUrl;

    @Schema(description = "性别 0女1男")
    @TableField("gender")
    private Byte gender;

    @Schema(description = "用户昵称")
    @TableField("username")
    private String username;

    @Schema(description = "电话")
    @TableField("phone")
    private String phone;

    @Schema(description = "邮箱")
    @TableField("email")
    private String email;

    @Schema(description = "状态 0 - 正常")
    @TableField("userStatus")
    private Integer userStatus;

    @Schema(description = "创建人用户ID")
    @TableField("create_by")
    private Long createBy;

    @Schema(description = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @Schema(description = "更新人")
    @TableField("update_by")
    private Long updateBy;

    @Schema(description = "是否删除")
    @TableField("isDelete")
    private Byte isDelete;

    @Schema(description = "用户角色类型")
    @TableField("max_user_type")
    private String maxUserType;

    @Schema(description = "用户编号")
    @TableField("userCode")
    private String userCode;

}

