/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.WeatherHandler;
import java.util.ArrayList;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

class WeatherHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ WeatherHandler this$0;

    WeatherHandler$DsiUpListener(WeatherHandler weatherHandler) {
        this.this$0 = weatherHandler;
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
            SeekEntry seekEntry = seekEntryArray[i2];
            if (seekEntry.getTypeOfContent() != 4) continue;
            arrayList.add(seekEntry);
        }
        Object[] objectArray = new SeekEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        this.this$0.guiInterface.updateWeatherSeekList((SeekEntry[])objectArray);
    }

    @Override
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
        this.this$0.guiInterface.updateWeatherMarketList(trafficWxEntryArray);
    }

    @Override
    public void updateAvailability(int n) {
        if (n == 1 && this.this$0.marketListModel != null) {
            this.this$0.marketListModel.fireEvent(0);
        }
    }
}

