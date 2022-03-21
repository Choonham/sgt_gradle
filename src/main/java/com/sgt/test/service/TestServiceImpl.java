package com.sgt.test.service;

import com.sgt.test.dao.TestDao;
import com.sgt.test.vo.TestVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class TestServiceImpl implements TestService{
    @Resource(name="testDao")
    private TestDao testDao;

    public int countTestValue(TestVo testVo){
        return testDao.checkWork(testVo);
    }

    public void insertTest(TestVo testVo) {
        testDao.insertTest(testVo);
    }
}
