# Vaadin+Auth0 Hello World

## Properties

Replace in the `application.yml` with the values from your auth0 configuration.

```yaml
spring.security.oauth2.client:
  registration.auth0:
    client-id: <client_id>
    client-secret: <client-secret>
  provider.auth0:
    issuer-uri: https>//<auth0-domain>
    authorization-uri: https://<autn0-domain>/authorize
    token-uri: https://<autn0-domain>/oauth/token
    user-info-uri: https://<autn0-domain>/userinfo
    user-name-attribute: sub
    jwk-set-uri: https://<autn0-domain>/.well-known/jwks.json
```