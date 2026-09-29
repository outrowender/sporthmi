/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.variant;

import de.audi.atip.variant.IIDMapper;

public interface IGUIVariantProvider {
    default public IIDMapper getTextConstantsMapper() {
    }

    default public IIDMapper getSMEventConstantsMapper() {
    }
}

