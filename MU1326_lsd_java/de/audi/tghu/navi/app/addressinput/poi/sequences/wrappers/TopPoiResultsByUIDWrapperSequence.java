/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class TopPoiResultsByUIDWrapperSequence
extends AbstractWrapperSequence {
    private final LogChannel lc;
    private final ICommandListFactory commandListFactory;
    private final PoiSearchArea searchArea;
    private final NavigationEnv env;
    private final IVehicle vehicle;
    private final IPoiSpellerModelAccess startSepellerModelAccess;
    private final IPoiSpellerModelAccess resultsModelAccess;
    private final int minInitialResults;
    private final int categoryID;
    protected LISpellerData initialSpellerState;

    public TopPoiResultsByUIDWrapperSequence(ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, int n, int n2, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.lc = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.resultsModelAccess = iPoiSpellerModelAccess2;
        this.startSepellerModelAccess = iPoiSpellerModelAccess;
        this.minInitialResults = n;
        this.categoryID = n2;
    }

    public void start() {
        this.lc.log(10000000, "[PoiInput] TopPoiResultsByUIDWrapperSequence#start()");
        CommandList commandList = this.getStartSequence();
        commandList.execute("TopPoiResultsByUIDWrapperSequence#start");
    }

    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(100000, "[PoiInput] TopPoiResultsByUIDWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }

    public CommandList getStartSequence() {
        this.lc.log(10000000, "[PoiInput] TopPoiResultsByUIDWrapperSequence#getStartSequence()");
        TopPoiInputSequence topPoiInputSequence = new TopPoiInputSequence(this.startSepellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence = topPoiInputSequence;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                TopPoiResultsByUIDWrapperSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(topPoiInputSequence.createStartSequence());
        commandList.add(new NavCommand(){

            public void execute() {
                LIValueListElement lIValueListElement = new LIValueListElement();
                lIValueListElement.poiUniqueId = TopPoiResultsByUIDWrapperSequence.this.categoryID;
                PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(TopPoiResultsByUIDWrapperSequence.this.resultsModelAccess, TopPoiResultsByUIDWrapperSequence.this.commandListFactory, TopPoiResultsByUIDWrapperSequence.this.searchArea, this.env, lIValueListElement, TopPoiResultsByUIDWrapperSequence.this.vehicle, true, TopPoiResultsByUIDWrapperSequence.this.minInitialResults, TopPoiResultsByUIDWrapperSequence.this.detailsScreen);
                TopPoiResultsByUIDWrapperSequence.this.currentInputSequence = poiResultsGeneralInputSequence;
                this.logger.log(10000000, "[PoiInput] TopPoiResultsByUIDWrapperSequence#navCommand#execute() - continue directly to results screen");
                this.getCommandList().commandFinishedWithPostSequence(poiResultsGeneralInputSequence.createStartSequence());
            }
        });
        return commandList;
    }
}

