/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.RadioSearchDataProvider;
import de.audi.app.tuner.truffles.RadioSearchDataProvider$1;
import de.audi.tuner.ifc.ISearchBreak;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

class RadioSearchDataProvider$SearchBreakListener
implements ISearchBreak {
    private final /* synthetic */ RadioSearchDataProvider this$0;

    private RadioSearchDataProvider$SearchBreakListener(RadioSearchDataProvider radioSearchDataProvider) {
        this.this$0 = radioSearchDataProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cursorInSearchResult(boolean bl) {
        if (bl) {
            SimpleIntIntMap simpleIntIntMap = RadioSearchDataProvider.access$400(this.this$0);
            synchronized (simpleIntIntMap) {
                RadioSearchDataProvider.access$502(this.this$0, true);
            }
        }
        SimpleIntIntMap simpleIntIntMap = RadioSearchDataProvider.access$400(this.this$0);
        synchronized (simpleIntIntMap) {
            int[] nArray = RadioSearchDataProvider.access$400(this.this$0).getKeys();
            RadioSearchDataProvider.access$400(this.this$0).clear();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                RadioSearchDataProvider.access$600(this.this$0, nArray[i2]);
            }
            RadioSearchDataProvider.access$502(this.this$0, false);
        }
    }

    /* synthetic */ RadioSearchDataProvider$SearchBreakListener(RadioSearchDataProvider radioSearchDataProvider, RadioSearchDataProvider$1 radioSearchDataProvider$1) {
        this(radioSearchDataProvider);
    }
}

