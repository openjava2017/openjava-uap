package com.diligrp.uap.security.core;

import com.diligrp.uap.security.exception.AccessDeniedException;
import com.diligrp.uap.security.exception.AuthenticationException;
import com.diligrp.uap.security.session.Session;
import com.diligrp.uap.security.util.ErrorCode;
import com.diligrp.uap.security.util.HttpRequestMatcher;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class UrlAuthorizationManager implements AuthorizationManager {
    private final List<UrlAuthorization> entries;

    public UrlAuthorizationManager(List<UrlAuthorization> entries) {
        this.entries = entries;
    }

    public void authorize(HttpServletRequest request, Session session) {
        for (UrlAuthorization authorization : entries) {
            if (authorization.requestMatcher.matches(request)) {
                authorization.authorize(session);
                break;
            }
        }
    }

    public static class UrlAuthorization {
        private final HttpRequestMatcher requestMatcher;

        private final AuthorizationChecker authorizationChecker;

        public UrlAuthorization(HttpRequestMatcher requestMatcher, AuthorizationChecker authorizationChecker) {
            this.requestMatcher = requestMatcher;
            this.authorizationChecker = authorizationChecker;
        }

        public void authorize(Session session) {
            authorizationChecker.check(session);
        }
    }

    @FunctionalInterface
    public interface AuthorizationChecker {
        void check(Session session);
    }

    public static class PermissionChecker implements AuthorizationChecker {
        private final Permission permission;

        public PermissionChecker(Permission permission) {
            this.permission = permission;
        }

        @Override
        public void check(Session session) {
            if (!session.isAuthenticated()) {
                throw new AuthenticationException(ErrorCode.SUBJECT_NOT_AUTHENTICATED, ErrorCode.MESSAGE_NOT_AUTHENTICATED);
            }

            Subject subject = session.getSubject();
            List<Permission> permissions = subject.getPermissions();
            if (permissions != null && !permissions.isEmpty()) {
                for (Permission permission : permissions) {
                    if (permission.check(this.permission)) {
                        return;
                    }
                }
            }

            throw new AccessDeniedException(ErrorCode.SUBJECT_NOT_AUTHORIZATION, ErrorCode.MESSAGE_NOT_AUTHORIZATION);
        }
    }
}