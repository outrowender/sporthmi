/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfiguration;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

public abstract class AbstractDataCommand
extends Command
implements DSIDataConfigurationListener {
    protected static final int RESULT_OK = 0;
    protected static final int RESULT_ERROR = 1;
    protected final DSIDataConfiguration dsi;

    protected static void schedule(CommandListManager commandListManager, Command command) {
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(command);
        commandList.execute(command.getName());
    }

    protected AbstractDataCommand(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration, String string) {
        super(logChannel, string);
        this.dsi = dSIDataConfiguration;
    }

    public void acceptDataRequestResponse(int n) {
    }

    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
    }

    public void resetPacketCounterResponse(int n) {
    }

    public void restoreFactorySettingsResponse(int n) {
    }

    public void setConnectionModeResponse(int n) {
    }

    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
    }

    public void setRequestSettingResponse(int n) {
    }

    public void setRoamingStateResponse(int n) {
    }

    public void updateActiveProfile(int n, int n2) {
    }

    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
    }

    public void updateConnectionMode(int n, int n2) {
    }

    public void updateDataRequest(int n, int n2) {
    }

    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
    }

    public void updateRequestSetting(int n, int n2, int n3) {
    }

    public void updateRoamingState(int n, int n2) {
    }
}

