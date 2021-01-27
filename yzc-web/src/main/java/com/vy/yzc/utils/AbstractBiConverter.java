package com.vy.yzc.utils;

import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2020/11/19 15:17
 * @Description: 双参数实体转换器
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBiConverter<T,U,R> implements BiConverter<T,U,R> {


	protected T source1;

	protected U source2;

	public R completeOne(Function<R, R> completeOne){
		return completeOne.apply(convert(getSource1(), getSource2()));
	}

}
