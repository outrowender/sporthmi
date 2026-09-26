/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateChildCategoryListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildCategoryScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence$4;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiParentChildCategoryScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiParentChildCategoryScreenModelAccess modelAccess;

    public PoiParentChildCategoryScreenInputSequence(IPoiParentChildCategoryScreenModelAccess iPoiParentChildCategoryScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(5), iPoiManager);
        this.modelAccess = iPoiParentChildCategoryScreenModelAccess;
        this.spellerType = 0x6800000;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiParentChildCategoryScreenInputSequence$1(this, new StringBuffer().append(this.CLASS_NAME).append(" - setParentElementOnModelAccess").toString()));
        commandList.add(new PoiParentChildCategoryScreenInputSequence$2(this, new StringBuffer().append(this.CLASS_NAME).append(" - ModelOnElementSelected with Element from CommandListContext").toString()));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiParentChildCategoryScreenInputSequence$3(this, new StringBuffer().append(this.CLASS_NAME).append(" - ChooseSpellerTypeDependentOnSearchContext").toString()));
        commandList.add(new ModelUpdateChildCategoryListCommand(this.modelAccess, this.commandListFactory));
        return commandList;
    }

    private CommandList createStartSpellerCommandList(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiParentChildCategoryScreenInputSequence$4(this, new StringBuffer().append(this.CLASS_NAME).append("#createStartSpellerCommandList").toString()));
        commandList.add(new LIStartSpellerCommand(n, false, false, false));
        return commandList;
    }

    private int getSortOrder() {
        return 1;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    public IPoiParentChildCategoryScreenModelAccess getPoiParentChildCategoryScreenModelAccess() {
        return this.modelAccess;
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
    }

    static /* synthetic */ IPoiParentChildCategoryScreenModelAccess access$000(PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence) {
        return poiParentChildCategoryScreenInputSequence.modelAccess;
    }

    static /* synthetic */ CommandList access$100(PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence, int n) {
        return poiParentChildCategoryScreenInputSequence.createStartSpellerCommandList(n);
    }
}

