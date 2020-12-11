//package com.example.esdemo.doc;
//
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.io.Serializable;
//import java.util.Date;
//
//
//@Data
//@NoArgsConstructor
//@Accessors(chain = true)
//@Document(indexName = "ShopBuyer", type = "_doc", shards = 1, replicas = 0)
//public class ShopBuyerDoc implements Serializable {
//
//    @Id
//    private Long shopBuyerId;
//    @Field(type = FieldType.Long)
//    private Long sellerId;
//    @Field(type = FieldType.Keyword)
//    private String buyerNick;
//    @Field(type = FieldType.Keyword)
//    private String receiverName;
//    @Field(type = FieldType.Keyword)
//    private String receiverZip;
//    @Field(type = FieldType.Keyword)
//    private String receiverMobile;
//    @Field(type = FieldType.Short)
//    private Integer receiverMobileType;
//    @Field(type = FieldType.Integer)
//    private Integer buyEverydayCount;
//    @Field(type = FieldType.Integer)
//    private Integer buyTotalCount;
//    @Field(type = FieldType.Double)
//    private Double buyTotalMoney;
//    @Field(type = FieldType.Integer)
//    private Integer paymentNum;
//    @Field(type = FieldType.Integer)
//    private Integer avgNum;
//    @Field(type = FieldType.Integer)
//    private Integer closeNum;
//    @Field(type = FieldType.Double)
//    private Double closeMoney;
//    @Field(type = FieldType.Double)
//    private Double guestPrice;
//    @Field(type = FieldType.Integer)
//    private Integer refundNum;
//    @Field(type = FieldType.Double)
//    private Double refundMoney;
//    @Field(type = FieldType.Keyword)
//    private String buyerAlipayNo;
//    @Field(type = FieldType.Integer)
//    private Integer grade;
//    @Field(type = FieldType.Integer)
//    private Integer sex;
//    @Field(type = FieldType.Keyword)
//    private String bornYear;
//    @Field(type = FieldType.Keyword)
//    private String birthday;
//    @Field(type = FieldType.Integer)
//    private Integer constellation;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date buyerLastTime;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date buyerFristTime;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date buyerFristPayTime;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date buyerLastPayTime;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date buyerFristSucceedTime;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date buyerLastSucceedTime;
//    @Field(type = FieldType.Integer)
//    private Integer smsMarketingCount;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date lastSendTime;
//    @Field(type = FieldType.Integer)
//    private Integer afterPeriod;
//    @Field(type = FieldType.Short)
//    private Integer crowdPortraitType;
//    @Field(type = FieldType.Short)
//    private Integer jhsSensitivity;
//    @Field(type = FieldType.Short)
//    private Integer stepSensitivity;
//    @Field(type = FieldType.Short)
//    private Integer isNeutralBadRate;
//    @Field(type = FieldType.Short)
//    private Integer isBlacklist;
//    @Field(type = FieldType.Text)
//    private String buyerLabelId;
//}
