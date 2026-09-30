/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntryStructure;
import java.util.List;

public interface IMERVisibilityChangeListener {
    public void notifyVisibilityChange(List var1);

    public void initUseOfMenuStructure(IMenuEntryStructure var1);
}

