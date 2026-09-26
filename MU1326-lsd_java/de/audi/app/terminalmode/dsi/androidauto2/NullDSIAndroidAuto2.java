/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
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
        super((LogChannel)Preconditions.checkNotNull((Object)logChannel), "NullDSIAndroidAuto");
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        this.log("postButtonEvent");
    }

    @Override
    public void postRotaryEvent(int n) {
        this.log("postRotaryEvent");
    }

    @Override
    public void videoFocusNotification(int n, boolean bl) {
        this.log("videoFocusNotification");
    }

    @Override
    public void audioFocusNotification(int n, boolean bl) {
        this.log("audioFocusNotification");
    }

    @Override
    public void microphoneNotification(int n, boolean bl) {
        this.log("microphoneNotification");
    }

    @Override
    public void navFocusNotification(int n, boolean bl) {
        this.log("navFocusNotification");
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        this.log("startService");
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        this.log("postTouchEvent");
    }

    @Override
    public void setNightMode(boolean bl) {
        this.log("setNightMode");
    }

    @Override
    public void bluetoothPairingResponse(boolean bl) {
        this.log("bluetoothPairingResponse");
    }

    @Override
    public void bluetoothAuthenticationData(String string) {
        this.log("bluetoothAuthenticationData");
    }
}

