/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.esolutions.fw.util.commons.Buffer;

public class SdarsRadioTextHistory
extends RadioTextHistory {
    final SDARSDsiUpInfo dsiUpInfo = new DsiUpListener();
    final SDARSDsiDownInfo dsiDownInfo = new DsiDownListener();
    private final IPdtListener pdtListener = new PdtListener();
    private final PdtInfoHandler pdtHandler;
    private int sID;

    public SdarsRadioTextHistory(TunerBasics tunerBasics, PdtInfoHandler pdtInfoHandler, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        super(tunerBasics, radiotextHyperlinkProcessor, 100717, 100718, 100158, "SDARS", tunerBasics.getLogger().sdarsDSI);
        this.pdtHandler = pdtInfoHandler;
    }

    private void updateStation(int n) {
        if (this.sID != n) {
            this.pdtHandler.removeListener(this.sID, this.pdtListener);
            this.sID = n;
            this.reset(true);
            this.pdtHandler.addListener(this.sID, this.pdtListener, 0);
        }
    }

    private class PdtListener
    implements IPdtListener {
        private PdtListener() {
        }

        public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
            if (n == SdarsRadioTextHistory.this.sID && sdarsRadioText != null) {
                Buffer buffer = new Buffer(200);
                buffer.append(sdarsRadioText.longArtistName).append("\n");
                buffer.append(sdarsRadioText.longProgramTitle).append("\n");
                buffer.append(sdarsRadioText.composer);
                String string = buffer.toString();
                SdarsRadioTextHistory.this.updateRadioText(string);
            }
        }
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            SdarsRadioTextHistory.this.updateStation(stationInfoExt.sID);
        }
    }

    private class DsiDownListener
    extends SDARSDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(StationInfoExt stationInfoExt) {
            SdarsRadioTextHistory.this.updateStation(stationInfoExt.sID);
        }
    }
}

