/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navi.evo.navlocationextractor;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.navi.evo.navlocationextractor.NaviFavoriteEvoAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter;

public class NaviFavoriteEvoNavLocationExtractor
extends SyncNavLocationExtractorAdapter {
    public NaviFavoriteEvoNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        super(new NaviFavoriteEvoAsyncNavLocationExtractor(iCommandListFactory));
    }
}

