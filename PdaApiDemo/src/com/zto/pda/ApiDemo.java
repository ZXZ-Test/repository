package com.zto.pda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;


/**
 * <p>
 * 接口测试类
 * </p>
 * @author MoonLo
 * @version 1.0 2017-12-7 11:43:43
 *
 */
public class ApiDemo {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	/** 接口地址 **/
	private static String url = "http://localhost:8888/apps/pdaService";
	/** PDA登录用户名 (选择实际账号)**/
	private static String userName = "testUserName";
	/** PDA登录用户密码  **/
	private static String passWord = "testUserPassword";
	/** 请求端口号 (装卸车数据上传:17120701 ; 数据核对 : 17120702 ; 漏扫查询: 17120703 ; 卸车提交: 17120704)**/
	private static String serviceCode = "17120702";

	/**
	 * 发送接口请求并返回结果
	 * @param params
	 * @param url
	 * @return
	 */
	public static String post(String params, String url) {
		try {
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		final List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();
		nameValueList.add(new NameValuePair("uname", userName));
		nameValueList.add(new NameValuePair("params", params));//参数
		nameValueList.add(new NameValuePair("upasswd", passWord));//mima
		nameValueList.add(new NameValuePair("serviceCode", serviceCode));//
		
		HttpClientParams httpClientParams = new HttpClientParams();
		httpClientParams.setConnectionManagerTimeout(1000);
		final HttpClient httpClient = new HttpClient(httpClientParams,
				new SimpleHttpConnectionManager(true));
		final PostMethod postMethod = new PostMethod(url);// chenfen.f3322.org
		postMethod.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");
		postMethod.setRequestBody( nameValueList
				.toArray(new NameValuePair[nameValueList.size()]));
		postMethod.addRequestHeader("Connection", "close");
		String result = null;
		try {
			httpClient.executeMethod(postMethod);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					postMethod.getResponseBodyAsStream()));
			StringBuffer stringBuffer = new StringBuffer();
			while ((result = reader.readLine()) != null) {
				stringBuffer.append(result);
			}
			return stringBuffer.toString();
		} catch (final IOException e) {
			System.out.println("数据请求失败，params:" + params);
		} finally {
			postMethod.releaseConnection();
			Date date2 = new Date();
			System.out.println("任务结束时间：" + sdf.format(date2));
		}
		return null;
	}

	/**
	 * 测试main方法
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			JSONObject stayinfo = new JSONObject();
			//p1
			stayinfo.put("hewbNo", "20167892061100100005");
			//p1
			stayinfo.put("operationBy", "5710000001");
			//p1
			stayinfo.put("ewbNo", "201613481944");
			//p1
			stayinfo.put("ewbsListNo","18441849218020202");
			
			
			String params = stayinfo.toString();
			System.out.println("返回参数："+ post(params, url));
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
