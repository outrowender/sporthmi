/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractApplicationErrorHandler;
import de.audi.app.data.core.online.AnnoyingOrange;

class ApplicationErrorHandlerMap
extends AbstractApplicationErrorHandler {
    private final AnnoyingOrange orange;
    private boolean active = false;
    private int errorMmi = 0;
    private boolean errorShown = false;
    private boolean roamingDeactivatedShown = false;

    private static final boolean isError(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 17: 
            case 18: 
            case 19: {
                return true;
            }
        }
        return false;
    }

    private static final boolean isStableError(int n) {
        switch (n) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 17: 
            case 18: 
            case 19: {
                return true;
            }
        }
        return false;
    }

    ApplicationErrorHandlerMap(AnnoyingOrange annoyingOrange) {
        this.orange = annoyingOrange;
    }

    void updateErrorState(int n, int n2) {
        this.errorMmi = n;
        this.errorShown = false;
        if (n != 0 && n != 16 && n != 18) {
            this.roamingDeactivatedShown = false;
        }
    }

    void updateApplicationState(int n, boolean bl, boolean bl2) {
        this.active = n == 2;
    }

    void notifyErrorShown(int n, int n2) {
        boolean bl = this.errorMmi == n2 && n2 != 14;
        boolean bl2 = this.errorShown = n == 0 || bl ? true : this.errorShown;
        if (n2 == 18) {
            this.roamingDeactivatedShown = true;
        }
    }

    boolean isActionRequired() {
        return this.active && ApplicationErrorHandlerMap.isError(this.errorMmi) && !this.errorShown && this.orange.isStartupOverAndClampOn() && !this.isReconnectBlocking() && !this.errorSuppressed(this.errorMmi);
    }

    boolean isReconnectBlocking() {
        return !ApplicationErrorHandlerMap.isStableError(this.errorMmi) && this.orange.isReconnect();
    }

    boolean errorSuppressed(int n) {
        return n == 18 && this.roamingDeactivatedShown;
    }

    void roamingSettingDeactivatedByUser() {
        this.roamingDeactivatedShown = true;
    }
}

