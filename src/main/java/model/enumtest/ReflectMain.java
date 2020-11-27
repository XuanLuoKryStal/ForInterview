package model.enumtest;


import java.lang.reflect.Field;

/**
 * @author luoxuan
 * @date 2020-11-26 16:00
 * @description 反射获取
 */
public class ReflectMain {
    public static void main(String[] args) {
        Command command = new Command(Op.GE, "hello");
        Class commandClass = command.getClass();
        try {
           for(Field field:commandClass.getDeclaredFields()) {
               field.setAccessible(true);
               if(Op.class.equals(field.getType())){
                   if(Op.GE.equals(field.get(command))) {
                       System.out.println(field.get(command));
                   }
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error");
        }

    }
}
