package part3.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect                                 // This is not creating an instance inside the Spring Context. We should use Aspects as "decorators" instead of "replacers" of logic.
@Component
public class HelloServiceAspect {       // Here we specify what will happen when we decouple functionality from our normal business logic code. It will intercept the call to the method "hello()" from HelloService, and it will do something after of before the call.

//    @Before("execution(* part3.services.HelloService.hello(..))")             // This is the join point where we define the point-cut, and tell this method to be executed before the method matched by the point-cut.
//    public void before() {
//        System.out.println("A");
//    }
//
//    @After("execution(* part3.services.HelloService.hello(..))")              // This method will be executed after the execution of the point-cut method specified.
//    public void after() {
//        System.out.println("B");
//    }
//
//    @AfterReturning("execution(* part3.services.HelloService.hello(..))")     // This method will be executed after the execution of the specified point-cut method, but only if there was no exception thrown.
//    public void afterReturning() {
//        System.out.println("C");
//    }
//
//    @AfterThrowing("execution(* part3.services.HelloService.hello(..))")     // This method will be executed after the execution of the specified point-cut method, but only if there was an exception thrown.
//    public void afterThrowing() {
//        System.out.println("D");
//    }

    @Around("execution(* part3.services.HelloService.hello(..))")               // This method returns an Object because at the aspect level, being totally decoupled, you don't actually know what the intercepted method will be or what will return.
    public Object around(ProceedingJoinPoint joinPoint) {                       // The ProceedingJointPoint represents the intercepted method.
        System.out.println("A");

        Object result = null;
        try {
            result = joinPoint.proceed(new Object[]{"Alex"});
            System.out.println("B");                                            // Here we print a String after the execution of the intercepted method
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return result;
    }
}

// These aspects that were used here are executed at Runtime. So the annotations that we will use to interpret at Runtime should be marked as "retention runtime", which is not the default retention for annotations.