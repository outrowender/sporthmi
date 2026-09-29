/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.app.terminalmode.dsi.carlife;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import de.audi.atip.utils.Preconditions;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public class NullDSICarlife
extends NullDSIBase
implements DSICarlife {
    public NullDSICarlife(LogChannel logChannel) {
        super((LogChannel)Preconditions.checkNotNull((Object)logChannel), "NullDSICarlife");
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        this.log("startService");
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        this.log("postButtonEvent");
    }

    @Override
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
        this.log("postTouchEvent");
    }

    @Override
    public void postRotaryEvent(int n) {
        this.log("postRotaryEvent");
    }

    @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        this.log("postCharacterEvent");
    }

    @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.log("setMode");
    }

    @Override
    public void requestNightMode(boolean bl) {
        this.log("requestNightMode");
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.log("responseModeChange");
    }
}

