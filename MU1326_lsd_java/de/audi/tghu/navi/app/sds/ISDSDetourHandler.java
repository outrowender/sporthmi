/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;

public interface ISDSDetourHandler {
    public void blockRoute(int var1, NaviServiceListener var2);

    public void unblockRoute(NaviServiceListener var1);
}

