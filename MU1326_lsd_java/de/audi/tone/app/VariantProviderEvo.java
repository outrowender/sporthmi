/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.variant.IGUIVariantProvider;
import de.audi.atip.variant.IIDMapper;
import de.audi.tone.app.ToneTextConstantsImplEvo;

public class VariantProviderEvo
implements IGUIVariantProvider {
    public IIDMapper getTextConstantsMapper() {
        return new ToneTextConstantsImplEvo();
    }

    public IIDMapper getSMEventConstantsMapper() {
        throw new UnsupportedOperationException("Not implemented");
    }
}

