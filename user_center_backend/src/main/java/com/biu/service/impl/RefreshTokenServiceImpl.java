package com.biu.service.impl;

import com.biu.model.entity.RefreshToken;
import com.biu.mapper.RefreshTokenMapper;
import com.biu.service.IRefreshTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户Refresh Token表 服务实现类
 * </p>
 *
 * @author Biu
 * @since 2025-11-11
 */
@Service
public class RefreshTokenServiceImpl extends ServiceImpl<RefreshTokenMapper, RefreshToken> implements IRefreshTokenService {

}
