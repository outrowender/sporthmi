/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeConversionsAvailableListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeMatchspellerProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConversionDataFetcherStrokeMatchspeller
extends AbstractConversionDataFetcher
implements IConversionDataFetcher,
ITouchInputDataChangeHandler,
IStrokeConversionsAvailableListener {
    private final IStrokeMatchspellerProtocol strokeMatchspellerProtocol;

    public ConversionDataFetcherStrokeMatchspeller(IStrokeMatchspellerProtocol iStrokeMatchspellerProtocol) {
        this.strokeMatchspellerProtocol = iStrokeMatchspellerProtocol;
        this.strokeMatchspellerProtocol.setStrokeConversionsAvailableListener(this);
    }

    @Override
    public final void touchInputDataChanged(int n, boolean bl, String string, String string2) {
        if (n == 3 && bl) {
            this.requestConversions(string2, TouchControllerListenerFactory.calculateLastInputChar(string, string2), 0, 36);
        }
    }

    @Override
    public void requestConversions(String string, char c2, int n, int n2, boolean bl) {
        if (bl) {
            this.strokeMatchspellerProtocol.strokesChanged(string, c2);
        }
        this.strokeMatchspellerProtocol.requestValidHanziCharsWindow(n, n2);
    }

    protected void requestConversions(String string, char c2, int n, int n2) {
        this.requestConversions(string, c2, n, n2, true);
    }

    @Override
    public void notifyMatchspellerStrokeConversionsAvailable() {
        List list = this.fetchStrokeConversionsFromMatchspellerModel();
        String string = this.strokeMatchspellerProtocol.getStrokes();
        this.notifyConversionsAvailable(string, list);
    }

    private List fetchStrokeConversionsFromMatchspellerModel() {
        String string = this.strokeMatchspellerProtocol.getValidHanziCharsWindowResult();
        if (StringUtilities.isNullOrEmpty(string)) {
            return Collections.EMPTY_LIST;
        }
        return ConversionDataFetcherStrokeMatchspeller.charArrayToList(string.toCharArray());
    }

    public static List charArrayToList(char[] cArray) {
        ArrayList arrayList = new ArrayList(cArray.length);
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            arrayList.add(String.valueOf(cArray[i2]));
        }
        return arrayList;
    }
}

