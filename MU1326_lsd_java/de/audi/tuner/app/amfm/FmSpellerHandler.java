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
import de.audi.tuner.app.amfm.FmSpellerHandler$FmUpListener;
import de.audi.tuner.ifc.IScanHandler;
import org.dsi.ifc.radio.WavebandInfo;

public class FmSpellerHandler
extends AbstractAmFmSpellerHandler {
    public FmSpellerHandler$FmUpListener fmUpListener = new FmSpellerHandler$FmUpListener(this, null);
    private int lowerLimitMhz;

    public FmSpellerHandler(TunerBasics tunerBasics, AMFMTuner aMFMTuner, IScanHandler iScanHandler) {
        super(tunerBasics.getModels().getMatchspellerModel(210305280), tunerBasics.getModels().getChoiceModel(243859712), aMFMTuner, iScanHandler);
    }

    @Override
    public String appendComma(String string) {
        int n;
        int n2 = n = string.length() > 0 ? Integer.parseInt(string) : 0;
        if (this.kommaPos != -1 || n < this.lowerLimitMhz) {
            return string;
        }
        int[] nArray = this.getValidNextDigitsForPrefix(n);
        if (nArray.length > 0) {
            boolean bl = true;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n3 = nArray[i2];
                if (this.getValidNextDigitsForPrefix(n * 10 + n3).length <= 0) continue;
                bl = false;
            }
            if (bl) {
                String string2 = new StringBuffer().append(string).append('.').toString();
                this.spellerModel.setText(string2);
                this.kommaPos = string.length();
                return string2;
            }
        }
        return string;
    }

    @Override
    protected void processWavebandInfo(WavebandInfo wavebandInfo) {
        this.lowerLimitMhz = this.cutOffTrailingDigits((int)wavebandInfo.lowerLimit) / 10;
    }

    @Override
    protected int cutOffTrailingDigits(int n) {
        return n / 100;
    }

    @Override
    public int getWaveband() {
        return 1;
    }

    @Override
    protected void setStationFromFrequency(String string) {
        if (this.kommaPos != -1 && string.length() > this.kommaPos + 1) {
            this.station = new AMFMStation();
            this.station.pi = -1;
            this.station.waveband = 1;
            if (this.hdPos != -1) {
                int n = this.hdPos + " HD".length() < string.length() ? Integer.parseInt(string.substring(this.hdPos + " HD".length())) : 1;
                double d2 = Double.parseDouble((String)string.substring(0, this.hdPos));
                this.station.frequency = (int)(d2 * 1000.0);
                this.station.serviceId = 1 << n - 1;
                this.station.hd = true;
            } else {
                double d3 = Double.parseDouble((String)string);
                this.station.frequency = (int)(d3 * 1000.0);
            }
        } else {
            this.station = null;
        }
    }
}

