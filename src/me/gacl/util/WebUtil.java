package me.gacl.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 把request对象中的请求参数封装到bean中
 * @author CHENLOU042
 *
 */

public class WebUtil {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try{
			T bean = clazz.newInstance();
			Enumeration<String> e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 生成UUID
	 */
	public static String makeId(){
		return UUID.randomUUID().toString();
	}

}
