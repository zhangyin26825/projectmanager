package com.weijuju.iag.projectmanager.util;/**
 * Created by zhangyin on 2017/3/13.
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangyin
 * @create 2017-03-13
 */
public class DirectoryCleanUtil {

    /**
     * 清空目录下的所有文件  该目录依然存在
     * @param dir   要删除的目录
     */
    public static  void  cleanDirectory(String dir)  {
        File f=new File(dir);
        try {
            FileUtils.cleanDirectory(f);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("清空目录");
        } finally {
        }
    }
}
