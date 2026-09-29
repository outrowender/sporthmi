/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.androidauto2;

import de.audi.app.terminalmode.dsi.AbstractNotificationProxy;
import de.audi.app.terminalmode.dsi.androidauto2.NullDSIAndroidAuto2;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class DSIAndroidAuto2Proxy
extends AbstractNotificationProxy
implements DSIAndroidAuto2 {
    private final NullDSIAndroidAuto2 nullService;
    private volatile DSIAndroidAuto2 dsi;
    private final DSIAndroidAuto2Listener dsiListener;

    public DSIAndroidAuto2Proxy(LogChannel logChannel, DSIAndroidAuto2Listener dSIAndroidAuto2Listener) {
        this.dsiListener = dSIAndroidAuto2Listener;
        this.nullService = new NullDSIAndroidAuto2(logChannel);
        this.dsi = this.nullService;
    }

    protected synchronized void addDSIService(DSIAndroidAuto2 dSIAndroidAuto2) {
        this.dsi = dSIAndroidAuto2;
        this.newDSIAvailable();
    }

    protected synchronized void removeDSIService() {
        this.dsi = this.nullService;
    }

    @Override
    protected DSIBase getDSI() {
        return this.dsi;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    public void videoFocusNotification(int n, boolean bl) {
        this.dsi.videoFocusNotification(n, bl);
    }

    @Override
    public void audioFocusNotification(int n, boolean bl) {
        this.dsi.audioFocusNotification(n, bl);
    }

    @Override
    public void microphoneNotification(int n, boolean bl) {
        this.dsi.microphoneNotification(n, bl);
    }

    @Override
    public void navFocusNotification(int n, boolean bl) {
        this.dsi.navFocusNotification(n, bl);
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        this.dsi.startService(serviceConfiguration);
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        this.dsi.postButtonEvent(n, n2);
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        this.dsi.postTouchEvent(n, touchEventArray, n2, n3);
    }

    @Override
    public void postRotaryEvent(int n) {
        this.dsi.postRotaryEvent(n);
    }

    @Override
    public void setNightMode(boolean bl) {
        this.dsi.setNightMode(bl);
    }

    @Override
    public void bluetoothPairingResponse(boolean bl) {
        this.dsi.bluetoothPairingResponse(bl);
    }

    @Override
    public void bluetoothAuthenticationData(String string) {
        this.dsi.bluetoothAuthenticationData(string);
    }
}

