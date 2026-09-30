/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRServiceState;

public class OSRGetLicensesCommand
extends AbstractOSRCommand {
    protected LicenseCollectionService licenseCollectionService;

    public OSRGetLicensesCommand(LicenseCollectionService licenseCollectionService) {
        this.licenseCollectionService = licenseCollectionService;
    }

    public void execute() {
        this.logger.log(10000000, "[ORSGetLicensesCommand#execute] enter");
        if (this.getDSI() != null) {
            this.getDSI().getLicenses(true, true);
        } else {
            this.logger.log(10000, "[ORSGetLicensesCommand#execute] no DSI available");
            this.getLicensesResponse(4, true, true, null);
        }
    }

    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        this.logger.log(10000000, "[ORSGetLicensesCommand#getLicensesResponse] got %1 licenses, with resultCode %2", oSRLicenseArray == null ? 0L : (long)oSRLicenseArray.length, (long)n);
        if (this.licenseCollectionService != null) {
            this.licenseCollectionService.setLicenseList(n, oSRLicenseArray);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public void abort() {
        this.logger.log(10000, "[ORSGetLicensesCommand#abort] command aborted. Most probably a timeout occured!");
        this.getLicensesResponse(4, true, true, null);
    }
}

