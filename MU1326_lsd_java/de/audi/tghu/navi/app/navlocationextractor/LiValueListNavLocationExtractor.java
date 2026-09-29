/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter;

public class LiValueListNavLocationExtractor
extends SyncNavLocationExtractorAdapter {
    public LiValueListNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        super(new LiValueListAsyncNavLocationExtractor(iCommandListFactory));
    }
}

