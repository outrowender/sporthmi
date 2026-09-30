/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.data.exchange;

import de.audi.atip.data.csv.CSVReader;
import de.audi.atip.data.csv.CSVWriter;
import de.audi.atip.data.exchange.DataImportExport;
import de.audi.atip.data.exchange.ExchangeData;
import de.audi.atip.data.exchange.ExchangeRecord;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImportExportManager {
    private final List serviceList = new ArrayList(10);
    private final LogChannel lc;

    public ImportExportManager(LogChannel logChannel) {
        this.lc = logChannel;
    }

    public void addService(DataImportExport dataImportExport) {
        this.lc.log(10000000, "ImportExportManager.addService(%2, %1) ", (Object)dataImportExport, (long)dataImportExport.getApplicationID());
        this.serviceList.add(dataImportExport);
    }

    public void removeService(DataImportExport dataImportExport) {
        this.lc.log(10000000, "ImportExportManager.removeService( %1 ) ", (long)dataImportExport.getApplicationID());
        this.serviceList.remove(dataImportExport);
    }

    public boolean importFromCSV(File file) {
        this.lc.log(10000000, "ImportExportManager.importFromCSV( %1 ) ", (Object)file);
        try {
            Object[] objectArray;
            SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(20);
            this.lc.log(10000000, "ImportExportManager.importFromCSV(): Start parsing CSV file... ");
            CSVReader cSVReader = new CSVReader(file);
            while ((objectArray = cSVReader.readLine()) != null) {
                try {
                    ExchangeRecord exchangeRecord = new ExchangeRecord((String[])objectArray);
                    ExchangeData exchangeData = (ExchangeData)simpleIntObjectMap.get(exchangeRecord.getApp());
                    if (exchangeData == null) {
                        exchangeData = new ExchangeData(exchangeRecord.getApp());
                        simpleIntObjectMap.add(exchangeRecord.getApp(), exchangeData);
                    }
                    exchangeData.add(exchangeRecord);
                }
                catch (Exception exception) {
                    this.lc.log(10000, "ImportExportManager.importFromCSV(): Import of record %1 failed! ", (Object)this.toString(objectArray), (Throwable)exception);
                }
            }
            this.lc.log(10000000, "ImportExportManager.importFromCSV(): CSV file successfully parsed. ");
            boolean bl = true;
            int n = this.serviceList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                DataImportExport dataImportExport = (DataImportExport)this.serviceList.get(i2);
                int n2 = dataImportExport.getApplicationID();
                ExchangeData exchangeData = (ExchangeData)simpleIntObjectMap.get(n2);
                if (exchangeData == null) {
                    this.lc.log(1000000, "ImportExportManager.importFromCSV(): There is no import data for application %1 ", (long)n2);
                    continue;
                }
                this.lc.log(10000000, "ImportExportManager.importFromCSV(): Importing %1 records for application %2 ... ", (long)exchangeData.size(), (long)n2);
                boolean bl2 = dataImportExport.importData(exchangeData);
                bl = bl && bl2;
            }
            this.lc.log(10000000, "ImportExportManager.importFromCSV(): Import finished ");
            return bl;
        }
        catch (Exception exception) {
            this.lc.log(10000, "ImportExportManager.importFromCSV( %1 ) failed! ", (Object)file, (Throwable)exception);
            return false;
        }
    }

    public boolean exportToCSV(File file) {
        this.lc.log(10000000, "ImportExportManager.exportToCSV( %1 ) ", (Object)file);
        try {
            ExchangeRecord[] exchangeRecordArray;
            int n;
            CSVWriter cSVWriter = new CSVWriter(file);
            ExchangeData[] exchangeDataArray = new ExchangeData[this.serviceList.size()];
            for (n = 0; n < exchangeDataArray.length; ++n) {
                exchangeRecordArray = (ExchangeRecord[])this.serviceList.get(n);
                exchangeDataArray[n] = new ExchangeData(exchangeRecordArray.getApplicationID());
                this.lc.log(10000000, "ImportExportManager.exportToCSV(): Request data from app %1 ", (long)exchangeDataArray[n].app);
                exchangeRecordArray.exportData(exchangeDataArray[n]);
            }
            for (n = 0; n < exchangeDataArray.length; ++n) {
                exchangeRecordArray = exchangeDataArray[n].getSortedRecords();
                this.lc.log(10000000, "ImportExportManager.exportToCSV(): Write %1 records from app %2 to file ", (long)exchangeRecordArray.length, (long)exchangeDataArray[n].app);
                for (int i2 = 0; i2 < exchangeRecordArray.length; ++i2) {
                    cSVWriter.writeLine(exchangeRecordArray[i2].toCSV());
                }
            }
            cSVWriter.close();
            this.lc.log(10000000, "ImportExportManager.exportToCSV(): Export finished ");
            return true;
        }
        catch (Exception exception) {
            this.lc.log(10000, "ImportExportManager.exportToCSV( %1 ) failed! ", (Object)file, (Throwable)exception);
            return false;
        }
    }

    private String toString(Object[] objectArray) {
        if (objectArray == null) {
            return "null";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            buffer.append(',');
            buffer.append(objectArray[i2]);
        }
        return buffer.substring(1);
    }
}

