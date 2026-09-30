/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnlineSearchHistory {
    public static int MAX_CUSTOMER_HISTORY_LENGTH = 20;
    private static final int MAX_SYSTEM_HISTORY_LENGTH = 0;
    public static final int MAX_HISTORY_LENGTH = MAX_CUSTOMER_HISTORY_LENGTH + 0;
    public static final int MAX_HISTORY_COLUMNS = 2;
    private static final int LLD_DEFAULT = 0;
    private static final int LLD_CUSTOMER = 1;
    protected final NavigationEnv env;
    protected ListModelApp historyList;
    private ListModelApp historyPreviewList;
    protected ArrayList customerHistoryList = new ArrayList(MAX_CUSTOMER_HISTORY_LENGTH / 4);
    protected SpellerModelApp searchSpeller;
    protected LogChannel logChannel;
    protected boolean SDSSearch;

    public OnlineSearchHistory(NavigationEnv navigationEnv, ListModelApp listModelApp, ListModelApp listModelApp2, SpellerModelApp spellerModelApp) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.historyList = listModelApp;
        this.historyPreviewList = listModelApp2;
        this.searchSpeller = spellerModelApp;
        this.searchSpeller.setMinLength(0);
    }

    public void refreshSearchHistory() {
        this.refreshSearchHistory(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refreshSearchHistory(String string) {
        try {
            ListCell[] listCellArray;
            int n;
            int n2;
            boolean bl;
            this.logChannel.log(10000000, "OnlineSearchHistory#refreshSearchHistory() - customerHistoryList.size: %1 ", (long)this.customerHistoryList.size());
            this.logChannel.log(10000000, "OnlineSearchHistory#refreshSearchHistory() - HistoryList.size: %1 ", (long)this.historyList.getLength());
            this.SDSSearch = bl = string != null;
            String string2 = string == null ? this.searchSpeller.getText() : string;
            int n3 = n2 = string2 != null ? string2.length() : 0;
            if (bl) {
                this.searchSpeller.setExitButtonText(1);
            }
            Util.setModelStatus(this.historyPreviewList, !bl && n2 > 0 ? 1 : 0);
            this.historyList.beginTransaction();
            this.historyList.clear();
            this.historyPreviewList.beginTransaction();
            this.historyPreviewList.clear();
            int n4 = n = n2 > 0 ? 4 : 0;
            if (n2 > 0) {
                listCellArray = new ListCell[]{new TextListCell(string2), new IntegerListCell(0)};
                this.historyList.addRow(listCellArray);
            }
            int n5 = this.customerHistoryList.size() > MAX_CUSTOMER_HISTORY_LENGTH ? MAX_CUSTOMER_HISTORY_LENGTH : this.customerHistoryList.size();
            for (int i2 = 0; i2 < n5; ++i2) {
                String string3 = (String)this.customerHistoryList.get(i2);
                listCellArray = null;
                if (n2 > 0) {
                    if (string3.regionMatches(true, 0, string2, 0, n2) && n2 < string3.length()) {
                        listCellArray = new ListCell[]{new TextListCell(string3), new IntegerListCell(1)};
                    }
                } else {
                    listCellArray = new ListCell[]{new TextListCell(string3), new IntegerListCell(1)};
                }
                if (listCellArray == null) continue;
                this.historyList.addRow(listCellArray);
                if (n <= 0) continue;
                this.historyPreviewList.addRow(listCellArray);
                --n;
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "OnlineSearchHistory#refreshSearchHistory() - %1! ", (Throwable)exception);
            this.historyList.clear();
            this.historyPreviewList.clear();
        }
        finally {
            this.historyList.endTransaction();
            this.historyPreviewList.endTransaction();
        }
        this.refreshHistoryAccess();
    }

    protected void refreshHistoryAccess() {
        this.logChannel.log(100000, "OnlineSearchHistory#refreshHistoryAccess not implemented yet!");
    }

    public void handleSearchText(String string) {
        int n = this.customerHistoryList.size();
        this.logChannel.log(10000000, "OnlineSearchHistory#handleSearchText - searchText = %1, customerHistoryList = %2", (Object)string, (long)n);
        for (int i2 = 0; i2 < n; ++i2) {
            String string2 = (String)this.customerHistoryList.get(i2);
            if (string2 == null || !string2.equalsIgnoreCase(string)) continue;
            this.customerHistoryList.remove(i2);
            --n;
            break;
        }
        if (!Util.isEmpty(string)) {
            this.customerHistoryList.add(0, string);
        }
        this.saveState();
        this.refreshSearchHistory();
    }

    public void handleSearchTextSDS(String string) {
        int n = this.customerHistoryList.size();
        this.logChannel.log(10000000, "OnlineSearchHistory#handleSearchText - searchText = %1, customerHistoryList = %2", (Object)string, (long)n);
        for (int i2 = 0; i2 < n; ++i2) {
            String string2 = (String)this.customerHistoryList.get(i2);
            if (string2 == null || !string2.equalsIgnoreCase(string)) continue;
            this.customerHistoryList.remove(i2);
            --n;
            break;
        }
        if (!Util.isEmpty(string)) {
            this.customerHistoryList.add(0, string);
        }
        this.saveState();
        this.refreshSearchHistory(string);
    }

    public void resetHistory() {
        this.logChannel.log(10000000, "OnlineSearchHistory#resetHistory() ");
        this.customerHistoryList.clear();
        this.saveState();
        this.refreshSearchHistory();
    }

    public void loadState() {
        try {
            IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
            State state = new State(iStorageAccess, this.logChannel);
            state.readAndDeserialize();
            String[] stringArray = state.getHistory();
            this.customerHistoryList.clear();
            if (stringArray != null) {
                this.logChannel.log(10000000, "OnlineSearchHistory#loadState %1", (long)stringArray.length);
                for (int i2 = 0; i2 < stringArray.length && i2 < MAX_CUSTOMER_HISTORY_LENGTH; ++i2) {
                    this.customerHistoryList.add(stringArray[i2]);
                }
            } else {
                this.logChannel.log(10000000, "OnlineSearchHistory#loadState - no search history");
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "OnlineSearchHistory#loadState() - %1! ", (Throwable)exception);
        }
        this.refreshSearchHistory();
    }

    private void saveState() {
        try {
            IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
            int n = this.customerHistoryList.size();
            String[] stringArray = new String[n];
            this.logChannel.log(10000000, "OnlineSearchHistory#saveState - customerHistoryList = ( %1 )", (long)n);
            for (int i2 = 0; i2 < n; ++i2) {
                stringArray[i2] = (String)this.customerHistoryList.get(i2);
            }
            State state = new State(iStorageAccess, this.logChannel);
            state.setHistory(stringArray);
            state.serializeAndWrite();
        }
        catch (Exception exception) {
            this.logChannel.log(10000000, "OnlineSearchHistory#saveState() - could not save state! ", (Throwable)exception);
        }
    }

    public List getHistoryEntries() {
        return this.customerHistoryList;
    }

    public static class State
    extends PersistentState {
        public static final int VERSION = 1;
        public static final int KEY = 880;
        private static final String[] DEFAULT_HISTORY = new String[0];
        private String[] history;

        public State(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 880, logChannel);
        }

        protected void initWithDefaultValues() {
            this.history = DEFAULT_HISTORY;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.history = DEFAULT_HISTORY;
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            this.serializeStringArray(this.history, dataOutputStream);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.history = this.deserializeStringArray(dataInputStream);
            if (this.history == null) {
                this.history = DEFAULT_HISTORY;
            }
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "OnlineSearchHistory.State#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.history = this.deserializeStringArray(dataInputStream);
                    if (this.history == null) {
                        this.history = DEFAULT_HISTORY;
                    }
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "OnlineSearchHistory.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public String[] getHistory() {
            return this.history;
        }

        public void setHistory(String[] stringArray) {
            this.history = stringArray;
        }
    }
}

