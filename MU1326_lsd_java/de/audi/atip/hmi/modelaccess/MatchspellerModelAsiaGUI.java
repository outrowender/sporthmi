/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;

public interface MatchspellerModelAsiaGUI
extends MatchspellerModelGUI {
    public String getValidNonAlphaNumTPCharacters(int var1);

    public void nonAlphaNumTPCharsChanged(String var1, int var2);

    public void inputModeTPChanged(int var1, int var2);

    public int getInitialInputMode(int var1);

    public boolean getAllowNonAlphaNumInput(int var1);
}

