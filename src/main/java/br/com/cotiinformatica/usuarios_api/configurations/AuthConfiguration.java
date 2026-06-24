package br.com.cotiinformatica.usuarios_api.configurations;

import br.com.cotiinformatica.usuarios_api.filters.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {

    @Value("${jwt.secret}")
    private String jwtSecret;

    //Método para configurar o Filter de autenticação

    @Bean
    public FilterRegistrationBean
            <AuthenticationFilter> registrationFilter() {

        //Registrando o filter de autenticação
        var filter = new FilterRegistrationBean
                                <AuthenticationFilter>();
        filter.setFilter(new AuthenticationFilter(jwtSecret));

        //Aplicando o filtro para os endpoints desejados
        filter.addUrlPatterns("/api/v1/usuario/obter-dados");

        return filter;
    }

}
