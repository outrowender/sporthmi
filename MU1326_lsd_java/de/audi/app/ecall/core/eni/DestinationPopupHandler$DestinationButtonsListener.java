/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.app.ecall.core.eni.DestinationPopupHandler;
import de.audi.app.ecall.core.eni.DestinationPopupHandler$1;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.interapp.NavigationUtilities;

class DestinationPopupHandler$DestinationButtonsListener
extends DefaultButtonListener {
    private final /* synthetic */ DestinationPopupHandler this$0;

    private DestinationPopupHandler$DestinationButtonsListener(DestinationPopupHandler destinationPopupHandler) {
        this.this$0 = destinationPopupHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        DestinationPopupHandler.access$100(this.this$0).log(1078071040, "DestinationPopupHandler.ButtonsListener#keyTyped(): modelId = %1", (long)n);
        if (n == DestinationPopupHandler.access$200(this.this$0).getID()) {
            int n4 = NavigationUtilities.degreeToWgs84((double)DestinationPopupHandler.access$300(this.this$0).getLongitude() / 1000000.0);
            int n5 = NavigationUtilities.degreeToWgs84((double)DestinationPopupHandler.access$300(this.this$0).getLatitude() / 1000000.0);
            DestinationPopupHandler.access$400(this.this$0).startRouteGuidance(n4, n5);
            DestinationPopupHandler.access$200(this.this$0).fireEvent(0);
        } else if (n == DestinationPopupHandler.access$500(this.this$0).getID()) {
            DestinationPopupHandler.access$500(this.this$0).fireEvent(0);
        }
    }

    /* synthetic */ DestinationPopupHandler$DestinationButtonsListener(DestinationPopupHandler destinationPopupHandler, DestinationPopupHandler$1 destinationPopupHandler$1) {
        this(destinationPopupHandler);
    }
}

