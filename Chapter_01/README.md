Bei dem letzten Beispiel hatte ich den folgenden Fehler

```
Dec 23, 2020 9:34:39 PM org.springframework.context.support.AbstractApplicationContext refresh
WARNING: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'knight' defined in class path resource [knights.xml]: BeanPostProcessor before instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.aspectj.AspectJPointcutAdvisor#0': Cannot create inner bean '(inner bean)#1139b2f3' of type [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#1139b2f3': Resolution of declared constructors on bean Class [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] from ClassLoader [jdk.internal.loader.ClassLoaders$AppClassLoader@659e0bfd] failed; nested exception is java.lang.NoClassDefFoundError: org/aspectj/lang/JoinPoint
Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'knight' defined in class path resource [knights.xml]: BeanPostProcessor before instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.aspectj.AspectJPointcutAdvisor#0': Cannot create inner bean '(inner bean)#1139b2f3' of type [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#1139b2f3': Resolution of declared constructors on bean Class [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] from ClassLoader [jdk.internal.loader.ClassLoaders$AppClassLoader@659e0bfd] failed; nested exception is java.lang.NoClassDefFoundError: org/aspectj/lang/JoinPoint
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:526)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:944)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:923)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:588)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:144)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:85)
	at com.springinaction.knights.KnightMain.main(KnightMain.java:7)

```
der Bean konnte nicht erstellt werden.
Mehr Informationen unter folgendem Link: https://stackoverflow.com/questions/35116672/

um das Problem zu beheben, muss man halt das folgende Dependency der POM-Datei hinzufügen:

```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.3.2</version>
</dependency>
```

Um die Java Bean Config zu konfigurieren, muss nur die folgende Zeile auskommentiert werden:
```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
```

Der Model View Controller Pattern ist der Pattern, der meist da verwendet wird, wo es die Oberfläsche anders als Backend ist. Z.B., wenn man das Frontend in JS schreib aber das Backend halt in Java.
