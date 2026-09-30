/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ButtonListener;

public interface ChoiceListener
extends ButtonListener {
    public void itemSelected(int var1, int var2, int var3, int var4);

    public void itemFocused(int var1, int var2, int var3, int var4);
}

