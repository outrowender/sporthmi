/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRServiceState;

class ExtOnlineCoreServiceReplyProxy$10
implements ISerializable {
    private final /* synthetic */ OSRServiceState[] val$serviceState;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$10(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, OSRServiceState[] oSRServiceStateArray) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$serviceState = oSRServiceStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRServiceStateSerializer.putOptionalOSRServiceStateVarArray(iSerializer, this.val$serviceState);
    }
}

