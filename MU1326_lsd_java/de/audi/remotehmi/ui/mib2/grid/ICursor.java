/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;

public interface ICursor {
    public ICursorComponent getFocus();

    public ICursorComponent getSelection();

    public boolean isForceUpdate();

    public ICursor withSelection(ICursorComponent var1);

    public ICursor withSelection(int var1, int var2, String var3, String var4);

    public ICursor withFocus(ICursorComponent var1);

    public ICursor withFocus(int var1, int var2, String var3, String var4);
}

