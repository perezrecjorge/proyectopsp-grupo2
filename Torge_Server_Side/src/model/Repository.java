package model;

import model.VO.UserVO;
import model.util.ExcepcionTorge;

import java.util.List;

public interface Repository {


    void payTrip(double id);

    List<UserVO> loadUserList() throws ExcepcionTorge;

    UserVO getUser(String nick, String passw) throws ExcepcionTorge;

    UserVO getUserRecovery(String nick) throws ExcepcionTorge;

    void saveUser(UserVO p) throws ExcepcionTorge;

    void modifyUser(UserVO p) throws ExcepcionTorge;





}
