/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.indication;

import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.util.Collections;
import de.audi.app.messaging.core.util.IFormatter;
import java.util.Collection;

class NewMessageIndicationManager$1
implements IFormatter {
    private final /* synthetic */ NewMessageIndicationManager this$0;

    NewMessageIndicationManager$1(NewMessageIndicationManager newMessageIndicationManager) {
        this.this$0 = newMessageIndicationManager;
    }

    @Override
    public String format(Object object) {
        return Collections.toString((Collection)object);
    }
}

