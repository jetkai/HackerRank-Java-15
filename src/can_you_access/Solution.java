package can_you_access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.security.Permission;

public class Solution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try{
            BufferedReader br = new BufferedReader(new FileReader("./data/can_you_access/input"));
            int num = Integer.parseInt(br.readLine().trim());
            Object o = Solution.Inner.Private.class;// Must be used to hold the reference of the instance of the class even_forest.Solution.Inner.Private

            //Write your code here
            Method[] methods = o.getClass().getDeclaredMethods();
            for(Method method : methods) {
               // if(method.) {
                method.setAccessible(true);
                if(method.getName().contains("power"))
                System.out.println(method.getName());
               // }
            }
          //  System.out.println(o.getClass().getMethod("powerof2"));

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner

}//end of even_forest.Solution

class DoNotTerminate { //This class prevents exit(0)

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
