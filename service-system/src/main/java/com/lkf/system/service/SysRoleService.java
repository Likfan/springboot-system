package com.lkf.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkf.model.system.SysRole;
import com.lkf.model.vo.SysRoleQueryVo;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> selectPage(Page<SysRole> rolePage, SysRoleQueryVo sysRoleQueryVo);
}
