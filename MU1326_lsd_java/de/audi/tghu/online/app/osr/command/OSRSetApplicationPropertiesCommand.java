/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.OnlineServiceRegistrationHelper;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRServiceState;

public class OSRSetApplicationPropertiesCommand
extends AbstractOSRCommand {
    private final String applicationId;
    private final OSRApplicationProperties[] propertyList;

    public OSRSetApplicationPropertiesCommand(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        this.applicationId = string;
        this.propertyList = oSRApplicationPropertiesArray;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ORSSetApplicationPropertiesCommand#execute] enter");
        this.getDSI().setApplicationProperties(this.applicationId, this.propertyList);
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logger.log(-2137614336, "[ORSSetApplicationPropertiesCommand#getOnlineApplicationResponse] application:%1", (Object)(oSRApplication != null ? oSRApplication.getId() : null));
        if (oSRApplication != null) {
            super.getOnlineApplicationResponse(oSRApplication);
            this.checkReminderResponse(oSRApplication);
        }
        this.getCommandList().commandFinished();
    }

    private void checkReminderResponse(OSRApplication oSRApplication) {
        this.logger.log(-2137614336, "[ORSSetApplicationPropertiesCommand#getOnlineApplicationResponse]");
        int n = OnlineServiceRegistrationHelper.getReminderStatus(this.propertyList, this.logger);
        int n2 = OnlineServiceRegistrationHelper.getReminderStatus(oSRApplication, this.logger);
        if (n != n2) {
            this.logger.log(-1601830656, "[ORSSetApplicationPropertiesCommand#getOnlineApplicationResponse] - different reminder state expected! current %1, expected %2", (long)n2, (long)n);
        }
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

