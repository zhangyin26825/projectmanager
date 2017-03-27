package com.weijuju.iag.projectmanager.config;/**
 * Created by zhangyin on 2017/3/14.
 */

/** Nginx 全局的配置
 * @author zhangyin
 * @create 2017-03-14
 */
public class Config {

    //nginx配置文件放置目录
    public static String configDir="/etc/nginx/sites-enabled";
    //nginx 命令执行目录
    public static  String nginxRunDir="/etc/init.d";
    //nginx 每个项目的accessLog 存放目录
    public static String nginxAccessLogDir="/mnt/log/weijuju/nginx";
    /***
     *  项目放置的基准目录
     */
    private static  String  projectBaseDirectory="/mnt/website";
    /**
     * Tomcat 模板放置的目录路径
     */
    private static  String  tomcatTempletDirectory="/mnt/operation/tomcatTemplet";
    /**
     * maven 骨架生成临时目录
     */
    private static  String  tempProjectMavenArcheTypeGenerate="/mnt/TempMavenArchetype";


    public static String getConfigDir() {
        return configDir;
    }

    public static void setConfigDir(String configDir) {
        Config.configDir = configDir;
    }

    public static String getNginxRunDir() {
        return nginxRunDir;
    }

    public static void setNginxRunDir(String nginxRunDir) {
        Config.nginxRunDir = nginxRunDir;
    }

    public static String getNginxAccessLogDir() {
        return nginxAccessLogDir;
    }

    public static void setNginxAccessLogDir(String nginxAccessLogDir) {
        Config.nginxAccessLogDir = nginxAccessLogDir;
    }

    public static String getProjectBaseDirectory() {
        return projectBaseDirectory;
    }

    public static void setProjectBaseDirectory(String projectBaseDirectory) {
        Config.projectBaseDirectory = projectBaseDirectory;
    }

    public static String getTomcatTempletDirectory() {
        return tomcatTempletDirectory;
    }

    public static void setTomcatTempletDirectory(String tomcatTempletDirectory) {
        Config.tomcatTempletDirectory = tomcatTempletDirectory;
    }

    public static String getTempProjectMavenArcheTypeGenerate() {
        return tempProjectMavenArcheTypeGenerate;
    }

    public static void setTempProjectMavenArcheTypeGenerate(String tempProjectMavenArcheTypeGenerate) {
        Config.tempProjectMavenArcheTypeGenerate = tempProjectMavenArcheTypeGenerate;
    }
}
