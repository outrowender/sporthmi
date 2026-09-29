/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.asia;

import de.audi.app.navi.evo.asia.AsiaHMIListener$AsiaButtonListener;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;

public class AsiaHMIListener {
    private NavigationEnv env;
    private ICommandListFactory commandListFactory;

    public AsiaHMIListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.initListeners();
    }

    private final void initListeners() {
        AsiaHMIListener$AsiaButtonListener asiaHMIListener$AsiaButtonListener = new AsiaHMIListener$AsiaButtonListener(this, null);
        this.env.getButtonModel(-2128542208).setButtonListener(asiaHMIListener$AsiaButtonListener);
    }

    static /* synthetic */ NavigationEnv access$100(AsiaHMIListener asiaHMIListener) {
        return asiaHMIListener.env;
    }

    static /* synthetic */ ICommandListFactory access$200(AsiaHMIListener asiaHMIListener) {
        return asiaHMIListener.commandListFactory;
    }
}

