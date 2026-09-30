/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.WLANResponseListener;
import de.audi.app.wlan.core.client.CommandConnectNetwork;
import de.audi.app.wlan.core.client.CommandDisconnectNetwork;
import de.audi.app.wlan.core.client.IConnection;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;

public abstract class AbstractWlanConnection
extends AbstractWlanComponent
implements IConnection,
ButtonListener,
SpellerListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private static final int UNENCRYPTED = 0;
    private static final int ENCRYPTED = 1;
    private static final int DISABLED = 0;
    private static final int ENABLED = 1;
    protected DiscoveredNetwork discoveredNetwork;
    private final ChoiceModelApp bondingState = this.getChoiceModel(2500044);
    protected final SpellerModelApp passwordSpeller = this.getSpellerModel(2500045);
    private final ButtonModelApp applyButton = this.getButtonModel(2500046);
    private final ChoiceModelApp disconnectNetworkResult = this.getChoiceModel(2500183);
    private final ChoiceModelApp passwordChoice = this.getChoiceModel(2500225);

    public AbstractWlanConnection(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    protected void setSpellerOKButton(int n) {
        this.passwordSpeller.setStatus(n);
    }

    public void connectNetwork(DiscoveredNetwork discoveredNetwork) {
        this.connectNetwork(discoveredNetwork, new WLANResponseListener(this.log));
    }

    public void connectNetwork(DiscoveredNetwork discoveredNetwork, DSIWLANListener dSIWLANListener) {
        this.log.log(10000000, "AbstractWlanConnection#connectNetwork(): %1", (Object)discoveredNetwork);
        this.discoveredNetwork = discoveredNetwork;
        if (this.wlanApplication.getTrustedNetworkList().isTrusted(discoveredNetwork.bssidAddress)) {
            this.passwordChoice.setValue(0);
            this.connectNetwork(discoveredNetwork, "", dSIWLANListener);
        } else {
            this.log.log(10000000, "AbstractWlanConnection#connectNetwork(): %1 not found in trusted network list.", (Object)discoveredNetwork);
            if (discoveredNetwork.getEncryptionType() == 1) {
                this.passwordChoice.setValue(0);
                this.connectNetwork(discoveredNetwork, "", dSIWLANListener);
            } else {
                this.passwordChoice.setValue(1);
                this.log.log(10000000, "AbstractWlanConnection#connectNetwork(): Waiting for user to enter the password");
            }
        }
    }

    protected void connectNetwork(DiscoveredNetwork discoveredNetwork, String string) {
        this.connectNetwork(discoveredNetwork, string, new WLANResponseListener(this.log));
    }

    protected void connectNetwork(DiscoveredNetwork discoveredNetwork, String string, DSIWLANListener dSIWLANListener) {
        this.wlanApplication.getMode().switchWlanState(true);
        this.wlanApplication.getMode().setRole(4);
        this.bondingState.setStatus(0);
        ChoiceModelApp choiceModelApp = this.getChoiceModel(2500042);
        CommandConnectNetwork.schedule(this.wlanApplication, this.dsiWlan, this.bondingState, choiceModelApp, discoveredNetwork, string, dSIWLANListener);
    }

    public void disconnectNetwork(String string, String string2) {
        this.disconnectNetwork(string, string2, new WLANResponseListener(this.log));
    }

    public void disconnectNetwork(String string, String string2, DSIWLANListener dSIWLANListener) {
        this.log.log(10000000, "AbstractWlanConnection#disconnectNetwork(): %1 %2", (Object)string, (Object)string2);
        CommandDisconnectNetwork.schedule(this.wlanApplication, this.dsiWlan, string, string2, this.disconnectNetworkResult, dSIWLANListener);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1000000, "AbstractWlanConnection#textChanged(): %1 %2", (Object)new Integer(n), (Object)string);
        int n3 = string.length() > 0 ? 1 : 0;
        this.setSpellerOKButton(n3);
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.applyButton.getID() && this.discoveredNetwork != null) {
            this.executeKeyTyped(n, n2, n3);
            this.applyButton.fireEvent(n3);
        }
    }

    protected void executeKeyTyped(int n, int n2, int n3) {
        this.connectNetwork(this.discoveredNetwork, this.passwordSpeller.getText());
        this.passwordSpeller.clear();
        this.setSpellerOKButton(0);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void init() {
        super.init();
        this.passwordSpeller.setSpellerListener(this);
        this.setSpellerOKButton(0);
        this.applyButton.setButtonListener(this);
    }

    public void deinit() {
        this.passwordSpeller.resetListener();
        this.applyButton.resetListener();
        super.deinit();
    }
}

