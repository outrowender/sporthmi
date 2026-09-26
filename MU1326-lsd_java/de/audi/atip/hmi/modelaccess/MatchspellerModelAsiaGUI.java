/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;

public interface MatchspellerModelAsiaGUI
extends MatchspellerModelGUI {
    @Override
    default public String getValidNonAlphaNumTPCharacters(int n) {
    }

    @Override
    default public void nonAlphaNumTPCharsChanged(String string, int n) {
    }

    @Override
    default public void inputModeTPChanged(int n, int n2) {
    }

    @Override
    default public int getInitialInputMode(int n) {
    }

    @Override
    default public boolean getAllowNonAlphaNumInput(int n) {
    }
}

