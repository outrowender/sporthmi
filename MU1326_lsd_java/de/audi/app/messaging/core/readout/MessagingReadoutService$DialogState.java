/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService$1;

public final class MessagingReadoutService$DialogState {
    private final boolean isActive;
    private final boolean messageAutoSelected;

    private MessagingReadoutService$DialogState(boolean bl, boolean bl2) {
        this.isActive = bl;
        this.messageAutoSelected = bl2;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean messageAutoSelected() {
        return this.messageAutoSelected;
    }

    /* synthetic */ MessagingReadoutService$DialogState(boolean bl, boolean bl2, MessagingReadoutService$1 messagingReadoutService$1) {
        this(bl, bl2);
    }
}

