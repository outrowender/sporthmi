/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.ICodingReader;
import de.audi.atip.sysapp.carcoding.IVariantInfo;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import de.audi.atip.sysapp.carcoding.SperrFlags;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public interface ISysConstManager {
    public int getSysConst(int var1);

    public String dumpCarData();

    public Coding getCarCoding();

    public Adaptation getAdaptationANP();

    public CarFuncAdap getCarFuncAdaptation();

    public LoadSpeedThreshold getSpeedThresholdUPDL();

    public SperrFlags getSperrFlags();

    public IVariantInfo getVariantInfo();

    public void initSysConstants(SimpleIntIntMap var1, ICodingReader var2);

    public int getHMIInternalPopupPrio(int var1, int var2);

    public void storeSwdlCopy();

    public void clearSwdlCopy();
}

