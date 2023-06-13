package com.web.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer targetId;
    private Boolean followed;
}
