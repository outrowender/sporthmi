/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface TextEditorListenerDD {
    public void openAlternativesList(int var1, int var2, int var3);

    public boolean alternativeSelected(boolean var1, int var2, int var3, int var4);

    public void textChanged(int var1, int var2, int var3);

    public void commandPressed(int var1, int var2, int var3);

    public void maxTextLengthChanged(int var1);
}

