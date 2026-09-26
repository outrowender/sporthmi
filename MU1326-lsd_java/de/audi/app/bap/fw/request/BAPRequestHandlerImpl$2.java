/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.request;

import de.audi.app.bap.fw.request.BAPRequestHandlerImpl;

class BAPRequestHandlerImpl$2
implements Runnable {
    private final /* synthetic */ int val$lsgID;
    private final /* synthetic */ int val$fctID;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ byte[] val$data;
    private final /* synthetic */ BAPRequestHandlerImpl this$0;

    BAPRequestHandlerImpl$2(BAPRequestHandlerImpl bAPRequestHandlerImpl, int n, int n2, int n3, byte[] byArray) {
        this.this$0 = bAPRequestHandlerImpl;
        this.val$lsgID = n;
        this.val$fctID = n2;
        this.val$requestType = n3;
        this.val$data = byArray;
    }

    @Override
    public void run() {
        BAPRequestHandlerImpl.access$000(this.this$0).getDSIBAPController().requestByteSequence(this.val$lsgID, this.val$fctID, this.val$requestType, this.val$data);
    }
}

