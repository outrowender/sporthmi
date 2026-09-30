/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

public interface ICursorComponent {
    public static final int NO_SELECTION = -1;

    public int getIndex();

    public int getSubindex();

    public String getId();

    public String getSubid();

    public int getRightDrawerIndex();

    public ICursorComponent withRightDrawerIndex(int var1);

    public ICursorComponent withValues(int var1, int var2, String var3, String var4);

    public ICursorComponent withValues(int var1, int var2, String var3, String var4, int var5);

    public ICursorComponent withDefaultValues();

    public boolean equalsIgnoringRightDrawer(ICursorComponent var1);
}

