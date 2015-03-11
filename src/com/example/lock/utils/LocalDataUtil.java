package com.example.lock.utils;

import java.text.SimpleDateFormat;

import android.R.integer;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * �������ݴ洢������
 * 
 * @author Aaron He
 * 
 */
public class LocalDataUtil {

	/**
	 * �������ݵ��ļ�����
	 */
	private static final String DB = "BIM";
	/**
	 * ��¼��
	 */
	public static final String LOGIN_NAME = "LOGIN_NAME";
	/**
	 * ��¼����
	 */
	public static final String LOGIN_PWD = "LOGIN_PWD";
	/**
	 * �û�ids
	 */
	public static final String LOGIN_ID = "LOGIN_ID";
	/**
	 * �û���
	 */
	public static final String USER_NAME = "USER_NAME";
	/**
	 * �û���¼����
	 */
	public static final String USER_PWD = "USER_PWD";
	/**
	 * ������
	 */
	public static final String DEPTNAME = "DEPTNAME";
	/**
	 * ����id
	 */
	public static final String DEPT_ID = "DEPT_ID";
	/**
	 * UNIT_ID
	 */
	public static final String UNIT_ID = "UNIT_ID";

	/**
	 * �Ƿ��Զ���¼ YES���ǣ�NO����
	 */
	public static final String AUTOLOGIN = "AUTOLOGIN";

	/**
	 * ��ȡ���������
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param key
	 *            �ؼ���
	 * @return ���ر����ֵ
	 */
	public static String getValue(Context context, String key) {
		SharedPreferences date = context.getSharedPreferences(DB, 0);
		String updateDate = date.getString(key, "");
		return updateDate;
	}

	/**
	 * ��ȡ���������
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param key
	 *            �ؼ���
	 * @param defaultValue
	 *            Ĭ��ֵ
	 * @return ���ر����ֵ
	 */
	public static int getIntValue(Context context, String key, int defaultValue) {
		SharedPreferences date = context.getSharedPreferences(DB, 0);
		int updateDate = date.getInt(key, defaultValue);
		return updateDate;
	}

	/**
	 * ��������
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param key
	 *            �ؼ���
	 * @param value
	 *            ��������� String
	 */
	public static void setValue(Context context, String key, String value) {
		SharedPreferences date = context.getSharedPreferences(DB, 0);
		date.edit().putString(key, value).commit();
	}

	/**
	 * ��������
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param key
	 *            �ؼ���
	 * @param value
	 *            ���������Integer
	 */
	public static void setIntValue(Context context, String key, int value) {
		SharedPreferences date = context.getSharedPreferences(DB, 0);
		date.edit().putInt(key, value).commit();
	}

	/**
	 * ��ȡʱ��
	 * 
	 * @param context
	 * @param key
	 *            �ؼ���
	 * @return ����ʱ���ַ���
	 */
	public static String getTime(Context context, String key) {
		SharedPreferences date = context.getSharedPreferences(DB, 0);
		String time = date.getString(key, "");
		return time;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param context
	 * @param key
	 *            �ؼ���
	 */
	public static void saveTime(Context context, String key) {
		SharedPreferences date = context.getSharedPreferences(DB, 0);
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sDateFormat.format(new java.util.Date());
		date.edit().putString(key, time).commit();
	}

}
