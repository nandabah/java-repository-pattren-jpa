package id.nan;

import id.nan.repository.Impl.UserRepositoryImpl;
import id.nan.model.User;
import id.nan.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserRepository nUr = new UserRepositoryImpl();
        User newUser = new User();

        newUser.setId(null);
        newUser.setName("Nan");
        newUser.setEmail("nan");

        nUr.InsertUser(newUser);
    }
}
