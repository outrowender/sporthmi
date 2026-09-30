/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.combi.NullCombiBAPServiceTV;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultListContentSupplier;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.lists.IListContentSupplier;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.storage.TVStorage;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class CombiBAPServiceHandler {
    private static final int SELECTION_CHANGE_INTERNAL = 0;
    private static final int SELECTION_CHANGE_SELECT = 1;
    private static final int SELECTION_CHANGE_SKIP = 2;
    private int selectionCause = 0;
    private final Object selectionCauseMutex = new Object();
    private CombiBAPServiceTV service = new NullCombiBAPServiceTV();
    public final EventListener activationListener = new EventListener();
    public final ITVListsListener listsListener = new ListsListener();
    public final TVListener tvListener = new TVListener();
    public final DSICallListener callListener = new CallListener();
    private final TVEnv env;
    private final TVStorage storage;
    private IListContentSupplier stationList = new DefaultListContentSupplier();
    private IListContentSupplier favoritesList = new DefaultListContentSupplier();
    private boolean isSeeking = false;
    private volatile boolean isAvAvailable = false;
    private volatile boolean isTunerAvailable = false;
    private volatile boolean isTunerInEsm = true;
    private CombiBAPCurrentStationInfo currentStationInfo = null;
    private final Object stationMutex = new Object();
    private volatile boolean isAvUsed = false;
    private volatile boolean tvHasMuAudioFocus = false;
    private volatile int listState = 0;

    public CombiBAPServiceHandler(TVEnv tVEnv, TVStorage tVStorage) {
        this.env = tVEnv;
        this.isAvAvailable = tVStorage.isAvSourceAvailable();
        this.storage = tVStorage;
    }

    public void registerStationList(IListContentSupplier iListContentSupplier) {
        this.stationList = iListContentSupplier;
    }

    public void registerFavoritesList(IListContentSupplier iListContentSupplier) {
        this.favoritesList = iListContentSupplier;
    }

    public synchronized void registerService(CombiBAPServiceTV combiBAPServiceTV) {
        this.service = combiBAPServiceTV;
        if (this.tvHasMuAudioFocus) {
            this.updateActiveSource(this.isAvUsed);
        }
        try {
            combiBAPServiceTV.updateStationListAutoUpdateInformation(true);
            if (!(this.stationList instanceof DefaultListContentSupplier)) {
                this.updateStationList();
                SelectedItem selectedItem = this.stationList.getSelected();
                if (selectedItem != null && this.isTunerAvailable) {
                    this.updateSelectedStation(this.stationList.getRowByIndex(selectedItem.getIndex()));
                }
            }
            if (!(this.favoritesList instanceof DefaultListContentSupplier)) {
                this.updateFavoritesList();
            }
            combiBAPServiceTV.updateActiveInfoState(this.getInfoState());
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void selectStation() {
        Object object = this.selectionCauseMutex;
        synchronized (object) {
            this.selectionCause = 1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void skip(boolean bl) {
        if (bl) {
            Object object = this.selectionCauseMutex;
            synchronized (object) {
                this.selectionCause = 2;
            }
        }
        CombiBAPServiceHandler combiBAPServiceHandler = this;
        synchronized (combiBAPServiceHandler) {
            try {
                this.service.skipResult(false);
            }
            catch (Exception exception) {
                this.env.lcCombi.log(10000, "%1", (Throwable)exception);
            }
        }
    }

    private synchronized void updateSeekState(boolean bl) {
        this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateSeekState] is seeking:%1", bl);
        try {
            this.service.updateSeekStatus(bl);
            int n = bl ? 6 : 0;
            this.service.updateActiveSourceState(n, 0);
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    private synchronized void updateFavoritesList() {
        BaseListModelApp baseListModelApp = this.favoritesList.getTmpList();
        if (baseListModelApp == null) {
            throw new IllegalArgumentException("[CombiBAPServiceHandler.updateFavoritesList] favoritesModel was null but shouldn't be");
        }
        CombiBAPPresetListEntry[] combiBAPPresetListEntryArray = new CombiBAPPresetListEntry[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < combiBAPPresetListEntryArray.length; ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
            combiBAPPresetListEntryArray[i2] = new CombiBAPPresetListEntry(StationMapper.getCombiID(abstractTVStationRow.getUniqueID()), i2 + 1, 9, abstractTVStationRow.service.name);
        }
        try {
            this.service.updateTVPresetList(combiBAPPresetListEntryArray);
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    private synchronized void updateStationList() {
        BaseListModelApp baseListModelApp = this.stationList.getTmpList();
        if (baseListModelApp == null) {
            throw new IllegalArgumentException("[CombiBAPServiceHandler.updateStationList] stationModel was null but shouldn't be");
        }
        CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray = new CombiBAPReceptionListEntry[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < combiBAPReceptionListEntryArray.length; ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
            combiBAPReceptionListEntryArray[i2] = new CombiBAPReceptionListEntry(StationMapper.getCombiID(abstractTVStationRow.getUniqueID()), 7, abstractTVStationRow.service.name, "");
        }
        try {
            this.service.updateTVStationList(combiBAPReceptionListEntryArray);
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private synchronized void updateSelectedStation(AbstractTVStationRow abstractTVStationRow) {
        Object object = this.stationMutex;
        synchronized (object) {
            this.currentStationInfo = new CombiBAPCurrentStationInfo(abstractTVStationRow.service.name, 71);
            int n = this.stationList.getIndexForUniqueID(abstractTVStationRow.getUniqueID());
            this.currentStationInfo.setListAbsolutePosition(n + 1);
            this.currentStationInfo.setListRef(StationMapper.getCombiID(abstractTVStationRow.getUniqueID()));
            int n2 = this.favoritesList.getIndexForUniqueID(abstractTVStationRow.getUniqueID());
            if (n2 > -1) {
                this.currentStationInfo.setPresetListAbsolutePosition(n2 + 1);
                this.currentStationInfo.setPresetListRef(n2 + 1);
            }
            if (!this.isAvUsed) {
                this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateCurrentStation] %1", (Object)this.currentStationInfo);
                try {
                    this.service.updateCurrentStation(this.currentStationInfo);
                }
                catch (Exception exception) {
                    this.env.lcCombi.log(10000, "%1", (Throwable)exception);
                }
            }
        }
        this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateSelectedStation] sending updateCurrentStation.");
        object = this.selectionCauseMutex;
        synchronized (object) {
            if (this.selectionCause == 1) {
                this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateSelectedStation] sending selectListEntryResult.");
                try {
                    this.service.selectListEntryResult(0);
                }
                catch (Exception exception) {
                    this.env.lcCombi.log(10000, "%1", (Throwable)exception);
                }
            } else if (this.selectionCause == 2) {
                this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateSelectedStation] sending skipResult.");
                try {
                    this.service.skipResult(true);
                }
                catch (Exception exception) {
                    this.env.lcCombi.log(10000, "%1", (Throwable)exception);
                }
            }
            this.selectionCause = 0;
        }
    }

    private synchronized void updateSourceList() {
        CombiBAPAudioSource[] combiBAPAudioSourceArray = this.isTunerAvailable ? (this.isAvAvailable && this.env.getConfiguration().hasAV() ? new CombiBAPAudioSource[]{new CombiBAPAudioSource(9, 0, 11, ""), new CombiBAPAudioSource(32, 0, 11, "")} : new CombiBAPAudioSource[]{new CombiBAPAudioSource(9, 0, 11, "")}) : new CombiBAPAudioSource[]{};
        this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateSourceList] %1", (Object)combiBAPAudioSourceArray);
        try {
            this.service.updateSourceListTv(combiBAPAudioSourceArray);
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private synchronized void updateActiveSource(boolean bl) {
        this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateActiveSource] is AV used: %1", bl);
        try {
            Object object;
            if (bl) {
                this.service.updateActiveSource(32, 0, 0, false, false, 0);
                object = this.stationMutex;
                synchronized (object) {
                    this.service.updateCurrentStation(new CombiBAPCurrentStationInfo());
                }
            }
            this.service.updateActiveSource(9, 0, 0, true, true, this.listState);
            object = this.stationMutex;
            synchronized (object) {
                if (this.currentStationInfo != null) {
                    this.service.updateCurrentStation(this.currentStationInfo);
                }
            }
            int n = this.getInfoState();
            this.env.lcCombi.log(10000000, "[CombiBAPServiceHandler.updateActiveSource] curInfoState: %1", (long)n);
            this.service.updateActiveInfoState(n);
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    private int getInfoState() {
        if (!this.isTunerAvailable || this.isTunerInEsm) {
            return 9;
        }
        return 0;
    }

    synchronized void sendSwitchSourceResult(int n) {
        try {
            this.service.switchSourceResult(n);
        }
        catch (Exception exception) {
            this.env.lcCombi.log(10000, "%1", (Throwable)exception);
        }
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3) {
            boolean bl4;
            boolean bl5 = bl4 = bl2 || bl;
            if (CombiBAPServiceHandler.this.isSeeking ^ bl4) {
                CombiBAPServiceHandler.this.isSeeking = bl4;
                CombiBAPServiceHandler.this.updateSeekState(bl4);
            }
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            CombiBAPServiceHandler.this.isAvAvailable = startUpConfig.avSrcAvail;
            CombiBAPServiceHandler.this.updateSourceList();
        }

        public void updateMessageService(int n) {
            CombiBAPServiceHandler.this.isTunerInEsm = n == 1;
            if (CombiBAPServiceHandler.this.tvHasMuAudioFocus) {
                CombiBAPServiceHandler.this.updateActiveSource(CombiBAPServiceHandler.this.isAvUsed);
            }
        }
    }

    private class CallListener
    extends DSICallListener {
        private CallListener() {
        }

        public void switchSource(int n, boolean bl) {
            boolean bl2;
            ((CombiBAPServiceHandler)CombiBAPServiceHandler.this).env.lcCombi.log(1000000, "[CombiBAPServiceHandler.CallListener.switchSource] sourceType=%1, isUserCall=%2", (Object)new Integer(n), (Object)(bl ? "true" : "false"));
            boolean bl3 = bl2 = n == 1;
            if (CombiBAPServiceHandler.this.isAvUsed != bl2) {
                CombiBAPServiceHandler.this.isAvUsed = bl2;
                if (CombiBAPServiceHandler.this.tvHasMuAudioFocus) {
                    CombiBAPServiceHandler.this.updateActiveSource(CombiBAPServiceHandler.this.isAvUsed);
                }
            }
        }
    }

    private class EventListener
    extends TVEventDefaultListener {
        private EventListener() {
        }

        public void onMuGotTvAudioFocus() {
            if (!CombiBAPServiceHandler.this.tvHasMuAudioFocus) {
                CombiBAPServiceHandler.this.updateActiveSource(CombiBAPServiceHandler.this.isAvUsed);
                CombiBAPServiceHandler.this.tvHasMuAudioFocus = true;
            }
        }

        public void onMuLostTvAudioFocus() {
            CombiBAPServiceHandler.this.tvHasMuAudioFocus = false;
        }

        public void onTunerAvailable() {
            CombiBAPServiceHandler.this.isTunerAvailable = true;
            CombiBAPServiceHandler.this.updateSourceList();
            if (CombiBAPServiceHandler.this.tvHasMuAudioFocus) {
                if (CombiBAPServiceHandler.this.currentStationInfo == null) {
                    CombiBAPServiceHandler.this.currentStationInfo = new CombiBAPCurrentStationInfo(((CombiBAPServiceHandler)CombiBAPServiceHandler.this).storage.getTunedService().name, 71);
                }
                CombiBAPServiceHandler.this.updateActiveSource(CombiBAPServiceHandler.this.isAvUsed);
            }
        }

        public void onTunerUnavailable() {
            CombiBAPServiceHandler.this.isTunerAvailable = false;
            if (CombiBAPServiceHandler.this.tvHasMuAudioFocus) {
                CombiBAPServiceHandler.this.updateActiveSource(CombiBAPServiceHandler.this.isAvUsed);
            }
            CombiBAPServiceHandler.this.updateSourceList();
        }

        public void onMuteChange(boolean bl) {
            try {
                CombiBAPServiceHandler.this.service.updateMuteState(bl);
            }
            catch (Exception exception) {
                ((CombiBAPServiceHandler)CombiBAPServiceHandler.this).env.lcCombi.log(10000, "%1", (Throwable)exception);
            }
        }

        public void onFocusedListChanged(int n) {
            try {
                CombiBAPServiceHandler.this.service.updatePreferredList(n == 0 ? 1 : 2);
            }
            catch (Exception exception) {
                ((CombiBAPServiceHandler)CombiBAPServiceHandler.this).env.lcCombi.log(10000, "%1", (Throwable)exception);
            }
        }
    }

    private class ListsListener
    extends DefaultTVListsListener {
        private ListsListener() {
        }

        public void updateFavoritesList() {
            CombiBAPServiceHandler.this.updateFavoritesList();
        }

        public void updateStationList() {
            CombiBAPServiceHandler.this.updateStationList();
            if (CombiBAPServiceHandler.this.listState == 0) {
                CombiBAPServiceHandler.this.listState = 3;
                if (!CombiBAPServiceHandler.this.isAvUsed && CombiBAPServiceHandler.this.tvHasMuAudioFocus) {
                    try {
                        CombiBAPServiceHandler.this.service.updateActiveSource(9, 0, 0, true, true, CombiBAPServiceHandler.this.listState);
                    }
                    catch (Exception exception) {
                        ((CombiBAPServiceHandler)CombiBAPServiceHandler.this).env.lcCombi.log(10000, "%1", (Throwable)exception);
                    }
                }
            }
        }

        public void updateSelectedStation(AbstractTVStationRow abstractTVStationRow) {
            CombiBAPServiceHandler.this.updateSelectedStation(abstractTVStationRow);
        }
    }
}

