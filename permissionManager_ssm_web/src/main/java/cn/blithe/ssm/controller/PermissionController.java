package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Permission;
import cn.blithe.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName PermissionController
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2
 * @Version 1.0
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/queryAll")
    public ModelAndView queryAll() {
        ModelAndView mv = new ModelAndView("permission-list");
        List<Permission> permissions = permissionService.queryAll();
        mv.addObject("permissionList", permissions);
        return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:queryAll";
    }

    @RequestMapping("/queryById")
    public ModelAndView queryById(@RequestParam(value = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView("permission-show");
        Permission permission = permissionService.queryById(id);
        mv.addObject("permission", permission);
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id", required = true) String id) {
        permissionService.delete(id);
        return "redirect:queryAll";

    }
}