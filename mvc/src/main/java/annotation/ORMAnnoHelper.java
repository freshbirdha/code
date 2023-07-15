package annotation;

import java.lang.reflect.Field;

public class ORMAnnoHelper {
	//获取指定类上注入的表名
	public static String getTableName(Class<?> beancls) {
		//通过class获取@table的注解
		Table tableAnno = beancls.getAnnotation(Table.class);
		if (tableAnno == null) {
			//类上没有使用注解，表示类的简称（simpleName）即对应的表名
			return beancls.getSimpleName().toLowerCase();
		} else {
			return tableAnno.value();// 注入的表名
		}
	}

	public static String getColumnName(Field f) {
		//通过column获取属性的注解
		Column columnAnno = f.getAnnotation(Column.class);
		if (columnAnno == null) {
			//类上没有使用注解，表示类的简称（simpleName）即对应的表名
			return f.getName().toLowerCase();
		} else {
			return columnAnno.value();// 注入的表名
		}
	}

	//从类中查询主键的列
	public static Field findIdField(Class<?>cls) {
		for(Field f:cls.getDeclaredFields()){
			if(isId(f)) {
				return f;
			}
		}
		return null;
	}

	//判断是否为主键
	public static boolean isId(Field f) {
		//通过column获取属性的注解
		Column columnAnno = f.getAnnotation(Column.class);
		if (columnAnno != null) {
			return columnAnno.isId();// 获取字段是否为主键字段
		}
		return false;
	}

}
