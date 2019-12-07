package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Permission;
import cn.blithe.ssm.pojo.Role;
import cn.blithe.ssm.pojo.UserInfo;
import cn.blithe.ssm.service.PermissionService;
import cn.blithe.ssm.service.RoleService;
import cn.blithe.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
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

    /**
     * @Author: nankexiansheng
     * @Description: 批量保存保存角色
     * @Date: 2019/12/7
     * @Param: [userId]
     * @Return: org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/saveRoles")
    public String saveRoles(@RequestParam(value = "userId",required = true) String userId,@RequestParam(value = "ids",required = true) String [] RoleIds){
        userService.saveRoles(userId,RoleIds);
        return "redirect:queryAll";
    }

    @RequestMapping("/queryUserToRole")
    public ModelAndView queryUserToRole(@RequestParam(value = "id",required = true) String userId){
        ModelAndView mv = new ModelAndView("user-role-add");
        UserInfo userInfo = userService.queryById(userId);
        List<Role> roles = roleService.queryNotRoleList(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        return mv;
    }

    @RequestMapping("/queryAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")  // PreAuthorize注解，可以使用SPEL表达式，包含ROLE_ADMIN这个权限才可以访问
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView("user-list");
        List<UserInfo> userInfos = userService.queryAll();
        mv.addObject("userList",userInfos);
        return mv;
    }

    @RequestMapping("/insert")
    @PreAuthorize("authentication.principal.username == 'blithe'")  // PreAuthorize注解，用户名为blithe才可以进行保存操作
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