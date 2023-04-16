package com.lkf.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkf.model.system.SysRole;
import com.lkf.model.vo.SysRoleQueryVo;
import com.lkf.system.mapper.SysRoleMapper;
import com.lkf.system.service.SysRoleService;
import org.springframework.stereotype.Service;


@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> rolePage, SysRoleQueryVo sysRoleQueryVo) {
        IPage<SysRole> sysRoleIPage = baseMapper.selectPage(rolePage, sysRoleQueryVo);
        return sysRoleIPage;
    }
}
