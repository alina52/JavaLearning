package proxy;

public class AbstractInterfaceImplementStaticProxy implements AbstractInterface{

    private AbstractInterfaceImplement abstractInterfaceImplement;

    public AbstractInterfaceImplementStaticProxy(AbstractInterfaceImplement abstractInterfaceImplement) {
        this.abstractInterfaceImplement = abstractInterfaceImplement;
    }

    @Override
    public void function() {
        System.out.println("Proxy");
        this.abstractInterfaceImplement.function();
    }

}
