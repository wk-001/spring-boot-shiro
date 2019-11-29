package com.wk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.entity.Role;
import com.wk.mapper.RoleMapper;
import com.wk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<String> queryRoleByUserId(Integer id) {
		return roleMapper.queryRoleByUserId(id);
	}
}
