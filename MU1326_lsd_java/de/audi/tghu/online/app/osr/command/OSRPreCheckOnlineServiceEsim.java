/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import org.dsi.ifc.online.OSRServiceState;

public class OSRPreCheckOnlineServiceEsim
extends AbstractOSRCommand {
    private static final String SYMBOLIC_NAME;
    private static final String APP_ID;
    private final LicenseCollectionService licenseCollectionService;

    public OSRPreCheckOnlineServiceEsim(LicenseCollectionService licenseCollectionService) {
        this.licenseCollectionService = licenseCollectionService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "PreCheckOnlineServiceEsim#execute(): Called.");
        if (this.getDSI() != null) {
            this.getDSI().precheckOnlineServiceSymbolicName("service_core", "esim");
        } else {
            this.logger.log(10000, "PreCheckOnlineServiceEsim#execute(): DSI not available");
            this.precheckOnlineServiceSymbolicNameResponse("service_core", null);
        }
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.logger.log(-2137614336, "OSRPreCheckOnlineServiceEsim#precheckOnlineServiceSymbolicNameResponse() appID:%1, state %2", (Object)string, (Object)oSRServiceState);
        if (string == null) {
            this.logger.log(-1601830656, "OSRPreCheckOnlineServiceEsim#precheckOnlineServiceSymbolicNameResponse() appID is null! Call ignored.");
            return;
        }
        if (!"service_core".equals(string)) {
            this.logger.log(-1601830656, "OSRPreCheckOnlineServiceEsim#precheckOnlineServiceSymbolicNameResponse() Call with wrong appID=%1 ignored!", (Object)string);
            return;
        }
        if (this.licenseCollectionService != null) {
            this.licenseCollectionService.preCheckOnlineServiceEsimResponse(string, oSRServiceState);
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
        this.logger.log(10000, "PreCheckOnlineServiceEsim#execute(): Command was canceled!");
        this.precheckOnlineServiceSymbolicNameResponse("esim", null);
        return null;
    }
}

