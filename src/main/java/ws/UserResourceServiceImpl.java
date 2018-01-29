package ws;


import dao.UserDAO;
import dao.UserVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.WebService;
import java.util.List;

/**
 * Class to obtain User objects.
 */
@WebService(endpointInterface="ws.UserResourceService")
public class UserResourceServiceImpl implements UserResourceService{

  private static final ApplicationContext context = new ClassPathXmlApplicationContext(
          "applicationContext.xml");   // Application context to load Spring

  //userDAO got from the aplicationContext.xml is UserServiceImpl class object, which interacts with UserMapper, which get
  //the values from the database
  //DI via Spring
  private static final UserDAO userDAO = (UserDAO) context
      .getBean("userDAO");    // User bean to work with

  /**
   * Get all users from DB.
   *
   * @return a List containing all users.
   */
  @Override
  public List<UserVO> getAll() {

    return userDAO.findAllUsers();
  }

  /**
   * Get user from an email
   *
   * @param email primary key in DB
   * @return a User object
   */
  @Override
  public UserVO getUserByEmail(String email) {

    return userDAO.findUserById(email);
  }

  /**
   * Get user from an email
   *
   * @param username primary key in DB
   * @return a User object
   */
  @Override
  public UserVO getUserByUsername(String username) {

    return userDAO.findUserByUsername(username);
  }

  /**
   * Get user from an email
   *
   * @param number primary key in DB
   * @return a User object
   */
  @Override
  public UserVO getUserByPhoneNumber(int number) {

    return userDAO.findUserByPhoneNumber(number);
  }

  /**
   * Get user from an email
   *
   * @param name primary key in DB
   * @return a User object
   */
  @Override
  public List<UserVO> getUserByName(String name) {

    return userDAO.findUserByName(name);
  }

    /**
   * Get user from the username and password
   *
   * @param username username of the User
   * @param password password of the User
   * @return a User object
   */
    @Override
    public UserVO getUserByUsernamePass(String username, String password) {

    return userDAO.findUserByUsernamePass(username, password);
  }

  @Override
  public String insertUser(UserVO userdata) {

    //TODO: Properly handle different cases of DB working or not

    // Try to create User from data body
    try {
      userDAO.insertUser(userdata.getEmail(),
          userdata.getName(),
          userdata.getUsername(),
          userdata.getPassword(),
          userdata.getPhone_number());

      return "OK";

      // Catch exception (wrong data) and return error
    } catch (Exception e) {
      return "Bad data supplied.";
    }

  }


}
