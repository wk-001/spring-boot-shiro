package com.wk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
public interface RoleService extends IService<Role> {

	/**
	 * 根据userID查询该用户拥有的角色
	 * @param id
	 * @return
	 */
	List<String> queryRoleByUserId(Integer id);
}
