package com.youyue.manage_cms.service;


import com.youyue.framework.domain.cms.CmsPage;
import com.youyue.framework.domain.cms.request.QueryPageRequest;
import com.youyue.framework.model.response.CommonCode;
import com.youyue.framework.model.response.QueryResponseResult;
import com.youyue.framework.model.response.QueryResult;
import com.youyue.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;
    /**
     *
     * @param page 页码
     * @param size 每页显示条数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList( int page,  int size, QueryPageRequest queryPageRequest) {
        if(page <= 0){
            page = 1;
        }
        page = page - 1;

        if(size <= 0){
            size = 10;
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageRequest);
        QueryResult queryResult = new QueryResult<>();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
