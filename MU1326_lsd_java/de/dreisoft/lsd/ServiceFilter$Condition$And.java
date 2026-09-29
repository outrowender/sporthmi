/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$Condition;
import de.dreisoft.lsd.ServiceFilter$Condition$Operation;
import java.util.Dictionary;

public class ServiceFilter$Condition$And
extends ServiceFilter$Condition$Operation {
    @Override
    public boolean hasDestinctServiceInterfaces() {
        int n = this.terms.size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (!((ServiceFilter$Condition)this.terms.get(i2)).hasDestinctServiceInterfaces()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isFulfilled(Dictionary dictionary) {
        int n = this.terms.size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (((ServiceFilter$Condition)this.terms.get(i2)).isFulfilled(dictionary)) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isServiceInterfaceList() {
        return false;
    }
}

