//package com.example.esdemo.doc;
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
//import java.util.Date;
//
///**
// * @author ：xbm
// * @date ：Created in 2020/12/10 17:52
// * @description：
// */
//@Data
//@NoArgsConstructor
//@Accessors(chain = true)
//@Document(indexName = "trade", type = "_doc", shards = 1, replicas = 0)
//public class TradeDoc {
//    @Id
//    private Long tid;
//
//    @Field(type = FieldType.Long)
//    private Long sellerId;
//
//    @Field(type = FieldType.Long)
//    private Long shopBuyerId;
//
//    @Field(type = FieldType.Text)
//    private String buyerNick;
//
//    @Field(type = FieldType.Double)
//    private Double receivedPayment;
//
//    @Field(type = FieldType.Double)
//    private Double postFee;
//
//    @Field(type = FieldType.Text)
//    private String receiverName;
//
//    @Field(type = FieldType.Text)
//    private String receiverZip;
//
//    @Field(type = FieldType.Keyword)
//    private String receiverMobile;
//
//    @Field(type = FieldType.Short)
//    private Integer receiverMobileType;
//
//    @Field(type = FieldType.Short)
//    private Integer num;
//
//    @Field(type = FieldType.Text)
//    private String buyerMessage;
//
//    @Field(type = FieldType.Short)
//    private Integer sellerFlag;
//
//    @Field(type = FieldType.Text)
//    private String sellerMemo;
//
//    @Field(type = FieldType.Keyword)
//    private String status;
//
//    @Field(type = FieldType.Text)
//    private String tradeFrom;
//
//    @Field(type = FieldType.Text)
//    private String type;
//
//    @Field(type = FieldType.Keyword)
//    private String stepTradeStatus;
//
//    @Field(type = FieldType.Text)
//    private String stepPaidFee;
//
//    @Field(type = FieldType.Keyword)
//    private String buyerAlipayNo;
//
//    @Field(type = FieldType.Double)
//    private Double price;
//
//    @Field(type = FieldType.Double)
//    private Double discountFee;
//
//    @Field(type = FieldType.Double)
//    private Double totalFee;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date created;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date payTime;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date modified;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date consignTime;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date endTime;
//
//    @Field(type = FieldType.Short)
//    private String shippingType;
//
//    @Field(type = FieldType.Keyword)
//    private String shippingSid;
//
//    @Field(type = FieldType.Short)
//    private Integer shippingStatus;
//
//    @Field(type = FieldType.Short)
//    private Integer rxAuditStatus;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date lastSendTime;
//
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date signTime;
//
//
//}
