/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.MatchSpellerListener;

public interface MatchspellerListenerAsia
extends MatchSpellerListener {
    public void nonAlphaNumTPCharsChanged(int var1, int var2, String var3);

    public void inputModeTPChanged(int var1, int var2, int var3);

    public void strokesChanged(int var1, int var2, String var3, char var4);

    public void requestValidHanziCharsWindow(int var1, int var2, int var3, int var4);
}

