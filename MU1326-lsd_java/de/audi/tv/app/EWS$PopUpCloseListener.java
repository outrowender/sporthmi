/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.EWS;
import de.audi.tv.app.EWS$1;

class EWS$PopUpCloseListener
extends DefaultButtonListener {
    private final /* synthetic */ EWS this$0;

    private EWS$PopUpCloseListener(EWS eWS) {
        this.this$0 = eWS;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 2600150: {
                Object object = EWS.access$500(this.this$0);
                synchronized (object) {
                    if (EWS.access$400(this.this$0).getStatus() != 0) {
                        EWS.access$300(this.this$0).log(-2137614336, "[EWS.PopUpCloseListener.keyPressed] popup closed (timeout)");
                        EWS.access$400(this.this$0).setStatus(1);
                        EWS.access$400(this.this$0).setStatus(0);
                        this.this$0.showNextEWSPopup();
                    }
                    break;
                }
            }
            case 2600155: {
                Object object = EWS.access$500(this.this$0);
                synchronized (object) {
                    EWS.access$300(this.this$0).log(-2137614336, "[EWS.PopUpCloseListener.keyPressed] popup closed");
                    EWS.access$400(this.this$0).setStatus(1);
                    EWS.access$400(this.this$0).setStatus(0);
                    this.this$0.showNextEWSPopup();
                    break;
                }
            }
            case 2600178: {
                Object object = EWS.access$500(this.this$0);
                synchronized (object) {
                    EWS.access$600(this.this$0).showDetails();
                    break;
                }
            }
            case 2600179: {
                Object object = EWS.access$500(this.this$0);
                synchronized (object) {
                    EWS.access$600(this.this$0).showAreaList();
                    break;
                }
            }
            default: {
                throw new IllegalArgumentException("Unsupported modelID");
            }
        }
    }

    /* synthetic */ EWS$PopUpCloseListener(EWS eWS, EWS$1 eWS$1) {
        this(eWS);
    }
}

