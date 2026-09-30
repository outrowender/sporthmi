/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.IPoiResults;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiStartSearchSpellerInputSequence
extends AbstractStartPoiInputSequence
implements IPoiResults {
    protected final SubstringSearchHandler substringSearchHandler;
    protected final IVehicle vehicle;
    protected final LogChannel logChannel;

    public PoiStartSearchSpellerInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 32778, poiSearchArea, navigationEnv, iDetailsScreen);
        this.vehicle = iVehicle;
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiSpellerModelAccess);
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public void start() {
        this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#start()");
        CommandList commandList = this.commandListFactory.createCommandList();
        this.env.getContainer().setLiCurrentState(this.getSpellerCountryLocation(), new int[0], new int[0]);
        commandList.add(this.createStartSequence());
        commandList.execute("PoiStartSearchSpellerInputSequence#start");
    }

    public void setInput(String string) {
        this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#setInput( %1 )", (Object)string);
        LIValueList lIValueList = new LIValueList();
        lIValueList.list = new LIValueListElement[0];
        this.env.getContainer().setLispValueListCount(0L);
        this.env.getContainer().setLispValueList(lIValueList);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        }
        commandList.add(new SetInputCommand(string));
        commandList.execute("PoiStartSearchSpellerInputSequence#setInput");
    }

    public void selectListElement(LIValueListElement lIValueListElement) {
        this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#selectListElement( )");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        this.selectedElement = lIValueListElement;
    }

    public void startGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.startGuidance(null, iStartGuidanceToDestinationSequence);
    }

    public void startGuidanceToSingleDestination(final IRouteManager iRouteManager) {
        this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance()");
        if (this.selectedElement == null) {
            this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - no element has been selected");
            return;
        }
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.logger.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - starting route guidance.");
                    this.getCommandList().commandFinishedWithPostSequence(iRouteManager.getStartRouteGuidanceToSingleDestinationSequence(navLocation));
                } else {
                    this.getCommandList().commandAborted("Position for element is not valid");
                }
            }
        });
        commandList.execute("PoiStartSearchSpellerInputSequence#startGuidance");
    }

    public void startGuidance(final ILocationHandler iLocationHandler, final IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance()");
        if (this.selectedElement == null) {
            this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - no element has been selected");
            return;
        }
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.logger.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - starting route guidance.");
                    this.getCommandList().commandFinishedWithPostSequence(iStartGuidanceToDestinationSequence.getStartSequence(iLocationHandler, navLocation));
                } else {
                    this.getCommandList().commandAborted("Position for element is not valid");
                }
            }
        });
        commandList.execute("PoiStartSearchSpellerInputSequence#startGuidance");
    }

    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#retrieveNavLocation()");
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
            return;
        }
        if (this.selectedElement == null) {
            this.logChannel.log(10000000, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - no element has been selected");
            return;
        }
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        PoiDetailsSequence poiDetailsSequence = new PoiDetailsSequence(this.commandListFactory, guiModelAccessDetailsNavi, this.selectedElement, this.detailsScreen);
        poiDetailsSequence.start();
    }

    public boolean hasActiveSubSequence() {
        return false;
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.logChannel.log(10000000, "[PoiInput] AbstractPoiResultsInputSequence#updatePoiSubstringSearchStatus()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    protected int getSortOrder() {
        return 1;
    }

    private NavLocation getSpellerCountryLocation() {
        if (this.searchArea.getSearchContext() == 2 || this.searchArea.getSearchContext() == 3) {
            return this.vehicle.getVehicleCountryLocation();
        }
        if (this.searchArea.getSearchContext() == 0 || this.searchArea.getSearchContext() == 1) {
            return this.vehicle.getVehicleCountryLocation();
        }
        if (this.searchArea.getSearchContext() == 4) {
            return this.searchArea.getLocation();
        }
        if (this.searchArea.getSearchContext() == 5) {
            return this.searchArea.getLocation();
        }
        return this.vehicle.getVehicleCountryLocation();
    }

    protected String getStringId() {
        return "PoiStartSearchSpellerInputSequence";
    }
}

