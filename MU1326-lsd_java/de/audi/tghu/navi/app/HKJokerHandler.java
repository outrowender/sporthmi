/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.ManagementServices;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;

public final class HKJokerHandler
implements ButtonListener {
    private static final int JOKER1_BUTTON_ID;
    private LogChannel logChannel;
    private ButtonModelApp joker1Button;
    private ManagementServices managementServices;
    private Navigation navigation;
    private final NavigationEnv env;

    public HKJokerHandler(NavigationEnv navigationEnv, Navigation navigation, ManagementServices managementServices) {
        this.logChannel = navigationEnv.getLogChannel();
        this.navigation = navigation;
        this.env = navigationEnv;
        this.joker1Button = navigationEnv.getButtonModel(-1742797312);
        this.joker1Button.setButtonListener(this);
        this.managementServices = managementServices;
    }

    public ButtonModelApp getJoker1Button() {
        return this.joker1Button;
    }

    public void cleanUp() {
        this.navigation = null;
        this.managementServices = null;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "HKJokerHandler#keyReleased( %1 )", (long)n);
        if (n == -1742797312) {
            int n4 = this.env.getChoiceModel(395).getValue();
            this.logChannel.log(1078071040, "HKJokerHandler#keyReleased() - jokerKey1Choice: %1", (long)n4);
            if (n4 == 3) {
                this.navigation.getSpeechManager().toggleGuidanceMode();
                int n5 = this.navigation.getSpeechManager().getGuidanceMode();
                switch (n5) {
                    case 3: {
                        this.managementServices.sendMessage(63);
                        break;
                    }
                    case 1: {
                        this.managementServices.sendMessage(62);
                        break;
                    }
                    case 0: {
                        this.managementServices.sendMessage(65);
                        break;
                    }
                    default: {
                        this.managementServices.sendMessage(64);
                        break;
                    }
                }
            } else if (n4 == 4) {
                boolean bl = this.navigation.getMapInterface().toggleDayNightView();
                this.managementServices.sendMessage(bl ? 60 : 61);
            } else if (n4 == 5) {
                int n6 = this.navigation.getMapInterface().toggleAdditionalInfo();
                switch (n6) {
                    case 3: {
                        this.managementServices.sendMessage(71);
                        break;
                    }
                    case 2: {
                        this.managementServices.sendMessage(73);
                        break;
                    }
                    default: {
                        this.managementServices.sendMessage(72);
                        break;
                    }
                }
            } else if (n4 == 10) {
                this.logChannel.log(-2137614336, "HKJokerHandler#keyReleased() - show/hide traffic announcement");
                this.navigation.getTmcGateway().showHideTMCPopup();
            } else if (n4 == 12) {
                this.logChannel.log(-2137614336, "HKJokerHandler#keyReleased() - repeat driving instruction");
                this.navigation.getLastAnnouncementHandler().repeatLastAnnoucment();
            } else {
                this.logChannel.log(-2137614336, "HKJokerHandler#keyReleased() - ignoring HKJoker key. No navigation function called.");
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

