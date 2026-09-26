/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.tm.KeyPanelHandler$ButtonListener;
import de.audi.tv.app.tm.KeyPanelHandler$ChoiceListenerImpl;
import de.audi.tv.app.tm.KeyPanelHandler$SpellerListener;
import de.audi.tv.app.tm.KeyPanelHandler$TVListenerImpl;

public class KeyPanelHandler {
    public final DefaultTVListener tvListener = new KeyPanelHandler$TVListenerImpl(this, null);
    private final TVEnv env;
    private final DSIHandler dsiHandler;
    private final ChoiceModelApp choiceModelApp;
    private volatile boolean keyLock = false;
    private final Object dsiAccessMutex = new Object();

    public KeyPanelHandler(DSIHandler dSIHandler, TVEnv tVEnv) {
        this.dsiHandler = dSIHandler;
        this.env = tVEnv;
        this.choiceModelApp = tVEnv.getChoiceModel(-1716771072);
        this.choiceModelApp.setChoiceListener(new KeyPanelHandler$ChoiceListenerImpl(this, null));
        KeyPanelHandler$ButtonListener keyPanelHandler$ButtonListener = new KeyPanelHandler$ButtonListener(this, null);
        tVEnv.getButtonModel(-777246976).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-1045682432).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-794024192).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-1079236864).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-1096014080).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-1062459648).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-978573568).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-1028905216).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-1012128000).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-995350784).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-961796352).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-945019136).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-928241920).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-911464704).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-894687488).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-877910272).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-861133056).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-844355840).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-827578624).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-810801408).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-324262144).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getButtonModel(-89381120).setButtonListener(keyPanelHandler$ButtonListener);
        tVEnv.getSpellerModel(548218624).setSpellerListener(new KeyPanelHandler$SpellerListener(this, null));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean externalKeyPressed(short s) {
        Object object = this.dsiAccessMutex;
        synchronized (object) {
            if (!this.keyLock) {
                this.dsiHandler.setTMTVKeyPanel(s, (short)1);
                this.dsiHandler.setTMTVKeyPanel(s, (short)0);
                return true;
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void buttonAction(short s, short s2) {
        Object object = this.dsiAccessMutex;
        synchronized (object) {
            this.keyLock = s2 == 1;
            this.dsiHandler.setTMTVKeyPanel(s, s2);
        }
    }

    static /* synthetic */ TVEnv access$400(KeyPanelHandler keyPanelHandler) {
        return keyPanelHandler.env;
    }

    static /* synthetic */ ChoiceModelApp access$500(KeyPanelHandler keyPanelHandler) {
        return keyPanelHandler.choiceModelApp;
    }

    static /* synthetic */ void access$600(KeyPanelHandler keyPanelHandler, short s, short s2) {
        keyPanelHandler.buttonAction(s, s2);
    }
}

