package com.youyue.manage_cms.dao;

import com.youyue.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void  test1(){//查询所有
        List<CmsPage> list = cmsPageRepository.findAll();
        System.out.println(list);
    }
    @Test
    public void test2(){//分页查询
        Pageable p = PageRequest.of(1,5);
        Page<CmsPage> page = cmsPageRepository.findAll(p);
        System.out.println(page);
    }

    @Test
    public void test3(){
        //修改
        Optional<CmsPage> optional = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if(optional.isPresent()){
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("测试");
            cmsPageRepository.save(cmsPage);
        }
    }

    @Test
    public void  test4(){//简单条件查询
        CmsPage cmsPage = cmsPageRepository.findByPageName("index2.html");
        System.out.println(cmsPage);
    }

    @Test
    public void test5(){//添加
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageAliase("测试添加");
        cmsPage.setDataUrl("www.baidu.com");
        cmsPage.setPageName("抬头");
        cmsPageRepository.save(cmsPage);
    }
    @Test//删除
    public void test6(){
        cmsPageRepository.deleteById("5e3a67d73043771958c8c0c7");
    }
}
