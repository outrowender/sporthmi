/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.app.terminalmode.logging.DSIBaseLoggingDecorator;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public class DSICarlifeLoggingDecorator
extends DSIBaseLoggingDecorator
implements DSICarlife {
    private final DSICarlife wrappee;

    public DSICarlifeLoggingDecorator(DSICarlife dSICarlife, LogChannel logChannel, int n) {
        super(dSICarlife, logChannel, n, "DSICarlife");
        this.wrappee = dSICarlife;
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.lc.log(this.level, "-> [DSICarlife.startService] %1", (Object)serviceConfiguration);
        this.wrappee.startService(serviceConfiguration);
    }

    public void postButtonEvent(int n, int n2) {
        this.lc.log(this.level, "-> [DSICarlife.postButtonEvent] button %1 buttonstate %2", (long)n, (long)n2);
        this.wrappee.postButtonEvent(n, n2);
    }

    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
        this.lc.log(this.level, "-> [DSICarlife.postTouchEvent] touchSource %1, %2, gesture %3", (Object)Integer.toString(n), (Object)Arrays2.toString(touchEventArray), (Object)Integer.toString(n2));
        this.wrappee.postTouchEvent(n, touchEventArray, n2);
    }

    public void postRotaryEvent(int n) {
        this.lc.log(this.level, "-> [DSICarlife.postRotaryEvent] ticks %1", (Object)Integer.toString(n));
        this.wrappee.postRotaryEvent(n);
    }

    public void postCharacterEvent(int n, String[] stringArray) {
        this.lc.log(this.level, "-> [DSICarlife.postCharacterEvent] alternatives %1 characters %2", (Object)Integer.toString(n), (Object)Arrays2.toString(stringArray));
        this.wrappee.postCharacterEvent(n, stringArray);
    }

    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.lc.log(this.level, "-> [DSICarlife.setMode] resources %1 appstates %2", (Object)Arrays2.toString(resourceArray), (Object)Arrays2.toString(appStateArray));
        this.wrappee.setMode(resourceArray, appStateArray);
    }

    public void requestNightMode(boolean bl) {
        this.lc.log(this.level, "-> [DSICarlife.requestNightMode] nightMode %1", (Object)Boolean.toString(bl));
        this.wrappee.requestNightMode(bl);
    }

    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.lc.log(this.level, "-> [DSICarlife.responseModeChange] resources %1 appstates %2", (Object)Arrays2.toString(resourceArray), (Object)Arrays2.toString(appStateArray));
        this.wrappee.responseModeChange(resourceArray, appStateArray);
    }
}

