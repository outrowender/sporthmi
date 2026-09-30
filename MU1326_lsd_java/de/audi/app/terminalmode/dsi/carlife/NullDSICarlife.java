/*
 * Decompiled with CFR 0.152.
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
        super(Preconditions.checkNotNull(logChannel), "NullDSICarlife");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.log("startService");
    }

    public void postButtonEvent(int n, int n2) {
        this.log("postButtonEvent");
    }

    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
        this.log("postTouchEvent");
    }

    public void postRotaryEvent(int n) {
        this.log("postRotaryEvent");
    }

    public void postCharacterEvent(int n, String[] stringArray) {
        this.log("postCharacterEvent");
    }

    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.log("setMode");
    }

    public void requestNightMode(boolean bl) {
        this.log("requestNightMode");
    }

    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.log("responseModeChange");
    }
}

