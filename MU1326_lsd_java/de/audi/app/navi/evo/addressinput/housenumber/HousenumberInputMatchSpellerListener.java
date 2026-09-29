/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.housenumber;

import de.audi.app.navi.evo.addressinput.AbstractEvoInputSequenceMatchspellerListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;

public class HousenumberInputMatchSpellerListener
extends AbstractEvoInputSequenceMatchspellerListener {
    private HousenumberMatchspellerInputSequence inputSequence;

    public HousenumberInputMatchSpellerListener(HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, NavigationEnv navigationEnv, int n, int n2, IPreviewMap iPreviewMap) {
        super(navigationEnv, n, n2, iPreviewMap);
        this.inputSequence = housenumberMatchspellerInputSequence;
    }

    public HousenumberInputMatchSpellerListener(HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
        super(navigationEnv, n, n2, n3, iPreviewMap);
        this.inputSequence = housenumberMatchspellerInputSequence;
    }

    @Override
    public IMatchspellerInputSequence getInputSequence() {
        return this.inputSequence;
    }
}

