/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.tr.TrafficUtil;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

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
        this.logChannel.log(10000000, "TrafficRegulationInterAppService#requestCurrentSpeedLimit()");
        if (this.trafficRegulationService == null || !this.trafficRegulationService.isTrafficRegulationPresent()) {
            this.logChannel.log(100000, "TrafficRegulationInterAppService#requestCurrentSpeedLimit() - traffic regulation is not present!");
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                protected void call(NaviServiceListener naviServiceListener) {
                    naviServiceListener.responseCurrentSpeedLimit((byte)1, 0, (byte)0);
                }
            });
            commandList.execute("TrafficRegulationInterAppService#requestCurrentSpeedLimit_noTrafficRegulation");
            return;
        }
        if (TrafficUtil.isTrafficRegulationInfoEnabled(this.env)) {
            final int n = this.trafficRegulationService.getCurrentSpeedLimit();
            final byte by = this.trafficRegulationService.getCurrentSpeedLimitUnit();
            final byte by2 = n == 0 || by == -1 ? (byte)3 : 0;
            this.logChannel.log(10000000, "TrafficRegulationInterAppService#requestCurrentSpeedLimit() - VZA enabled, notify SDS with result=%1, currentSpeedLimit=%2, currentSpeedLimitUnit=%3", (long)by2, (long)n, (long)by);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                protected void call(NaviServiceListener naviServiceListener) {
                    naviServiceListener.responseCurrentSpeedLimit(by2, n, by);
                }
            });
            commandList.execute("TrafficRegulationInterAppService#requestCurrentSpeedLimit_trafficRegulationEnabled");
        } else {
            this.logChannel.log(10000000, "TrafficRegulationInterAppService#requestCurrentSpeedLimit() - VZA disabled, shortly enable VZA and wait for update");
            UpdateTrafficSignCommand updateTrafficSignCommand = new UpdateTrafficSignCommand(naviServiceListener);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(updateTrafficSignCommand);
            commandList.execute("TrafficRegulationInterAppService#requestCurrentSpeedLimit_trafficRegulationDisabled");
            this.trafficRegulationService.registerCurrentTrafficSignObserver(updateTrafficSignCommand);
            this.trafficRegulationService.setEnableTrafficRegulationInfo(true);
        }
    }

    private class UpdateTrafficSignCommand
    extends NavCommand
    implements TrafficRegulationService.CurrentTrafficSignObserver {
        private final NaviServiceListener naviServiceListener;
        private final Timer updateTrafficSignTimer;
        private static final long UPDATE_TRAFFIC_SIGN_TIMEOUT = 5000L;
        private final Object mutex = new Object();
        private volatile boolean updateReceived = false;
        private boolean stillListeningForUpdates = true;

        public UpdateTrafficSignCommand(NaviServiceListener naviServiceListener) {
            this.naviServiceListener = naviServiceListener;
            this.updateTrafficSignTimer = new Timer("Stop waiting for update Timer", 5000L, true, this);
        }

        public void execute() {
            this.updateTrafficSignTimer.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Object object = this.mutex;
            synchronized (object) {
                if (!this.updateReceived) {
                    this.logger.log(10000000, "%1#fireTimer - timeout of %2 ms reached, waiting for updates will be stopped.", (Object)this.CLASS_NAME, 5000L);
                    this.turnOffListeningForUpdates();
                    this.getCommandList().commandFinishedWithPostCommand(new NotifyNaviServiceListenerCommand(this.naviServiceListener){

                        protected void call(NaviServiceListener naviServiceListener) {
                            try {
                                naviServiceListener.responseCurrentSpeedLimit((byte)3, 0, (byte)-1);
                            }
                            catch (Exception exception) {
                                this.logger.log(10000, "%1#fireTimer - listener has thrown an exception=%2", (Object)this.CLASS_NAME, (Throwable)exception);
                            }
                        }
                    });
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation) {
            Object object = this.mutex;
            synchronized (object) {
                if (this.stillListeningForUpdates) {
                    int n;
                    this.updateReceived = true;
                    this.turnOffListeningForUpdates();
                    this.logger.log(10000000, "%1#updateCurrentTrafficSign - currentTrafficSign=%2", (Object)this.CLASS_NAME, (Object)trafficSignInformation);
                    this.updateTrafficSignTimer.cancel();
                    int n2 = 0;
                    if (trafficSignInformation != null && (n = TrafficUtil.retrieveCurrentSignID(trafficSignInformation)) != -1) {
                        n2 = TrafficUtil.extractSpeedLimitFromSignID(n);
                    }
                    n = n2;
                    final byte by = TrafficRegulationInterAppService.this.trafficRegulationService.getCurrentSpeedLimitUnit();
                    final byte by2 = n == 0 || by == -1 ? (byte)3 : 0;
                    this.logger.log(10000000, "UpdateTrafficSignCommand#updateCurrentTrafficSign() - notify SDS with result=%1, currentSpeedLimit=%2, currentSpeedLimitUnit=%3", (long)by2, (long)n, (long)by);
                    this.getCommandList().commandFinishedWithPostCommand(new NotifyNaviServiceListenerCommand(this.naviServiceListener){

                        protected void call(NaviServiceListener naviServiceListener) {
                            naviServiceListener.responseCurrentSpeedLimit(by2, n, by);
                        }
                    });
                }
            }
        }

        private void turnOffListeningForUpdates() {
            TrafficRegulationInterAppService.this.trafficRegulationService.registerCurrentTrafficSignObserver(null);
            this.stillListeningForUpdates = false;
            if (!TrafficUtil.isTrafficRegulationInfoEnabled(this.env)) {
                TrafficRegulationInterAppService.this.trafficRegulationService.setEnableTrafficRegulationInfo(false);
            }
        }
    }
}

