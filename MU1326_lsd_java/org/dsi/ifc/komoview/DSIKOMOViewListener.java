/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

import org.dsi.ifc.base.DSIListener;

public interface DSIKOMOViewListener
extends DSIListener {
    public void updateKomoViewEnabled(boolean var1, int var2);

    public void updateVisibility(boolean var1, int var2);

    public void komoViewResult(int var1);

    public void updateCurrentKomoViewType(int var1, int var2);
}

