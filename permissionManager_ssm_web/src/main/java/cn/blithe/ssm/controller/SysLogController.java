package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.SysLog;
import cn.blithe.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName SysLogController
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/7
 * @Version 1.0
 **/
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView("syslog-list");
        List<SysLog> sysLogs = sysLogService.querySysLogList();
        mv.addObject("sysLogs",sysLogs);
        return mv;
    }
}