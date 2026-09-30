/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komogfxstreamsink;

import org.dsi.ifc.base.DSIListener;

public interface DSIKOMOGfxStreamSinkListener
extends DSIListener {
    public void updateGfxState(int var1, int var2);

    public void updateRequestSync(int var1, int var2);

    public void updateDataRate(int var1, int var2);

    public void setFGLayerResult(int var1);

    public void fadeInResult();

    public void fadeOutResult();
}

