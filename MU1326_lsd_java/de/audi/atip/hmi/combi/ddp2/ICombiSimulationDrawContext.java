/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi.ddp2;

public interface ICombiSimulationDrawContext {
    public void screenConnected();

    public void updateText(int var1, int var2, String var3, int var4);

    public void updateCursor(int var1, int var2, int var3);

    public void setFrameStatus(int var1, int var2);

    public void setActiveSubterminal(int var1);
}

