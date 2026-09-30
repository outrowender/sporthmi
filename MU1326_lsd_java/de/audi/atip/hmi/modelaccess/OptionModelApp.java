/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface OptionModelApp
extends HMIModelApp {
    public void setListener(OptionModelListener var1);

    public void setListener(OptionModelListener var1, int var2);

    public void removeListener(int var1);

    public void setCustomIDListener(OptionModelListener var1, int var2);

    public void removeCustomIDListener(int var1);
}

