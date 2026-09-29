/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiBrandScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence$3;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiBrandScreenModelAccess modelAccess;

    public PoiBrandScreenInputSequence(IPoiBrandScreenModelAccess iPoiBrandScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(14), iPoiManager);
        this.modelAccess = iPoiBrandScreenModelAccess;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.modelAccess != null) {
            commandList.add(new PoiModelStartCommand(this.modelAccess));
        }
        commandList.add(new PoiBrandScreenInputSequence$1(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiBrandScreenInputSequence$2(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiBrandScreenInputSequence$3(this));
        commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        return commandList;
    }

    protected int getSortOrder() {
        int n = 1;
        return n;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    public IPoiBrandScreenModelAccess getPoiBrandScreenModelAccess() {
        return this.modelAccess;
    }

    static /* synthetic */ IPoiBrandScreenModelAccess access$000(PoiBrandScreenInputSequence poiBrandScreenInputSequence) {
        return poiBrandScreenInputSequence.modelAccess;
    }
}

