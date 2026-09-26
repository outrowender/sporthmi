/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import java.util.Comparator;

class SourceListHandler$1
implements Comparator {
    private final /* synthetic */ SourceListHandler this$0;

    SourceListHandler$1(SourceListHandler sourceListHandler) {
        this.this$0 = sourceListHandler;
    }

    @Override
    public int compare(Object object, Object object2) {
        return new Integer(((CombiBAPAudioSource)object).getPosID()).compareTo(new Integer(((CombiBAPAudioSource)object2).getPosID()));
    }
}

