package com.org.resources.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.util.Constant;
import com.org.resources.service.ResourcesService;

@Controller
@RequestMapping("/resourcesController")
public class ResourcesController {

    @Autowired
    public ResourcesService resourcesService;

    /**
     * 获取漫画的推广内容 (首页)
     *
     * @Title: getCartoonLv1
     * @author UniCode.
     * @date 2019年9月5日
     * @version V1.0
     */
    @RequestMapping(value = "/getCartoonLv1.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> getCartoonLv1(HttpServletRequest request) {
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("cur_page", Integer.parseInt(request.getParameter("cur_page")));// 起始页
        parm.put("page_size", Integer.parseInt(request.getParameter("page_size")));// 结束页
        return resourcesService.getCartoonLv1(parm);
    }

    /**
     * 获取漫画详情页
     *
     * @return Map
     */
    @RequestMapping(value = "/getCartoonLv2.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCartoonLv2(HttpServletRequest request) {
        String id = request.getParameter("id");
        return resourcesService.getCartoonLv2(id);
    }

    /**
     * 获取漫画阅读页
     *
     * @return
     */
    @RequestMapping(value = "/getCartoonLv3.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCartoonLv3(HttpServletRequest request) {
        Map<String, Object> parm = new HashMap<String, Object>();
        String id = request.getParameter("pornhub_cartoon_id");
        int cur_page = Integer.parseInt(request.getParameter("cur_page"));
        int page_size = Integer.parseInt(request.getParameter("page_size"));
        File file = new File(Constant.PORNHUB_CARTOON_IMG_URL + id);
        String pf = "/" + file.getParentFile().getParentFile().getName() + "/" + file.getParentFile().getName() + "/";
        File[] tempList = file.listFiles();
        if (tempList == null) {
            return parm;
        }
        for (int i = cur_page; i < tempList.length && i < page_size; i++) {
            parm.put("" + i, pf + id + "/" + tempList[i].getName());
        }
        return parm;
    }

    /**
     * 获取漫画全部页
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getCartoonLv4.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> getCartoonLv4(HttpServletRequest request) {
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("search", request.getParameter("search")); // 查詢條件
        parm.put("cur_page", Integer.parseInt(request.getParameter("cur_page")));// 起始页
        parm.put("page_size", Integer.parseInt(request.getParameter("page_size")));// 结束页
        return resourcesService.getCartoonLv4(parm);
    }

    /**
     * 获取视频全部页
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getVideoLv4.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getVideoLv4(HttpServletRequest request) {
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("search", request.getParameter("search")); // 查詢條件
        parm.put("cur_page", Integer.parseInt(request.getParameter("cur_page")));// 起始页
        parm.put("page_size", Integer.parseInt(request.getParameter("page_size")));// 结束页
        return resourcesService.getVideoLv4(parm);
    }

    /**
     * 获取视频详情页
     *
     * @return
     */
    @RequestMapping(value = "/getVideoLv2.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getVideoLv2(HttpServletRequest request) {
        String id = request.getParameter("id");
        return resourcesService.getVideoLv2(id);
    }

    /**
     * 根据视频ID读取所有的图片
     *
     * @return
     */
    @RequestMapping(value = "/getVideoLv2Info.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getVideoLv2Info(HttpServletRequest request) {
        Map<String, Object> parm = new HashMap<String, Object>();
        String id = request.getParameter("id");
        File file = new File(Constant.PORNHUB_VIDEO_IMG_URL + id);
        String pf = "/" + file.getParentFile().getParentFile().getName() + "/" + file.getParentFile().getName() + "/";
        File[] tempList = file.listFiles();
        if (tempList == null) {
            return parm;
        }
        for (int i = 0; i < tempList.length; i++) {
            parm.put("" + i, pf + id + "/" + tempList[i].getName());
        }
        return parm;
    }
}