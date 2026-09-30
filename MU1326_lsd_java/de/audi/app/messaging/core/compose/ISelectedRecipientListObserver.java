/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.recipients.RecipientListRow;

public interface ISelectedRecipientListObserver {
    public void indicateRecipientsCleared();

    public void indicateRecipientsAdded(RecipientListRow[] var1);

    public void indicateRecipientsRemoved(RecipientListRow[] var1);

    public static class EmptyImplementation
    implements ISelectedRecipientListObserver {
        public void indicateRecipientsCleared() {
        }

        public void indicateRecipientsAdded(RecipientListRow[] recipientListRowArray) {
        }

        public void indicateRecipientsRemoved(RecipientListRow[] recipientListRowArray) {
        }
    }
}

