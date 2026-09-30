/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCategoriesOrResultsWrapperSequence
extends AbstractWrapperSequence {
    private final IPoiCategoriesOrResultsModelAccess poiModelAccess;
    private final ICommandListFactory commandListFactory;
    private final PoiSearchArea searchArea;
    private final NavigationEnv env;
    private final LIValueListElement classElement;
    private final IVehicle vehicle;
    private final int minimumResults;
    protected LISpellerData initialSpellerState;

    public PoiCategoriesOrResultsWrapperSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, LIValueListElement lIValueListElement, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        this(iPoiCategoriesOrResultsModelAccess, iCommandListFactory, navigationEnv, poiSearchArea, lIValueListElement, iVehicle, -1, iDetailsScreen);
    }

    public PoiCategoriesOrResultsWrapperSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, LIValueListElement lIValueListElement, IVehicle iVehicle, int n, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.poiModelAccess = iPoiCategoriesOrResultsModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.classElement = lIValueListElement;
        this.vehicle = iVehicle;
        this.minimumResults = n;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiCategoriesOrResultsInputSequence#start() - classElementIndex: %1 ", (Object)this.classElement);
        PoiClassCategoriesInputSequence poiClassCategoriesInputSequence = new PoiClassCategoriesInputSequence(this.poiModelAccess.getCategoriesScreen(), this.commandListFactory, this.searchArea, this.env, this.classElement, this.vehicle, this.detailsScreen);
        this.currentInputSequence = poiClassCategoriesInputSequence;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiCategoriesOrResultsWrapperSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(poiClassCategoriesInputSequence.createStartSequence());
        commandList.add(new NavCommand(){

            public void execute() {
                long l = this.dsiResponseContainer.getLispValueListCount();
                LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                if (l == 1L && lIValueList != null && lIValueList.getList() != null && lIValueList.getList().length == 1) {
                    LIValueListElement lIValueListElement = lIValueList.getList()[0];
                    PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(PoiCategoriesOrResultsWrapperSequence.this.poiModelAccess.getResultsScreen(), PoiCategoriesOrResultsWrapperSequence.this.commandListFactory, PoiCategoriesOrResultsWrapperSequence.this.searchArea, this.env, lIValueListElement, PoiCategoriesOrResultsWrapperSequence.this.vehicle, false, PoiCategoriesOrResultsWrapperSequence.this.minimumResults, PoiCategoriesOrResultsWrapperSequence.this.detailsScreen);
                    PoiCategoriesOrResultsWrapperSequence.this.currentInputSequence = poiResultsGeneralInputSequence;
                    this.logger.log(10000000, "[PoiInput] PoiCategoriesOrResultsInputSequence#navCommand#execute() - continue directly to results screen");
                    this.getCommandList().commandFinishedWithPostSequence(poiResultsGeneralInputSequence.createStartSequence());
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.execute("PoiCategoriesOrResultsInputSequence#start");
    }

    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(100000, "[PoiInput] PoiBrandsFromSpellerStateWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }
}

