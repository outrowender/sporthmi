/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.country;

import de.audi.app.navi.evo.addressinput.AbstractEvoInputSequenceMatchspellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.country.CountryInputSequence;

public class CountryInputMatchSpellerListener
extends AbstractEvoInputSequenceMatchspellerListener {
    private CountryInputSequence inputSequence;

    public CountryInputMatchSpellerListener(CountryInputSequence countryInputSequence, NavigationEnv navigationEnv, int n, int n2, IPreviewMap iPreviewMap) {
        super(navigationEnv, n, n2, iPreviewMap);
        this.inputSequence = countryInputSequence;
    }

    public CountryInputMatchSpellerListener(CountryInputSequence countryInputSequence, NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
        super(navigationEnv, n, n2, n3, iPreviewMap);
        this.inputSequence = countryInputSequence;
    }

    public CountryInputMatchSpellerListener(CountryInputSequence countryInputSequence, NavigationEnv navigationEnv, int n, int n2) {
        super(navigationEnv, n, n2);
        this.inputSequence = countryInputSequence;
    }

    public IMatchspellerInputSequence getInputSequence() {
        return this.inputSequence;
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

