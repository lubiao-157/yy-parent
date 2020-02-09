package com.youyue.manage_cms.dao;

import com.youyue.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 页面查询的dao
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

    /**
     * 分页查询
     * @param pageName  //按照页面名称查询
     * @return
     */
    CmsPage findByPageName(String pageName);

    public CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);
}
