/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.OAuthToken;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.OAuthTokenSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$13
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ OAuthToken val$token;
    private final /* synthetic */ String val$serviceID;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$13(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, OAuthToken oAuthToken, String string) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$result = n;
        this.val$token = oAuthToken;
        this.val$serviceID = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$result);
        OAuthTokenSerializer.putOptionalOAuthToken(iSerializer, this.val$token);
        iSerializer.putOptionalString(this.val$serviceID);
    }
}

