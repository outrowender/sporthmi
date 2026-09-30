/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.addressinput.AbstractAddressInputHistoryElementListRow;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastStateHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastStreetHistoryEntryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class LiCityStateStreetHistoryListAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private final ICommandListFactory commandListFactory;

    public LiCityStateStreetHistoryListAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        AbstractAddressInputHistoryElementListRow abstractAddressInputHistoryElementListRow = (AbstractAddressInputHistoryElementListRow)evoListRow;
        CityHistory.HistoryEntry historyEntry = abstractAddressInputHistoryElementListRow.getHistoryEntry();
        CommandList commandList = this.commandListFactory.createCommandList(n);
        if (historyEntry.getEntry() instanceof LICityHistoryEntry) {
            commandList.add(new GetLastCityHistoryEntryCommand((LICityHistoryEntry)historyEntry.getEntry()));
        } else if (historyEntry.getEntry() instanceof LIStateHistoryEntry) {
            commandList.add(new GetLastStateHistoryEntryCommand((LIStateHistoryEntry)historyEntry.getEntry()));
        } else if (historyEntry.getEntry() instanceof LIStreetHistoryEntry) {
            commandList.add(new GetLastStreetHistoryEntryCommand((LIStreetHistoryEntry)historyEntry.getEntry()));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                LiCityStateStreetHistoryListAsyncNavLocationExtractor.this.putResultInCommandListMap("navLocation", object, this.getCommandList(), this.logger);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (!(evoListRow instanceof AbstractAddressInputHistoryElementListRow)) {
            throw new IllegalArgumentException("This NavLocationExtractor works only with AbstractAddressInputHistoryElementListRow objects");
        }
    }
}

