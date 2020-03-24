package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;



public class HttpClient {
	/** 
	 * url 地址
	 * */
	private String url = null;
	
	private static final int BYTELENGTH = 2048;
	private String read_encode;
	/**
	 * 请求头信息
	 * */
	private Map<String, String> reqs = new HashMap<String, String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -5515725831839932637L;
		{
		}
	};
	
	public HttpClient(String url){
		this.url = url;
	}
	public HttpClient(String url,Map<String, String> reqs){
		this(url);
		this.reqs.putAll(reqs);
	}
	
	private OutputStream out;
	private InputStream ins ;
	private HttpURLConnection conn;
	
	/**
	 * 创建HTTP连接
	 * */
	private void connect() throws IOException{
		URL realUrl = new URL(url);
		conn = (HttpURLConnection) realUrl.openConnection();
		if(reqs!=null){
			Iterator<Map.Entry<String, String>> it = reqs.entrySet().iterator();
			Map.Entry<String, String> entry = null;
			while (it.hasNext()) {
				entry = it.next();
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
	}
	/**
	 * post方式提交数据
	 * @param param 需要提交的数据
	 * */
	public void post(byte[] bytes,OutputStream out) throws IOException{
		connect();
		conn.setRequestMethod("POST");
		if(bytes!=null){
			conn.setRequestProperty("Content-Length", bytes.length+"");
		}
		conn.setDoOutput(true);
		conn.setDoInput(true);
		this.out = conn.getOutputStream();
		this.out.write(bytes);
		this.out.flush();
		wirte(out);
	}
	/**
	*获取输出流
	*/
	public void get(OutputStream out) throws IOException{
		connect();
		conn.setRequestMethod("GET");
		this.conn.connect();
		wirte(out);
	}
	/**
	* 获取html内容
	*/
	public String get() throws IOException{
		connect();
		conn.setRequestMethod("GET");
		this.conn.connect();
		String line = null;
		BufferedReader reader = null;
		try{
			if(read_encode!=null){
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),read_encode));	
			}else{
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			
			
			StringBuffer sb = new StringBuffer();
			while ((line=reader.readLine())!=null) {
				sb.append(line);
			}
			reader.close();
			return sb.toString();
		} finally {
			if(reader!=null) reader.close();
		}
	}
	
	private void wirte(OutputStream out) throws IOException {
		try{
			ins = conn.getInputStream();
			byte[] buffer = new byte[BYTELENGTH];
			int len = 0;
			while ((len = ins.read(buffer))!=-1) {
				out.write(buffer, 0, len);
			}
			out.flush();
			this.conn.disconnect();
		} finally {
			try {
				if(ins!=null)
					ins.close();
			} finally {
				if(this.out!=null) 
					this.out.close();
			}
		}
	}

	public HttpURLConnection getConn() {
		return conn;
	}
	public InputStream getInputStream() throws IOException {
		connect();
		conn.setRequestMethod("GET");
		this.conn.connect();
		ins = conn.getInputStream();
		return ins;
	}
	public void close() {
		try{
			if(ins!=null){
				ins.close();
			}
		}catch(Exception e){}finally{
			try{
				if(out!=null){
					out.close();
				}
			}catch(Exception e){}finally{
				if(conn!=null) conn.disconnect();
			}
		}
	}
	/**
	 * url 请求的URL
	 * head request 请求头
	 * param 参数
	 * 
	 * */
	public static String send(String url,Map<String, String> head, String param,String encode) {
		if(encode == null || "".equals(encode)){
			encode = "UTF-8";
		}
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		HttpURLConnection conn = null;
		try {
			URL realUrl = new URL(url);
			
			 // trust all hosts
            if (realUrl.getProtocol().toLowerCase().equals("https")) {
            	trustAllHosts();
            	HttpsURLConnection https = (HttpsURLConnection)realUrl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
            	conn = (HttpURLConnection)realUrl.openConnection();
            }
            
			if(head!=null){
				Iterator<Map.Entry<String, String>> it = head.entrySet().iterator();
				Map.Entry<String, String> entry = null;
 				while (it.hasNext()) {
 					entry = it.next();
 					conn.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}
		
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			if(param!=null&&!"".equals(param)) {
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Length", param.length()+"");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),encode)); 
				out.print(param);
				out.flush();
			} else {
				conn.setRequestMethod("GET");
				conn.connect();
			}
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),encode));
			String line;
			while ((line = in.readLine()) != null) {
				//if(line.startsWith("<"))
					result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			throw new RuntimeException("HTTP请求失败："+e.getMessage(),e);
		} finally {
			if(out!=null){
				out.close();
			}
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				conn.disconnect();
			}
		}
	}
	

	public String getRead_encode() {
		return read_encode;
	}
	public void setRead_encode(String read_encode) {
		this.read_encode = read_encode;
	}
	
	final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		 
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

	/**
	 * Trust every server - dont check for any certificate
	 */
	private static void trustAllHosts() {
		final String TAG = "trustAllHosts";
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[] {};
			}

			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}
		} };

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(send("http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E8%A5%BF%E5%AE%89&kw=java%E5%BC%80%E5%8F%91%E5%B7%A5%E7%A8%8B%E5%B8%88&sm=0&p=2",null,null,"utf-8"));;
	}
}



