package com.czmen.core.service.impl;

import org.apache.ibatis.session.SqlSession;

/**
 * 所有服务类的基类，用于注入SQLSession。
 * @author YANGYONG
 *
 */
public class BaseService {
    /**
     * 可写的sqlSession
     */
    protected SqlSession writableSQLSession;

    /**
     * 只读的sqlSession
     */
    protected SqlSession readonlySQLSession;

    public void setWritableSQLSession(SqlSession writableSQLSession) {
        this.writableSQLSession = writableSQLSession;
    }

    public void setReadonlySQLSession(SqlSession readonlySQLSession) {
        this.readonlySQLSession = readonlySQLSession;
    }

}
