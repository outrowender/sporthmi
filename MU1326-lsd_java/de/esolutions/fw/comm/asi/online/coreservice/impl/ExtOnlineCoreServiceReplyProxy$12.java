/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRUser;

class ExtOnlineCoreServiceReplyProxy$12
implements ISerializable {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ int val$updateControl;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$12(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, OSRUser oSRUser, int n) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$user = oSRUser;
        this.val$updateControl = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRUserSerializer.putOptionalOSRUser(iSerializer, this.val$user);
        iSerializer.putInt32(this.val$updateControl);
    }
}

