/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand$1;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand$2;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class AddStreetAndCityToHistoryCommand
extends NavCommand {
    private final NavLocation liCurrentLD;
    private final CityHistory cityHistory;
    private final ICommandListFactory commandListFactory;
    private final boolean hasStreets;

    public AddStreetAndCityToHistoryCommand(NavLocation navLocation, CityHistory cityHistory, ICommandListFactory iCommandListFactory, boolean bl) {
        this.liCurrentLD = navLocation;
        this.cityHistory = cityHistory;
        this.commandListFactory = iCommandListFactory;
        this.hasStreets = bl;
    }

    @Override
    public void execute() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddStreetAndCityToHistoryCommand$1(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip city and add to history").toString()));
        commandList.add(new AddStreetAndCityToHistoryCommand$2(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip Street and add to history").toString()));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ ICommandListFactory access$000(AddStreetAndCityToHistoryCommand addStreetAndCityToHistoryCommand) {
        return addStreetAndCityToHistoryCommand.commandListFactory;
    }

    static /* synthetic */ boolean access$200(AddStreetAndCityToHistoryCommand addStreetAndCityToHistoryCommand) {
        return addStreetAndCityToHistoryCommand.hasStreets;
    }

    static /* synthetic */ CityHistory access$300(AddStreetAndCityToHistoryCommand addStreetAndCityToHistoryCommand) {
        return addStreetAndCityToHistoryCommand.cityHistory;
    }
}

