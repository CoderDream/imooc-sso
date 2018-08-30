# imooc-sso

imooc sso 学习笔记


## 运行环境 ##

- eclipse下载地址：

```shell
http://ftp.jaist.ac.jp/pub/eclipse/technology/epp/downloads/release/photon/R/eclipse-jee-photon-R-win32-x86_64.zip
```



- jetty插件下载

打开eclipse，依次点击菜单Help->Eclipse Marketplace，在Find后面的框中输入jetty，选择第一项进行install即可。

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0001.png)




- 运行项目：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0002.png)



- 控制台信息：

```shell
   ____    ___                   __    __  __         ___
  / __/___/ (_)__  ___ ___   __ / /__ / /_/ /___ __  / _ \
 / _// __/ / / _ \(_-</ -_) / // / -_) __/ __/ // /  \_, /
/___/\__/_/_/ .__/___/\__/  \___/\__/\__/\__/\_, /  /___/
           /_/                              /___/
2018-08-30 09:58:34.850:INFO::main: Logging initialized @186ms
   Configuration: C:\Users\Admin\AppData\Local\Temp\eclipseJettyPlugin.config.sso_same_domain.xml
         Version: 9.3.12.v20160915
         Context: /
            Port: 8080
       Classpath: D:/Java/GitHub/imooc-sso/sso_same_domain/target/classes
                  D:/Java/repo/commons-fileupload/commons-fileupload/1.3.3/commons-fileupload-1.3.3.jar
                  D:/Java/repo/commons-io/commons-io/2.5/commons-io-2.5.jar
                  D:/Java/repo/ognl/ognl/3.1.15/ognl-3.1.15.jar
                  D:/Java/repo/org/apache/commons/commons-lang3/3.6/commons-lang3-3.6.jar
                  D:/Java/repo/org/apache/logging/log4j/log4j-api/2.9.1/log4j-api-2.9.1.jar
                  D:/Java/repo/org/apache/logging/log4j/log4j-core/2.9.1/log4j-core-2.9.1.jar
                  D:/Java/repo/org/apache/struts/struts2-core/2.5.14.1/struts2-core-2.5.14.1.jar
                  D:/Java/repo/org/freemarker/freemarker/2.3.26-incubating/freemarker-2.3.26-incubating.jar
                  D:/Java/repo/org/javassist/javassist/3.20.0-GA/javassist-3.20.0-GA.jar
2018-08-30 09:58:35.178:INFO:oejs.Server:main: jetty-9.3.12.v20160915
2018-08-30 09:58:35.772:WARN:oejs.SecurityHandler:main: ServletContext@o.e.j.w.WebAppContext@1e7c7811
{/,file:///D:/Java/GitHub/imooc-sso/sso_same_domain/src/main/webapp/,STARTING}
{D:\Java\GitHub\imooc-sso\sso_same_domain\src\main\webapp} has uncovered http methods for path: /
2018-08-30 09:58:36.594:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@1e7c7811
{/,file:///D:/Java/GitHub/imooc-sso/sso_same_domain/src/main/webapp/,AVAILABLE}
{D:\Java\GitHub\imooc-sso\sso_same_domain\src\main\webapp}
2018-08-30 09:58:36.613:INFO:oejs.AbstractConnector:main: Started ServerConnector@49c6c24f
{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2018-08-30 09:58:36.614:INFO:oejs.Server:main: Started @1951ms
------------------------------------------------
Jetty startup finished in 1.9 s.
Used memory: 7.5 MB of 111.5 MB (1.8 GB maximum)
Console available: type "help".
------------------------------------------------
```


## 同域 ##


![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0003.png)

### 访问地址 ###

```shell
http://localhost:8080/demo1/main.action

http://localhost:8080/demo2/main.action
```

- 未登陆：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0101.png)

- 登陆成功

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0102.png)

- 刷新页面（浏览器已有cookie信息）

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0103.png)


查看chrome的cookie信息路径：
```shell
chrome://settings/cookies/detail?site=localhost
```

localhost的cookie信息截图如下：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0104.png)

## 同父域 ##

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0004.png)

修改hosts文件：
```shell
127.0.0.1	demo1.x.com
127.0.0.1	demo2.x.com
127.0.0.1	check.x.com
```

### 访问地址 ###

```shell
http://demo1.x.com:8080/demo1/main.action

http://demo2.x.com:8080/demo2/main.action
```

- 未登陆：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0201.png)

- 未登录

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0202.png)

- 登陆页面

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0203.png)

- 登陆成功

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0204.png)

- 刷新页面（浏览器已有cookie信息）

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0205.png)


查看chrome的cookie信息路径：
```shell
chrome://settings/cookies/detail?site=x.com
```
x.com的cookie信息截图如下：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0206.png)


## 跨域 ##

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0005.png)

```shell
127.0.0.1	www.a.com
127.0.0.1	www.b.com
127.0.0.1	www.x.com
```

### 访问地址 ###
```shell
http://www.a.com:8080/demo1/main.action

http://www.b.com:8080/demo2/main.action
```

- 未登陆：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0301.png)

- 未登录

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0302.png)

- 登陆成功

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0303.png)

- 刷新页面（浏览器已有cookie信息）

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0304.png)


查看chrome的cookie信息路径：
```shell
chrome://settings/cookies/detail?site=www.a.com

chrome://settings/cookies/detail?site=www.b.com
```
www.a.com 的cookie信息截图如下：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0305.png)

www.b.com 的cookie信息截图如下：

![](https://raw.githubusercontent.com/CoderDream/imooc-sso/master/snapshot/sso_0306.png)

