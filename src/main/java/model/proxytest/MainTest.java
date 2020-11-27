package model.proxytest;

public class MainTest {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl=new UserServiceImpl();
        InvokeProcessClass handle=new InvokeProcessClass(userServiceImpl);
        UserService proxyService=(UserService) handle.getProxy();
        proxyService.getName();
    }
}
