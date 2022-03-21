package com.sgt.crud_toy.dao;

import com.sgt.crud_toy.vo.InputVo;

import java.util.List;

public interface InputDao {
    int insertInput(InputVo inputVo)throws Exception;

    int updateInput(InputVo inputVo)throws Exception;

    int deleteInput(InputVo inputVo)throws Exception;

    List<InputVo> getInputList(String inputIp)throws Exception;

    InputVo getInputDetail(int id)throws Exception;

}
