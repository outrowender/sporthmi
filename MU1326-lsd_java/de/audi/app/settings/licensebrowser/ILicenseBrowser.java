/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.licensebrowser;

import de.audi.atip.browser.IBrowserHandler;

public interface ILicenseBrowser {
    default public void browserEntered() {
    }

    default public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
    }
}

