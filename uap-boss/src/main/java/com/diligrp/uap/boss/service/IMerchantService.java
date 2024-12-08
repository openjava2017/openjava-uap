package com.diligrp.uap.boss.service;

import com.diligrp.uap.boss.domain.MerchantDTO;
import com.diligrp.uap.boss.domain.MerchantVO;
import com.diligrp.uap.boss.domain.MerchantQuery;
import com.diligrp.uap.boss.model.MerchantDO;
import com.diligrp.uap.shared.domain.PageMessage;

public interface IMerchantService {
    /**
     * 创建商户
     */
    void createMerchant(MerchantDTO merchant);

    /**
     * 根据ID查找商户
     */
    MerchantDO findMerchantById(Long id);

    /**
     * 分页查询系统商户
     */
    PageMessage<MerchantVO> listMerchants(MerchantQuery query);

    /**
     * 修改商户信息
     */
    void updateMerchant(MerchantDTO request);

    /**
     * 删除指定商户
     */
    void deleteMerchant(Long mchId);
}
