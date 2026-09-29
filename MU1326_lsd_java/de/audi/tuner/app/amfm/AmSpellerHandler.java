/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;
import de.audi.tuner.app.amfm.AmSpellerHandler$AmUpListener;
import de.audi.tuner.ifc.IScanHandler;
import org.dsi.ifc.radio.WavebandInfo;

public class AmSpellerHandler
extends AbstractAmFmSpellerHandler {
    public AmSpellerHandler$AmUpListener amUpListener = new AmSpellerHandler$AmUpListener(this, null);
    private double lowerLimit = -1.0;
    private double upperLimit = -1.0;

    public AmSpellerHandler(TunerBasics tunerBasics, AMFMTuner aMFMTuner, IScanHandler iScanHandler) {
        super(tunerBasics.getModels().getMatchspellerModel(461963520), tunerBasics.getModels().getChoiceModel(243859712), aMFMTuner, iScanHandler);
    }

    @Override
    public String appendComma(String string) {
        return string;
    }

    @Override
    protected void processWavebandInfo(WavebandInfo wavebandInfo) {
        this.lowerLimit = wavebandInfo.getLowerLimit();
        this.upperLimit = wavebandInfo.getUpperLimit();
    }

    @Override
    protected int cutOffTrailingDigits(int n) {
        return n;
    }

    @Override
    public int getWaveband() {
        return 3;
    }

    @Override
    protected void setStationFromFrequency(String string) {
        this.station = null;
        if (string.length() > 0) {
            if (this.hdPos != -1) {
                int n = this.hdPos + " HD".length() < string.length() ? Integer.parseInt(string.substring(this.hdPos + " HD".length())) : 1;
                double d2 = Double.parseDouble((String)string.substring(0, this.hdPos));
                this.station = new AMFMStation();
                this.station.waveband = 3;
                this.station.pi = -1;
                this.station.frequency = (int)d2;
                this.station.serviceId = 1 << n - 1;
                this.station.hd = true;
            } else {
                double d3 = Double.parseDouble((String)string);
                if (this.lowerLimit != -1.0 && d3 >= this.lowerLimit && this.upperLimit != -1.0 && d3 <= this.upperLimit) {
                    this.station = new AMFMStation();
                    this.station.waveband = 3;
                    this.station.pi = -1;
                    this.station.frequency = (int)d3;
                }
            }
        }
    }
}

