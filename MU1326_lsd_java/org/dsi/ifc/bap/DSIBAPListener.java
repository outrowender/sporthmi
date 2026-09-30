/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bap;

import org.dsi.ifc.base.DSIListener;

public interface DSIBAPListener
extends DSIListener {
    public void bapStateStatus(int var1, int var2);

    public void indication(int var1, int var2, int var3, int var4, int var5);

    public void indicationVoid(int var1, int var2, int var3);

    public void indicationByteSequence(int var1, int var2, int var3, byte[] var4);

    public void indicationError(int var1, int var2, int var3);

    public void acknowledge(int var1, int var2, int var3);
}

