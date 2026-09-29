/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.tuner.app.gracenote.IGracenoteResponse;
import de.audi.tuner.app.gracenote.RadioGracenote;
import de.audi.tuner.app.gracenote.RadioGracenote$1;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.DSIMetadataServiceListener;

class RadioGracenote$GracenoteListener
implements DSIMetadataServiceListener {
    private final /* synthetic */ RadioGracenote this$0;

    private RadioGracenote$GracenoteListener(RadioGracenote radioGracenote) {
        this.this$0 = radioGracenote;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateOnlineLookupStatus(int n, int n2) {
        RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(-2137614336, "[DSIMetadataServiceListener.updateOnlineLookupStatus] %1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                if (n != 0) {
                    RadioGracenote.access$502(this.this$0, n == 1);
                    RadioGracenote.access$600(this.this$0).getChoiceModel(-460848896).setValue(RadioGracenote.access$500(this.this$0) ? 1 : 0);
                    RadioGracenote.access$700(this.this$0).storeGracenoteOnlineLookup(RadioGracenote.access$500(this.this$0));
                }
                RadioGracenote.access$800(this.this$0).updateOnlineLookupStatus(n);
            }
            catch (Exception exception) {
                RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(10000, "[DSIMetadataServiceListener.updateOnlineLookupStatus]", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void responseCoverArt(int n, ResourceLocator resourceLocator) {
        IGracenoteResponse iGracenoteResponse;
        RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(-2137614336, "[DSIMetadataServiceListener.responseCoverArt] job %2, %1", (Object)resourceLocator, (long)n);
        Object object = RadioGracenote.access$900(this.this$0);
        synchronized (object) {
            iGracenoteResponse = (IGracenoteResponse)RadioGracenote.access$1000(this.this$0).get(n);
            RadioGracenote.access$1000(this.this$0).remove(n);
        }
        if (iGracenoteResponse != null) {
            iGracenoteResponse.setCoverArt(n, resourceLocator);
        } else {
            RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(10000, "no destination for jobId %1 found", (long)n);
        }
    }

    /* synthetic */ RadioGracenote$GracenoteListener(RadioGracenote radioGracenote, RadioGracenote$1 radioGracenote$1) {
        this(radioGracenote);
    }
}

