/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiStartSearchSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.Util;

public class TopPoiInputSequence
extends AbstractStartPoiInputSequence {
    private final IVehicle vehicle;

    public TopPoiInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 32777, poiSearchArea, navigationEnv, iDetailsScreen);
        this.vehicle = iVehicle;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] TopPoiInputSequence#start() ");
        CommandList commandList = this.createStartSequence();
        commandList.execute("TopPoiInputSequence#start");
    }

    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                TopPoiInputSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
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
                if (TopPoiInputSequence.this.searchArea.getSearchContext() == 1) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(TopPoiInputSequence.this.spellerType, Util.isHURegionNAR()));
                } else if (TopPoiInputSequence.this.searchArea.getSearchContext() == 5 && TopPoiInputSequence.this.spellerType == 32778) {
                    CommandList commandList = TopPoiInputSequence.this.createStartSpellerCommandList(32771);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    CommandList commandList = TopPoiInputSequence.this.createStartSpellerCommandList(TopPoiInputSequence.this.spellerType);
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] TopPoiInputSequence#startResultsSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, false, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startCategoriesOrResultsSequence(iPoiCategoriesOrResultsModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] TopPoiInputSequence#startCategoriesOrResultsSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiCategoriesOrResultsWrapperSequence(iPoiCategoriesOrResultsModelAccess, this.commandListFactory, this.env, this.searchArea, this.selectedElement, this.vehicle, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] TopPoiInputSequence#startSubstringSearch() - create search sequence");
        this.currentInputSequence = new PoiStartSearchSpellerInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] TopPoiInputSequence#startBrands() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiBrandsInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    protected int getSortOrder() {
        return 2;
    }

    protected String getStringId() {
        return "TopPoiInputSequence";
    }
}

