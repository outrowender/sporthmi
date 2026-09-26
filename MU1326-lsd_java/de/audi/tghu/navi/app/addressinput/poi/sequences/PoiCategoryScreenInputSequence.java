/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiCategoryScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence$5;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCategoryScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiCategoryScreenModelAccess modelAccess;

    public PoiCategoryScreenInputSequence(IPoiCategoryScreenModelAccess iPoiCategoryScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(13), iPoiManager);
        this.modelAccess = iPoiCategoryScreenModelAccess;
    }

    public CommandList getStartCommandList(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new LispSelectByCategoryUidCommand(n));
        commandList.add(new PoiCategoryScreenInputSequence$1(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiCategoryScreenInputSequence$2(this, "CheckSelectionCriteria"));
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiCategoryScreenInputSequence$3(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiCategoryScreenInputSequence$4(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiCategoryScreenInputSequence$5(this, "CheckSelectionCriteria"));
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    public CommandList getStartSearchByName() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getAllResultsSelected() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    private int getSortOrder() {
        return 1;
    }

    static /* synthetic */ IPoiCategoryScreenModelAccess access$000(PoiCategoryScreenInputSequence poiCategoryScreenInputSequence) {
        return poiCategoryScreenInputSequence.modelAccess;
    }
}

