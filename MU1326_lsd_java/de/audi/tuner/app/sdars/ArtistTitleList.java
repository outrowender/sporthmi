/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.ArtistTitleList$CatFilterListener;
import de.audi.tuner.app.sdars.ArtistTitleList$ChoiceListener;
import de.audi.tuner.app.sdars.ArtistTitleList$DsiUpListener;
import de.audi.tuner.app.sdars.ArtistTitleList$ListListener;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sdars.CategoryFilter$ICategoryFilter;
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

class ArtistTitleList {
    final SDARSDsiUpInfo dsiUpListener = new ArtistTitleList$DsiUpListener(this, null);
    final CategoryFilter$ICategoryFilter catFilterListener = new ArtistTitleList$CatFilterListener(this, null);
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
        this.listModel = tunerBasics.getModels().getBaseListModel(-175636224);
        this.indexListModel = tunerBasics.getModels().getBaseListModel(948568320);
        this.log = tunerBasics.getLogger().sdarsRadioText;
        this.rowFactory = abstractListRowFactory;
        this.listModel.setListener(new ArtistTitleList$ListListener(null));
        this.modelGroup.add(this.listModel);
        this.allComps = new AbstractArtistTitleComparatorAndIndexer[]{new SortAlgoArtistName(languageManager), new SortAlgoTitleName(languageManager)};
        this.sortChoice = tunerBasics.getModels().getChoiceModel(-91750144);
        this.sortChoice.setChoiceListener(new ArtistTitleList$ChoiceListener(this, null));
        this.sortChoice.setValue(0);
        this.selectionChoice = tunerBasics.getModels().getChoiceModel(-1165426432);
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

    static /* synthetic */ StationInfoExt access$402(ArtistTitleList artistTitleList, StationInfoExt stationInfoExt) {
        artistTitleList.selectedStation = stationInfoExt;
        return artistTitleList.selectedStation;
    }

    static /* synthetic */ void access$500(ArtistTitleList artistTitleList) {
        artistTitleList.doHighlighting();
    }

    static /* synthetic */ ModelGroup access$600(ArtistTitleList artistTitleList) {
        return artistTitleList.modelGroup;
    }

    static /* synthetic */ StationInfoExt[] access$702(ArtistTitleList artistTitleList, StationInfoExt[] stationInfoExtArray) {
        artistTitleList.stationList = stationInfoExtArray;
        return stationInfoExtArray;
    }

    static /* synthetic */ Object access$800(ArtistTitleList artistTitleList) {
        return artistTitleList.mutex;
    }

    static /* synthetic */ void access$900(ArtistTitleList artistTitleList, RadioText radioText) {
        artistTitleList.update(radioText);
    }

    static /* synthetic */ LogChannel access$1000(ArtistTitleList artistTitleList) {
        return artistTitleList.log;
    }

    static /* synthetic */ void access$1100(ArtistTitleList artistTitleList, int n, boolean bl) {
        artistTitleList.update(n, bl);
    }

    static /* synthetic */ AbstractArtistTitleComparatorAndIndexer[] access$1200(ArtistTitleList artistTitleList) {
        return artistTitleList.allComps;
    }

    static /* synthetic */ ChoiceModelApp access$1300(ArtistTitleList artistTitleList) {
        return artistTitleList.sortChoice;
    }

    static /* synthetic */ void access$1400(ArtistTitleList artistTitleList) {
        artistTitleList.buildNewList();
    }

    static /* synthetic */ boolean[] access$1502(ArtistTitleList artistTitleList, boolean[] blArray) {
        artistTitleList.catFilter = blArray;
        return blArray;
    }
}

