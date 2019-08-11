package com.aqdamnaseem.projects.employee.management.common;

import java.util.Collection;

public class Utilities {

	/**
	 * @param input
	 * @return
	 */
	public static boolean isNullOrEmpty(String input) {
		return (input == null || input.length() == 0);
	}

	/**
	 * @param input
	 * @return
	 */
	public static boolean isNullOrEmpty(Collection<?> input) {
		return (input == null || input.isEmpty());
	}

}
