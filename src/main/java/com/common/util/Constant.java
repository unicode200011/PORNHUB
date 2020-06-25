package com.common.util;

import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Constant
{
	public static String PORNHUB_CARTOON_IMG_URL = ""; 
	public static String PORNHUB_VIDEO_IMG_URL = ""; 

    static {
        try {
            Properties prop = PropertiesLoaderUtils.loadAllProperties("properties/platform.properties");
            PORNHUB_CARTOON_IMG_URL = prop.getProperty("PORNHUB_CARTOON_IMG_URL").trim();
            PORNHUB_VIDEO_IMG_URL = prop.getProperty("PORNHUB_VIDEO_IMG_URL").trim();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}