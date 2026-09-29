/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.modelaccess.IPSpellerModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class IPSpellerModel
extends MatchspellerModel
implements IPSpellerModelApp,
MatchspellerModelGUI {
    private static final char DONT_CARE;
    private static final char BACKSPACE;
    private static final String DOT;
    private static final String VALID_CHARS_FIRST_NUMBER;
    private static final String VALID_CHARS_FOLLOWING_NUMBER;
    private static final String VALID_CHARS_SECOND_NUMBER_2;

    public IPSpellerModel(int n) {
        this(n, 0);
    }

    public IPSpellerModel(int n, int n2) {
        super(n, n2);
        this.setMinLength(15);
        this.setMaxLength(15);
        this.setValidChars("012");
    }

    @Override
    public void textChanged(String string, char c2, int n) {
        this.setStatus(0);
        String string2 = this.determineCurrentInputText(string, c2);
        String string3 = this.determineValidChars(string2);
        this.setText(string2);
        this.setValidChars(string3);
        this.setStatus(1);
    }

    private String determineCurrentInputText(String string, char c2) {
        String string2 = string;
        switch (c2) {
            case '\b': {
                string2 = this.charRemoved(string);
                break;
            }
            case '\u0000': {
                break;
            }
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                string2 = this.addChar(string);
                break;
            }
            default: {
                this.lc.log(10000, "IPSpeller#determineValidChars invalid latest character: %1 - ignore character ", c2);
            }
        }
        return string2;
    }

    private String charRemoved(String string) {
        String string2 = string;
        int n = string2.length();
        if (n > 0 && n - string2.lastIndexOf(".") >= 4) {
            string2 = string2.substring(0, n - 1);
        }
        return string2;
    }

    private String addChar(String string) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        int n = buffer.length();
        if (n == 3) {
            buffer.append(".");
        } else if (n < 15 && n % 4 == 3) {
            buffer.append(".");
        }
        return buffer.toString();
    }

    private String determineValidChars(String string) {
        String string2 = null;
        int n = string.length();
        int n2 = n % 4;
        block0 : switch (n2) {
            case 0: 
            case 3: {
                string2 = "012";
                break;
            }
            case 1: {
                switch (string.charAt(n - 1)) {
                    case '0': 
                    case '1': {
                        string2 = "0123456789";
                        break block0;
                    }
                    case '2': {
                        string2 = "012345";
                        break block0;
                    }
                }
                this.lc.log(10000, "IPSpellerModel#determineValidChars invalid first number: %1 (valid: 0..2) ", string.charAt(n - 1));
                string2 = "";
                break;
            }
            case 2: {
                switch (string.charAt(n - 2)) {
                    case '0': 
                    case '1': {
                        string2 = "0123456789";
                        break block0;
                    }
                    case '2': {
                        if (string.charAt(n - 1) >= '5') {
                            string2 = "012345";
                            break block0;
                        }
                        string2 = "0123456789";
                        break block0;
                    }
                }
                this.lc.log(10000, "IPSpellerModel#determineValidChars invalid first number: %1 (valid: 0..2) ", string.charAt(n - 1));
                string2 = "";
                break;
            }
            default: {
                this.lc.log(10000, "IPSpellerModel#determineValidChars invalid textPosition textPosition: %1 is calulated 'mod 4' ", (long)n2);
                string2 = "";
            }
        }
        if (n == 2 || n == 14) {
            if (string.charAt(n - 2) == '2' && string.charAt(n - 1) == '5') {
                string2 = "01234";
            } else if (string.charAt(n - 2) == '0' && string.charAt(n - 1) == '0') {
                string2 = "123456789";
            }
        } else if (n >= 15) {
            string2 = "";
        }
        return string2;
    }
}

