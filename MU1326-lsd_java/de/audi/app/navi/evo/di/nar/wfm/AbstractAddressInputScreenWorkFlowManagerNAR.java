/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.AddressInputManagerNAR;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractAddressInputScreenWorkFlowManagerNAR {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected AddressInputManagerNAR inputManager;

    public AbstractAddressInputScreenWorkFlowManagerNAR(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    public abstract CommandList handleWorkFlow(CommandList commandList, int n) {
    }

    public void setAddressInputManager(AddressInputManagerNAR addressInputManagerNAR) {
        this.inputManager = addressInputManagerNAR;
    }

    protected SpellerContext getSpellerContext(int n) {
        return SpellerContextManager.getSpellerContext(n);
    }
}

