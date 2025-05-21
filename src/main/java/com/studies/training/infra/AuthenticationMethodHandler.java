package com.studies.training.infra;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;

import com.studies.training.exceptions.AuthenticationException;

public class AuthenticationMethodHandler implements MethodAuthorizationDeniedHandler {

    @Override
    public Object handleDeniedInvocation(MethodInvocation invocation,
            AuthorizationResult result) {
        throw new AuthenticationException();
    }

}
