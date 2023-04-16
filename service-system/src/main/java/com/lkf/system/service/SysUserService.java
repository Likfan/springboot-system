package com.lkf.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkf.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkf.model.vo.SysUserQueryVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lkf
 * @since 2023-04-15
 */
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> selectPage(Page<SysUser> rolePage, SysUserQueryVo sysUserQueryVo);
}
