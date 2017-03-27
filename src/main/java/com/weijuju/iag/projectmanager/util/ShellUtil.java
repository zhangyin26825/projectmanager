package com.weijuju.iag.projectmanager.util;/**
 * Created by zhangyin on 2017/3/13.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhangyin
 * @create 2017-03-13
 */
public class ShellUtil {

    public static  String  executeShell(String command){
        try {
            String[] cmd = { "/bin/sh", "-c", command };
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
        return null;
    }

    public static void main(String[] args) {
        String s = ShellUtil.executeShell("echo hello world");
        System.out.println(s);
    }
}
