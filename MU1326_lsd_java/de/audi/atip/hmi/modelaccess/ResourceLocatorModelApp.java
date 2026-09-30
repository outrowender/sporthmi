/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;

public interface ResourceLocatorModelApp
extends HMIModelApp,
ResourceLocatorModelGUI {
    public static final int UNDEFINED_ID = -1;
    public static final String UNDEFINED_URI = null;
    public static final int STATUS_VALID = 0;
    public static final int STATUS_INVALID = 1;

    public void setResourceLocator(int var1, String var2);

    public void setResourceLocator(int var1, String var2, int var3);

    public void setResourceLocator(HMIResourceLocator var1);
}

