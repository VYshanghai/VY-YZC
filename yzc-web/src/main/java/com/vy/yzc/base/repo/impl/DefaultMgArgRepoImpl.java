package com.vy.yzc.base.repo.impl;

import com.vy.basic.web.base.VYBaseMapper;
import com.vy.yzc.base.po.DefaultMgArgPO;

/**
 * @Author: Edward
 * @Date: 2021/1/25 19:15
 * @Description: 后台默认数据仓库继承类
 */
public class DefaultMgArgRepoImpl<M extends VYBaseMapper<T>, T extends DefaultMgArgPO> extends
		DefaultArgRepoImpl<M, T>  {

}
