package com.qa.rest.common;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class RestConfig
{
    public static Logger logger = LoggerFactory.getLogger(RestConfig.class);

    //connection configuration
    public static String BASE_URL;
    public static final String LOCALHOST = "localhost";
    public static Properties properties;

    static
    {
        // get environment
        String prop = System.getProperty("env"); // use to run on Jenkins Machine
        if (prop == null) {
            prop = System.getenv("env"); // use to run local PC
        }
        else
        {
            prop = LOCALHOST;
        }

        // read properties
        properties = new Properties();
        try
        {
            properties.load(RestConfig.class.getClassLoader().getResourceAsStream("localhost" + ".properties"));
        }
        catch (Exception e)
        {
            logger.error("Unable to read Environment properties", e);
        }

        // get global properties
        BASE_URL = properties.getProperty("baseURL");
    }

    public static void main( String[] args )
    {
        System.out.println(BASE_URL);
    }
}