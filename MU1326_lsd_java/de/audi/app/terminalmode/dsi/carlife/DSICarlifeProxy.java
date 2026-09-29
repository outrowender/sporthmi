/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carlife;

import de.audi.app.terminalmode.dsi.AbstractNotificationProxy;
import de.audi.app.terminalmode.dsi.carlife.NullDSICarlife;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public class DSICarlifeProxy
extends AbstractNotificationProxy
implements DSICarlife {
    private final NullDSICarlife nullService;
    private volatile DSICarlife dsi;
    private final DSICarlifeListener dsiListener;

    public DSICarlifeProxy(LogChannel logChannel, DSICarlifeListener dSICarlifeListener) {
        this.dsiListener = dSICarlifeListener;
        this.nullService = new NullDSICarlife(logChannel);
        this.dsi = this.nullService;
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
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
        this.dsi.postTouchEvent(n, touchEventArray, n2);
    }

    @Override
    public void postRotaryEvent(int n) {
        this.dsi.postRotaryEvent(n);
    }

    @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        this.dsi.postCharacterEvent(n, stringArray);
    }

    @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.dsi.setMode(resourceArray, appStateArray);
    }

    @Override
    public void requestNightMode(boolean bl) {
        this.dsi.requestNightMode(bl);
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.dsi.responseModeChange(resourceArray, appStateArray);
    }

    protected synchronized void addDSIService(DSICarlife dSICarlife) {
        this.dsi = dSICarlife;
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
}

