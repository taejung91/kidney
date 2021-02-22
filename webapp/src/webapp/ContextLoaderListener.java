package webapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 - MVC 프레임워크 만들기
	       스프링 MVC를 모방한 간단한 MVC 프레임워크 만들어보기 
	       스프링 프레임워크의 구동 원리와 내부  구조를 이해하기
	       디자인 패턴 적용하는 방법과 오픈 소스 라이브러리를 사용하는 방법을 경험하기 
	       리플렉션 API 사용법 익히기
	       애노테이션을 정의하고 사용하는 방법 익히기
	  
	       
	  - 프런트 컨트롤러의 도입
	            프런트 컨트롤러 디자인 패턴
	            프런트 컨트롤러는 서블릿틀의 공동 코드를 처리
	            기존 서블릿은 페이지에 대한 요청 처리만 담당
	            클라이언트의 요청에 따라 적절한 페이지 컨트롤러의 선택
	            뷰 관리 및 페이지 이동 관리
	  
	  
	  - 페이지 컨트롤러의 진화 (서블릿 대체)
	      Controller 인터페이스
	             프런트 컨트롤러와 페이지 컨트롤러 사이의 호출 규칙
	             페이지 컨트롤러를 일반 클래스화  -> 재 사용성 높임
	        ex)
	          public interface Controller{
	                String execute(Map<String, Object> model) throws Exception;
	          }                         <!-- Map : 사용자 데이터 처리할 때 사용 -->
	         
	          
      - DI를 이용한 빈 의존성 관리
           
           1. 의존성 주입(DI : Dependency Injection)
                             특정 작업을 수행할 때 사용하는 객체를 "의존 객체" 라 부름
                             이런 의존 객체를 외부에서 주입함 -> 결합도가 낮아짐 -> 교체가 쉽고, 변경이 용이해짐
                             문법 -> 의존 객체를 위한 인스턴스 변수와 셋터 메서드를 준비   
           
           2. 의존 객체의 관리
                             의존 객체의 관리와 주입은 빈 컨테이너가 관리  // 이 시점에서 빈 개념이 바뀜. (실 데이터 저장의 빈 x) (컨테이너 안의 객체들 빈)
             ContextLoaderListener가 빈 컨테이너 역할 수행 
                             인터페이스를 통해 의존 객체에 대한 결합도 낮춤 
             MemberDao에 인터페이스 적용
             
             
      - 프로퍼티를 이용한 객체 관리
        
          1. 프로퍼티 파일(.properties)
                                        하나의 라인은 키=값 형태로 구성됨
                  #으로 시작하면 라인 전체가 주석이 됨
                  
          2. Properties 클래스
                  load() 메소드를 통해 프로퍼티 파일을 읽어서 내부 맵에 저장함
                  get(key) 또는 getProperty(key)를 통해 값을 꺼냄
                  
                  
      - 리플랙션 API를 이용하여 프런트 컨트롤러 개선하기
      
                      리플랙션 API (Reflection API)
                      실행 중에 애플리케이션을 조사하고 변경할 때 사용
                      클래스의 멤버(메소드나 변수)의 정보를 손쉽게 탐색할 수 있음
                     
                      단점
                      성능을 떨어 뜨림  <- 동적인 객체 생성, 메소드 조사
                      보안에 제약  <- 보안 제약이 걸려있는 애플릿에서는 사용할 수 없음
                      내부 구조의 무분별한 노출  <- private 변수나 메소드의 실행
                      
            ex)
            Class classinfo = dto.Member3.class;                         클래스 정보 가지고 오기
            dto.Member3 member = (dto.Member3)classinfo.newInstance();    객체 생성
            Method[] methodList = classinfo.getMethods();               클래스로 객체 정보 매소드 가지고 오기
            Method method = classinfo.getMethods("getEmail");           
            for(Method methods : methodList){...}                       반복문으로 값 저장

            Method m = classinfo.getMethod("setEmail", String.class);
            dto.Member3 instance = (dto.Member3)classinfo.newInstance();
            m.invoke(instance, "abc@abc.com");                          메소드 호출
            instance.getEmail()  -> 실행 시 -> "abc@abc.com"
            
            
      - 애노테이션을 이용한 객체 관리
            
            1. 애노테이션(Annotation)
                                       컴파일이나 배포, 실행할 때 참조할 수 있는 특별한 주석
                                       클래스나 필드, 매소드에 부가 정보 설정
            
            2. 애노테이션 유지 정책(RetentionPolicy)
                 SOURCE : 컴파일 후 버려짐. 클래스 파일에 없음.
                 CLASS : 컴파일 후 클래스에 남아 있음. 실행 시 참조 불가.
                 RUNTIME : 컴파일 후 클래스에 남아 있음. 실행 시 참조 가능.
             
            3. 애노테이션 정의와 활용

 */

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
	static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {

		try {
			ServletContext sc = event.getServletContext();
			// 필요한 객체들을 준비 DS, DAO, Controller ...
/*
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/oracle");         // 데이터소스

			  MySqlMemberDao memberDao = new MySqlMemberDao();                                       // DAO
			   memberDao.setDataSource(ds);          // DI
//              .do -> 암호화하기 위해서
			  sc.setAttribute("/auth/loginform.do", new LogInFormController());
			  sc.setAttribute("/auth/login.do", new LogInController().setMemberDao(memberDao));      // 컨트롤러
			  sc.setAttribute("/member/list.do", new MemberListController().setMemberDao(memberDao));
			  sc.setAttribute("/auth/createform.do", new CreateFormController());
			  sc.setAttribute("/auth/add.do", new MemberAddController().setMemberDao(memberDao));
			  sc.setAttribute("/member/updateform.do", new MemberUpdateFormController().setMemberDao(memberDao));
			  sc.setAttribute("/member/update.do", new MemberUpdateController().setMemberDao(memberDao));
			  sc.setAttribute("/member/logout.do", new LogOutController());
			  sc.setAttribute("/member/delete.do", new MemberDeleteController().setMemberDao(memberDao));
	*/		 
              
			  String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));       // .getInitParameter() : 외부자원을 주입
			  applicationContext = new ApplicationContext(propertiesPath);
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

}
