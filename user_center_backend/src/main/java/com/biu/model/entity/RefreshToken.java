
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
* @description:用户Refresh Token表数据表：refresh_token表的持久类
* @author Biu
* @date 2025-11-11
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("refresh_token")
@Schema( description = "用户Refresh Token表")
public class RefreshToken implements Serializable {

private static final long serialVersionUID = 1L;

    @TableId(value = "token_id", type = IdType.AUTO)
    private Long tokenId;

    @TableField("user_id")
    private Long userId;

    @TableField("token")
    private String token;

    @TableField("ip_address")
    private String ipAddress;

    @TableField("device_info")
    private String deviceInfo;

    @TableField("expires_at")
    private LocalDateTime expiresAt;

    @TableField("created_at")
    private LocalDateTime createdAt;

    @Schema(description = "被踢原因")
    @TableField("kicked_reason")
    private String kickedReason;

    @Schema(description = "状态：1=有效，0=无效（被挤/过期）")
    @TableField("status")
    private Byte status;

    @Schema(description = "逻辑删除：1=已删除，0=未删除")
    @TableField("is_deleted")
    private Byte isDeleted;

}

