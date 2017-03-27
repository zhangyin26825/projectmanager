package com.weijuju.iag.projectmanager.domain;/**
 * Created by zhangyin on 2017/3/16.
 */

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.AddDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.AddDomainRecordResponse;
import com.aliyuncs.alidns.model.v20150109.DeleteDomainRecordRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.commons.lang.StringUtils;

/**
 * @author zhangyin
 * @create 2017-03-16
 */
public class DomainUtil {

    private static IAcsClient client = null;
//    private static String DOMAIN="andysoso.cn";
    private static String DOMAIN="weixinjia.net";
    static {
        String regionId = "cn-hangzhou"; //必填固定值，必须为“cn-hanghou”
        String accessKeyId = "LTAImHVkUZETlDxj"; // your accessKey
        String accessKeySecret = "z1tZJU58uNGRlvNYemCh0htZY0PxDQ";// your accessSecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        // 若报Can not find endpoint to access异常，请添加以下此行代码
        // DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Alidns", "alidns.aliyuncs.com");
        client = new DefaultAcsClient(profile);
    }

    //生成域名
    public static String generateDomain(String domain,String ip){
        int i = domain.indexOf('.');
        String substring = domain.substring(0, i);
        AddDomainRecordRequest addDomainRecordRequest=new  AddDomainRecordRequest();
        addDomainRecordRequest.setDomainName(DOMAIN);
        addDomainRecordRequest.setActionName("AddDomainRecord");
        addDomainRecordRequest.setRR(substring);
        addDomainRecordRequest.setType("A");
        addDomainRecordRequest.setValue(ip); //测试环境的IP地址
        try {
            AddDomainRecordResponse acsResponse = client.getAcsResponse(addDomainRecordRequest);
            return acsResponse.getRecordId();
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public static void deleteDomain(String RecordId){
        try {
            DeleteDomainRecordRequest  deleteDomainRecordRequest=new DeleteDomainRecordRequest();
            deleteDomainRecordRequest.setRecordId(RecordId);
            client.getAcsResponse(deleteDomainRecordRequest);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
        }
    }



    //验证域名
    public  static boolean validateDomain(String domain){
        if(!StringUtils.contains(domain,DOMAIN)){
           return false;
        }
        String[] split = domain.split("\\.");
        if(split.length!=3){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        generateDomain("test.andysoso.cn");
    }
}
