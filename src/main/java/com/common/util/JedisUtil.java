package com.common.util;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class JedisUtil
{
	private static Logger log = LoggerFactory.getLogger(JedisUtil.class);

	private static JedisPool jedisPool;

	/**
	 * 带参数的构造, 手动封装jedisPool ,Spring 无法自动注入
	 * 
	 * @param poolConfig
	 * @param host
	 * @param port
	 * @param timeout
	 * @param password
	 * @author Unicode_ 2017年8月7日
	 */
	public JedisUtil( final JedisPoolConfig poolConfig, final String host, final int port, final int timeout, final String password )
	{
		try
		{
			jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 空的构造方法,方便调用
	 * 
	 * @author Unicode_ 2017年8月7日
	 */
	public JedisUtil( )
	{

	}

	/**
	 * 获取redis资源
	 * 
	 * @return
	 * @author Unicode_ 2017年8月7日
	 */
	public static Jedis getJedis()
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
		}
		catch (JedisConnectionException e)
		{
			String message = e.getMessage().trim();
			if ("Could not get a resource from the pool".equalsIgnoreCase(message))
			{
				log.warn("++++++++++请检查你的redis服务++++++++");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return jedis;
	}

	public static void closeRedis( Jedis jedis, boolean isBroken )
	{
		if (jedis == null) return;
		jedis.close();
	}

	/**
	 * 获得key指定数据
	 * 
	 * @param dbIndex
	 * @param key
	 * @return
	 * @throws Exception
	 * @author Unicode_ 2017年8月4日
	 */
	public static String getValueByKey( int dbIndex, String key ) throws Exception
	{
		Jedis jedis = null;
		String result = null;
		boolean isBroken = false;
		try
		{
			jedis = getJedis();
			jedis.select(dbIndex);
			result = jedis.get(key);
			jedis.expire(key, 1800);
		}
		catch (Exception e)
		{
			isBroken = true;
			throw e;
		}
		finally
		{
			closeRedis(jedis, isBroken);
		}
		return result;
	}

	/**
	 * 删除指定key数据
	 * 
	 * @param dbIndex
	 *            对应数据库
	 * @param key
	 *            键名
	 * @throws Exception
	 * @author Unicode_ 2017年8月4日
	 */
	public static void deleteByKey( int dbIndex, String key ) throws Exception
	{
		Jedis jedis = null;
		boolean isBroken = false;
		try
		{
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.del(key);
		}
		catch (Exception e)
		{
			isBroken = true;
			throw e;
		}
		finally
		{
			closeRedis(jedis, isBroken);
		}
	}

	/**
	 * 保存有失效时间的数据
	 * 
	 * @param dbIndex
	 *            对应数据库
	 * @param key
	 *            键名
	 * @param value
	 *            键值
	 * @param expireTime
	 *            超时时间
	 * @throws Exception
	 * @author Unicode_ 2017年8月4日
	 */
	public static void saveValueByKey( int dbIndex, byte[] key, byte[] value, int expireTime ) throws Exception
	{
		Jedis jedis = null;
		boolean isBroken = false;
		try
		{
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.set(key, value);
			if (expireTime > 0) jedis.expire(key, expireTime);
		}
		catch (Exception e)
		{
			isBroken = true;
			throw e;
		}
		finally
		{
			closeRedis(jedis, isBroken);
		}
	}

	public static Set<String> getKeys( int dbIndex, String userCode )
	{
		Jedis jedis = null;
		boolean isBroken = false;
		Set<String> keys;
		try
		{
			jedis = getJedis();
			jedis.select(dbIndex);
			keys = jedis.keys(userCode + "*");
		}
		catch (Exception e)
		{
			isBroken = true;
			throw e;
		}
		finally
		{
			closeRedis(jedis, isBroken);
		}
		return keys;
	}

	public static void setExpire( int dbIndex, String key, int expireTime )
	{
		Jedis jedis = null;
		boolean isBroken = false;
		try
		{
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.expire(key, expireTime);
		}
		catch (Exception e)
		{
			isBroken = true;
			throw e;
		}
		finally
		{
			closeRedis(jedis, isBroken);
		}
	}

}