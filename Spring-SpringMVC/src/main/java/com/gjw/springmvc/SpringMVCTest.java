package com.gjw.springmvc;

/**
 * JavaEE基础
 * Servlet：能够处理HTTP请求并返回
 * JSP：一直嵌套Java代码的HTML，将被编译成Servlet
 * Filter；能过滤指定的URL以实现拦截功能
 * Listener：监听指定的事件，如ServletContext，HttpSession的创建和销毁
 *
 * src/main/webapp是标准web目录，WEB-INF存放的web.xml，编译的class，第三方jar
 * 以及不允许浏览器访问的View模板，static文件夹里面存放的所有静态文件
 *
 * 使用SpringMVC开发web应用程序主要的工作就是编写controller逻辑
 * 在web应用中，除了需要使用MVC给用户显示页面外，还有一类API接口，我们称之为
 * REST，通常输入输出都是JSON，便于第三方调用或者使用Javascript与之交互
 * 对于的Maven工程需要加入Jackson这个依赖
 * jackson-databind（也可以自己定义消息转换器如：fastJson）
 * Servlet规范中还可以使用Filter
 * web应用中输入中文会导致乱码
 * Servlet默认按照非UTF-8编码读取参数=>我们可以使用一个EncodingFilter，在全局范围类给HttpServletRequest和...Response
 * 强制设置UTF-8编码
 * 可以自己设置一个EncodingFilter 也可以使用SpringMVC自带的CharacterEncodingFilter，配置时只需要在web.xml中声明即可
 *
 * 处理跨域问题：
 * 如果A站在域名a.com页面的JavaScript调用A站自己的API时，这是同域，没有问题
 * 如果A站在域名a.com页面的JavaScript调用B站b.com时，将被浏览器拒绝访问，因为不符合同源策略
 * 同源是全相同 域名 端口号 协议
 * 跨域访问 CORS
 * 法一 @CrossOrigin(origins="*")
 * 法二：WebMvcConfigurer全局配置CORS
 * 法三：使用CorsFilter
 */
public class SpringMVCTest {

    public static void main(String[] args) {
        System.out.println("hello world!!!");
    }
}
