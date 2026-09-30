/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public class NullDSICarplay
implements DSICarplay {
    private static final String LOGCLASS = "NullDSIDigitailIpodOut";
    private final LogChannel logger;

    public NullDSICarplay(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.setNotification]", (Object)LOGCLASS);
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.setNotification]", (Object)LOGCLASS);
    }

    public void setNotification(DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.setNotification]", (Object)LOGCLASS);
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.clearNotification]", (Object)LOGCLASS);
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.clearNotification]", (Object)LOGCLASS);
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.clearNotification]", (Object)LOGCLASS);
    }

    public void responseBTDeactivation() {
        this.logger.log(1000000, "[%1.responseBTDeactivation]", (Object)LOGCLASS);
    }

    public void requestUI(int n) {
        this.logger.log(1000000, "[%1.requestUI]", (Object)LOGCLASS);
    }

    public void requestUI2(String string) {
        this.logger.log(1000000, "[%1.requestUI]", (Object)LOGCLASS);
    }

    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        this.logger.log(1000000, "[%1.postTouchEvent]", (Object)LOGCLASS);
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.logger.log(1000000, "[%1.startService]", (Object)LOGCLASS);
    }

    public void stopService() {
        this.logger.log(1000000, "[%1.stopService]", (Object)LOGCLASS);
    }

    public void postButtonEvent(int n, int n2) {
        this.logger.log(1000000, "[%1.postButtonEvent]", (Object)LOGCLASS);
    }

    public void postRotaryEvent(int n) {
        this.logger.log(1000000, "[%1.postRotaryEvent]", (Object)LOGCLASS);
    }

    public void postCharacterEvent(int n, String[] stringArray) {
        this.logger.log(1000000, "[%1.postCharacterEvent]", (Object)LOGCLASS);
    }

    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        this.logger.log(1000000, "[%1.requestModeChange]", (Object)LOGCLASS);
    }

    public void requestNightMode(boolean bl) {
        this.logger.log(1000000, "[%1.requestNightMode]", (Object)LOGCLASS);
    }

    public void requestSIRIAction(int n) {
        this.logger.log(1000000, "[%1.requestSIRIAction]", (Object)LOGCLASS);
    }

    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.logger.log(1000000, "[%1.responseUpdateMode]", (Object)LOGCLASS);
    }

    public void responseUpdateMainAudioType(int n) {
        this.logger.log(1000000, "[%1.responseUpdateMainAudioType]", (Object)LOGCLASS);
    }
}

