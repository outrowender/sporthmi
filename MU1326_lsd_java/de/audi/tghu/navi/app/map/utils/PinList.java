/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.utils.MapPin;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public class PinList {
    private List pins = new ArrayList();

    public int size() {
        return this.pins.size();
    }

    public void clear() {
        this.pins.clear();
    }

    public MapPin get(int n) {
        return (MapPin)this.pins.get(n);
    }

    public void add(MapPin mapPin) {
        if (!this.pins.contains(mapPin)) {
            this.pins.add(mapPin);
        }
    }

    public void addAll(MapPin[] mapPinArray) {
        if (mapPinArray != null && mapPinArray.length > 0) {
            for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                this.add(mapPinArray[i2]);
            }
        }
    }

    public void addAll(MapPin[] mapPinArray, PinList pinList) {
        if (mapPinArray != null && mapPinArray.length > 0) {
            for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                if (this.pins.contains(mapPinArray[i2])) continue;
                this.add(mapPinArray[i2]);
                pinList.add(mapPinArray[i2]);
            }
        }
    }

    public void addAll(PinList pinList) {
        this.pins.addAll(pinList.pins);
    }

    public void removeAll(MapPin[] mapPinArray) {
        PinList pinList = new PinList();
        pinList.addAll(mapPinArray);
        this.removeAll(pinList);
    }

    public void removeAll(PinList pinList) {
        this.pins.removeAll(pinList.pins);
    }

    public void set(PinList pinList, PinList pinList2, PinList pinList3) {
        if (pinList == null || pinList.size() == 0) {
            pinList = new PinList();
            pinList2.pins.addAll(this.pins);
            pinList3.pins.addAll(pinList.pins);
            this.pins.clear();
            this.pins.addAll(pinList.pins);
        } else {
            MapPin mapPin;
            int n;
            for (n = 0; n < this.pins.size(); ++n) {
                mapPin = (MapPin)this.pins.get(n);
                if (pinList.pins.contains(mapPin)) continue;
                pinList2.add(mapPin);
            }
            this.pins.removeAll(pinList2.pins);
            for (n = 0; n < pinList.size(); ++n) {
                mapPin = (MapPin)pinList.pins.get(n);
                int n2 = this.pins.indexOf(mapPin);
                if (n2 >= 0) continue;
                pinList3.add(mapPin);
                this.pins.add(mapPin);
            }
        }
    }

    public void set(MapPin[] mapPinArray, PinList pinList, PinList pinList2) {
        PinList pinList3 = new PinList();
        pinList3.addAll(mapPinArray);
        this.set(pinList3, pinList, pinList2);
    }

    public MapPin[] toArray() {
        int n = this.size();
        MapPin[] mapPinArray = new MapPin[n];
        for (int i2 = 0; i2 < n; ++i2) {
            mapPinArray[i2] = (MapPin)this.pins.get(i2);
        }
        return mapPinArray;
    }

    public void merge(PinList pinList) {
        if (pinList != null && pinList.size() > 0) {
            for (int i2 = 0; i2 < pinList.size(); ++i2) {
                this.merge((MapPin)pinList.pins.get(i2));
            }
        }
    }

    public void merge(MapPin mapPin) {
        int n = this.pins.indexOf(mapPin);
        if (n >= 0) {
            this.pins.set(n, mapPin);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.pins.size(); ++i2) {
            if (i2 > 0) {
                buffer.append(", ");
            }
            buffer.append("{").append(this.pins.get(i2)).append("}");
        }
        return buffer.toString();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}

