/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$1;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$2;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$UpdateTrafficSignCommand;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.tr.TrafficUtil;

public class TrafficRegulationInterAppService {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final TrafficRegulationService trafficRegulationService;
    private final ICommandListFactory commandListFactory;

    public TrafficRegulationInterAppService(TrafficRegulationService trafficRegulationService, LogChannel logChannel, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv) {
        this.trafficRegulationService = trafficRegulationService;
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
    }

    public void requestCurrentSpeedLimit(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "TrafficRegulationInterAppService#requestCurrentSpeedLimit()");
        if (this.trafficRegulationService == null || !this.trafficRegulationService.isTrafficRegulationPresent()) {
            this.logChannel.log(-1601830656, "TrafficRegulationInterAppService#requestCurrentSpeedLimit() - traffic regulation is not present!");
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new TrafficRegulationInterAppService$1(this, naviServiceListener));
            commandList.execute("TrafficRegulationInterAppService#requestCurrentSpeedLimit_noTrafficRegulation");
            return;
        }
        if (TrafficUtil.isTrafficRegulationInfoEnabled(this.env)) {
            int n = this.trafficRegulationService.getCurrentSpeedLimit();
            byte by = this.trafficRegulationService.getCurrentSpeedLimitUnit();
            byte by2 = n == 0 || by == -1 ? (byte)3 : 0;
            this.logChannel.log(-2137614336, "TrafficRegulationInterAppService#requestCurrentSpeedLimit() - VZA enabled, notify SDS with result=%1, currentSpeedLimit=%2, currentSpeedLimitUnit=%3", (long)by2, (long)n, (long)by);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new TrafficRegulationInterAppService$2(this, naviServiceListener, by2, n, by));
            commandList.execute("TrafficRegulationInterAppService#requestCurrentSpeedLimit_trafficRegulationEnabled");
        } else {
            this.logChannel.log(-2137614336, "TrafficRegulationInterAppService#requestCurrentSpeedLimit() - VZA disabled, shortly enable VZA and wait for update");
            TrafficRegulationInterAppService$UpdateTrafficSignCommand trafficRegulationInterAppService$UpdateTrafficSignCommand = new TrafficRegulationInterAppService$UpdateTrafficSignCommand(this, naviServiceListener);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(trafficRegulationInterAppService$UpdateTrafficSignCommand);
            commandList.execute("TrafficRegulationInterAppService#requestCurrentSpeedLimit_trafficRegulationDisabled");
            this.trafficRegulationService.registerCurrentTrafficSignObserver(trafficRegulationInterAppService$UpdateTrafficSignCommand);
            this.trafficRegulationService.setEnableTrafficRegulationInfo(true);
        }
    }

    static /* synthetic */ TrafficRegulationService access$000(TrafficRegulationInterAppService trafficRegulationInterAppService) {
        return trafficRegulationInterAppService.trafficRegulationService;
    }
}

