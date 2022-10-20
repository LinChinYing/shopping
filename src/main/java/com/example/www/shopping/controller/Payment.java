package com.example.www.shopping.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@RestController
public class Payment {
	public AllInOne all;
	
	@PostMapping("/payment")
	public String genAioCheckOutALL(String money){
		all = new AllInOne("");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String v = sdf.format(d);
		String[] a = new String[] {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};
		String cc = a[(int)(Math.random()*10)];
		String dd = a[(int)(Math.random()*5)];
		String ee = a[(int)(Math.random()*3)];
		String bb = a[(int)(Math.random()*16)];
		String qq = a[(int)(Math.random()*9)];
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(bb+"moona"+cc+qq+dd+"peko"+ee);
		obj.setMerchantTradeDate(v);
		obj.setTotalAmount("1100");
		obj.setTradeDesc("新的商品");
		obj.setItemName("購買紀錄");
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		return form;
		// 測試卡號4311-9522-2222-2222 安全碼 : 222
	}
}
