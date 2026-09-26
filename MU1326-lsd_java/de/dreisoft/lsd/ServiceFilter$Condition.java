/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$1;
import java.util.Dictionary;

abstract class ServiceFilter$Condition {
    private ServiceFilter$Condition() {
    }

    public abstract boolean isFulfilled(Dictionary dictionary) {
    }

    public abstract boolean hasDestinctServiceInterfaces() {
    }

    public abstract boolean isServiceInterfaceList() {
    }

    /* synthetic */ ServiceFilter$Condition(ServiceFilter$1 serviceFilter$1) {
        this();
    }
}

