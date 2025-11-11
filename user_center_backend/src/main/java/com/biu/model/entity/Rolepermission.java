
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
* @description:角色权限表数据表：rolepermission表的持久类
* @author Biu
* @date 2025-11-11
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("rolepermission")
@Schema( description = "角色权限表")
public class Rolepermission implements Serializable {

private static final long serialVersionUID = 1L;

    @Schema(description = "角色id")
    @TableId("role_id")
    private Long roleId;

    @Schema(description = "权限id")
    @TableId("permission_id")
    private Long permissionId;

}

