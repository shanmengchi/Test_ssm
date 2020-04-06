package com.shan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class myInterceptor extends HandlerInterceptorAdapter{
	
	private final Logger log = LoggerFactory.getLogger(myInterceptor.class);

	
	  /** 
     * ��ҵ��������������֮ǰ������ 
     * �������false 
     *     �ӵ�ǰ������������ִ��������������afterCompletion(),���˳���������
     *     
     * �������true 
     *    ִ����һ��������,ֱ�����е���������ִ����� 
     *    ��ִ�б����ص�Controller 
     *    Ȼ�������������, 
     *    �����һ������������ִ�����е�postHandle() 
     *    �����ٴ����һ������������ִ�����е�afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			
		}
		log.info("==============ִ��˳��: 1��preHandle================");  
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());        
		if ("/userController/login".equals(url)) {                  
			return true;
		}else {               
			String username =  (String)request.getSession().getAttribute("user"); 
			if(username == null){
				log.info("��������δ��¼��ת��indexҳ�棡");
				request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
				return false;
			}else
				return true;   
		}
	}
	
	/**
	 * ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���   
	 * ����modelAndView�м������ݣ����統ǰʱ��
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("==============ִ��˳��: 2��postHandle================");  
        if(modelAndView != null){  //���뵱ǰʱ��  
            modelAndView.addObject("haha", "����postHandle");  
        }  
	}
	
	/** 
	 * ��DispatcherServlet��ȫ����������󱻵���,������������Դ��    
	 * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion() 
	 */  
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		  log.info("==============ִ��˳��: 3��afterCompletion================");  
	}

}
