package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Permission;
import cn.blithe.ssm.pojo.Role;
import cn.blithe.ssm.pojo.UserInfo;
import cn.blithe.ssm.service.PermissionService;
import cn.blithe.ssm.service.RoleService;
import cn.blithe.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName UserInfoController
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2 13:58
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView("user-list");
        List<UserInfo> userInfos = userService.queryAll();
        mv.addObject("userList",userInfos);
        return mv;
    }

    @RequestMapping("/insert")
    public String insert(UserInfo userInfo){
        userService.insert(userInfo);
        return "redirect:queryAll";
    }

    @RequestMapping("/queryById")
    public ModelAndView queryById(@RequestParam(value = "id",required = true) String id){
        ModelAndView mv = new ModelAndView("user-show");
        UserInfo userInfo = userService.queryById(id);
        List<Role> roles = roleService.queryRoleList(id);
        userInfo.setRoles(roles);
        for (Role role : roles) {
            List<Permission> permissions = permissionService.queryPermissionByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        mv.addObject("user",userInfo);
        return mv;
    }
}