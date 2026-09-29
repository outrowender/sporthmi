/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.tghu.smi.SMI;

class SMI$SyncEventQueueElement {
    public int sourceTerminalID;
    public int syncEventID;
    private final /* synthetic */ SMI this$0;

    public SMI$SyncEventQueueElement(SMI sMI, int n, int n2) {
        this.this$0 = sMI;
        this.sourceTerminalID = n;
        this.syncEventID = n2;
    }
}

