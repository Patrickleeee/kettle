package com.kettle.controller;

import com.kettle.bean.MerchantManagementInfo;
import com.kettle.mapper.MerchantManagementInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desciption
 * Create By  li.bo
 * CreateTime 2018/6/21 11:14
 * UpdateTime 2018/6/21 11:14
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantManagementInfoMapper merchantManagementInfoMapper;

    @GetMapping("/{merchantsCode}")
    public MerchantManagementInfo getMerchantManagementInfo(@PathVariable("merchantsCode") String merchantsCode) {
        return merchantManagementInfoMapper.selectOne(merchantsCode);
    }
}
