package com.org.backstage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backstage.dao.ResManageDao;
import com.org.backstage.pojo.PornhubCard;
import com.org.backstage.pojo.PornhubCartoon;
import com.org.backstage.pojo.PornhubCartoonInfo;
import com.org.backstage.pojo.PornhubVideo;

@Service("ResManageServiceImpl")
public class ResManageServiceImpl implements ResManageService
{

	@Autowired
	ResManageDao resManageDao;

	@Override
	public Integer insertRes( PornhubCartoonInfo pornhubCartoonInfo )
	{
		return resManageDao.insertRes(pornhubCartoonInfo);
	}

	@Override
	public Integer insertCartoon( PornhubCartoon pornhubCartoon )
	{
		return resManageDao.insertCartoon(pornhubCartoon);
	}

	@Override
	public Integer insertCard( PornhubCard pornhubCard )
	{
		return resManageDao.insertCard(pornhubCard);
	}

	@Override
	public Integer insertVideo( PornhubVideo pornhubVideo )
	{
		return resManageDao.insertVideo(pornhubVideo);
	}

}
