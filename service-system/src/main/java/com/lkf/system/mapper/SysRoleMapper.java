package com.lkf.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkf.model.system.SysRole;
import com.lkf.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    //条件分页查询
    public IPage<SysRole> selectPage(Page<SysRole> rolePage, @Param("sysRoleQueryVo") SysRoleQueryVo sysRoleQueryVo);

}
