
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
* @description:权限表数据表：permission表的持久类
* @author Biu
* @date 2025-11-11
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("permission")
@Schema( description = "权限表")
public class Permission implements Serializable {

private static final long serialVersionUID = 1L;

    @Schema(description = "权限id")
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Long permissionId;

    @Schema(description = "请求url")
    @TableField("request_url")
    private String requestUrl;

    @Schema(description = "权限名称")
    @TableField("permission_name")
    private String permissionName;

    @Schema(description = "权限描述")
    @TableField("permission_description")
    private String permissionDescription;

}

