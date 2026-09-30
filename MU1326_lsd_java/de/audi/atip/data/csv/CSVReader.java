/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    static final char QUOTE = '\"';
    static final char DEFAULT_DELIMITER = ';';
    private final List tmpColumnList = new ArrayList(10);
    private final String delimiterSequence;
    private final char delimiterChar;
    private final String delimiterString;
    private final File file;
    private BufferedReader reader;

    public CSVReader(File file) throws IllegalArgumentException, IOException {
        this(file, ';');
    }

    public CSVReader(File file, char c2) throws IllegalArgumentException, IOException {
        if (file == null) {
            throw new IllegalArgumentException("Parameter csvFile is null!");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("CSV file \"" + file + "\" not found!");
        }
        if (!file.isFile()) {
            throw new IOException("CSV file \"" + file + "\" is not a file!");
        }
        if (!file.canRead()) {
            throw new IOException("CSV file \"" + file + "\" is not readable!");
        }
        String string = String.valueOf('\"');
        this.delimiterSequence = string + c2 + string;
        this.delimiterChar = c2;
        this.delimiterString = String.valueOf(c2);
        this.file = file;
    }

    public String[] readLine() throws IOException {
        try {
            String string;
            if (this.reader == null) {
                this.reader = new BufferedReader(new FileReader(this.file));
            }
            if ((string = this.reader.readLine()) == null) {
                this.reader.close();
                return null;
            }
            return this.parseLine(string);
        }
        catch (IOException iOException) {
            if (this.reader != null) {
                this.reader.close();
            }
            throw iOException;
        }
    }

    String[] parseLine(String string) {
        this.tmpColumnList.clear();
        String string2 = string.trim().substring(1, string.length() - 1);
        String[] stringArray = this.split(string2, 0);
        return this.undoEscapingSpecialCharacters(stringArray);
    }

    String undoEscapingSpecialCharacters(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        for (int i2 = 0; i2 < stringBuffer.length(); ++i2) {
            char c2 = stringBuffer.charAt(i2);
            if (c2 != '\\' || stringBuffer.length() <= i2 + 1) continue;
            char c3 = stringBuffer.charAt(i2 + 1);
            if (c3 == this.delimiterChar) {
                stringBuffer.replace(i2, i2 + 2, this.delimiterString);
                continue;
            }
            if (c3 == '\\') {
                stringBuffer.replace(i2, i2 + 2, "\\");
                continue;
            }
            if (c3 == 'n') {
                stringBuffer.replace(i2, i2 + 2, "\n");
                continue;
            }
            if (c3 != 'r') continue;
            stringBuffer.replace(i2, i2 + 2, "\r");
        }
        return stringBuffer.toString();
    }

    private String[] undoEscapingSpecialCharacters(String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = this.undoEscapingSpecialCharacters(stringArray[i2]);
        }
        return stringArray;
    }

    private String[] split(String string, int n) {
        boolean bl = false;
        int n2 = string.indexOf(this.delimiterSequence, n);
        if (n2 == -1) {
            n2 = string.length();
            bl = true;
        }
        String string2 = string.substring(n, n2);
        this.tmpColumnList.add(string2);
        if (bl) {
            Object[] objectArray = new String[this.tmpColumnList.size()];
            this.tmpColumnList.toArray(objectArray);
            return objectArray;
        }
        return this.split(string, n2 + this.delimiterSequence.length());
    }
}

