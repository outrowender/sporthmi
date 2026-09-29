/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.asia;

import de.audi.app.navi.evo.asia.AsiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;

public class AsiaDbPartialMapUpdateHMIListener {
    private NavigationEnv env;
    private ICommandListFactory commandListFactory;

    public AsiaDbPartialMapUpdateHMIListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.initListeners();
    }

    private final void initListeners() {
        AsiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener asiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener = new AsiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener(this, null);
        this.env.getButtonModel(874579456).setButtonListener(asiaDbPartialMapUpdateHMIListener$AsiaDbPartialMapUpdateButtonListener);
    }

    static /* synthetic */ NavigationEnv access$100(AsiaDbPartialMapUpdateHMIListener asiaDbPartialMapUpdateHMIListener) {
        return asiaDbPartialMapUpdateHMIListener.env;
    }

    static /* synthetic */ ICommandListFactory access$200(AsiaDbPartialMapUpdateHMIListener asiaDbPartialMapUpdateHMIListener) {
        return asiaDbPartialMapUpdateHMIListener.commandListFactory;
    }
}

