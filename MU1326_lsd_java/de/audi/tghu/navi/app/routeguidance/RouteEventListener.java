/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

public interface RouteEventListener {
    default public void onUpdateRgActive(boolean bl) {
    }

    default public void onRouteStarted() {
    }

    default public void onRouteTerminated() {
    }
}

