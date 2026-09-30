/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiParentChildInputSequence
extends AbstractStartPoiInputSequence {
    private static final int WAITING_NOT_REQUIRED = 0;
    private final IVehicle vehicle;
    protected final int poiListIndex;

    public PoiParentChildInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, int n, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 32774, poiSearchArea, navigationEnv, iDetailsScreen);
        this.poiListIndex = n;
        this.vehicle = iVehicle;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiParentChildSequence#start( )");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.createStartSequence());
        commandList.execute("PoiParentChildSequence#execute");
    }

    public void selectListElement(LIValueListElement lIValueListElement) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.selectListElement(lIValueListElement);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiParentChildSequence#selectListElement( %1 )", (Object)lIValueListElement);
        this.selectedElement = lIValueListElement;
        if (this.modelAccess != null) {
            this.modelAccess.onElementSelected(lIValueListElement);
        }
    }

    public void startGuidance(final ILocationHandler iLocationHandler, final IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidance(iLocationHandler, iStartGuidanceToDestinationSequence);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getPOILogChannel().log(10000000, "[PoiInput] PoiParentChildInputSequence#startGuidance() - no element has been selected");
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.getCommandList().commandFinishedWithPostSequence(iStartGuidanceToDestinationSequence.getStartSequence(iLocationHandler, navLocation));
                } else {
                    this.getCommandList().commandAborted("PoiParentChildInputSequence#startGuidance - Position for element is not valid");
                }
            }
        });
        commandList.execute("PoiParentChildInputSequence#startGuidance");
    }

    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiParentChildSequence#startResultsSequence( %1 )", (long)n);
        this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, false, 0, this.detailsScreen);
        this.currentInputSequence.start();
    }

    protected NavLocation getLocation(PoiSearchArea poiSearchArea) {
        return this.env.getContainer().getLiCurrentLD();
    }

    protected int getSortOrder() {
        return 1;
    }

    protected String getStringId() {
        return "PoiParentChildSequence";
    }
}

