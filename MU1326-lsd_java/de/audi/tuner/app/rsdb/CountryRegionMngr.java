/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rsdb.CountryRegionMngr$CountryRow;
import de.audi.tuner.app.rsdb.CountryRegionMngr$CountryRowSorter;
import de.audi.tuner.app.rsdb.CountryRegionMngr$ListListener;
import de.audi.tuner.app.rsdb.LogoDatabase;
import de.audi.tuner.app.storage.TunerStorage;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;

public class CountryRegionMngr {
    private static final CountryRegionData EMPTY_CR_DATA = new CountryRegionData();
    public static final int COUNTRY_AUTO;
    int selectedRegion = 0;
    CountryRegionData preparedData = new CountryRegionData();
    private CountryRegionData[] countryRegionData = new CountryRegionData[0];
    private final LogChannel log;
    private CountryRegionTranslationData[] countryTranslation = new CountryRegionTranslationData[0];
    private final BaseListModelApp listModel;
    private final TunerStorage storage;
    private final LogoDatabase logoDb;
    private int lastCountryForNameSelection = -1;
    private boolean longPrefered = false;
    private final LanguageManager languageMngr;
    private String systemLanguage = "";

    public CountryRegionMngr(LogoDatabase logoDatabase, TunerBasics tunerBasics, TunerStorage tunerStorage, LanguageManager languageManager) {
        this.log = tunerBasics.getLogger().rsdb;
        this.listModel = tunerBasics.getModels().getBaseListModel(143261952);
        this.listModel.setStatus(0);
        this.listModel.setListener(new CountryRegionMngr$ListListener(this, null));
        this.storage = tunerStorage;
        this.logoDb = logoDatabase;
        this.languageMngr = languageManager;
        this.selectedRegion = tunerStorage.loadDatabaseCountry();
    }

    public void setCountyRegionData(CountryRegionData[] countryRegionDataArray) {
        this.countryRegionData = countryRegionDataArray;
        this.listChanged();
    }

    public void setCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray) {
        this.countryTranslation = countryRegionTranslationDataArray;
        this.listChanged();
    }

    private void listChanged() {
        Object object;
        int n;
        int n2;
        if (this.countryRegionData.length == 0) {
            return;
        }
        int n3 = Utilities.getDatabaseRegion();
        CountryRegionData countryRegionData = null;
        int n4 = 0;
        for (n2 = 0; n2 < this.countryRegionData.length; ++n2) {
            if (this.countryRegionData[n2].countryId != n3) continue;
            countryRegionData = this.countryRegionData[n2];
            ++n4;
        }
        if (n4 != 1 || countryRegionData == null) {
            this.log.log(10000, "[CountryRegionData.listChanged] found %1 region elements!");
            this.logoDb.setInitStatus(false);
            return;
        }
        block1: for (n2 = 0; n2 < 3; ++n2) {
            int n5 = countryRegionData.macroRegionId;
            if (countryRegionData.countryId == countryRegionData.macroRegionId) break;
            for (n = 0; n < this.countryRegionData.length; ++n) {
                if (this.countryRegionData[n].countryId != n5) continue;
                countryRegionData = this.countryRegionData[n];
                continue block1;
            }
        }
        if (countryRegionData.countryId != countryRegionData.macroRegionId) {
            this.log.log(10000, "[CountryRegionData.listChanged] no root element found!");
            this.logoDb.setInitStatus(false);
            return;
        }
        n2 = countryRegionData.extraInt != null && countryRegionData.extraInt.length > 0 && (countryRegionData.extraInt[0] & 1) == 1 ? 1 : 0;
        LinkedList linkedList = new LinkedList();
        for (n = 0; n < this.countryRegionData.length; ++n) {
            if (this.countryRegionData[n].countryId == this.countryRegionData[n].macroRegionId || this.countryRegionData[n].macroRegionId != countryRegionData.countryId || (this.countryRegionData[n].countryId != 1 || n2 == 0) && this.countryRegionData[n].countryId == 1) continue;
            linkedList.add(this.countryRegionData[n]);
        }
        LinkedList linkedList2 = new LinkedList();
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            object = (CountryRegionData)iterator.next();
            boolean bl = false;
            for (int i2 = 0; i2 < this.countryRegionData.length; ++i2) {
                if (this.countryRegionData[i2].macroRegionId != ((CountryRegionData)object).countryId) continue;
                bl = true;
                linkedList2.add(new CountryRegionMngr$CountryRow(this, (CountryRegionData)object, this.getTranslation(((CountryRegionData)object).countryId), this.countryRegionData[i2], this.getTranslation(this.countryRegionData[i2].countryId)));
            }
            if (bl) continue;
            linkedList2.add(new CountryRegionMngr$CountryRow(this, (CountryRegionData)object, this.getTranslation(((CountryRegionData)object).countryId)));
        }
        boolean bl = false;
        object = linkedList2.iterator();
        while (object.hasNext()) {
            CountryRegionMngr$CountryRow countryRegionMngr$CountryRow = (CountryRegionMngr$CountryRow)object.next();
            bl |= countryRegionMngr$CountryRow.setRadioButton(this.selectedRegion);
        }
        Collections.sort(linkedList2, new CountryRegionMngr$CountryRowSorter(this.languageMngr));
        this.listModel.setStatus(linkedList2.isEmpty() ? 0 : 1);
        if (bl) {
            this.log.log(1078071040, "CountryRegionMngr.listChanged select Region %1", (long)this.selectedRegion);
            object = this.listModel.getEmptyCopy();
            object.append((CountryRegionMngr$CountryRow[])linkedList2.toArray(new CountryRegionMngr$CountryRow[linkedList2.size()]));
            object.setSelectedUniqueID(this.selectedRegion);
            this.listModel.update((BaseListModelApp)object);
        } else {
            this.log.log(1078071040, "CountryRegionMngr.listChanged reset to default settings called");
            this.resetToDefaultSettings();
        }
        this.logoDb.setInitStatus(true);
    }

    private CountryRegionTranslationData getTranslation(int n) {
        for (int i2 = 0; i2 < this.countryTranslation.length; ++i2) {
            if (this.countryTranslation[i2].countryId != n) continue;
            return this.countryTranslation[i2];
        }
        return null;
    }

    public int getHome(int n, int n2) {
        CountryRegionData countryRegionData = this.prepareRegion(n);
        if (n2 >= 0 && n2 < countryRegionData.countryNeighborPi.length) {
            return countryRegionData.countryNeighborPi[n2];
        }
        this.log.log(10000, "CountryRegionMngr.getHome() cc %1 wrong", (long)n2);
        return 0;
    }

    private synchronized CountryRegionData prepareRegion(int n) {
        if (this.preparedData.countryId != n) {
            this.preparedData = EMPTY_CR_DATA;
            for (int i2 = 0; i2 < this.countryRegionData.length; ++i2) {
                if (this.countryRegionData[i2].countryId != n) continue;
                this.preparedData = this.countryRegionData[i2];
                return this.preparedData;
            }
            this.log.log(-1601830656, "[CountryRegionManager.setActiveRegion] region %1 not found", (long)n);
        }
        return this.preparedData;
    }

    public int[] getAllNeighbors(int n) {
        CountryRegionData countryRegionData = this.prepareRegion(n);
        int[] nArray = new int[countryRegionData.countryNeighborPi.length + 1];
        System.arraycopy((Object)countryRegionData.countryNeighborPi, 0, (Object)nArray, 1, countryRegionData.countryNeighborPi.length);
        nArray[0] = n;
        return nArray;
    }

    public int getStrategy(int n) {
        return this.prepareRegion((int)n).requestStrategy;
    }

    public void resetToDefaultSettings() {
        int n = Utilities.getDatabaseRegion();
        this.setNewRegion(n);
    }

    private void setNewRegion(int n) {
        this.log.log(1078071040, "[CountryRegionMngr.setNewRegion] region: %1", (long)n);
        if (n == 69) {
            n = n == 69 ? 1 : n;
            this.log.log(1078071040, "[CountryRegionMngr.setNewRegion] region corrected: set region 69 (europe) to region 1 (Auto): region: %1", (long)n);
        }
        this.selectedRegion = n;
        this.prepareRegion(n);
        this.logoDb.setRegion(n);
        this.storage.storeDatabaseCountry(n);
        List list = this.listModel.asList();
        Object object = list.iterator();
        while (object.hasNext()) {
            CountryRegionMngr$CountryRow countryRegionMngr$CountryRow = (CountryRegionMngr$CountryRow)object.next();
            countryRegionMngr$CountryRow.setRadioButton(n);
        }
        object = this.listModel.getEmptyCopy();
        object.append((CountryRegionMngr$CountryRow[])list.toArray(new CountryRegionMngr$CountryRow[list.size()]));
        object.setSelectedUniqueID(n);
        this.listModel.update((BaseListModelApp)object);
    }

    public void setSystemLanguage(String string) {
        this.systemLanguage = string;
        this.lastCountryForNameSelection = -1;
    }

    public synchronized boolean isLongNamePrefered(int n) {
        if (n != this.lastCountryForNameSelection) {
            CountryRegionData countryRegionData = this.prepareRegion(n);
            String string = countryRegionData.nativeLanguage.toUpperCase();
            String string2 = this.systemLanguage.toUpperCase();
            this.longPrefered = "-1".equals(countryRegionData.nativeLanguage) ? false : (this.systemLanguage.equalsIgnoreCase(countryRegionData.nativeLanguage) ? false : string.length() <= 0 || string2.length() <= 0 || string.indexOf(string2) == -1);
            this.lastCountryForNameSelection = n;
        }
        return this.longPrefered;
    }

    static /* synthetic */ LogChannel access$100(CountryRegionMngr countryRegionMngr) {
        return countryRegionMngr.log;
    }

    static /* synthetic */ void access$200(CountryRegionMngr countryRegionMngr, int n) {
        countryRegionMngr.setNewRegion(n);
    }
}

