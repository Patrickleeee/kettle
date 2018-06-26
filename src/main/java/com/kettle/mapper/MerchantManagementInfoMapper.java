package com.kettle.mapper;

import com.kettle.bean.MerchantManagementInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Desciption 商户经营信息dao
 * Create By  li.bo
 * CreateTime 2018/6/21 11:03
 * UpdateTime 2018/6/21 11:03
 */
@Mapper
public interface MerchantManagementInfoMapper {

    MerchantManagementInfo selectOne(@Param("merchantsCode") String merchantsCode);
}
