package com.vy.yzc.base.repo.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vy.basic.web.base.BasePageReqVO;
import com.vy.basic.web.base.BaseService;
import com.vy.basic.web.base.VYBaseMapper;
import com.vy.yzc.base.po.DefaultArgPO;
import com.vy.yzc.base.repo.DefaultPageRepository;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Author: Edward
 * @Date: 2021/1/25 18:56
 * @Description: app端数据仓储基础类
 */
public class DefaultArgRepoImpl<M extends VYBaseMapper<T>, T extends DefaultArgPO> extends
		BaseService<M, T> implements DefaultPageRepository<T> {

	@Override
	public <R, Q extends BasePageReqVO> IPage<R> iPage(Q q, Supplier<Wrapper<T>> supplier,
			Function<T, R> compose) {
		Page<T> queryPage = new Page<>(q.getStartPage(), q.getPageSize(), true);
		Page<T> poPage = getBaseMapper().selectPage(queryPage, supplier.get());
		List<T> records = poPage.getRecords();
		if (CollectionUtils.isNotEmpty(records)) {
			List<R> finalResult = records.stream().map(compose).collect(Collectors.toList());
			Page<R> rPage = new Page<>(q.getStartPage(), q.getPageSize(), true);
			rPage.setTotal(poPage.getTotal());
			rPage.setRecords(finalResult);
			rPage.setCurrent(poPage.getCurrent());
			return rPage;
		} else {
			return new Page<>(q.getStartPage(), q.getPageSize(), true);
		}
	}

	@Override
	public <R, Q extends BasePageReqVO> IPage<R> iPageExtraHandle(Q q, Supplier<Wrapper<T>> supplier,
			Function<List<T>, List<R>> compose) {
		Page<T> queryPage = new Page<>(q.getStartPage(), q.getPageSize(), true);
		Page<T> poPage = getBaseMapper().selectPage(queryPage, supplier.get());
		List<T> records = poPage.getRecords();
		if (CollectionUtils.isNotEmpty(records)) {
			List<R> finalResult = compose.apply(records);
			Page<R> rPage = new Page<>(q.getStartPage(), q.getPageSize(), true);
			rPage.setTotal(poPage.getTotal());
			rPage.setRecords(finalResult);
			rPage.setCurrent(poPage.getCurrent());
			return rPage;
		} else {
			return new Page<>(q.getStartPage(), q.getPageSize(), true);
		}
	}
}
