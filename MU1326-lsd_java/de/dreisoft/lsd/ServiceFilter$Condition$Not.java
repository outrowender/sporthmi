/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$Condition;
import de.dreisoft.lsd.ServiceFilter$Condition$Operation;
import java.util.Dictionary;

public class ServiceFilter$Condition$Not
extends ServiceFilter$Condition$Operation {
    @Override
    public boolean hasDestinctServiceInterfaces() {
        return false;
    }

    @Override
    public boolean isFulfilled(Dictionary dictionary) {
        return !((ServiceFilter$Condition)this.terms.get(0)).isFulfilled(dictionary);
    }

    @Override
    public boolean isServiceInterfaceList() {
        return false;
    }
}

