/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.license;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import org.dsi.ifc.online.OSRServiceState;

class LicenseCollectionService$4
extends AbstractOSRCommand {
    private final /* synthetic */ LicenseCollectionService this$0;

    LicenseCollectionService$4(LicenseCollectionService licenseCollectionService) {
        this.this$0 = licenseCollectionService;
    }

    @Override
    public void execute() {
        this.this$0.log.log(-2137614336, "LicenseCollectionService#requestLicenses: Could not execute command.");
        this.this$0.modelManager.setServiceListDownloaded(3);
        this.this$0.isLicenseRequestRunning = false;
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

