package me.gacl.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ��request�����е����������װ��bean��
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
	 * ����UUID
	 */
	public static String makeId(){
		return UUID.randomUUID().toString();
	}

}
