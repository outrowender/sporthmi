/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import org.dsi.ifc.map.PosInfo;

public interface HasPosInfo {
    public void updateInfoForPosition(PosInfo[] var1);

    public PosInfo[] getInfoList();
}

