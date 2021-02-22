package com.vy.yzc.third.infrastructure;

import com.vy.basic.elasticsearch.BaseVyElasticsearchVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

/**
 * @author: vikko
 * @Date: 2021/2/2 18:08
 * @Description:
 */
@Data
@Document(indexName = "visva", type = "teacher")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseVyElasticsearchVO {
	@Id
	private Integer id;
	private String name;
	private String address;
	private Integer sex;
	@GeoPointField
	private String location;

	private String distance;

	private Integer level;
}
