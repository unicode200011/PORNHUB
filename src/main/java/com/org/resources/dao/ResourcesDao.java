package com.org.resources.dao;

import java.util.List;
import java.util.Map;

import com.common.base.MyBatisRepository;

@MyBatisRepository
public interface ResourcesDao
{

	public List<Map<String, Object>> getCartoonLv1( Map<String, Object> map );

	public Map<String, Object> getCartoonLv2( String id );

	public List<Map<String, Object>> getCartoonLv3( Map<String, Object> map );
	
	public List<Map<String, Object>> getCartoonLv4( Map<String, Object> map );

	public List<Map<String, Object>> getVideoLv4( Map<String, Object> map );

	public Map<String, Object> getVideoLv2( String id );

	
}