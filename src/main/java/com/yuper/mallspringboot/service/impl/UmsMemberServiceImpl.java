package com.yuper.mallspringboot.service.impl;

import com.yuper.mallspringboot.common.CommonResult;
import com.yuper.mallspringboot.service.RedisService;
import com.yuper.mallspringboot.service.UmsMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理 Service 实现类
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDE;

    /**
     * 生成验证码
     *
     * @param telephone
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        // 验证码绑定手机号并存储到ｒｅｄｉｓ
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone, AUTH_CODE_EXPIRE_SECONDE);
        LOGGER.debug("本次验证码为：{}",sb.toString());
        return CommonResult.success(sb.toString(), "获取验证码成功");

    }

    /**
     * 判断验证码和手机号是否匹配
     *
     * @param telephone
     * @param authCode
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCOde = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        boolean result = authCode.equals(realAuthCOde);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        }else {
            return CommonResult.failed("验证码不正确");
        }

    }
}
