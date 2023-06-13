package com.web.backend.service.Impl.user.publicpost;

import com.web.backend.mapper.PublicPostMapper;
import com.web.backend.pojo.Publicpost;
import com.web.backend.service.user.publicpost.GetPublicPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetPublicPostServiceImpl implements GetPublicPostService {
    @Autowired
    private PublicPostMapper publicPostMapper;
    @Override
    public List<Publicpost> getpublicpost() {
        return publicPostMapper.selectList(null);
    }
}
