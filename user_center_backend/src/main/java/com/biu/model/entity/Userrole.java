
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
* @description:用户角色表数据表：userrole表的持久类
* @author Biu
* @date 2025-11-11
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("userrole")
@Schema( description = "用户角色表")
public class Userrole implements Serializable {

private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    @TableId("user_id")
    private Long userId;

    @Schema(description = "角色id")
    @TableId("role_id")
    private Long roleId;

}

