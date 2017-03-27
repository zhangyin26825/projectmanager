package com.weijuju.iag.projectmanager.controller;/**
 * Created by zhangyin on 2017/3/13.
 */

import com.weijuju.iag.projectmanager.dataobject.Project;
import com.weijuju.iag.projectmanager.service.ProjectService;
import com.weijuju.iag.projectmanager.util.PortUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhangyin
 * @create 2017-03-13
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    private static String DOMAIN="weixinjia.net";

    @Autowired
    ProjectService projectService;


    @RequestMapping("/create")
    @ResponseBody
    public synchronized ModelAndView createProject(Project project){
        ModelAndView mav=new ModelAndView();
        if(StringUtils.isEmpty(project.getProjectname())
                ||StringUtils.isEmpty(project.getDomain())
                ||StringUtils.isEmpty(project.getSvnRoot())
                ||StringUtils.isEmpty(project.getDomainIp())
                ){
            mav.getModelMap().addAttribute("message","projectname,domain,svnRoot domainIp不能为空");
            mav.setViewName("/error.jsp");
            return mav;
        }

        boolean b = projectService.VerifyRepeat(project.getProjectname(), project.getDomain());
        if(!b){
            mav.getModelMap().addAttribute("message","存在一样的项目名，或者域名，创建活动失败");
            mav.setViewName("/error.jsp");
            return mav;
        }

        if(!validateDomain(project.getDomain())){
            mav.getModelMap().addAttribute("message","域名格式不对，必需是二级域名，包含的一级域名必须有weixinjia.net");
            mav.setViewName("/error.jsp");
            return mav;
        }
        //获取可用的端口号
        Integer availablePort = PortUtil.getAvailablePort();
        project.setPort(availablePort);
        //生成二级域名
//        projectService.addSecondLevelDomain(project);
        //生产Nginx配置文件
        projectService.generateNginxConfig(project);
        //复制Tomcat  替换 server.xml 文件
        projectService.copyTomcat(project);
        //执行基本 shell 命令   启动tomcat   重启nginx
        projectService.startTomcatNginx(project);
        //根据mvn 命令 生产项目骨架
        projectService.invokeMVNArchetype(project);
        //提交 项目到 svn
        projectService.commitSVN(project);
        //部署 jenkins
        projectService.deployJenkis(project);
        //新增到数据库
        projectService.insertProject(project);
        mav.getModelMap().addAttribute("fullSvnUrl",project.getSvnRoot()+"/"+project.getMvnDirName());
        mav.getModelMap().addAttribute("id",project.getId());
        mav.setViewName("/projectCreateSuccesss.jsp");
        return mav;
    }

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

    @RequestMapping("/del")
    @ResponseBody
    public  ModelMap delProject(Integer id){
        ModelMap mav=new ModelMap();
        Project project = projectService.getProjectById(id);
        projectService.stopTomcat(project);
        projectService.deleteTomcat(project);
        projectService.deleteNginxConfig(project);
        projectService.deleteJenkins(project);
//        projectService.delSecondLevelDomain(project);
        return mav;
    }
}
