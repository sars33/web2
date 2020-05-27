package service;

import model.User;
import org.eclipse.jetty.server.Authentication;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {

    private static UserService instance;


    /* хранилище данных */
    private Map<Long, User> dataBase = Collections.synchronizedMap(new HashMap<>());
    /* счетчик id */
    private AtomicLong maxId = new AtomicLong(0);
    /* список авторизованных пользователей */
    private Map<Long, User> authMap = Collections.synchronizedMap(new HashMap<>());


    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        Iterator<Map.Entry<Long, User>> databaseIterator = dataBase.entrySet().iterator();
        while(databaseIterator.hasNext()) {
            userList.add(databaseIterator.next().getValue());
        }
        //заполнить users from database
        //вытащить from database

        return userList;
    }



    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }



    public User getUserById(Long id) {
        if ((maxId.get() >= id) && (id >= 0)) {
            return dataBase.get(id);
        }
        return null;
    }

    public boolean addUser(User user) {

        if(user == null) {
            return false;
        } else {
            Long lg = maxId.get();
            dataBase.put(lg, user);
            return true;
        }


    }

    public void deleteAllUser() {
        dataBase.clear();
    }

    public boolean isExistsThisUser(User user) {
        for (Map.Entry<Long, User> entry : dataBase.entrySet()) {
            User user1 = entry.getValue();
            if(user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword())) {
                return false;
            }

        }
        return false;

    }

    public List<User> getAllAuth() {
        return  null;
    }

    public boolean authUser(User user) {
        return false;
    }

    public void logoutAllUsers() {
        getAllAuth();
        getAllAuth().clear();
    }

    public boolean isUserAuthById(Long id) {
        return false;
    }

}
