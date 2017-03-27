package com.weijuju.iag.projectmanager.shell;



import com.weijuju.iag.projectmanager.config.Config;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangyin on 2016/8/25.
 */
public class LinuxShell {

    private String domainName;

    private String projectName;

    private int port;


    public LinuxShell(String domainName, String projectName, int port) {
        this.domainName = domainName;
        this.projectName = projectName;
        this.port = port;
    }
    public  void  setTomcatAccess(){
        try {
            String   targetFilepath = Config.getProjectBaseDirectory() + File.separator +projectName + File.separator+ "server_" + port;
            Process process = Runtime.getRuntime().exec("chmod 777 "+targetFilepath);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void  startTomcat(){
        try {
            String tomcatpath= Config.getProjectBaseDirectory() + File.separator
                    +projectName + File.separator+ "server_" + port+File.separator+"bin"+File.separator+"startup.sh";
            Process process = Runtime.getRuntime().exec(tomcatpath);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void  stopTomcat(){
        try {
            String tomcatpath= Config.getProjectBaseDirectory() + File.separator
                    +projectName + File.separator+ "server_" + port+File.separator+"bin"+File.separator+"shutdown.sh";
            Process process = Runtime.getRuntime().exec(tomcatpath);
            process.waitFor();

        } catch (Exception e) {
            System.out.println("停止 tomcat失败");
            e.printStackTrace();
        }
        try {
            String kiiTomcat="ps -ef|grep "+projectName+"|grep -v grep|awk '{print $2}'|xargs kill -9";
            Process process = Runtime.getRuntime().exec(kiiTomcat);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void restartNginx(){
        try {
            Process process = Runtime.getRuntime().exec("nginx -s reload");
            process.waitFor();
        } catch (Exception e) {
            System.out.println("重启Nginx失败");
            e.printStackTrace();
        }
    }
}
