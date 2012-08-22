package br.com.flanders.blogjee.utils;

import javax.enterprise.inject.Default;

@Default
public class TimeProviderUtils {

	public long getCurrentTime() {
		return System.currentTimeMillis();
	}
}