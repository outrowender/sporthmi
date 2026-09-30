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
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
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

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiUIDResultsWrapperSequence#start()");
        CommandList commandList = this.getStartSequence();
        commandList.execute("PoiUIDResultsWrapperSequence#start");
    }

    public CommandList getStartSequence() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiUIDResultsWrapperSequence#getStartSequence()");
        final PoiCategoryByUIDSequence poiCategoryByUIDSequence = new PoiCategoryByUIDSequence(this.startSepellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        final TopPoiInputSequence topPoiInputSequence = new TopPoiInputSequence(this.resultsModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiUIDResultsWrapperSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new PoiGetCategoryTypesFromUIdCommand(this.categoryListElement.poiUniqueId));
        commandList.add(new NavCommand(){

            public void execute() {
                if (this.isGenericPoi()) {
                    PoiUIDResultsWrapperSequence.this.currentInputSequence = poiCategoryByUIDSequence;
                    this.getCommandList().commandFinishedWithPostSequence(poiCategoryByUIDSequence.createStartSequence());
                } else if (this.isTopPoi()) {
                    PoiUIDResultsWrapperSequence.this.currentInputSequence = topPoiInputSequence;
                    this.getCommandList().commandFinishedWithPostSequence(topPoiInputSequence.createStartSequence());
                } else {
                    this.getCommandList().commandAborted(2L);
                }
            }

            private boolean isTopPoi() {
                int[] nArray = this.dsiResponseContainer.getPoiGetCategoryTypesFromUId();
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (nArray[i2] != 1) continue;
                    return true;
                }
                return false;
            }

            private boolean isGenericPoi() {
                int[] nArray = this.dsiResponseContainer.getPoiGetCategoryTypesFromUId();
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (nArray[i2] != 2) continue;
                    return true;
                }
                return false;
            }
        });
        commandList.add(new NavCommand(){

            public void execute() {
                PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(PoiUIDResultsWrapperSequence.this.resultsModelAccess, PoiUIDResultsWrapperSequence.this.commandListFactory, PoiUIDResultsWrapperSequence.this.searchArea, this.env, PoiUIDResultsWrapperSequence.this.categoryListElement, PoiUIDResultsWrapperSequence.this.vehicle, true, PoiUIDResultsWrapperSequence.this.minInitialResults, PoiUIDResultsWrapperSequence.this.detailsScreen);
                PoiUIDResultsWrapperSequence.this.currentInputSequence = poiResultsGeneralInputSequence;
                this.logger.log(10000000, "[PoiInput] PoiUIDResultsWrapperSequence#navCommand#execute() - continue directly to results screen");
                this.getCommandList().commandFinishedWithPostSequence(poiResultsGeneralInputSequence.createStartSequence());
            }
        });
        return commandList;
    }

    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(100000, "[PoiInput] PoiUIDResultsWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }
}

