/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.HMIModel;

public interface HMIModelBank {
    public static final String PROP_KEY_APP_NAME;
    public static final String PROP_KEY_MODULE_ID;
    public static final int ID_MULTIPLIER;

    default public int getId() {
    }

    default public int[] getAllModelIds() {
    }

    default public HMIModel getModel(int n) {
    }

    default public HMIModel getModel(int n, int n2) {
    }

    default public HMIModel[] getModels() {
    }

    default public void resetAllModelListeners() {
    }

    default public void isRegistered(boolean bl) {
    }

    default public void waitForRegistration(IFrameworkAccess iFrameworkAccess) {
    }
}

