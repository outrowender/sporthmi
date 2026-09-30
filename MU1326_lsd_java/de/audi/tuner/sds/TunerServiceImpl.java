/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.Const;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.sds.SortAlgoSpeech;
import java.util.ArrayList;
import java.util.Collections;

public class TunerServiceImpl
implements TunerService {
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final AnnouncementHandler announce;
    private final BandListHandler bandList;
    private final AudioFocusClient audioFocusClient;

    public TunerServiceImpl(TunerBasics tunerBasics, AnnouncementHandler announcementHandler, BandListHandler bandListHandler, AudioFocusClient audioFocusClient) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.audioFocusClient = audioFocusClient;
        this.announce = announcementHandler;
        this.bandList = bandListHandler;
    }

    public void forceStationListUpdate() {
        int n = this.models.getActiveTuner();
        this.logger.sds.log(1000000, "[TunerServiceImpl.forceStationListUpdate], active tuner: %1", (long)n);
        if (n == 4) {
            TunerProxyManager.getInstance().getAmFmTuner().forceStationListUpdate(true);
        } else if (n == 5) {
            TunerProxyManager.getInstance().getDABTuner().forceStationListUpdate(true);
        }
    }

    public byte freezeDynamicLists() {
        this.logger.sds.log(1000000, "[TunerServiceImpl.freezeDynamicLists] called");
        int[] nArray = new int[]{2, 3};
        int[] nArray2 = new int[]{5, 6, 7};
        int[] nArray3 = new int[]{4};
        this.status.setSDSActive(true);
        TunerProxyManager.getInstance().getAmFmTuner().clearNotification(nArray);
        TunerProxyManager.getInstance().getDABTuner().clearNotification(nArray2);
        TunerProxyManager.getInstance().getUnifiedTuner().clearNotification(nArray3);
        return 0;
    }

    public byte unfreezeDynamicLists() {
        this.logger.sds.log(1000000, "[TunerServiceImpl.unfreezeDynamicLists] called");
        int[] nArray = new int[]{2, 3};
        int[] nArray2 = new int[]{5, 6, 7};
        int[] nArray3 = new int[]{4};
        this.status.setSDSActive(false);
        TunerProxyManager.getInstance().getAmFmTuner().setNotification(nArray);
        TunerProxyManager.getInstance().getDABTuner().setNotification(nArray2);
        TunerProxyManager.getInstance().getUnifiedTuner().setNotification(nArray3);
        return 0;
    }

    public byte selectWaveBand(int n) {
        this.logger.sds.log(1000000, "[TunerServiceImpl.selectWaveBand], band: %1", (long)n);
        this.bandList.switchBand(Const.sds2RadioBand(n));
        if (Utilities.isPGen1OrBentley()) {
            this.audioFocusClient.switchSource(0, Const.sds2RadioBand(n), null);
        }
        return 1;
    }

    public byte switchTrafficAnnouncements(boolean bl) {
        this.logger.sds.log(1000000, "[TunerServiceImpl.switchTrafficAnnouncements], on: %1", bl);
        if (!bl) {
            this.announce.switchTrafficAnnouncements(0, false);
        } else {
            this.announce.switchTrafficAnnouncements(2, true);
        }
        return 1;
    }

    public byte tuneEnsembleByID(long l) {
        this.logger.sds.log(1000000, "[TunerServiceImpl.tuneEnsembleByID], ensId: %1", l);
        return this.tuneStationByID(new long[]{l}).getResultCode();
    }

    public byte tuneFrequency(long l, byte by) {
        this.logger.sds.log(1000000, "[TunerServiceImpl.tuneFrequency] frequency=%1, subchannel=%2", l, (long)by);
        if (l == 87750L) {
            l = 87700L;
            this.logger.sds.log(1000000, "[TunerServiceImpl.tuneFrequency] adjust frequency to %1", l);
        }
        AMFMStation aMFMStation = new AMFMStation();
        aMFMStation.frequency = l;
        aMFMStation.pi = -1;
        aMFMStation.waveband = this.bandList.getWavebandByFrequency(l);
        if (aMFMStation.waveband == -1) {
            return 0;
        }
        if (by > 1) {
            aMFMStation.hd = true;
            switch (by) {
                case 2: {
                    aMFMStation.serviceId = 2;
                    break;
                }
                case 3: {
                    aMFMStation.serviceId = 4;
                    break;
                }
                case 4: {
                    aMFMStation.serviceId = 8;
                    break;
                }
                case 5: {
                    aMFMStation.serviceId = 16;
                    break;
                }
                case 6: {
                    aMFMStation.serviceId = 32;
                    break;
                }
                case 7: {
                    aMFMStation.serviceId = 64;
                    break;
                }
                case 8: {
                    aMFMStation.serviceId = 128;
                    break;
                }
                default: {
                    aMFMStation.serviceId = 1;
                }
            }
        }
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(3, aMFMStation);
        byte by2 = this.checkBandChangeByFrequency(l);
        if (by2 != 0) {
            this.models.setActiveList(tunerObjectContainer.getBand());
            this.audioFocusClient.switchSource(0, tunerObjectContainer.getBand(), tunerObjectContainer);
        }
        return by2;
    }

    public TunerService.TunerSettingResult tuneStationByID(long[] lArray) {
        this.logger.sds.log(1000000, "[TunerServiceImpl.tuneStationByID], iDs: %1", (Object)lArray);
        long l = this.selectStationID(lArray);
        int n = this.models.getActiveTuner();
        this.logger.sds.log(1000000, "[TunerServiceImpl.tuneStationByID], objectId: %1", l);
        TunerObjectContainer tunerObjectContainer = new RadioObjectIds((long)l, (LogChannel)this.logger.sds).toc;
        if (tunerObjectContainer == null) {
            return new TunerService.TunerSettingResult(0, l);
        }
        this.audioFocusClient.switchSource(0, tunerObjectContainer.getBand(), tunerObjectContainer);
        if (RadioObjectIds.isFavorite(l) && !Utilities.isPGen1OrBentley()) {
            this.models.setActiveList(12);
        } else {
            this.models.setActiveList(tunerObjectContainer.getBand());
        }
        if (tunerObjectContainer.getType() != 5) {
            return new TunerService.TunerSettingResult(this.checkBandChange(l, n), l);
        }
        return new TunerService.TunerSettingResult(this.checkBandChange(l, n), l);
    }

    public void abortActiveTA() {
        this.announce.abortAnnouncement();
    }

    private byte checkBandChangeByFrequency(long l) {
        int n = this.models.getActiveTuner();
        int n2 = this.bandList.getBandByFrequency((int)l);
        this.logger.sds.log(1000000, "[TunerServiceImpl.checkBandChange], current Band: %1, new Band: %2", (long)n, (long)n2);
        return this.getBandChange(n2, n);
    }

    private byte checkBandChange(long l, int n) {
        int n2 = RadioObjectIds.getBandComponent(l);
        this.logger.sds.log(1000000, "[TunerServiceImpl.checkBandChange], current Band: %1, new Band: %2", (long)n, (long)n2);
        return this.getBandChange(n2, n);
    }

    private byte getBandChange(int n, int n2) {
        byte by;
        if (n != n2) {
            switch (n) {
                case 1: {
                    by = 2;
                    break;
                }
                case 4: {
                    by = 3;
                    break;
                }
                case 5: {
                    by = 4;
                    break;
                }
                case 7: {
                    by = 5;
                    break;
                }
                case 11: {
                    by = 6;
                    break;
                }
                default: {
                    by = 0;
                    break;
                }
            }
        } else {
            by = 1;
        }
        this.logger.sds.log(1000000, "[TunerServiceImpl.getBandChange], returning: %1", (long)by);
        return by;
    }

    private long selectStationID(long[] lArray) {
        long l = 0L;
        this.logger.sds.log(1000000, "[TunerServiceImpl.selectStationID], matchedStationIds: %1", (Object)lArray);
        if (lArray != null && lArray.length > 0) {
            if (this.logger.sds.isDebug2()) {
                for (int i2 = 0; i2 < lArray.length; ++i2) {
                    this.logger.sds.log(100000000, "[%2] %1", (Object)RadioObjectIds.dump(lArray[i2]), (long)i2);
                }
            }
            Long[] longArray = this.getStatioListIds(lArray);
            Long[] longArray2 = this.getPresetListIds(lArray);
            Long[] longArray3 = this.getIdsOfBand(longArray, this.models.getActiveTuner());
            if (longArray3.length > 0) {
                l = longArray3[0];
                this.logger.sds.log(1000000, "[TunerServiceImpl.selectStationID], activeBand: %1", l);
            } else if (longArray2.length > 0) {
                l = longArray2[0];
                this.logger.sds.log(1000000, "[TunerServiceImpl.selectStationID], PresetList: %1", l);
            } else if (longArray.length > 0) {
                l = longArray[0];
                this.logger.sds.log(1000000, "[TunerServiceImpl.selectStationID], StationList: %1", l);
            }
            return l;
        }
        return l;
    }

    private Long[] getIdsOfBand(Long[] longArray, int n) {
        ArrayList arrayList = new ArrayList(longArray.length);
        for (int i2 = 0; i2 < longArray.length; ++i2) {
            if (RadioObjectIds.getBandComponent(longArray[i2]) != n) continue;
            arrayList.add(longArray[i2]);
        }
        Collections.sort(arrayList, new SortAlgoSpeech(TunerProxyManager.getInstance().getDABTuner().getActiveStation().ensemble.getEnsID()));
        return (Long[])arrayList.toArray(new Long[arrayList.size()]);
    }

    private Long[] getPresetListIds(long[] lArray) {
        ArrayList arrayList = new ArrayList(lArray.length);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (!RadioObjectIds.isFavorite(lArray[i2])) continue;
            arrayList.add(new Long(lArray[i2]));
        }
        Collections.sort(arrayList, new SortAlgoSpeech(TunerProxyManager.getInstance().getDABTuner().getActiveStation().ensemble.getEnsID()));
        return (Long[])arrayList.toArray(new Long[arrayList.size()]);
    }

    private Long[] getStatioListIds(long[] lArray) {
        ArrayList arrayList = new ArrayList(lArray.length);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (RadioObjectIds.isFavorite(lArray[i2])) continue;
            arrayList.add(new Long(lArray[i2]));
        }
        Collections.sort(arrayList, new SortAlgoSpeech(TunerProxyManager.getInstance().getDABTuner().getActiveEnsemble().getEnsID()));
        return (Long[])arrayList.toArray(new Long[arrayList.size()]);
    }

    public byte selectGenre(long l) {
        ISDARSTuner iSDARSTuner = TunerProxyManager.getInstance().getSDARSTuner();
        TunerObjectContainer tunerObjectContainer = iSDARSTuner.getNextChannelByGenre((short)l);
        if (tunerObjectContainer != null) {
            this.audioFocusClient.switchSource(0, tunerObjectContainer.getBand(), tunerObjectContainer);
            return 1;
        }
        return 2;
    }

    public byte fillTunerPickList(TunerService.TunerListEntry[] tunerListEntryArray) {
        try {
            BaseListModelApp baseListModelApp = this.models.getBaseListModel(3865);
            baseListModelApp.removeAll();
            baseListModelApp.setSelectedIndex(-1);
            EvoListRow[] evoListRowArray = new EvoListRow[tunerListEntryArray.length];
            for (int i2 = 0; i2 < tunerListEntryArray.length; ++i2) {
                long l;
                long[] lArray = tunerListEntryArray[i2].getEntryVariantIds();
                String string = "";
                if (lArray.length == 1) {
                    l = lArray[0];
                    string = tunerListEntryArray[i2].getName();
                } else {
                    l = this.selectStationID(lArray);
                    for (int i3 = 0; i3 < lArray.length; ++i3) {
                        if (lArray[i3] != l) continue;
                        string = tunerListEntryArray[i2].getNameOfEntryVariant(i3);
                        break;
                    }
                }
                evoListRowArray[i2] = new EvoListRow(l, 2);
                evoListRowArray[i2].setLong(0, l);
                evoListRowArray[i2].setText(1, string);
            }
            baseListModelApp.append(evoListRowArray);
            return 1;
        }
        catch (Exception exception) {
            this.logger.sds.log(10000, "[TunerServiceImpl.fillTunerPickList] %1", (Throwable)exception);
            return 0;
        }
    }

    public byte fillTunerPickList(SDSListEntry[] sDSListEntryArray) {
        try {
            BaseListModelApp baseListModelApp = this.models.getBaseListModel(3865);
            baseListModelApp.removeAll();
            baseListModelApp.setSelectedIndex(-1);
            EvoListRow[] evoListRowArray = new EvoListRow[sDSListEntryArray.length];
            for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
                evoListRowArray[i2] = new EvoListRow(sDSListEntryArray[i2].getId(), 2);
                evoListRowArray[i2].setLong(0, sDSListEntryArray[i2].getId());
                evoListRowArray[i2].setText(1, sDSListEntryArray[i2].getName());
            }
            baseListModelApp.append(evoListRowArray);
            return 1;
        }
        catch (Exception exception) {
            this.logger.sds.log(10000, "[TunerServiceImpl.fillTunerPickList] %1", (Throwable)exception);
            return 0;
        }
    }

    public SDSListEntry getTunerPicklistEntry(int n) {
        BaseListModelApp baseListModelApp = this.models.getBaseListModel(3865);
        if (n > baseListModelApp.getLength()) {
            return null;
        }
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        String string = evoListRow.getText(1);
        long l = evoListRow.getLong(0);
        return new SDSListEntry(string, l);
    }

    public byte getTypeOfListRow(int n) {
        switch (this.models.getActiveList()) {
            case 5: {
                return TunerProxyManager.getInstance().getStationListHandler(5).isEnsemble(n) ? (byte)2 : 0;
            }
            case 7: {
                return 0;
            }
        }
        return 0;
    }

    public int getWavebandForID(long[] lArray) {
        long l = this.selectStationID(lArray);
        switch (RadioObjectIds.getBandComponent(l)) {
            case 4: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 5: {
                return 5;
            }
            case 11: {
                return 9;
            }
            case 7: {
                return 7;
            }
        }
        return 0;
    }
}

