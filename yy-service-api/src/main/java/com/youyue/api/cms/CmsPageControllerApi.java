package com.youyue.api.cms;

import com.youyue.framework.domain.cms.CmsPage;
import com.youyue.framework.domain.cms.request.QueryPageRequest;
import com.youyue.framework.domain.cms.response.CmsPageResult;
import com.youyue.framework.model.response.QueryResponseResult;
import com.youyue.framework.model.response.ResponseResult;

/**
 * 页面查询
 */
public interface CmsPageControllerApi {
    //条件分页查询
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest );

    public CmsPageResult add(CmsPage cmsPage);

    public CmsPage findById(String id);

    public CmsPageResult update(String id , CmsPage cmsPage);

    public ResponseResult delete(String id);
}
