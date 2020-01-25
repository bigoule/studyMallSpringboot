package com.yuper.mallspringboot.service;

import com.yuper.mallspringboot.common.CommonResult;

/**
 * 会员管理 Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
