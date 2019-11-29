package com.wk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.entity.Resource;
import com.wk.mapper.ResourceMapper;
import com.wk.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public List<String> queryResourcesByUserId(Integer id) {
		return resourceMapper.queryResourcesByUserId(id);
	}
}
