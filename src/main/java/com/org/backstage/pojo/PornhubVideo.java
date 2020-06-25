package com.org.backstage.pojo;

import java.io.Serializable;

public class PornhubVideo implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int				  pornhub_video_id;
	private String			  pornhub_video_name;
	private String			  pornhub_video_type;
	private String			  pornhub_video_sort;
	private String			  pornhub_video_img_url;
	private String			  pornhub_video_duration;
	private String			  pornhub_video_download;

	public PornhubVideo( )
	{
	}

	
	
	public int getPornhub_video_id()
	{
		return pornhub_video_id;
	}

	public void setPornhub_video_id( int pornhub_video_id )
	{
		this.pornhub_video_id = pornhub_video_id;
	}

	public String getPornhub_video_name()
	{
		return pornhub_video_name;
	}

	public void setPornhub_video_name( String pornhub_video_name )
	{
		this.pornhub_video_name = pornhub_video_name;
	}

	public String getPornhub_video_sort()
	{
		return pornhub_video_sort;
	}

	public void setPornhub_video_sort( String pornhub_video_sort )
	{
		this.pornhub_video_sort = pornhub_video_sort;
	}

	public String getPornhub_video_img_url()
	{
		return pornhub_video_img_url;
	}

	public void setPornhub_video_img_url( String pornhub_video_img_url )
	{
		this.pornhub_video_img_url = pornhub_video_img_url;
	}

	public String getPornhub_video_duration()
	{
		return pornhub_video_duration;
	}

	public void setPornhub_video_duration( String pornhub_video_duration )
	{
		this.pornhub_video_duration = pornhub_video_duration;
	}

	public String getPornhub_video_type()
	{
		return pornhub_video_type;
	}

	public void setPornhub_video_type( String pornhub_video_type )
	{
		this.pornhub_video_type = pornhub_video_type;
	}



	public String getPornhub_video_download()
	{
		return pornhub_video_download;
	}



	public void setPornhub_video_download( String pornhub_video_download )
	{
		this.pornhub_video_download = pornhub_video_download;
	}

}