/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRServiceState;

public class OSRActivateLicenseCommand
extends AbstractOSRCommand {
    private final String applicationId;
    private final OSRLicense license;
    private final IOnlineServiceListener callback;
    private volatile int status = -1;

    public OSRActivateLicenseCommand(String string, OSRLicense oSRLicense, IOnlineServiceListener iOnlineServiceListener) {
        this.applicationId = string;
        this.license = oSRLicense;
        this.callback = iOnlineServiceListener;
    }

    public OSRActivateLicenseCommand(String string, OSRLicense oSRLicense) {
        this.applicationId = string;
        this.license = oSRLicense;
        this.callback = null;
    }

    public void execute() {
        this.logger.log(10000000, "ORSActivateLicenseCommand#execute() applicationId: %1 license>%2", (Object)this.applicationId, (Object)this.license.getId());
        this.getDSI().activateLicense(this.license);
    }

    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.status = n;
        if (this.callback != null) {
            this.callback.activateLicenseResponse(n);
        }
        this.getCommandList().commandFinished();
    }

    public int getLicenseStatus() {
        return this.status;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

