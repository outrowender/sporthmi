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
        this.env.getButtonModel(1847395840).setButtonListener(this);
        this.env.getButtonModel(1662846464).setButtonListener(this);
        this.env.getListModel(1780286976).setMaxColumns(7);
        this.env.getButtonModel(1075971584).setButtonListener(this);
        this.directWritingSpeller = this.env.getSpellerModel(-1088354816);
        this.directWritingSpeller.setSpellerListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "CountryInfoHmiListener#keyPressed(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "CountryInfoHmiListener#keyReleased(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "CountryInfoHmiListener#keyTyped(%1, %2, %3)", (long)n, (long)n2, (long)n3);
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
                this.logChannel.log(-1601830656, "CountryInfoHmiListener#keyTyped - unknown modelID( %1 )", (long)n);
            }
        }
    }

    public void setNavResetInputMode() {
        this.navResetInputModeChoice.setValue(0);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (n == this.directWritingSpeller.getID()) {
            this.countryInfoHandler.startCountryInput(true, c2);
            this.env.fireModelEvent(n, n2);
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }
}

