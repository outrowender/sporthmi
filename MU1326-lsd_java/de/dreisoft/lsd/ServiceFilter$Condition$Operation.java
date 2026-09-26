/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$Condition;
import java.util.ArrayList;
import java.util.List;

public abstract class ServiceFilter$Condition$Operation
extends ServiceFilter$Condition {
    protected List terms = new ArrayList(2);

    public ServiceFilter$Condition$Operation() {
        super(null);
    }

    public void addTerm(ServiceFilter$Condition serviceFilter$Condition) {
        this.terms.add(serviceFilter$Condition);
    }
}

