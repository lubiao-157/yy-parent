package com.youyue.manage_cms.controller;

import com.youyue.api.cms.CmsTemplateControllerApi;
import com.youyue.framework.model.response.QueryResponseResult;
import com.youyue.manage_cms.dao.CmsTemplateRepository;
import com.youyue.manage_cms.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/template")
public class CmsTempalteController implements CmsTemplateControllerApi {

    @Autowired
    private TemplateService templateService;


    @Override
    @GetMapping("/findAll")
    public QueryResponseResult findAll() {
        return templateService.findAll();
    }
}
