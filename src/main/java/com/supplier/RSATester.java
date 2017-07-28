package com.supplier;



import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class RSATester {

    private static String publicKey ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCczw18alyYLMt5FKl1m9v3/JSu5GidDKfYRoIrD0iGaUF51BIeRCzcH76H3Q3FBjKBWTPGxp2J+Alf2vanozwTBE3AfxDNpM1A6X3tbTbpy+mmLIxYZm07NpqRmhOVAHvnItLzXeHVPph1M08sBVgY8il1ceyxgYlMCV+603sNmQIDAQAB";

    public static void main(String[] args) throws Exception {
    	String text =  test();
		String urlStr = "http://test.iyouqu.com.cn:8080/app/third/outService.do?corpCode=JIFU&text="+text;
		Map<String,String> map = getURLContent(urlStr);
       
    }

    public static String test() throws Exception {
	    System.out.println("公钥加密——私钥解密");
        String source = "{\"msgId\":\"GET_INFO\",\"userId\":10999}";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        System.out.println("RSA加密后文字：\r\n" + new String(encodedData));
        String a=Base64Utils.encode(encodedData);
        System.out.println("base64加密后文字：\r\n" + a);
        String str=URLEncoder.encode(a, "utf-8");
        System.out.println("URLEncoder加密后文字：\r\n" + str);
        String str2 = URLEncoder.encode(str, "utf-8");
        System.out.println("URLEncoder加密后文字：\r\n" + str2);
        return str2;
     
    }
    
    /**
     * 程序中访问http数据接口
     */
    public static Map<String,String> getURLContent(String urlStr)throws Exception {
    	Map<String,String>  map=new HashMap<String,String>();
    	DefaultHttpClient httpclient = new DefaultHttpClient();  
    	HttpPost post = new HttpPost(urlStr);
    	HttpResponse response = httpclient.execute(post); 
        /*读返回数据*/  
        String str = EntityUtils.toString(response.getEntity());  
        JSONObject obj = JSONObject.fromObject(str); 
        String code = String.valueOf(obj.get("code"));
        if("0".equals(code)){
	        JSONObject result = obj.getJSONObject("resultMap");
	        String userName = String.valueOf(result.get("userName"));
	        String userEmail=String.valueOf(result.get("userEmail"));
	        String userPhone=String.valueOf(result.get("userPhone"));
	        String userSite=String.valueOf(result.get("userSite"));
	        String userPostion=String.valueOf(result.get("userPostion"));
	        map.put("userName", userName);
	        map.put("userEmail", userEmail);
	        map.put("userPhone", userPhone);
	        map.put("userSite", userSite);
	        map.put("userPostion", userPostion);
	        return map;
        }
        return null;
    }


}
