import org.junit.Test;
import proxy.AbstractInterface;
import proxy.AbstractInterfaceImplement;
import proxy.AbstractInterfaceImplementDynamicProxy;
import proxy.AbstractInterfaceImplementStaticProxy;

import java.lang.reflect.Proxy;

public class testProxy {

    @Test
    public void testStatic() {
        AbstractInterfaceImplement ai = new AbstractInterfaceImplement();
        AbstractInterfaceImplementStaticProxy aisp = new AbstractInterfaceImplementStaticProxy(ai);
        aisp.function();
    }

    @Test
    public void testDynamic(){
        AbstractInterface abstractInterface = new AbstractInterfaceImplement();
        AbstractInterfaceImplementDynamicProxy invocationHandler = new AbstractInterfaceImplementDynamicProxy(abstractInterface);
        AbstractInterface proxy = (AbstractInterface) Proxy.newProxyInstance(abstractInterface.getClass().getClassLoader(), abstractInterface.getClass().getInterfaces(), invocationHandler);
        proxy.function();
    }
}
