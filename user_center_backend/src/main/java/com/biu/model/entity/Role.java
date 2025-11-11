
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
* @description:角色表数据表：role表的持久类
* @author Biu
* @date 2025-11-11
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
@Schema( description = "角色表")
public class Role implements Serializable {

private static final long serialVersionUID = 1L;

    @Schema(description = "角色id")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @Schema(description = "角色名称")
    @TableField("role_name")
    private String roleName;

    @Schema(description = "角色描述")
    @TableField("role_description")
    private String roleDescription;

}

