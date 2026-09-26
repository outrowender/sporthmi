/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands;

import de.audi.app.addressbook.core.common.commands.ADBDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.ProfileInfo;

class ADBDSIListener$39
extends CommandResponse {
    private final /* synthetic */ ProfileInfo[] val$profileInfo;
    private final /* synthetic */ int val$indexOfActiveProfile;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ ADBDSIListener this$0;

    ADBDSIListener$39(ADBDSIListener aDBDSIListener, ProfileInfo[] profileInfoArray, int n, int n2) {
        this.this$0 = aDBDSIListener;
        this.val$profileInfo = profileInfoArray;
        this.val$indexOfActiveProfile = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIAdbUserProfileListener)dSIListener).updateProfileInfo(this.val$profileInfo, this.val$indexOfActiveProfile, this.val$validFlag);
    }
}

