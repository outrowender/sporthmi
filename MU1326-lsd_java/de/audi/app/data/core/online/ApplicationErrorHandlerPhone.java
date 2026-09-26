/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractApplicationErrorHandler;

class ApplicationErrorHandlerPhone
extends AbstractApplicationErrorHandler {
    private boolean isActive = false;
    private int errorMmi = 0;
    private boolean errorShown = false;
    private boolean showOnEnterPhone = true;

    ApplicationErrorHandlerPhone() {
    }

    private static final boolean isError(int n) {
        return n == 6 || n == 7 || n == 8 || n == 9;
    }

    @Override
    void updateErrorState(int n, int n2) {
        this.errorMmi = n;
        this.errorShown = false;
    }

    @Override
    void updateApplicationState(int n, boolean bl, boolean bl2) {
        this.isActive = bl2 && n != 3 && n != 4;
    }

    @Override
    void notifyErrorShown(int n, int n2) {
        this.errorShown = n == 0 || this.errorMmi == n2 ? true : this.errorShown;
    }

    @Override
    boolean isActionRequired() {
        return this.isActive && !this.errorShown && ApplicationErrorHandlerPhone.isError(this.errorMmi);
    }

    void telAppEntered() {
        if (this.showOnEnterPhone) {
            this.errorShown = false;
        }
        this.showOnEnterPhone = false;
    }

    void telAppLeft() {
        this.showOnEnterPhone = true;
    }

    void hkTelPressed() {
        this.errorShown = false;
    }
}

