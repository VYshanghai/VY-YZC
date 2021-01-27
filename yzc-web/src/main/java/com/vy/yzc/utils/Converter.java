package com.vy.yzc.utils;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Author: Edward
 * @Date: 2020/11/11 17:19
 * @Description: 实体转换器
 */
public interface Converter<T, R>{


	R convert(T t);

	default List<R> convert(){
		if(CollectionUtils.isEmpty(getSources())){
			return Lists.newArrayList();
		}
		return getSources().stream().map(this::convert).collect(Collectors.toList());
	}

	List<T> getSources();

	List<R> complete(Function<List<R>, List<R>> complete);

	R completeOne(Function<R, R> complete);

}
