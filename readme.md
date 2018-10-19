####AndroidDevFrame

#####框架整体结构
 1. 项目架构:组件化
 2. 编码架构:MVP
 
#####开发计划
 1. 搭建组件化项目结构
 2. Gradle配置文件的统一管理
 3. 资源文件命名统一管理
 4. 签名文件的统一配置管理
 5. 混淆文件的编写
 6. 业务Module的划分
 7. 组件之间通信
 8. 组件服务的暴露
 9. 工具类的封装
 
#### Android Studio 3.2 google()和jcenter() 容易下载依赖产生connect timeout
利用国内阿里云镜像
buildscript {
         repositories {
                 maven{ url 'http://maven.aliyun.com/nexus/content/groups/public/' }
                 maven{ url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
             }
             dependencies {
                 classpath 'com.android.tools.build:gradle:3.3.0-alpha13'
             }
         }
         allprojects {
             repositories {
                 maven{ url 'http://maven.aliyun.com/nexus/content/groups/public/'}
                 maven{ url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
             }
         }
         task clean(type: Delete) {
             delete rootProject.buildDir
         }
 