package com.weijuju.iag.projectmanager.nginx;

import com.weijuju.iag.projectmanager.config.Config;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyin on 2016/8/24.
 */
public class NginxConfigurationFile {

    private String domainName;

    private String projectName;

    private int port;

    public NginxConfigurationFile(String domainName, String projectName, int port) {
        this.domainName = domainName;
        this.projectName = projectName;
        this.port = port;
    }

    private String generateNginxConf(){
        Configuration configuration = new Configuration();
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setTemplateLoader(new ClassTemplateLoader(NginxConfigurationFile.class, "/"));
        try {
            Template template = configuration.getTemplate("templet/NginxConfigurationTemplet.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> context = new HashMap<String, Object>();
            context.put("domainName", domainName);
            context.put("projectName", projectName);
            context.put("port",port);
            template.process(context, writer);
           // System.out.println(writer.toString());
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void generateFile(){
        FileWriter fw=null;
        try {
            String filepath= Config.getConfigDir()+ File.separator+domainName;
            File f=new File(filepath);
            f.createNewFile();
            fw=new FileWriter(f);
            fw.write(generateNginxConf());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        NginxConfigurationFile ng=new NginxConfigurationFile("iag-jenkins.weijuju.com","iag-jenkins",9007);
        System.out.println(ng.generateNginxConf());

    }
}
