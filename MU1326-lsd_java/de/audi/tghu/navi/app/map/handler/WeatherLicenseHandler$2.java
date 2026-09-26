/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler$WLHCommand;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRServiceState;

class WeatherLicenseHandler$2
extends WeatherLicenseHandler$WLHCommand {
    private final /* synthetic */ IOnlineServiceListener val$listener;
    private final /* synthetic */ WeatherLicenseHandler this$0;

    WeatherLicenseHandler$2(WeatherLicenseHandler weatherLicenseHandler, IOnlineServiceListener iOnlineServiceListener, String string, IOnlineServiceListener iOnlineServiceListener2) {
        this.this$0 = weatherLicenseHandler;
        this.val$listener = iOnlineServiceListener2;
        super(iOnlineServiceListener, string);
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherSequence#execute");
        if (this.this$0.service != null) {
            try {
                this.this$0.service.setOnlineApplicationState(0, this);
            }
            catch (Exception exception) {
                this.this$0.logChannel.log(10000, "WeatherLicenseHandler#disableWeatherSequence#execute - ERROR=%1", (Throwable)exception);
                this.getCommandList().commandAborted(exception);
            }
        } else {
            this.this$0.logChannel.log(10000, "WeatherLicenseHandler#disableWeatherSequence#execute - no service");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.this$0.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherSequence#getOnlineApplicationResponse - appState: %1", oSRApplication != null ? (long)oSRApplication.getState() : -1L);
        if (this.val$listener != null) {
            try {
                this.val$listener.getOnlineApplicationResponse(oSRApplication);
                this.getCommandList().commandFinished();
            }
            catch (Exception exception) {
                this.this$0.logChannel.log(10000, "WeatherLicenseHandler#disableWeatherSequence#getOnlineApplicationResponse - ERROR=%1", (Throwable)exception);
                this.getCommandList().commandAborted(exception);
            }
        } else {
            this.this$0.logChannel.log(10000, "WeatherLicenseHandler#disableWeatherSequence#getOnlineApplicationResponse - no listener");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }
}

