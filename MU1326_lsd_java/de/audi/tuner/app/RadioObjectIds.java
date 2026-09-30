/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class RadioObjectIds {
    private static final byte OBJ_ID_BAND_CODE_FM = 1;
    private static final byte OBJ_ID_BAND_CODE_AM = 2;
    private static final byte OBJ_ID_BAND_CODE_DAB = 3;
    private static final byte OBJ_ID_BAND_CODE_SDARS = 4;
    private static final byte OBJ_ID_BAND_CODE_UNIFIED = 5;
    private static final byte OBJ_ID_BAND_CODE_UNIFIED_FM = 6;
    private final LogChannel log;
    public final TunerObjectContainer toc;

    public RadioObjectIds(long l, LogChannel logChannel) {
        this.log = logChannel;
        byte by = (byte)(l & 0xFL);
        switch (by) {
            case 1: 
            case 2: {
                this.toc = new TunerObjectContainer(this.createAmFmContainer(l, by));
                break;
            }
            case 3: {
                this.toc = this.createDabObjectContainer(l);
                break;
            }
            case 5: 
            case 6: {
                this.toc = this.createUniObjectContainer(l);
                break;
            }
            case 4: {
                this.toc = this.createSdarsObjectContainer(l);
                break;
            }
            default: {
                this.toc = null;
            }
        }
    }

    private AMFMStation createAmFmContainer(long l, byte by) {
        AMFMStation aMFMStation = new AMFMStation();
        aMFMStation.frequency = (int)(l >> 8 & 0xFFFFFFFFFFFFFFFFL);
        aMFMStation.rds = (l & 0x100000000000000L) != 0L;
        aMFMStation.pi = aMFMStation.rds ? (int)(l >> 40 & 0xFFFFL) : -1;
        aMFMStation.serviceId = this.unpackServiceId(l >> 57 & 0xFL);
        aMFMStation.waveband = by == 1 ? 1 : 3;
        aMFMStation.hd = (l >> 61 & 1L) == 1L;
        return aMFMStation;
    }

    private int unpackServiceId(long l) {
        switch ((int)l) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 8;
            }
            case 5: {
                return 16;
            }
            case 6: {
                return 32;
            }
            case 7: {
                return 64;
            }
            case 8: {
                return 128;
            }
        }
        return 0;
    }

    private TunerObjectContainer createDabObjectContainer(long l) {
        int n = RadioObjectIds.getEnsembleId(l);
        int n2 = RadioObjectIds.getEnsembleEcc(l);
        if (n == 0) {
            this.log.log(10000, "[ROI.createDabObjectContainer] Invalid IDs! objectId:%1 ensID:%2 ensECC:%3", (Object)Long.toHexString(l), (long)n, (long)n2);
            return null;
        }
        int n3 = RadioObjectIds.getServiceId(l);
        int n4 = RadioObjectIds.getComponentId(l);
        boolean bl = this.getPrimary(l);
        EnsembleInfo ensembleInfo = new EnsembleInfo();
        ServiceInfo serviceInfo = new ServiceInfo();
        ComponentInfo componentInfo = new ComponentInfo();
        this.log.log(10000000, "[ROI.createDabObjectContainer] objectId:%1 ensID:%2 ensECC:%3", (Object)Long.toHexString(l), (long)n, (long)n2);
        this.log.log(10000000, "[ROI.createDabObjectContainer] serviceID:%1 componentID:%2", (long)n3, (long)n4);
        if (n3 != 0) {
            componentInfo.ensID = n;
            componentInfo.ensECC = n2;
            componentInfo.sID = n3;
            componentInfo.sCIDI = n4;
            componentInfo.primaryService = bl;
            this.log.log(1000000, "[ROI.createDabObjectContainer] created component: %1", (Object)componentInfo);
        }
        if (n3 != 0) {
            serviceInfo.ensID = n;
            serviceInfo.ensECC = n2;
            serviceInfo.sID = n3;
            this.log.log(1000000, "[ROI.createDabObjectContainer], created service: %1", (Object)serviceInfo);
        }
        ensembleInfo.ensID = n;
        ensembleInfo.ensECC = n2;
        this.log.log(1000000, "[ROI.createDabObjectContainer], created ensemble: %1", (Object)ensembleInfo);
        return new TunerObjectContainer(new DabStation(ensembleInfo, serviceInfo, componentInfo));
    }

    private TunerObjectContainer createUniObjectContainer(long l) {
        UnifiedStationExt unifiedStationExt = new UnifiedStationExt();
        byte by = (byte)(l & 0xFL);
        if (by == 6) {
            AMFMStation aMFMStation = this.createAmFmContainer(l, (byte)1);
            unifiedStationExt.frequency = aMFMStation.frequency;
            unifiedStationExt.piSId = aMFMStation.pi;
            unifiedStationExt.rds = aMFMStation.rds;
        } else {
            unifiedStationExt.ensId = RadioObjectIds.getEnsembleId(l);
            unifiedStationExt.ecc = RadioObjectIds.getEnsembleEcc(l);
            unifiedStationExt.piSId = RadioObjectIds.getServiceId(l);
            unifiedStationExt.sCIDI = RadioObjectIds.getComponentId(l);
        }
        return new TunerObjectContainer(unifiedStationExt);
    }

    private TunerObjectContainer createSdarsObjectContainer(long l) {
        this.log.log(1000000, "[ROI#createSdarsObjectContainer], objectId: %1", (Object)Long.toHexString(l));
        StationInfoExt stationInfoExt = new StationInfoExt();
        stationInfoExt.sID = RadioObjectIds.getSDARSsId(l);
        return new TunerObjectContainer(stationInfoExt);
    }

    public static long getSDARSObjectId(int n) {
        return (long)n << 8 | 4L;
    }

    public static long getDabId(int n, int n2, long l, int n3, boolean bl) {
        long l2 = bl ? 1L : 0L;
        return l2 << 56 | (long)n3 << 48 | l << 32 | (long)n << 16 | (long)n2 << 8 | 3L;
    }

    public static long getUniId(long l, int n, int n2, int n3, int n4) {
        int n5;
        long l2;
        if (n2 == 0) {
            l2 = RadioObjectIds.getAmFmId(1, l, n, 0, false);
            n5 = 6;
        } else {
            l2 = RadioObjectIds.getDabId(n2, n3, n, n4, n4 == 0);
            n5 = 5;
        }
        l2 &= 0xFFFFFFFFFFFFFF00L;
        return l2 |= (long)n5;
    }

    public static long getAmFmId(int n, long l, int n2, int n3, boolean bl) {
        n2 = Utilities.isPiIgnore() ? -1 : n2;
        long l2 = n == 1 ? 1L : 2L;
        long l3 = bl ? 0x2000000000000000L : 0L;
        return l3 | RadioObjectIds.packChannel(n3) << 57 | (n2 >= 0 ? 0x100000000000000L : 0L) | (long)(n2 & 0xFFFF) << 40 | l << 8 | l2;
    }

    private static long packChannel(int n) {
        switch (n) {
            case 1: {
                return 1L;
            }
            case 2: {
                return 2L;
            }
            case 4: {
                return 3L;
            }
            case 8: {
                return 4L;
            }
            case 16: {
                return 5L;
            }
            case 32: {
                return 6L;
            }
            case 64: {
                return 7L;
            }
            case 128: {
                return 8L;
            }
        }
        return 0L;
    }

    public static long toFavoriteID(long l) {
        return l | 0x80L;
    }

    public static long toEpgProgNowID(long l) {
        return l | 0x200000000000000L;
    }

    public static long toEpgProgNextID(long l) {
        return l | 0x2000000000000000L;
    }

    public static long toSdarsEPGProg(long l, int n) {
        return (long)n << 32 | l;
    }

    public static int getBandComponent(long l) {
        byte by = (byte)(l & 0xFL);
        switch (by) {
            case 1: {
                return 1;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 5;
            }
            case 5: 
            case 6: {
                return 11;
            }
            case 4: {
                return 7;
            }
        }
        Buffer buffer = new Buffer(50);
        buffer.append("No case for objectId ").append(l).append(" with bandCode ").append(by);
        throw new IllegalArgumentException(buffer.toString());
    }

    public static boolean isFavorite(long l) {
        return (l & 0x80L) == 128L;
    }

    private static int getFrequency(long l) {
        return (int)(l >> 8 & 0xFFFFFFFFFFFFFFFFL);
    }

    private static int getPi(long l) {
        return (int)(l >> 40 & 0xFFFFL);
    }

    private static int getEnsembleEcc(long l) {
        return (int)(l >> 8 & 0xFFL);
    }

    public static int getEnsembleId(long l) {
        return (int)(l >> 16 & 0xFFFFL);
    }

    private static int getServiceId(long l) {
        return (int)(l >> 32 & 0xFFFFL);
    }

    private static int getComponentId(long l) {
        return (int)(l >> 48 & 0xFFL);
    }

    private boolean getPrimary(long l) {
        int n = (int)(l >> 56 & 0xFL);
        return n == 1;
    }

    public static int getSDARSsId(long l) {
        return (int)(l >> 8 & 0xFFFFFFFFFFFFFFFFL);
    }

    public static Buffer dump(long l) {
        Buffer buffer = new Buffer(100);
        buffer.append(l).append(':');
        int n = RadioObjectIds.getBandComponent(l);
        switch (n) {
            case 1: {
                buffer.append(RadioObjectIds.dumpFM(l));
                break;
            }
            case 4: {
                buffer.append(RadioObjectIds.dumpAM(l));
                break;
            }
            case 5: {
                buffer.append(RadioObjectIds.dumpDAB(l));
                break;
            }
            case 7: {
                buffer.append(RadioObjectIds.dumpSDARS(l));
                break;
            }
        }
        buffer.append(" isPreset: ").append(RadioObjectIds.isFavorite(l));
        return buffer;
    }

    private static Buffer dumpDAB(long l) {
        Buffer buffer = new Buffer(100);
        buffer.append("DAB: EnsId=").append(RadioObjectIds.getEnsembleId(l));
        buffer.append(" ECC=").append(RadioObjectIds.getEnsembleEcc(l));
        buffer.append(" SID=").append(RadioObjectIds.getServiceId(l));
        buffer.append(" SCIDI=").append(RadioObjectIds.getComponentId(l));
        return buffer;
    }

    private static Buffer dumpAM(long l) {
        Buffer buffer = new Buffer(100);
        buffer.append("AM: f=").append(RadioObjectIds.getFrequency(l));
        return buffer;
    }

    private static Buffer dumpFM(long l) {
        Buffer buffer = new Buffer(100);
        buffer.append("FM: f=").append(RadioObjectIds.getFrequency(l));
        buffer.append(" PI=").append(RadioObjectIds.getPi(l));
        return buffer;
    }

    private static Buffer dumpSDARS(long l) {
        Buffer buffer = new Buffer(100);
        buffer.append("SDARS: SID=").append(RadioObjectIds.getSDARSsId(l));
        return buffer;
    }

    public static long getEnsembleUniqueId(long l) {
        int n = RadioObjectIds.getEnsembleId(l);
        int n2 = RadioObjectIds.getEnsembleEcc(l);
        return RadioObjectIds.getDabId(n, n2, 0L, 0, false);
    }
}

