package com.org.backstage.web;

import com.ndktools.javamd5.Mademd5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/payController")
public class PayController {
    @RequestMapping(value = "/payReturn.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> payReturn(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resp = new HashMap<String, Object>();
        System.out.println("支付平台回调接口");
        return resp;
    }

    @RequestMapping(value = "/pay.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resp = new HashMap<String, Object>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        Mademd5 md = new Mademd5(); //md5加密
        String pay_memberid = "200697206";
        String pay_orderid = "test11111";
        String pay_applydate = df.format(new Date());
        String pay_bankcode = "903";
        String pay_notifyurl = "";
        String pay_callbackurl = "";
        String pay_amount = "10";
        String pay_productname = "xishi_test_pay";

        String stringSignTemp = "pay_amount=pay_amount&pay_applydate=pay_applydate&pay_bankcode=pay_bankcode&pay_callbackurl=pay_callbackurl&" +
                "pay_memberid=pay_memberid&pay_notifyurl=pay_notifyurl&pay_orderid=pay_orderid&key=key"; //签名算法

        StringBuffer a= new StringBuffer();
        a.append("pay_amount=");
        a.append(pay_amount);
        a.append("&");


        String sign = md.toMd5(stringSignTemp).toUpperCase();
        String pay_md5sign = sign;


        return resp;
    }
}
