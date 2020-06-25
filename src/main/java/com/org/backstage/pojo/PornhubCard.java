package com.org.backstage.pojo;

import java.io.Serializable;

public class PornhubCard implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int				  pornhubCardId;
	private String			  pornhub_card_number;
	private String			  pornhub_card_password;
	private String			  enable_flag;
	private String			  pornhub_card_type;

	public String getPornhub_card_type()
	{
		return pornhub_card_type;
	}

	public void setPornhub_card_type( String pornhub_card_type )
	{
		this.pornhub_card_type = pornhub_card_type;
	}

	public int getPornhubCardId()
	{
		return pornhubCardId;
	}

	public void setPornhubCardId( int pornhubCardId )
	{
		this.pornhubCardId = pornhubCardId;
	}

	public String getPornhub_card_number()
	{
		return pornhub_card_number;
	}

	public void setPornhub_card_number( String pornhub_card_number )
	{
		this.pornhub_card_number = pornhub_card_number;
	}

	public String getPornhub_card_password()
	{
		return pornhub_card_password;
	}

	public void setPornhub_card_password( String pornhub_card_password )
	{
		this.pornhub_card_password = pornhub_card_password;
	}



	public String getEnable_flag()
	{
		return enable_flag;
	}

	public void setEnable_flag( String enable_flag )
	{
		this.enable_flag = enable_flag;
	}

	public PornhubCard( )
	{
	}

}