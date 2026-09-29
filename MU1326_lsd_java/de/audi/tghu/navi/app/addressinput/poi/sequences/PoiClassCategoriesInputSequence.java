/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiResultsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiClassCategoriesInputSequence
extends AbstractPoiSequence {
    private final PoiSearchArea searchArea;
    private final IVehicle vehicle;
    private final LIValueListElement classElement;
    private final boolean selectByUID;

    public PoiClassCategoriesInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, navigationEnv, iDetailsScreen);
        this.classElement = lIValueListElement;
        this.searchArea = poiSearchArea;
        this.vehicle = iVehicle;
        this.selectByUID = bl;
    }

    public PoiClassCategoriesInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        this(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, false, iDetailsScreen);
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiClassCategoriesInputSequence#start() - classElementIndex: %1 ", (Object)this.classElement);
        CommandList commandList = this.createStartSequence();
        commandList.execute("PoiClassCategoriesInputSequence#start()");
    }

    @Override
    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiClassCategoriesInputSequence#startResultsSequence() - element: %1", (Object)this.selectedElement);
        if (this.selectedElement == null) {
            this.currentInputSequence = new PoiResultsFromSpellerStateWrapperSequence(iPoiSpellerModelAccess, this.commandListFactory, this.env, this.searchArea, this.classElement, this.initialSpellerState, this.vehicle, n, this.selectByUID, this.detailsScreen);
            this.currentInputSequence.start();
        } else {
            this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, false, n, this.detailsScreen);
            this.currentInputSequence.start();
        }
    }

    @Override
    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiClassCategoriesInputSequence#startSubstringSearch() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiResultsFromSpellerStateWrapperSequence(iPoiSpellerModelAccess, this.commandListFactory, this.env, this.searchArea, this.classElement, this.initialSpellerState, this.vehicle, this.selectByUID, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiClassCategoriesInputSequence#startBrands() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiBrandsInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiClassCategoriesInputSequence$1(this, "SaveSpellerState"));
        if (this.modelAccess != null) {
            commandList.add(new ModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        if (this.selectByUID) {
            commandList.add(new LispSelectByCategoryUidCommand(this.classElement.getPoiUniqueId()));
        } else {
            commandList.add(new LISPSelectListItemCommand(this.classElement.getListIndex()));
        }
        if (this.modelAccess != null) {
            commandList.add(new ModelOnElementSelectedCommand(this.modelAccess, this.classElement));
            commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        }
        commandList.add(new PoiClassCategoriesInputSequence$2(this, "CheckSelectionCriteria"));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    @Override
    protected int getSortOrder() {
        return 1;
    }

    @Override
    protected String getStringId() {
        return "PoiClassCategoriesInputSequence";
    }
}

