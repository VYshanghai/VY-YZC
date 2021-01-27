package com.vy.yzc.common.constants;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: Edward
 * @Date: 2020/12/16 16:35
 * @Description:
 */
public class HeadInfoContextHandler {

	public static final String version = "Version";

	public static final String platform = "Platform";

	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	private static void set(String key, Object value) {
		Map<String, Object> info = threadLocal.get();
		if (Objects.isNull(info)) {
			info = Maps.newHashMap();
			threadLocal.set(info);
		}
		info.put(key, value);
	}

	private static Object get(String key) {
		Map<String, Object> info = threadLocal.get();
		if (Objects.isNull(info)) {
			info = Maps.newHashMap();
			threadLocal.set(info);
		}
		return info.get(key);
	}

	public static String getVersion() {
		return Objects.nonNull(get(version)) ? get(version).toString() : null;
	}

	public static String getPlatform() {
		return Objects.nonNull(get(platform)) ? get(platform).toString() : null;
	}


	public static void setVersion(String value) {
		set(version, value);
	}

	public static void setPlatform(String value) {
		set(platform, value);
	}

	public static void remove() {
		threadLocal.remove();
	}

}
