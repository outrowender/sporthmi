/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallInformation {
    private final int uniqueId;
    private final String name;
    private final Date dateTime;
    private final OperatorCallResult[] results;

    public OperatorCallInformation(int n, String string, Date date, OperatorCallResult[] operatorCallResultArray) {
        this.uniqueId = n;
        this.name = string;
        this.dateTime = date;
        this.results = operatorCallResultArray;
    }

    public String getName() {
        return this.name;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public OperatorCallResult[] getResults() {
        return this.results;
    }

    public int getUniqueId() {
        return this.uniqueId;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("name = ");
        buffer.append(this.name);
        buffer.append("\ndate = ");
        buffer.append(this.dateTime);
        for (int i2 = 0; i2 < this.results.length; ++i2) {
            buffer.append("\nresult = ");
            buffer.append(this.results);
        }
        return buffer.toString();
    }
}

