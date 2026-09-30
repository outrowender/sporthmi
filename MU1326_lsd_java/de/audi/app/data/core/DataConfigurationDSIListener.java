/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

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

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConfigurationDSIListener#asyncException():  called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void updateAvailableProfiles(final CDataProfile[] cDataProfileArray, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updateAvailableProfiles(cDataProfileArray, n);
            }
        });
    }

    public void updateActiveProfile(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updateActiveProfile(n, n2);
            }
        });
    }

    public void updateRoamingState(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updateRoamingState(n, n2);
            }
        });
    }

    public void updateConnectionMode(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updateConnectionMode(n, n2);
            }
        });
    }

    public void updateDataRequest(final int n, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updateDataRequest(n, n2);
            }
        });
    }

    public void updateRequestSetting(final int n, final int n2, final int n3) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updateRequestSetting(n, n2, n3);
            }
        });
    }

    public void setDataProfileResponse(final CDataProfile cDataProfile, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).setDataProfileResponse(cDataProfile, n);
            }
        });
    }

    public void automaticProfileResponse(final int n, final CDataProfile cDataProfile, final int n2) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).automaticProfileResponse(n, cDataProfile, n2);
            }
        });
    }

    public void setRoamingStateResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).setRoamingStateResponse(n);
            }
        });
    }

    public void setConnectionModeResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).setConnectionModeResponse(n);
            }
        });
    }

    public void setRequestSettingResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).setRequestSettingResponse(n);
            }
        });
    }

    public void acceptDataRequestResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).acceptDataRequestResponse(n);
            }
        });
    }

    public void resetPacketCounterResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).resetPacketCounterResponse(n);
            }
        });
    }

    public void restoreFactorySettingsResponse(final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).restoreFactorySettingsResponse(n);
            }
        });
    }

    public void updatePacketCounter(final CPacketCounter cPacketCounter, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDataConfigurationListener)dSIListener).updatePacketCounter(cPacketCounter, n);
            }
        });
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.dataConfigurationDefaultListener;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }
}

