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
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence$5;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultScreenWithSpellerInputSequence
extends AbstractPoiScreenInputSequence {
    private static final int MINIMUM_RESULTS_TO_GO_ON;
    private final IPoiResultScreenWithSpellerModelAccess modelAccess;
    private final SubstringSearchHandler substringSearchHandler;

    public PoiResultScreenWithSpellerInputSequence(IPoiResultScreenWithSpellerModelAccess iPoiResultScreenWithSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(9), iPoiManager);
        this.modelAccess = iPoiResultScreenWithSpellerModelAccess;
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiResultScreenWithSpellerModelAccess);
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(this.createStartSpellerCommands(this.poiSearchArea.getSearchContext()));
        commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(this.modelAccess, this.commandListFactory, 1, this.poiManager));
        return commandList;
    }

    public CommandList getStartCommandListWithElement() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiResultScreenWithSpellerInputSequence$1(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiResultScreenWithSpellerInputSequence$2(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiResultScreenWithSpellerInputSequence$3(this));
        return commandList;
    }

    public CommandList getStartCommandListByUID(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LispSelectByCategoryUidCommand(n));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiResultScreenWithSpellerInputSequence$4(this));
        return commandList;
    }

    private int getSortOrder() {
        return 2;
    }

    private CommandList createStartSpellerCommands(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (n == 1) {
            commandList.add(new PoiStartSpellerAlongRouteCommand(0xA800000, Util.isHURegionNAR()));
            return commandList;
        }
        NavLocation navLocation = PoiUtil.getLocation(this.poiSearchArea, this.env);
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new LIStartSpellerCommand(0xA800000, false, false, false));
        return commandList;
    }

    public void setInput(String string) {
        this.env.getLogChannel().log(-2137614336, "%1#setInput( %2 )", (Object)this.CLASS_NAME, (Object)string);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Input was entered");
        }
        LIValueList lIValueList = new LIValueList();
        lIValueList.list = new LIValueListElement[0];
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess != null) {
            commandList.add(new PoiResultScreenWithSpellerInputSequence$5(this, "Delete valuelist", lIValueList));
            commandList.add(new NewModelUpdateResultScreenWithSpellerListCommand(this.modelAccess));
        }
        commandList.add(new SetInputCommand(string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setInput").toString());
    }

    public void requestItems(int n, int n2, int n3) {
        this.requestItems(n, n2, n3, null);
    }

    public void requestItems(int n, int n2, int n3, NavCommand navCommand) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        if (n == 0 && navCommand != null) {
            commandList.add(navCommand);
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public CommandList getSelectListElement(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
    }

    public IPoiResultScreenWithSpellerModelAccess getModelAccess() {
        return this.modelAccess;
    }

    public void onElementFocused(NavLocation navLocation) {
        this.modelAccess.onElementFocused(navLocation);
    }

    static /* synthetic */ IPoiResultScreenWithSpellerModelAccess access$000(PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence) {
        return poiResultScreenWithSpellerInputSequence.modelAccess;
    }

    static /* synthetic */ SubstringSearchHandler access$100(PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence) {
        return poiResultScreenWithSpellerInputSequence.substringSearchHandler;
    }
}

