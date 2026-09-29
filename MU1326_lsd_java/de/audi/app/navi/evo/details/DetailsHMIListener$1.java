/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.details;

import de.audi.app.navi.evo.details.DetailsHMIListener;
import de.audi.atip.phone.ITelServiceListener;

class DetailsHMIListener$1
implements ITelServiceListener {
    private final /* synthetic */ int val$modelID;
    private final /* synthetic */ DetailsHMIListener this$0;

    DetailsHMIListener$1(DetailsHMIListener detailsHMIListener, int n) {
        this.this$0 = detailsHMIListener;
        this.val$modelID = n;
    }

    @Override
    public void dialNumberResponse(int n) {
        this.this$0.logChannel.log(-2137614336, "%1#dialNumberResponse( %2 )", (Object)this.this$0.CLASS_NAME, (long)n);
        if (n == 0) {
            this.this$0.logChannel.log(-2137614336, "%1#dialNumberResponse() - fire model event, modelID: %2", (Object)this.this$0.CLASS_NAME, (long)this.val$modelID);
        } else {
            this.this$0.logChannel.log(10000, "%1#dialNumberResponse( %2 ) - dial was not successful", (Object)this.this$0.CLASS_NAME, (long)n);
        }
    }
}

