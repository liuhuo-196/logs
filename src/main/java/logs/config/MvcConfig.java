package logs.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.ObjectMapper;
import logs.constant.ResultConstant;
import logs.entity.CommonResult;
import java.io.PrintWriter;
import logs.entity.User;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/logs/list").setViewName("logs/list");
		registry.addViewController("/user/list").setViewName("user/list");
		
		
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/login").setViewName("login");
	}

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {

				// 预请求
                if ("OPTIONS".equals(request.getMethod())) {
                    return true;
                }

				HttpSession session = request.getSession();

				User user = (User) session.getAttribute("user");

				if (user == null) {
					response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
                    response.setHeader("Access-Control-Allow-Methods", "*");
                    response.setHeader("Access-Control-Max-Age", "3600");
                    response.setHeader("Access-Control-Allow-Credentials", "true");
                    CommonResult commonResult = new CommonResult(ResultConstant.PLEASELOGIN_CODE, ResultConstant.FAIL_MSG);
                    String result = new ObjectMapper().writeValueAsString(commonResult);
                    response.setContentType("application/json; charset=utf-8");
                    response.setCharacterEncoding("utf-8");
                    PrintWriter pw = response.getWriter();
                    pw.write(result);
                    pw.flush();
                    pw.close();
                    return false;
				}
				return true;

			}
		}).addPathPatterns("/**").excludePathPatterns("/login", "/register", "/login/doLogin", "/user/register",
				"/mystatic/**", "/druid/**", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
	}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
