/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sdars.CategoryFilter;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.sortandindex.artisttitle.AbstractArtistTitleComparatorAndIndexer;
import de.audi.tuner.app.sdars.sortandindex.artisttitle.SortAlgoArtistName;
import de.audi.tuner.app.sdars.sortandindex.artisttitle.SortAlgoTitleName;
import de.audi.tuner.app.sortandindex.AlphabeticalIndexRow;
import de.audi.tuner.ifc.AbstractListRowFactory;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;

class ArtistTitleList {
    final SDARSDsiUpInfo dsiUpListener = new DsiUpListener();
    final CategoryFilter.ICategoryFilter catFilterListener = new CatFilterListener();
    private final BaseListModelApp listModel;
    private final BaseListModelApp indexListModel;
    private final ChoiceModelApp sortChoice;
    private final ChoiceModelApp selectionChoice;
    private final ModelGroup modelGroup = new ModelGroup();
    private final AbstractArtistTitleComparatorAndIndexer[] allComps;
    private final LogChannel log;
    private StationInfoExt[] stationList = new StationInfoExt[0];
    private ArtistTitleRow[] allRows = new ArtistTitleRow[384];
    private StationInfoExt selectedStation = new StationInfoExt();
    private boolean[] catFilter = new boolean[256];
    private final Object mutex = new Object();
    private final AbstractListRowFactory rowFactory;

    ArtistTitleList(TunerBasics tunerBasics, LanguageManager languageManager, AbstractListRowFactory abstractListRowFactory) {
        this.listModel = tunerBasics.getModels().getBaseListModel(100597);
        this.indexListModel = tunerBasics.getModels().getBaseListModel(100920);
        this.log = tunerBasics.getLogger().sdarsRadioText;
        this.rowFactory = abstractListRowFactory;
        this.listModel.setListener(new ListListener());
        this.modelGroup.add(this.listModel);
        this.allComps = new AbstractArtistTitleComparatorAndIndexer[]{new SortAlgoArtistName(languageManager), new SortAlgoTitleName(languageManager)};
        this.sortChoice = tunerBasics.getModels().getChoiceModel(100602);
        this.sortChoice.setChoiceListener(new ChoiceListener());
        this.sortChoice.setValue(0);
        this.selectionChoice = tunerBasics.getModels().getChoiceModel(100794);
    }

    private void update(RadioText radioText) {
        StationInfoExt stationInfoExt = this.getStation(radioText.sID);
        boolean bl = false;
        this.allRows[radioText.sID] = null;
        ArtistTitleRow artistTitleRow = null;
        if (stationInfoExt != null && !this.isEmpty(radioText) && stationInfoExt.categoryNumber >= 0 && stationInfoExt.categoryNumber < this.catFilter.length) {
            bl = this.catFilter[stationInfoExt.categoryNumber] && stationInfoExt.getSubscription() == 2;
            this.allRows[radioText.sID] = artistTitleRow = this.rowFactory.getSdarsArtistTitleRow(radioText, stationInfoExt, this.sortChoice.getValue());
        }
        if (bl) {
            ArtistTitleRow artistTitleRow2 = (ArtistTitleRow)this.listModel.getRowByUniqueID(radioText.sID);
            if (artistTitleRow2 != null) {
                artistTitleRow.setFavorite(artistTitleRow2.getFavorite());
            }
            this.listModel.remove(radioText.sID);
            if (artistTitleRow != null) {
                this.analyzeRow(artistTitleRow);
            }
        }
    }

    private void analyzeRow(ArtistTitleRow artistTitleRow) {
        Object object;
        AbstractArtistTitleComparatorAndIndexer abstractArtistTitleComparatorAndIndexer = this.allComps[this.sortChoice.getValue()];
        long l = 0L;
        List list = this.listModel.asList();
        int n = -1;
        Object object2 = list.listIterator();
        while (object2.hasNext()) {
            object = (ArtistTitleRow)object2.next();
            if (abstractArtistTitleComparatorAndIndexer.compare(artistTitleRow, object) >= 0) continue;
            l = ((EvoListRow)object).getUniqueID();
            n = object2.previousIndex();
            break;
        }
        if (l == 0L) {
            this.listModel.append(artistTitleRow);
            list.add(artistTitleRow);
        } else {
            this.listModel.insertBefore(l, artistTitleRow);
            list.add(n, artistTitleRow);
        }
        object2 = this.indexListModel.getEmptyCopy();
        object = abstractArtistTitleComparatorAndIndexer.provideAlphabeticalIndexRowsForAlreadySortedList(list);
        object2.append((AlphabeticalIndexRow[])object.toArray(new AlphabeticalIndexRow[object.size()]));
        this.indexListModel.update((BaseListModelApp)object2);
    }

    private void update(int n, boolean bl) {
        ArtistTitleRow artistTitleRow = this.allRows[n];
        if (artistTitleRow != null) {
            ArtistTitleRow artistTitleRow2 = (ArtistTitleRow)artistTitleRow.copy();
            artistTitleRow2.setFavorite(bl);
            int n2 = this.listModel.getIndexForUniqueID(artistTitleRow.getUniqueID());
            if (n2 != -1) {
                this.listModel.setRow(n2, artistTitleRow2);
                this.modelGroup.flush();
            }
        }
    }

    private void doHighlighting() {
        int n = this.listModel.getIndexForUniqueID(this.selectedStation.sID);
        this.listModel.setSelectedIndex(n);
        this.selectionChoice.setValue(n == -1 ? 0 : 1);
    }

    private boolean isEmpty(RadioText radioText) {
        return Utilities.isEmpty(radioText.longArtistName) && Utilities.isEmpty(radioText.longProgramTitle);
    }

    private StationInfoExt getStation(short s) {
        StationInfoExt[] stationInfoExtArray = this.stationList;
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            StationInfoExt stationInfoExt = stationInfoExtArray[i2];
            if (stationInfoExt.sID != s) continue;
            return stationInfoExt;
        }
        return null;
    }

    private void buildNewList() {
        Object object;
        int n = this.sortChoice.getValue();
        ArrayList arrayList = new ArrayList(400);
        for (int i2 = 0; i2 < this.allRows.length; ++i2) {
            object = this.allRows[i2];
            if (object == null || !this.catFilter[((ArtistTitleRow)object).getStation().categoryNumber]) continue;
            ((ArtistTitleRow)object).setMode(n);
            arrayList.add(object);
        }
        AbstractArtistTitleComparatorAndIndexer abstractArtistTitleComparatorAndIndexer = this.allComps[n];
        object = abstractArtistTitleComparatorAndIndexer.sortAndProvideAlphabeticalIndexRowsFor(arrayList);
        BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
        baseListModelApp.append((ArtistTitleRow[])arrayList.toArray(new ArtistTitleRow[arrayList.size()]));
        this.listModel.update(baseListModelApp);
        this.doHighlighting();
        this.modelGroup.flush();
        BaseListModelApp baseListModelApp2 = this.indexListModel.getEmptyCopy();
        baseListModelApp2.append((AlphabeticalIndexRow[])object.toArray(new AlphabeticalIndexRow[object.size()]));
        this.indexListModel.update(baseListModelApp2);
    }

    static /* synthetic */ StationInfoExt[] access$702(ArtistTitleList artistTitleList, StationInfoExt[] stationInfoExtArray) {
        artistTitleList.stationList = stationInfoExtArray;
        return stationInfoExtArray;
    }

    static /* synthetic */ boolean[] access$1502(ArtistTitleList artistTitleList, boolean[] blArray) {
        artistTitleList.catFilter = blArray;
        return blArray;
    }

    private static class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ArtistTitleRow artistTitleRow = (ArtistTitleRow)evoListRow;
            StationInfoExt stationInfoExt = artistTitleRow.getStation();
            TunerProxyManager.getInstance().getSDARSTuner().selectStation(stationInfoExt, 0);
        }
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            ArtistTitleList.this.selectedStation = stationInfoExt;
            ArtistTitleList.this.doHighlighting();
            ArtistTitleList.this.modelGroup.flush();
        }

        public void updateStationList(StationInfoExt[] stationInfoExtArray) {
            ArtistTitleList.access$702(ArtistTitleList.this, stationInfoExtArray);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void informationRadioText2(RadioText[] radioTextArray) {
            Object object = ArtistTitleList.this.mutex;
            synchronized (object) {
                for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
                    if (radioTextArray[i2].sID >= 0 && radioTextArray[i2].sID < 384) {
                        ArtistTitleList.this.update(radioTextArray[i2]);
                        continue;
                    }
                    ArtistTitleList.this.log.log(10000, "[ATL.informationRadioText2] received invalid sId %1", (long)radioTextArray[i2].sID);
                }
            }
            ArtistTitleList.this.doHighlighting();
            ArtistTitleList.this.modelGroup.flush();
        }

        public void updateSeekAlert(SeekAlert seekAlert) {
            ArtistTitleList.this.update(seekAlert.getSID(), seekAlert.getAlertType() == 1);
        }
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            if (n2 >= 0 && n2 < ArtistTitleList.this.allComps.length) {
                ArtistTitleList.this.sortChoice.setValue(n2);
                ArtistTitleList.this.buildNewList();
            }
        }
    }

    private class CatFilterListener
    implements CategoryFilter.ICategoryFilter {
        private CatFilterListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void categoryFilterChanged(boolean[] blArray) {
            Object object = ArtistTitleList.this.mutex;
            synchronized (object) {
                ArtistTitleList.access$1502(ArtistTitleList.this, blArray);
                ArtistTitleList.this.buildNewList();
            }
        }
    }
}

