package co.pablobastidasv.demo.views

import co.pablobastidasv.demo.add
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.VaadinServletRequest
import jakarta.annotation.security.PermitAll
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler


@Route("")
@PermitAll
class Main : VerticalLayout() {
    init {
        val authentication = SecurityContextHolder.getContext().authentication
        val principal = authentication.principal as OAuth2AuthenticatedPrincipal

        val title = H1("Hello World!!")
        add { title }

        val subtitle = H2("Here I am.")
        add { subtitle }

        val span = Span(principal.attributes["email"]?.toString() ?: "Not email defined.")
        add { span }

        val logoutButton = Button("Logout") {
            UI.getCurrent().page.setLocation("/login")
            val logoutHandler = SecurityContextLogoutHandler()
            logoutHandler.logout(
                VaadinServletRequest.getCurrent().httpServletRequest,
                null,
                null
            )
        }
        add(logoutButton)

        alignItems = FlexComponent.Alignment.CENTER
    }
}
