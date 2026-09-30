/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rsdb.LogoDatabase;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.DSIRadioDataListener;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class RadioDataListenerImpl
implements DSIRadioDataListener {
    private final LogChannel lc;
    private final LogoDatabase internalDatabase;

    public RadioDataListenerImpl(TunerBasics tunerBasics, LogoDatabase logoDatabase) {
        this.lc = tunerBasics.getLogger().rsdb;
        this.internalDatabase = logoDatabase;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[RadioDataListenerImpl.asyncException]", (Object)string, (long)n, (long)n2);
    }

    public void responseRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        try {
            this.lc.log(1000000, "[RadioDataListenerImpl.responseRadioStationData] #list:%1 session:%2", (long)this.size(radioStationDataResponseArray), (long)n);
            if (this.lc.isDebug2()) {
                Buffer buffer = new Buffer(100 * radioStationDataResponseArray.length);
                for (int i2 = 0; i2 < radioStationDataResponseArray.length; ++i2) {
                    buffer.append(Utilities.toString(radioStationDataResponseArray[i2])).append('\n');
                }
                this.lc.log(100000000, "%1", (Object)buffer);
            }
            this.internalDatabase.respStationData(radioStationDataResponseArray, n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    public void responseRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        try {
            this.lc.log(1000000, "[RadioDataListenerImpl.responseRadioStationLogos] #list:%1 session:%2", (long)this.size(radioStationLogoResponseArray), (long)n);
            if (this.lc.isDebug2()) {
                Buffer buffer = new Buffer(100 * radioStationLogoResponseArray.length);
                for (int i2 = 0; i2 < radioStationLogoResponseArray.length; ++i2) {
                    buffer.append(Utilities.toString(radioStationLogoResponseArray[i2])).append('\n');
                }
                this.lc.log(100000000, "%1", (Object)buffer);
            }
            this.internalDatabase.respStationLogos(radioStationLogoResponseArray, n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    public void responseDynamicDatabaseAlteration(int n, int n2) {
        this.lc.log(1000000, "[RadioDataListenerImpl.responseDynamicDatabaseAlteration] success:%1 session:%2", (long)n, (long)n2);
    }

    public void responseCountryList(int[] nArray, int n) {
        try {
            this.lc.log(1000000, "[RadioDataListenerImpl.responseCountryList] #list:%1 session:%2", (long)this.size(nArray), (long)n);
            if (this.lc.isDebug2()) {
                Buffer buffer = new Buffer(5 * nArray.length);
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    buffer.append(nArray[i2]).append(' ');
                }
                this.lc.log(100000000, "%1", (Object)buffer);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    public void responseDatabaseVersionInfo(int n, int n2, int n3, String string, int n4, int n5, int n6) {
        try {
            if (this.lc.isInfo()) {
                Buffer buffer = new Buffer(100);
                buffer.append("Major").append(n);
                buffer.append(" Minor").append(n2);
                buffer.append(" Revision").append(n3);
                buffer.append(" Date").append(string);
                buffer.append(" Region").append(n4);
                buffer.append(" success").append(n5);
                buffer.append(" session").append(n6);
                this.lc.log(1000000, "[RadioDataListenerImpl.responseDatabaseVersionInfo] %1", (Object)buffer);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    public void updateDatabaseState(int n, int n2) {
        try {
            this.lc.log(1000000, "[RadioDataListenerImpl.updateDatabaseState] state:%1 valid:%2", (long)n, (long)n2);
            this.internalDatabase.setStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    public void responsePersistStationLogos(int n, int n2) {
        this.lc.log(1000000, "[RadioDataListenerImpl.responsePersistStationLogos] success:%1 session:%2", (long)n, (long)n2);
    }

    public void updateRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        this.lc.log(1000000, "[RadioDataListenerImpl.updateRadioStationLogos] #list:%1 valid:%2", (long)this.size(radioStationLogoResponseArray), (long)n);
    }

    public void responseCountryRegionData(CountryRegionData[] countryRegionDataArray, int n) {
        try {
            this.lc.log(1000000, "[RadioDataListenerImpl.responseCountryRegionData] #list:%1 session:%2", (long)this.size(countryRegionDataArray), (long)n);
            if (this.lc.isDebug2()) {
                Buffer buffer = new Buffer(600 * countryRegionDataArray.length);
                for (int i2 = 0; i2 < countryRegionDataArray.length; ++i2) {
                    buffer.append(countryRegionDataArray[i2]).append('\n');
                }
                this.lc.log(100000000, "%1", (Object)buffer);
            }
            this.internalDatabase.setCountyRegionData(countryRegionDataArray);
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    public void responseCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
        try {
            this.lc.log(1000000, "[RadioDataListenerImpl.responseCountryRegionTranslationData] #list:%1 session:%2", (long)this.size(countryRegionTranslationDataArray), (long)n);
            if (this.lc.isDebug2()) {
                Buffer buffer = new Buffer(100 * countryRegionTranslationDataArray.length);
                for (int i2 = 0; i2 < countryRegionTranslationDataArray.length; ++i2) {
                    buffer.append(countryRegionTranslationDataArray[i2]).append('\n');
                }
                this.lc.log(100000000, "%1", (Object)buffer);
            }
            this.internalDatabase.setCountryRegionTranslationData(countryRegionTranslationDataArray);
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1", (Throwable)exception);
        }
    }

    private int size(Object[] objectArray) {
        return objectArray != null ? objectArray.length : -1;
    }

    private int size(int[] nArray) {
        return nArray != null ? nArray.length : -1;
    }

    public void responsePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
    }

    public void updatePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }
}

