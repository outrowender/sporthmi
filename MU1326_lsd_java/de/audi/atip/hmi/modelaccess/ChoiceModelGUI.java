/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public interface ChoiceModelGUI
extends ButtonModelGUI {
    public int getValue();

    public void itemSelected(int var1, int var2);

    public void itemFocused(int var1, int var2);
}

