/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HistoryListRowBuilder;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LiLastCityOrStreetHistoryAddCommand;
import de.audi.tghu.navi.app.command.LiLastCityOrStreetHistoryDeleteAllCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class CityHistory {
    public static final String DEFAULT_LCH_RESOURCE = "resources/AppNavi/default.lch";
    private final ICommandListFactory commandListFactory;
    private final LogChannel logChannel;
    private LIStateHistoryEntry[] stateHistory;
    private LIStreetHistoryEntry[] streetHistory;
    private LICityHistoryEntry[] cityHistory;

    public CityHistory(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.logChannel = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
    }

    public CommandList addLastCityCommandList(NavLocation navLocation, boolean bl) {
        this.logChannel.log(10000000, "CityHistory#addLastCityCommandList( %2, %1 )", bl, (Object)LocationFormatter.formatLocationShort(navLocation));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiLastCityOrStreetHistoryAddCommand(navLocation, bl, LocationFormatter.formatCityTitleWithoutCityCenter(navLocation)));
        return commandList;
    }

    public CommandList addLastStreetCommandList(NavLocation navLocation) {
        this.logChannel.log(10000000, "CityHistory#addLastStreetCommandList( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiLastCityOrStreetHistoryAddCommand(navLocation, LocationFormatter.formatStreet(navLocation)));
        return commandList;
    }

    public boolean hasLastCityHistory(boolean bl) {
        List list = this.getAllMatchingLastCities(bl);
        return list != null && list.size() > 0;
    }

    public List getAllMatchingLastCities(boolean bl) {
        if (this.cityHistory == null || this.cityHistory.length == 0) {
            return null;
        }
        int n = this.cityHistory.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            if (bl) {
                if (!this.cityHistory[i2].isStreetsInCity()) continue;
                arrayList.add(new HistoryEntry(this.cityHistory[i2]));
                continue;
            }
            arrayList.add(new HistoryEntry(this.cityHistory[i2]));
        }
        return arrayList;
    }

    public boolean hasLastStreetHistory() {
        return this.streetHistory != null && this.streetHistory.length != 0;
    }

    public List getMatchingLastStates(String string) {
        if (this.stateHistory == null || this.stateHistory.length == 0) {
            return null;
        }
        int n = this.stateHistory.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            LIStateHistoryEntry lIStateHistoryEntry = this.stateHistory[i2];
            if (!this.stateMatches(lIStateHistoryEntry, string)) continue;
            arrayList.add(new HistoryEntry(lIStateHistoryEntry));
        }
        return arrayList;
    }

    private boolean stateMatches(LIStateHistoryEntry lIStateHistoryEntry, String string) {
        if (lIStateHistoryEntry == null) {
            return false;
        }
        return this.historyNameAndPrefixMatch(string, lIStateHistoryEntry.getName());
    }

    public List getMatchingLastCities(String string) {
        if (this.cityHistory == null || this.cityHistory.length == 0) {
            return null;
        }
        int n = this.cityHistory.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            LICityHistoryEntry lICityHistoryEntry = this.cityHistory[i2];
            if (!this.cityMatches(lICityHistoryEntry, string)) continue;
            arrayList.add(new HistoryEntry(lICityHistoryEntry));
        }
        return arrayList;
    }

    private boolean cityMatches(LICityHistoryEntry lICityHistoryEntry, String string) {
        if (lICityHistoryEntry == null) {
            return false;
        }
        return this.historyNameAndPrefixMatch(string, lICityHistoryEntry.getName());
    }

    public List getMatchingLastStreets(String string) {
        if (this.streetHistory == null || this.streetHistory.length == 0) {
            return null;
        }
        int n = this.streetHistory.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            LIStreetHistoryEntry lIStreetHistoryEntry = this.streetHistory[i2];
            if (!this.streetMatches(lIStreetHistoryEntry, string)) continue;
            arrayList.add(new HistoryEntry(lIStreetHistoryEntry));
        }
        return arrayList;
    }

    private boolean streetMatches(LIStreetHistoryEntry lIStreetHistoryEntry, String string) {
        if (lIStreetHistoryEntry == null) {
            return false;
        }
        return this.historyNameAndPrefixMatch(string, lIStreetHistoryEntry.getName());
    }

    public CommandList prepareDeleteLastStateCityAndStreetHistory() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiLastCityOrStreetHistoryDeleteAllCommand(0));
        if (!Util.isHURegionAsia()) {
            commandList.add(new LiLastCityOrStreetHistoryDeleteAllCommand(1));
        }
        return commandList;
    }

    public void updateLastState(LIStateHistoryEntry[] lIStateHistoryEntryArray) {
        this.logChannel.log(1000000, "CityHistory#updateLastState()");
        if (lIStateHistoryEntryArray != null) {
            for (int i2 = 0; i2 < lIStateHistoryEntryArray.length; ++i2) {
                this.logChannel.log(1000000, "CityHistory#updateLastState() - entry %2: %1", (Object)lIStateHistoryEntryArray[i2], (long)i2);
            }
        }
        this.stateHistory = lIStateHistoryEntryArray;
    }

    public void updateLastCity(LICityHistoryEntry[] lICityHistoryEntryArray) {
        this.logChannel.log(1000000, "CityHistory#updateLastCity()");
        if (lICityHistoryEntryArray != null) {
            for (int i2 = 0; i2 < lICityHistoryEntryArray.length; ++i2) {
                this.logChannel.log(1000000, "CityHistory#updateLastCity() - entry %2: %1", (Object)lICityHistoryEntryArray[i2], (long)i2);
            }
        }
        this.cityHistory = lICityHistoryEntryArray;
    }

    public void updateLastStreet(LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        this.logChannel.log(1000000, "CityHistory#updateLastStreet()");
        if (lIStreetHistoryEntryArray == null) {
            this.logChannel.log(1000000, "CityHistory#updateLastStreet() - ignoring null array");
            return;
        }
        for (int i2 = 0; i2 < lIStreetHistoryEntryArray.length; ++i2) {
            this.logChannel.log(1000000, "CityHistory#updateLastStreet() - entry %2: %1", (Object)lIStreetHistoryEntryArray[i2], (long)i2);
        }
        this.streetHistory = lIStreetHistoryEntryArray;
    }

    public String toString() {
        Object object;
        int n;
        int n2 = this.stateHistory == null ? 0 : this.stateHistory.length;
        int n3 = this.cityHistory == null ? 0 : this.cityHistory.length;
        int n4 = this.streetHistory == null ? 0 : this.streetHistory.length;
        Buffer buffer = new Buffer();
        buffer.append("State history:\n");
        for (n = 0; n < n2; ++n) {
            object = this.stateHistory[n];
            if (object == null) {
                buffer.append("null");
            } else {
                buffer.append(((LIStateHistoryEntry)object).toString());
            }
            buffer.append('\n');
        }
        buffer.append("City history:\n");
        for (n = 0; n < n3; ++n) {
            object = this.cityHistory[n];
            if (object == null) {
                buffer.append("null");
            } else {
                buffer.append(((LICityHistoryEntry)object).toString());
            }
            buffer.append('\n');
        }
        buffer.append("Street history:\n");
        for (n = 0; n < n4; ++n) {
            object = this.streetHistory[n];
            if (object == null) {
                buffer.append("null");
            } else {
                buffer.append(((LIStreetHistoryEntry)object).toString());
            }
            buffer.append('\n');
        }
        return buffer.toString();
    }

    private boolean historyNameAndPrefixMatch(String string, String string2) {
        String string3 = Util.deleteDash(Util.deleteWhiteSpaces(string.toUpperCase()));
        return Util.isEmpty(string3) ? true : Util.deleteDash(Util.deleteWhiteSpaces(string2.toUpperCase())).startsWith(string3);
    }

    public static class HistoryEntry {
        private final LIStateHistoryEntry stateEntry;
        private final LICityHistoryEntry cityEntry;
        private final LIStreetHistoryEntry streetEntry;

        public HistoryEntry(LIStateHistoryEntry lIStateHistoryEntry) {
            this.stateEntry = lIStateHistoryEntry;
            this.cityEntry = null;
            this.streetEntry = null;
        }

        public HistoryEntry(LICityHistoryEntry lICityHistoryEntry) {
            this.stateEntry = null;
            this.cityEntry = lICityHistoryEntry;
            this.streetEntry = null;
        }

        public HistoryEntry(LIStreetHistoryEntry lIStreetHistoryEntry) {
            this.stateEntry = null;
            this.cityEntry = null;
            this.streetEntry = lIStreetHistoryEntry;
        }

        public Object getEntry() {
            if (this.stateEntry != null) {
                return this.stateEntry;
            }
            if (this.cityEntry != null) {
                return this.cityEntry;
            }
            return this.streetEntry;
        }

        public String getEntryName() {
            if (this.stateEntry != null) {
                return this.stateEntry.getName();
            }
            if (this.cityEntry != null) {
                return this.cityEntry.getName();
            }
            return this.streetEntry.getName();
        }

        public long getId() {
            if (this.stateEntry != null) {
                return this.stateEntry.getId();
            }
            if (this.cityEntry != null) {
                return this.cityEntry.getId();
            }
            return this.streetEntry.getId();
        }
    }

    public static class HistoryForCurrentInput {
        public static final HistoryForCurrentInput NO_HISTORY = new HistoryForCurrentInput(new ArrayList());
        private final List matchingHistoryEntries;

        public HistoryForCurrentInput(List list) {
            this.matchingHistoryEntries = list;
        }

        public HistoryEntry getBestMatchingEntry() {
            if (this.matchingHistoryEntries != null && !this.matchingHistoryEntries.isEmpty()) {
                return (HistoryEntry)this.matchingHistoryEntries.get(0);
            }
            return null;
        }

        public EvoListRow[] getEntriesForList(LogChannel logChannel, HistoryListRowBuilder historyListRowBuilder) {
            logChannel.log(10000000, "CityHistory#HistoryForCurrentInput#getEntriesForList");
            if (this.matchingHistoryEntries == null) {
                return null;
            }
            EvoListRow[] evoListRowArray = new EvoListRow[this.matchingHistoryEntries.size()];
            for (int i2 = 0; i2 < this.matchingHistoryEntries.size(); ++i2) {
                evoListRowArray[i2] = historyListRowBuilder.buildListRow((HistoryEntry)this.matchingHistoryEntries.get(i2), 1000000 + i2);
            }
            return evoListRowArray;
        }
    }
}

