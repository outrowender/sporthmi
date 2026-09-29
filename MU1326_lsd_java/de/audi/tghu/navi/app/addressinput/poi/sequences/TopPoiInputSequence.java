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
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiStartSearchSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class TopPoiInputSequence
extends AbstractStartPoiInputSequence {
    private final IVehicle vehicle;

    public TopPoiInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 0x9800000, poiSearchArea, navigationEnv, iDetailsScreen);
        this.vehicle = iVehicle;
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] TopPoiInputSequence#start() ");
        CommandList commandList = this.createStartSequence();
        commandList.execute("TopPoiInputSequence#start");
    }

    @Override
    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new TopPoiInputSequence$1(this));
        commandList.add(new LISPCancelSpellerCommand());
        if (this.modelAccess != null) {
            commandList.add(new ModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new TopPoiInputSequence$2(this, "AbstractStartPoiInputSequence#SpellerType"));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    @Override
    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] TopPoiInputSequence#startResultsSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, false, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startCategoriesOrResultsSequence(iPoiCategoriesOrResultsModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] TopPoiInputSequence#startCategoriesOrResultsSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiCategoriesOrResultsWrapperSequence(iPoiCategoriesOrResultsModelAccess, this.commandListFactory, this.env, this.searchArea, this.selectedElement, this.vehicle, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] TopPoiInputSequence#startSubstringSearch() - create search sequence");
        this.currentInputSequence = new PoiStartSearchSpellerInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] TopPoiInputSequence#startBrands() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiBrandsInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    protected int getSortOrder() {
        return 2;
    }

    @Override
    protected String getStringId() {
        return "TopPoiInputSequence";
    }
}

