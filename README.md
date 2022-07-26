Spring Boot
------------------------------

    Spring Boot
    Spring Data JPA
    Spring Web
        Spring Web MVC
        Spring Web REST
    Swagger
    Spring Actuator
    Spring Test

    Pre-Requisites
    ---------------------
        JDK 1.8
        Maven 
        Spring Core
        Spring Context
        Spring SpEL
    
    Lab Setup
    ---------------------
        JDK 1.8
        STS latest
        MySQL / Oracle

    Spring Boot is a spring framework module that offers
        1. AutoConfiguaration
        2. Rapid Application Development
        3. Embeded Servers for Serverless Application.

    @SpringBootApplication
        = @Configuration
          @ComponentScan("thePackageInWhichTheCurrentSpringBootApplciationClassExists")
          @PropertySource("classpath:application.proeprties")


    spring-boot-demo
        |-com.cts.spring.boot.demo
                                |-SpringBootDemoApplication.java

    @SpringBootApplication
    public class SpringBootDemoApplication{
        public static void main(String args[]){
            SpringApplication.run(SpringBootDemoApplication.class,args);
        }

        /*.......*/
    }                                

    SpringApplication.run
            1. Creates an ApplicationContext object (creates a container)
            2. Scans all the annoed classes (components) and registers those beans into ApplicationContext
            3. Execute all Spring Runners (if any)....
            4. Starts the embeded server (if any)...
            5. Termiantes

    Spring Runners
        are interfaces accomidated to facitate any executions before an embed server might start.
        
        CommandLineRunner       void run(String arg[])
        ApplicationRunner       void run(ApplicationArgs args)

    @Order

    Spring Data JPA
    -----------------------------------------------------------------------------------------------

        is a spring framework module that offers dynamic automatic implementation for a jpa based
        repository

        CrudRepository
            |- JpaRepository
                    Optional<E> findById(T id)          
                    List<E> findAll()
                    E save(E e)
                    void deleteById(T id)
                    boolean existsById(T id)
