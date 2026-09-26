/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

public class MatchSpellerImpl$SpellerState {
    private String uniqueChars;
    private String validChars;
    private String[] valueList;
    private boolean[] valueListToRefine;
    private boolean fullMatch = false;

    public boolean isFullMatch() {
        return this.fullMatch;
    }

    public String getUniqueChars() {
        return this.uniqueChars;
    }

    public String getValidChars() {
        return this.validChars;
    }

    public String[] getValueList() {
        return this.valueList;
    }

    public boolean[] getValueListToRefine() {
        return this.valueListToRefine;
    }

    static /* synthetic */ String access$002(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState, String string) {
        matchSpellerImpl$SpellerState.validChars = string;
        return matchSpellerImpl$SpellerState.validChars;
    }

    static /* synthetic */ String access$102(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState, String string) {
        matchSpellerImpl$SpellerState.uniqueChars = string;
        return matchSpellerImpl$SpellerState.uniqueChars;
    }

    static /* synthetic */ String[] access$202(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState, String[] stringArray) {
        matchSpellerImpl$SpellerState.valueList = stringArray;
        return stringArray;
    }

    static /* synthetic */ boolean[] access$302(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState, boolean[] blArray) {
        matchSpellerImpl$SpellerState.valueListToRefine = blArray;
        return blArray;
    }

    static /* synthetic */ boolean[] access$300(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState) {
        return matchSpellerImpl$SpellerState.valueListToRefine;
    }

    static /* synthetic */ boolean access$402(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState, boolean bl) {
        matchSpellerImpl$SpellerState.fullMatch = bl;
        return matchSpellerImpl$SpellerState.fullMatch;
    }

    static /* synthetic */ String access$100(MatchSpellerImpl$SpellerState matchSpellerImpl$SpellerState) {
        return matchSpellerImpl$SpellerState.uniqueChars;
    }
}

