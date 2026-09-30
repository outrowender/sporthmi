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
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryByUIDSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCategoryByUIDWrapperSequence
extends AbstractWrapperSequence {
    protected final IPoiSpellerModelAccess startSepellerModelAccess = null;
    protected final IPoiSpellerModelAccess categoriesModelAccess;
    protected final ICommandListFactory commandListFactory;
    protected final PoiSearchArea searchArea;
    protected final NavigationEnv env;
    protected final IVehicle vehicle;
    protected final int criteriaNumber;
    protected LISpellerData initialSpellerState;

    public PoiCategoryByUIDWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, IVehicle iVehicle, int n, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.categoriesModelAccess = iPoiSpellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.criteriaNumber = n;
        this.vehicle = iVehicle;
    }

    public CommandList getStartSequence() {
        this.env.getLogChannel().log(10000000, "[PoiInput] CategoryByUIDWrapperSequence#getStartSequence()");
        PoiCategoryByUIDSequence poiCategoryByUIDSequence = new PoiCategoryByUIDSequence(this.startSepellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence = poiCategoryByUIDSequence;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiCategoryByUIDWrapperSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(poiCategoryByUIDSequence.createStartSequence());
        commandList.add(new NavCommand(){

            public void execute() {
                LIValueListElement lIValueListElement = new LIValueListElement();
                lIValueListElement.poiUniqueId = PoiCategoryByUIDWrapperSequence.this.criteriaNumber;
                PoiClassCategoriesInputSequence poiClassCategoriesInputSequence = new PoiClassCategoriesInputSequence(PoiCategoryByUIDWrapperSequence.this.categoriesModelAccess, PoiCategoryByUIDWrapperSequence.this.commandListFactory, PoiCategoryByUIDWrapperSequence.this.searchArea, this.env, lIValueListElement, PoiCategoryByUIDWrapperSequence.this.vehicle, true, PoiCategoryByUIDWrapperSequence.this.detailsScreen);
                PoiCategoryByUIDWrapperSequence.this.currentInputSequence = poiClassCategoriesInputSequence;
                this.logger.log(10000000, "[PoiInput] CategoryByUIDWrapperSequence#navCommand#execute() - continue directly to results screen");
                this.getCommandList().commandFinishedWithPostSequence(poiClassCategoriesInputSequence.createStartSequence());
            }
        });
        return commandList;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] CategoryByUIDWrapperSequence#start()");
        CommandList commandList = this.getStartSequence();
        commandList.execute("CategoryByUIDWrapperSequence#start");
    }

    protected CommandList restoreCurrent() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Check For Spellerstate available"){

            public void execute() {
                if (PoiCategoryByUIDWrapperSequence.this.initialSpellerState == null) {
                    this.env.getLogChannel().log(1000000, "[PoiInput] CategoryByUIDWrapperSequence#Invalid sequence state - spellerState is NULL.");
                    this.getCommandList().commandAborted("Not Initial Spellerstate available");
                } else {
                    if (this.env.getLogChannel().isDebug2()) {
                        this.env.getLogChannel().log(100000000, "[PoiInput] CategoryByUIDWrapperSequence#Invalid sequence state - spellerState is OK.");
                    }
                    this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(PoiCategoryByUIDWrapperSequence.this.initialSpellerState));
                }
            }
        });
        return commandList;
    }
}

