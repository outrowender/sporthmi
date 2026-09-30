/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ResultReceiver;

public interface ExlapService {
    public static final String SERVICE_NAME = "service_name";

    public void addListener(int var1, ExlapListener var2);

    public void addListener(int[] var1, ExlapListener var2);

    public void removeListener(int var1, ExlapListener var2);

    public void removeListener(int[] var1, ExlapListener var2);

    public void setResultReceiver(ResultReceiver var1);

    public void init();
}

