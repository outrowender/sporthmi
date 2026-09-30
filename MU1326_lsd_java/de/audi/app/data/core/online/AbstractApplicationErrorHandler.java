/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

abstract class AbstractApplicationErrorHandler {
    AbstractApplicationErrorHandler() {
    }

    abstract void updateErrorState(int var1, int var2);

    abstract void updateApplicationState(int var1, boolean var2, boolean var3);

    abstract void notifyErrorShown(int var1, int var2);

    abstract boolean isActionRequired();
}

