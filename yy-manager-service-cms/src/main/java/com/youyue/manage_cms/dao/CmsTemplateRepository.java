package com.youyue.manage_cms.dao;

import com.youyue.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateRepository  extends MongoRepository<CmsTemplate ,String> {
}
