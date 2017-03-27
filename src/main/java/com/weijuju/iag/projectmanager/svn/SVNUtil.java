package com.weijuju.iag.projectmanager.svn;/**
 * Created by zhangyin on 2017/3/15.
 */

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import java.io.File;

/**
 * @author zhangyin
 * @create 2017-03-15
 */
public class SVNUtil {

    public static void setupLibrary() {
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
    }

    /**
     * 验证登录svn
     */
    public static SVNClientManager authSvn(String svnRoot, String username,
                                           String password) {
        // 初始化版本库
        setupLibrary();

        // 创建库连接
        SVNRepository repository = null;
        try {
            repository = SVNRepositoryFactory.create(SVNURL
                    .parseURIEncoded(svnRoot));
        } catch (SVNException e) {
            return null;
        }

        // 身份验证
        ISVNAuthenticationManager authManager = SVNWCUtil
                     .createDefaultAuthenticationManager(username, password);

        // 创建身份验证管理器
        repository.setAuthenticationManager(authManager);

        DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(true);
        SVNClientManager clientManager = SVNClientManager.newInstance(options,
                authManager);
        return clientManager;
    }

    /**
     * Make directory in svn repository
     * @param clientManager
     * @param url
     *          eg: http://svn.ambow.com/wlpt/bsp/trunk
     * @param commitMessage
     * @return
     * @throws SVNException
     */
    public static SVNCommitInfo makeDirectory(SVNClientManager clientManager,
                                              SVNURL url, String commitMessage) {
        try {
            return clientManager.getCommitClient().doMkDir(
                    new SVNURL[] { url }, commitMessage);
        } catch (SVNException e) {
        }
        return null;
    }

    /**
     *  LocalPath 是一个目录   把 目录中的文件复制到 对应的  dstURL 中，不会包含目录本身
     *
     * Imports an unversioned directory into a repository location denoted by a
     *  destination URL
     * @param clientManager
     * @param localPath
     *          a local unversioned directory or singal file that will be imported into a
     *          repository;
     * @param dstURL
     *          a repository location where the local unversioned directory/file will be
     *          imported into
     * @param commitMessage
     * @param isRecursive 递归
     * @return
     */
    public static SVNCommitInfo importDirectory(SVNClientManager clientManager,
                                                File localPath, SVNURL dstURL, String commitMessage,
                                                boolean isRecursive) {
        try {
            return clientManager.getCommitClient().doImport(localPath, dstURL,
                    commitMessage, null, true, true,
                    SVNDepth.fromRecurse(isRecursive));
        } catch (SVNException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            String svnUrl="svn://10.170.27.248/recreation/iag/web/anta/weijuju-iag-anta-newshoes";
            File file=new File("D:\\testSvnImportDir");
            SVNClientManager svnClientManager = SVNUtil.authSvn(svnUrl, "zhangyin", "alkdf#$!dafadfda");
            SVNUtil.importDirectory(svnClientManager,file,SVNURL.parseURIEncoded(svnUrl),"新增目录",true);
        } catch (SVNException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
