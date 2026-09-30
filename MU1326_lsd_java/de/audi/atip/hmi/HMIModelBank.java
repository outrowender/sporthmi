/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.HMIModel;

public interface HMIModelBank {
    public static final String PROP_KEY_APP_NAME = "ApplicationName";
    public static final String PROP_KEY_MODULE_ID = "moduleID";
    public static final int ID_MULTIPLIER = 100000;

    public int getId();

    public int[] getAllModelIds();

    public HMIModel getModel(int var1);

    public HMIModel getModel(int var1, int var2);

    public HMIModel[] getModels();

    public void resetAllModelListeners();

    public void isRegistered(boolean var1);

    public void waitForRegistration(IFrameworkAccess var1);
}

