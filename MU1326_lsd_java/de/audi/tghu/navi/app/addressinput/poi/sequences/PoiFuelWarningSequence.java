/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiFuelWarningModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiFuelWarningSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiFuelWarningModelAccess modelAccess;
    private final int maxResults;
    private final SubstringSearchHandler substringSearchHandler;

    public PoiFuelWarningSequence(ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPoiFuelWarningModelAccess iPoiFuelWarningModelAccess, int n, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(73), iPoiManager);
        this.modelAccess = iPoiFuelWarningModelAccess;
        this.maxResults = n;
        this.substringSearchHandler = new SubstringSearchHandler(navigationEnv, iPoiFuelWarningModelAccess);
    }

    public CommandList getStartCommandListWithElementByUid(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectByCategoryUidCommand(lIValueListElement.getPoiUniqueId()));
        if (this.modelAccess != null) {
            commandList.add(new ModelOnElementSelectedCommand(this.modelAccess, lIValueListElement));
            commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        }
        commandList.add(new NavCommand("PoiFuelWarningSequence#getStartCommandListWithElementByUid --> Select the SelectionCriteria"){

            public void execute() {
                this.logger.log(10000000, "PoiFuelWarningSequence#getStartCommandListWithElementByUid#execute()");
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "PoiFuelWarningSequence#getStartCommandListWithElementByUid#execute() - poiValueList or poiValueList.getList is null.");
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                int n = CommandUtil.getIndexForCriteria(16, lIValueList);
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                    return;
                }
                CommandList commandList = PoiFuelWarningSequence.this.commandListFactory.createCommandList();
                commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiFuelWarningSequence.this.substringSearchHandler));
                commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiFuelWarningSequence.this.modelAccess, PoiFuelWarningSequence.this.commandListFactory, PoiFuelWarningSequence.this.maxResults, PoiFuelWarningSequence.this.poiManager));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getListElementSelected(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("CurrentSelection", lIValueListElement);
        return commandList;
    }
}

