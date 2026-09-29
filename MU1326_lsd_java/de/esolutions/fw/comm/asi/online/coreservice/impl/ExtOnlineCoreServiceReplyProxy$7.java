/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSLSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;

class ExtOnlineCoreServiceReplyProxy$7
implements ISerializable {
    private final /* synthetic */ OSRNotifyPropertiesSL[] val$props;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$7(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$props = oSRNotifyPropertiesSLArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRNotifyPropertiesSLSerializer.putOptionalOSRNotifyPropertiesSLVarArray(iSerializer, this.val$props);
    }
}

