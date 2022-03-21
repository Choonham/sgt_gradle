package com.sgt.crud_toy.service;

import com.sgt.crud_toy.dao.InputDao;
import com.sgt.crud_toy.vo.InputVo;
import jdk.internal.util.xml.impl.Input;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InputServiceImpl implements InputService{
    @Resource(name="inputDao")
    private InputDao inputDao;
    @Override
    public int insertInput(InputVo inputVo) throws Exception {
        return inputDao.insertInput(inputVo);
    }

    @Override
    public int updateInput(InputVo inputVo) throws Exception {
        return inputDao.updateInput(inputVo);
    }

    @Override
    public int deleteInput(InputVo inputVo) throws Exception {
        return inputDao.deleteInput(inputVo);
    }

    @Override
    public List<InputVo> getInputList(String inputIp) throws Exception {
        return inputDao.getInputList(inputIp);
    }

    @Override
    public InputVo getInputDetail(int id) throws Exception {
        return null;
    }
}
