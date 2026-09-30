/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractNotificationProxy;
import de.audi.app.terminalmode.dsi.carplay.DSICarplaySafe;
import de.audi.app.terminalmode.dsi.carplay.NullDSICarplay;
import de.audi.app.terminalmode.dsi.carplay.SiriAction;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.DSICarplayListener;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public class DSICarplaySafeProxy
extends AbstractNotificationProxy
implements DSICarplaySafe {
    private final DSICarplay nullService;
    private volatile DSICarplay dsi;
    private final DSICarplayListener dsiListener;

    public DSICarplaySafeProxy(LogChannel logChannel, DSICarplayListener dSICarplayListener) {
        this.dsiListener = dSICarplayListener;
        this.dsi = this.nullService = new NullDSICarplay(logChannel);
        this.setNotification(new int[]{3, 4, 5, 7, 8, 9, 10, 12}, (DSIListener)this.dsiListener);
    }

    protected synchronized void addDSIService(DSICarplay dSICarplay) {
        this.dsi = dSICarplay;
        this.newDSIAvailable();
    }

    protected synchronized void removeDSIService() {
        this.dsi = this.nullService;
    }

    protected DSIBase getDSI() {
        return this.dsi;
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.dsi.startService(serviceConfiguration);
    }

    public void postButtonEvent(int n, int n2) {
        this.dsi.postButtonEvent(n, n2);
    }

    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        this.dsi.postTouchEvent(n, n2, touchEventArray);
    }

    public void postRotaryEvent(int n) {
        this.dsi.postRotaryEvent(n);
    }

    public void postCharacterEvent(int n, String[] stringArray) {
        this.dsi.postCharacterEvent(n, stringArray);
    }

    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        this.dsi.requestModeChange(resourceRequestArray, appStateRequestArray, string);
    }

    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.dsi.responseUpdateMode(resourceArray, appStateArray);
    }

    public void responseBTDeactivation() {
        this.dsi.responseBTDeactivation();
    }

    public void requestUI(int n) {
        this.dsi.requestUI(n);
    }

    public void requestNightMode(boolean bl) {
        this.dsi.requestNightMode(bl);
    }

    public void requestSIRIAction(SiriAction siriAction) {
        this.dsi.requestSIRIAction(siriAction.getDSIConstantValue());
    }

    public void responseUpdateMainAudioType(int n) {
        this.dsi.responseUpdateMainAudioType(n);
    }

    public void requestUI2(String string) {
        this.dsi.requestUI2(string);
    }
}

