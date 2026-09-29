/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;
import java.util.HashMap;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;

class SeekActiveContentHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$DsiUpListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        SeekActiveContentHandler.access$1302(this.this$0, stationInfoExt);
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        if (SeekActiveContentHandler.access$1700(this.this$0) != null && SeekActiveContentHandler.access$1100(this.this$0)) {
            SeekActiveContentHandler.access$1102(this.this$0, false);
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                SeekEntry seekEntry = seekEntryArray[i2];
                if (SeekActiveContentHandler.access$1700(this.this$0).containsKey(new Integer(seekEntry.getSeekID()))) continue;
                SeekActiveContentHandler.access$1800(this.this$0, seekEntry);
                break;
            }
        }
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < seekEntryArray.length; ++i3) {
            SeekEntry seekEntry = seekEntryArray[i3];
            hashMap.put(new Integer(seekEntry.getSeekID()), seekEntry);
        }
        SeekActiveContentHandler.access$1702(this.this$0, hashMap);
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility) {
        int n = -1;
        switch (seekPossibility.getTypeOfContent()) {
            case 1: {
                n = 0;
                break;
            }
            case 3: {
                n = 1;
                break;
            }
        }
        SeekActiveContentHandler.access$1900(this.this$0, n);
    }

    /* synthetic */ SeekActiveContentHandler$DsiUpListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

