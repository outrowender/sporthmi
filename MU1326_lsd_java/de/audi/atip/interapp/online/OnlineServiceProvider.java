/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.TransitionCallback;
import org.dsi.ifc.global.NavLocation;

public interface OnlineServiceProvider {
    public void startMediaApp(String var1, boolean var2);

    public void stopMediaApp(String var1);

    public void startDestinationApp(NavLocation var1, String var2, TransitionCallback var3);

    public void startMapApp(NavLocation var1, String var2, TransitionCallback var3);

    public void downloadAppListForNavi();

    public void startPhoneApp(String var1, boolean var2);

    public void stopPhoneApp(String var1);
}

