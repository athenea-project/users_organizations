package ws;

import dao.UserVO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserResourceService {

    @WebMethod
    List<UserVO> getAll();

    UserVO getUserByEmail(@WebParam(name = "email")String email);

    UserVO getUserByUsername(@WebParam(name = "username")String username);

    UserVO getUserByPhoneNumber(@WebParam(name = "number")int number);

    List<UserVO> getUserByName(@WebParam(name = "name")String name);

    UserVO getUserByUsernamePass(@WebParam(name = "username")String username, @WebParam(name = "password")String password);

    String insertUser(@WebParam(name = "userdata")UserVO userdata);


}
