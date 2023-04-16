package com.lkf.system.controller;

import cmo.lkf.common.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkf.model.system.SysRole;
import com.lkf.model.vo.SysRoleQueryVo;
import com.lkf.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleConreoller {
    @Autowired
    SysRoleService sysRoleService;

    //http://localhost:8800/admin/system/sysRole/select/all
    @ApiOperation("查询所以sysrole的接口")
    @GetMapping("/select/all")
    public Result selectAll(){
        List<SysRole> sysRoleList = sysRoleService.list();
        return Result.ok(sysRoleList);
    }

    @ApiOperation("根据id查询指定sysrole的接口")
    @PostMapping("/select/one/{id}")
    public Result selectOne(@PathVariable("id") Integer id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    @ApiOperation("修改sysrole的接口")
    @PostMapping("/updata")
    public Result updateSysRole(@RequestBody SysRole sysRole){
        boolean b = sysRoleService.updateById(sysRole);
        if(b){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    @ApiOperation("添加角色")
    @PostMapping("/save")
    public Result saveSysRole(@RequestBody SysRole sysRole){
        boolean save = sysRoleService.save(sysRole);
        if(save){
            return Result.ok();
        }else {
            return Result.fail();
        }

    }


    @ApiOperation("逻辑删除的接口")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id")Integer id){
        boolean b = sysRoleService.removeById(id);
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
        boolean b = sysRoleService.removeByIds(ids);
        if(b){
            return Result.ok();
        }else{
            return  Result.fail();
        }
    }

    @ApiOperation("条件分页查询")
    @GetMapping("/select/{page}/{limit}")
    public Result selectPageQueryRole(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit, SysRoleQueryVo sysRoleQueryVo){
        Page <SysRole> rolePage = new Page<>(page,limit);
        IPage<SysRole> sysRoleIPage = sysRoleService.selectPage(rolePage, sysRoleQueryVo);
        return Result.ok(sysRoleIPage);
    }


}
