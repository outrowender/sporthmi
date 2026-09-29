/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSLabels;
import de.audi.tuner.app.sdars.SDARSLabels$1;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.listener.IPdtListener;
import de.esolutions.fw.util.commons.Buffer;

class SDARSLabels$PdtListener
implements IPdtListener {
    private final /* synthetic */ SDARSLabels this$0;

    private SDARSLabels$PdtListener(SDARSLabels sDARSLabels) {
        this.this$0 = sDARSLabels;
    }

    @Override
    public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
        SDARSLabels.access$600(this.this$0).setPdt(sdarsRadioText);
        if (n == SDARSLabels.access$500((SDARSLabels)this.this$0).sID && sdarsRadioText != null) {
            SDARSLabels.access$702(this.this$0, sdarsRadioText);
            SDARSLabels.access$400(this.this$0).getLabelModel(-41484032).setText(sdarsRadioText.longArtistName);
            SDARSLabels.access$400(this.this$0).getLabelModel(-7929600).setText(sdarsRadioText.longProgramTitle);
            SDARSLabels.access$400(this.this$0).getResourceLocatorModel(327811328).setResourceLocator(sdarsRadioText.getCoverArt());
            Buffer buffer = new Buffer(200);
            buffer.append(sdarsRadioText.longArtistName).append("\n");
            buffer.append(sdarsRadioText.longProgramTitle).append("\n");
            buffer.append(sdarsRadioText.composer);
            String string = buffer.toString();
            SDARSLabels.access$400(this.this$0).getLabelModel(1015480576).setText(string);
        } else {
            SDARSLabels.access$702(this.this$0, null);
            SDARSLabels.access$400(this.this$0).getLabelModel(-41484032).setText("");
            SDARSLabels.access$400(this.this$0).getLabelModel(-7929600).setText("");
            SDARSLabels.access$400(this.this$0).getResourceLocatorModel(327811328).setResourceLocator(ISimpleTuner.EMPTY_RL);
            SDARSLabels.access$400(this.this$0).getLabelModel(1015480576).setText("");
        }
        this.this$0.propagateUpdatedActiveStation(7);
    }

    /* synthetic */ SDARSLabels$PdtListener(SDARSLabels sDARSLabels, SDARSLabels$1 sDARSLabels$1) {
        this(sDARSLabels);
    }
}

