package com.vy.yzc.utils;

import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2020/11/11 17:50
 * @Description: single 实体转换器
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractConverter<T, R> implements Converter<T, R> {

	protected List<T> sources;

	protected T source;

	@Override
	public List<R> complete(Function<List<R>, List<R>> complete) {
		return complete.apply(convert());
	}

	@Override
	public R completeOne(Function<R, R> complete) {
		return complete.apply(convert(getSource()));
	}
}
