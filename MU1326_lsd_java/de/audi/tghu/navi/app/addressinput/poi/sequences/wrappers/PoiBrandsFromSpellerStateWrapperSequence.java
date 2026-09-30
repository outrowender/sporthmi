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
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandsFromSpellerStateWrapperSequence
extends AbstractWrapperSequence {
    private final IPoiSpellerModelAccess modelAccess;
    private final ICommandListFactory commandListFactory;
    private final PoiSearchArea searchArea;
    private final LIValueListElement selectedCategoryElement;
    private final NavigationEnv env;
    private final LISpellerData categoriesSpellerData;
    private final IVehicle vehicle;
    private final boolean selectByUID;
    private LISpellerData initialSpellerState;

    public PoiBrandsFromSpellerStateWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, LISpellerData lISpellerData, IVehicle iVehicle, boolean bl, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.env = navigationEnv;
        this.selectedCategoryElement = lIValueListElement;
        this.modelAccess = iPoiSpellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.categoriesSpellerData = lISpellerData;
        this.vehicle = iVehicle;
        this.selectByUID = bl;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiBrandsFromSpellerStateWrapperSequence#start() - categElementIndex: %1 ", (Object)this.selectedCategoryElement);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiBrandsFromSpellerStateWrapperSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LIRestoreStateCommand(this.categoriesSpellerData));
        commandList.execute("PoiBrandsFromSpellerStateWrapperSequence#start");
        PoiBrandsInputSequence poiBrandsInputSequence = new PoiBrandsInputSequence(this.modelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedCategoryElement, this.vehicle, this.selectByUID, this.detailsScreen);
        this.currentInputSequence = poiBrandsInputSequence;
        poiBrandsInputSequence.start();
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

