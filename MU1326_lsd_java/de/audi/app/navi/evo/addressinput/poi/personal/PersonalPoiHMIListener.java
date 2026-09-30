/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.personal;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.personal.IPersonalPoiHandler;

public class PersonalPoiHMIListener
implements ButtonListener {
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final IPersonalPoiHandler personalPoiHandler;

    public PersonalPoiHMIListener(NavigationEnv navigationEnv, LogChannel logChannel, IPersonalPoiHandler iPersonalPoiHandler) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.personalPoiHandler = iPersonalPoiHandler;
        this.initListeners();
    }

    private void initListeners() {
        this.env.getButtonModel(401256).setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "PersonalPOIHMIListener#keyPressed - modelID: %1; keyID: %2", (long)n, (long)n2);
        if (n == 401256) {
            this.personalPoiHandler.deletePersonalPOIDataBases();
        }
        this.env.fireModelEvent(n, n3);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

