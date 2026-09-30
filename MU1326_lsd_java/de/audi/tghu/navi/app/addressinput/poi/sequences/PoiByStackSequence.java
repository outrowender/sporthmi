/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class PoiByStackSequence
extends AbstractStartPoiInputSequence {
    private final NavLocation searchLocation;

    public PoiByStackSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, NavLocation navLocation, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 32781, new PoiSearchArea(navigationEnv.getPOILogChannel()), navigationEnv, iDetailsScreen);
        this.searchLocation = navLocation;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiByStackSequence#start( )");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.createStartSequence());
        commandList.execute("PoiByStackSequence#execute");
    }

    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiByStackSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        if (this.modelAccess != null) {
            commandList.add(new ModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand("AbstractStartPoiInputSequence#SpellerType"){

            public void execute() {
                if (PoiByStackSequence.this.searchArea.getSearchContext() == 1) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(PoiByStackSequence.this.spellerType, Util.isHURegionNAR()));
                } else if (PoiByStackSequence.this.searchArea.getSearchContext() == 5 && PoiByStackSequence.this.spellerType == 32778) {
                    CommandList commandList = PoiByStackSequence.this.createStartSpellerCommandList(32771);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    CommandList commandList = PoiByStackSequence.this.createStartSpellerCommandList(PoiByStackSequence.this.spellerType);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory, 1));
        }
        return commandList;
    }

    protected int getSortOrder() {
        return 1;
    }

    protected String getStringId() {
        return "PoiByStackSequence";
    }

    protected NavLocation getLocation(PoiSearchArea poiSearchArea) {
        return this.searchLocation;
    }

    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiByStackSequence#retrieveNavLocation()");
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(10000000, "[PoiInput] PoiByStackSequence#startGuidance() - no element has been selected");
            return;
        }
        PoiDetailsSequence poiDetailsSequence = new PoiDetailsSequence(this.commandListFactory, guiModelAccessDetailsNavi, this.selectedElement, this.detailsScreen);
        poiDetailsSequence.start();
    }
}

