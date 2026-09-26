/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

public abstract class AbstractFunctionList {
    protected boolean[] functionSupported;

    protected abstract int getMinModuleSpecificFctID() {
    }

    protected abstract int getMaxFctID() {
    }

    public abstract int getGetAllFctID() {
    }

    public abstract int getBAPConfigBAPFctID() {
    }

    public abstract int getFctListBAPFctID() {
    }

    public abstract int getOperationStateBAPFctID() {
    }

    public boolean isFunctionSupported(int n) {
        return this.functionSupported[n];
    }

    public boolean isInRange(int n) {
        return n > 0 && n <= this.getMaxFctID();
    }

    public boolean isInModuleSpecificRange(int n) {
        return n >= this.getMinModuleSpecificFctID() && n <= this.getMaxFctID();
    }
}

