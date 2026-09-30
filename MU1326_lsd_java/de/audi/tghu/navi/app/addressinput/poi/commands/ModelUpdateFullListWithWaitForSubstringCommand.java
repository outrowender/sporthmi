/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.IUpdatePoiSubstringSearchStatus;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerListCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public class ModelUpdateFullListWithWaitForSubstringCommand
extends NavCommand {
    private static final int MAXIMUM_VALUE_LIST_SIZE = 10;
    private final int minimumResultsToGoOn;
    private final IPoiScreenUpdateResultList modelAccess;
    private final ICommandListFactory commandListFactory;
    private boolean alreadyQueriedResults = false;
    private final IUpdatePoiSubstringSearchStatus poiManager;

    public ModelUpdateFullListWithWaitForSubstringCommand(IPoiScreenUpdateResultList iPoiScreenUpdateResultList, ICommandListFactory iCommandListFactory, int n, IUpdatePoiSubstringSearchStatus iUpdatePoiSubstringSearchStatus) {
        this.modelAccess = iPoiScreenUpdateResultList;
        this.commandListFactory = iCommandListFactory;
        this.minimumResultsToGoOn = n;
        this.poiManager = iUpdatePoiSubstringSearchStatus;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute", (Object)this.CLASS_NAME);
        if (this.sdsIsActiveAndRegionIsAsia() || this.searchLooksGood(this.dsiResponseContainer.getPoiSubstringSearchStatus())) {
            this.logger.log(10000000, "%1#execute - search looks good - starting to request items!", (Object)this.CLASS_NAME);
            this.requestItems();
        }
    }

    private boolean sdsIsActiveAndRegionIsAsia() {
        return this.env.getInputModeManager().isSdsActive() && Util.isHURegionAsia();
    }

    private boolean searchLooksGood(ValueListStatus valueListStatus) {
        return PoiUtil.substringSearchIsRunning(valueListStatus) && PoiUtil.substringSearchHasItems(this.minimumResultsToGoOn, valueListStatus) || PoiUtil.substringSearchEnded(valueListStatus);
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.logger.log(10000000, "%1#updatePoiSubstringSearchStatus - valueListStatus=%2", (Object)this.CLASS_NAME, (Object)valueListStatus);
        this.dsiResponseContainer.setPoiSubstringSearchStatus(valueListStatus);
        this.poiManager.updatePoiSubstringSearchStatus(valueListStatus);
        if (this.searchLooksGood(valueListStatus) && !this.sdsIsActiveAndRegionIsAsia()) {
            this.requestItems();
        } else {
            this.logger.log(10000000, "%1#updatePoiSubstringSearchStatus - no result found yet, keep on waiting. poiSubstringSearchStatus=%2", (Object)this.CLASS_NAME, (Object)valueListStatus);
        }
    }

    private synchronized void requestItems() {
        this.logger.log(10000000, "%1#requestItems - alreadyQueriedResults=%2", (Object)this.CLASS_NAME, (Object)Boolean.toString(this.alreadyQueriedResults));
        if (!this.alreadyQueriedResults) {
            this.logger.log(1000000, "%1#requestItems - minResults: %2", (Object)this.CLASS_NAME, (long)this.minimumResultsToGoOn);
            this.alreadyQueriedResults = true;
            CommandList commandList = this.commandListFactory.createCommandList();
            int n = this.calculateLiValueListWindowSize(this.minimumResultsToGoOn, this.dsiResponseContainer.getPoiSubstringSearchStatus());
            int n2 = this.calculateHowOftenRequestHasToBeDone(n, this.dsiResponseContainer.getPoiSubstringSearchStatus());
            this.logger.log(1000000, "%1#requestItems - windowSize = %2, requestTimes = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
            commandList.add(new LIValueListWindowSizeCommand(n));
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 == 0) {
                    commandList.add(new LISPRequestValueListByListIndexCommand(i2, true));
                } else {
                    commandList.add(new NavCommand(this.CLASS_NAME + "#requestItems --> Enqueue further requests"){

                        public void execute() {
                            LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
                            int n = lIValueList.getList().length;
                            if (n > 0) {
                                this.logger.log(10000000, "%1#execute() - valueListSize = %2", (Object)this.CLASS_NAME, (long)n);
                                int n2 = lIValueList.getList()[n - 1].getListIndex() + 1;
                                this.getCommandList().commandFinishedWithPostCommand(new LISPRequestValueListByListIndexCommand(n2, true));
                            } else {
                                this.logger.log(10000, "%1#execute() - The valueList is Empty. Cant continue requesting items", (Object)this.CLASS_NAME);
                                this.getCommandList().commandFinished();
                            }
                        }
                    });
                }
                commandList.add(new NewModelUpdateResultScreenWithSpellerListCommand(this.modelAccess));
            }
            commandList.add(new LIValueListWindowSizeCommand(-1));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }

    private int calculateLiValueListWindowSize(int n, ValueListStatus valueListStatus) {
        return 10;
    }

    private int calculateHowOftenRequestHasToBeDone(int n, ValueListStatus valueListStatus) {
        int n2;
        if (valueListStatus.getNumberOfAvailableItems() > this.minimumResultsToGoOn && this.minimumResultsToGoOn < 10) {
            return 1;
        }
        int n3 = 0;
        n3 = valueListStatus.getNumberOfAvailableItems() % n > 0 ? valueListStatus.getNumberOfAvailableItems() / n + 1 : valueListStatus.getNumberOfAvailableItems() / n;
        if (this.minimumResultsToGoOn > n && n3 > (n2 = this.minimumResultsToGoOn / n)) {
            return n2;
        }
        return n3;
    }
}

