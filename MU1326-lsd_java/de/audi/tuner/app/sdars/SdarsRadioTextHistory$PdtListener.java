/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory$1;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.esolutions.fw.util.commons.Buffer;

class SdarsRadioTextHistory$PdtListener
implements IPdtListener {
    private final /* synthetic */ SdarsRadioTextHistory this$0;

    private SdarsRadioTextHistory$PdtListener(SdarsRadioTextHistory sdarsRadioTextHistory) {
        this.this$0 = sdarsRadioTextHistory;
    }

    @Override
    public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
        if (n == SdarsRadioTextHistory.access$400(this.this$0) && sdarsRadioText != null) {
            Buffer buffer = new Buffer(200);
            buffer.append(sdarsRadioText.longArtistName).append("\n");
            buffer.append(sdarsRadioText.longProgramTitle).append("\n");
            buffer.append(sdarsRadioText.composer);
            String string = buffer.toString();
            SdarsRadioTextHistory.access$500(this.this$0, string);
        }
    }

    /* synthetic */ SdarsRadioTextHistory$PdtListener(SdarsRadioTextHistory sdarsRadioTextHistory, SdarsRadioTextHistory$1 sdarsRadioTextHistory$1) {
        this(sdarsRadioTextHistory);
    }
}

