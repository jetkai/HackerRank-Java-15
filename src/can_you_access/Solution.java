package can_you_access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;

//Make sure to use a package lower than JDK 17 before running the following
public class Solution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/can_you_access/input"));
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;

            Inner inner = new Inner();
            Class<?> clazz = inner.getClass().getDeclaredClasses()[0];
            Method method = clazz.getDeclaredMethod("powerof2", int.class);
            method.setAccessible(true);

            Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
            constructor.setAccessible(true);

            Inner.Private instance = (Inner.Private) constructor.newInstance(inner);
            o = instance;

            String result = String.valueOf(method.invoke(instance, num));

            System.out.println(num + " is " + result);

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
    static class Inner {
        private class Private {
            private String powerof2(int num){
                return ((num & num -1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }

}

class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}