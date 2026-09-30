/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

public interface ISpellerMode {
    public void spellerModeChanged();

    public void textChanged(int var1, String var2, char var3, int var4);

    public String getValidChars(String var1);
}

