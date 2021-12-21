# Proyecto SPRING BOOT REDIS CACHE

## Iniciando

Siga las siguientes instrucciones para iniciar el desarrollo de este proyecto.

### Pre-Requisitos

#### Configuracion de Java:

* Descargar la versión 11 del JDk segun el sistema operativo, para Linux ([lista de JDK](https://www.oracle.com/java/technologies/downloads/#java11-windows))

* Descargar la versión 11 del JDk segun el sistema operativo, para Windows ([lista de JDK](https://www.oracle.com/java/technologies/downloads/#java11-linux))

#### Configuracion de JDK:

* Debe contar con la version 11.0.13 o superior de maven ([como instalar](https://docs.oracle.com/en/java/javase/17/install/overview-jdk-installation.html)).

* Para **Linux**
    * descargar maven 11
        ```jshelllanguage
        https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
        ```
    * descomprimir zip
        ```jshelllanguage
        $ sudo unzip -o apache-maven-3.6.3-bin.zip -d /opt
        ```
  
    * configurar variable de entorno ***JAVA_HOME***

        * agregar variable de entorno
             ```jshelllanguage
            $ export JAVA_HOME=/opt/jdk-11.0.1
            $ export PATH=$JAVA_HOME/bin:$PATH 
            ```
* Para **Windows**
    * descargar maven 11
        ```jshelllanguage
        https://download.oracle.com/otn/java/jdk/11.0.13%2B10/bdde8881e2e3437baa70044f884d2d67/jdk-11.0.13_windows-x64_bin.zip
        ```
    * descomprimir zip (desde PowerShell)
        ```jshelllanguage
        $ Expand-Archive jdk-11.0.13_windows-x64_bin.zip C:\Program Files\Java
        ```

    * configurar variable de entorno ***JAVA_HOME***

        * agregar variable de entorno
             ```jshelllanguage
            JAVA_HOME = C:\Program Files\Java\jdk-11.0.13
            PATH = %JAVA_HOME%\bin
            ```          

* verificar la instalación de jdk
  ```jshelllanguage
  $ java -version
  ```

#### Configuracion de Maven:

* Debe contar con la version 3.6.3 o superior de maven ([como instalar](https://maven.apache.org/install.html)).

* Para **Linux**
    * descargar maven 3
        ```jshelllanguage
        https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
        ```
    * descomprimir zip
        ```jshelllanguage
        $ sudo unzip -o apache-maven-3.6.3-bin.zip -d /opt
        ```
    * configurar variable de entorno ***MAVEN_HOME***

        * agregar variable de entorno
            ```jshelllanguage
            $ export MAVEN_HOME=/opt/apache-maven-3.6.3
            $ export PATH=$MAVEN_HOME/bin:$JAVA_HOME/bin:$PATH 
            ```
        * hacer el script ejecutable
            ```jshelllanguage
            $ sudo chmod +x /etc/profile.d/compileMaven.sh

        * contenido del script ejecutable
          ```jshelllanguage
          mvn clean install -DskipTests=true -U -o -Dproject.build.sourceEncoding=UTF-8 -Dproject.reporting.outputEncoding=UTF-8 -Dfile.encoding=UTF-8
          ```
        * ejecutar compilador
            ```jshelllanguage
            $ source /etc/profile.d/compileMaven.sh
            ```
    * verificar la instalación de maven
        ```jshelllanguage
        $ mvn -version
        ```

* Para **Windows**
    * descargar [maven 3.6.3](https://dlcdn.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)

    * abrir una terminal de **PowerShell**

  * descomprimir zip
      ```jshelllanguage
      $ sudo unzip -o apache-maven-3.6.3-bin.zip -d /opt
      ```
  * configurar variable de entorno ***MAVEN_HOME***

      * agregar variable de entorno
          ```jshelllanguage
          M2_HOME = C:\maven\apache-maven-3.6.3
          PATH = %M2_HOME%\bin
        ```


    * Guardar cambios
#### Otras configuraciones:

Deben tener instalado Docker y Docker-Compose

https://www.docker.com/get-started
https://docs.docker.com/desktop/windows/install/


---

Ejemplo para levantar el api:

* Debemos de instalar algunas dependencias necesarias para el api con estos comandos:

    ```jshelllanguage
    $ mvn clean install

    ```
* En la carpeta raiz del proyecto teclear el siguiente comando para iniciar ejecutar el archivo docker-compose que permite iniciar levantar el proyecto y la base de datos que usa el api:
    ```jshelllanguage
    $ docker-compose up -d db

    ```

* En el Terminal o PowerShell ejecutar lo siguiente:
    ```jshelllanguage
    $ docker exec -ti redis /bin/bash
      redis-cli
      mostrar todas las claves: KEYS *
      verificar clave: student::1
    ```

***

## Tecnologías Utilizadas

![Java](https://cdn.static.innovacionpacifico.com/document_library/readme/java-logo-64.png) [JDK](https://www.oracle.com/technetwork/java/index.html)
![Spring Boot](https://cdn.static.innovacionpacifico.com/document_library/readme/spring-boot-logo-64.png) [Spring Boot](https://spring.io/projects/spring-boot)
![Spring Cloud](https://cdn.static.innovacionpacifico.com/document_library/readme/spring-cloud-logo-64.png) [Spring Cloud](https://spring.io/projects/spring-cloud)
![Maven](https://cdn.static.innovacionpacifico.com/document_library/readme/maven-logo-64.png) [Maven](https://maven.apache.org/)
![Rest](https://cdn.static.innovacionpacifico.com/document_library/readme/rest-logo-64.png) [Rest](https://es.wikipedia.org/wiki/Transferencia_de_Estado_Representacional)
![Docker](https://cdn.static.innovacionpacifico.com/document_library/readme/docker-logo-64.png) [Docker](https://www.docker.com/get-started)

***