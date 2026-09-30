/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiCategoryScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCategoryScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiCategoryScreenModelAccess modelAccess;

    public PoiCategoryScreenInputSequence(IPoiCategoryScreenModelAccess iPoiCategoryScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new POISpellerContext(13), iPoiManager);
        this.modelAccess = iPoiCategoryScreenModelAccess;
    }

    public CommandList getStartCommandList(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new LispSelectByCategoryUidCommand(n));
        commandList.add(new NavCommand("ModelOnElementSelected with Element from CommandListContext"){

            public void execute() {
                LIValueListElement lIValueListElement = (LIValueListElement)this.commandList.get("CurrentSelection");
                if (lIValueListElement != null) {
                    this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiCategoryScreenInputSequence.this.modelAccess, lIValueListElement));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new NavCommand("CheckSelectionCriteria"){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                int n = CommandUtil.getIndexForCriteria(2, lIValueList);
                if (n >= 0) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaCommand(n));
                } else {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                }
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand("SelectListItem with Element from CommandListContext"){

            public void execute() {
                LIValueListElement lIValueListElement = (LIValueListElement)this.commandList.get("CurrentSelection");
                if (lIValueListElement != null) {
                    this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
                } else {
                    this.getCommandList().commandAborted("No SELECTED_ELEMENT in CommandList Context");
                }
            }
        });
        commandList.add(new NavCommand("ModelOnElementSelected with Element from CommandListContext"){

            public void execute() {
                LIValueListElement lIValueListElement = (LIValueListElement)this.commandList.get("CurrentSelection");
                if (lIValueListElement != null) {
                    this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiCategoryScreenInputSequence.this.modelAccess, lIValueListElement));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        commandList.add(new NavCommand("CheckSelectionCriteria"){

            public void execute() {
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                int n = CommandUtil.getIndexForCriteria(2, lIValueList);
                if (n >= 0) {
                    this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaCommand(n));
                } else {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                }
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory));
        }
        return commandList;
    }

    public CommandList getStartSearchByName() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getAllResultsSelected() {
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
}

