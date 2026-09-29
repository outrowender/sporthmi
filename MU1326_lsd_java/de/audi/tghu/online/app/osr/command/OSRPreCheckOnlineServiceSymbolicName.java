/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import org.dsi.ifc.online.OSRServiceState;

public class OSRPreCheckOnlineServiceSymbolicName
extends AbstractOSRCommand {
    private final String appID;
    private final String symbolicName;
    private final LicenseCollectionService licenseCollectionService;

    public OSRPreCheckOnlineServiceSymbolicName(String string, String string2, LicenseCollectionService licenseCollectionService) {
        this.appID = string;
        this.symbolicName = string2;
        this.licenseCollectionService = licenseCollectionService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "OSRPreCheckOnlineServiceSymbolicName#execute(): Called.");
        if (this.getDSI() != null) {
            this.getDSI().precheckOnlineServiceSymbolicName(this.appID, this.symbolicName);
        } else {
            this.logger.log(10000, "OSRPreCheckOnlineServiceSymbolicName#execute(): DSI not available");
            this.precheckOnlineServiceSymbolicNameResponse(this.appID, null);
        }
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.logger.log(-2137614336, "OSRPreCheckOnlineServiceSymbolicName#precheckOnlineServiceSymbolicNameResponse() appID:%1, state %2", (Object)string, (Object)oSRServiceState);
        if (string == null || this.appID == null) {
            this.logger.log(-1601830656, "OSRPreCheckOnlineServiceSymbolicName#precheckOnlineServiceSymbolicNameResponse() appID is null! Call ignored. (%1, %2)", (Object)this.appID, (Object)string);
            return;
        }
        if (!this.appID.equals(string)) {
            this.logger.log(-1601830656, "OSRPreCheckOnlineServiceSymbolicName#precheckOnlineServiceSymbolicNameResponse() appID:%1, call with wrong appID=%2 ignored!", (Object)this.appID, (Object)string);
            return;
        }
        if (oSRServiceState != null && this.symbolicName != null && !this.symbolicName.equals(oSRServiceState.getSymbolicName())) {
            this.logger.log(-1601830656, "OSRPreCheckOnlineServiceSymbolicName#precheckOnlineServiceSymbolicNameResponse() symbolicName:%1, call with wrong symbolicName=%2 ignored!", (Object)this.symbolicName, (Object)oSRServiceState.getSymbolicName());
            return;
        }
        if (this.licenseCollectionService != null) {
            this.licenseCollectionService.preCheckOnlineServiceSymbolicNameResponse(string, oSRServiceState);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    protected Command canceled() {
        this.logger.log(10000, "OSRPreCheckOnlineServiceSymbolicName#execute(): Command was canceled!");
        this.precheckOnlineServiceSymbolicNameResponse(this.appID, null);
        return null;
    }
}

