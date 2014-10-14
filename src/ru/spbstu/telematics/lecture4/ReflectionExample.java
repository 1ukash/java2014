package ru.spbstu.telematics.lecture4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ReflectionExample {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Object o = new Object();
		Class clazz = o.getClass();
		Class clazz2 = ReflectionExample.class;
		
		Class<?> strClass = Class.forName("java.util.Date");
		Date str = (Date) strClass.newInstance();
		System.out.println("Date string " + str);
		
		Class<?> beanClass = Bean.class;//Class.forName("ru.spbstu.telematics.lecture4.Bean");
		Bean beanObj1 = (Bean) beanClass.newInstance();
		Bean beanObj2 = new Bean(10, "ten");
		
		Method[] methods = beanClass.getMethods();
		Constructor<?>[] constructors = beanClass.getConstructors();
		Field[] fields = beanClass.getFields();
		
		evaluateMethods(methods);
		evaluateConstructors(constructors);
		evaluateFields(fields);
		
		System.out.println();
		System.out.println("Declared fields");
		System.out.println();
		evaluateMethods(beanClass.getDeclaredMethods());
		
		Method toString = beanClass.getMethod("toString");
		Object invokeResult = toString.invoke(beanObj2);
		System.out.println(invokeResult);
	}

	private static void evaluateFields(Field[] fields) {
		for (Field f : fields) {
			System.out.println(f.getName() + " " + f.getType());
		}
	}

	private static void evaluateConstructors(Constructor<?>[] constructors) {
		for (Constructor<?> c : constructors) {
			Class<?>[] types = c.getParameterTypes();
			System.out.print(c.getName() + "( ");
			for (Class x : types) {
				System.out.print(x.getName() + ", ");
			}
			System.out.println(")");
		}
	}

	private static void evaluateMethods(Method[] methods) {
		for (Method m : methods) {
			Class<?>[] types = m.getParameterTypes();
			System.out.print(m.getName() + "( ");
			for (Class c : types) {
				System.out.print(c.getName() + ", ");
			}
			System.out.println(")");
			
		}
	}
}
