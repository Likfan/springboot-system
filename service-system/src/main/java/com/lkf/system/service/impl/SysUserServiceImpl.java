package com.lkf.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkf.model.system.SysRole;
import com.lkf.model.system.SysUser;
import com.lkf.model.vo.SysUserQueryVo;
import com.lkf.system.mapper.SysUserMapper;
import com.lkf.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lkf
 * @since 2023-04-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectPage(Page<SysUser> rolePage, SysUserQueryVo sysUserQueryVo) {
        IPage<SysUser> sysUserIPage = baseMapper.selectPage(rolePage, sysUserQueryVo);
        return sysUserIPage;
    }
}
