package com.vy.yzc.base.po;

import com.vy.basic.web.base.BasePO;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2021/1/25 18:48
 * @Description: app端 基础映射类
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultArgPO implements BasePO {

	protected Long id;

	protected Boolean deleted;

	protected Date createdTime;

	protected Date updatedTime;

	@Override
	public void setCreator(Long creator) {

	}

	@Override
	public Long getCreator() {
		return null;
	}

	@Override
	public void setModifier(Long modifier) {

	}

	@Override
	public Long getModifier() {
		return null;
	}
}
