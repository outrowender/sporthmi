/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.IGenericDataUpdatePayload$IWeatherInfos;
import java.util.List;

public interface IGenericDataUpdatePayload {
    default public int getLocation() {
    }

    default public String getId() {
    }

    default public String getContext() {
    }

    default public String getType() {
    }

    default public int getUpdateState() {
    }

    default public List getRows() {
    }

    default public IWeatherInfos getWeatherInfos() {
    }
}

