package com.vy.yzc.third.domain.service;

import com.vy.basic.elasticsearch.BaseVyElasticsearchVO;

/**
 * @author: vikko
 * @Date: 2021/2/2 11:57
 * @Description:
 */
public interface TestEsService {


	<T extends BaseVyElasticsearchVO> void test(Class<T> clazz);
}
