package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    //条件查询查询
    @Test
    public void findAll() {
        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        //设置条件对象
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");

        // cmsPage.setPageAliase("分类导航");

        //分页条件
        int page = 0;//从0开始
        int size = 10;//查询10条
        Pageable pageable = PageRequest.of(page, size);

        //创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);

        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all.getContent());
    }

    //分页查询
    @Test
    public void findPage() {
        //分页条件
        int page = 0;//从0开始
        int size = 10;//查询10条
        Pageable pageable = PageRequest.of(page, size);

        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);

    }

    //自定义查询条件
    @Test
    public void findBy() {

        CmsPage page = cmsPageRepository.findByPageName("10101.html");
        System.out.println(page);


    }

    @Autowired
    PageService pageService;

    //生产静态页面
    @Test
    public void getPageHtml() {
        String pageHtml = pageService.getPageHtml("5c46d29da9bce21fb0a99117");
        System.out.println(pageHtml);

    }


}



