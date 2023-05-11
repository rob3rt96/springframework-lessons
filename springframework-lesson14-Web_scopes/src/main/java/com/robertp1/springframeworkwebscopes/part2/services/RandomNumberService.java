package com.robertp1.springframeworkwebscopes.part2.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service

// The value = WebApplicationContext.SCOPE_REQUEST is making this component to be part of the Web Scopes, or the Web Spring Context.
// SCOPE_REQUEST makes possible to generate a new instance of the bean for each new Http request, differently from the Singleton standard scope.
@Scope(
        value = WebApplicationContext.SCOPE_REQUEST,
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
