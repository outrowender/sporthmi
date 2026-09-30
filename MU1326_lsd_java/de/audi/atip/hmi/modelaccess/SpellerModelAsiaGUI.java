/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.SpellerModelGUI;

public interface SpellerModelAsiaGUI
extends SpellerModelGUI {
    public String getPhonetic();

    public void textChanged(String var1, String var2, int var3);

    public void textChanged(String var1, String var2, char var3, int var4);
}

