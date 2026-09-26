/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.combi.CombiBAPUtilities;
import de.audi.tuner.ifc.ICombiBAPServiceElementBuilderAMFM;

public class CombiBAPServiceElementBuilderAMFMEvo
implements ICombiBAPServiceElementBuilderAMFM {
    @Override
    public CombiBAPCurrentStationInfo getAMFMCurrentStationEntry(TunerObjectContainer tunerObjectContainer, int n, int n2, int n3, HMIResourceLocator hMIResourceLocator) {
        int n4;
        String string;
        String string2;
        AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
        int n5 = 68;
        int n6 = 0;
        if (aMFMStation.isHd()) {
            string2 = aMFMStation.getHDNameAndExt();
            n5 = 68;
            string = aMFMStation.getFrequencyString();
            n4 = 67;
            if (aMFMStation.getAudioStatus() == 2) {
                n6 |= 1;
                n6 |= 0x20;
            }
        } else if (!(aMFMStation.waveband != 1 && aMFMStation.waveband != 3 || Utilities.isEmpty(aMFMStation.name))) {
            string2 = aMFMStation.getName();
            n5 = 68;
            string = aMFMStation.getFrequencyString();
            n4 = 67;
        } else {
            string2 = aMFMStation.getFrequencyString();
            n5 = 67;
            string = "";
            n4 = 0;
        }
        int n7 = 0;
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo(string2, n5, 0, n, n7);
        combiBAPCurrentStationInfo.setSecondaryInformation(string, n4);
        combiBAPCurrentStationInfo.setPresetListRef(n2);
        combiBAPCurrentStationInfo.setPresetListAbsolutePosition(n3);
        if (aMFMStation.tp) {
            n6 |= 8;
        }
        if (aMFMStation.tmc) {
            n6 |= 4;
        }
        combiBAPCurrentStationInfo.setAttributes(n6);
        ArtistAndTitlePair artistAndTitlePair = aMFMStation.getArtistAndTitlePair();
        String string3 = artistAndTitlePair.titleString;
        if (!Utilities.isEmpty(string3)) {
            combiBAPCurrentStationInfo.setTertiaryInformation(string3, 72);
        }
        if (!Utilities.isEmpty(string3 = artistAndTitlePair.artistString)) {
            combiBAPCurrentStationInfo.setQuaternaryInformation(string3, 73);
        }
        combiBAPCurrentStationInfo.setPicture(hMIResourceLocator.getResourceID(), hMIResourceLocator.getResourceURI());
        return combiBAPCurrentStationInfo;
    }

    @Override
    public CombiBAPReceptionListEntry getAMFMListStationEntry(TunerObjectContainer tunerObjectContainer, int n) {
        int n2;
        String string;
        AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
        if (aMFMStation.isHd()) {
            string = aMFMStation.getHDNameAndExt();
            n2 = aMFMStation.serviceId < 2 ? 5 : 6;
        } else {
            string = aMFMStation.getName();
            n2 = 1;
        }
        CombiBAPReceptionListEntry combiBAPReceptionListEntry = new CombiBAPReceptionListEntry(n, n2, string, aMFMStation.getFrequencyString());
        combiBAPReceptionListEntry.setAttributes(CombiBAPUtilities.getBAPStationAttributes(tunerObjectContainer));
        combiBAPReceptionListEntry.setCategory(aMFMStation.getPtyCode());
        combiBAPReceptionListEntry.setPresetID(tunerObjectContainer.getPresetPos());
        return combiBAPReceptionListEntry;
    }
}

