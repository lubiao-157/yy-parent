package com.youyue.manage_cms.service;

import com.youyue.framework.domain.cms.CmsSite;
import com.youyue.framework.model.response.CommonCode;
import com.youyue.framework.model.response.QueryResponseResult;
import com.youyue.framework.model.response.QueryResult;
import com.youyue.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    private CmsSiteRepository cmsSiteRepository;

    public QueryResponseResult findAll(){
        List<CmsSite> list = cmsSiteRepository.findAll();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);
        queryResult.setTotal(list.size());
        return  new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
