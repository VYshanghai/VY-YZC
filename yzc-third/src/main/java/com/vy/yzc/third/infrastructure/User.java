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
 * userRepository操作的bean
 */
@Data
@Document(indexName = "vikko", type = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseVyElasticsearchVO {
    @Id
    private Integer id;
    private String name;
    private String address;
    private Integer sex;
    @GeoPointField
    private String location;

    private String distance;

    private String extra;

}