package model.proxytest;

public class UserServiceImpl implements  UserService{
    @Override
    public String getName() {
        System.out.println("doing...");
        return "dealing with UserServiceImpl..";
    }
}
