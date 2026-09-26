/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.CallStackTracer;

class CallStackTracer$InstanceHolder {
    private static CallStackTracer instance = new CallStackTracer();

    private CallStackTracer$InstanceHolder() {
    }

    static /* synthetic */ CallStackTracer access$100() {
        return instance;
    }
}

