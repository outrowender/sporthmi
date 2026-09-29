/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import org.dsi.ifc.map.PosInfo;

public interface HasPosInfo {
    default public void updateInfoForPosition(PosInfo[] posInfoArray) {
    }

    default public PosInfo[] getInfoList() {
    }
}

