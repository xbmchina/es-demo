package com.example.esdemo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@TableName("shop_buyer_000009")
public class ShopBuyer implements Serializable {

    private Long shopBuyerId;
    private Long sellerId;
    private String buyerNick;
    private String receiverName;
    private String receiverAddress;
    private String receiverZip;
    private String receiverMobile;
    private Integer receiverMobileType;
    private Integer buyEverydayCount;
    private Integer buyTotalCount;
    private Double buyTotalMoney;
    private Integer paymentNum;
    private Integer avgNum;
    private Integer closeNum;
    private Double closeMoney;
    private Double guestPrice;
    private Integer refundNum;
    private Double refundMoney;
    private String weChat;
    private String qq;
    private String email;
    private String buyerAlipayNo;
    private Integer grade;
    private Integer sex;
    private String bornYear;
    private String birthday;
    private Integer constellation;
    private Date buyerLastTime;
    private Date buyerFristTime;
    private Date buyerFristPayTime;
    private Date buyerLastPayTime;
    private Date buyerFristSucceedTime;
    private Date buyerLastSucceedTime;
    private Integer smsMarketingCount;
    private Date lastSendTime;
    private Integer afterPeriod;
    private Integer crowdPortraitType;
    private Integer jhsSensitivity;
    private Integer stepSensitivity;
    private Integer isNeutralBadRate;
    private Integer isBlacklist;
    private String buyerLabelId;
    private Integer pointBalance;
    private Date registerDate;
    private Date lastPointUpdateTime;
    private Integer pointsSignInCount;
    private Integer pointsJoinBigWheelCount;
    private Integer pointsExchangePointsCount;
    private Integer pointsExchangeCount;
    private Integer pointsCostPoints;
    private Integer pointsIsFillInformation;
    private Date wxSubscribeTime;
    private Integer wxSex;

}
