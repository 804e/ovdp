package com.ov.dp.uims.config;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.core.convert.support.GenericConversionService;
//import org.springframework.core.serializer.support.DeserializingConverter;
//import org.springframework.core.serializer.support.SerializingConverter;

//import net.sf.ehcache.CacheManager;

@Configuration
public class UimsConfiguration {

	/*@Bean
	public CacheManager cacheManager() {
		return net.sf.ehcache.CacheManager.create();
	}*/

	/**
	 * spring session专用，不然session序列化的时候会报错
	 * 
	 * @return
	 */
	/*@Bean
	public ConversionService springSessionConversionService() {
		GenericConversionService converter = new GenericConversionService();
		converter.addConverter(Object.class, byte[].class, new SerializingConverter());
		converter.addConverter(byte[].class, Object.class, new DeserializingConverter());
		return converter;
	}*/

}
