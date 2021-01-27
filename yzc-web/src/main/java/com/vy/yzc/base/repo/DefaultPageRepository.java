package com.vy.yzc.base.repo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vy.basic.web.base.BasePageReqVO;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: vikko
 * @Date: 2020/11/30 14:31
 * @Description:
 */
public interface DefaultPageRepository<T> extends IService<T> {

	/**
	 * 基础分页
	 *
	 * @param q 请求对象
	 * @param supplier Wrapper<T> sql包装器函数
	 * @param compose Function<T, R> 结果集转换函数
	 * @param <R> 返回对象泛型
	 * @param <Q> 请求对象泛型
	 * @return IPage<R>
	 */
	<R, Q extends BasePageReqVO> IPage<R> iPage(Q q, Supplier<Wrapper<T>> supplier,
			Function<T, R> compose);

	/**
	 * 分页增强
	 *
	 * @param q 请求对象
	 * @param supplier sql包装器函数
	 * @param then 结果集转换器函数
	 * @param <R> 返回对象泛型
	 * @param <Q> 请求对象泛型
	 * @return IPage<R>
	 */
	<R, Q extends BasePageReqVO> IPage<R> iPageExtraHandle(Q q, Supplier<Wrapper<T>> supplier,
			Function<List<T>, List<R>> then);

}
