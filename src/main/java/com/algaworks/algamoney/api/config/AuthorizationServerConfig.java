package com.algaworks.algamoney.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager; //gerencia a autenticação do login pw
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// autoriza o Cliente a utilizar 
		clients.inMemory()
			.withClient("angular")
			.secret("@ngul@r0")
			.scopes("read", "write")  //tem que tratar para definir se le, escreve etc
			.authorizedGrantTypes("password", "refresh_token") //refresh não precisa ficar se logando de novo
			.accessTokenValiditySeconds(20) //1800 = 30 minutos
			.refreshTokenValiditySeconds(3600 * 24);//demora um dia para espirar o refresh
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter())
			.reuseRefreshTokens(false) //enquanto o usuário estiver usando não se desloca para gerar novo access token
			.authenticationManager(authenticationManager); //validar
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("algaworks");
		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		//return new InMemoryTokenStore();  //não vai ser mais em Memoria
		return new JwtTokenStore(accessTokenConverter());
	}
}
