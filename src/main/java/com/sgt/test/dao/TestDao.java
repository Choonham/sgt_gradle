package com.sgt.test.dao;

import com.sgt.test.vo.TestVo;
import org.springframework.stereotype.Repository;

public interface TestDao {
    public int checkWork(TestVo testVo);
    void insertTest(TestVo testVo);
}
