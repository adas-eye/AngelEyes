package org.angeleyes.dao;

import org.angeleyes.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /***************************** 前台函数接口 ***************************************
     */

    /**
     * 通过用户ID查询用户信息
     * @param userId
     * @return
     */
    User queryUserById(Long userId);

    /**
     * 统计用户数量
     * @return
     */
    Long getUserCounts();

    /**
     * 得到用户信息列表
     * @return
     */
    List<User> getUserList();

    /**
     * 查询某时间段内注册的用户
     * @param startTime  开始时间
     * @param endTime    结束时间
     * @return
     */
    List<User> getUserListByTime(@Param("startTime") Long startTime,
                                     @Param("endTime") Long endTime);


    /**
     * 通过学生家乡所在省份/城市/镇查找学生
     * @param home
     * @return
     */
    List<User> getUserListByArea(String home);

    /**
     * 用户登录验证
     * @param userEmail  用户名
     * @param password  密码
     * @return
     */
    User getLoginInfo(@Param("userEmail") String userEmail,
                          @Param("password") String password);

    /**
     * 判断用户邮箱是否唯一
     * @param userEmail
     * @return
     */
    User checkUser_email(String userEmail);

    /**
     * 更新用户信息
     * @param user_id               用户id
     * @param user_name             昵称
     * @param user_email            邮箱
     * @param user_gender           性别
     * @param user_home_province    家乡省份
     * @param user_home_city        家乡城市
     * @param user_home_district    家乡县
     * @param user_home_town        家乡镇
     * @param user_home_details     详细地址
     * @param phoneNumber           手机
     * @return
     */
    int updateUserInfo(@Param("user_id") Long user_id,
                       @Param("user_name")String user_name,
                       @Param("user_email") String user_email,
                       @Param("user_age") int user_age,
                       @Param("user_gender") int user_gender,
                       @Param("user_home_province") String user_home_province,
                       @Param("user_home_city") String user_home_city,
                       @Param("user_home_district") String user_home_district,
                       @Param("user_home_town") String user_home_town,
                       @Param("user_home_details") String user_home_details,
                       @Param("user_phoneNumber") String phoneNumber
    );

    /**
     * 修改用户头像
     * @param user_img
     * @param user_email
     * @return
     */
    int updateUserImg(@Param("user_img") String user_img,
                      @Param("user_email") String user_email);

    /**
     * 修改用户密码
     * @param old_password 原密码
     * @param new_password 新密码
     * @param user_email   用户邮箱
     * @return
     */
    int updateUserPwd(@Param("old_password") String old_password,
                      @Param("new_password") String new_password,
                      @Param("user_email") String user_email);


    /**
     * 用户登陆
     * @param email
     * @param passsword
     * @return
     */
    User user_login(@Param("email") String email, @Param("password") String passsword);

    /**
     * 用户注册
     * @param email
     * @param user_name
     * @param password
     * @return
     */
    int user_regist(@Param("email") String email, @Param("user_name") String user_name,
                    @Param("password") String password);

    /**
     * 日志记录，用户点击一篇主题以后记录到数据库中
     * @param userId
     * @param articleId
     * @param time
     * @return
     */
    int insertToUserArticleRecords_click(@Param("userId") Long userId,
                                         @Param("articleId") Long articleId,
                                         @Param("time") Long time);

    /***************************** 后台管理函数接口 ***************************************
     */

    /**
     * 后台管理员登陆
     * @param userId
     * @param password
     * @return
     */
    User adminUserLogin(@Param("user_id") Long userId,
                        @Param("password") String password);


    /**
     * 设置某模块管理员
     * @param user_id
     * @param module_id
     * @return
     */
    int setController(@Param("module_id") int module_id,
                      @Param("user_id") long user_id);


}
