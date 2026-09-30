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
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiResultsFromSpellerStateWrapperSequence
extends AbstractWrapperSequence {
    protected final IPoiSpellerModelAccess modelAccess;
    protected final ICommandListFactory commandListFactory;
    protected final PoiSearchArea searchArea;
    protected final NavigationEnv env;
    protected final LIValueListElement classElement;
    protected final LISpellerData classesSpellerData;
    private final IVehicle vehicle;
    private final int minInitialResults;
    private final boolean selectByUID;
    protected LISpellerData initialSpellerState;

    public PoiResultsFromSpellerStateWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, LIValueListElement lIValueListElement, LISpellerData lISpellerData, IVehicle iVehicle, boolean bl, IDetailsScreen iDetailsScreen) {
        this(iPoiSpellerModelAccess, iCommandListFactory, navigationEnv, poiSearchArea, lIValueListElement, lISpellerData, iVehicle, 1, bl, iDetailsScreen);
    }

    public PoiResultsFromSpellerStateWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, LIValueListElement lIValueListElement, LISpellerData lISpellerData, IVehicle iVehicle, int n, boolean bl, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.modelAccess = iPoiSpellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.classElement = lIValueListElement;
        this.classesSpellerData = lISpellerData;
        this.vehicle = iVehicle;
        this.minInitialResults = n;
        this.selectByUID = bl;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiClassResultsFromSpellerStateWrapperSequence#start() - classElementIndex: %1 ", (Object)this.classElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiResultsFromSpellerStateWrapperSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LIRestoreStateCommand(this.classesSpellerData));
        PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(this.modelAccess, this.commandListFactory, this.searchArea, this.env, this.classElement, this.vehicle, this.selectByUID, this.minInitialResults, this.detailsScreen);
        this.currentInputSequence = poiResultsGeneralInputSequence;
        commandList.add(poiResultsGeneralInputSequence.createStartSequence());
        commandList.execute("PoiResultsFromSpellerStateWrapperSequence#start");
    }

    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(100000, "[PoiInput] PoiClassResultsFromSpellerStateWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }
}

