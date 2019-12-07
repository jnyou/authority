package cn.blithe.ssm.controller;

import cn.blithe.ssm.dao.PermissionDao;
import cn.blithe.ssm.pojo.Permission;
import cn.blithe.ssm.pojo.Role;
import cn.blithe.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName RoleController
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2 15:04
 * @Version 1.0
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionDao permissionDao;

    @RequestMapping("/saveBatchPermissionAndRole")
    public String saveBatchPermissionAndRole(@RequestParam(value = "roleId",required = true) String roleId,@RequestParam(value = "ids",required = true) String [] permissionId){
        roleService.saveBatchPermissionAndRole(roleId,permissionId);
        return "redirect:queryAll";
    }

    @RequestMapping("/queryRoleAndPermission")
    public ModelAndView queryRoleAndPermission(@RequestParam(value = "id",required = true) String roleId){
        ModelAndView mv = new ModelAndView("role-permission-add");
        Role role = roleService.queryRoleByRoleId(roleId);
        List<Permission> permissions = permissionDao.queryPermissionToUse(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissions);
        return mv;
    }

    @RequestMapping("/queryAll")
    public ModelAndView queryAll(){
        ModelAndView mv = new ModelAndView("role-list");
        List<Role> roles = roleService.queryAll();
        mv.addObject("roleList",roles);
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:queryAll";
    }

    @RequestMapping("/queryById")
    public ModelAndView queryRoleByRoleId(@RequestParam(value = "id",required = true) String id){
        ModelAndView mv = new ModelAndView("role-show");
        Role role = roleService.queryRoleByRoleId(id);
        List<Permission> permissions = permissionDao.queryPermissionByRoleId(id);
        role.setPermissions(permissions);
        mv.addObject("role",role);
        return mv;
    }
}