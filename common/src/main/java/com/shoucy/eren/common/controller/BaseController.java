package com.shoucy.eren.common.controller;

import com.mybatisflex.core.paginate.Page;
import com.shoucy.eren.common.util.Convert;
import com.shoucy.eren.common.util.ServletUtils;

/**
 * controller基本功能
 *
 * @author shoucy
 */
public class BaseController {

    // /**
    // * 将前台传递过来的日期格式的字符串，自动转化为Date类型
    // */
    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    // // Date 类型转换
    // binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
    // @Override
    // public void setAsText(String text) {
    // setValue(DateUtils.parseDate(text));
    // }
    // });
    // }

    /**
     * 获得分页信息, 没有取到则使用默认值（可配置，参考mybatis-flex文档）
     */
    protected <T> Page<T> getPage() {
        Page<T> page = new Page<>();
        page.setPageNumber(Convert.toLong(ServletUtils.getParameter("pageNum"), page.getPageNumber()));
        page.setPageSize(Convert.toLong(ServletUtils.getParameter("pageSize"), page.getPageSize()));
        // 数据总数会在页面第一次查询时获得，之后翻页时传递此参数可减少count（*）次数以提升效率。
        page.setTotalRow(Convert.toLong(ServletUtils.getParameter("totalRow"), page.getTotalRow()));
        return page;
    }

    /**
     * 从Servlet取分页数据，并调用pageHelper分页功能<br>
     * 接收pageNum页码，pageSize每页数量，orderBy分页条件<br>
     * orderBy举例：age、age desc<br>
     * reasonable默认为true，为false时，关闭分页自动合理化。
     */
    // protected void startPage() {
    //
    // String orderBy = ServletUtils.getParameter("orderBy");
    // Validator.validateSqlColumn(orderBy);
    // // reasonable为true时，pageNum大于最大页数时，PageHelper会自动将pageNum设为最大页数。
    // Boolean reasonable = ServletUtils.getParameterToBool("reasonable");
    // if (reasonable == null) {
    // reasonable = Boolean.TRUE;
    // }
    // PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    // }

    // /**
    // * 获取用户缓存信息
    // */
    // public LoginUser getLoginUser() {
    // return SecurityUtils.getLoginUser();
    // }
    //
    // /**
    // * 获取登录用户id
    // */
    // public Long getUserId() {
    // return getLoginUser().getUserId();
    // }
    //
    // /**
    // * 获取登录部门id
    // */
    // public String getDeptId() {
    // return getLoginUser().getDeptId();
    // }
    //
    // /**
    // * 获取登录用户名
    // */
    // public String getUsername() {
    // return getLoginUser().getUsername();
    // }
    //
    // /**
    // * 获取登录用户名
    // */
    // public String getNickName() {
    // return getLoginUser().getUser().getNickName();
    // }

}
