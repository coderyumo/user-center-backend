package com.yupi.usercenterbackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.usercenterbackend.model.domain.User;
import com.yupi.usercenterbackend.model.domain.dto.UserDTO;
import com.yupi.usercenterbackend.model.domain.request.SearchUserByTagsRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author linli
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-12-15 22:57:04
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param planetCode    星球编号
     * @return 新用户 id
     */
    long userRegister(
            String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    String userLogin(String userAccount, String userPassword, String uuid);

    /**
     * 获取当前登录用户信息
     *
     * @param userAccount
     * @param uuid
     * @return
     */
    User getLoginUser(String userAccount, String uuid);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagList
     * @return
     */
    Page<User> queryUsersByTags(SearchUserByTagsRequest byTagsRequest);

    Page<User> queryUsersByTagsByMysql(SearchUserByTagsRequest byTagsRequest);

    /**
   * 修改用户信息
   *
   * @param userDTO
   * @param LoginUser
   * @return
   */
  int updateUser(UserDTO userDTO, User LoginUser);

  /**
   * 是否为管理员
   *
   * @param userAccount
   * @param uuid
   * @return
   */
  boolean isAdmin(String userAccount, String uuid);

    /**
     * 是否为管理员
     *
     * @param loginUser
     * @return
     */
    boolean isAdmin(User loginUser);
}
