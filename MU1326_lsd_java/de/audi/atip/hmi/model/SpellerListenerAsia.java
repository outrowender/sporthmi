/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.SpellerListener;

public interface SpellerListenerAsia
extends SpellerListener {
    public void textChanged(int var1, String var2, String var3, int var4);

    public void textChanged(int var1, String var2, String var3, char var4, int var5);
}

