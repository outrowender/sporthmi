/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import org.dsi.ifc.sdars.RadioText;

class PdtInfoHandler$CoverArtRequestInfo {
    public static final PdtInfoHandler$CoverArtRequestInfo EMPTY_DUMMY = new PdtInfoHandler$CoverArtRequestInfo(-1, "", "");
    private final int sId;
    private final String artistName;
    private final String title;

    public PdtInfoHandler$CoverArtRequestInfo(int n, String string, String string2) {
        this.sId = n;
        this.artistName = string;
        this.title = string2;
    }

    public static PdtInfoHandler$CoverArtRequestInfo fromRadioText(RadioText radioText) {
        String string = PdtInfoHandler$CoverArtRequestInfo.artistNameForRadioText(radioText);
        String string2 = PdtInfoHandler$CoverArtRequestInfo.titleForRadioText(radioText);
        return new PdtInfoHandler$CoverArtRequestInfo(radioText.sID, string, string2);
    }

    public boolean differesFrom(RadioText radioText) {
        return !this.matches(radioText);
    }

    public boolean matches(RadioText radioText) {
        return radioText != null && this.sId == radioText.sID && this.artistName.equals(PdtInfoHandler$CoverArtRequestInfo.artistNameForRadioText(radioText)) && this.title.equals(PdtInfoHandler$CoverArtRequestInfo.titleForRadioText(radioText));
    }

    private static String artistNameForRadioText(RadioText radioText) {
        return radioText.longArtistName != null ? radioText.longArtistName : radioText.shortArtistName;
    }

    private static String titleForRadioText(RadioText radioText) {
        return radioText.longProgramTitle != null ? radioText.longProgramTitle : radioText.shortProgramTitle;
    }

    static /* synthetic */ int access$200(PdtInfoHandler$CoverArtRequestInfo pdtInfoHandler$CoverArtRequestInfo) {
        return pdtInfoHandler$CoverArtRequestInfo.sId;
    }

    static /* synthetic */ String access$300(PdtInfoHandler$CoverArtRequestInfo pdtInfoHandler$CoverArtRequestInfo) {
        return pdtInfoHandler$CoverArtRequestInfo.artistName;
    }

    static /* synthetic */ String access$400(PdtInfoHandler$CoverArtRequestInfo pdtInfoHandler$CoverArtRequestInfo) {
        return pdtInfoHandler$CoverArtRequestInfo.title;
    }
}

