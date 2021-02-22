package com.vy.yzc.third;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.vy.basic.elasticsearch.BaseVyElasticsearchVO;
import com.vy.basic.tool.common.Unthrow;
import com.vy.yzc.third.domain.service.TestEsService;
import com.vy.yzc.third.infrastructure.Teacher;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: vikko
 * @Date: 2021/2/2 11:59
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTestApplication extends BaseVyElasticsearchVO {

	@Autowired
	TestEsService testEsService;

	@Test
	public void testEs(){
		testEsService.test(Teacher.class);
	}


	@Test
	public void testMeiTuan(){
		String url = getUrl();
		System.out.println(url);
		HttpResponse<String> response = Unthrow.wrap(() -> Unirest.get(url).asString());
		System.out.println(response.getBody().toString());
	}

	public static String getUrl(){
		TreeMap<String, String> map = new TreeMap();
		map.put("appkey", "321ab50d46a65a627899c25d4903ba02"); //申请的 appkey
//		map.put("pos", "31.21524,121.420033");
		map.put("city", "上海");
		map.put("offset", "0");
		map.put("ts",String.valueOf(System.currentTimeMillis()/1000));
		map.put("limit", "10");
//		map.put("cate", "");
//		map.put("district", "");
//		map.put("dist", "");
//		map.put("orderby", "");
		map.put("query", "泰国菜");
		StringBuilder s = new StringBuilder();
		for(Entry<String, String> entry : map.entrySet()) {
			s.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		String params = s.toString();
		s.append("0624ba0d82084b88faf8bf5b3ac25f39"); //分配的 secret
		String encrypt = DigestUtils.sha256Hex(s.toString().getBytes()).toLowerCase();
		return  "http://openapi.meituan.com/poi/search?" + params + "sign=" + encrypt;
	}
}
