/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.data.core.DataConfigurationDSIListener$1;
import de.audi.app.data.core.DataConfigurationDSIListener$10;
import de.audi.app.data.core.DataConfigurationDSIListener$11;
import de.audi.app.data.core.DataConfigurationDSIListener$12;
import de.audi.app.data.core.DataConfigurationDSIListener$13;
import de.audi.app.data.core.DataConfigurationDSIListener$14;
import de.audi.app.data.core.DataConfigurationDSIListener$15;
import de.audi.app.data.core.DataConfigurationDSIListener$2;
import de.audi.app.data.core.DataConfigurationDSIListener$3;
import de.audi.app.data.core.DataConfigurationDSIListener$4;
import de.audi.app.data.core.DataConfigurationDSIListener$5;
import de.audi.app.data.core.DataConfigurationDSIListener$6;
import de.audi.app.data.core.DataConfigurationDSIListener$7;
import de.audi.app.data.core.DataConfigurationDSIListener$8;
import de.audi.app.data.core.DataConfigurationDSIListener$9;
import de.audi.app.data.core.DataConfigurationDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDSIListener
implements DSIDataConfigurationListener,
ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final DataConfigurationDefaultListener dataConfigurationDefaultListener;
    private final LogChannel log;

    DataConfigurationDSIListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.cmdListManager = commandListManager;
        this.dataConfigurationDefaultListener = new DataConfigurationDefaultListener(logChannel);
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConfigurationDSIListener#asyncException():  called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$1(this, cDataProfileArray, n));
    }

    @Override
    public void updateActiveProfile(int n, int n2) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$2(this, n, n2));
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$3(this, n, n2));
    }

    @Override
    public void updateConnectionMode(int n, int n2) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$4(this, n, n2));
    }

    @Override
    public void updateDataRequest(int n, int n2) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$5(this, n, n2));
    }

    @Override
    public void updateRequestSetting(int n, int n2, int n3) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$6(this, n, n2, n3));
    }

    @Override
    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$7(this, cDataProfile, n));
    }

    @Override
    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$8(this, n, cDataProfile, n2));
    }

    @Override
    public void setRoamingStateResponse(int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$9(this, n));
    }

    @Override
    public void setConnectionModeResponse(int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$10(this, n));
    }

    @Override
    public void setRequestSettingResponse(int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$11(this, n));
    }

    @Override
    public void acceptDataRequestResponse(int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$12(this, n));
    }

    @Override
    public void resetPacketCounterResponse(int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$13(this, n));
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$14(this, n));
    }

    @Override
    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        CommandResponse.execute(this, new DataConfigurationDSIListener$15(this, cPacketCounter, n));
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.dataConfigurationDefaultListener;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }
}

