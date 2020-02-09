package com.youyue.manage_cms.controller;

import com.youyue.api.cms.CmsSiteControllerApi;
import com.youyue.framework.model.response.QueryResponseResult;
import com.youyue.manage_cms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {

    @Autowired
    private SiteService siteService;

    @Override
    @GetMapping("/findAll")
    public QueryResponseResult findAll() {
        return siteService.findAll();
    }
}
