package com.org.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

public class PornhubCartoon implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int pornhubCartoonId;

	private Date createTimestamp;

	private String createUser;

	private String enableFlag;

	private Date lastUpdateTimestamp;

	private String lastUpdateUser;

	private String pornhubCartoonAuthor;

	private String pornhubCartoonImgUrl;

	private String pornhubCartoonName;

	private int pornhubCartoonPages;

	private String pornhubCartoonSort;

	private String pornhubCartoonType;

	public PornhubCartoon( )
	{
	}

	public int getPornhubCartoonId()
	{
		return this.pornhubCartoonId;
	}

	public void setPornhubCartoonId( int pornhubCartoonId )
	{
		this.pornhubCartoonId = pornhubCartoonId;
	}

	public Date getCreateTimestamp()
	{
		return this.createTimestamp;
	}

	public void setCreateTimestamp( Date createTimestamp )
	{
		this.createTimestamp = createTimestamp;
	}

	public String getCreateUser()
	{
		return this.createUser;
	}

	public void setCreateUser( String createUser )
	{
		this.createUser = createUser;
	}

	public String getEnableFlag()
	{
		return this.enableFlag;
	}

	public void setEnableFlag( String enableFlag )
	{
		this.enableFlag = enableFlag;
	}

	public Date getLastUpdateTimestamp()
	{
		return this.lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp( Date lastUpdateTimestamp )
	{
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getLastUpdateUser()
	{
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser( String lastUpdateUser )
	{
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getPornhubCartoonAuthor()
	{
		return this.pornhubCartoonAuthor;
	}

	public void setPornhubCartoonAuthor( String pornhubCartoonAuthor )
	{
		this.pornhubCartoonAuthor = pornhubCartoonAuthor;
	}

	public String getPornhubCartoonImgUrl()
	{
		return this.pornhubCartoonImgUrl;
	}

	public void setPornhubCartoonImgUrl( String pornhubCartoonImgUrl )
	{
		this.pornhubCartoonImgUrl = pornhubCartoonImgUrl;
	}

	public String getPornhubCartoonName()
	{
		return this.pornhubCartoonName;
	}

	public void setPornhubCartoonName( String pornhubCartoonName )
	{
		this.pornhubCartoonName = pornhubCartoonName;
	}

	public int getPornhubCartoonPages()
	{
		return this.pornhubCartoonPages;
	}

	public void setPornhubCartoonPages( int pornhubCartoonPages )
	{
		this.pornhubCartoonPages = pornhubCartoonPages;
	}

	public String getPornhubCartoonSort()
	{
		return this.pornhubCartoonSort;
	}

	public void setPornhubCartoonSort( String pornhubCartoonSort )
	{
		this.pornhubCartoonSort = pornhubCartoonSort;
	}

	public String getPornhubCartoonType()
	{
		return this.pornhubCartoonType;
	}

	public void setPornhubCartoonType( String pornhubCartoonType )
	{
		this.pornhubCartoonType = pornhubCartoonType;
	}

}