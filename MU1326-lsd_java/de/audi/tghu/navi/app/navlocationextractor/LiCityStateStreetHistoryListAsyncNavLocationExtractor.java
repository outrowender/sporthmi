/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.addressinput.AbstractAddressInputHistoryElementListRow;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastStateHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastStreetHistoryEntryCommand;
import de.audi.tghu.navi.app.navlocationextractor.AbstractAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiCityStateStreetHistoryListAsyncNavLocationExtractor$1;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class LiCityStateStreetHistoryListAsyncNavLocationExtractor
extends AbstractAsyncNavLocationExtractor {
    private final ICommandListFactory commandListFactory;

    public LiCityStateStreetHistoryListAsyncNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    protected CommandList getExtractNavLocationCL(EvoListRow evoListRow, int n) {
        this.checkArgument(evoListRow);
        AbstractAddressInputHistoryElementListRow abstractAddressInputHistoryElementListRow = (AbstractAddressInputHistoryElementListRow)evoListRow;
        CityHistory$HistoryEntry cityHistory$HistoryEntry = abstractAddressInputHistoryElementListRow.getHistoryEntry();
        CommandList commandList = this.commandListFactory.createCommandList(n);
        if (cityHistory$HistoryEntry.getEntry() instanceof LICityHistoryEntry) {
            commandList.add(new GetLastCityHistoryEntryCommand((LICityHistoryEntry)cityHistory$HistoryEntry.getEntry()));
        } else if (cityHistory$HistoryEntry.getEntry() instanceof LIStateHistoryEntry) {
            commandList.add(new GetLastStateHistoryEntryCommand((LIStateHistoryEntry)cityHistory$HistoryEntry.getEntry()));
        } else if (cityHistory$HistoryEntry.getEntry() instanceof LIStreetHistoryEntry) {
            commandList.add(new GetLastStreetHistoryEntryCommand((LIStreetHistoryEntry)cityHistory$HistoryEntry.getEntry()));
        }
        commandList.add(new LiCityStateStreetHistoryListAsyncNavLocationExtractor$1(this));
        return commandList;
    }

    private void checkArgument(EvoListRow evoListRow) {
        if (!(evoListRow instanceof AbstractAddressInputHistoryElementListRow)) {
            throw new IllegalArgumentException("This NavLocationExtractor works only with AbstractAddressInputHistoryElementListRow objects");
        }
    }
}

