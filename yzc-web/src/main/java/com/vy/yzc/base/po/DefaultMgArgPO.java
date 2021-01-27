package com.vy.yzc.base.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2021/1/25 18:54
 * @Description: 后台基础映射类
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DefaultMgArgPO extends DefaultArgPO {

	protected Long creator;

	protected Long modifier;

}
