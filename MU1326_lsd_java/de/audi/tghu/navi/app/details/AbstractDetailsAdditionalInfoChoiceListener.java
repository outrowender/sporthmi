/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;

public abstract class AbstractDetailsAdditionalInfoChoiceListener
extends DefaultChoiceListener {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final int additionalinfoBrowserChoice;

    public AbstractDetailsAdditionalInfoChoiceListener(NavigationEnv navigationEnv) {
        this.additionalinfoBrowserChoice = -668989952;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
    }
}

