package com.lkf.system.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lkf.model.system.SysRole;
import com.lkf.system.mapper.SysRoleMapper;
import com.lkf.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysRoleServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void selectAll(){
        List<SysRole> list = sysRoleService.list();
        list.forEach(System.out::print);
    }
    @Test
    public void save(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("测试角色1");
        sysRole.setRoleCode("testManeger1");
        sysRole.setDescription("测试角色1");
        boolean save = sysRoleService.save(sysRole);
        System.out.println(save);
    }
    @Test
    public void update(){
        SysRole byId = sysRoleService.getById(10);
        byId.setDescription("test");
        boolean b = sysRoleService.updateById(byId);
        System.out.println(b);
    }


}
