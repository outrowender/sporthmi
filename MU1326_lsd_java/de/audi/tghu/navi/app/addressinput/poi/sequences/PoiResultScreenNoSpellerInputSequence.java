/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenNoSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultScreenNoSpellerInputSequence
extends AbstractPoiScreenInputSequence {
    protected static final int MINIMUM_RESULTS_TO_GO_ON;
    protected final IPoiResultScreenNoSpellerModelAccess modelAccess;
    private final SubstringSearchHandler substringSearchHandler;
    private final int minimumResultsToGoOn;

    public PoiResultScreenNoSpellerInputSequence(IPoiResultScreenNoSpellerModelAccess iPoiResultScreenNoSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, int n, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(10), iPoiManager);
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiResultScreenNoSpellerModelAccess);
        this.modelAccess = iPoiResultScreenNoSpellerModelAccess;
        this.minimumResultsToGoOn = n;
    }

    public PoiResultScreenNoSpellerInputSequence(IPoiResultScreenNoSpellerModelAccess iPoiResultScreenNoSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        this(iPoiResultScreenNoSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, 1, iPoiManager);
    }

    public CommandList getStartCommandListWithElement() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiResultScreenNoSpellerInputSequence$1(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiResultScreenNoSpellerInputSequence$2(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiResultScreenNoSpellerInputSequence$3(this));
        return commandList;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(this.createStartSpellerCommands(this.poiSearchArea.getSearchContext()));
        if (this.poiSearchArea.getSearchContext() == 5) {
            commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        } else {
            commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(this.modelAccess, this.commandListFactory, this.getMinimumResultsToGoOn(), this.poiManager));
        }
        return commandList;
    }

    protected CommandList createStartSpellerCommands(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (n == 1) {
            commandList.add(new PoiStartSpellerAlongRouteCommand(0xA800000, Util.isHURegionNAR()));
            return commandList;
        }
        NavLocation navLocation = PoiUtil.getLocation(this.poiSearchArea, this.env);
        commandList.add(new PoiSetContextCommand(navLocation));
        if (this.poiSearchArea.getSearchContext() == 5) {
            commandList.add(new LIStartSpellerCommand(0x3800000, false, false, false));
        } else {
            commandList.add(new LIStartSpellerCommand(0xA800000, false, false, false));
        }
        return commandList;
    }

    public CommandList getStartCommandList(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LispSelectByCategoryUidCommand(n));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiResultScreenNoSpellerInputSequence$4(this));
        return commandList;
    }

    public CommandList getStartSearchByName() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartBrandSelected() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
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
        this.getSubstringSearchHandler().updatePoiSubstringSearchStatus(valueListStatus);
    }

    public IPoiResultScreenNoSpellerModelAccess getModelAccess() {
        return this.modelAccess;
    }

    protected int getSortOrder() {
        return 2;
    }

    public void onElementFocused(NavLocation navLocation) {
        this.modelAccess.onElementFocused(navLocation);
    }

    public SubstringSearchHandler getSubstringSearchHandler() {
        return this.substringSearchHandler;
    }

    public int getMinimumResultsToGoOn() {
        return this.minimumResultsToGoOn;
    }
}

