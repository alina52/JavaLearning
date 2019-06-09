package proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AbstractInterfaceImplementDynamicProxy implements InvocationHandler {

    private Object obj;

    public AbstractInterfaceImplementDynamicProxy(Object abstractInterface) {
        this.obj = abstractInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("-------- start ---------");
        Object invoke = method.invoke(obj, args);
        System.out.println("-------- end ---------");
        return invoke;
    }
}
