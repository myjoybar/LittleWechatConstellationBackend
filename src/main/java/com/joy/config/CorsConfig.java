package config;
/**
 * Created by meizhuang on 23/04/17.
 */

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by joybar on 20/12/16.
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }


//    /**
//     * it's for set http url auto change to https
//     */
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer(){
//		TomcatEmbeddedServletContainerFactory tomcat=new TomcatEmbeddedServletContainerFactory(){
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint=new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");//confidential
//				SecurityCollection collection=new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//		tomcat.addAdditionalTomcatConnectors(httpConnector());
//		return tomcat;
//	}
//
//
//	@Bean
//	public Connector httpConnector(){
//		Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8221);
//		connector.setSecure(false);
//		//connector.setRedirectPort(8443);
//		connector.setRedirectPort(8221);
//		return connector;
//	}


    //	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				Ssl ssl = new Ssl();
//				// Server.jks中包含服务器私钥和证书
//				ssl.setKeyStore("/home/fzk/key/server.jks");
//				ssl.setKeyStorePassword("123456");
//				container.setSsl(ssl);
//				container.setPort(8092);
//			}
//		};
//	}
//
}

