package com.org.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

public class PornhubCustomer implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int				  pornhubCustomerId;

	private Date createTimestamp;

	private String createUser;

	private String enableFlag;

	private Date lastUpdateTimestamp;

	private String lastUpdateUser;

	private String pornhubCustomerAccount;

	private String pornhubCustomerInvitationCode;

	private String pornhubCustomerLastLoginIp;

	private String pornhubCustomerPassword;

	private String pornhubCustomerRegisterIp;

	private String pornhubCustomerType;

	private Date pornhubCustomerVipTime;

	public PornhubCustomer( )
	{
	}

	public int getPornhubCustomerId()
	{
		return this.pornhubCustomerId;
	}

	public void setPornhubCustomerId( int pornhubCustomerId )
	{
		this.pornhubCustomerId = pornhubCustomerId;
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

	public String getPornhubCustomerAccount()
	{
		return this.pornhubCustomerAccount;
	}

	public void setPornhubCustomerAccount( String pornhubCustomerAccount )
	{
		this.pornhubCustomerAccount = pornhubCustomerAccount;
	}

	public String getPornhubCustomerInvitationCode()
	{
		return this.pornhubCustomerInvitationCode;
	}

	public void setPornhubCustomerInvitationCode( String pornhubCustomerInvitationCode )
	{
		this.pornhubCustomerInvitationCode = pornhubCustomerInvitationCode;
	}

	public String getPornhubCustomerLastLoginIp()
	{
		return this.pornhubCustomerLastLoginIp;
	}

	public void setPornhubCustomerLastLoginIp( String pornhubCustomerLastLoginIp )
	{
		this.pornhubCustomerLastLoginIp = pornhubCustomerLastLoginIp;
	}

	public String getPornhubCustomerPassword()
	{
		return this.pornhubCustomerPassword;
	}

	public void setPornhubCustomerPassword( String pornhubCustomerPassword )
	{
		this.pornhubCustomerPassword = pornhubCustomerPassword;
	}

	public String getPornhubCustomerRegisterIp()
	{
		return this.pornhubCustomerRegisterIp;
	}

	public void setPornhubCustomerRegisterIp( String pornhubCustomerRegisterIp )
	{
		this.pornhubCustomerRegisterIp = pornhubCustomerRegisterIp;
	}

	public String getPornhubCustomerType()
	{
		return this.pornhubCustomerType;
	}

	public void setPornhubCustomerType( String pornhubCustomerType )
	{
		this.pornhubCustomerType = pornhubCustomerType;
	}

	public Date getPornhubCustomerVipTime()
	{
		return this.pornhubCustomerVipTime;
	}

	public void setPornhubCustomerVipTime( Date pornhubCustomerVipTime )
	{
		this.pornhubCustomerVipTime = pornhubCustomerVipTime;
	}

}