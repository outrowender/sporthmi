/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.ICompositionValidator;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.util.Strings;

final class NewMessage$1
implements ICompositionValidator {
    NewMessage$1() {
    }

    @Override
    public boolean isValid(NewMessage newMessage) {
        boolean bl = !newMessage.getSelectedRecipientList().isEmpty();
        boolean bl2 = !Strings.isNullOrEmpty(newMessage.getBody());
        boolean bl3 = newMessage.getAttachments().length > 0;
        return bl && (bl2 || bl3);
    }
}

