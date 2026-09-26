/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.ifc.ISimpleTuner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.StationInfo;

class SDARSDSIUpManager$StationsDatabase {
    private final LogChannel lc;
    private StationInfoExt[] stationInfo = new StationInfoExt[0];
    private StationInfoExt[] sIDToStationInfo = new StationInfoExt[384];
    private HMIResourceLocator[] sIDToStationArt = new HMIResourceLocator[384];
    private final Map catNumberToCategory = new HashMap();
    private StationInfoExt selectedStation;

    public SDARSDSIUpManager$StationsDatabase(TunerBasics tunerBasics) {
        this.lc = tunerBasics.getLogger().sdarsDSI;
        Arrays.fill(this.sIDToStationArt, ISimpleTuner.EMPTY_RL);
    }

    public void updateStationInfo(StationInfo[] stationInfoArray) {
        this.stationInfo = new StationInfoExt[stationInfoArray.length];
        this.sIDToStationInfo = new StationInfoExt[384];
        for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
            int n = stationInfoArray[i2].sID;
            StationInfoExt stationInfoExt = new StationInfoExt(stationInfoArray[i2]);
            this.fillInCategoryInfos(stationInfoExt);
            if (stationInfoExt.fullLabel == null || stationInfoExt.shortLabel == null) {
                String string;
                this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateStationInfo] name=null for %1", (Object)stationInfoExt);
                stationInfoExt.fullLabel = string = new StringBuffer().append("Station").append(stationInfoExt.stationNumber).toString();
                stationInfoExt.shortLabel = string;
            }
            this.stationInfo[i2] = stationInfoExt;
            if (SDARSDSIUpManager$StationsDatabase.isSIDValid(n)) {
                this.sIDToStationInfo[n] = stationInfoExt;
                this.sIDToStationInfo[n].setStationArt(this.sIDToStationArt[n]);
                continue;
            }
            this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateStationInfo] invalid sID %1", (long)n);
        }
    }

    public void updateSelectedStation(StationInfo stationInfo) {
        this.selectedStation = new StationInfoExt(stationInfo);
        if (SDARSDSIUpManager$StationsDatabase.isSIDValid(this.selectedStation.sID)) {
            this.selectedStation.setStationArt(this.sIDToStationArt[this.selectedStation.sID]);
        } else {
            this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateSelectedStation] invalid sID %1", (long)this.selectedStation.sID);
        }
        this.fillInCategoryInfos(this.selectedStation);
    }

    public void informationStationArt(ImageInformation[] imageInformationArray) {
        for (int i2 = 0; i2 < imageInformationArray.length; ++i2) {
            int n = imageInformationArray[i2].sID;
            if (SDARSDSIUpManager$StationsDatabase.isSIDValid(n)) {
                HMIResourceLocator hMIResourceLocator;
                ResourceLocator resourceLocator = imageInformationArray[i2].getImage();
                boolean bl = resourceLocator != null && !Utilities.isEmpty(resourceLocator.url);
                this.sIDToStationArt[n] = hMIResourceLocator = bl ? new HMIResourceLocator(resourceLocator.url) : ISimpleTuner.EMPTY_RL;
                if (this.sIDToStationInfo[n] == null) continue;
                this.sIDToStationInfo[n].setStationArt(hMIResourceLocator);
                continue;
            }
            this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateStationArt] invalid sID %1", (long)n);
        }
        if (this.isSelectedStationPresent()) {
            this.selectedStation.setStationArt(this.sIDToStationArt[this.selectedStation.sID]);
        }
    }

    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        int n;
        this.catNumberToCategory.clear();
        for (n = 0; n < categoryInfoExtArray.length; ++n) {
            this.catNumberToCategory.put(Util.createInteger(categoryInfoExtArray[n].categoryNumber), categoryInfoExtArray[n]);
        }
        for (n = 0; n < this.stationInfo.length; ++n) {
            this.fillInCategoryInfos(this.stationInfo[n]);
        }
        if (this.isSelectedStationPresent()) {
            this.fillInCategoryInfos(this.selectedStation);
        }
    }

    public StationInfoExt getSelectedStation() {
        return this.selectedStation;
    }

    public boolean isSelectedStationPresent() {
        return this.selectedStation != null;
    }

    public StationInfoExt[] getGaplessStationList() {
        return this.stationInfo;
    }

    public StationInfoExt getStationInfoExtForSID(int n) {
        if (SDARSDSIUpManager$StationsDatabase.isSIDValid(n)) {
            return this.sIDToStationInfo[n];
        }
        this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.getStationInfoExtForSID] invalid sID %1", (long)n);
        return null;
    }

    private void fillInCategoryInfos(StationInfoExt stationInfoExt) {
        CategoryInfoExt categoryInfoExt = (CategoryInfoExt)this.catNumberToCategory.get(Util.createInteger(stationInfoExt.categoryNumber));
        if (categoryInfoExt == null) {
            categoryInfoExt = CategoryInfoExt.EMPTY_CATEGORY;
        }
        stationInfoExt.setCategory(categoryInfoExt);
    }

    private static boolean isSIDValid(int n) {
        return n >= 0 && n < 384;
    }
}

