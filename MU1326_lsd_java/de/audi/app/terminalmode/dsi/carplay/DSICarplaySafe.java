/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.carplay.SiriAction;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public interface DSICarplaySafe {
    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void postCharacterEvent(int n, String[] stringArray) {
    }

    default public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
    }

    default public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void responseBTDeactivation() {
    }

    default public void requestUI(int n) {
    }

    default public void requestUI2(String string) {
    }

    default public void requestNightMode(boolean bl) {
    }

    default public void requestSIRIAction(SiriAction siriAction) {
    }

    default public void responseUpdateMainAudioType(int n) {
    }
}

