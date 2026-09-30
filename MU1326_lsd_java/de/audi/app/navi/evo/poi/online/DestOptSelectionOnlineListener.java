/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.util.Util;

public class DestOptSelectionOnlineListener
implements ButtonListener {
    private final IOnlineSearchForm onlineSearchForm;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public DestOptSelectionOnlineListener(IOnlineSearchForm iOnlineSearchForm, NavigationEnv navigationEnv) {
        this.onlineSearchForm = iOnlineSearchForm;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        navigationEnv.getButtonModel(402192).setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyPressed() - modelId=%2, keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == 402192) {
            this.onlineSearchForm.enterOnlineSearchForm();
            this.env.fireModelEvent(n, n3);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

