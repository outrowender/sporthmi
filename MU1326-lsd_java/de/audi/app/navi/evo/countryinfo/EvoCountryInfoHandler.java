/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.countryinfo;

import de.audi.app.navi.evo.addressinput.country.CountryInputMatchSpellerListener;
import de.audi.app.navi.evo.addressinput.country.CountryInputModelAccess;
import de.audi.app.navi.evo.countryinfo.EvoCountryInfoInputModelAccess;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.country.CountryInfoInputSequence;
import de.audi.tghu.navi.app.addressinput.country.CountryInputSequence;
import de.audi.tghu.navi.app.countryinfo.CountryInfoHandler;
import de.audi.tghu.navi.app.countryinfo.CountryInfoScreens;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;

public class EvoCountryInfoHandler
extends CountryInfoHandler {
    private CountryInputSequence sequence;
    private CountryInputModelAccess modelAccess;

    public EvoCountryInfoHandler(NavigationEnv navigationEnv, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IconHandler iconHandler, IVehicle iVehicle, IPreviewMap iPreviewMap, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, iCommandListFactory, iconHandler, iVehicle);
        this.initListener(spellerStack, iAddressInputFormModelAccessHelper, iPreviewMap);
    }

    private void initListener(SpellerStack spellerStack, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, IPreviewMap iPreviewMap) {
        this.modelAccess = new EvoCountryInfoInputModelAccess(this.env, CountryInfoScreens.getCountryInfoSpeller(), -1004665344, this, iAddressInputFormModelAccessHelper);
        this.sequence = new CountryInfoInputSequence(this.modelAccess, spellerStack, this.commandListFactory, iPreviewMap, this.env);
        new CountryInputMatchSpellerListener(this.sequence, this.env, CountryInfoScreens.getCountryInfoSpeller(), -1004665344, -987888128, null);
    }

    @Override
    public void startCountryInput(boolean bl, char c2) {
        if (c2 == '\u0000') {
            this.sequence.start(bl);
        } else {
            this.sequence.start(c2, bl);
        }
    }
}

