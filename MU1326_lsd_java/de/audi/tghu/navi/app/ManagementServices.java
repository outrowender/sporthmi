/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.command.ETCSetMetricSystemCommand;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.ResetSMCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.Route;

public final class ManagementServices
implements MsgListener {
    private final MsgDistributor messageDistributor;
    private final LogChannel logChannel;
    private final FunctionCounter fc;
    private NavigationEnv env;
    private Navigation navigation;

    public ManagementServices(NavigationEnv navigationEnv, Navigation navigation, FunctionCounter functionCounter) {
        this.env = navigationEnv;
        this.fc = functionCounter;
        this.navigation = navigation;
        this.messageDistributor = navigationEnv.getFramework().getMsgDistrib();
        this.logChannel = navigationEnv.getMsgLogChannel();
    }

    public MsgDistributor getMessageDistributor() {
        return this.messageDistributor;
    }

    public void sendMessage(int n) {
        this.logChannel.log(-2137614336, "ManagementServices#sendMessage( %1 )", (long)n);
        this.messageDistributor.sendMessage(n);
    }

    @Override
    public void processMsg(int n) {
        this.logChannel.log(-2137614336, "ManagementServices#processMessage( %1 ) ", (long)n);
        if (!this.navigation.getOperationManager().isFullyOperable()) {
            this.logChannel.log(-1601830656, "ManagementServices#processMessage() - Navigation is not fully operable -> ignore message!");
            return;
        }
        switch (n) {
            case 23: {
                this.stopRG();
                this.resetNavigation();
                this.navigation.resetMemorySettings();
                this.fc.clearCounters();
                this.navigation.getPicNavInterfaceHandler().resetToFactorySettings();
                break;
            }
            case 24: {
                this.stopRG();
                this.navigation.resetSettings();
                break;
            }
            case 11: {
                this.refreshMetricsSystem();
                this.navigation.unitsChanged(true);
                break;
            }
            case 40: {
                break;
            }
            case 12: 
            case 13: {
                this.navigation.unitsChanged(false);
                break;
            }
            case 15: {
                break;
            }
            case 42: {
                this.navigation.getDsiNavigationManager().getDispatcher(0).updateClockAdjusted(this.env.getFramework().getSysApp().isClockAdjusted());
                break;
            }
            case 205: {
                this.navigation.getNaviFavoriteHandler().resetMyScreenConfiguration();
                break;
            }
            case 206: {
                this.navigation.updateLockingState(true);
                break;
            }
            case 207: {
                this.navigation.updateLockingState(false);
                break;
            }
        }
    }

    private void refreshMetricsSystem() {
        this.logChannel.log(-2137614336, "ManagementServices#refreshMetricsSystem() ");
        OperationManager operationManager = this.navigation.getOperationManager();
        if (operationManager.isFullyOperable()) {
            int n = Util.getCurrentMetricsSystem(false);
            if (n != this.env.getContainer().getEtcMetricSystem()) {
                CommandList commandList = this.navigation.getCommandListFactory().createCommandList(1);
                commandList.add(new ETCSetMetricSystemCommand(n));
                commandList.execute("ManagementServices.refreshMetricsSystem");
            }
        } else {
            this.logChannel.log(-1601830656, "ManagementServices#refreshMetricsSystem() - cannot refresh metrics system, navigation not ready!");
        }
        if (operationManager.isMapReady()) {
            this.navigation.getMapInterface().refreshMetricSystem();
        } else {
            this.logChannel.log(-1601830656, "ManagementServices#refreshMetricsSystem() - cannot refresh metrics system, map not ready!");
        }
    }

    private void stopRG() {
        CommandList commandList = this.navigation.getCommandListFactory().createCommandList(1);
        commandList.add(new RGStopGuidanceCommand());
        commandList.execute("ManagementServices.stopRG");
    }

    private void resetNavigation() {
        CommandList commandList = this.navigation.getCommandListFactory().createCommandList(1);
        commandList.add(new RmMakeRoutePersistentCommand(new Route()));
        commandList.add(new ResetSMCommand());
        commandList.execute("ManagementServices.resetNavigation");
    }

    public void cleanUp() {
        this.navigation = null;
        this.env = null;
    }
}

