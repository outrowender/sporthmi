/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPDeleteAllCharactersCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPUndoCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithMatchSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.CmdNaviPreviewMapPrepare;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultScreenWithMatchSpellerInputSequence
extends AbstractPoiScreenInputSequence {
    protected final IPoiResultScreenWithMatchSpellerModelAccess modelAccess;

    public PoiResultScreenWithMatchSpellerInputSequence(IPoiResultScreenWithMatchSpellerModelAccess iPoiResultScreenWithMatchSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(11), iPoiManager);
        this.modelAccess = iPoiResultScreenWithMatchSpellerModelAccess;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        NavLocation navLocation = PoiUtil.getLocation(this.poiSearchArea, this.env);
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new LIStartSpellerCommand(32771, false, false, false));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        return commandList;
    }

    public void focusPreviewMap(IPreviewMap iPreviewMap, NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(navLocation);
        CmdNaviPreviewMapPrepare cmdNaviPreviewMapPrepare = new CmdNaviPreviewMapPrepare(iPreviewMap, new NavLocation[]{navLocation}, navLocationWgs84, -1);
        commandList.add(cmdNaviPreviewMapPrepare);
        commandList.execute(this.CLASS_NAME + "#preparePreviewMap");
    }

    public CommandList getStartCommandListWithElement() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new NavCommand("SelectListItem with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
            }
        });
        commandList.add(new NavCommand("ModelOnElementSelected with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiResultScreenWithMatchSpellerInputSequence.this.modelAccess, (LIValueListElement)this.commandList.get("CurrentSelection")));
            }
        });
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "%1#createStartSequence#execute()", (Object)this.CLASS_NAME);
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "%1#createStartSequence#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "%1#createStartSequence#execute() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
                }
                int n = CommandUtil.getIndexForCriteria(16, lIValueList);
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "%1#createStartSequence#execute(): index for criteria: %2", (Object)this.CLASS_NAME, (long)n);
                }
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                    return;
                }
                CommandList commandList = PoiResultScreenWithMatchSpellerInputSequence.this.commandListFactory.createCommandList();
                if (PoiResultScreenWithMatchSpellerInputSequence.this.poiSearchArea.getSearchContext() == 5) {
                    commandList.add(new PoiSelectSelectionCriteriaCommand(n));
                }
                commandList.add(new NewModelUpdateResultListCommand(PoiResultScreenWithMatchSpellerInputSequence.this.modelAccess));
                commandList.add(new NewModelUpdateSpellerCommand(PoiResultScreenWithMatchSpellerInputSequence.this.modelAccess));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public CommandList getStartCommandListByUID(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LispSelectByCategoryUidCommand(n));
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "%1#createStartSequence#execute()", (Object)this.CLASS_NAME);
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "%1#createStartSequence#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "%1#createStartSequence#execute() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
                }
                int n = CommandUtil.getIndexForCriteria(16, lIValueList);
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "%1#createStartSequence#execute(): index for criteria: %2", (Object)this.CLASS_NAME, (long)n);
                }
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                    return;
                }
                CommandList commandList = PoiResultScreenWithMatchSpellerInputSequence.this.commandListFactory.createCommandList();
                if (PoiResultScreenWithMatchSpellerInputSequence.this.poiSearchArea.getSearchContext() == 5) {
                    commandList.add(new PoiSelectSelectionCriteriaCommand(n));
                }
                commandList.add(new NewModelUpdateResultListCommand(PoiResultScreenWithMatchSpellerInputSequence.this.modelAccess));
                commandList.add(new NewModelUpdateSpellerCommand(PoiResultScreenWithMatchSpellerInputSequence.this.modelAccess));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public CommandList getSelectElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
    }

    private int getSortOrder() {
        return 1;
    }

    public void addCharacter(String string) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void undoCharacter() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPUndoCharacterCommand());
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#undoCharacter");
    }

    public void deleteAllCharacters() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPDeleteAllCharactersCommand());
        commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
        commandList.add(new NewModelUpdateSpellerCommand(this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#deleteAllCharacters");
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
        commandList.execute(this.CLASS_NAME + "#requestItems");
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#unrequestItems");
    }

    public void onElementFocused(NavLocation navLocation) {
        this.modelAccess.onElementFocused(navLocation);
    }

    public IPoiResultScreenWithMatchSpellerModelAccess getModelAccess() {
        return this.modelAccess;
    }
}

