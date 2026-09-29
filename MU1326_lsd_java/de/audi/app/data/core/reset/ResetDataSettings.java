/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.reset;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.reset.CommandAutomaticProfile;
import de.audi.app.data.core.reset.CommandRestoreFactorySettings;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;
import org.osgi.framework.ServiceRegistration;

public class ResetDataSettings
extends AbstractDataConfigurationComponent
implements ButtonListener,
MsgListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private ServiceRegistration registration;
    protected ButtonModelApp resetButton = this.getButtonModel(1160128000);
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public ResetDataSettings(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "ResetDataSettings#keyTyped(): resetting configuration");
        if (n == this.resetButton.getID()) {
            this.resetConfiguration();
        }
        this.resetButton.fireEvent(n3);
    }

    private void resetConfiguration() {
        CommandAutomaticProfile.schedule(this.dataApplication, this.dsiDataConfiguration);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void processMsg(int n) {
        if (n == 28) {
            this.log.log(1078071040, "[ResetDataSettings#processMsg] Called, restore factory settings.");
            this.restoreFactorySettings();
        }
    }

    private void restoreFactorySettings() {
        CommandRestoreFactorySettings.schedule(this.dataApplication, this.dsiDataConfiguration);
        this.resetConfiguration();
    }

    @Override
    public void init() {
        super.init();
        this.resetButton.setButtonListener(this);
        this.registration = this.dataApplication.getBundleContext().registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ResetDataSettings.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.registration.unregister();
        this.registration = null;
        this.resetButton.resetListener();
        super.deinit();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

