/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.dab.stationlist.IFolderListModel;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DabFolderListModel
implements IFolderListModel {
    private static final int FOLDERSTATE_CLOSED = 0;
    private static final int FOLDERSTATE_OPEN = 1;
    private static final int FOLDERSTATE_NEW = Utilities.isPGen1OrBentley() ? 0 : 1;
    private final Logger logger;
    private final BaseListModelApp viewModel;
    private final TunerModels models;
    private final DabFolderListHandler folderListHandler;
    private BaseListModelListener listListener;
    private long selectedRowId;
    private List listArray;
    private SimpleIntIntMap idStateMapping = new SimpleIntIntMap();
    private int imgType;

    DabFolderListModel(TunerBasics tunerBasics, int n, int n2, DabFolderListHandler dabFolderListHandler) {
        this.models = tunerBasics.getModels();
        this.viewModel = this.models.getBaseListModel(n);
        this.logger = tunerBasics.getLogger();
        this.folderListHandler = dabFolderListHandler;
        this.viewModel.setListener(new ListListener());
        this.listArray = new ArrayList(250);
        this.imgType = n2;
    }

    public void setListener(BaseListModelListener baseListModelListener) {
        this.listListener = baseListModelListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void update(List list, DabStation dabStation) {
        List list2 = this.listArray;
        synchronized (list2) {
            this.listArray = list;
            long l = dabStation.getUniqueId();
            this.update(l);
            this.selectedRowId = l;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSelectedIndex(int n, DabStation dabStation, int n2) {
        BaseListModelApp baseListModelApp;
        this.logger.dabList.log(10000000, "[DFLM.setSelectedIndex]index %3->%2 : %1", (Object)dabStation, (long)n, (long)n2);
        List list = this.listArray;
        synchronized (list) {
            int n3;
            EvoListRow evoListRow = null;
            EvoListRow evoListRow2 = null;
            DabListRow dabListRow = this.getParentRow(n);
            if (dabListRow == null) {
                this.logger.dabList.log(10000, "[DFLM.setSelectedIndex] new ensemble not found");
                return;
            }
            DabListRow dabListRow2 = (DabListRow)this.listArray.get(n);
            this.selectedRowId = dabListRow2.getUniqueID();
            baseListModelApp = this.viewModel.getCopy();
            if (n2 != n && n2 != -1) {
                evoListRow = this.getParentRow(n2);
                evoListRow2 = this.getRow(n2);
            }
            if (evoListRow != null && evoListRow.getUniqueID() != dabListRow.getUniqueID()) {
                ((DabListRow)evoListRow).resetProgramData();
                n3 = this.viewModel.getIndexForUniqueID(evoListRow.getUniqueID());
                if (n3 != -1 && n3 < baseListModelApp.getLength()) {
                    baseListModelApp.setRow(n3, evoListRow);
                } else {
                    this.logger.dabList.log(10000, "[DFLM.setSelectedIndex]#1 wrong index %1", (long)n3);
                }
            }
            if (evoListRow2 != null && evoListRow2.getUniqueID() != dabListRow2.getUniqueID()) {
                ((DabListRow)evoListRow2).resetProgramData();
                ((DabListRow)evoListRow2).setStationActive(false);
                if (evoListRow != null && this.isOpen((DabListRow)evoListRow)) {
                    n3 = this.viewModel.getIndexForUniqueID(evoListRow2.getUniqueID());
                    if (n3 != -1 && n3 < baseListModelApp.getLength()) {
                        baseListModelApp.setRow(n3, evoListRow2);
                    } else {
                        this.logger.dabList.log(10000, "[DFLM.setSelectedIndex]#2 wrong index %1", (long)n3);
                    }
                }
            }
            dabListRow2.setProgramData(dabStation, this.imgType);
            if (!this.isOpen(dabListRow) && !Utilities.isPGen1OrBentley()) {
                dabListRow.setProgramData(dabStation, this.imgType);
            }
            dabListRow2.setStationActive(true);
            n3 = this.viewModel.getIndexForUniqueID(dabListRow.getUniqueID());
            if (n3 != -1 && n3 < baseListModelApp.getLength()) {
                baseListModelApp.setRow(n3, dabListRow);
            } else {
                this.logger.dabList.log(10000, "[DFLM.setSelectedIndex]#3 wrong index %1", (long)n3);
            }
            if (this.isOpen(dabListRow)) {
                int n4 = this.viewModel.getIndexForUniqueID(dabListRow2.getUniqueID());
                if (n4 != -1 && n4 < baseListModelApp.getLength()) {
                    baseListModelApp.setRow(n4, dabListRow2);
                } else {
                    this.logger.dabList.log(10000, "[DFLM.setSelectedIndex]#4 wrong index %1", (long)n4);
                }
                baseListModelApp.setSelectedIndex(n4);
            } else {
                baseListModelApp.setSelectedIndex(n3);
            }
        }
        this.viewModel.update(baseListModelApp);
    }

    public int getSelected() {
        if (this.selectedRowId == -1L) {
            return -1;
        }
        return this.getIndexForUniqueID(this.selectedRowId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DabListRow getRow(int n) {
        List list = this.listArray;
        synchronized (list) {
            return (DabListRow)this.listArray.get(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRow(int n, DabListRow dabListRow) {
        List list = this.listArray;
        synchronized (list) {
            this.listArray.set(n, dabListRow);
            n = this.viewModel.getIndexForUniqueID(dabListRow.getUniqueID());
            if (n != -1) {
                this.viewModel.setRow(n, dabListRow);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getIndexForUniqueID(long l) {
        List list = this.listArray;
        synchronized (list) {
            Iterator iterator = this.listArray.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                if (((DabListRow)iterator.next()).getUniqueID() == l) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLength() {
        List list = this.listArray;
        synchronized (list) {
            return this.listArray.size();
        }
    }

    public void setFolderStates(SimpleIntIntMap simpleIntIntMap) {
        this.idStateMapping = simpleIntIntMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SimpleIntIntMap getFolderStates() {
        SimpleIntIntMap simpleIntIntMap = new SimpleIntIntMap();
        List list = this.listArray;
        synchronized (list) {
            Iterator iterator = this.listArray.iterator();
            while (iterator.hasNext()) {
                DabListRow dabListRow = (DabListRow)iterator.next();
                if (!dabListRow.isEnsemble()) continue;
                int n = dabListRow.getEnsemble().getEnsID();
                simpleIntIntMap.add(n, this.idStateMapping.get(n));
            }
        }
        return simpleIntIntMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setReceptionStatus(int n, int n2) {
        long l = 0L;
        if (this.selectedRowId != -1L) {
            l = this.selectedRowId;
        }
        List list = this.listArray;
        synchronized (list) {
            for (int i2 = 0; i2 < this.listArray.size(); ++i2) {
                DabListRow dabListRow = (DabListRow)this.listArray.get(i2);
                dabListRow.setReceptionStatus(n, n2);
                this.listArray.set(i2, dabListRow);
            }
        }
        this.update(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void update(long l) {
        BaseListModelApp baseListModelApp;
        List list = this.listArray;
        synchronized (list) {
            baseListModelApp = this.viewModel.getEmptyCopy();
            DabStation dabStation = this.folderListHandler.getCurrentStation();
            DabListRow[] dabListRowArray = this.getEnsembles();
            for (int i2 = 0; i2 < dabListRowArray.length; ++i2) {
                DabListRow dabListRow = dabListRowArray[i2];
                if (this.isOpen(dabListRow)) {
                    baseListModelApp.append(dabListRow.open(dabStation));
                    baseListModelApp.append(this.getChildrenOf(dabListRow));
                    continue;
                }
                baseListModelApp.append(dabListRow.close(dabStation));
            }
            if (!baseListModelApp.setSelectedUniqueID(l)) {
                baseListModelApp.setSelectedUniqueID(RadioObjectIds.getEnsembleUniqueId(l));
            }
        }
        this.viewModel.update(baseListModelApp);
    }

    private boolean isOpen(DabListRow dabListRow) {
        int n = this.idStateMapping.get(dabListRow.getDabStation().ensemble.ensID);
        if (n == -1) {
            this.idStateMapping.add(dabListRow.getDabStation().ensemble.ensID, FOLDERSTATE_NEW);
            n = FOLDERSTATE_NEW;
        }
        return n == 1;
    }

    private void close(DabListRow dabListRow) {
        this.idStateMapping.add(dabListRow.getDabStation().ensemble.ensID, 0);
    }

    private void open(DabListRow dabListRow) {
        this.idStateMapping.add(dabListRow.getDabStation().ensemble.ensID, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private DabListRow[] getEnsembles() {
        ArrayList arrayList = new ArrayList(10);
        List list = this.listArray;
        synchronized (list) {
            Iterator iterator = this.listArray.iterator();
            while (iterator.hasNext()) {
                DabListRow dabListRow = (DabListRow)iterator.next();
                if (!dabListRow.isEnsemble()) continue;
                arrayList.add(dabListRow);
            }
        }
        return (DabListRow[])arrayList.toArray(new DabListRow[arrayList.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getNumOfChildren(DabListRow dabListRow) {
        List list = this.listArray;
        synchronized (list) {
            int n = this.getIndexForUniqueID(dabListRow.getUniqueID()) + 1;
            int n2 = 0;
            for (int i2 = n; i2 < this.listArray.size() && !((DabListRow)this.listArray.get(i2)).isEnsemble(); ++i2) {
                ++n2;
            }
            return n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private EvoListRow[] getChildrenOf(DabListRow dabListRow) {
        List list = this.listArray;
        synchronized (list) {
            int n = this.getIndexForUniqueID(dabListRow.getUniqueID()) + 1;
            int n2 = 0;
            for (int i2 = n; i2 < this.listArray.size() && !((DabListRow)this.listArray.get(i2)).isEnsemble(); ++i2) {
                ++n2;
            }
            EvoListRow[] evoListRowArray = new EvoListRow[n2];
            System.arraycopy((Object)this.listArray.toArray(), n, (Object)evoListRowArray, 0, n2);
            return evoListRowArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private DabListRow getParentRow(int n) {
        List list = this.listArray;
        synchronized (list) {
            for (int i2 = n - 1; i2 > -1; --i2) {
                DabListRow dabListRow = (DabListRow)this.listArray.get(i2);
                if (!dabListRow.isEnsemble()) continue;
                return dabListRow;
            }
        }
        return null;
    }

    public void setPrefImgType(int n) {
        this.imgType = n;
    }

    private class ListListener
    implements BaseListModelListener {
        private volatile boolean focusSet = false;

        private ListListener() {
        }

        public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (((DabListRow)evoListRow).isEnsemble()) {
                BaseListModelApp baseListModelApp;
                List list = DabFolderListModel.this.listArray;
                synchronized (list) {
                    baseListModelApp = DabFolderListModel.this.viewModel.getCopy();
                    SelectedItem selectedItem = baseListModelApp.getSelected();
                    long l = selectedItem != null ? selectedItem.getUniqueID() : 0L;
                    DabListRow dabListRow = (DabListRow)DabFolderListModel.this.listArray.get(DabFolderListModel.this.getIndexForUniqueID(evoListRow.getUniqueID()));
                    DabStation dabStation = DabFolderListModel.this.folderListHandler.getCurrentStation();
                    if (dabListRow.isActive(dabStation)) {
                        baseListModelApp.setSelectedIndex(-1);
                    }
                    if (DabFolderListModel.this.isOpen(dabListRow)) {
                        int n5 = DabFolderListModel.this.getNumOfChildren(dabListRow);
                        baseListModelApp.removeAndClose(evoListRow.getUniqueID(), n5);
                        dabListRow.close(dabStation);
                        if (dabListRow.isActive(dabStation)) {
                            l = dabListRow.getUniqueID();
                        }
                        DabFolderListModel.this.close(dabListRow);
                    } else {
                        EvoListRow[] evoListRowArray = DabFolderListModel.this.getChildrenOf(dabListRow);
                        baseListModelApp.insertAfterAndOpen(evoListRow.getUniqueID(), evoListRowArray);
                        if (DabFolderListModel.this.selectedRowId != -1L && dabListRow.isActive(dabStation)) {
                            l = DabFolderListModel.this.selectedRowId;
                        }
                        dabListRow.open(dabStation);
                        DabFolderListModel.this.open(dabListRow);
                    }
                    baseListModelApp.setRow(n2, dabListRow);
                    baseListModelApp.setSelectedUniqueID(l);
                }
                DabFolderListModel.this.viewModel.update(baseListModelApp);
                DabFolderListModel.this.models.getMenuModel(100370).setFocusedItem(n, FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
                this.focusSet = true;
            } else {
                int n6 = DabFolderListModel.this.getIndexForUniqueID(evoListRow.getUniqueID());
                DabFolderListModel.this.listListener.itemSelected(evoListRow, n, n6, n3, n4);
            }
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            int n5 = DabFolderListModel.this.getIndexForUniqueID(evoListRow.getUniqueID());
            DabFolderListModel.this.listListener.itemLongSelected(evoListRow, n, n5, n3, n4);
        }

        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (this.focusSet) {
                DabFolderListModel.this.models.getMenuModel(100370).resetFocusedItem();
                this.focusSet = false;
            }
        }
    }
}

