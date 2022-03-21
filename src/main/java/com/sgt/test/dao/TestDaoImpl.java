package com.sgt.test.dao;

import com.sgt.test.vo.TestVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Repository("testDao")
public class TestDaoImpl implements TestDao{

    @Autowired
    SqlSession sqlSession;

    public int checkWork(TestVo testVo) {
        return sqlSession.selectOne("test.countTestValue", testVo);
    }
    public void insertTest(TestVo testVo){
        sqlSession.insert("test.insertTest", testVo);
    }
}
