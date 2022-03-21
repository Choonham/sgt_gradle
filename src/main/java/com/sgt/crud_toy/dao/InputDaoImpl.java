package com.sgt.crud_toy.dao;

import com.sgt.crud_toy.vo.InputVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inputDao")
public class InputDaoImpl implements InputDao{

    @Autowired
    SqlSession sqlSession;

    @Override
    public int insertInput(InputVo inputVo) throws Exception {
        return sqlSession.insert("input.insertInput", inputVo);
    }

    @Override
    public int updateInput(InputVo inputVo) throws Exception {
        return sqlSession.update("input.updateInput", inputVo);
    }

    @Override
    public int deleteInput(InputVo inputVo) throws Exception {
        return sqlSession.update("input.deleteInput", inputVo);
    }

    @Override
    public List<InputVo> getInputList(String inputIp) throws Exception {
        return sqlSession.selectList("input.getInputList", inputIp);

    }

    @Override
    public InputVo getInputDetail(int id) throws Exception {
        return null;
    }
}
