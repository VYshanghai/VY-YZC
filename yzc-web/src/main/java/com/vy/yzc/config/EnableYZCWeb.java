package com.vy.yzc.config;

import com.vy.basic.web.utils.SpringContextUtil;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

/**
 * @Author: Edward
 * @Date: 2020/11/30 16:24
 * @Description:
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({BaseWebConfiguration.class, SpringContextUtil.class})
@ComponentScans({@ComponentScan({"com.vy.basic.web.handler"})})
public @interface EnableYZCWeb {

}
