/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.tghu.navi.app.map.IMapContent;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler$WLHCommand;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRServiceState;

class WeatherLicenseHandler$1
extends WeatherLicenseHandler$WLHCommand {
    private final /* synthetic */ IOnlineServiceListener val$listener;
    private final /* synthetic */ boolean val$jumpToInclude;
    private final /* synthetic */ IMapContent val$mapContent;
    private final /* synthetic */ WeatherLicenseHandler this$0;

    WeatherLicenseHandler$1(WeatherLicenseHandler weatherLicenseHandler, IOnlineServiceListener iOnlineServiceListener, String string, IOnlineServiceListener iOnlineServiceListener2, boolean bl, IMapContent iMapContent) {
        this.this$0 = weatherLicenseHandler;
        this.val$listener = iOnlineServiceListener2;
        this.val$jumpToInclude = bl;
        this.val$mapContent = iMapContent;
        super(iOnlineServiceListener, string);
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "WeatherLicenseHandler#enableWeatherSequence#execute");
        if (this.this$0.service != null) {
            try {
                this.this$0.service.setOnlineApplicationState(1, this);
            }
            catch (Exception exception) {
                this.this$0.logChannel.log(10000, "WeatherLicenseHandler#enableWeatherSequence#execute - ERROR=%1", (Throwable)exception);
                this.getCommandList().commandAborted(exception);
            }
        } else {
            this.this$0.logChannel.log(10000, "WeatherLicenseHandler#enableWeatherSequence#execute - no service");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.this$0.logChannel.log(-2137614336, "WeatherLicenseHandler#enableWeatherSequence#getOnlineApplicationResponse - appState: %1", oSRApplication != null ? (long)oSRApplication.getState() : -1L);
        if (this.val$listener != null) {
            try {
                this.val$listener.getOnlineApplicationResponse(oSRApplication);
                this.getCommandList().commandFinished();
            }
            catch (Exception exception) {
                this.this$0.logChannel.log(10000, "WeatherLicenseHandler#enableWeatherSequence#getOnlineApplicationResponse - ERROR=%1", (Throwable)exception);
                this.getCommandList().commandAborted(exception);
            }
        } else {
            this.this$0.logChannel.log(10000, "WeatherLicenseHandler#enableWeatherSequence#getOnlineApplicationResponse - no listener");
            this.getCommandList().commandFinished();
        }
        if (this.val$jumpToInclude) {
            this.this$0.logChannel.log(-2137614336, "WeatherLicenseHandler#enableWeatherSequence#getOnlineApplicationResponse - jump to include");
            try {
                this.val$mapContent.jumpToInclude();
            }
            catch (Exception exception) {
                this.this$0.logChannel.log(1078071040, "WeatherLicenseHandler#enableWeatherSequence#getOnlineApplicationResponse - ERROR=%1 ", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }
}

