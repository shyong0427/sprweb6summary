package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import pack.model.HelloModel;

//public class HelloController implements Controller {
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		return null;
//	}
//}

public class HelloController extends AbstractController {
	private HelloModel helloModel;
	
	public void setHelloModel(HelloModel helloModel) {
		this.helloModel = helloModel;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 모델과 통신
		String result = helloModel.getGreeting();
		
//		ModelAndView modelAndView = new ModelAndView("hello"); 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello"); // Forwarding
//		modelAndView.setViewName("redirect : /hello.jsp"); // redirect
		modelAndView.addObject("result", result);
		return modelAndView; // Forwarding
	}
}