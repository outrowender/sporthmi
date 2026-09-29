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
    default public CarFuncAdap getCarFuncAdaptation() {
    }

    default public Adaptation getAdaptationANP() {
    }

    default public LoadSpeedThreshold getSpeedThresholdUPDL() {
    }

    default public Coding getCarCoding() {
    }

    default public SperrFlags getSperrFlags() {
    }

    default public String dumpCarData() {
    }

    default public IVariantInfo getVariantInfo() {
    }

    default public void storeSwdlCopy() {
    }

    default public void clearSwdlCopy() {
    }
}

