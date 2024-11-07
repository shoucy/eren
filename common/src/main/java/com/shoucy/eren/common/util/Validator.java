package com.shoucy.eren.common.util;

import com.shoucy.eren.common.exception.ValidateException;

public class Validator extends cn.hutool.core.lang.Validator {

	/**
	 * 校验sql字段名是否合法
	 */
	public static String validateSqlColumn(String value) {
		// 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
		if (StrUtil.isNotEmpty(value) && !value.matches("[a-zA-Z0-9_\\ \\,\\.]+")) {
			throw new ValidateException("参数不符合规范，不能进行查询");
		}
		return value;
	}

}
