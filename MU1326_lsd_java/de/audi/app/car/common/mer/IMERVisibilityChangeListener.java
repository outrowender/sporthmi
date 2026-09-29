/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntryStructure;
import java.util.List;

public interface IMERVisibilityChangeListener {
    default public void notifyVisibilityChange(List list) {
    }

    default public void initUseOfMenuStructure(IMenuEntryStructure iMenuEntryStructure) {
    }
}

