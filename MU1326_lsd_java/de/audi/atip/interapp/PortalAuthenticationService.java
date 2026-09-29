/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.PortalAuthenticationService$ILoginStateListener;
import de.audi.atip.interapp.PortalAuthenticationService$UpdateProfileInfoListener;

public interface PortalAuthenticationService {
    default public void logoutCurrentUser() {
    }

    default public void logoutAllUsers() {
    }

    default public void requestUsersList() {
    }

    default public void init() {
    }

    default public void loginUserWithSavedCredentials() {
    }

    default public void registerUpdateProfileInfoListener(PortalAuthenticationService$UpdateProfileInfoListener portalAuthenticationService$UpdateProfileInfoListener) {
    }

    default public boolean isAuthenticated() {
    }

    default public void indicateAuthenticationDialogFinsihed() {
    }

    default public void indicateLogoutDialogFinsihed() {
    }

    default public void addLoginStateListener(ILoginStateListener iLoginStateListener) {
    }
}

