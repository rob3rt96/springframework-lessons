package com.robertp1.springframeworkwebscopes.part3.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service

// The value = WebApplicationContext.SCOPE_SESSION is making this component to be part of the Web Scopes, or the Web Spring Context.
// SCOPE_SESSION generates a server-side session of 25 minutes (by default). The session is a place in which data is stored per user,
// being accessible for multiple requests that are sent by a specific user. It uses a cookie that identifies, by a specific id, the user on the server, and
// it allows that specific user to access that information on multiple requests until the session expires.
@Scope(
        value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.INTERFACES
)
public class RandomNumberService implements NumberService {

    private final int value;

    public RandomNumberService() {
        this.value = new Random().nextInt(1000);
    }

    public int getValue() {
        return value;
    }
}
