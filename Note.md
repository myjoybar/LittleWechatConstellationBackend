# LittleWechatConstellationBackend
###### 1. Mysql
1.  mysql -uroot -p
    
###### 2. spring项目打包： 排除测试代码后进行打包

1. mvn clean package  -Dmaven.test.skip=true
2. build jar包:   mvn install   或者  mvn clean package -Dmaven.test.skip=true