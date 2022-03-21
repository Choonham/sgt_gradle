package com.sgt.test.service;

import com.sgt.test.vo.TestVo;
import org.springframework.stereotype.Service;

public interface TestService {
    public int countTestValue(TestVo testVo);
    void insertTest(TestVo testVo);
}
