/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiBrandResultScreenNoSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiBrandResultScreenNoSpellerInputSequence
extends AbstractPoiScreenInputSequence {
    private static final int MINIMUM_RESULTS_TO_GO_ON;
    private SubstringSearchHandler substringSearchHandler;
    private IPoiBrandResultScreenNoSpellerModelAccess modelAccess;

    public PoiBrandResultScreenNoSpellerInputSequence(IPoiBrandResultScreenNoSpellerModelAccess iPoiBrandResultScreenNoSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(15), iPoiManager);
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiBrandResultScreenNoSpellerModelAccess);
        this.modelAccess = iPoiBrandResultScreenNoSpellerModelAccess;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiBrandResultScreenNoSpellerInputSequence$1(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiBrandResultScreenNoSpellerInputSequence$2(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new PoiBrandResultScreenNoSpellerInputSequence$3(this));
        return commandList;
    }

    public CommandList getStartSearchByName() {
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

    public void requestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestItems").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
    }

    public void onElementFocused(NavLocation navLocation) {
        this.modelAccess.onElementFocused(navLocation);
    }

    static /* synthetic */ IPoiBrandResultScreenNoSpellerModelAccess access$000(PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence) {
        return poiBrandResultScreenNoSpellerInputSequence.modelAccess;
    }

    static /* synthetic */ SubstringSearchHandler access$100(PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence) {
        return poiBrandResultScreenNoSpellerInputSequence.substringSearchHandler;
    }
}

