package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.SysLog;
import cn.blithe.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName LogAop
 * @Deacription AOP日志处理
 * @Author 夏小颜
 * @Date 2019/12/7
 * @Version 1.0
 **/
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date VisitTime; // 访问时间
    private Class clazz;   // 访问的类
    private Method method; // 访问的方法

    // 前置通知  主要是获取开始时间、执行的类是哪一个、访问的是哪个方法
    @Before("execution(* cn.blithe.ssm.controller.*.*(..))")  // 拦截controller下面的所有类的所有方法
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //当前时间就是开始访问的时间
        VisitTime = new Date();
        // 获取访问的具体类对象
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName(); // 获取访问方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数集
        //判断是否有参数
        if(args == null || args.length == 0){
            method = clazz.getMethod(methodName); // 只能获取无参数的方法
        }else{
            Class [] classArgs = new Class[args.length];
            for(int i = 0;i < args.length;i++){
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }
    }

    // 后置通知
    @After("execution(* cn.blithe.ssm.controller.*.*(..))")  // 拦截controller下面的所有类的所有方法
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - VisitTime.getTime(); // 获取访问时长
        String url = "";
        /** 获取url start   通过反射获取类和方法的参数值 */
        // 获取类上的@RequestMapping("/orders")的值
        if(clazz != null && method != null && clazz != LogAop.class){
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(clazzAnnotation != null){
                String[] clazzValue = clazzAnnotation.value();
                // 获取方法上的@RequestMapping("/queryAll")的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = clazzValue[0] + methodValue[0];

                    /** 获取url end */

                    /** 获取访问ip地址 */
                    String ip = request.getRemoteAddr();

                    /** 获取当前操作的用户  使用springsecurity来获取, 也可以使用request.getSession.getAttribute()获取 */
                    SecurityContext context = SecurityContextHolder.getContext(); // 从上下文中获取当前登陆的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();


                    /** 将获取的相关信息封装到SysLog对象中 */
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(VisitTime);
                    sysLog.setMethod("【类名】" + context.getClass() + "【方法名】" + method.getName());

                    // 调用service
                    sysLogService.save(sysLog);
                }
            }
        }

    }

}