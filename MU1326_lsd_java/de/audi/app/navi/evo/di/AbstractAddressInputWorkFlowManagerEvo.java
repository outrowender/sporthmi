/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.AbstractAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.li.SpellerStack;

public abstract class AbstractAddressInputWorkFlowManagerEvo
extends AbstractAddressInputWorkFlowManager {
    public AbstractAddressInputWorkFlowManagerEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        super(navigationEnv, iCommandListFactory, spellerStack);
    }
}

