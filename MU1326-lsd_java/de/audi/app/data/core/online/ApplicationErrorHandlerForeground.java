/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.online.AbstractApplicationErrorHandler;

class ApplicationErrorHandlerForeground
extends AbstractApplicationErrorHandler {
    private boolean active;
    private int errorMmi = 0;

    ApplicationErrorHandlerForeground() {
    }

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
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 17: 
            case 18: 
            case 21: 
            case 22: {
                return true;
            }
        }
        return false;
    }

    @Override
    void updateErrorState(int n, int n2) {
        this.errorMmi = n;
    }

    @Override
    void updateApplicationState(int n, boolean bl, boolean bl2) {
        this.active = n == 1;
    }

    @Override
    void notifyErrorShown(int n, int n2) {
    }

    @Override
    boolean isActionRequired() {
        return this.active && ApplicationErrorHandlerForeground.isError(this.errorMmi);
    }
}

