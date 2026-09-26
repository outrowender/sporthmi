/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;

public interface ILocationDisambiguatorPopupHandler {
    default public void startPopupHandling(LocationDisambiguationWrapper locationDisambiguationWrapper) {
    }

    default public void startPopupHandlingForSds(LocationDisambiguationWrapper locationDisambiguationWrapper) {
    }
}

