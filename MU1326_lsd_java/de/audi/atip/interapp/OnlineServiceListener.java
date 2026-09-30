/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;
import de.esolutions.fw.util.commons.Buffer;
import java.util.List;

public interface OnlineServiceListener {
    public static final byte REC_RESULT_CONTINUE_DIALOG = 0;
    public static final byte REC_RESULT_END_DIALOG = 1;

    public void updateRemoteHMIList(SDSListEntry[] var1, boolean var2);

    public void updateRemoteHMIGlobalList(SDSListEntry[] var1, boolean var2);

    public void updateRemoteHMIHelpList(SDSListEntry[] var1, boolean var2);

    public void setRemoteHMICategorySetFinished(byte var1);

    public void setDictionary(OnlineSpeechDictionary var1);

    public static class OnlineSpeechDictionary {
        private int type;
        private String language;
        private String format;
        private List dictionaryEntries;

        public OnlineSpeechDictionary(int n, String string, String string2, List list) {
            this.type = n;
            this.format = string2;
            this.language = string;
            this.dictionaryEntries = list;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int n) {
            this.type = n;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setLanguage(String string) {
            this.language = string;
        }

        public String getFormat() {
            return this.format;
        }

        public void setFormat(String string) {
            this.format = string;
        }

        public List getDictionaryEntries() {
            return this.dictionaryEntries;
        }

        public void setDictionaryEntries(List list) {
            this.dictionaryEntries = list;
        }

        public String toString() {
            Buffer buffer = new Buffer(250);
            buffer.append("OnlinePhoneticEntry(");
            buffer.append("format=\"");
            buffer.append(this.format);
            buffer.append('\"');
            buffer.append(',');
            buffer.append("language=\"");
            buffer.append(this.language);
            buffer.append('\"');
            buffer.append(',');
            buffer.append("type=\"");
            buffer.append(this.type);
            buffer.append('\"');
            buffer.append(',');
            buffer.append("dictionary entries=\"");
            buffer.append(this.dictionaryEntries);
            buffer.append('\"');
            buffer.append(')');
            return buffer.toString();
        }
    }
}

