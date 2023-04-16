package com.lkf.system.test;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lkf.model.system.SysRole;
import com.lkf.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysRoleTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void selectAllByLike(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.like("role_name","管理员");
        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);
        sysRoles.forEach(System.out::print);
    }

    @Test
    public void selectAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::print);
    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleMapper.selectById(1);
        sysRole.setDescription("系统管理员2");
        int i = sysRoleMapper.updateById(sysRole);
        System.out.println("update:"+i);
    }

    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("测试角色");
        sysRole.setRoleCode("testManager");
        sysRole.setDescription("测试角色");
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert);
    }
}
