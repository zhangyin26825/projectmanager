package com.weijuju.iag.projectmanager.service;/**
 * Created by zhangyin on 2017/3/14.
 */

import com.weijuju.iag.projectmanager.dataobject.Project;

/**
 * @author zhangyin
 * @create 2017-03-14
 */

public interface ProjectService {

     //生成Nginx配置文件
    void generateNginxConfig(Project project);
    // 删除Nginx配置文件
    void deleteNginxConfig(Project project);
    // 删除nginx下该项目日志文件
    void deleteNginxLogFile(Project project);
    // 复制tomcat
    void copyTomcat(Project project);
    //删除tomcat
    void deleteTomcat(Project project);
    //启动Tomcat  nginx
    void startTomcatNginx(Project project);
    //部署Jenkins
    void deployJenkis(Project project);
    //根据mvn 命令 生产项目骨架
    void invokeMVNArchetype(Project project);
    //提交 项目到 svn
    void commitSVN(Project project);
    //插入数据库
    void  insertProject(Project project);
    //增加二级域名
    void  addSecondLevelDomain(Project project);
    //删除二级域名
    void delSecondLevelDomain(Project project);
    //验证域名跟项目名的重复性
    boolean  VerifyRepeat(String projectName,String domain);

    Project getProjectById(Integer id);
    //删除jenkins部署的项目
    void deleteJenkins(Project project);


    void stopTomcat(Project project);
}
