package com.weijuju.iag.projectmanager.dataobject;

import java.io.Serializable;

public class Project implements Serializable {
    private Integer id;

    private String projectname;

    private String domain;

    private String databaseName;

    private Integer redisdb;

    private String groupid;

    private String artifactid;

    private String svnRoot;

    private String archetype;

    private String domainIp;

    private Integer port;

    private String mvnDirName;

    private String dnsRecordId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName == null ? null : databaseName.trim();
    }

    public Integer getRedisdb() {
        return redisdb;
    }

    public void setRedisdb(Integer redisdb) {
        this.redisdb = redisdb;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getArtifactid() {
        return artifactid;
    }

    public void setArtifactid(String artifactid) {
        this.artifactid = artifactid == null ? null : artifactid.trim();
    }

    public String getSvnRoot() {
        return svnRoot;
    }

    public void setSvnRoot(String svnRoot) {
        this.svnRoot = svnRoot == null ? null : svnRoot.trim();
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype == null ? null : archetype.trim();
    }

    public String getDomainIp() {
        return domainIp;
    }

    public void setDomainIp(String domainIp) {
        this.domainIp = domainIp == null ? null : domainIp.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getMvnDirName() {
        return mvnDirName;
    }

    public void setMvnDirName(String mvnDirName) {
        this.mvnDirName = mvnDirName == null ? null : mvnDirName.trim();
    }

    public String getDnsRecordId() {
        return dnsRecordId;
    }

    public void setDnsRecordId(String dnsRecordId) {
        this.dnsRecordId = dnsRecordId == null ? null : dnsRecordId.trim();
    }
}