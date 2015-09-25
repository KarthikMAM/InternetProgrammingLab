<h4>Mysql installation procedure</h4>
<ul>
  <li>Use the following command to install mysql <pre> sudo apt-get install mysql-server </pre>
  <li>Create a password for the root
</ul>

<h4>sql-connector.jar</h4>
<ul>
  <li>Download <a href="http://www.java2s.com/Code/Jar/m/Downloadmysqlconnectorjar.htm">sql-connector.jar</a>
  <li>Extract it to the folder <pre> /usr/lib/jvm/java/jre/lib/ext/ </pre>
</ul>
  
<h4>Parameters</h4>
```java
private static final String DRIVER = "com.mysql.jdbc.Driver";
private static final String URL = "jdbc:mysql://localhost/YOUR_DATABASE";
private static final String USER = "USER_NAME";
private static final String PASS = "PASSWORD";
```

<a href="https://www.digitalocean.com/community/tutorials/a-basic-mysql-tutorial">MySql Tutorial</a>
