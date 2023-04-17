package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/initServlet")
public class InitServlet extends HttpServlet{
	//서블릿 : 서버측에서 실행되는 웹페이지(자바코드)
	//		톰캣 컨테이너가 실행시켜줌. 
	//		<-> 클라이언트의 요청. url: locahost:8081/HellWeb/initServlet
	// .java확장자 -> .class파일 컴파일이 된 후 .class파일이 실행
	// HttpServlet 클래스를 상속받아야 서블릿으로 동작함
	public InitServlet() {
		System.out.println("InitServlet() Call.");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() Call.");
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest와 HttpServletResponse 두 파라미터는 각각 JSP의 request 기본 객체와 response 기본 객체에 해당함
		// 재정의한 메서드는 request를 기용해서 웹 브라우저의 요청 정보를 읽어오거나, response를 이용해서 응답을 전송
		System.out.println("service() Call.");
		resp.setContentType("text/html;charset=UTF-8"); //화면의 출력되는 컨테츠의 타입지정.
		// 재정의한 메서드는 request를 기용해서 웹 브라우저의 요청 정보를 읽어오거나, response를 이용해서 응답을 전송
		// setContentType() 메서드에 전달되는 값은 JSP에서 page 디렉티브의 contentType 속성값과 동일
		
		// 사용자의 화면에 출력 -> 출력스트림 생성
		PrintWriter out = resp.getWriter();//출력스트림 생성
		// 웹 브라우저에 데이터를 전송하려면(응답 컨텐츠 타입 지정 후), response.getWriter()로 문자열 데이터를 출력할 수 있는 PrintWriter를 구함
		// PrintWriter는 println() 메서드를 제공하며, 이 메서드를 이용해서 전송할 응답 데이터를 전달함
		out.print("InitServlet 페이지입니다.");
		out.print("<h3>InitServlet</h3>");
		out.print("<a href = 'index.html'>홈페이지로</a>");
		
	}
}
