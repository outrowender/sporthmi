/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateChildCategoryListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildCategoryScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
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
        this.spellerType = 32774;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(" - setParentElementOnModelAccess").toString()){

            public void execute() {
                PoiParentChildCategoryScreenInputSequence.this.modelAccess.setParentElement((LIValueListElement)this.getCommandList().get("CurrentSelection"));
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(" - ModelOnElementSelected with Element from CommandListContext").toString()){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiParentChildCategoryScreenInputSequence.this.modelAccess, (LIValueListElement)this.commandList.get("CurrentSelection")));
            }
        });
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(" - ChooseSpellerTypeDependentOnSearchContext").toString()){

            public void execute() {
                CommandList commandList = PoiParentChildCategoryScreenInputSequence.this.createStartSpellerCommandList(PoiParentChildCategoryScreenInputSequence.this.spellerType);
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        commandList.add(new ModelUpdateChildCategoryListCommand(this.modelAccess, this.commandListFactory));
        return commandList;
    }

    private CommandList createStartSpellerCommandList(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#createStartSpellerCommandList").toString()){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new PoiSetContextCommand(this.dsiResponseContainer.getLiCurrentLD()));
            }
        });
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
}

