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
    default public int getSysConst(int n) {
    }

    default public String dumpCarData() {
    }

    default public Coding getCarCoding() {
    }

    default public Adaptation getAdaptationANP() {
    }

    default public CarFuncAdap getCarFuncAdaptation() {
    }

    default public LoadSpeedThreshold getSpeedThresholdUPDL() {
    }

    default public SperrFlags getSperrFlags() {
    }

    default public IVariantInfo getVariantInfo() {
    }

    default public void initSysConstants(SimpleIntIntMap simpleIntIntMap, ICodingReader iCodingReader) {
    }

    default public int getHMIInternalPopupPrio(int n, int n2) {
    }

    default public void storeSwdlCopy() {
    }

    default public void clearSwdlCopy() {
    }
}

