package com.vy.yzc.third;

import com.vy.basic.elasticsearch.BaseVyElasticsearchVO;
import com.vy.yzc.third.domain.service.TestEsService;
import com.vy.yzc.third.infrastructure.Teacher;
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
}
