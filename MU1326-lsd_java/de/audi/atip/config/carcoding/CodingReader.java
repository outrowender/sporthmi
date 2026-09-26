/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.config.carcoding.AdaptationImplHigh;
import de.audi.atip.config.carcoding.AdaptationImplStandard;
import de.audi.atip.config.carcoding.CarFuncAdapImpl;
import de.audi.atip.config.carcoding.CodingImpl;
import de.audi.atip.config.carcoding.LoadSpeedThresholdImpl;
import de.audi.atip.config.carcoding.SperrFlagImpl;
import de.audi.atip.config.carcoding.VariantInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.ICodingReader;
import de.audi.atip.sysapp.carcoding.IVariantInfo;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import de.audi.atip.sysapp.carcoding.SperrFlags;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;

public final class CodingReader
implements ICodingReader {
    private final IFrameworkAccess fw;
    private final byte[] codingData;
    private final CarFuncAdap carFuncAdaptation;
    private final Coding carCoding;
    private final Adaptation adaptationANP;
    private final LoadSpeedThreshold speedThr;
    private final LogChannel lc;
    private IVariantInfo variantInfo;
    private SperrFlags sperrFlags = null;

    CodingReader(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = iFrameworkAccess.getLogChannel("Fw.Config.Reader");
        this.codingData = this.readCarCodingData();
        this.carCoding = new CodingImpl(this.codingData);
        this.adaptationANP = iFrameworkAccess.isEvoStd() || iFrameworkAccess.isPorscheStd() ? new AdaptationImplStandard(this.readAdaptationData(), this.readAdaptation2Data()) : new AdaptationImplHigh(this.readAdaptationData(), this.readAdaptation2Data());
        this.carFuncAdaptation = new CarFuncAdapImpl(this.readCarMenuFlags());
        this.speedThr = new LoadSpeedThresholdImpl(this.readSpeedThresholdData());
        this.variantInfo = new VariantInfo(this.readVariantInfostring());
    }

    @Override
    public CarFuncAdap getCarFuncAdaptation() {
        return this.carFuncAdaptation;
    }

    @Override
    public Coding getCarCoding() {
        return this.carCoding;
    }

    @Override
    public Adaptation getAdaptationANP() {
        return this.adaptationANP;
    }

    @Override
    public LoadSpeedThreshold getSpeedThresholdUPDL() {
        return this.speedThr;
    }

    @Override
    public synchronized SperrFlags getSperrFlags() {
        if (this.sperrFlags == null) {
            this.sperrFlags = new SperrFlagImpl(this.readSperrFlagData());
        }
        return this.sperrFlags;
    }

    @Override
    public IVariantInfo getVariantInfo() {
        return this.variantInfo;
    }

    private final byte[] getByteArray(int n, int n2) {
        return this.fw.getStorageMgr().getByteArray(n, n2, new byte[0]);
    }

    byte[] readCarCodingData() {
        byte[] byArray;
        byte[] byArray2 = this.getByteArray(-687821311, 1);
        if ((byArray2 == null || byArray2.length != 25) && (byArray = this.getByteArray(257, 100)) != null && byArray.length == 25) {
            byArray2 = byArray;
        }
        if (byArray2 == null || byArray2.length != 25) {
            this.lc.log(10000, "ERROR in read carCoding carData[]=%1", (Object)byArray2);
            byArray2 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 32, 0, 0, 6};
            this.lc.log(10000, "use default carCoding data=%1", (Object)Converter.array2String(byArray2));
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "Init CodingImpl with carData[]=%1", (Object)Converter.array2String(byArray2));
        }
        return byArray2;
    }

    private byte[] readAdaptationData() {
        byte[] byArray = this.getByteArray(-536825343, 100);
        if (byArray == null || byArray.length < 15) {
            this.lc.log(10000, "Read AdaptationANP data: %1 Wrong Size! expected > %2", (Object)Converter.array2String(byArray), (long)0);
            byArray = new byte[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0};
            this.lc.log(10000, "use default AdaptationANP data=%1", (Object)Converter.array2String(byArray));
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "Init AdaptationImpl with adaptationData[]=%1", (Object)Converter.array2String(byArray));
        }
        return byArray;
    }

    private byte[] readAdaptation2Data() {
        byte[] byArray = this.getByteArray(-536825343, 113);
        if (byArray == null || byArray.length < 15) {
            this.lc.log(10000, "Read AdaptationANP2 data: %1 Wrong Size! expected > %2", (Object)Converter.array2String(byArray), (long)0);
            byArray = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            this.lc.log(10000, "use default AdaptationANP2 data=%1", (Object)Converter.array2String(byArray));
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "Init AdaptationImpl with adaptation2Data[]=%1", (Object)Converter.array2String(byArray));
        }
        return byArray;
    }

    private byte[] readCarMenuFlags() {
        byte[] byArray = this.getByteArray(-536825343, 101);
        if (byArray == null || byArray.length == 0) {
            byArray = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            this.lc.log(10000, "getCarMenuFlags(): persistence does not contain carMenuFlags!!! Use default");
        }
        if (byArray[2] == -1) {
            byArray[2] = 0;
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "getCarMenuFlags(): carMenuFlags=%1", (Object)Converter.array2String(byArray));
        }
        return byArray;
    }

    private byte[] readSpeedThresholdData() {
        byte[] byArray = this.getByteArray(906042371, 200);
        if (byArray == null || byArray.length != 30) {
            this.lc.log(10000, "Error in LoadSpeedThreshold data=%1", (Object)Converter.array2String(byArray));
            byArray = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            this.lc.log(10000, "use default LoadSpeedThreshold data=%1", (Object)Converter.array2String(byArray));
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "Init LoadSpeedThreshold with speedThresholdData[]=%1", (Object)Converter.array2String(byArray));
        }
        return byArray;
    }

    private byte[] readSperrFlagData() {
        byte[] byArray = this.getByteArray(-536825343, 105);
        if (byArray == null || byArray.length < 21) {
            this.lc.log(10000, "Error in SperrFlags data=%1", (Object)Converter.array2String(byArray));
            byArray = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            this.lc.log(10000, "use default SperrFlags data=%1", (Object)Converter.array2String(byArray));
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "Init SperrFlags with SperrFlags[]=%1", (Object)Converter.array2String(byArray));
        }
        return byArray;
    }

    private String readVariantInfostring() {
        return this.fw.getStorageMgr().getString(-1945800920, 12, "unknown");
    }

    @Override
    public String dumpCarData() {
        Buffer buffer = new Buffer();
        buffer.append(this.carCoding);
        buffer.append(this.adaptationANP);
        buffer.append(this.carFuncAdaptation);
        buffer.append(this.speedThr);
        if (this.sperrFlags != null) {
            buffer.append(this.sperrFlags);
        }
        buffer.append(this.variantInfo);
        return buffer.toString();
    }

    private final void setByteArray(int n, int n2, byte[] byArray) {
        this.fw.getStorageMgr().setByteArray(n, n2, byArray);
    }

    @Override
    public void storeSwdlCopy() {
        this.setByteArray(257, 100, this.codingData);
    }

    @Override
    public void clearSwdlCopy() {
        this.setByteArray(257, 100, new byte[0]);
    }
}

