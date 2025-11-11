package com.biu.service.impl;

import com.biu.model.entity.OauthUser;
import com.biu.mapper.OauthUserMapper;
import com.biu.service.IOauthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 三方登录记录表 服务实现类
 * </p>
 *
 * @author Biu
 * @since 2025-11-11
 */
@Service
public class OauthUserServiceImpl extends ServiceImpl<OauthUserMapper, OauthUser> implements IOauthUserService {

}
