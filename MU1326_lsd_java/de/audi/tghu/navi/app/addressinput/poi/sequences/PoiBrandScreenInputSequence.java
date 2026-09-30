/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiBrandScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiBrandScreenModelAccess modelAccess;

    public PoiBrandScreenInputSequence(IPoiBrandScreenModelAccess iPoiBrandScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(14), iPoiManager);
        this.modelAccess = iPoiBrandScreenModelAccess;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.modelAccess != null) {
            commandList.add(new PoiModelStartCommand(this.modelAccess));
        }
        commandList.add(new NavCommand("SelectListItem with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
            }
        });
        commandList.add(new NavCommand("ModelOnElementSelected with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiBrandScreenInputSequence.this.modelAccess, (LIValueListElement)this.commandList.get("CurrentSelection")));
            }
        });
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand(){

            public void execute() {
                int n;
                this.logger.log(10000000, "%1#getStartCommandList#execute()", (Object)this.CLASS_NAME);
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "%1#getStartCommandList#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                }
                if ((n = CommandUtil.getIndexForCriteria(13, lIValueList)) < 0) {
                    n = CommandUtil.getIndexForCriteria(11, lIValueList);
                }
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaCommand(n));
                }
            }
        });
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
}

