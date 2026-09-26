/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.util.Util;
import de.audi.tuner.app.sdars.seek.WeatherHandler;
import de.audi.tuner.app.sdars.seek.WeatherHandler$1;
import de.audi.tuner.app.sdars.seek.WeatherHandler$IGUIInterface;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

class WeatherHandler$GUIInterfaceGUIDE
implements WeatherHandler$IGUIInterface {
    private final /* synthetic */ WeatherHandler this$0;

    private WeatherHandler$GUIInterfaceGUIDE(WeatherHandler weatherHandler) {
        this.this$0 = weatherHandler;
    }

    @Override
    public void updateWeatherSeekList(SeekEntry[] seekEntryArray) {
        WeatherHandler.access$400(this.this$0).log(-2137614336, "WeatherHandler.updateWeatherSeekList()");
        WeatherHandler.access$500(this.this$0).clear();
        for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
            SeekEntry seekEntry = seekEntryArray[i2];
            WeatherHandler.access$500(this.this$0).put(Util.createInteger(seekEntry.getSeekID()), seekEntry);
        }
        this.this$0.updateWeatherMarketModel();
    }

    @Override
    public void updateWeatherMarketList(TrafficWxEntry[] trafficWxEntryArray) {
        WeatherHandler.access$400(this.this$0).log(-2137614336, "WeatherHandler.updateWeatherMarketList()");
        this.this$0.markets = trafficWxEntryArray;
        this.this$0.updateWeatherMarketModel();
    }

    /* synthetic */ WeatherHandler$GUIInterfaceGUIDE(WeatherHandler weatherHandler, WeatherHandler$1 weatherHandler$1) {
        this(weatherHandler);
    }
}

