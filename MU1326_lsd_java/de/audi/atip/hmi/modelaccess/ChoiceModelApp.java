/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface ChoiceModelApp
extends ButtonModelApp {
    public void setChoiceListener(ChoiceListener var1);

    public void setValue(int var1);

    public int getValue();

    public void forceUpdate(boolean var1);
}

