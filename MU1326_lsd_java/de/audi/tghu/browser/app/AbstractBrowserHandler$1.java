/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.browser.app;

import de.audi.tghu.browser.app.AbstractBrowserHandler;
import java.util.HashMap;

class AbstractBrowserHandler$1
extends HashMap {
    private final /* synthetic */ AbstractBrowserHandler this$0;

    AbstractBrowserHandler$1(AbstractBrowserHandler abstractBrowserHandler) {
        this.this$0 = abstractBrowserHandler;
        this.put(new Integer(0), "BROWSERSTATE_LOADING");
        this.put(new Integer(1), "BROWSERSTATE_IDLE");
        this.put(new Integer(2), "BROWSERSTATE_NOT_FOUND");
        this.put(new Integer(3), "BROWSERSTATE_SUSPENDED");
        this.put(new Integer(4), "BROWSERSTATE_COMPLETE");
        this.put(new Integer(5), "BROWSERSTATE_OUT_OF_MEMORY");
        this.put(new Integer(6), "BROWSERSTATE_HTML_COMPLETE");
    }
}

