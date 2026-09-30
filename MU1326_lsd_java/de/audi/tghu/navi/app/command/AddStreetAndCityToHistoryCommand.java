/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
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

    public void execute() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip city and add to history").toString()){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
                    CommandList commandList = AddStreetAndCityToHistoryCommand.this.commandListFactory.createCommandList();
                    commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList add striped location to history").toString()){

                        public void execute() {
                            this.getCommandList().commandFinishedWithPostSequence(AddStreetAndCityToHistoryCommand.this.cityHistory.addLastCityCommandList(this.dsiResponseContainer.getLiCurrentLD(), AddStreetAndCityToHistoryCommand.this.hasStreets));
                        }
                    });
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip Street and add to history").toString()){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
                    CommandList commandList = AddStreetAndCityToHistoryCommand.this.commandListFactory.createCommandList();
                    commandList.add(new LIStripLocationCommand(this.dsiResponseContainer.getLiCurrentLD(), 14));
                    commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList add stiped location to history").toString()){

                        public void execute() {
                            this.getCommandList().commandFinishedWithPostSequence(AddStreetAndCityToHistoryCommand.this.cityHistory.addLastStreetCommandList((NavLocation)this.getCommandList().get("STRIPPED_LOCATION")));
                        }
                    });
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

