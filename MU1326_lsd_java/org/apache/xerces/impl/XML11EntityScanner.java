/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.io.IOException;
import org.apache.xerces.impl.XMLEntityScanner;
import org.apache.xerces.util.XML11Char;
import org.apache.xerces.util.XMLChar;
import org.apache.xerces.util.XMLStringBuffer;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLString;

public class XML11EntityScanner
extends XMLEntityScanner {
    public int peekChar() throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        int n = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        if (this.fCurrentEntity.isExternal()) {
            return n != 13 && n != 133 && n != 8232 ? n : 10;
        }
        return n;
    }

    public int scanChar() throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        int n = this.fCurrentEntity.ch[this.fCurrentEntity.position++];
        boolean bl = false;
        if (n == 10 || (n == 13 || n == 133 || n == 8232) && (bl = this.fCurrentEntity.isExternal())) {
            char c2;
            ++this.fCurrentEntity.lineNumber;
            this.fCurrentEntity.columnNumber = 1;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = (char)n;
                this.load(1, false);
            }
            if (n == 13 && bl && (c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) != '\n' && c2 != '\u0085') {
                --this.fCurrentEntity.position;
            }
            n = 10;
        }
        ++this.fCurrentEntity.columnNumber;
        return n;
    }

    public String scanNmtoken() throws IOException {
        char c2;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        int n = this.fCurrentEntity.position;
        while (true) {
            char c3;
            if (XML11Char.isXML11Name(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position])) {
                if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                c3 = this.fCurrentEntity.position - n;
                if (c3 == this.fCurrentEntity.ch.length) {
                    char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, (int)c3);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, (int)c3);
                }
                n = 0;
                if (!this.load(c3, false)) continue;
                break;
            }
            if (!XML11Char.isXML11NameHighSurrogate(c2)) break;
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                c3 = this.fCurrentEntity.position - n;
                if (c3 == this.fCurrentEntity.ch.length) {
                    char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, (int)c3);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, (int)c3);
                }
                n = 0;
                if (this.load(c3, false)) {
                    --this.fCurrentEntity.startPosition;
                    --this.fCurrentEntity.position;
                    break;
                }
            }
            if (!XMLChar.isLowSurrogate(c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11Name(XMLChar.supplemental(c2, c3))) {
                --this.fCurrentEntity.position;
                break;
            }
            if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
            int n2 = this.fCurrentEntity.position - n;
            if (n2 == this.fCurrentEntity.ch.length) {
                char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, n2);
                this.fCurrentEntity.ch = cArray;
            } else {
                System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, n2);
            }
            n = 0;
            if (this.load(n2, false)) break;
        }
        c2 = this.fCurrentEntity.position - n;
        this.fCurrentEntity.columnNumber += c2;
        String string = null;
        if (c2 > '\u0000') {
            string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, n, c2);
        }
        return string;
    }

    public String scanName() throws IOException {
        char c2;
        int n;
        char c3;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        if (XML11Char.isXML11NameStart(c3 = this.fCurrentEntity.ch[n = this.fCurrentEntity.position++])) {
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                n = 0;
                if (this.load(1, false)) {
                    ++this.fCurrentEntity.columnNumber;
                    String string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
                    return string;
                }
            }
        } else if (XML11Char.isXML11NameHighSurrogate(c3)) {
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                n = 0;
                if (this.load(1, false)) {
                    --this.fCurrentEntity.position;
                    --this.fCurrentEntity.startPosition;
                    return null;
                }
            }
            if (!XMLChar.isLowSurrogate(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11NameStart(XMLChar.supplemental(c3, c2))) {
                --this.fCurrentEntity.position;
                return null;
            }
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                this.fCurrentEntity.ch[1] = c2;
                n = 0;
                if (this.load(2, false)) {
                    this.fCurrentEntity.columnNumber += 2;
                    String string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 2);
                    return string;
                }
            }
        } else {
            return null;
        }
        while (true) {
            if (XML11Char.isXML11Name(c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position])) {
                if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                c2 = this.fCurrentEntity.position - n;
                if (c2 == this.fCurrentEntity.ch.length) {
                    char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, (int)c2);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, (int)c2);
                }
                n = 0;
                if (!this.load(c2, false)) continue;
                break;
            }
            if (!XML11Char.isXML11NameHighSurrogate(c3)) break;
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                c2 = this.fCurrentEntity.position - n;
                if (c2 == this.fCurrentEntity.ch.length) {
                    char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, (int)c2);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, (int)c2);
                }
                n = 0;
                if (this.load(c2, false)) {
                    --this.fCurrentEntity.position;
                    --this.fCurrentEntity.startPosition;
                    break;
                }
            }
            if (!XMLChar.isLowSurrogate(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11Name(XMLChar.supplemental(c3, c2))) {
                --this.fCurrentEntity.position;
                break;
            }
            if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
            int n2 = this.fCurrentEntity.position - n;
            if (n2 == this.fCurrentEntity.ch.length) {
                char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, n2);
                this.fCurrentEntity.ch = cArray;
            } else {
                System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, n2);
            }
            n = 0;
            if (this.load(n2, false)) break;
        }
        c2 = this.fCurrentEntity.position - n;
        this.fCurrentEntity.columnNumber += c2;
        String string = null;
        if (c2 > '\u0000') {
            string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, n, c2);
        }
        return string;
    }

    public String scanNCName() throws IOException {
        char c2;
        int n;
        char c3;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        if (XML11Char.isXML11NCNameStart(c3 = this.fCurrentEntity.ch[n = this.fCurrentEntity.position++])) {
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                n = 0;
                if (this.load(1, false)) {
                    ++this.fCurrentEntity.columnNumber;
                    String string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
                    return string;
                }
            }
        } else if (XML11Char.isXML11NameHighSurrogate(c3)) {
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                n = 0;
                if (this.load(1, false)) {
                    --this.fCurrentEntity.position;
                    --this.fCurrentEntity.startPosition;
                    return null;
                }
            }
            if (!XMLChar.isLowSurrogate(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11NCNameStart(XMLChar.supplemental(c3, c2))) {
                --this.fCurrentEntity.position;
                return null;
            }
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                this.fCurrentEntity.ch[1] = c2;
                n = 0;
                if (this.load(2, false)) {
                    this.fCurrentEntity.columnNumber += 2;
                    String string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 2);
                    return string;
                }
            }
        } else {
            return null;
        }
        while (true) {
            if (XML11Char.isXML11NCName(c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position])) {
                if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                c2 = this.fCurrentEntity.position - n;
                if (c2 == this.fCurrentEntity.ch.length) {
                    char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, (int)c2);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, (int)c2);
                }
                n = 0;
                if (!this.load(c2, false)) continue;
                break;
            }
            if (!XML11Char.isXML11NameHighSurrogate(c3)) break;
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                c2 = this.fCurrentEntity.position - n;
                if (c2 == this.fCurrentEntity.ch.length) {
                    char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, (int)c2);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, (int)c2);
                }
                n = 0;
                if (this.load(c2, false)) {
                    --this.fCurrentEntity.startPosition;
                    --this.fCurrentEntity.position;
                    break;
                }
            }
            if (!XMLChar.isLowSurrogate(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11NCName(XMLChar.supplemental(c3, c2))) {
                --this.fCurrentEntity.position;
                break;
            }
            if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
            int n2 = this.fCurrentEntity.position - n;
            if (n2 == this.fCurrentEntity.ch.length) {
                char[] cArray = new char[this.fCurrentEntity.ch.length << 1];
                System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)cArray, 0, n2);
                this.fCurrentEntity.ch = cArray;
            } else {
                System.arraycopy((Object)this.fCurrentEntity.ch, n, (Object)this.fCurrentEntity.ch, 0, n2);
            }
            n = 0;
            if (this.load(n2, false)) break;
        }
        c2 = this.fCurrentEntity.position - n;
        this.fCurrentEntity.columnNumber += c2;
        String string = null;
        if (c2 > '\u0000') {
            string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, n, c2);
        }
        return string;
    }

    public boolean scanQName(QName qName) throws IOException {
        Object object;
        char c2;
        int n;
        int n2;
        char c3;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        if (XML11Char.isXML11NCNameStart(c3 = this.fCurrentEntity.ch[n2 = this.fCurrentEntity.position++])) {
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                n2 = 0;
                if (this.load(1, false)) {
                    ++this.fCurrentEntity.columnNumber;
                    String string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
                    qName.setValues(null, string, string, null);
                    return true;
                }
            }
        } else if (XML11Char.isXML11NameHighSurrogate(c3)) {
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                n2 = 0;
                if (this.load(1, false)) {
                    --this.fCurrentEntity.startPosition;
                    --this.fCurrentEntity.position;
                    return false;
                }
            }
            if (!XMLChar.isLowSurrogate(n = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11NCNameStart(XMLChar.supplemental(c3, (char)n))) {
                --this.fCurrentEntity.position;
                return false;
            }
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c3;
                this.fCurrentEntity.ch[1] = n;
                n2 = 0;
                if (this.load(2, false)) {
                    this.fCurrentEntity.columnNumber += 2;
                    String string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 2);
                    qName.setValues(null, string, string, null);
                    return true;
                }
            }
        } else {
            return false;
        }
        n = -1;
        boolean bl = false;
        while (true) {
            char[] cArray;
            if (XML11Char.isXML11Name(c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position])) {
                if (c3 == ':') {
                    if (n != -1) break;
                    n = this.fCurrentEntity.position;
                }
                if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                c2 = this.fCurrentEntity.position - n2;
                if (c2 == this.fCurrentEntity.ch.length) {
                    cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n2, (Object)cArray, 0, (int)c2);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n2, (Object)this.fCurrentEntity.ch, 0, (int)c2);
                }
                if (n != -1) {
                    n -= n2;
                }
                n2 = 0;
                if (!this.load(c2, false)) continue;
                break;
            }
            if (!XML11Char.isXML11NameHighSurrogate(c3)) break;
            if (++this.fCurrentEntity.position == this.fCurrentEntity.count) {
                c2 = this.fCurrentEntity.position - n2;
                if (c2 == this.fCurrentEntity.ch.length) {
                    cArray = new char[this.fCurrentEntity.ch.length << 1];
                    System.arraycopy((Object)this.fCurrentEntity.ch, n2, (Object)cArray, 0, (int)c2);
                    this.fCurrentEntity.ch = cArray;
                } else {
                    System.arraycopy((Object)this.fCurrentEntity.ch, n2, (Object)this.fCurrentEntity.ch, 0, (int)c2);
                }
                if (n != -1) {
                    n -= n2;
                }
                n2 = 0;
                if (this.load(c2, false)) {
                    bl = true;
                    --this.fCurrentEntity.startPosition;
                    --this.fCurrentEntity.position;
                    break;
                }
            }
            if (!XMLChar.isLowSurrogate(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) || !XML11Char.isXML11Name(XMLChar.supplemental(c3, c2))) {
                bl = true;
                --this.fCurrentEntity.position;
                break;
            }
            if (++this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
            int n3 = this.fCurrentEntity.position - n2;
            if (n3 == this.fCurrentEntity.ch.length) {
                object = new char[this.fCurrentEntity.ch.length << 1];
                System.arraycopy((Object)this.fCurrentEntity.ch, n2, object, 0, n3);
                this.fCurrentEntity.ch = (char[])object;
            } else {
                System.arraycopy((Object)this.fCurrentEntity.ch, n2, (Object)this.fCurrentEntity.ch, 0, n3);
            }
            if (n != -1) {
                n -= n2;
            }
            n2 = 0;
            if (this.load(n3, false)) break;
        }
        c2 = this.fCurrentEntity.position - n2;
        this.fCurrentEntity.columnNumber += c2;
        if (c2 > '\u0000') {
            String string = null;
            object = null;
            String string2 = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, n2, c2);
            if (n != -1) {
                int n4 = n - n2;
                string = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, n2, n4);
                int n5 = c2 - n4 - 1;
                int n6 = n + 1;
                if (!(XML11Char.isXML11NCNameStart(this.fCurrentEntity.ch[n6]) || XML11Char.isXML11NameHighSurrogate(this.fCurrentEntity.ch[n6]) && !bl)) {
                    this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "IllegalQName", null, (short)2);
                }
                object = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, n + 1, n5);
            } else {
                object = string2;
            }
            qName.setValues(string, (String)object, string2, null);
            return true;
        }
        return false;
    }

    public int scanContent(XMLString xMLString) throws IOException {
        int n;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        } else if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
            this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[this.fCurrentEntity.count - 1];
            this.load(1, false);
            this.fCurrentEntity.position = 0;
            this.fCurrentEntity.startPosition = 0;
        }
        int n2 = this.fCurrentEntity.position;
        int n3 = this.fCurrentEntity.ch[n2];
        int n4 = 0;
        boolean bl = this.fCurrentEntity.isExternal();
        if (n3 == 10 || (n3 == 13 || n3 == 133 || n3 == 8232) && bl) {
            do {
                if ((n3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) == 13 && bl) {
                    ++n4;
                    ++this.fCurrentEntity.lineNumber;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                        n2 = 0;
                        this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                        this.fCurrentEntity.position = n4;
                        this.fCurrentEntity.startPosition = n4;
                        if (this.load(n4, false)) break;
                    }
                    if ((n = this.fCurrentEntity.ch[this.fCurrentEntity.position]) == 10 || n == 133) {
                        ++this.fCurrentEntity.position;
                        ++n2;
                        continue;
                    }
                    ++n4;
                    continue;
                }
                if (n3 == 10 || (n3 == 133 || n3 == 8232) && bl) {
                    ++n4;
                    ++this.fCurrentEntity.lineNumber;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                    n2 = 0;
                    this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                    this.fCurrentEntity.position = n4;
                    this.fCurrentEntity.startPosition = n4;
                    if (!this.load(n4, false)) continue;
                    break;
                }
                --this.fCurrentEntity.position;
                break;
            } while (this.fCurrentEntity.position < this.fCurrentEntity.count - 1);
            for (n = n2; n < this.fCurrentEntity.position; ++n) {
                this.fCurrentEntity.ch[n] = 10;
            }
            n = this.fCurrentEntity.position - n2;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                xMLString.setValues(this.fCurrentEntity.ch, n2, n);
                return -1;
            }
        }
        if (bl) {
            while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                if (XML11Char.isXML11Content(n3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) && n3 != 133 && n3 != 8232) continue;
                --this.fCurrentEntity.position;
                break;
            }
        } else {
            while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                if (XML11Char.isXML11InternalEntityContent(n3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++])) continue;
                --this.fCurrentEntity.position;
                break;
            }
        }
        n = this.fCurrentEntity.position - n2;
        this.fCurrentEntity.columnNumber += n - n4;
        xMLString.setValues(this.fCurrentEntity.ch, n2, n);
        if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
            n3 = this.fCurrentEntity.ch[this.fCurrentEntity.position];
            if ((n3 == 13 || n3 == 133 || n3 == 8232) && bl) {
                n3 = 10;
            }
        } else {
            n3 = -1;
        }
        return n3;
    }

    public int scanLiteral(int n, XMLString xMLString) throws IOException {
        int n2;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        } else if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
            this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[this.fCurrentEntity.count - 1];
            this.load(1, false);
            this.fCurrentEntity.startPosition = 0;
            this.fCurrentEntity.position = 0;
        }
        int n3 = this.fCurrentEntity.position;
        int n4 = this.fCurrentEntity.ch[n3];
        int n5 = 0;
        boolean bl = this.fCurrentEntity.isExternal();
        if (n4 == 10 || (n4 == 13 || n4 == 133 || n4 == 8232) && bl) {
            do {
                if ((n4 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) == 13 && bl) {
                    ++n5;
                    ++this.fCurrentEntity.lineNumber;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                        n3 = 0;
                        this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                        this.fCurrentEntity.position = n5;
                        this.fCurrentEntity.startPosition = n5;
                        if (this.load(n5, false)) break;
                    }
                    if ((n2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) == 10 || n2 == 133) {
                        ++this.fCurrentEntity.position;
                        ++n3;
                        continue;
                    }
                    ++n5;
                    continue;
                }
                if (n4 == 10 || (n4 == 133 || n4 == 8232) && bl) {
                    ++n5;
                    ++this.fCurrentEntity.lineNumber;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                    n3 = 0;
                    this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                    this.fCurrentEntity.position = n5;
                    this.fCurrentEntity.startPosition = n5;
                    if (!this.load(n5, false)) continue;
                    break;
                }
                --this.fCurrentEntity.position;
                break;
            } while (this.fCurrentEntity.position < this.fCurrentEntity.count - 1);
            for (n2 = n3; n2 < this.fCurrentEntity.position; ++n2) {
                this.fCurrentEntity.ch[n2] = 10;
            }
            n2 = this.fCurrentEntity.position - n3;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                xMLString.setValues(this.fCurrentEntity.ch, n3, n2);
                return -1;
            }
        }
        if (bl) {
            while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                if ((n4 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) != n && n4 != 37 && XML11Char.isXML11Content(n4) && n4 != 133 && n4 != 8232) continue;
                --this.fCurrentEntity.position;
                break;
            }
        } else {
            while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                if (((n4 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) != n || this.fCurrentEntity.literal) && n4 != 37 && XML11Char.isXML11InternalEntityContent(n4)) continue;
                --this.fCurrentEntity.position;
                break;
            }
        }
        n2 = this.fCurrentEntity.position - n3;
        this.fCurrentEntity.columnNumber += n2 - n5;
        xMLString.setValues(this.fCurrentEntity.ch, n3, n2);
        if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
            n4 = this.fCurrentEntity.ch[this.fCurrentEntity.position];
            if (n4 == n && this.fCurrentEntity.literal) {
                n4 = -1;
            }
        } else {
            n4 = -1;
        }
        return n4;
    }

    public boolean scanData(String string, XMLStringBuffer xMLStringBuffer) throws IOException {
        boolean bl = false;
        int n = string.length();
        char c2 = string.charAt(0);
        boolean bl2 = this.fCurrentEntity.isExternal();
        do {
            int n2;
            int n3;
            int n4;
            block25: {
                int n5;
                if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                    this.load(0, true);
                }
                boolean bl3 = false;
                while (this.fCurrentEntity.position >= this.fCurrentEntity.count - n && !bl3) {
                    System.arraycopy((Object)this.fCurrentEntity.ch, this.fCurrentEntity.position, (Object)this.fCurrentEntity.ch, 0, this.fCurrentEntity.count - this.fCurrentEntity.position);
                    bl3 = this.load(this.fCurrentEntity.count - this.fCurrentEntity.position, false);
                    this.fCurrentEntity.position = 0;
                    this.fCurrentEntity.startPosition = 0;
                }
                if (this.fCurrentEntity.position >= this.fCurrentEntity.count - n) {
                    n4 = this.fCurrentEntity.count - this.fCurrentEntity.position;
                    xMLStringBuffer.append(this.fCurrentEntity.ch, this.fCurrentEntity.position, n4);
                    this.fCurrentEntity.columnNumber += this.fCurrentEntity.count;
                    this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                    this.fCurrentEntity.position = this.fCurrentEntity.count;
                    this.fCurrentEntity.startPosition = this.fCurrentEntity.count;
                    this.load(0, true);
                    return false;
                }
                n4 = this.fCurrentEntity.position;
                char c3 = this.fCurrentEntity.ch[n4];
                n3 = 0;
                if (c3 == '\n' || (c3 == '\r' || c3 == '\u0085' || c3 == '\u2028') && bl2) {
                    do {
                        if ((c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) == '\r' && bl2) {
                            ++n3;
                            ++this.fCurrentEntity.lineNumber;
                            this.fCurrentEntity.columnNumber = 1;
                            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                                n4 = 0;
                                this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                                this.fCurrentEntity.position = n3;
                                this.fCurrentEntity.startPosition = n3;
                                if (this.load(n3, false)) break;
                            }
                            if ((n2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) == 10 || n2 == 133) {
                                ++this.fCurrentEntity.position;
                                ++n4;
                                continue;
                            }
                            ++n3;
                            continue;
                        }
                        if (c3 == '\n' || (c3 == '\u0085' || c3 == '\u2028') && bl2) {
                            ++n3;
                            ++this.fCurrentEntity.lineNumber;
                            this.fCurrentEntity.columnNumber = 1;
                            if (this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                            n4 = 0;
                            this.fCurrentEntity.baseCharOffset += this.fCurrentEntity.position - this.fCurrentEntity.startPosition;
                            this.fCurrentEntity.position = n3;
                            this.fCurrentEntity.startPosition = n3;
                            this.fCurrentEntity.count = n3;
                            if (!this.load(n3, false)) continue;
                            break;
                        }
                        --this.fCurrentEntity.position;
                        break;
                    } while (this.fCurrentEntity.position < this.fCurrentEntity.count - 1);
                    for (n2 = n4; n2 < this.fCurrentEntity.position; ++n2) {
                        this.fCurrentEntity.ch[n2] = 10;
                    }
                    n2 = this.fCurrentEntity.position - n4;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                        xMLStringBuffer.append(this.fCurrentEntity.ch, n4, n2);
                        return true;
                    }
                }
                if (bl2) {
                    while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                        if ((c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) == c2) {
                            n2 = this.fCurrentEntity.position - 1;
                            for (n5 = 1; n5 < n; ++n5) {
                                if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                                    this.fCurrentEntity.position -= n5;
                                    break block25;
                                }
                                c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++];
                                if (string.charAt(n5) == c3) continue;
                                --this.fCurrentEntity.position;
                                break;
                            }
                            if (this.fCurrentEntity.position != n2 + n) continue;
                            bl = true;
                            break;
                        }
                        if (c3 == '\n' || c3 == '\r' || c3 == '\u0085' || c3 == '\u2028') {
                            --this.fCurrentEntity.position;
                            break;
                        }
                        if (XML11Char.isXML11ValidLiteral(c3)) continue;
                        --this.fCurrentEntity.position;
                        n2 = this.fCurrentEntity.position - n4;
                        this.fCurrentEntity.columnNumber += n2 - n3;
                        xMLStringBuffer.append(this.fCurrentEntity.ch, n4, n2);
                        return true;
                    }
                } else {
                    while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                        if ((c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) == c2) {
                            n2 = this.fCurrentEntity.position - 1;
                            for (n5 = 1; n5 < n; ++n5) {
                                if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                                    this.fCurrentEntity.position -= n5;
                                    break block25;
                                }
                                c3 = this.fCurrentEntity.ch[this.fCurrentEntity.position++];
                                if (string.charAt(n5) == c3) continue;
                                --this.fCurrentEntity.position;
                                break;
                            }
                            if (this.fCurrentEntity.position != n2 + n) continue;
                            bl = true;
                            break;
                        }
                        if (c3 == '\n') {
                            --this.fCurrentEntity.position;
                            break;
                        }
                        if (XML11Char.isXML11Valid(c3)) continue;
                        --this.fCurrentEntity.position;
                        n2 = this.fCurrentEntity.position - n4;
                        this.fCurrentEntity.columnNumber += n2 - n3;
                        xMLStringBuffer.append(this.fCurrentEntity.ch, n4, n2);
                        return true;
                    }
                }
            }
            n2 = this.fCurrentEntity.position - n4;
            this.fCurrentEntity.columnNumber += n2 - n3;
            if (bl) {
                n2 -= n;
            }
            xMLStringBuffer.append(this.fCurrentEntity.ch, n4, n2);
        } while (!bl);
        return !bl;
    }

    public boolean skipChar(int n) throws IOException {
        char c2;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        if ((c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]) == n) {
            ++this.fCurrentEntity.position;
            if (n == 10) {
                ++this.fCurrentEntity.lineNumber;
                this.fCurrentEntity.columnNumber = 1;
            } else {
                ++this.fCurrentEntity.columnNumber;
            }
            return true;
        }
        if (n == 10 && (c2 == '\u2028' || c2 == '\u0085') && this.fCurrentEntity.isExternal()) {
            ++this.fCurrentEntity.position;
            ++this.fCurrentEntity.lineNumber;
            this.fCurrentEntity.columnNumber = 1;
            return true;
        }
        if (n == 10 && c2 == '\r' && this.fCurrentEntity.isExternal()) {
            char c3;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                this.fCurrentEntity.ch[0] = c2;
                this.load(1, false);
            }
            if ((c3 = this.fCurrentEntity.ch[++this.fCurrentEntity.position]) == '\n' || c3 == '\u0085') {
                ++this.fCurrentEntity.position;
            }
            ++this.fCurrentEntity.lineNumber;
            this.fCurrentEntity.columnNumber = 1;
            return true;
        }
        return false;
    }

    public boolean skipSpaces() throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        char c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        if (this.fCurrentEntity.isExternal()) {
            if (XML11Char.isXML11Space(c2)) {
                do {
                    boolean bl = false;
                    if (c2 == '\n' || c2 == '\r' || c2 == '\u0085' || c2 == '\u2028') {
                        char c3;
                        ++this.fCurrentEntity.lineNumber;
                        this.fCurrentEntity.columnNumber = 1;
                        if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                            this.fCurrentEntity.ch[0] = c2;
                            bl = this.load(1, true);
                            if (!bl) {
                                this.fCurrentEntity.startPosition = 0;
                                this.fCurrentEntity.position = 0;
                            }
                        }
                        if (c2 == '\r' && (c3 = this.fCurrentEntity.ch[++this.fCurrentEntity.position]) != '\n' && c3 != '\u0085') {
                            --this.fCurrentEntity.position;
                        }
                    } else {
                        ++this.fCurrentEntity.columnNumber;
                    }
                    if (!bl) {
                        ++this.fCurrentEntity.position;
                    }
                    if (this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                    this.load(0, true);
                } while (XML11Char.isXML11Space(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]));
                return true;
            }
        } else if (XMLChar.isSpace(c2)) {
            do {
                boolean bl = false;
                if (c2 == '\n') {
                    ++this.fCurrentEntity.lineNumber;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                        this.fCurrentEntity.ch[0] = c2;
                        bl = this.load(1, true);
                        if (!bl) {
                            this.fCurrentEntity.startPosition = 0;
                            this.fCurrentEntity.position = 0;
                        }
                    }
                } else {
                    ++this.fCurrentEntity.columnNumber;
                }
                if (!bl) {
                    ++this.fCurrentEntity.position;
                }
                if (this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
                this.load(0, true);
            } while (XMLChar.isSpace(c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position]));
            return true;
        }
        return false;
    }

    public boolean skipString(String string) throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            this.load(0, true);
        }
        int n = string.length();
        for (int i2 = 0; i2 < n; ++i2) {
            char c2;
            if ((c2 = this.fCurrentEntity.ch[this.fCurrentEntity.position++]) != string.charAt(i2)) {
                this.fCurrentEntity.position -= i2 + 1;
                return false;
            }
            if (i2 >= n - 1 || this.fCurrentEntity.position != this.fCurrentEntity.count) continue;
            System.arraycopy((Object)this.fCurrentEntity.ch, this.fCurrentEntity.count - i2 - 1, (Object)this.fCurrentEntity.ch, 0, i2 + 1);
            if (!this.load(i2 + 1, false)) continue;
            this.fCurrentEntity.startPosition -= i2 + 1;
            this.fCurrentEntity.position -= i2 + 1;
            return false;
        }
        this.fCurrentEntity.columnNumber += n;
        return true;
    }
}

