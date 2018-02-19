package ru.newmvc.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long startTime = Long.parseLong(request.getAttribute("startTime").toString());
        Thread.sleep(1111);
        int totalTime = (int) ((System.currentTimeMillis() - startTime) / 1000);
        modelAndView.addObject("totalTime",totalTime);
        System.out.println(handler + " = " + totalTime);


//        if(request.getRequestURI().contains("checkUser")){
//            User user = (User) modelAndView.getModel().get("user");
//            if(user==null || !user.isAdmin()){
//                response.sendRedirect(request.getContextPath()+"/failed");
//            }
//        }
    }
}
