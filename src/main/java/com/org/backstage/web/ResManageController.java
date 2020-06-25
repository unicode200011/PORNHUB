package com.org.backstage.web;

import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.util.CommonUtil;
import com.org.backstage.pojo.PornhubCard;
import com.org.backstage.pojo.PornhubCartoon;
import com.org.backstage.pojo.PornhubCartoonInfo;
import com.org.backstage.pojo.PornhubVideo;
import com.org.backstage.service.ResManageService;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/resManageController")
public class ResManageController
{

	@Autowired
	public ResManageService resManageService;

	@RequestMapping(value = "/insertVideo.do", method = RequestMethod.POST)
	@ResponseBody
	public int insertVideo( HttpServletRequest request, PornhubVideo pornhubVideo )
	{
		pornhubVideo.setPornhub_video_name(request.getParameter("pornhub_video_name"));
		pornhubVideo.setPornhub_video_img_url(request.getParameter("pornhub_video_img_url"));
		pornhubVideo.setPornhub_video_duration(request.getParameter("pornhub_video_duration"));
		pornhubVideo.setPornhub_video_sort(request.getParameter("pornhub_video_sort"));
		pornhubVideo.setPornhub_video_type(request.getParameter("pornhub_video_type"));
		pornhubVideo.setPornhub_video_download(request.getParameter("pornhub_video_download"));

		resManageService.insertVideo(pornhubVideo);
		return pornhubVideo.getPornhub_video_id();
	}

	@RequestMapping(value = "/insertCard.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> insertCard( HttpServletRequest request, PornhubCard pornhubCard ) throws NoSuchAlgorithmException
	{
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		Integer card_1 = Integer.parseInt(request.getParameter("card_1")); // 充值卡数量
		String card_2 = request.getParameter("card_2"); // 充值卡类型

		for (int i = 0; i < card_1; i++)
		{
			Map<String, Object> parm = new HashMap<String, Object>();
			Date date = new Date();
			String context = String.valueOf(date.getTime());
			String rand = String.valueOf(Math.random());
			StringBuffer cardNumber = CommonUtil.cardMD5(context); // 生成卡号
			StringBuffer cardPassword = CommonUtil.cardMD5(rand); // 生成卡密
			pornhubCard.setPornhub_card_number(cardNumber.toString());
			pornhubCard.setPornhub_card_password(cardPassword.toString());
			pornhubCard.setPornhub_card_type(card_2);
			resManageService.insertCard(pornhubCard);
			parm.put("pornhub_card_number", cardNumber.toString());
			parm.put("pornhub_card_password", cardPassword.toString());
			res.add(parm);
		}

		return res;

	}

	/**
	 * 插入漫画详情
	 * 
	 * @param request
	 * @param pornhubCartoonInfo
	 * @return
	 */
	@RequestMapping(value = "/insertRes.do", method = RequestMethod.POST)
	@ResponseBody
	public int insertRes( HttpServletRequest request, PornhubCartoonInfo pornhubCartoonInfo )
	{

		String pornhub_cartoon_id = request.getParameter("pornhub_cartoon_id"); // 资源关联表ID
		String fileName = request.getParameter("fileName");// 文件存放详细地址 '/res/mhinfo/?/
		String number = request.getParameter("number");// 遍历的次数
		String format = request.getParameter("format");// 命名格式
		String imgFormat = request.getParameter("imgFormat"); // 图片格式
		DecimalFormat df = new DecimalFormat(format);// 整数不足X前面+0
		// fileName + format + number

		for (int i = 0; i < Integer.parseInt(number); i++)
		{
			String pornhub_cartoon_info_url = fileName + df.format(i + 1) + "." + imgFormat;
			pornhubCartoonInfo.setPornhubCartoonId(Integer.parseInt(pornhub_cartoon_id));
			pornhubCartoonInfo.setPornhubCartoonInfoName(df.format(i));
			pornhubCartoonInfo.setPornhubCartoonInfoUrl(pornhub_cartoon_info_url);
			resManageService.insertRes(pornhubCartoonInfo);
		}
		return pornhubCartoonInfo.getPornhubCartoonInfoId();
	}

	/**
	 * 插入漫画封面
	 * 
	 * @param request
	 * @param pornhubCartoon
	 * @return
	 */
	@RequestMapping(value = "/insertCartoon.do", method = RequestMethod.POST)
	@ResponseBody
	public int insertCartoon( HttpServletRequest request, PornhubCartoon pornhubCartoon )
	{
		pornhubCartoon.setPornhubCartoonName(request.getParameter("pornhub_cartoon_name"));
		pornhubCartoon.setPornhubCartoonAuthor(request.getParameter("pornhub_cartoon_author"));
		pornhubCartoon.setPornhubCartoonImgUrl(request.getParameter("pornhub_cartoon_img_url"));
		pornhubCartoon.setPornhubCartoonPages(Integer.parseInt(request.getParameter("pornhub_cartoon_pages")));
		pornhubCartoon.setPornhubCartoonSort(request.getParameter("pornhub_cartoon_sort"));
		pornhubCartoon.setPornhubCartoonType(request.getParameter("pornhub_cartoon_type"));

		resManageService.insertCartoon(pornhubCartoon);
		return pornhubCartoon.getPornhubCartoonId();
	}


	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  upload(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> resp = new HashMap<String, Object>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		return resp;
	}


}