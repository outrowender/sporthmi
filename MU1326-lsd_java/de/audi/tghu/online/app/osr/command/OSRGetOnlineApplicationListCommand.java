/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRServiceState;

public class OSRGetOnlineApplicationListCommand
extends AbstractOSRCommand {
    private static final OSRApplication[] EMPTY_APP_LIST = new OSRApplication[0];
    private LicenseCollectionService licenseCollector;

    public OSRGetOnlineApplicationListCommand(LicenseCollectionService licenseCollectionService) {
        this.licenseCollector = licenseCollectionService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ORSGetOnlineApplicationListCommand#execute] enter");
        if (this.getDSI() != null) {
            this.getDSI().getOnlineApplicationList();
        } else {
            this.logger.log(10000, "[ORSGetOnlineApplicationListCommand#execute]: no DSI available");
            this.getOnlineApplicationListResponse(EMPTY_APP_LIST);
        }
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        for (int i2 = 0; i2 < oSRApplicationArray.length; ++i2) {
            this.logger.log(-2137614336, "[ORSGetOnlineApplicationListCommand#getOnlineApplicationListResponse] adding application: %1", (Object)oSRApplicationArray[i2].getId());
            this.application.getContainer().addOrUpdateOnlineApplication(oSRApplicationArray[i2], this.application);
        }
        this.application.syncServices();
        if (this.licenseCollector != null) {
            this.licenseCollector.sendToSouthside(oSRApplicationArray);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

