/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import de.eso.remotehmi.xpath.AttributePathEntry;
import de.eso.remotehmi.xpath.ElementPathEntry;
import de.eso.remotehmi.xpath.FunctionPathEntry;
import de.eso.remotehmi.xpath.SelectorEqualsPathEntry;
import de.eso.remotehmi.xpath.SelectorPathEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoorMansXPathParser {
    private static final int TOKEN_UNKNOWN = 0;
    private static final int TOKEN_NAME = 1;
    private static final int TOKEN_SELECTOR = 2;
    private static final int TOKEN_SELECTOR_LEFT = 3;
    private static final int TOKEN_SELECTOR_LEFT_ATTRIBUTE = 5;
    private static final int TOKEN_SELECTOR_RIGHT = 4;
    private static final int TOKEN_ATTRIBUTE = 6;
    private static final int TOKEN_FUNCTION = 7;
    private List items;
    private int currentToken;
    private int startPtr;
    private int ptr;
    private char c;
    private String toParse;
    private String prefix;
    private String attributeLeftName;

    private boolean isNameChar(char c2) {
        return c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '1' && c2 <= '9' || c2 == '0';
    }

    public AbstractPathEntry[] parse(Map map, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        this.toParse = string + '\u0000';
        this.ptr = 0;
        this.startPtr = 0;
        this.currentToken = 0;
        this.items = new ArrayList(10);
        this.prefix = null;
        while (this.ptr < this.toParse.length()) {
            this.c = this.toParse.charAt(this.ptr);
            switch (this.currentToken) {
                case 0: {
                    if (this.isNameChar(this.c)) {
                        this.currentToken = 1;
                        break;
                    }
                    if (this.c == '\u0000') break;
                    if (this.c == '@') {
                        this.currentToken = 6;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 1: {
                    if (this.isNameChar(this.c)) break;
                    if (this.c == ':') {
                        this.prefix = this.toParse.substring(this.startPtr, this.ptr);
                        this.startPtr = this.ptr + 1;
                        break;
                    }
                    if (this.c == '/' || this.c == '\u0000') {
                        this.pushElement();
                        this.currentToken = 0;
                        break;
                    }
                    if (this.c == '[') {
                        this.pushElement();
                        this.currentToken = 2;
                        break;
                    }
                    if (this.c == '(') {
                        this.currentToken = 7;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 2: {
                    if (this.isNameChar(this.c)) {
                        this.currentToken = 3;
                        break;
                    }
                    if (this.c == '@') {
                        this.currentToken = 5;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 3: {
                    if (this.isNameChar(this.c) || this.c == '.' || this.c == ']') break;
                    if (this.c == '/' || this.c == '\u0000') {
                        this.pushSelector();
                        this.currentToken = 0;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 5: {
                    if (this.isNameChar(this.c) || this.c == ' ') break;
                    if (this.c == '=') {
                        this.attributeLeftName = this.toParse.substring(this.startPtr, this.ptr);
                        this.startPtr = this.ptr + 1;
                        this.currentToken = 4;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 4: {
                    if (this.isNameChar(this.c) || this.c == '.' || this.c == '-' || this.c == '\'' || this.c == '\"' || this.c == ' ' || this.c == ']') break;
                    if (this.c == '\u0000' || this.c == '/') {
                        this.pushEqualsSelector();
                        this.currentToken = 0;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 6: {
                    if (this.isNameChar(this.c)) break;
                    if (this.c == '\u0000' || this.c == '/' || this.c == '\"') {
                        this.pushAttribute();
                        this.currentToken = 0;
                        break;
                    }
                    this.error("Invalid character.");
                    break;
                }
                case 7: {
                    if (this.c == ')') break;
                    if (this.c == '\u0000' || this.c == '/') {
                        this.pushFunction();
                        break;
                    }
                    this.error("Invalid character (no parameters allowed).");
                    break;
                }
                default: {
                    this.error("Unknown token.");
                }
            }
            ++this.ptr;
        }
        AbstractPathEntry[] abstractPathEntryArray = new AbstractPathEntry[this.items.size()];
        for (int i2 = 0; i2 < this.items.size(); ++i2) {
            abstractPathEntryArray[i2] = (AbstractPathEntry)this.items.get(i2);
        }
        return abstractPathEntryArray;
    }

    private void pushEqualsSelector() {
        String string = this.attributeLeftName;
        if ((string = string.trim()).charAt(0) != '@') {
            throw new RuntimeException("Only attributes (@) allowed on left-hand side.");
        }
        string = string.substring(1);
        String string2 = this.toParse.substring(this.startPtr, this.ptr);
        if (string2.charAt(string2.length() - 1) == ']') {
            string2 = string2.substring(0, string2.length() - 1);
        }
        if (!((string2 = string2.trim()).charAt(0) != '\'' && string2.charAt(string2.length() - 1) != '\'' || string2.charAt(0) != '\"' && string2.charAt(string2.length() - 1) != '\"')) {
            throw new RuntimeException("Only strings allowed on right-hand side.");
        }
        string2 = string2.substring(1, string2.length() - 1);
        this.items.add(new SelectorEqualsPathEntry(string, string2));
        this.startPtr = this.ptr + 1;
    }

    private void pushSelector() {
        String string = this.toParse.substring(this.startPtr, this.ptr);
        if (string.charAt(string.length() - 1) == ']') {
            string = string.substring(0, string.length() - 1);
        }
        this.items.add(new SelectorPathEntry(string));
        this.startPtr = this.ptr + 1;
    }

    private void pushElement() {
        String string = this.toParse.substring(this.startPtr, this.ptr);
        if (this.prefix == null) {
            this.prefix = "";
        }
        this.items.add(new ElementPathEntry(string, this.prefix));
        this.startPtr = this.ptr + 1;
        this.prefix = null;
    }

    private void pushFunction() {
        String string = this.toParse.substring(this.startPtr, this.ptr);
        this.items.add(new FunctionPathEntry(string));
        this.startPtr = this.ptr + 1;
        this.prefix = null;
    }

    private void pushAttribute() {
        String string = this.toParse.substring(this.startPtr + 1, this.ptr);
        if (this.prefix == null) {
            this.prefix = "";
        }
        this.items.add(new AttributePathEntry(string));
        this.startPtr = this.ptr + 1;
        this.prefix = null;
    }

    private void error(String string) {
        throw new RuntimeException(string + ", token " + this.currentToken + ", character " + this.c + ", index " + this.ptr);
    }
}

