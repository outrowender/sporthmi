/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryByUIDSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoryByUIDWrapperSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoryByUIDWrapperSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoryByUIDWrapperSequence$3;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;

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
        this.env.getLogChannel().log(-2137614336, "[PoiInput] CategoryByUIDWrapperSequence#getStartSequence()");
        PoiCategoryByUIDSequence poiCategoryByUIDSequence = new PoiCategoryByUIDSequence(this.startSepellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence = poiCategoryByUIDSequence;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiCategoryByUIDWrapperSequence$1(this));
        commandList.add(poiCategoryByUIDSequence.createStartSequence());
        commandList.add(new PoiCategoryByUIDWrapperSequence$2(this));
        return commandList;
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] CategoryByUIDWrapperSequence#start()");
        CommandList commandList = this.getStartSequence();
        commandList.execute("CategoryByUIDWrapperSequence#start");
    }

    @Override
    protected CommandList restoreCurrent() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiCategoryByUIDWrapperSequence$3(this, "Check For Spellerstate available"));
        return commandList;
    }
}

