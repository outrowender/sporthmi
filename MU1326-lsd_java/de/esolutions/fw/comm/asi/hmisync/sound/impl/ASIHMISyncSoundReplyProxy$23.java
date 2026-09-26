/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeValue;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.SoundShapeValueSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncSoundReplyProxy$23
implements ISerializable {
    private final /* synthetic */ SoundShapeValue val$SoundShapeValue;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncSoundReplyProxy this$0;

    ASIHMISyncSoundReplyProxy$23(ASIHMISyncSoundReplyProxy aSIHMISyncSoundReplyProxy, SoundShapeValue soundShapeValue, boolean bl) {
        this.this$0 = aSIHMISyncSoundReplyProxy;
        this.val$SoundShapeValue = soundShapeValue;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SoundShapeValueSerializer.putOptionalSoundShapeValue(iSerializer, this.val$SoundShapeValue);
        iSerializer.putBool(this.val$isValid);
    }
}

