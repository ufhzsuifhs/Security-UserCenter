package com.biu.service.impl;

import com.biu.model.entity.Permission;
import com.biu.mapper.PermissionMapper;
import com.biu.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Biu
 * @since 2025-11-11
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
