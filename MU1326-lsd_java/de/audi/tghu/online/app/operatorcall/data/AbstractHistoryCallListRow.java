/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.data;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.online.app.Online;
import de.esolutions.fw.util.commons.Buffer;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractHistoryCallListRow
extends EvoListRow {
    protected static long idCount = 1L;
    protected static final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected static final int COLUMN_ID;
    protected static final int COLUMN_NAME;
    protected static final int COLUMN_DATE;
    protected static final int COLUMN_TIME;
    protected static final int COLUMN_NUMBER_OF_POIS;
    protected static final int COLUMN_MULTIPLE_POIS;
    protected static final int COLUMN_COUNT;
    private static final int TYPE_SINGLE_POI;
    private static final int TYPE_MULTIPLE_POI;
    protected Date dateTime;
    private int persistenceUniqueId = -1;

    public abstract void createPropertyListCell(boolean bl) {
    }

    public AbstractHistoryCallListRow(IFrameworkAccess iFrameworkAccess, String string, Date date, boolean bl, int n) {
        super(idCount, 7);
        ++idCount;
        this.dateTime = date != null ? date : new Date(iFrameworkAccess.getKombiTime());
        if (string == null) {
            throw new NullPointerException("AbstractHistoryCallListRow: name is null! Wrong!");
        }
        if (string.equalsIgnoreCase("")) {
            logChannel.log(-1601830656, "AbstractHistoryCallListRow: name is empty! Wrong!");
        }
        this.fillCells(string, this.dateTime, bl, n);
    }

    public AbstractHistoryCallListRow(AbstractHistoryCallListRow abstractHistoryCallListRow) {
        super(abstractHistoryCallListRow);
        this.dateTime = abstractHistoryCallListRow.dateTime;
        this.persistenceUniqueId = abstractHistoryCallListRow.persistenceUniqueId;
    }

    protected String getTimeAsString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    protected final void fillCells(String string, Date date, boolean bl, int n) {
        int n2;
        String string2;
        DateMetric dateMetric = new DateMetric(date, 0);
        DateMetric dateMetric2 = new DateMetric(date, 1);
        this.setLong(0, this.getUniqueID());
        this.setText(1, string);
        this.setMetrics(2, dateMetric);
        this.setMetrics(3, dateMetric2);
        if (n < 2) {
            string2 = "";
            n2 = 0;
        } else {
            string2 = this.getNumberOfPoisAsString(n);
            n2 = 1;
        }
        logChannel.log(14808325, "HistoryCallListRow#fillCells: set number of pois to \"%1\"", (Object)string2);
        this.setText(5, string2);
        this.setInteger(6, n2);
        this.createPropertyListCell(bl);
    }

    private String getNumberOfPoisAsString(int n) {
        Buffer buffer = new Buffer();
        buffer.append("(");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }

    public String getDateAsString() {
        return this.getMetrics(2).format();
    }

    public String getTimeAsString() {
        return this.getMetrics(3).format();
    }

    public String getName() {
        return this.getText(1);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("\nPersistence unique Id = ");
        buffer.append(this.getPersistenceUniqueId());
        buffer.append("\nName = ");
        buffer.append(this.getName());
        buffer.append("\nCategory = ");
        buffer.append(this.getCategory());
        buffer.append("\nNumberOfPois = ");
        buffer.append(String.valueOf(this.getNumberOfPois()));
        buffer.append("\ntypeOfPoi = ");
        buffer.append(this.getTypeOfPois());
        buffer.append("\n");
        return buffer.toString();
    }

    private int getTypeOfPois() {
        return this.getInteger(6);
    }

    public int getCategory() {
        return -1;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public int getNumberOfPois() {
        String string = this.getText(5);
        if (string == null || string.length() == 0) {
            return 1;
        }
        String string2 = string.substring(1, string.length() - 1);
        return Integer.parseInt(string2);
    }

    public static void setNextFreeUniqueId(long l) {
        logChannel.log(-2137614336, "AbstractHistoryCallListRow#setNextFreeUniqueId: starting with unique id = %1", l);
        idCount = l;
    }

    public void setPersistenceUniqueId(int n) {
        logChannel.log(-2137614336, "AbstractHistoryCallListRow#setPersistenceUniqueId: %1 -> %2", (long)this.persistenceUniqueId, (long)n);
        this.persistenceUniqueId = n;
    }

    private int getPersistenceUniqueId() {
        return this.persistenceUniqueId;
    }
}

