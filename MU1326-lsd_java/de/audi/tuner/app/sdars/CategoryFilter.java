/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.CategoryFilter$ChoiceListener;
import de.audi.tuner.app.sdars.CategoryFilter$DsiUpListener;
import de.audi.tuner.app.sdars.CategoryFilter$ICategoryFilter;
import de.audi.tuner.app.sdars.CategoryFilter$ListListener;
import de.audi.tuner.app.sdars.CategoryFilterRow;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SortAlgoCategory;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.storage.TunerStorage;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryFilter {
    final SDARSDsiUpInfo dsiUpInfo = new CategoryFilter$DsiUpListener(this, null);
    private final TunerModels models;
    private final BaseListModelApp filterList;
    private final BaseListModelApp jumpModel;
    private final ChoiceModelApp allChoice;
    private final LanguageManager langMngr;
    private final SDARSStationListHandler stationListHandler;
    private final TunerStorage storage;
    private StationInfoExt[] stationList = new StationInfoExt[0];
    private CategoryInfoExt[] categoryList = new CategoryInfoExt[0];
    private SimpleIntIntMap filterStates;
    private CategoryFilter$ICategoryFilter[] catListeners = new CategoryFilter$ICategoryFilter[0];

    CategoryFilter(TunerBasics tunerBasics, LanguageManager languageManager, SDARSStationListHandler sDARSStationListHandler, TunerStorage tunerStorage) {
        this.models = tunerBasics.getModels();
        this.langMngr = languageManager;
        this.storage = tunerStorage;
        this.stationListHandler = sDARSStationListHandler;
        this.filterList = this.models.getBaseListModel(2122842368);
        this.filterList.setListener(new CategoryFilter$ListListener(this, null));
        this.jumpModel = this.models.getBaseListModel(2139619584);
        this.allChoice = this.models.getChoiceModel(914817280);
        CategoryFilter$ChoiceListener categoryFilter$ChoiceListener = new CategoryFilter$ChoiceListener(this, null);
        this.allChoice.setChoiceListener(categoryFilter$ChoiceListener);
        this.models.getButtonModel(-276299520).setButtonListener(categoryFilter$ChoiceListener);
        this.models.getButtonModel(-242745088).setButtonListener(categoryFilter$ChoiceListener);
        this.models.getButtonModel(-259522304).setButtonListener(categoryFilter$ChoiceListener);
        this.filterStates = tunerStorage.loadSDARSFilterStates();
    }

    private void doListUpdate() {
        Object object;
        if (this.categoryList.length == 0 || this.stationList.length == 0) {
            return;
        }
        SimpleIntIntMap simpleIntIntMap = new SimpleIntIntMap(this.categoryList.length);
        for (int i2 = 0; i2 < this.stationList.length; ++i2) {
            object = this.stationList[i2];
            boolean bl = CategoryFilter.booleanConstToBoolean(simpleIntIntMap.get(((StationInfoExt)object).categoryNumber));
            if (bl) continue;
            if (((StationInfoExt)object).subscription == 2) {
                bl = true;
            }
            simpleIntIntMap.add(((StationInfoExt)object).categoryNumber, CategoryFilter.booleanToBooleanConst(bl));
        }
        ArrayList arrayList = new ArrayList(simpleIntIntMap.size());
        object = simpleIntIntMap.getKeys();
        int[] nArray = simpleIntIntMap.getValues();
        for (int i3 = 0; i3 < ((Object)object).length; ++i3) {
            CategoryFilterRow categoryFilterRow = this.getCatRow((int)object[i3]);
            if (categoryFilterRow == null) continue;
            boolean bl = CategoryFilter.booleanConstToBoolean(nArray[i3]);
            categoryFilterRow.setContainsSubscribedStations(bl);
            arrayList.add(categoryFilterRow);
        }
        Collections.sort(arrayList, new SortAlgoCategory(this.langMngr));
        BaseListModelApp baseListModelApp = this.filterList.getEmptyCopy();
        baseListModelApp.append((EvoListRow[])arrayList.toArray(new EvoListRow[arrayList.size()]));
        this.filterList.update(baseListModelApp);
        this.checkAll();
        this.createJumpList();
    }

    private void createJumpList() {
        List list = this.filterList.asList();
        Object object = list.iterator();
        while (object.hasNext()) {
            CategoryFilterRow categoryFilterRow = (CategoryFilterRow)object.next();
            boolean bl = categoryFilterRow.isChecked() && categoryFilterRow.containsSubscribedStations();
            if (bl) continue;
            object.remove();
        }
        object = this.jumpModel.getEmptyCopy();
        object.append((CategoryFilterRow[])list.toArray(new CategoryFilterRow[list.size()]));
        this.jumpModel.update((BaseListModelApp)object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkAll() {
        int[] nArray;
        SimpleIntIntMap simpleIntIntMap = this.filterStates;
        synchronized (simpleIntIntMap) {
            nArray = this.filterStates.getValues();
        }
        if (nArray.length != 0) {
            int n = nArray[0];
            for (int i2 = 1; i2 < nArray.length; ++i2) {
                if (n == nArray[i2]) continue;
                this.allChoice.setValue(0);
                return;
            }
            this.allChoice.setValue(n);
        } else {
            this.allChoice.setValue(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private CategoryFilterRow getCatRow(int n) {
        for (int i2 = 0; i2 < this.categoryList.length; ++i2) {
            if (this.categoryList[i2].categoryNumber != n) continue;
            SimpleIntIntMap simpleIntIntMap = this.filterStates;
            synchronized (simpleIntIntMap) {
                int n2 = this.filterStates.get(n);
                if (n2 == -1) {
                    n2 = 1;
                    this.filterStates.add(n, 1);
                }
                return new CategoryFilterRow(this.categoryList[i2], n2);
            }
        }
        return null;
    }

    private void activateDeactivateAll(boolean bl) {
        BaseListModelApp baseListModelApp = this.filterList.getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            CategoryFilterRow categoryFilterRow = (CategoryFilterRow)baseListModelApp.getRow(i2);
            categoryFilterRow.setChecked(bl);
            baseListModelApp.setRow(i2, categoryFilterRow);
        }
        this.filterList.update(baseListModelApp);
        this.updateFilterState();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateFilterState() {
        boolean bl = false;
        SimpleIntIntMap simpleIntIntMap = this.filterStates;
        synchronized (simpleIntIntMap) {
            this.filterStates.clear();
            for (int i2 = 0; i2 < this.filterList.getLength(); ++i2) {
                CategoryFilterRow categoryFilterRow = (CategoryFilterRow)this.filterList.getRow(i2);
                boolean bl2 = categoryFilterRow.isChecked();
                this.filterStates.add(categoryFilterRow.getCategory(), bl2 ? 1 : 0);
                bl |= bl2;
            }
            this.storage.storeSDARSFilterStates(this.filterStates);
        }
        this.checkAll();
        this.stationListHandler.catFilterChanged();
        this.informListener();
        this.createJumpList();
        this.models.getButtonModel(-259522304).setStatus(bl ? 1 : 3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SimpleIntIntMap getFilterStates() {
        SimpleIntIntMap simpleIntIntMap = this.filterStates;
        synchronized (simpleIntIntMap) {
            return this.filterStates;
        }
    }

    public boolean isShowAllCategoriesChecked() {
        return this.allChoice.getValue() == 1;
    }

    private static boolean booleanConstToBoolean(int n) {
        return n == 1;
    }

    private static int booleanToBooleanConst(boolean bl) {
        return bl ? 1 : 0;
    }

    public void resetToDefaultSettings() {
        this.activateDeactivateAll(true);
    }

    public void addListener(CategoryFilter$ICategoryFilter categoryFilter$ICategoryFilter) {
        CategoryFilter$ICategoryFilter[] categoryFilter$ICategoryFilterArray = new CategoryFilter$ICategoryFilter[this.catListeners.length + 1];
        System.arraycopy((Object)this.catListeners, 0, (Object)categoryFilter$ICategoryFilterArray, 0, this.catListeners.length);
        categoryFilter$ICategoryFilterArray[this.catListeners.length] = categoryFilter$ICategoryFilter;
        this.catListeners = categoryFilter$ICategoryFilterArray;
        this.informListener(categoryFilter$ICategoryFilter, this.extractFilterInfo());
    }

    private void informListener() {
        boolean[] blArray = this.extractFilterInfo();
        CategoryFilter$ICategoryFilter[] categoryFilter$ICategoryFilterArray = this.catListeners;
        for (int i2 = 0; i2 < categoryFilter$ICategoryFilterArray.length; ++i2) {
            this.informListener(categoryFilter$ICategoryFilterArray[i2], blArray);
        }
    }

    private void informListener(CategoryFilter$ICategoryFilter categoryFilter$ICategoryFilter, boolean[] blArray) {
        categoryFilter$ICategoryFilter.categoryFilterChanged(blArray);
    }

    private boolean[] extractFilterInfo() {
        boolean[] blArray = new boolean[256];
        int[] nArray = this.filterStates.getKeys();
        int[] nArray2 = this.filterStates.getValues();
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            if (nArray2[i2] != 1 || nArray[i2] >= blArray.length) continue;
            blArray[nArray[i2]] = true;
        }
        return blArray;
    }

    static /* synthetic */ StationInfoExt[] access$302(CategoryFilter categoryFilter, StationInfoExt[] stationInfoExtArray) {
        categoryFilter.stationList = stationInfoExtArray;
        return stationInfoExtArray;
    }

    static /* synthetic */ void access$400(CategoryFilter categoryFilter) {
        categoryFilter.doListUpdate();
    }

    static /* synthetic */ CategoryInfoExt[] access$502(CategoryFilter categoryFilter, CategoryInfoExt[] categoryInfoExtArray) {
        categoryFilter.categoryList = categoryInfoExtArray;
        return categoryInfoExtArray;
    }

    static /* synthetic */ BaseListModelApp access$600(CategoryFilter categoryFilter) {
        return categoryFilter.filterList;
    }

    static /* synthetic */ void access$700(CategoryFilter categoryFilter) {
        categoryFilter.updateFilterState();
    }

    static /* synthetic */ ChoiceModelApp access$800(CategoryFilter categoryFilter) {
        return categoryFilter.allChoice;
    }

    static /* synthetic */ void access$900(CategoryFilter categoryFilter, boolean bl) {
        categoryFilter.activateDeactivateAll(bl);
    }

    static /* synthetic */ TunerModels access$1000(CategoryFilter categoryFilter) {
        return categoryFilter.models;
    }
}

