package com.vy.yzc.utils;

/**
 * @Author: Edward
 * @Date: 2020/11/11 17:23
 * @Description: 双参数实体转换器
 */
public interface BiConverter<T,U,R> {

	R convert(T t, U u);
}
