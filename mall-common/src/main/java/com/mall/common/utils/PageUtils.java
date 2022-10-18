package com.mall.common.utils;

import com.github.pagehelper.PageHelper;
import com.mall.common.core.page.PageDomain;
import com.mall.common.core.page.TableSupport;
import com.mall.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 *
 * @author ruoyi
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        // 根据request 的数据 构建分页对象( 只从request 中取数据，不对数据做任何处理 )
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        //  检查获取的数据，防止sql注入
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
