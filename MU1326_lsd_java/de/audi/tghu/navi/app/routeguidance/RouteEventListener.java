/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

public interface RouteEventListener {
    public void onUpdateRgActive(boolean var1);

    public void onRouteStarted();

    public void onRouteTerminated();
}

