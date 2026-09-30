/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOICategoryListModelAccess;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIBaseSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class TpegPOICategoryListSequence
extends TpegPOIBaseSequence {
    private final IVehicle vehicle;
    private final ITpegPOICategoryListModelAccess modelAccess;

    public TpegPOICategoryListSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, ITpegPOICategoryListModelAccess iTpegPOICategoryListModelAccess, SpellerStack spellerStack, IVehicle iVehicle) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.vehicle = iVehicle;
        this.modelAccess = iTpegPOICategoryListModelAccess;
    }

    public CommandList getStartTpegPOICommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Reset SpellerStack"){

            public void execute() {
                TpegPOICategoryListSequence.this.spellerStack.reset();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(109)));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(0));
        commandList.add(new PoiSetContextCommand(this.vehicle.getVehicleLocationDescription()));
        commandList.add(new LIStartSpellerCommand(153, false, false, false));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        return commandList;
    }
}

