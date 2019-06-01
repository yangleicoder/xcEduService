package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

//查询页面集合
@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int")})
    public QueryResponseResult  findList(int page, int size, QueryPageRequest queryPageRequest);

    //添加页面
    @ApiOperation("添加页面")
    public CmsPageResult  add(CmsPage cmsPage);
    //根据id查找页面
    @ApiOperation("通过ID查询页面")
    public CmsPage findById(String id);
    //修改页面
    @ApiOperation("修改页面")
    public CmsPageResult edit(String id,CmsPage cmsPage);
    //删除页面
    @ApiOperation("通过id删除页面")
    public ResponseResult delete(String id);

    @ApiOperation("发布页面")
    public ResponseResult post(String pageId);
}
