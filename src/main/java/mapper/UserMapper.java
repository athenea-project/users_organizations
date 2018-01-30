package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import dao.UserVO;

import java.util.List;

/**
 * User mapper class for Spring and MyBatis
 */
public interface UserMapper {

  /**
   * Get all Users
   * @return every user in a List
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USERS_ORGANIZATIONS")
  List<UserVO> getUsers();

  /**
   * Get user by email
   * @param email email of the User (primary key)
   * @return a single User
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USERS_ORGANIZATIONS WHERE EMAIL = #{email}")
  UserVO getUserByEmail(@Param("email") String email);
  
  /**
   * Get user by email
   * @param username email of the User (primary key)
   * @return a single User
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USERS_ORGANIZATIONS WHERE USERNAME = #{username}")
  UserVO getUserByUsername(@Param("username") String username);

  /**
   * Get user by name
   * @param name name of the User 
   * @return a single User
   */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USERS_ORGANIZATIONS WHERE NAME = #{name}")
  List<UserVO> getUserByName(@Param("name") String name);

  /** 
  * Get user by phone number
  * @param phoneNumber phone number of the User
  * @return a single User
  */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USERS_ORGANIZATIONS WHERE PHONE_NUMBER = #{phone_number}")
  UserVO getUserByPhoneNumber(@Param("phone_number") int phoneNumber);

    /** 
  * Get user by pass and username
  * @param username username of the User
  * @param password password of the User
  * @return a single User
  */
  @Select("SELECT EMAIL, NAME, USERNAME, PHONE_NUMBER FROM USERS_ORGANIZATIONS WHERE username = #{username} AND password = #{password}")
  UserVO getUserByUsernamePass(@Param("username") String username, @Param("password") String password);

  /**
   * Insert user into DB
   * @param email
   * @param name
   * @param username
   * @param password
   * @param phone_number
   */
  @Insert("INSERT INTO USER (EMAIL, NAME, USERNAME, PASSWORD, PHONE_NUMBER) VALUES (#{email}, #{name}, #{username}, #{password}, #{phone_number})")
  void insertUser(@Param("email") String email, @Param("name") String name, @Param("username") String username,
                  @Param("password") String password, @Param("phone_number") int phone_number);
}
