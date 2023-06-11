package com.web.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.backend.pojo.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
}
