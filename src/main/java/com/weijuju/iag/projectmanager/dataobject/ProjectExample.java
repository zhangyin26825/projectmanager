package com.weijuju.iag.projectmanager.dataobject;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNull() {
            addCriterion("projectName is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectName is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectName =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectName <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectName >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectName >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectName <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectName <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectName like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectName not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectName in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectName not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectName between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectName not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameIsNull() {
            addCriterion("database_name is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameIsNotNull() {
            addCriterion("database_name is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameEqualTo(String value) {
            addCriterion("database_name =", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameNotEqualTo(String value) {
            addCriterion("database_name <>", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameGreaterThan(String value) {
            addCriterion("database_name >", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("database_name >=", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameLessThan(String value) {
            addCriterion("database_name <", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameLessThanOrEqualTo(String value) {
            addCriterion("database_name <=", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameLike(String value) {
            addCriterion("database_name like", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameNotLike(String value) {
            addCriterion("database_name not like", value, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameIn(List<String> values) {
            addCriterion("database_name in", values, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameNotIn(List<String> values) {
            addCriterion("database_name not in", values, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameBetween(String value1, String value2) {
            addCriterion("database_name between", value1, value2, "databaseName");
            return (Criteria) this;
        }

        public Criteria andDatabaseNameNotBetween(String value1, String value2) {
            addCriterion("database_name not between", value1, value2, "databaseName");
            return (Criteria) this;
        }

        public Criteria andRedisdbIsNull() {
            addCriterion("redisDB is null");
            return (Criteria) this;
        }

        public Criteria andRedisdbIsNotNull() {
            addCriterion("redisDB is not null");
            return (Criteria) this;
        }

        public Criteria andRedisdbEqualTo(Integer value) {
            addCriterion("redisDB =", value, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbNotEqualTo(Integer value) {
            addCriterion("redisDB <>", value, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbGreaterThan(Integer value) {
            addCriterion("redisDB >", value, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("redisDB >=", value, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbLessThan(Integer value) {
            addCriterion("redisDB <", value, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbLessThanOrEqualTo(Integer value) {
            addCriterion("redisDB <=", value, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbIn(List<Integer> values) {
            addCriterion("redisDB in", values, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbNotIn(List<Integer> values) {
            addCriterion("redisDB not in", values, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbBetween(Integer value1, Integer value2) {
            addCriterion("redisDB between", value1, value2, "redisdb");
            return (Criteria) this;
        }

        public Criteria andRedisdbNotBetween(Integer value1, Integer value2) {
            addCriterion("redisDB not between", value1, value2, "redisdb");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNull() {
            addCriterion("groupId is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupId is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(String value) {
            addCriterion("groupId =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(String value) {
            addCriterion("groupId <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(String value) {
            addCriterion("groupId >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(String value) {
            addCriterion("groupId >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(String value) {
            addCriterion("groupId <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(String value) {
            addCriterion("groupId <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLike(String value) {
            addCriterion("groupId like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotLike(String value) {
            addCriterion("groupId not like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<String> values) {
            addCriterion("groupId in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<String> values) {
            addCriterion("groupId not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(String value1, String value2) {
            addCriterion("groupId between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(String value1, String value2) {
            addCriterion("groupId not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andArtifactidIsNull() {
            addCriterion("artifactId is null");
            return (Criteria) this;
        }

        public Criteria andArtifactidIsNotNull() {
            addCriterion("artifactId is not null");
            return (Criteria) this;
        }

        public Criteria andArtifactidEqualTo(String value) {
            addCriterion("artifactId =", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidNotEqualTo(String value) {
            addCriterion("artifactId <>", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidGreaterThan(String value) {
            addCriterion("artifactId >", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidGreaterThanOrEqualTo(String value) {
            addCriterion("artifactId >=", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidLessThan(String value) {
            addCriterion("artifactId <", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidLessThanOrEqualTo(String value) {
            addCriterion("artifactId <=", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidLike(String value) {
            addCriterion("artifactId like", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidNotLike(String value) {
            addCriterion("artifactId not like", value, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidIn(List<String> values) {
            addCriterion("artifactId in", values, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidNotIn(List<String> values) {
            addCriterion("artifactId not in", values, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidBetween(String value1, String value2) {
            addCriterion("artifactId between", value1, value2, "artifactid");
            return (Criteria) this;
        }

        public Criteria andArtifactidNotBetween(String value1, String value2) {
            addCriterion("artifactId not between", value1, value2, "artifactid");
            return (Criteria) this;
        }

        public Criteria andSvnRootIsNull() {
            addCriterion("svn_root is null");
            return (Criteria) this;
        }

        public Criteria andSvnRootIsNotNull() {
            addCriterion("svn_root is not null");
            return (Criteria) this;
        }

        public Criteria andSvnRootEqualTo(String value) {
            addCriterion("svn_root =", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootNotEqualTo(String value) {
            addCriterion("svn_root <>", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootGreaterThan(String value) {
            addCriterion("svn_root >", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootGreaterThanOrEqualTo(String value) {
            addCriterion("svn_root >=", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootLessThan(String value) {
            addCriterion("svn_root <", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootLessThanOrEqualTo(String value) {
            addCriterion("svn_root <=", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootLike(String value) {
            addCriterion("svn_root like", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootNotLike(String value) {
            addCriterion("svn_root not like", value, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootIn(List<String> values) {
            addCriterion("svn_root in", values, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootNotIn(List<String> values) {
            addCriterion("svn_root not in", values, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootBetween(String value1, String value2) {
            addCriterion("svn_root between", value1, value2, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andSvnRootNotBetween(String value1, String value2) {
            addCriterion("svn_root not between", value1, value2, "svnRoot");
            return (Criteria) this;
        }

        public Criteria andArchetypeIsNull() {
            addCriterion("archetype is null");
            return (Criteria) this;
        }

        public Criteria andArchetypeIsNotNull() {
            addCriterion("archetype is not null");
            return (Criteria) this;
        }

        public Criteria andArchetypeEqualTo(String value) {
            addCriterion("archetype =", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeNotEqualTo(String value) {
            addCriterion("archetype <>", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeGreaterThan(String value) {
            addCriterion("archetype >", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeGreaterThanOrEqualTo(String value) {
            addCriterion("archetype >=", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeLessThan(String value) {
            addCriterion("archetype <", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeLessThanOrEqualTo(String value) {
            addCriterion("archetype <=", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeLike(String value) {
            addCriterion("archetype like", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeNotLike(String value) {
            addCriterion("archetype not like", value, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeIn(List<String> values) {
            addCriterion("archetype in", values, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeNotIn(List<String> values) {
            addCriterion("archetype not in", values, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeBetween(String value1, String value2) {
            addCriterion("archetype between", value1, value2, "archetype");
            return (Criteria) this;
        }

        public Criteria andArchetypeNotBetween(String value1, String value2) {
            addCriterion("archetype not between", value1, value2, "archetype");
            return (Criteria) this;
        }

        public Criteria andDomainIpIsNull() {
            addCriterion("domain_ip is null");
            return (Criteria) this;
        }

        public Criteria andDomainIpIsNotNull() {
            addCriterion("domain_ip is not null");
            return (Criteria) this;
        }

        public Criteria andDomainIpEqualTo(String value) {
            addCriterion("domain_ip =", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpNotEqualTo(String value) {
            addCriterion("domain_ip <>", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpGreaterThan(String value) {
            addCriterion("domain_ip >", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpGreaterThanOrEqualTo(String value) {
            addCriterion("domain_ip >=", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpLessThan(String value) {
            addCriterion("domain_ip <", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpLessThanOrEqualTo(String value) {
            addCriterion("domain_ip <=", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpLike(String value) {
            addCriterion("domain_ip like", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpNotLike(String value) {
            addCriterion("domain_ip not like", value, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpIn(List<String> values) {
            addCriterion("domain_ip in", values, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpNotIn(List<String> values) {
            addCriterion("domain_ip not in", values, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpBetween(String value1, String value2) {
            addCriterion("domain_ip between", value1, value2, "domainIp");
            return (Criteria) this;
        }

        public Criteria andDomainIpNotBetween(String value1, String value2) {
            addCriterion("domain_ip not between", value1, value2, "domainIp");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameIsNull() {
            addCriterion("mvn_dir_name is null");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameIsNotNull() {
            addCriterion("mvn_dir_name is not null");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameEqualTo(String value) {
            addCriterion("mvn_dir_name =", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameNotEqualTo(String value) {
            addCriterion("mvn_dir_name <>", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameGreaterThan(String value) {
            addCriterion("mvn_dir_name >", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameGreaterThanOrEqualTo(String value) {
            addCriterion("mvn_dir_name >=", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameLessThan(String value) {
            addCriterion("mvn_dir_name <", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameLessThanOrEqualTo(String value) {
            addCriterion("mvn_dir_name <=", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameLike(String value) {
            addCriterion("mvn_dir_name like", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameNotLike(String value) {
            addCriterion("mvn_dir_name not like", value, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameIn(List<String> values) {
            addCriterion("mvn_dir_name in", values, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameNotIn(List<String> values) {
            addCriterion("mvn_dir_name not in", values, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameBetween(String value1, String value2) {
            addCriterion("mvn_dir_name between", value1, value2, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andMvnDirNameNotBetween(String value1, String value2) {
            addCriterion("mvn_dir_name not between", value1, value2, "mvnDirName");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdIsNull() {
            addCriterion("dns_record_Id is null");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdIsNotNull() {
            addCriterion("dns_record_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdEqualTo(String value) {
            addCriterion("dns_record_Id =", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdNotEqualTo(String value) {
            addCriterion("dns_record_Id <>", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdGreaterThan(String value) {
            addCriterion("dns_record_Id >", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("dns_record_Id >=", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdLessThan(String value) {
            addCriterion("dns_record_Id <", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdLessThanOrEqualTo(String value) {
            addCriterion("dns_record_Id <=", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdLike(String value) {
            addCriterion("dns_record_Id like", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdNotLike(String value) {
            addCriterion("dns_record_Id not like", value, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdIn(List<String> values) {
            addCriterion("dns_record_Id in", values, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdNotIn(List<String> values) {
            addCriterion("dns_record_Id not in", values, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdBetween(String value1, String value2) {
            addCriterion("dns_record_Id between", value1, value2, "dnsRecordId");
            return (Criteria) this;
        }

        public Criteria andDnsRecordIdNotBetween(String value1, String value2) {
            addCriterion("dns_record_Id not between", value1, value2, "dnsRecordId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}