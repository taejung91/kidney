package webapp;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;




                                     // 빈에 대한 생성 및 관리
public class ApplicationContext {

	Hashtable<String, Object> objTable = new Hashtable<String, Object>();   // 저장 공간
	
	public Object getBean(String key) {              // 저장 공간 불러오기
		return objTable.get(key);
		
	}
	
	public ApplicationContext(String propertiesPath) throws Exception{
		
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));                    // properties 값 읽고, 로드 
		
		/*     참고 :
		reflections-0.9.9-RC1.jar
		pom.xml
		<dependency>
		     <groupId>org.reflections</groupId>
		     <artifactId>reflections</artifactId>
		     <version>0.9.9-RC1</version>
		</dependency>
		*/
		
		prepareObjects(props);
		prepareAnnotationObjects();
		injectDependency();
		
	}
	
	private void prepareObjects(Properties props) throws Exception{
		Context ctx = new InitialContext();
		String key = null;
		String value = null;
		
		for(Object item : props.keySet()) {
			key = (String) item;
			value = props.getProperty(key);              // .getProperty() : 변수의 프로퍼티 내용 값 가지고 오기
			if(key.startsWith("jndi.")) {                // .startsWith("") : 시작 문자열 확인
				objTable.put(key, ctx.lookup(value));
			}else {
				objTable.put(key, Class.forName(value).newInstance());
			}
		}
	}
	
	private void prepareAnnotationObjects() throws Exception{
		
		Reflections reflector = new Reflections("");
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class);  //getTypesAnnotatedWith() : 애노테이션이 붙은 클라스 찾음
		String key = null;
		for(Class<?> clazz : list) {
			key = clazz.getAnnotation(Component.class).value();
			objTable.put(key, clazz.newInstance());
		}
	}
	
	             // 객체 주입
	private void injectDependency() throws Exception{
		for(String key : objTable.keySet()) {
			if(!key.startsWith("jndi.")) {
				callSetter(objTable.get(key));         
			}
		}
	}
	
	private void callSetter(Object obj) throws Exception{
		Object dependency = null;
		for(Method m : obj.getClass().getMethods()) {
			if(m.getName().startsWith("set")) {
				dependency = findObjectByType(m.getParameterTypes()[0]);
				if(dependency != null) {
					m.invoke(obj, dependency);
				}
			}
		}
	}
	
	
	private Object findObjectByType(Class<?> type) {   // type에 따라 
		for(Object obj : objTable.values()){
			if(type.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}

}
