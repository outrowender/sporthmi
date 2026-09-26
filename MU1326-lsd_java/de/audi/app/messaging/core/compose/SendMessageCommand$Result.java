/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.SendMessageCommand;
import de.audi.app.messaging.core.compose.SendMessageCommand$1;

public final class SendMessageCommand$Result {
    private final int resultCode;
    private final int[] indicationResultCodes;
    private final /* synthetic */ SendMessageCommand this$0;

    private SendMessageCommand$Result(SendMessageCommand sendMessageCommand, int n, int[] nArray) {
        this.this$0 = sendMessageCommand;
        this.resultCode = n;
        this.indicationResultCodes = nArray;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public int[] getIndicationResultCodes() {
        return this.indicationResultCodes;
    }

    /* synthetic */ SendMessageCommand$Result(SendMessageCommand sendMessageCommand, int n, int[] nArray, SendMessageCommand$1 sendMessageCommand$1) {
        this(sendMessageCommand, n, nArray);
    }
}

