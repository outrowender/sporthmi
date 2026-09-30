/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp.carcoding;

import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.IVariantInfo;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import de.audi.atip.sysapp.carcoding.SperrFlags;

public interface ICodingReader {
    public CarFuncAdap getCarFuncAdaptation();

    public Adaptation getAdaptationANP();

    public LoadSpeedThreshold getSpeedThresholdUPDL();

    public Coding getCarCoding();

    public SperrFlags getSperrFlags();

    public String dumpCarData();

    public IVariantInfo getVariantInfo();

    public void storeSwdlCopy();

    public void clearSwdlCopy();
}

