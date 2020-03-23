package com.baieapp.mapper;

import com.baieapp.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author dengmin
 * @Created 2020/3/22 09:58
 */
public interface UserMapper {
    @Select("SELECT * FROM unifieduser WHERE id = #{userId}")
    public User getUser(@Param("userId") Long userId);
}
