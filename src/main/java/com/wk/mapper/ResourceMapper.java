package com.wk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.entity.Resource;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
public interface ResourceMapper extends BaseMapper<Resource> {

	List<String> queryResourcesByUserId(Integer id);
}
