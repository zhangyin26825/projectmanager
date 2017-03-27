package com.weijuju.iag.projectmanager.util;/**
 * Created by zhangyin on 2017/3/14.
 */

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

/** 端口号检测
 *
 * @author zhangyin
 * @create 2017-03-14
 */
public class PortUtil {

    private static void bindPort(String host, int port) throws Exception {
        Socket s = new Socket();
        s.bind(new InetSocketAddress(host, port));
        s.close();
    }
    //检测端口号 有没有被占用
    public static boolean isPortAvailable(int port) {
        Socket s = new Socket();
        try {
            bindPort("0.0.0.0", port);
            bindPort(InetAddress.getLocalHost().getHostAddress(), port);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Integer  getAvailablePort(){
        while(true) {
            Random random = new Random();
            Integer i = random.nextInt(5700) + 300;
            Integer port = i *10+ 7;
           if(isPortAvailable(port)){
                return port;
           }
        }
    }


}
