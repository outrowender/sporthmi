/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;

public interface ISDSDetourHandler {
    default public void blockRoute(int n, NaviServiceListener naviServiceListener) {
    }

    default public void unblockRoute(NaviServiceListener naviServiceListener) {
    }
}

