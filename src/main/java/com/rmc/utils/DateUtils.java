package com.rmc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڹ�����
 * 
 * @author ch
 *
 */
public class DateUtils {
	/**
	 * ���ر�׼ʱ��
	 * 
	 * @param time
	 * @return
	 */
	public static String getDate(long time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(time));
	}

	/**
	 * ���ر�׼ʱ��
	 * 
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * ����ʱ���
	 * 
	 * @return
	 */
	public static String getTemple() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(new Date());
	}

}
