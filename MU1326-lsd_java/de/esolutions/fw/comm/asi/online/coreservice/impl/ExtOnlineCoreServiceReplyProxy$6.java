/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRNotifyProperties;

class ExtOnlineCoreServiceReplyProxy$6
implements ISerializable {
    private final /* synthetic */ OSRNotifyProperties[] val$disableReasons;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$6(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$disableReasons = oSRNotifyPropertiesArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRNotifyPropertiesSerializer.putOptionalOSRNotifyPropertiesVarArray(iSerializer, this.val$disableReasons);
    }
}

