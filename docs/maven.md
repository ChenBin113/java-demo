# 什么是 Maven

Maven：Apache 的一款开源自动化的项目管理工具，[GitHub 地址](https://github.com/apache/maven)，还可以在 GitHub 上看到很多 Apache 管理的项目，比如 tomcat，shiro，dubbo 等。

# Maven 的功能

主要有两项功能：

- 完成项目构建，编译，打包，部署等工作：通过 

依赖管理：pom.xml，自动下载jar包

Maven是用Java语言写的，需要运行在JRE上，版本要求1.7以上，内存要求有两个，一个是软件安装要求 10 M，另一个是仓库存储要求，500 M +，README 文档提示。

```
  System Requirements
  -------------------

  JDK:
    1.7 or above (this is to execute Maven - it still allows you to build against 1.3
    and prior JDK's).
    System Requirements
  -------------------

  JDK:
    1.7 or above (this is to execute Maven - it still allows you to build against 1.3
    and prior JDK's).
```

Maven中央仓库：mvnrepository.com

Maven仓库

本地仓库

云端仓库