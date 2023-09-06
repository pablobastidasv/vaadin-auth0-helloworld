package co.pablobastidasv.demo.config

import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository

@EnableWebSecurity
@Configuration
class SecurityConfiguration : VaadinWebSecurity() {

    override fun configure(http: HttpSecurity) {
        http {
            authorizeHttpRequests {
                authorize("/login/oauth2/code/**", permitAll)
            }
            oauth2Login {
                loginPage = LOGIN_URL
                permitAll = true
                defaultSuccessUrl("/", true)
            }
        }
        super.configure(http)
    }

    companion object {
        private const val LOGIN_URL = "/login"
    }
}