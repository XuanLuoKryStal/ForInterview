package model.proxytest;

public class MainTest {
    public static void main(String[] args) {
        //JDK
        UserServiceImpl userServiceImpl=new UserServiceImpl();
        InvokeProcessClass handle=new InvokeProcessClass(userServiceImpl);
        UserService proxyService=(UserService) handle.getProxy();
        proxyService.getName();
        System.out.println("==================================");
        //CGLIB
        UserService userService= (UserService) new InvokeCglibClass().getProxy(UserServiceImpl.class);
        userService.getName();
    }
}
