package com.org.resources.service;

import java.util.List;
import java.util.Map;

public interface ResourcesService
{
	public List<Map<String, Object>> getCartoonLv1( Map<String, Object> map );

	public Map<String, Object> getCartoonLv2( String id );

	public List<Map<String, Object>> getCartoonLv3( Map<String, Object> map );

	public List<Map<String, Object>> getCartoonLv4( Map<String, Object> map );

	public List<Map<String, Object>> getVideoLv4( Map<String, Object> map );

	public Map<String, Object> getVideoLv2( String id );

}
