package com.kettle.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Desciption 商户数据
 * Create By  li.bo
 * CreateTime 2018/6/21 10:46
 * UpdateTime 2018/6/21 10:46
 */
@NoArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
@ToString
public class MerchantManagementInfo {

    private String merchantsCode;           // 商户号
    private String merchantName;            // 商户名称
    private BigDecimal contractArea;        // 出租面积
    private BigDecimal averageRentalPrice;  // 每平米每月租金
    private BigDecimal avgPayRent6m;        // 最近6月平均租金
    private String brandName;               // 品牌名称
    private String mallName;                // 商场名称
    private BigDecimal recentSaleAmount;    // 近期销售额
    private BigDecimal recentSaleStatement; // 近期流水
    private int operateMonths;              // 经营月数
    private int totalComplaint12m;          // 近12个月总投诉数
    private int totalComplaint12mHigh;      // 近12个月高级客户投诉数
    private int totalComplaint12mMiddle;    // 近12个月中级客户投诉数
    private int totalComplaint12mLow;       // 近12个月低级客户投诉数

}
