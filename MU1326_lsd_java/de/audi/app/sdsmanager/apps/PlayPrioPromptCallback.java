/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.apps.SDSServiceImpl;

public class PlayPrioPromptCallback {
    private SDSServiceImpl sdsServiceImpl;
    private String text;

    public PlayPrioPromptCallback(SDSServiceImpl sDSServiceImpl, String string) {
        this.sdsServiceImpl = sDSServiceImpl;
        this.text = string;
    }

    public void callback() {
        this.sdsServiceImpl.playPrioPrompt(this.text);
    }
}

