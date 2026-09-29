/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.request;

import de.audi.app.bap.fw.request.BAPRequestHandlerImpl;

class BAPRequestHandlerImpl$3
implements Runnable {
    private final /* synthetic */ int val$lsgID;
    private final /* synthetic */ int val$fctID;
    private final /* synthetic */ int val$dataType;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ int val$data;
    private final /* synthetic */ BAPRequestHandlerImpl this$0;

    BAPRequestHandlerImpl$3(BAPRequestHandlerImpl bAPRequestHandlerImpl, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = bAPRequestHandlerImpl;
        this.val$lsgID = n;
        this.val$fctID = n2;
        this.val$dataType = n3;
        this.val$requestType = n4;
        this.val$data = n5;
    }

    @Override
    public void run() {
        BAPRequestHandlerImpl.access$000(this.this$0).getDSIBAPController().request(this.val$lsgID, this.val$fctID, this.val$dataType, this.val$requestType, this.val$data);
    }
}

