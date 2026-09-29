/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRUser;

class OnlineServiceRegistrationListener$21
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ String val$pathToFolder;
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ String val$domain;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$21(OnlineServiceRegistrationListener onlineServiceRegistrationListener, int n, String string, OSRUser oSRUser, String string2) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$result = n;
        this.val$pathToFolder = string;
        this.val$user = oSRUser;
        this.val$domain = string2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).getProfileFolderResponse(this.val$result, this.val$pathToFolder, this.val$user, this.val$domain);
    }
}

