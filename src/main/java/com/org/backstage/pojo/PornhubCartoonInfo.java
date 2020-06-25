package com.org.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

public class PornhubCartoonInfo implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int	 pornhubCartoonInfoId;
	private Date createTimestamp;

	private int pornhubCartoonId;

	private String pornhubCartoonInfoName;

	private String pornhubCartoonInfoUrl;

	public PornhubCartoonInfo( )
	{
	}

	public int getPornhubCartoonInfoId()
	{
		return this.pornhubCartoonInfoId;
	}

	public void setPornhubCartoonInfoId( int pornhubCartoonInfoId )
	{
		this.pornhubCartoonInfoId = pornhubCartoonInfoId;
	}

	public Date getCreateTimestamp()
	{
		return this.createTimestamp;
	}

	public void setCreateTimestamp( Date createTimestamp )
	{
		this.createTimestamp = createTimestamp;
	}

	public int getPornhubCartoonId()
	{
		return this.pornhubCartoonId;
	}

	public void setPornhubCartoonId( int pornhubCartoonId )
	{
		this.pornhubCartoonId = pornhubCartoonId;
	}

	public String getPornhubCartoonInfoName()
	{
		return this.pornhubCartoonInfoName;
	}

	public void setPornhubCartoonInfoName( String pornhubCartoonInfoName )
	{
		this.pornhubCartoonInfoName = pornhubCartoonInfoName;
	}

	public String getPornhubCartoonInfoUrl()
	{
		return this.pornhubCartoonInfoUrl;
	}

	public void setPornhubCartoonInfoUrl( String pornhubCartoonInfoUrl )
	{
		this.pornhubCartoonInfoUrl = pornhubCartoonInfoUrl;
	}

}