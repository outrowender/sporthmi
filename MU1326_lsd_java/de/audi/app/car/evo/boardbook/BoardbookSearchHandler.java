/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.boardbook;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import org.osgi.framework.BundleContext;

public class BoardbookSearchHandler
extends AbstractSearch {
    public BoardbookSearchHandler(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n) {
        super(bundleContext, iFrameworkAccess, logChannel, n);
    }

    @Override
    public void removeAllFromHistoryBySourceResult(int n) {
    }
}

