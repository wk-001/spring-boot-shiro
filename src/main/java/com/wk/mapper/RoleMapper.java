package com.wk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
public interface RoleMapper extends BaseMapper<Role> {

	List<String> queryRoleByUserId(Integer id);
}
