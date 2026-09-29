/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.navlocationextractor.AdbEntryAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter;

public class AdbEntryNavLocationExtractor
extends SyncNavLocationExtractorAdapter
implements NavLocationExctractor {
    public AdbEntryNavLocationExtractor(ICommandListFactory iCommandListFactory) {
        super(new AdbEntryAsyncNavLocationExtractor(iCommandListFactory));
    }
}

