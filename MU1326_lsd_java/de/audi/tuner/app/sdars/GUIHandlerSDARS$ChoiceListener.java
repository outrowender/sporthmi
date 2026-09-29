/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.sdars.GUIHandlerSDARS;
import de.audi.tuner.app.sdars.GUIHandlerSDARS$1;

class GUIHandlerSDARS$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ GUIHandlerSDARS this$0;

    private GUIHandlerSDARS$ChoiceListener(GUIHandlerSDARS gUIHandlerSDARS) {
        this.this$0 = gUIHandlerSDARS;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 100583: {
                GUIHandlerSDARS.access$100(this.this$0).getChoiceModel(n).setValue(n2);
                GUIHandlerSDARS.access$200(this.this$0).setSortAlgo(n2);
                GUIHandlerSDARS.access$300(this.this$0).setSortAlgo(n2);
                GUIHandlerSDARS.access$400(this.this$0).valueUpdated(n2, 2);
                break;
            }
            case 100420: {
                GUIHandlerSDARS.access$100(this.this$0).getChoiceModel(n4, n).setValue(n2);
                GUIHandlerSDARS.access$400(this.this$0).valueUpdated(n2, 4);
                break;
            }
            case 100653: {
                GUIHandlerSDARS.access$100(this.this$0).getChoiceModel(n4, n).setValue(n2);
                GUIHandlerSDARS.access$400(this.this$0).valueUpdated(n2, 3);
                break;
            }
        }
    }

    /* synthetic */ GUIHandlerSDARS$ChoiceListener(GUIHandlerSDARS gUIHandlerSDARS, GUIHandlerSDARS$1 gUIHandlerSDARS$1) {
        this(gUIHandlerSDARS);
    }
}

