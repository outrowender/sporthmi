/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.androidauto2;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import de.audi.atip.utils.Preconditions;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;

public class NullDSIAndroidAuto2
extends NullDSIBase
implements DSIAndroidAuto2 {
    public NullDSIAndroidAuto2(LogChannel logChannel) {
        super(Preconditions.checkNotNull(logChannel), "NullDSIAndroidAuto");
    }

    public void postButtonEvent(int n, int n2) {
        this.log("postButtonEvent");
    }

    public void postRotaryEvent(int n) {
        this.log("postRotaryEvent");
    }

    public void videoFocusNotification(int n, boolean bl) {
        this.log("videoFocusNotification");
    }

    public void audioFocusNotification(int n, boolean bl) {
        this.log("audioFocusNotification");
    }

    public void microphoneNotification(int n, boolean bl) {
        this.log("microphoneNotification");
    }

    public void navFocusNotification(int n, boolean bl) {
        this.log("navFocusNotification");
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.log("startService");
    }

    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        this.log("postTouchEvent");
    }

    public void setNightMode(boolean bl) {
        this.log("setNightMode");
    }

    public void bluetoothPairingResponse(boolean bl) {
        this.log("bluetoothPairingResponse");
    }

    public void bluetoothAuthenticationData(String string) {
        this.log("bluetoothAuthenticationData");
    }
}

