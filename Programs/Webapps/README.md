<h4>Apache server install instructions</h4>
<ul>
  <li>Download the <b>tar.gz</b> version from the <a href="http://tomcat.apache.org/download-70.cgi"/>Tomcat Server Site</a>
  <li>Untar it as <b>tomcat</b>
  <li>Now move it to the <b>opt</b> folder by using the command <pre> mv tomcat /opt/tomcat </pre>
</ul>

<h4>Starting and Stopping the server</h4>
<ul>
  <li>Go to the <b>bin</b> folder in the tomcat directory
  <li>Right click on the folder and select <b>open in terminal</b>
  <li>Now type the commands to start and shutdown the server in the terminal
</ul>

```BASH
sudo ./startup.sh
sudo ./shutdown.sh

or simply

./startup.sh
./shutdown.sh
```

<h4>Creating Java Servlet pages</h4>
<ul>
  <li>In <b>webapps</b> folder create a <b>new folder</b> for this project
  <li>Within this folder add another folder named <b>WEB-INF</b>, <b>WEB-INF/java</b> and <b>WEB-INF/classes</b>
  <li>Now create a java file within the folder <b>WEB-INF/java</b>
  <li>Compile the code using <b>servlet-api.jar</b> file as the classpath like <pre> javac -cp /opt/tomcat/lib/servlet-api.jar ServletClass.java </pre>
  <li>Move the class file to the folder <b>WEB-INF/classes</b>
  <li>Map the class file to a url in the <b>WEB-INF/web.xml</b> file
</ul>
```xml
<web-app>
    <servlet>
        <servlet-name>ServletClass</servlet-name>
        <servlet-class>ServletClass</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ServletClass</servlet-name>
        <url-pattern>/ServletClass</url-pattern>
    </servlet-mapping>
    <welcome-file-list>/index.html</welcome-file-list>
</web-app>
```

<h4>Creating jsp pages</h4>
<ul>
  <li>Create a jsp file and place it in the <b>project folder</b>
  <li>Next map the jsp-file in <b>WEB-INF/web.xml</b> like this
</ul>
```xml
<web-app>
    <servlet>
        <servlet-name>Index</servlet-name>
        <jsp-file>/index.jsp</jsp-file>
    </servlet>
    <servlet-mapping>
        <servlet-name>Index</servlet-name>
        <url-pattern>/index.jsp</url-pattern>
    </servlet-mapping>

    <welcome-file-list>/index.jsp</welcome-file-list>
</web-app>

```

<h4>Index of apps</h4>
<ul>
  <li><a href="appletservlet">Applet to Servlet Communication</a>
  <li><a href="exam">Online Exam</a>
  <li><a href="form">Form Servlet Communication</a>
  <li><a href="login">Login Authentication Using JSP Sessions</a>
  <li><a href="sessions">Session Visit Counter using JSP</a>
  <li><a href="student">Student Database Manipulation</a>
  <li><a href="banking">Banking System</a>
</ul>
