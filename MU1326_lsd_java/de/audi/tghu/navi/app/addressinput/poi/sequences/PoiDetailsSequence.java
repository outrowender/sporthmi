/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiLocationCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.IPoiDetailsSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence$3;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiDetailsSequence
implements IPoiDetailsSequence {
    private final ICommandListFactory commandListFactory;
    private final GuiModelAccessDetailsNavi poiDetailsModelAccess;
    private final LIValueListElement selectedElement;
    private final IDetailsScreen detailsScreen;

    public PoiDetailsSequence(ICommandListFactory iCommandListFactory, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, LIValueListElement lIValueListElement, IDetailsScreen iDetailsScreen) {
        this.commandListFactory = iCommandListFactory;
        this.poiDetailsModelAccess = guiModelAccessDetailsNavi;
        this.selectedElement = lIValueListElement;
        this.detailsScreen = iDetailsScreen;
    }

    @Override
    public void start() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        commandList.add(new PoiDetailsSequence$1(this));
        commandList.add(new ModelUpdatePoiLocationCommand(this.poiDetailsModelAccess));
        commandList.add(new PoiDetailsSequence$2(this, "call enter details screen again"));
        commandList.add(new PoiDetailsSequence$3(this));
        commandList.execute("PoiDetailsSequence#start");
    }

    static /* synthetic */ IDetailsScreen access$000(PoiDetailsSequence poiDetailsSequence) {
        return poiDetailsSequence.detailsScreen;
    }
}

