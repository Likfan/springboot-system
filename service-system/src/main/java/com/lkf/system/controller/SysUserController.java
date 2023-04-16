package com.lkf.system.controller;


import cmo.lkf.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkf.model.system.SysRole;
import com.lkf.model.system.SysUser;
import com.lkf.model.vo.SysRoleQueryVo;
import com.lkf.model.vo.SysUserQueryVo;
import com.lkf.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lkf
 * @since 2023-04-15
 */
@Api(tags="用户管理接口")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    //列表
    @ApiOperation("查询所以sysUser的接口")
    @GetMapping("/select/all")
    public Result selectAll(){
        List<SysUser> sysRoleList = sysUserService.list();
        return Result.ok(sysRoleList);
    }

    @ApiOperation("根据id查询指定sysUser的接口")
    @PostMapping("/select/one/{id}")
    public Result selectOne(@PathVariable("id") Integer id){
        SysUser sysUser = sysUserService.getById(id);
        return Result.ok(sysUser);
    }

    @ApiOperation("修改sysUser的接口")
    @PostMapping("/updata")
    public Result updateSysRole(@RequestBody SysUser sysUser){
        boolean b = sysUserService.updateById(sysUser);
        if(b){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    @ApiOperation("添加用户")
    @PostMapping("/save")
    public Result saveSysRole(@RequestBody SysUser sysUser){
        boolean save = sysUserService.save(sysUser);
        if(save){
            return Result.ok();
        }else {
            return Result.fail();
        }

    }


    @ApiOperation("逻辑删除的接口")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id")Integer id){
        boolean b = sysUserService.removeById(id);
        if(b){
            return Result.ok();
        }else{
            return  Result.fail();
        }
    }
    @ApiOperation("批量删除的接口")
    @DeleteMapping("/remove")
    public Result removeByIds(@RequestBody List<Long> ids){
        ids.forEach(System.out::print);
        boolean b = sysUserService.removeByIds(ids);
        if(b){
            return Result.ok();
        }else{
            return  Result.fail();
        }
    }

    @ApiOperation("条件分页查询")
    @GetMapping("/select/{page}/{limit}")
    public Result selectPageQueryRole(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit, SysUserQueryVo sysUserQueryVo){
        Page <SysUser> userPage = new Page<>(page,limit);
        IPage<SysUser> sysRoleIPage = sysUserService.selectPage(userPage, sysUserQueryVo);
        return Result.ok(sysRoleIPage);
    }


}

