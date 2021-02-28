package com.cy.dao.impl;

import com.cy.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public  abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /*
    * update 用来执行 Insert/Delete/Update语句
    *  如果返回-1，说明执行失败    返回其他表示影响的行数
    * */
    public int update(String sql,Object ...args){

        System.out.println("BaseDao程序在【" + Thread.currentThread().getName() + "】中");

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
    * 查询返回一个JavaBean的sql语句
    * type:返回的对象类型  sql:执行的sql语句     args:sql对应的参数值  <T>:返回的类型的泛型
    * */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            //返回查询结果
            return queryRunner.query(conn,sql, new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
     * 查询返回多个JavaBean的sql语句
     * type:返回的对象类型  sql:执行的sql语句     args:sql对应的参数值  <T>:返回的类型的泛型
     * */
    public <T> List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
     * 执行返回一行一列的sql语句
     *  sql:执行的sql语句     args:sql对应的参数值
     * */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection connection = JdbcUtils.getConnection();

        try {
           return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
