package com.weijuju.iag.projectmanager.jenkins;/**
 * Created by zhangyin on 2017/3/15.
 */

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

import java.net.URI;
import java.util.Map;

/**
 * @author zhangyin
 * @create 2017-03-15
 */
public class JenkinsUtil {

    public static  void  createJob(String jobName,String jobXml){
        try {
            JenkinsServer jenkins = new JenkinsServer(new URI("http://iag-jenkins.weijuju.com"), "admin", "admin");
//            Map<String, Job> jobs = jenkins.getJobs();
//            JenkinsVersion version = jenkins.getVersion();
//            System.out.println(version.toString());
            jenkins.createJob(jobName,jobXml);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void deleteJob(String jobName){
        try {
            JenkinsServer jenkins = new JenkinsServer(new URI("http://iag-jenkins.weijuju.com"), "admin", "admin");
            Map<String, Job> jobs = jenkins.getJobs();
//            Job job = jobs.get(jobName);
//            JobWithDetails details = job.details();
            jenkins.deleteJob(jobName);
            System.out.println("删除jenkins任务成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除jenkins任务失败");
        } finally {
        }
    }


    public static void main(String[] args) {
//        JenkinsUtil.jenkensOperation();
    }

}
