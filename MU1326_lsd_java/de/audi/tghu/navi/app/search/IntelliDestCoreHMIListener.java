/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.search.IntelliDestAccess;
import de.audi.tghu.navi.app.util.Util;

public class IntelliDestCoreHMIListener
extends DefaultButtonListener {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private final NavigationEnv env;
    private final LogChannel lc;
    private IntelliDestAccess intelliDestAccess;

    public IntelliDestCoreHMIListener(NavigationEnv navigationEnv, IntelliDestAccess intelliDestAccess) {
        this.env = navigationEnv;
        this.intelliDestAccess = intelliDestAccess;
        this.lc = navigationEnv.getSearchLogChannel();
        this.initListener();
    }

    public static int getDeleteCurrentModelId() {
        return 400423;
    }

    private final void initListener() {
        this.env.getButtonModel(401030).setButtonListener(this);
    }

    public void deinit() {
        this.env.getButtonModel(401030).resetListener();
    }

    public void keyTyped(int n, int n2, int n3) {
        this.lc.log(1000000, "%1#ButtonListener.keyPressed model = %2 key = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        switch (n) {
            case 401030: {
                this.intelliDestAccess.getMainSearch().removeAllFromHistory();
                this.hidePopup();
                break;
            }
        }
        this.env.getButtonModel(n).fireEvent(n3);
    }

    protected void hidePopup() {
    }
}

