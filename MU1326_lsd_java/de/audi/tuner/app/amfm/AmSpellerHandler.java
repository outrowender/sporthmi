/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.ifc.IScanHandler;
import org.dsi.ifc.radio.WavebandInfo;

public class AmSpellerHandler
extends AbstractAmFmSpellerHandler {
    public AmUpListener amUpListener = new AmUpListener();
    private double lowerLimit = -1.0;
    private double upperLimit = -1.0;

    public AmSpellerHandler(TunerBasics tunerBasics, AMFMTuner aMFMTuner, IScanHandler iScanHandler) {
        super(tunerBasics.getModels().getMatchspellerModel(100635), tunerBasics.getModels().getChoiceModel(100622), aMFMTuner, iScanHandler);
    }

    public String appendComma(String string) {
        return string;
    }

    protected void processWavebandInfo(WavebandInfo wavebandInfo) {
        this.lowerLimit = wavebandInfo.getLowerLimit();
        this.upperLimit = wavebandInfo.getUpperLimit();
    }

    protected int cutOffTrailingDigits(int n) {
        return n;
    }

    public int getWaveband() {
        return 3;
    }

    protected void setStationFromFrequency(String string) {
        this.station = null;
        if (string.length() > 0) {
            if (this.hdPos != -1) {
                int n = this.hdPos + " HD".length() < string.length() ? Integer.parseInt(string.substring(this.hdPos + " HD".length())) : 1;
                double d2 = Double.parseDouble(string.substring(0, this.hdPos));
                this.station = new AMFMStation();
                this.station.waveband = 3;
                this.station.pi = -1;
                this.station.frequency = (int)d2;
                this.station.serviceId = 1 << n - 1;
                this.station.hd = true;
            } else {
                double d3 = Double.parseDouble(string);
                if (this.lowerLimit != -1.0 && d3 >= this.lowerLimit && this.upperLimit != -1.0 && d3 <= this.upperLimit) {
                    this.station = new AMFMStation();
                    this.station.waveband = 3;
                    this.station.pi = -1;
                    this.station.frequency = (int)d3;
                }
            }
        }
    }

    private class AmUpListener
    extends AMFMDsiUpInfo {
        private AmUpListener() {
        }

        public void updateStationListAM(AMFMStation[] aMFMStationArray) {
            AmSpellerHandler.this.buildHdPostfixMap(aMFMStationArray);
        }
    }
}

