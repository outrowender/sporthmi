/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.accounts.IAccountManagerListener$DefaultAccountManagerListener;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.dictation.MessagingDictationService$1;
import de.audi.app.messaging.core.dictation.MessagingDictationService$AccountManagerListener$1;

final class MessagingDictationService$AccountManagerListener
extends IAccountManagerListener$DefaultAccountManagerListener {
    private final /* synthetic */ MessagingDictationService this$0;

    private MessagingDictationService$AccountManagerListener(MessagingDictationService messagingDictationService) {
        this.this$0 = messagingDictationService;
    }

    @Override
    public void selectedAccountChanged() {
        MessagingDictationService.access$8100(this.this$0).getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$AccountManagerListener$1(this));
    }

    /* synthetic */ MessagingDictationService$AccountManagerListener(MessagingDictationService messagingDictationService, MessagingDictationService$1 messagingDictationService$1) {
        this(messagingDictationService);
    }

    static /* synthetic */ MessagingDictationService access$7800(MessagingDictationService$AccountManagerListener messagingDictationService$AccountManagerListener) {
        return messagingDictationService$AccountManagerListener.this$0;
    }
}

