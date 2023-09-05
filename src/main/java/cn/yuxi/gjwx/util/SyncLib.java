package cn.yuxi.gjwx.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.system.SystemUtil;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author xchen
 */
public class SyncLib {

    private static Session session;
    private static ChannelSftp channelSftp;
    //只打印日志，不做上传删除操作（debug用）
    private static final Boolean onlyPrint = true;

    private static String ZZTW_URL = "/home/web/data/zztw";
    private static String ZZTW_LIB_URL = "/home/web/data/zztw/lib";
    private static String SERVER_URL = "101.43.157.72";

    public static void main(String[] args) throws Exception {
        //初始化ssh连接
        initChannel();
        updateJar();
//        updateLib();

    }

    public static void updateJar() throws Exception{
        try {
            //cd 到服务器上的jar包所在目录
            channelSftp.cd(ZZTW_URL);
            //将jar目录下的jar都ls出来，保存到oldJarList中
            Vector ls = channelSftp.ls(".");
            List<String> oldJarList = new ArrayList<>();
            for (int i = 0; i < ls.size(); i++) {
                ChannelSftp.LsEntry o = (ChannelSftp.LsEntry) ls.get(i);
                String filename = o.getFilename();
                if (filename.endsWith(".jar")) {
                    if (onlyPrint) {
                        channelSftp.rm(filename);
                    }
                    System.out.println("remove jar ==> " + filename);
                }
            }
            //这个是intellij idea中分离打包后的jar的路径, 大家可以直接改成自己本地的绝对路径
            String newJarPath = SystemUtil.get(SystemUtil.USER_DIR) + "/target/";
            //获取本地最新jar的列表
            List<String> newJarList = FileUtil.listFileNames(newJarPath);

            //对比新老jar列表，找出要新增的jar,删除的jar
            //上传新增的jar
            for (String addJarName : newJarList) {
                if (onlyPrint) {
                    channelSftp.put(newJarPath + addJarName, addJarName);
                }
                System.out.println("add jar ==> " + addJarName);
            }


        } finally {
            //关闭ssh连接
            closeChannel();
        }
    }

    public static void updateLib() throws Exception{
        try {
            //cd 到服务器上的jar包所在目录
            channelSftp.cd(ZZTW_LIB_URL);
            //将jar目录下的jar都ls出来，保存到oldJarList中
            Vector ls = channelSftp.ls(".");
            List<String> oldjarList = new ArrayList<>();
            for (int i = 0; i < ls.size(); i++) {
                ChannelSftp.LsEntry o = (ChannelSftp.LsEntry) ls.get(i);
                String filename = o.getFilename();
                if (filename.endsWith(".jar")) {
                    oldjarList.add(filename);
                }
            }
            //这个是intellij idea中分离打包后的jar的路径, 大家可以直接改成自己本地的绝对路径
            String newLibPath = SystemUtil.get(SystemUtil.USER_DIR) + "/target/lib/";
            //获取本地最新jar的列表
            List<String> newLibList = FileUtil.listFileNames(newLibPath);

            //对比新老jar列表，找出要新增的jar,删除的jar
            List<String> addLibList = addJarList(oldjarList, newLibList);
            List<String> removeLibList = removeJarList(oldjarList, newLibList);

            //上传新增的jar
            for (String addJarName : addLibList) {
                if (onlyPrint) {
                    channelSftp.put(newLibPath + addJarName, addJarName);
                }
                System.out.println("add lib/jar ==> " + addJarName);
            }

            //删除过期的jar
            for (String removeJarName : removeLibList) {
                if (onlyPrint) {
                    channelSftp.rm(removeJarName);
                }
                System.out.println("remove lib/jar ==> " + removeJarName);
            }
        } finally {
            //关闭ssh连接
            closeChannel();
        }
    }

    public static List<String> removeJarList(List<String> oldLibList, List<String> newLibList) {
        Set<String> newLibSet = new HashSet<>(newLibList);
        return oldLibList.stream().filter(item -> !newLibSet.contains(item)).collect(Collectors.toList());
    }

    public static List<String> addJarList(List<String> oldLibList, List<String> newLibList) {
        Set<String> oldLigSet = new HashSet<>(oldLibList);
        return newLibList.stream().filter(item -> !oldLigSet.contains(item)).collect(Collectors.toList());
    }

    public static void initChannel() throws JSchException {
        //声明JSCH对象
        JSch jSch = new JSch();
        //获取一个Linux会话
        session = jSch.getSession("songhongxing", SERVER_URL, 22);
        //设置登录密码
        session.setPassword("#HVn3Bu4m#Tf&$8k");
        //关闭key的检验
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        //连接Linux
        session.connect();
        //通过sftp的方式连接
        channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
    }

    private static void closeChannel() {
        if (channelSftp != null) {
            channelSftp.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}

