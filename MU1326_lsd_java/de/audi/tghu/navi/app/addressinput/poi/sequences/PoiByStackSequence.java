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
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiByStackSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiByStackSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import org.dsi.ifc.global.NavLocation;

public class PoiByStackSequence
extends AbstractStartPoiInputSequence {
    private final NavLocation searchLocation;

    public PoiByStackSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, NavLocation navLocation, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 0xD800000, new PoiSearchArea(navigationEnv.getPOILogChannel()), navigationEnv, iDetailsScreen);
        this.searchLocation = navLocation;
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiByStackSequence#start( )");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.createStartSequence());
        commandList.execute("PoiByStackSequence#execute");
    }

    @Override
    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiByStackSequence$1(this));
        commandList.add(new LISPCancelSpellerCommand());
        if (this.modelAccess != null) {
            commandList.add(new ModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiByStackSequence$2(this, "AbstractStartPoiInputSequence#SpellerType"));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory, 1));
        }
        return commandList;
    }

    @Override
    protected int getSortOrder() {
        return 1;
    }

    @Override
    protected String getStringId() {
        return "PoiByStackSequence";
    }

    @Override
    protected NavLocation getLocation(PoiSearchArea poiSearchArea) {
        return this.searchLocation;
    }

    @Override
    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiByStackSequence#retrieveNavLocation()");
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiByStackSequence#startGuidance() - no element has been selected");
            return;
        }
        PoiDetailsSequence poiDetailsSequence = new PoiDetailsSequence(this.commandListFactory, guiModelAccessDetailsNavi, this.selectedElement, this.detailsScreen);
        poiDetailsSequence.start();
    }
}

