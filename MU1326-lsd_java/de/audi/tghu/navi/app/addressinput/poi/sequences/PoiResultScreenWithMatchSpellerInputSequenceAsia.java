/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPUndoCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.ClearPoiSubstringSearchStatusCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithMatchSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia$5;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.commands.FilterHandwritingCharactersCommand;
import de.audi.tghu.navi.app.di.commands.LISPAddStrokeCommand;
import de.audi.tghu.navi.app.di.commands.LISPRequestNVCValidCharsCommand;
import de.audi.tghu.navi.app.di.commands.LISetNvcRangeCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerStrokeStatusCommand;
import de.audi.tghu.navi.app.di.commands.SetSpellerValidHanziCharsCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputAsiaSpecificSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultScreenWithMatchSpellerInputSequenceAsia
extends PoiResultScreenWithMatchSpellerInputSequence
implements IAddressInputAsiaSpecificSequence {
    private static final int MINIMUM_WINDOW_SIZE;
    private static final int DEFAULT_WINDOW_SIZE;
    protected final SubstringSearchHandler substringSearchHandler;
    private final IPreviewMap previewMapInterface;

    public PoiResultScreenWithMatchSpellerInputSequenceAsia(IPoiResultScreenWithMatchSpellerModelAccess iPoiResultScreenWithMatchSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iPoiResultScreenWithMatchSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, iPoiManager);
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiResultScreenWithMatchSpellerModelAccess);
        this.previewMapInterface = iPreviewMap;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        SpellerContext spellerContext = this.spellerStack.getActiveSC();
        int n = -1;
        if (spellerContext != null) {
            n = spellerContext.getContextID();
        }
        this.logChannel.log(-2137614336, "%1#getStartCommandList - spellerStack.getActiveSC().getContextID()=%2", (Object)this.CLASS_NAME, (long)n);
        NavLocation navLocation = n == 26 || n == 32 || n == 40 ? this.poiSearchArea.getLocation() : PoiUtil.getLocation(this.poiSearchArea, this.env);
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new ClearPoiSubstringSearchStatusCommand());
        commandList.add(new LIStartSpellerCommand(0x3800000, false, false, false));
        commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(this.modelAccess, this.commandListFactory, 1, this.poiManager));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        return commandList;
    }

    @Override
    public CommandList getStartCommandListWithElement() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiResultScreenWithMatchSpellerInputSequenceAsia$1(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiResultScreenWithMatchSpellerInputSequenceAsia$2(this, "ModelOnElementSelected with Element from CommandListContext"));
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new PoiResultScreenWithMatchSpellerInputSequenceAsia$3(this, new StringBuffer().append(this.CLASS_NAME).append(" - Decide Selection Criteria").toString()));
        return commandList;
    }

    @Override
    public CommandList getStartCommandListByUID(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LispSelectByCategoryUidCommand(n));
        commandList.add(new PoiResultScreenWithMatchSpellerInputSequenceAsia$4(this));
        return commandList;
    }

    protected int getSortOrder() {
        return 1;
    }

    @Override
    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addCharacter").toString());
    }

    @Override
    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoCharacter").toString());
    }

    @Override
    public void deleteAllCharacters() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#deleteAllCharacters").toString());
    }

    @Override
    public void requestItems(int n, int n2, int n3) {
        this.requestItems(n, n2, n3, null);
    }

    @Override
    public void requestItems(int n, int n2, int n3, NavCommand navCommand) {
        this.getRequestItemsCommandList(n, n2, n3, navCommand, false).execute(new StringBuffer().append(this.CLASS_NAME).append("#requestItems").toString());
    }

    protected CommandList getRequestItemsCommandList(int n, int n2, int n3, NavCommand navCommand, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LIValueListWindowSizeCommand(n3));
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        if (!bl) {
            commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        }
        commandList.add(new LIValueListWindowSizeCommand(-1));
        if (n == 0 && navCommand != null) {
            commandList.add(navCommand);
        }
        return commandList;
    }

    @Override
    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public void onElementFocused(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new PoiResultScreenWithMatchSpellerInputSequenceAsia$5(this));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#onElementFocused").toString());
    }

    @Override
    public synchronized void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
        if (!PoiUtil.substringSearchStarted(valueListStatus)) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(this.getRequestItemsCommandList(0, 0, 1, null, false));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#onUpdateSearchStatus - requesting items").toString());
        }
    }

    @Override
    public void addStroke(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPAddStrokeCommand(string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#addStroke").toString());
    }

    @Override
    public void undoStroke() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#undoStroke").toString());
    }

    @Override
    public void touchPadInputModeChanged(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPDeleteAllCharactersCommand(true));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        if (n == 1) {
            commandList.add(new LISetNvcRangeCommand(2));
        } else if (n == 0) {
            commandList.add(new LISetNvcRangeCommand(1));
        } else {
            this.logChannel.log(10000, "%1#touchPadInputModeChanged - invalid id for mode=%2", (Object)this.CLASS_NAME, (long)n);
        }
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#touchPadInputModeChanged").toString());
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestNVCValidCharsCommand(3, n2, n3));
        commandList.add(new SetSpellerValidHanziCharsCommand(this.env.getMatchSpellerModel(n)));
        commandList.add(new SetSpellerStrokeStatusCommand(this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestValidHanziCharsWindow").toString());
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string, MatchspellerModelApp matchspellerModelApp) {
        this.logChannel.log(-2137614336, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new FilterHandwritingCharactersCommand(matchspellerModelApp, string));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#nonAlphaNumTPCharsChanged").toString());
    }

    static /* synthetic */ IPreviewMap access$000(PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia) {
        return poiResultScreenWithMatchSpellerInputSequenceAsia.previewMapInterface;
    }
}

