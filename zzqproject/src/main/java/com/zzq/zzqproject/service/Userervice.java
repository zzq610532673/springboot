package com.zzq.zzqproject.service;

import com.zzq.zzqproject.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张志奇
 * @since 2021-02-23
 */
public interface Userervice extends IService<User> {
    //根据用户名和密码获取user
    User getUserByUsernameAndPassword(String username, String password);


}
