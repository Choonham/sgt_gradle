package com.sgt.crud_toy.service;

import com.sgt.crud_toy.vo.InputVo;

import java.util.List;

public interface InputService {
    int insertInput(InputVo inputVo)throws Exception;

    int updateInput(InputVo inputVo)throws Exception;

    int deleteInput(InputVo inputVo)throws Exception;

    List<InputVo> getInputList(String inputIp)throws Exception;

    InputVo getInputDetail(int id)throws Exception;

}
