package study07;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*") //WebFilter 애너테이션을 이용해 모든 요청이 필터를 거치게 한다.
public class EncoderFilter implements Filter { //사용자 정의 필터는 반드시 Filter인터페이스를 구현해야 함
	ServletContext context;
	
    /**
     * Default constructor. 
     */
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	//doFilter() 안에서 실제 필터 기능을 구현한다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		//요청 필터 기능
		chain.doFilter(request, response); //다음 필터로 넘기는 작업을 수행한다.
	}
}
