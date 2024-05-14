///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import com.libary.model.Book;
//import com.libary.model.User;
//import java.util.List;
//
///**
// *
// * @author ADMIN
// */
//public class UserDao extends ServiceDAO<User> implements IGeneralDAO<User>{
//
//    private IMapper<User> mapper = new User.UserMapper();
//
//
//    @Override
//    public List<User> findAll() {
// //To change body of generated methods, choose Tools | Templates.
//         return query("SELECT * FROM user", mapper);    }
//
//    @Override
//    public User findOne(String username) {
//         List<User> list = query("SELECT * FROM user where username=?", mapper, username);
//        return list.isEmpty()? null : list.get(0);
//    }
//
//    @Override
//    public User save(User object) {
//        insert("INSERT INTO user(username, password) VALUES(?,?)",
//                    object.getUsername(),
//                    object.getPassword());
//        return object;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
