/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;

abstract class WeatherLicenseHandler$WLHCommand
extends NavCommand
implements IOnlineServiceListener {
    private IOnlineServiceListener defaultHandler;

    public WeatherLicenseHandler$WLHCommand(IOnlineServiceListener iOnlineServiceListener, String string) {
        super(string);
        this.defaultHandler = iOnlineServiceListener;
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.defaultHandler.getOnlineApplicationResponse(oSRApplication);
    }

    @Override
    public void activateLicenseResponse(int n) {
        this.defaultHandler.activateLicenseResponse(n);
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.defaultHandler.getLicenseInformationResult(oSRLicenseArray);
    }

    @Override
    public void getReminderStatusResult(int n) {
        this.defaultHandler.getReminderStatusResult(n);
    }

    @Override
    public void setReminderStateResponse(int n) {
        this.defaultHandler.setReminderStateResponse(n);
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.defaultHandler.updateApplicationState(oSRNotifyPropertiesArray);
    }
}

