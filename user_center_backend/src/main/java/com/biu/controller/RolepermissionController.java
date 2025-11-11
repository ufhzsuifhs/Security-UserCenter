package com.biu.controller;

import java.util.List;

import com.biu.common.BaseResponse;
import com.biu.common.ResultUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.biu.model.entity.Rolepermission;
import com.biu.service.IRolepermissionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:角色权限表控制器
 * @author Biu
 * @date 2025-11-11
 */
@RestController
@Tag(name = "角色权限表")
@RequestMapping("/rolepermission")
public class RolepermissionController {
    @Autowired
    private IRolepermissionService rolepermissionService;


}
