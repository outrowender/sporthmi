/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambMatchSpellerListener;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.IAddressInputAsiaSpecificSequence;

public class AddressDisambiguatorHMIListener$DisambMatchSpellerListenerAsia
extends AddressDisambiguatorHMIListener$DisambMatchSpellerListener
implements MatchspellerListenerAsia {
    private final IAddressInputAsiaSpecificSequence asiaSpecificSequence;
    private final /* synthetic */ AddressDisambiguatorHMIListener this$0;

    protected AddressDisambiguatorHMIListener$DisambMatchSpellerListenerAsia(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener, HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, IAddressInputAsiaSpecificSequence iAddressInputAsiaSpecificSequence, NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
        this.this$0 = addressDisambiguatorHMIListener;
        super(addressDisambiguatorHMIListener, housenumberMatchspellerInputSequence, navigationEnv, n, n2, n3, iPreviewMap);
        this.asiaSpecificSequence = iAddressInputAsiaSpecificSequence;
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
        this.logChannel.log(-2137614336, "DisambMatchSpellerListenerAsia#nonAlphaNumTPCharsChanged - modelId=%1, recognizedChars=%2", (Object)Integer.toString(n), (Object)string);
        AddressDisambiguatorHMIListener.access$100(this.this$0);
        this.asiaSpecificSequence.nonAlphaNumTPCharsChanged(n, n2, string, this.env.getMatchSpellerModel(n));
    }

    @Override
    public void inputModeTPChanged(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "DisambMatchSpellerListenerAsia#inputModeTPChanged - modelId=%1, mode=%2", (long)n, (long)n2);
        AddressDisambiguatorHMIListener.access$100(this.this$0);
        this.asiaSpecificSequence.touchPadInputModeChanged(n2);
    }

    @Override
    public void strokesChanged(int n, int n2, String string, char c2) {
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
    }
}

