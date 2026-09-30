/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komonavinfo;

import org.dsi.ifc.base.DSIListener;

public interface DSIKOMONavInfoListener
extends DSIListener {
    public void setCurrentStreetResult(int var1);

    public void setTurnToStreetResult(int var1);

    public void setCityNameResult(int var1);

    public void setSemiDynRouteResult(int var1);

    public void setTrafficOffsetResult(int var1);

    public void setRgSelectResult(int var1);

    public void setCapabilitiesResult(int var1);

    public void setMapScaleResult(int var1, int var2, boolean[] var3, int var4, int var5, boolean[] var6, boolean var7);

    public void setMapScale(int var1, int var2, boolean[] var3, int var4, int var5, int var6);
}

