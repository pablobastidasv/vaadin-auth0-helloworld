package co.pablobastidasv.demo.views

import co.pablobastidasv.demo.add
import com.vaadin.flow.component.html.Anchor
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed

@Route("/login")
@AnonymousAllowed
class Login : VerticalLayout(){
    init {
        val loginLink = Anchor(OAUTH_URL, "Login using Auth0").apply {
            element.setAttribute("router-ignore", true)
        }
        add { loginLink }

        style.set("padding", "200px")
        alignItems = FlexComponent.Alignment.CENTER
    }

    companion object{
        const val OAUTH_URL = "/oauth2/authorization/auth0"
    }
}