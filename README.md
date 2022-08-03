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

    Spring Web
    -----------------------------------------------------------------------------------------------------------

        is another spring framework module.

        And this module offers support for Web MVC applications and REST api applications.

        Web MVC - Single Front Controller Design Pattern

                       Repo <-Entity-> Service <-Model-> Controller                                                   EndUser
                       Repo <-Entity-> Service <-Model-> Controller                                                     ↑4
        Database <---> Repo <-Entity-> Service <-Model-> Controller   <-Model-------------- FrontController <---REQ-- Client
                       Repo <-Entity-> Service <-Model-> Controller   -ViewName/ Model+ViewName---> | 
                       Repo <-Entity-> Service <-Model-> Controller                                 |        
                                                                                                  (model)
                                                                                                    |
                                                                                                    ↓
                                                                                                   VIEWS --------RESP----> 
                                                                                             

        FrontController?        DispatcherServlet from spring web module.

        Controller?             is a POJO marked with @Controller.
                                The controller offers methods that msut be invoked when ever a req is to be processed.
                                These methods are called actions.
                                These actions are expected to return either a viewName as String or a viewName + models as
                                ModelAndView Object.

        How can a front-controller know which underlying controller should be invoked for a 
        incoming req?

            UrlHandler is a spring web interface using which the fornt-controller tries to
            figure out the related conteroller.action for a incoming request.

            UrlHandler's implementation class SimpleUrlHandler is by default cofngiured by spring bott for this purpose.

            @RequestMapping(value="url",method=RequestMethod.GET|POST|...etc)
                this annotation is applied on the action methods.

            SimpleUrlHandler will match the url and http method of the incoming request with the
            urls and method configed on the actions and the related action is picked if one available.

        When a controller after processing the req-data, it is sending a viewName, how 
        the front-controller will picka related view of the viewName from the VIEWS?

            ViewResolver is a spring web interface the front-controller uses to
            figureout the actual view for a given viewName.

            XmlResourceViewResolver,MessageBundleReourceViewResolver,InternalResourceViewResolver are the different
            implementations of ViewResolver interface.

            Spring Boot configs InternalResourceViewResolver as the default option.

            InternalResourceViewResolver has two fields
                prefix
                suffix

            for a given viewName the actual view is 'prefix + viewName + suffix'.

    REST api - Single Front Controller Design Pattern

                       Repo <-Entity-> Service <-Model-> Controller
                       Repo <-Entity-> Service <-Model-> Controller                                                         
        Database <---> Repo <-Entity-> Service <-Model-> Controller   <-Model-------------- FrontController <---REQ-- Another APP
                       Repo <-Entity-> Service <-Model-> Controller   -ViewName/ Model+ViewName---> | 
                       Repo <-Entity-> Service <-Model-> Controller                                 |        
                                                                                                  (model) --------RESP----> 
      