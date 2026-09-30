/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private final File file;
    private final char delimiterChar;
    private boolean isNotFirstLine = false;
    private BufferedWriter writer;

    public CSVWriter(File file) throws IOException {
        this(file, ';');
    }

    public CSVWriter(File file, char c2) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Parameter csvFile is null!");
        }
        file.createNewFile();
        if (!file.isFile()) {
            throw new IOException("CSV file \"" + file + "\" is not a file!");
        }
        this.delimiterChar = c2;
        this.file = file;
    }

    public void writeLine(String[] stringArray) throws IOException {
        try {
            if (this.writer == null) {
                this.writer = new BufferedWriter(new FileWriter(this.file));
            }
            if (this.isNotFirstLine) {
                this.writer.newLine();
            }
            this.writer.write(this.composeLine(stringArray));
            this.isNotFirstLine = true;
        }
        catch (IOException iOException) {
            this.close();
            throw iOException;
        }
    }

    public void close() throws IOException {
        if (this.writer != null) {
            this.writer.close();
        }
    }

    String composeLine(String[] stringArray) {
        StringBuffer stringBuffer = new StringBuffer(this.calculateBufferSize(stringArray));
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringBuffer.append(this.delimiterChar);
            stringBuffer.append('\"');
            stringBuffer.append(this.escapeSpecialCharacters(stringArray[i2]));
            stringBuffer.append('\"');
        }
        return stringBuffer.substring(1);
    }

    String escapeSpecialCharacters(String string) {
        StringBuffer stringBuffer = new StringBuffer(string.length() * 2);
        stringBuffer.append(string);
        for (int i2 = stringBuffer.length() - 1; i2 >= 0; --i2) {
            char c2 = stringBuffer.charAt(i2);
            if (c2 == this.delimiterChar) {
                stringBuffer.insert(i2, '\\');
                continue;
            }
            if (c2 == '\n') {
                stringBuffer.replace(i2, i2 + 1, "\\n");
                continue;
            }
            if (c2 == '\r') {
                stringBuffer.replace(i2, i2 + 1, "\\r");
                continue;
            }
            if (c2 != '\\') continue;
            stringBuffer.replace(i2, i2 + 1, "\\\\");
        }
        return stringBuffer.toString();
    }

    private int calculateBufferSize(String[] stringArray) {
        int n = 0;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            n += stringArray[i2].length();
            n += 3;
        }
        return n + 20;
    }
}

