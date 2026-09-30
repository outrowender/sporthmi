/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.AddressInputManagerJP;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractAddressInputScreenWorkFlowManagerJP {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected AddressInputManagerJP inputManager;

    public AbstractAddressInputScreenWorkFlowManagerJP(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    public abstract CommandList handleWorkFlow(CommandList var1, int var2);

    public void setAddressInputManager(AddressInputManagerJP addressInputManagerJP) {
        this.inputManager = addressInputManagerJP;
    }

    protected SpellerContext getSpellerContext(int n) {
        return SpellerContextManager.getSpellerContext(n);
    }
}

