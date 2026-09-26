/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.rrd;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.RRDCalculator$1;
import de.audi.tghu.navi.app.command.poi.RRDStartCalculationForPositionCommand;
import de.audi.tghu.navi.app.command.poi.RRDStopCalculationCommand;
import org.dsi.ifc.global.NavLocationWgs84;

public class RRDCalculator {
    private final ICommandListFactory commandListFactory;
    private LogChannel logChannel;

    public RRDCalculator(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.logChannel = navigationEnv.getPOILogChannel();
        this.commandListFactory = iCommandListFactory;
    }

    public void startRRDCalculation(IRRDListProvider iRRDListProvider) {
        CommandList commandList = this.createStartRRDCalculation(iRRDListProvider);
        if (commandList != null) {
            commandList.execute("RRDCalculator#startRRDCalculation");
        } else {
            this.logChannel.log(-1601830656, "RRDCalculator#startRRDCalculation() - no list to start");
        }
    }

    public CommandList createStartRRDCalculation(IRRDListProvider iRRDListProvider) {
        if (iRRDListProvider == null) {
            this.logChannel.log(-1601830656, "RRDCalculator#startRRDCalculation() - calculation not started. IRRDListProvider is null! ");
            return null;
        }
        this.logChannel.log(1078071040, "RRDCalculator#startRRDCalculation() ");
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDCalculator$1(this, "GetRRDListForCalculation", iRRDListProvider));
        return commandList;
    }

    public CommandList createStartRRDCalculation(NavLocationWgs84[] navLocationWgs84Array) {
        if (navLocationWgs84Array == null || navLocationWgs84Array.length <= 0) {
            this.logChannel.log(-1601830656, "RRDCalculator#createStartRRDCalculation() - calculation not started. NavLocationWgs84 array is null or empty: %1 ! ", (Object)navLocationWgs84Array);
            return null;
        }
        this.logChannel.log(1078071040, "RRDCalculator#createStartRRDCalculation() - prepare calculation for: %1 with size %2! ", (Object)navLocationWgs84Array, (long)navLocationWgs84Array.length);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDStopCalculationCommand());
        commandList.add(new RRDStartCalculationForPositionCommand(navLocationWgs84Array));
        return commandList;
    }

    public void stopRRDCalculation() {
        this.logChannel.log(-2137614336, "RRDCalculator#stopRRDCalculation() ");
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDStopCalculationCommand());
        commandList.execute("RRDCalculator#stopRRDCalculation");
    }

    static /* synthetic */ LogChannel access$000(RRDCalculator rRDCalculator) {
        return rRDCalculator.logChannel;
    }
}

