package com.vy.yzc.third.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.vy.basic.elasticsearch.BaseVyElasticsearchVO;
import com.vy.basic.elasticsearch.utils.ElasticsearchUtil;
import com.vy.yzc.third.infrastructure.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

/**
 * @author: vikko
 * @Date: 2021/2/2 11:57
 * @Description:
 */
@Service
@AllArgsConstructor
public class TestEsServiceImpl implements TestEsService {

	private ElasticsearchUtil elasticsearchUtil;

	@Override
	public <T extends BaseVyElasticsearchVO> void test(Class<T> clazz) {

		List<T> result = (List<T>) elasticsearchUtil.queryListWithScore(getSearchQuery(clazz), clazz);
		result.forEach(System.out::println);
		System.out.println("==========finish======");
	}

	public <T> SearchQuery getSearchQuery(Class<T> clazz) {
		double lat = 31.231706;
		double lon = 121.472644;

		QueryBuilder geoDisBuild =
				new GeoDistanceQueryBuilder("location")
						.distance("100", DistanceUnit.KILOMETERS)
						.point(new GeoPoint(lat, lon));

		Document annotation = clazz.getAnnotation(Document.class);

		GeoDistanceSortBuilder disSortBuilder = new GeoDistanceSortBuilder("location", lat, lon);
		disSortBuilder.order(SortOrder.ASC);
		disSortBuilder.unit(DistanceUnit.METERS);

		return new NativeSearchQueryBuilder()
				.withQuery(geoDisBuild)
//				.withQuery(QueryBuilders.matchQuery("name", "老师"))  //分词
//				.withQuery(QueryBuilders.matchPhraseQuery("name", "test")) //精确匹配
				.withSort(disSortBuilder)
				.withPageable(PageRequest.of(0, 10))
				.withIndices(annotation.indexName())
				.withTypes(annotation.type())
				.build();
	}


	public static void main(String[] args) {
		HashMap<Object, Object> resultMap = Maps.newHashMap();
		resultMap.put("name", "test");
//		String s = "{score=151279.49227092208, address=address, distance=null, sex=1, name=社会主义核心价值观的基本内容是富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善。“富强、民主、文明、和谐”，是我国社会主义现代化国家的建设目标，“自由、平等、公正、法治”，是对美好社会的生动表述。, location=30.577289162569368,120.08250199849752, id=3}";
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(mapper.writeValueAsString(resultMap), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(user.toString());
	}
}
