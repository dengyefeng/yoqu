package com.supplier.controller;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.Base64Utils;
import com.supplier.RSAUtils;
import com.supplier.model.SupplierInfo;
import com.supplier.service.SupplierService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class SupplierController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SupplierService supplierService;
	
    private static String publicKey ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQwl44CoEdnXe7ZBhtTHMsSHqDcYGfrH70yeo+9HAGNNkD+53vZ92yEukWaPPoTN7mMmCjZ6iFulU+tdvwvNq0CmgnPPUk6x4BWcypgt59zxX75ajJvLb3mSuUe9cnbhnYQwcqga/ooC/BdsMkIgrpbrVxMbUXHboSBN3bf+9xTwIDAQAB";


	@RequestMapping(value = "supplier/insertSupplierInfo", method = RequestMethod.POST)
	public Object insertSupplierInfo() {
		String userId = "";
		try {
			userId = java.net.URLDecoder.decode(request.getParameter("userId"), "UTF-8");
			//调用接口
			String text = createText(userId);
			String urlStr = "http://iyouqu.com.cn:8080/app/third/outService.do?corpCode=JIFU&text="+text;
			Map<String,String> map = getURLContent(urlStr);
			if(null ==map){
				return null;
			}
			String clientProvince = request.getParameter("clientProvince");
			String clientCity = request.getParameter("clientCity");
			String clientOperator = request.getParameter("clientOperator");
			String projectLeader = request.getParameter("projectLeader");
			String clientDepartment = request.getParameter("clientDepartment");
			String clientPhone = request.getParameter("clientPhone");
			String businessType = request.getParameter("businessType");
			String stage = request.getParameter("stage");
			double itemAmount = Double.parseDouble(request.getParameter("itemAmount"));
			String accessToInfo = request.getParameter("accessToInfo");
			String projectDesc = request.getParameter("projectDesc");
			SupplierInfo supplierInfo = new SupplierInfo();
			supplierInfo.setId(String.valueOf(new Date().getTime()));
			supplierInfo.setAccessToInfo(accessToInfo);
			supplierInfo.setBusinessType(businessType);
			supplierInfo.setClientCity(clientCity);
			supplierInfo.setClientDepartment(clientDepartment);
			supplierInfo.setClientOperator(clientOperator);
			supplierInfo.setClientPhone(clientPhone);
			supplierInfo.setClientProvince(clientProvince);
			supplierInfo.setItemAmount(itemAmount);
			supplierInfo.setProjectDesc(projectDesc);
			supplierInfo.setProjectLeader(projectLeader);
			supplierInfo.setStage(stage);
			supplierInfo.setUserEmail(map.get("userEmail"));
			supplierInfo.setUserName(map.get("userName"));
			supplierInfo.setUserPhone(map.get("userPhone"));
			supplierInfo.setUserPostion(map.get("userPostion"));
			supplierInfo.setUserSite(map.get("userSite"));
			this.supplierService.insertSupplier(supplierInfo);
			return supplierInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 生成密钥
	 */
	 public static String createText(String userId) throws Exception {
		    System.out.println("公钥加密——私钥解密");
	        String source = "{\"msgId\":\"GET_INFO\",\"userId\":"+userId+"}";
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
