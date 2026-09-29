/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.tghu.log.LogExtractorFactory;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class LogExtractorFactory$ByteArrayData {
    private String charset = "UTF-8";
    private int nrStrings;
    private int[] offset;
    private byte[] data;
    private final /* synthetic */ LogExtractorFactory this$0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LogExtractorFactory$ByteArrayData(LogExtractorFactory logExtractorFactory, String string) {
        this.this$0 = logExtractorFactory;
        InputStream inputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            inputStream = LogExtractorFactory.access$000(logExtractorFactory).getResourceAsStream(string);
            if (inputStream == null) {
                System.err.println(new StringBuffer().append("[ERROR] cannot open file: ").append(string).toString());
                System.err.println("[ERROR] ext_log.zip is not in the CLASSPATH!!!");
                return;
            }
            filterInputStream = new DataInputStream(new BufferedInputStream(inputStream, 0xA00000));
            this.nrStrings = ((DataInputStream)filterInputStream).readInt();
            if (this.nrStrings < 0) throw new IOException("Stream data corrupted!");
            this.offset = new int[this.nrStrings + 1];
            for (int i2 = 0; i2 <= this.nrStrings; ++i2) {
                this.offset[i2] = ((DataInputStream)filterInputStream).readInt();
            }
            if (this.offset[this.nrStrings] > 0) {
                this.data = new byte[this.offset[this.nrStrings]];
                ((DataInputStream)filterInputStream).readFully(this.data);
                return;
            }
            if (this.offset[this.nrStrings] != 0) throw new IOException("Stream data corrupted!");
            this.data = new byte[0];
            return;
        }
        catch (Exception exception) {
            System.err.println(new StringBuffer().append("[ERROR] cannot open file: ").append(string).toString());
            System.err.println("[ERROR] ext_log.zip is not in the CLASSPATH!!!");
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        finally {
            if (filterInputStream != null) {
                try {
                    filterInputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
    }

    public String getString(int n) {
        if (n >= 0 && n < this.nrStrings) {
            try {
                return new String(this.data, this.offset[n], this.offset[n + 1] - this.offset[n], this.charset);
            }
            catch (Exception exception) {
                return "[ERROR] ext_log.zip is not in the CLASSPATH!!!";
            }
        }
        return "[ERROR] ext_log.zip is not in the CLASSPATH!!!";
    }
}

