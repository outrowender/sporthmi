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
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullDSICarplay(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.setNotification]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.setNotification]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.setNotification]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.clearNotification]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.clearNotification]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.clearNotification]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void responseBTDeactivation() {
        this.logger.log(1078071040, "[%1.responseBTDeactivation]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void requestUI(int n) {
        this.logger.log(1078071040, "[%1.requestUI]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void requestUI2(String string) {
        this.logger.log(1078071040, "[%1.requestUI]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        this.logger.log(1078071040, "[%1.postTouchEvent]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        this.logger.log(1078071040, "[%1.startService]", (Object)"NullDSIDigitailIpodOut");
    }

    public void stopService() {
        this.logger.log(1078071040, "[%1.stopService]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        this.logger.log(1078071040, "[%1.postButtonEvent]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void postRotaryEvent(int n) {
        this.logger.log(1078071040, "[%1.postRotaryEvent]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        this.logger.log(1078071040, "[%1.postCharacterEvent]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        this.logger.log(1078071040, "[%1.requestModeChange]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void requestNightMode(boolean bl) {
        this.logger.log(1078071040, "[%1.requestNightMode]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void requestSIRIAction(int n) {
        this.logger.log(1078071040, "[%1.requestSIRIAction]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.logger.log(1078071040, "[%1.responseUpdateMode]", (Object)"NullDSIDigitailIpodOut");
    }

    @Override
    public void responseUpdateMainAudioType(int n) {
        this.logger.log(1078071040, "[%1.responseUpdateMainAudioType]", (Object)"NullDSIDigitailIpodOut");
    }
}

