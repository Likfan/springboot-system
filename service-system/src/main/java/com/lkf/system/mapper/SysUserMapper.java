package com.lkf.system.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkf.model.system.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkf.model.vo.SysUserQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lkf
 * @since 2023-04-15
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    public IPage<SysUser> selectPage(Page<SysUser> rolePage,@Param("sysUserQueryVo") SysUserQueryVo sysUserQueryVo);

}
