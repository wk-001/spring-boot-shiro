package com.wk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.entity.Resource;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
public interface ResourceService extends IService<Resource> {

	/**
	 * 根据userID查询该用户拥有的权限
	 * @param id
	 * @return
	 */
	List<String> queryResourcesByUserId(Integer id);
}
