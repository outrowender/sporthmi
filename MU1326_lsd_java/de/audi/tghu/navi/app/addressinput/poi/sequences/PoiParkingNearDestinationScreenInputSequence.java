/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParkingNearDestinationScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiParkingNearDestinationScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private static final int MINIMUM_RESULTS_TO_GO_ON;
    private final IPoiParkingNearDestinationScreenModelAccess modelAccess;
    private final SubstringSearchHandler substringSearchHandler;

    public PoiParkingNearDestinationScreenInputSequence(ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiParkingNearDestinationScreenModelAccess iPoiParkingNearDestinationScreenModelAccess, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(16), iPoiManager);
        this.modelAccess = iPoiParkingNearDestinationScreenModelAccess;
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiParkingNearDestinationScreenModelAccess);
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiParkingNearDestinationScreenInputSequence$1(this, new StringBuffer().append(this.CLASS_NAME).append("#Set SearchContext to SelectedLocation from ResponseContainer").toString()));
        commandList.add(new PoiParkingNearDestinationScreenInputSequence$2(this, "Decide which speller must be started"));
        commandList.add(new LispSelectByCategoryUidCommand(102));
        commandList.add(new PoiParkingNearDestinationScreenInputSequence$3(this));
        return commandList;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    public void requestItems(int n, int n2, int n3) {
        this.requestItems(n, n2, n3, null);
    }

    public void requestItems(int n, int n2, int n3, NavCommand navCommand) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LIValueListWindowSizeCommand(n3));
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        commandList.add(new LIValueListWindowSizeCommand(-1));
        if (n == 0 && navCommand != null) {
            commandList.add(navCommand);
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    private int getSortOrder() {
        return 2;
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
    }

    public void setInput(String string) {
        this.env.getLogChannel().log(-2137614336, "%1#setInput( %2 )", (Object)this.CLASS_NAME, (Object)string);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Input was entered");
        }
        LIValueList lIValueList = new LIValueList();
        lIValueList.list = new LIValueListElement[0];
        this.env.getContainer().setLispValueListCount(0L);
        this.env.getContainer().setLispValueList(lIValueList);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateResultScreenWithSpellerListCommand(this.modelAccess));
        }
        commandList.add(new SetInputCommand(string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setInput").toString());
    }

    static /* synthetic */ IPoiParkingNearDestinationScreenModelAccess access$100(PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence) {
        return poiParkingNearDestinationScreenInputSequence.modelAccess;
    }

    static /* synthetic */ SubstringSearchHandler access$200(PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence) {
        return poiParkingNearDestinationScreenInputSequence.substringSearchHandler;
    }
}

