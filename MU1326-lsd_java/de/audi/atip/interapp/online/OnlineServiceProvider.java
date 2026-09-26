/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import de.audi.atip.interapp.online.TransitionCallback;
import org.dsi.ifc.global.NavLocation;

public interface OnlineServiceProvider {
    default public void startMediaApp(String string, boolean bl) {
    }

    default public void stopMediaApp(String string) {
    }

    default public void startDestinationApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
    }

    default public void startMapApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
    }

    default public void downloadAppListForNavi() {
    }

    default public void startPhoneApp(String string, boolean bl) {
    }

    default public void stopPhoneApp(String string) {
    }
}

