package com.weijuju.iag.projectmanager.service.impl;/**
 * Created by zhangyin on 2017/3/14.
 */

import com.weijuju.iag.projectmanager.dataobject.Project;
import com.weijuju.iag.projectmanager.dataobject.ProjectExample;
import com.weijuju.iag.projectmanager.domain.DomainUtil;
import com.weijuju.iag.projectmanager.jenkins.JenkinsBuildJob;
import com.weijuju.iag.projectmanager.jenkins.JenkinsUtil;
import com.weijuju.iag.projectmanager.mapper.ProjectMapper;
import com.weijuju.iag.projectmanager.nginx.NginxConfigurationFile;
import com.weijuju.iag.projectmanager.config.Config;
import com.weijuju.iag.projectmanager.service.ProjectService;
import com.weijuju.iag.projectmanager.shell.LinuxShell;
import com.weijuju.iag.projectmanager.svn.SVNUtil;
import com.weijuju.iag.projectmanager.tomcat.TomcatCopyDirectory;
import com.weijuju.iag.projectmanager.util.ShellUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNClientManager;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangyin
 * @create 2017-03-14
 */
@Service
public class ProjectServiceImpl  implements ProjectService {

    @Override
    public void generateNginxConfig(Project project) {
        try {
            NginxConfigurationFile nginxConfigurationFile=new NginxConfigurationFile(project.getDomain(),project.getProjectname(),project.getPort());
            nginxConfigurationFile.generateFile();
            System.out.println("生成Nginx配置文件成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成Nginx配置文件失败");
            throw  e;
        } finally {
        }
    }

    @Override
    public void deleteNginxConfig(Project project) {
        try {
            String filepath= Config.getConfigDir()+ File.separator+project.getDomain();
            File f=new File(filepath);
            FileUtils.forceDelete(f);
            System.out.println("删除Nginx配置文件成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("删除Nginx配置文件失败");
        } finally {
        }
    }

    @Override
    public void deleteNginxLogFile(Project project) {
        try {
            String filepath= Config.getNginxAccessLogDir()+ File.separator+project.getProjectname()+".log";
            File f=new File(filepath);
            FileUtils.forceDelete(f);
            System.out.println("删除NginxAccessLog文件成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("删除NginxAccessLog文件失败");
        } finally {
        }
    }

    @Override
    public void copyTomcat(Project project) {
        try {
            TomcatCopyDirectory tomcat=new TomcatCopyDirectory(project.getDomain(),project.getProjectname(),project.getPort());
            System.out.println("复制新的tomcat 成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("复制新的tomcat 失败");
        } finally {
        }
    }

    @Override
    public void deleteTomcat(Project project) {
        try {
            String   targetFilepath = Config.getProjectBaseDirectory() + File.separator +project.getProjectname();
            File file=new File(targetFilepath);
            FileUtils.deleteDirectory(file);
            System.out.println("删除 Tomcat 成功");
        } catch (IOException e) {
            System.out.println("删除 Tomcat 失败");
            e.printStackTrace();
        } finally {
        }

    }

    @Override
    public void stopTomcat(Project project) {
        try {
            LinuxShell  linuxShell=new LinuxShell(project.getDomain(),project.getProjectname(),project.getPort());
            linuxShell.stopTomcat();
            System.out.println("关闭Tomcat成功");
        } catch (Exception e) {
            System.out.println("关闭Tomcat失败");
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public void startTomcatNginx(Project project) {

        try {
            LinuxShell  linuxShell=new LinuxShell(project.getDomain(),project.getProjectname(),project.getPort());
            linuxShell.setTomcatAccess();
            linuxShell.startTomcat();
            linuxShell.restartNginx();
            System.out.println("启动  tomcat  nginx 成功");
        } catch (Exception e) {
            System.out.println("启动  tomcat  nginx 失败");
            e.printStackTrace();
        } finally {
        }

    }

    @Override
    public void deployJenkis(Project project) {
        try {
            JenkinsBuildJob j=new JenkinsBuildJob(project.getDomain(),project.getProjectname(),project.getPort(),project.getSvnRoot()+"/"+project.getMvnDirName(),project.getGroupid(),project.getArtifactid());
            System.out.println("部署jenkins 成功");
        } catch (Exception e) {
            System.out.println("部署jenkins 失败");
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public synchronized void invokeMVNArchetype(Project project) {
        try {
            String mvnCommand = getMVNCommand(project);
            String tempDirPath=Config.getTempProjectMavenArcheTypeGenerate();
            File dir=new File(tempDirPath);
            //清空临时目录
            FileUtils.cleanDirectory(dir);
            String command="cd "+tempDirPath+"; "+mvnCommand;
            System.out.println("maven骨架项目生成命令是   "+command);
            ShellUtil.executeShell(command);
            System.out.println("利用mvn骨架 创建骨架成功");
            File[] files = dir.listFiles();
            for (File file : files) {
                if(file.isDirectory()){
                    String name = file.getName();
                    project.setMvnDirName(name);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("利用mvn骨架 创建骨架失败");
            e.printStackTrace();
        } finally {
        }


    }


    @Override
    public void commitSVN(Project project) {
        try {
            String tempDirPath=Config.getTempProjectMavenArcheTypeGenerate();
            File dir=new File(tempDirPath);
            SVNClientManager svnClientManager = SVNUtil.authSvn(project.getSvnRoot(), "zhangyin", "alkdf#$!dafadfda");
            SVNUtil.importDirectory(svnClientManager,dir, SVNURL.parseURIEncoded(project.getSvnRoot()),"程序自动提交",true);
            System.out.println("提交项目到svn成功");
        } catch (SVNException e) {
            System.out.println("提交项目到svn失败");
            e.printStackTrace();
        } finally {
        }

    }

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void insertProject(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public Project getProjectById(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteJenkins(Project project) {
        JenkinsUtil.deleteJob(project.getProjectname());
    }


    @Override
    public void addSecondLevelDomain(Project project) {
        String s = DomainUtil.generateDomain(project.getDomain(),project.getDomainIp());
        project.setDnsRecordId(s);
    }

    @Override
    public void delSecondLevelDomain(Project project) {
        DomainUtil.deleteDomain(project.getDnsRecordId());
    }


    @Override
    public boolean VerifyRepeat(String projectName, String domain) {
        ProjectExample example=new ProjectExample();
        example.or().andProjectnameEqualTo(projectName);
        example.or().andDomainEqualTo(domain);
        int i = projectMapper.countByExample(example);
        if(i==0){
            return true;
        }
        return false;
    }

    private  String  getMVNCommand(Project project){
        //todo 这里应该会有多种 maven骨架  后续应该会增加
        String result="";
        result="mvn archetype:generate -B -U -DarchetypeGroupId=com.weijuju.iag -DarchetypeArtifactId=springboot.redisson-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId="+ project.getGroupid()+" -DartifactId="+project.getArtifactid()+" -Dversion=1.0-SNAPSHOT -DarchetypeCatalog=local -DdatabaseName="+project.getDatabaseName()+" -DprojectName="+project.getProjectname()+" -DbasePackage="+project.getGroupid()+"."+project.getArtifactid()+" -DRedisDB="+project.getRedisdb()+" -Ddomain="+project.getDomain();
        return result;
//        switch (project.getArchetype()){
//            case  "springboot.redisson-archetype":
//               result="mvn archetype:generate -DarchetypeGroupId=com.weijuju.iag -DarchetypeArtifactId=springboot.redisson-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId="+ project.getGroupid()+" -DartifactId="+project.getArtifactid()+" -Dversion=1.0-SNAPSHOT -DarchetypeCatalog=local -DdatabaseName="+project.getDatabase()+" -DprojectName="+project.getProjectname()+" -DbasePackage="+project.getGroupid()+"."+project.getArtifactid()+" -DRedisDB="+project.getRedisdb()+"";
//                 break;
//        }
//        return result;
    }
}
