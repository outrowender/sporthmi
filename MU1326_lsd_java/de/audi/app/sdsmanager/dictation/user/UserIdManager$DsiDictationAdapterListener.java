/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.user.UserIdManager;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$1;

class UserIdManager$DsiDictationAdapterListener
extends DsiDictationAdapterEmptyListener {
    private final /* synthetic */ UserIdManager this$0;

    private UserIdManager$DsiDictationAdapterListener(UserIdManager userIdManager) {
        this.this$0 = userIdManager;
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
        UserIdManager.access$301(this.this$0).log(-2137614336, "[UserIdManager$DsiDictationAdapterListener#updateDsiAvailability] dsiAvailable = %1", bl);
        UserIdManager.access$402(this.this$0, bl);
        if (bl) {
            UserIdManager.access$500(this.this$0);
        }
    }

    /* synthetic */ UserIdManager$DsiDictationAdapterListener(UserIdManager userIdManager, UserIdManager$1 userIdManager$1) {
        this(userIdManager);
    }
}

