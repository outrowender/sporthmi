/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$IReusable;

public abstract class ReusableInstanceCache$AbstractInstanceFactory {
    public abstract ReusableInstanceCache$IReusable newInstance(String string) {
    }

    private final ReusableInstanceCache$IReusable createAndCheckForNull(String string) {
        ReusableInstanceCache$IReusable reusableInstanceCache$IReusable = this.newInstance(string);
        if (reusableInstanceCache$IReusable == null) {
            throw new NullPointerException("Factory returned null.");
        }
        return reusableInstanceCache$IReusable;
    }

    static /* synthetic */ ReusableInstanceCache$IReusable access$000(ReusableInstanceCache$AbstractInstanceFactory reusableInstanceCache$AbstractInstanceFactory, String string) {
        return reusableInstanceCache$AbstractInstanceFactory.createAndCheckForNull(string);
    }
}

