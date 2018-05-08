package com.moneyxchange.persistence.util;


import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ObjectUtil {
	
	
	public static Object convertObject(Class inClass, Class outClass, Object object) {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(inClass, outClass);
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(object, outClass);
	}

	public static List<Object> converListObject(Class inClass, Class outClass, List list) {
		List<Object> result = new ArrayList<Object>();
		for (Object obj : list) {
			result.add(convertObject(inClass, outClass, obj));
		}
		return result;
	}

}
