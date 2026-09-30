/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

public interface TMDSIKeyPanelListener {
    public void updateRecognizerLanguage2(int var1, String var2, int var3);

    public void updateRecognizerMode(int var1, int var2);

    public void updateCharacterEvent2(int var1, String[] var2, int[] var3);
}

