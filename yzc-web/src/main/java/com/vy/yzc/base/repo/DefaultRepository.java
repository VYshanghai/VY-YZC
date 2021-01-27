package com.vy.yzc.base.repo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vy.basic.web.base.VYBaseMapper;

/**
 * @Author: Edward
 * @Date: 2020/12/30 14:49
 * @Description:
 */
public interface DefaultRepository<M extends VYBaseMapper<T>, T> extends IService<T> {

}
