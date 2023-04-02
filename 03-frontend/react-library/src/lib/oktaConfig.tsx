export const oktaConfig = {
  clientId: "0oa8ycuhtc6XF7hAm5d7",
  issuer: "https://dev-21732388.okta.com/oauth2/default",
  redirectUri: "http://localhost:3000/login/callback",
  scopes: ["openid", "profile", "email"],
  pkce: true,
  disableHttpsCheck: true,
};
