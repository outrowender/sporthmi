/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.countryinfo;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.countryinfo.IClosePopups;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;

public class CountryInfoHmiListener
implements ButtonListener,
SpellerListener {
    protected final ICountryInfoHandler countryInfoHandler;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    private SpellerModelApp directWritingSpeller;
    private final IClosePopups countryPopupCloser;
    protected ChoiceModelApp navResetInputModeChoice;

    public CountryInfoHmiListener(NavigationEnv navigationEnv, ICountryInfoHandler iCountryInfoHandler, IClosePopups iClosePopups) {
        this.env = navigationEnv;
        this.countryInfoHandler = iCountryInfoHandler;
        this.countryPopupCloser = iClosePopups;
        this.logChannel = navigationEnv.getLogChannel();
        this.navResetInputModeChoice = navigationEnv.getChoiceModel(170);
        this.setListeners();
    }

    protected final void setListeners() {
        this.env.getButtonModel(400750).setButtonListener(this);
        this.env.getButtonModel(400739).setButtonListener(this);
        this.env.getListModel(400746).setMaxColumns(7);
        this.env.getButtonModel(401984).setButtonListener(this);
        this.directWritingSpeller = this.env.getSpellerModel(401855);
        this.directWritingSpeller.setSpellerListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "CountryInfoHmiListener#keyPressed(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "CountryInfoHmiListener#keyReleased(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "CountryInfoHmiListener#keyTyped(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        }
        switch (n) {
            case 400750: {
                this.setNavResetInputMode();
                this.countryInfoHandler.initiateCountry();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400739: {
                this.countryInfoHandler.startCountryInput(true);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401984: {
                if (this.countryPopupCloser == null) break;
                this.countryPopupCloser.close();
                break;
            }
            default: {
                this.logChannel.log(100000, "CountryInfoHmiListener#keyTyped - unknown modelID( %1 )", (long)n);
            }
        }
    }

    public void setNavResetInputMode() {
        this.navResetInputModeChoice.setValue(0);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (n == this.directWritingSpeller.getID()) {
            this.countryInfoHandler.startCountryInput(true, c2);
            this.env.fireModelEvent(n, n2);
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }
}

