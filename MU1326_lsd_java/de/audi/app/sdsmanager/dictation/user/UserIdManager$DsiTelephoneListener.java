/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import de.audi.app.sdsmanager.dictation.user.DsiTelephoneEmptyListener;
import de.audi.app.sdsmanager.dictation.user.UserIdManager;
import de.audi.app.sdsmanager.dictation.user.UserIdManager$1;
import org.dsi.ifc.telephone.PhoneInformation;

final class UserIdManager$DsiTelephoneListener
extends DsiTelephoneEmptyListener {
    private final /* synthetic */ UserIdManager this$0;

    private UserIdManager$DsiTelephoneListener(UserIdManager userIdManager) {
        this.this$0 = userIdManager;
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if (n != 1 && UserIdManager.access$1400(this.this$0).isInfo()) {
            UserIdManager.access$1500(this.this$0).log(1078071040, "[UserIdManager#updatePhoneInformation] validFlag = %1", (long)n);
        } else if (n == 1) {
            String string;
            String string2 = string = phoneInformation != null ? phoneInformation.getImsi() : null;
            if (UserIdManager.access$1600(this.this$0).isInfo()) {
                UserIdManager.access$1700(this.this$0).log(1078071040, "[UserIdManager#updatePhoneInformation] validFlag = %1, phoneInformation.getImsi() = %2", (Object)String.valueOf(n), (Object)String.valueOf(string));
            }
            UserIdManager.access$1800(this.this$0, string);
        }
    }

    /* synthetic */ UserIdManager$DsiTelephoneListener(UserIdManager userIdManager, UserIdManager$1 userIdManager$1) {
        this(userIdManager);
    }
}

