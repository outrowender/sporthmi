/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.ISelectedRecipientListObserver;
import de.audi.app.messaging.core.recipients.RecipientListRow;

public class ISelectedRecipientListObserver$EmptyImplementation
implements ISelectedRecipientListObserver {
    @Override
    public void indicateRecipientsCleared() {
    }

    @Override
    public void indicateRecipientsAdded(RecipientListRow[] recipientListRowArray) {
    }

    @Override
    public void indicateRecipientsRemoved(RecipientListRow[] recipientListRowArray) {
    }
}

