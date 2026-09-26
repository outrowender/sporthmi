/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

abstract class AbstractApplicationErrorHandler {
    AbstractApplicationErrorHandler() {
    }

    abstract void updateErrorState(int n, int n2) {
    }

    abstract void updateApplicationState(int n, boolean bl, boolean bl2) {
    }

    abstract void notifyErrorShown(int n, int n2) {
    }

    abstract boolean isActionRequired() {
    }
}

