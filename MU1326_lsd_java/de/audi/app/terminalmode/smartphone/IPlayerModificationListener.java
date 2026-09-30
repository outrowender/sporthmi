/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

public interface IPlayerModificationListener {
    public void skip(boolean var1, int var2);

    public void seek(boolean var1, boolean var2);

    public void resume();

    public void pause(boolean var1);
}

