/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.DummyDistanceContainer;
import de.audi.tghu.navi.app.addressinput.poi.rrd.DummyRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IDistanceContainer;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.RRDCalculator;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class PoiDistanceCalculator
implements TimerListener {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    public static final long AIR_DELAY = 5000L;
    public static final long RRD_DELAY_UPDATE = 60000L;
    private final ICommandListFactory commandListFactory;
    private final RRDCalculator rrdCalculator;
    private final IVehicle vehicle;
    private final Timer updateAirdistanceTimer;
    private final Timer updateRRDTimer;
    private final LogChannel poiLogChannel;
    private IRRDListProvider rrdListProvider = new DummyRRDListProvider();
    private IDistanceContainer distanceContainer = new DummyDistanceContainer();

    public PoiDistanceCalculator(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, String string, String string2) {
        this.vehicle = iVehicle;
        this.poiLogChannel = navigationEnv.getPOILogChannel();
        this.commandListFactory = iCommandListFactory;
        this.rrdCalculator = new RRDCalculator(navigationEnv, iCommandListFactory);
        this.updateAirdistanceTimer = new Timer(string2, 5, this.poiLogChannel, this, 5000L, false);
        this.updateRRDTimer = new Timer(string, 5, this.poiLogChannel, this, 60000L, false);
    }

    public void nameListEntered(boolean bl, IRRDListProvider iRRDListProvider, IDistanceContainer iDistanceContainer) {
        this.poiLogChannel.log(1000000, "%2#nameListEntered() - performAirDistanceUpdates: %1 ", bl, (Object)this.CLASS_NAME);
        if (iRRDListProvider == null) {
            throw new IllegalArgumentException("rrdListProvider is null!");
        }
        if (iDistanceContainer == null) {
            throw new IllegalArgumentException("distanceContainer is null!");
        }
        this.setProvider(iRRDListProvider);
        this.setDistanceContainer(iDistanceContainer);
        this.rrdCalculator.stopRRDCalculation();
        this.cancelTimers();
        int n = this.getProvider().getRRDListCalculationLimit();
        if (n > 0) {
            this.triggerRRDCalculation();
            if (this.updateRRDTimer.isRunning()) {
                this.updateRRDTimer.cancel();
            }
            this.updateRRDTimer.restart();
        } else {
            this.poiLogChannel.log(10000000, "%1#nameListEntered() - no RRDs requested.", (Object)this.CLASS_NAME);
        }
        if (bl) {
            this.updateDirectionAndAirDistance();
            if (this.updateAirdistanceTimer.isRunning()) {
                this.updateAirdistanceTimer.cancel();
            }
            this.updateAirdistanceTimer.restart();
        }
    }

    public void nameListLeft(int n) {
        this.poiLogChannel.log(1000000, "%1#nameListLeft() - listType: %2", (Object)this.CLASS_NAME, (long)n);
        this.rrdCalculator.stopRRDCalculation();
        this.cancelTimers();
        this.setProvider(null);
        this.setDistanceContainer(null);
    }

    public void itemsRRDCalculationLimitReached() {
        this.poiLogChannel.log(1000000, "%1#itemsRRDCalculationLimitReached()", (Object)this.CLASS_NAME);
        this.updateDelayRRDTimer(60000L);
    }

    private void updateDelayRRDTimer(long l) {
        if (this.updateRRDTimer.getDelay() == l) {
            return;
        }
        this.updateRRDTimer.setDelay(l);
        this.updateRRDTimer.restart();
    }

    private synchronized IRRDListProvider getProvider() {
        return this.rrdListProvider;
    }

    private synchronized void setProvider(IRRDListProvider iRRDListProvider) {
        this.rrdListProvider = iRRDListProvider == null ? new DummyRRDListProvider() : iRRDListProvider;
    }

    private synchronized IDistanceContainer getDistanceContainer() {
        return this.distanceContainer;
    }

    private synchronized void setDistanceContainer(IDistanceContainer iDistanceContainer) {
        this.distanceContainer = iDistanceContainer == null ? new DummyDistanceContainer() : iDistanceContainer;
    }

    public void updateRRDCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        if (!this.updateRRDTimer.isRunning()) {
            if (this.poiLogChannel.isDebug2()) {
                this.poiLogChannel.log(100000000, "%1#updateRRDCalculationInfo() - Timer not active -> updateRRDCalculationInfo not interesting!", (Object)this.CLASS_NAME);
            }
            return;
        }
        this.getDistanceContainer().storeRRDDistances(rrdCalculationInfoArray);
        this.getProvider().updateRRDDistances(rrdCalculationInfoArray);
    }

    public void unitsChanged() {
        this.poiLogChannel.log(10000000, "%1#unitsChanged()", (Object)this.CLASS_NAME);
        this.getProvider().unitsChanged();
    }

    public void fireTimer(Timer timer) {
        if (this.poiLogChannel.isDebug2()) {
            this.poiLogChannel.log(100000000, "%1#fireTimer() - Timer: %2", (Object)this.CLASS_NAME, (Object)timer);
        }
        if (timer == this.updateAirdistanceTimer) {
            this.updateDirectionAndAirDistance();
        } else if (timer == this.updateRRDTimer) {
            this.triggerRRDCalculation();
        } else {
            this.poiLogChannel.log(100000, "%1#fireTimer() - Unknown timer: %2!", (Object)this.CLASS_NAME, (Object)timer);
        }
    }

    public void cancelTimer(Timer timer) {
    }

    private void triggerRRDCalculation() {
        this.poiLogChannel.log(10000000, "%1#triggerRRDCalculation()", (Object)this.CLASS_NAME);
        this.rrdCalculator.startRRDCalculation(this.getProvider());
    }

    private void updateDirectionAndAirDistance() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#updateDirectionAndAirDistance").toString()){

            public void execute() {
                PosPosition posPosition = PoiDistanceCalculator.this.vehicle.getPosition();
                PoiDistanceCalculator.this.getProvider().updateDirectionAndAirDistance(posPosition);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#updateDirectionAndAirDistanceCommandList").toString());
    }

    public void cancelTimers() {
        this.updateAirdistanceTimer.cancel();
        this.updateRRDTimer.cancel();
    }
}

