package cn.springboot.user.service;

import cn.springboot.user.mapper.UserMapper;
import cn.springboot.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id){

        return this.userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteUserById(Long id){
         this.userMapper.deleteByPrimaryKey(id);
    }

    public List<User> queryUserAll() {
        return userMapper.selectAll();
    }
}
