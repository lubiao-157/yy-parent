package com.youyue.api.cms;

import com.youyue.framework.domain.cms.request.QueryPageRequest;
import com.youyue.framework.model.response.QueryResponseResult;

/**
 * 页面查询
 */
public interface CmsPageControllerApi {
    //条件分页查询
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest );
}
