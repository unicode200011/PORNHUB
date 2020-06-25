package com.common;

import com.ndktools.javamd5.Mademd5;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        Mademd5 md = new Mademd5(); //md5加密
        String pay_memberid = "200697206";
        String pay_orderid = "test11111";
        String pay_applydate = df.format(new Date());
        String pay_bankcode = "903";
        String pay_notifyurl = "http://p.sfpay.vip/payController/pay.do";
        String pay_callbackurl = "http://p.sfpay.vip/index.html";
        String pay_amount = "10";
        String pay_productname = "xishi_test_pay";
        String key = "gokc6fruzluful7w22ze1fewemh36yg9";

        StringBuffer a = new StringBuffer();
        a.append("pay_amount=");
        a.append(pay_amount);
        a.append("&");
        a.append("pay_applydate=");
        a.append(pay_applydate);
        a.append("&");
        a.append("pay_bankcode=");
        a.append(pay_bankcode);
        a.append("&");
        a.append("pay_callbackurl=");
        a.append(pay_callbackurl);
        a.append("&");
        a.append("pay_memberid=");
        a.append(pay_memberid);
        a.append("&");
        a.append("pay_notifyurl=");
        a.append(pay_notifyurl);
        a.append("&");
        a.append("pay_orderid=");
        a.append(pay_orderid);
        a.append("&");
        a.append("key=");
        a.append(key);

        System.out.println(a);

        String sign = md.toMd5(String.valueOf(a)).toUpperCase();
        String pay_md5sign = sign;

        StringBuffer b = new StringBuffer();
        b.append("pay_amount=");
        b.append(pay_amount);
        b.append("&");
        b.append("pay_applydate=");
        b.append(pay_applydate);
        b.append("&");
        b.append("pay_bankcode=");
        b.append(pay_bankcode);
        b.append("&");
        b.append("pay_callbackurl=");
        b.append(pay_callbackurl);
        b.append("&");
        b.append("pay_memberid=");
        b.append(pay_memberid);
        b.append("&");
        b.append("pay_notifyurl=");
        b.append(pay_notifyurl);
        b.append("&");
        b.append("pay_orderid=");
        b.append(pay_orderid);
        b.append("&");
        b.append("pay_md5sign=");
        b.append(pay_md5sign);
        b.append("&");
        b.append("pay_productname=");
        b.append(pay_productname);
        System.out.println(b);
    }
}
