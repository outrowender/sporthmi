/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberMatchSpellerModelAccess;
import de.audi.app.navi.evo.phonenumber.PhonenumberScreenListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public class PhonenumberInputManager {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final SpellerStack spellerStack;
    private final IPreviewMap previewMap;
    private final IStartGuidanceToDestinationSequence startRouteGuidanceSequence;
    private final HomeAddressHandler homeAddressHandler;
    private PhonenumberScreenListener phonenumberScreenListener;

    public PhonenumberInputManager(NavigationEnv navigationEnv, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
        this.startRouteGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.homeAddressHandler = homeAddressHandler;
        this.initPhonenumberScreenListener();
    }

    private void initPhonenumberScreenListener() {
        PhonenumberMatchSpellerModelAccess phonenumberMatchSpellerModelAccess = new PhonenumberMatchSpellerModelAccess(this.env, this.logChannel, PoiScreensEvo.getDiAsiaTelephoneNumberScreenMatchSpellerModel(), PoiScreensEvo.getDiAsiaTelephoneNumberScreenTiledListModel());
        PhonenumberInputSequence phonenumberInputSequence = new PhonenumberInputSequence(this.env, this.logChannel, this.commandListFactory, phonenumberMatchSpellerModelAccess, this.previewMap, this.spellerStack, this.startRouteGuidanceSequence);
        this.phonenumberScreenListener = new PhonenumberScreenListener(this.env, this.logChannel, this.previewMap, phonenumberInputSequence, this.homeAddressHandler);
    }

    public PhonenumberScreenListener getPhonenumberScreenListener() {
        return this.phonenumberScreenListener;
    }
}

