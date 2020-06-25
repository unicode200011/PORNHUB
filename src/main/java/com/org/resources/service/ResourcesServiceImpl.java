package com.org.resources.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.resources.dao.ResourcesDao;

@Service("ResourcesService")
public class ResourcesServiceImpl implements ResourcesService
{

	@Autowired
	public ResourcesDao resourcesDao;

	@Override
	public List<Map<String, Object>> getCartoonLv1( Map<String, Object> map )
	{
		return resourcesDao.getCartoonLv1(map);
	}

	@Override
	public Map<String, Object> getCartoonLv2( String id )
	{

		return resourcesDao.getCartoonLv2(id);
	}

	@Override
	public List<Map<String, Object>> getCartoonLv3( Map<String, Object> map )
	{
		return resourcesDao.getCartoonLv3(map);
	}

	@Override
	public List<Map<String, Object>> getCartoonLv4( Map<String, Object> map )
	{
		return resourcesDao.getCartoonLv4(map);

	}

	@Override
	public List<Map<String, Object>> getVideoLv4( Map<String, Object> map )
	{
		return resourcesDao.getVideoLv4(map);
	}

	@Override
	public Map<String, Object> getVideoLv2( String id )
	{
		return resourcesDao.getVideoLv2(id);

	}
}