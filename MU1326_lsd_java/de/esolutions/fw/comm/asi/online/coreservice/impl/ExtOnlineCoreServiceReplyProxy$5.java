/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ServiceListEntry;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ServiceListEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$5
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ ServiceListEntry val$serviceListEntry;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$5(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, ServiceListEntry serviceListEntry) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$result = n;
        this.val$serviceListEntry = serviceListEntry;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$result);
        ServiceListEntrySerializer.putOptionalServiceListEntry(iSerializer, this.val$serviceListEntry);
    }
}

