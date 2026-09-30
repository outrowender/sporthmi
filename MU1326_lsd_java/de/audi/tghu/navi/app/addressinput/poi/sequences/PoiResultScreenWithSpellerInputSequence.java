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
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultScreenWithSpellerInputSequence
extends AbstractPoiScreenInputSequence {
    private static final int MINIMUM_RESULTS_TO_GO_ON = 1;
    private final IPoiResultScreenWithSpellerModelAccess modelAccess;
    private final SubstringSearchHandler substringSearchHandler;

    public PoiResultScreenWithSpellerInputSequence(IPoiResultScreenWithSpellerModelAccess iPoiResultScreenWithSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(9), iPoiManager);
        this.modelAccess = iPoiResultScreenWithSpellerModelAccess;
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiResultScreenWithSpellerModelAccess);
    }

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
        commandList.add(new NavCommand("SelectListItem with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
            }
        });
        commandList.add(new NavCommand("ModelOnElementSelected with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiResultScreenWithSpellerInputSequence.this.modelAccess, (LIValueListElement)this.commandList.get("CurrentSelection")));
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
                CommandList commandList = PoiResultScreenWithSpellerInputSequence.this.commandListFactory.createCommandList();
                if (PoiResultScreenWithSpellerInputSequence.this.poiSearchArea.getSearchContext() == 5) {
                    commandList.add(new PoiSelectSelectionCriteriaCommand(n));
                } else {
                    commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiResultScreenWithSpellerInputSequence.this.substringSearchHandler));
                }
                commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiResultScreenWithSpellerInputSequence.this.modelAccess, PoiResultScreenWithSpellerInputSequence.this.commandListFactory, 1, PoiResultScreenWithSpellerInputSequence.this.poiManager));
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
                CommandList commandList = PoiResultScreenWithSpellerInputSequence.this.commandListFactory.createCommandList();
                if (PoiResultScreenWithSpellerInputSequence.this.poiSearchArea.getSearchContext() == 5) {
                    commandList.add(new PoiSelectSelectionCriteriaCommand(n));
                } else {
                    commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiResultScreenWithSpellerInputSequence.this.substringSearchHandler));
                }
                commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiResultScreenWithSpellerInputSequence.this.modelAccess, PoiResultScreenWithSpellerInputSequence.this.commandListFactory, 1, PoiResultScreenWithSpellerInputSequence.this.poiManager));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    private int getSortOrder() {
        return 2;
    }

    private CommandList createStartSpellerCommands(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (n == 1) {
            commandList.add(new PoiStartSpellerAlongRouteCommand(32778, Util.isHURegionNAR()));
            return commandList;
        }
        NavLocation navLocation = PoiUtil.getLocation(this.poiSearchArea, this.env);
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new LIStartSpellerCommand(32778, false, false, false));
        return commandList;
    }

    public void setInput(String string) {
        this.env.getLogChannel().log(10000000, "%1#setInput( %2 )", (Object)this.CLASS_NAME, (Object)string);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Input was entered");
        }
        final LIValueList lIValueList = new LIValueList();
        lIValueList.list = new LIValueListElement[0];
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess != null) {
            commandList.add(new NavCommand("Delete valuelist"){

                public void execute() {
                    this.env.getContainer().setLispValueListCount(0L);
                    this.env.getContainer().setLispValueList(lIValueList);
                    this.commandList.commandFinished();
                }
            });
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
}

