/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.recipients.RecipientListRow;

public interface ISelectedRecipientListObserver {
    default public void indicateRecipientsCleared() {
    }

    default public void indicateRecipientsAdded(RecipientListRow[] recipientListRowArray) {
    }

    default public void indicateRecipientsRemoved(RecipientListRow[] recipientListRowArray) {
    }
}

