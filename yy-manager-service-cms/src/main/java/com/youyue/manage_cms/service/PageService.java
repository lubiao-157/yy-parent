package com.youyue.manage_cms.service;


import com.youyue.framework.domain.cms.CmsPage;
import com.youyue.framework.domain.cms.request.QueryPageRequest;
import com.youyue.framework.domain.cms.response.CmsPageResult;
import com.youyue.framework.model.response.CommonCode;
import com.youyue.framework.model.response.QueryResponseResult;
import com.youyue.framework.model.response.QueryResult;
import com.youyue.framework.model.response.ResponseResult;
import com.youyue.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        if(queryPageRequest == null){//防止空指针异常
            queryPageRequest = new QueryPageRequest();
        }

        //构建匹配对象
        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        if(page <= 0){
            page = 1;
        }
        page = page - 1;

        if(size <= 0){
            size = 10;
        }
        CmsPage cmsPage = new CmsPage();
        if(StringUtils.isNotEmpty(queryPageRequest.getSiteId())){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        if(StringUtils.isNotEmpty(queryPageRequest.getPageAliase())){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        if(StringUtils.isNotEmpty(queryPageRequest.getTemplateId())){
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }

        Example<CmsPage> example = Example.of(cmsPage, matching);

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example,pageRequest);
        QueryResult queryResult = new QueryResult<>();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    public CmsPageResult add(CmsPage cmsPage){
        CmsPage cmsPage1 = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if(cmsPage1 == null){
            //cmsPage.setPageId(null);
            cmsPageRepository.save(cmsPage);
            return  new CmsPageResult(CommonCode.SUCCESS,cmsPage);
        }else {
           return  new CmsPageResult(CommonCode.FAIL,null);
        }
    }

    public CmsPage findById(String id){
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public CmsPageResult update(String id, CmsPage cmsPage){
        CmsPage one = findById(id);
        if(one != null){
            one.setTemplateId(cmsPage.getTemplateId());
            one.setPageAliase(cmsPage.getPageAliase());
            one.setSiteId(cmsPage.getSiteId());
            one.setPageName(cmsPage.getPageName());
            one.setDataUrl(cmsPage.getDataUrl());
            one.setHtmlFileId(cmsPage.getHtmlFileId());
            cmsPageRepository.save(one);
            return  new CmsPageResult(CommonCode.SUCCESS,one);
        }
        return new CmsPageResult(CommonCode.FAIL,null);
    }

    public ResponseResult delete(String id){
        Optional<CmsPage> op = cmsPageRepository.findById(id);
        if(op.isPresent()){
            cmsPageRepository.delete(op.get());
            return  new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
