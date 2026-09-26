/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiGetCategoryTypesFromUIdCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryByUIDSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiUIDResultsWrapperSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiUIDResultsWrapperSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiUIDResultsWrapperSequence$3;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiUIDResultsWrapperSequence
extends AbstractWrapperSequence {
    protected final IPoiSpellerModelAccess startSepellerModelAccess = null;
    protected final IPoiSpellerModelAccess resultsModelAccess;
    protected final ICommandListFactory commandListFactory;
    protected final PoiSearchArea searchArea;
    protected final NavigationEnv env;
    protected final IVehicle vehicle;
    protected final LIValueListElement categoryListElement;
    protected final int minInitialResults;
    protected LISpellerData initialSpellerState;

    public PoiUIDResultsWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, IVehicle iVehicle, LIValueListElement lIValueListElement, int n, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.resultsModelAccess = iPoiSpellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.categoryListElement = lIValueListElement;
        this.minInitialResults = n;
        this.vehicle = iVehicle;
    }

    public PoiUIDResultsWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, IVehicle iVehicle, LIValueListElement lIValueListElement, IDetailsScreen iDetailsScreen) {
        this(iPoiSpellerModelAccess, iCommandListFactory, navigationEnv, poiSearchArea, iVehicle, lIValueListElement, 1, iDetailsScreen);
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiUIDResultsWrapperSequence#start()");
        CommandList commandList = this.getStartSequence();
        commandList.execute("PoiUIDResultsWrapperSequence#start");
    }

    public CommandList getStartSequence() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiUIDResultsWrapperSequence#getStartSequence()");
        PoiCategoryByUIDSequence poiCategoryByUIDSequence = new PoiCategoryByUIDSequence(this.startSepellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        TopPoiInputSequence topPoiInputSequence = new TopPoiInputSequence(this.resultsModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiUIDResultsWrapperSequence$1(this));
        commandList.add(new PoiGetCategoryTypesFromUIdCommand(this.categoryListElement.poiUniqueId));
        commandList.add(new PoiUIDResultsWrapperSequence$2(this, poiCategoryByUIDSequence, topPoiInputSequence));
        commandList.add(new PoiUIDResultsWrapperSequence$3(this));
        return commandList;
    }

    @Override
    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(-1601830656, "[PoiInput] PoiUIDResultsWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }
}

