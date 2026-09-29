/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.MatchSpellerImpl$SpellerState;
import java.util.ArrayList;
import java.util.Arrays;

public class MatchSpellerImpl {
    MatchSpellerImpl$SpellerState currentState;
    StringBuffer curPrefix;
    String[] values;
    boolean changed = true;

    public MatchSpellerImpl(String[] stringArray) {
        this.resetValues(stringArray);
    }

    public MatchSpellerImpl() {
        this.resetValues(new String[0]);
    }

    public final void resetValues(String[] stringArray) {
        this.values = new String[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.values[i2] = stringArray[i2].toUpperCase();
        }
        Arrays.sort(this.values);
        this.curPrefix = new StringBuffer();
        this.changed = true;
    }

    public MatchSpellerImpl$SpellerState getCurrentState() {
        int n;
        if (this.currentState != null && !this.changed) {
            return this.currentState;
        }
        if (this.currentState == null) {
            this.currentState = new MatchSpellerImpl$SpellerState();
        }
        MatchSpellerImpl$SpellerState.access$002(this.currentState, this.getNextChars());
        MatchSpellerImpl$SpellerState.access$102(this.currentState, this.curPrefix.toString());
        String string = this.curPrefix.toString();
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        for (n = 0; n < this.values.length; ++n) {
            if (this.values[n].toLowerCase().indexOf(string.toLowerCase()) == -1) continue;
            if (arrayList.contains(this.values[n])) {
                arrayList2.set(arrayList.indexOf(this.values[n]), Boolean.TRUE);
                continue;
            }
            arrayList.add(this.values[n]);
            arrayList2.add(Boolean.FALSE);
        }
        MatchSpellerImpl$SpellerState.access$202(this.currentState, (String[])arrayList.toArray(new String[arrayList.size()]));
        MatchSpellerImpl$SpellerState.access$302(this.currentState, new boolean[arrayList2.size()]);
        for (n = 0; n < MatchSpellerImpl$SpellerState.access$300(this.currentState).length; ++n) {
            MatchSpellerImpl$SpellerState.access$300((MatchSpellerImpl$SpellerState)this.currentState)[n] = (Boolean)arrayList2.get(n);
        }
        MatchSpellerImpl$SpellerState.access$402(this.currentState, Arrays.binarySearch(this.values, MatchSpellerImpl$SpellerState.access$100(this.currentState)) > -1);
        this.changed = false;
        return this.currentState;
    }

    public void add(char c2) {
        this.curPrefix.append(c2);
        this.findLongestCommonPrefix();
        this.changed = true;
    }

    public void add(String string) {
        this.curPrefix.append(string);
        this.findLongestCommonPrefix();
        this.changed = true;
    }

    public void reset() {
        this.curPrefix.setLength(0);
        this.changed = true;
    }

    public void ungetLastChar() {
        this.curPrefix.deleteCharAt(this.curPrefix.length() - 1);
        this.findShortestCommonPrefix();
        this.changed = true;
    }

    private String getNextChars() {
        StringBuffer stringBuffer = new StringBuffer();
        this.getNextChars(stringBuffer);
        return stringBuffer.toString();
    }

    private int getNextChars(StringBuffer stringBuffer) {
        String string = this.curPrefix.toString();
        int n = string.length();
        int n2 = 0;
        for (int i2 = 0; i2 < this.values.length; ++i2) {
            if (this.values[i2].length() <= n || !this.values[i2].regionMatches(true, 0, string, 0, n)) continue;
            char c2 = this.values[i2].charAt(n);
            ++n2;
            if (stringBuffer.toString().indexOf(c2) != -1) continue;
            stringBuffer.append(c2);
        }
        return n2;
    }

    private void findLongestCommonPrefix() {
        StringBuffer stringBuffer = new StringBuffer();
        int n = this.getNextChars(stringBuffer);
        while (true) {
            stringBuffer.setLength(0);
            if (this.getNextChars(stringBuffer) != n || stringBuffer.length() != 1) break;
            this.curPrefix.append(stringBuffer);
        }
    }

    private void findShortestCommonPrefix() {
        StringBuffer stringBuffer = new StringBuffer();
        int n = this.getNextChars(stringBuffer);
        while (true) {
            stringBuffer.setLength(0);
            if (this.getNextChars(stringBuffer) != n || stringBuffer.length() != 1) break;
            this.curPrefix.deleteCharAt(this.curPrefix.length() - 1);
        }
    }
}

