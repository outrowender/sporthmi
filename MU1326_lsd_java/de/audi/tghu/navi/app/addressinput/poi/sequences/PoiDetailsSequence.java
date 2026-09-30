/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiLocationCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.IPoiDetailsSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiDetailsSequence
implements IPoiDetailsSequence {
    private final ICommandListFactory commandListFactory;
    private final GuiModelAccessDetailsNavi poiDetailsModelAccess;
    private final LIValueListElement selectedElement;
    private final IDetailsScreen detailsScreen;

    public PoiDetailsSequence(ICommandListFactory iCommandListFactory, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, LIValueListElement lIValueListElement, IDetailsScreen iDetailsScreen) {
        this.commandListFactory = iCommandListFactory;
        this.poiDetailsModelAccess = guiModelAccessDetailsNavi;
        this.selectedElement = lIValueListElement;
        this.detailsScreen = iDetailsScreen;
    }

    public void start() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandAborted("Position for element is not valid");
                }
            }
        });
        commandList.add(new ModelUpdatePoiLocationCommand(this.poiDetailsModelAccess));
        commandList.add(new NavCommand("call enter details screen again"){

            public void execute() {
                PoiDetailsSequence.this.detailsScreen.enterDetailsScreen(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                LISpellerData lISpellerData = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(lISpellerData));
            }
        });
        commandList.execute("PoiDetailsSequence#start");
    }
}

