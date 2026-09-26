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
    public static final int UNDEFINED_ID;
    public static final String UNDEFINED_URI;
    public static final int STATUS_VALID;
    public static final int STATUS_INVALID;

    default public void setResourceLocator(int n, String string) {
    }

    default public void setResourceLocator(int n, String string, int n2) {
    }

    default public void setResourceLocator(HMIResourceLocator hMIResourceLocator) {
    }

    static {
        UNDEFINED_URI = null;
    }
}

