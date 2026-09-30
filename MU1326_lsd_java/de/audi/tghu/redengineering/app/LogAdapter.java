/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.ISLOGSink;
import de.audi.atip.log.IStandardConsoleLogSink;
import de.audi.atip.log.ITraceClientLogSink;
import de.audi.atip.log.LogSink;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAdapter {
    private final LogAdapterHMIHandler hmi;
    private LogSink activeSink;
    private Map cats;
    private LogSink[] logSinks;
    private Map backupConfig;
    private final EngineeringEnv engineeringEnv;

    public LogAdapter(EngineeringEnv engineeringEnv) {
        this.engineeringEnv = engineeringEnv;
        this.hmi = new LogAdapterHMIHandler(this, engineeringEnv);
        this.logSinks = this.getLogSinks();
        for (int i2 = 0; i2 < this.logSinks.length; ++i2) {
            if (!(this.logSinks[i2] instanceof IStandardConsoleLogSink)) continue;
            this.activeSink = this.logSinks[i2];
            break;
        }
    }

    private final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    void storeEngState(int n) {
        IStorageAccess iStorageAccess = this.getEngineeringEnv().getStorageMgr();
        if (iStorageAccess != null) {
            iStorageAccess.setInt(262, 10, n);
        }
    }

    private Map getLogChannels() {
        return this.getEngineeringEnv().getLogChannelAdmin().getAvailableChannels();
    }

    private LogSink[] getLogSinks() {
        List list = this.getEngineeringEnv().getLogChannelAdmin().getAllLogSinks();
        return (LogSink[])list.toArray(new LogSink[0]);
    }

    private Map getLogChannelCategories() {
        if (this.cats == null) {
            Map map = this.getLogChannels();
            String[] stringArray = (String[])map.keySet().toArray(new String[0]);
            HashMap hashMap = new HashMap(map.size());
            if (stringArray != null) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    LogChannelCategory logChannelCategory;
                    int n;
                    int n2;
                    if (stringArray[i2] == null || (n2 = stringArray[i2].indexOf(46, (n = stringArray[i2].indexOf(46)) + 1)) == -1) continue;
                    String string = stringArray[i2].substring(0, n2);
                    if (!hashMap.containsKey(string)) {
                        logChannelCategory = new LogChannelCategory();
                        logChannelCategory.addChannel(stringArray[i2]);
                        hashMap.put(string, logChannelCategory);
                        continue;
                    }
                    logChannelCategory = (LogChannelCategory)hashMap.get(string);
                    logChannelCategory.addChannel(stringArray[i2]);
                }
            }
            this.cats = hashMap;
        }
        return this.cats;
    }

    private void setLogSinkSelction(int n) {
        if (this.logSinks == null) {
            this.logSinks = this.getLogSinks();
        }
        block0 : switch (n) {
            case 0: {
                for (int i2 = 0; i2 < this.logSinks.length; ++i2) {
                    if (!(this.logSinks[i2] instanceof IStandardConsoleLogSink)) continue;
                    this.activeSink = this.logSinks[i2];
                    break block0;
                }
                break;
            }
            case 1: {
                for (int i3 = 0; i3 < this.logSinks.length; ++i3) {
                    if (!(this.logSinks[i3] instanceof ITraceClientLogSink)) continue;
                    this.activeSink = this.logSinks[i3];
                    break block0;
                }
                break;
            }
            case 2: {
                for (int i4 = 0; i4 < this.logSinks.length; ++i4) {
                    if (!(this.logSinks[i4] instanceof ISLOGSink)) continue;
                    this.activeSink = this.logSinks[i4];
                    break block0;
                }
                break;
            }
        }
    }

    private void switchOperationState(boolean bl) {
        if (this.activeSink != null) {
            if (bl) {
                if (this.backupConfig != null) {
                    this.activeSink.setConfiguration(this.backupConfig);
                }
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("all", new Integer(0));
                this.backupConfig = this.activeSink.getConfiguration();
                this.activeSink.setConfiguration(hashMap);
            }
        }
    }

    private void removeAllFlag(Map map) {
        if (map.containsKey("all")) {
            map.remove("all");
        }
    }

    private void enableChannel(String string) {
        Map map = this.activeSink.getConfiguration();
        this.removeAllFlag(map);
        if (map.containsKey(string)) {
            map.remove(string);
        }
        map.put(string, new Integer(100000000));
        this.activeSink.setConfiguration(map);
        this.hmi.setOperationStateChoice(1);
    }

    private void disableChannel(String string) {
        Map map = this.activeSink.getConfiguration();
        if (map.containsKey(string)) {
            map.remove(string);
        }
        this.activeSink.setConfiguration(map);
    }

    private void enableCategory(String string) {
        LogChannelCategory logChannelCategory = (LogChannelCategory)this.getLogChannelCategories().get(string);
        if (logChannelCategory != null) {
            String[] stringArray = logChannelCategory.getLogChannels();
            Map map = this.activeSink.getConfiguration();
            this.removeAllFlag(map);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (map.containsKey(stringArray[i2])) {
                    map.remove(stringArray[i2]);
                }
                map.put(stringArray[i2], new Integer(100000000));
            }
            this.activeSink.setConfiguration(map);
            this.hmi.setOperationStateChoice(1);
        }
    }

    private void disableCategory(String string) {
        LogChannelCategory logChannelCategory = (LogChannelCategory)this.getLogChannelCategories().get(string);
        if (logChannelCategory != null) {
            String[] stringArray = logChannelCategory.getLogChannels();
            Map map = this.activeSink.getConfiguration();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!map.containsKey(stringArray[i2])) continue;
                map.remove(stringArray[i2]);
            }
            this.activeSink.setConfiguration(map);
        }
    }

    private static class LogChannelCategory {
        private final List channels = new ArrayList(256);

        private LogChannelCategory() {
        }

        public void addChannel(String string) {
            this.channels.add(string);
        }

        public String[] getLogChannels() {
            return (String[])this.channels.toArray(new String[0]);
        }
    }

    private class LogAdapterHMIHandler
    implements ListListener,
    ChoiceListener,
    ButtonListener {
        private static final int LIST_COLLS = 3;
        private static final int LIST_TYPE_NAME = 0;
        private static final int LIST_TYPE_CAT = 1;
        private final LogAdapter adapter;
        private final EngineeringEnv engineeringEnv;
        private boolean catlistFilled = false;
        private boolean namelistFilled = false;

        public LogAdapterHMIHandler(LogAdapter logAdapter2, EngineeringEnv engineeringEnv) {
            ChoiceModelApp choiceModelApp;
            ChoiceModelApp choiceModelApp2;
            ButtonModelApp buttonModelApp;
            ButtonModelApp buttonModelApp2;
            this.adapter = logAdapter2;
            this.engineeringEnv = engineeringEnv;
            ListModelApp listModelApp = this.getHMIService().getListModel(1300029);
            if (null != listModelApp) {
                listModelApp.setListListener(this);
                listModelApp.setMaxRows(250);
                listModelApp.setMaxColumns(3);
                listModelApp = this.getHMIService().getListModel(1300030);
                listModelApp.setListListener(this);
                listModelApp.setMaxRows(250);
                listModelApp.setMaxColumns(3);
            }
            if (null != (buttonModelApp2 = this.getHMIService().getButtonModel(1300031))) {
                buttonModelApp2.setButtonListener(this);
            }
            if (null != (buttonModelApp = this.getHMIService().getButtonModel(1300032))) {
                buttonModelApp.setButtonListener(this);
            }
            if (null != (choiceModelApp2 = this.getHMIService().getChoiceModel(1300033))) {
                choiceModelApp2.setChoiceListener(this);
            }
            if (null != (choiceModelApp = this.getHMIService().getChoiceModel(1300034))) {
                choiceModelApp.setChoiceListener(this);
            }
            this.getHMIService().getChoiceModel(112).setChoiceListener(this);
        }

        private final EngineeringEnv getEngineeringEnv() {
            return this.engineeringEnv;
        }

        private final IHMIServiceApp getHMIService() {
            return this.getEngineeringEnv().getHMIService();
        }

        public void itemFocused(int n, int n2, int n3, int n4) {
        }

        public void itemReleased(int n, int n2, int n3, int n4) {
        }

        public void setOperationStateChoice(int n) {
            ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(1300034);
            choiceModelApp.setValue(n);
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            switch (n) {
                case 1300033: {
                    ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(1300033);
                    if (choiceModelApp.getValue() == n2) break;
                    this.adapter.setLogSinkSelction(n2);
                    choiceModelApp.setValue(n2);
                    break;
                }
                case 1300034: {
                    ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(1300034);
                    if (choiceModelApp.getValue() == 1) {
                        this.adapter.switchOperationState(false);
                        choiceModelApp.setValue(0);
                        break;
                    }
                    if (choiceModelApp.getValue() != 0) break;
                    this.adapter.switchOperationState(true);
                    choiceModelApp.setValue(1);
                    break;
                }
                case 1300029: {
                    ListModelApp listModelApp = this.getHMIService().getListModel(1300029);
                    if (this.getIntegerValue(listModelApp, n2, 1) == 0) {
                        String string = this.getStringValue(listModelApp, n2, 0);
                        this.adapter.enableCategory(string.substring(0, string.length() - 4));
                        listModelApp.setCell(n2, 1, new IntegerListCell(1, 255));
                        String string2 = this.getStringValue(listModelApp, n2, 0);
                        int n5 = string2.indexOf(91);
                        if (n5 <= 0) break;
                        String string3 = new StringBuffer().append(string2.substring(0, n5 + 1)).append("X").append(string2.substring(n5 + 2)).toString();
                        listModelApp.setCell(n2, 0, new TextListCell(string3));
                        break;
                    }
                    String string = this.getStringValue(listModelApp, n2, 0);
                    this.adapter.disableCategory(string.substring(0, string.length() - 4));
                    listModelApp.setCell(n2, 1, new IntegerListCell(0, 255));
                    String string4 = this.getStringValue(listModelApp, n2, 0);
                    int n6 = string4.indexOf(91);
                    if (n6 <= 0) break;
                    String string5 = new StringBuffer().append(string4.substring(0, n6 + 1)).append("-").append(string4.substring(n6 + 2)).toString();
                    listModelApp.setCell(n2, 0, new TextListCell(string5));
                    break;
                }
                case 1300030: {
                    ListModelApp listModelApp = this.getHMIService().getListModel(1300030);
                    if (this.getIntegerValue(listModelApp, n2, 1) == 0) {
                        String string = this.getStringValue(listModelApp, n2, 0);
                        this.adapter.enableChannel(string.substring(0, string.length() - 4));
                        listModelApp.setCell(n2, 1, new IntegerListCell(1, 255));
                        String string6 = this.getStringValue(listModelApp, n2, 0);
                        int n7 = string6.indexOf(91);
                        if (n7 <= 0) break;
                        String string7 = new StringBuffer().append(string6.substring(0, n7 + 1)).append("X").append(string6.substring(n7 + 2)).toString();
                        listModelApp.setCell(n2, 0, new TextListCell(string7));
                        break;
                    }
                    String string = this.getStringValue(listModelApp, n2, 0);
                    this.adapter.disableChannel(string.substring(0, string.length() - 4));
                    listModelApp.setCell(n2, 1, new IntegerListCell(0, 255));
                    String string8 = this.getStringValue(listModelApp, n2, 0);
                    int n8 = string8.indexOf(91);
                    if (n8 <= 0) break;
                    String string9 = new StringBuffer().append(string8.substring(0, n8 + 1)).append("-").append(string8.substring(n8 + 2)).toString();
                    listModelApp.setCell(n2, 0, new TextListCell(string9));
                    break;
                }
                case 112: {
                    ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(n);
                    if (choiceModelApp.getValue() == 1) {
                        choiceModelApp.setValue(0);
                    } else {
                        choiceModelApp.setValue(1);
                    }
                    LogAdapter.this.storeEngState(choiceModelApp.getValue());
                    break;
                }
            }
        }

        private int getIntegerValue(ListModelApp listModelApp, int n, int n2) {
            int n3 = -1;
            if (listModelApp != null) {
                ListCell[] listCellArray = new ListCell[3];
                listModelApp.getRow(n, listCellArray);
                if (listCellArray != null && n > 0 && n2 < listCellArray.length) {
                    try {
                        n3 = ((IntegerListCell)listCellArray[n2]).getValue();
                    }
                    catch (ClassCastException classCastException) {
                        n3 = -1;
                    }
                }
            }
            return n3;
        }

        private String getStringValue(ListModelApp listModelApp, int n, int n2) {
            String string = "";
            if (listModelApp != null) {
                ListCell[] listCellArray = new ListCell[3];
                listModelApp.getRow(n, listCellArray);
                if (listCellArray != null && n > 0 && n2 < listCellArray.length) {
                    try {
                        string = ((TextListCell)listCellArray[n2]).getText();
                    }
                    catch (ClassCastException classCastException) {
                        string = "";
                    }
                }
            }
            return string;
        }

        public void keyPressed(int n, int n2, int n3) {
        }

        public void keyReleased(int n, int n2, int n3) {
        }

        public void keyTyped(int n, int n2, int n3) {
            int n4 = 0;
            switch (n) {
                case 1300031: {
                    ButtonModelApp buttonModelApp = this.getHMIService().getButtonModel(n);
                    n4 = this.fillList(1);
                    if (n4 != 0) break;
                    buttonModelApp.fireEvent(n3);
                    break;
                }
                case 1300032: {
                    ButtonModelApp buttonModelApp = this.getHMIService().getButtonModel(n);
                    n4 = this.fillList(0);
                    if (n4 != 0) break;
                    buttonModelApp.fireEvent(n3);
                    break;
                }
                case 112: {
                    ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(n);
                    if (choiceModelApp.getValue() == 1) {
                        choiceModelApp.setValue(0);
                    } else {
                        choiceModelApp.setValue(1);
                    }
                    LogAdapter.this.storeEngState(choiceModelApp.getValue());
                    break;
                }
            }
        }

        public void keyLongTyped(int n, int n2, int n3) {
        }

        private int fillList(int n) {
            int n2 = 0;
            boolean bl = false;
            Map map = null;
            ListModelApp listModelApp = null;
            if (n == 1) {
                if (this.catlistFilled) {
                    bl = true;
                } else {
                    map = this.adapter.getLogChannelCategories();
                    listModelApp = this.getHMIService().getListModel(1300029);
                    this.catlistFilled = true;
                }
            } else {
                if (this.namelistFilled) {
                    bl = true;
                }
                map = this.adapter.getLogChannels();
                listModelApp = this.getHMIService().getListModel(1300030);
                this.namelistFilled = true;
            }
            if (bl) {
                n2 = 0;
            } else if (map == null) {
                n2 = -1;
            } else {
                Object[] objectArray = (String[])map.keySet().toArray(new String[map.size()]);
                Arrays.sort(objectArray);
                listModelApp.clear();
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    ListCell[] listCellArray = new ListCell[3];
                    listCellArray[0] = new TextListCell((String)objectArray[i2]);
                    listCellArray[1] = new IntegerListCell(0, 255);
                    listCellArray[0] = new TextListCell(new StringBuffer().append((String)objectArray[i2]).append(" [-]").toString());
                    listModelApp.addRow(listCellArray);
                }
            }
            return n2;
        }
    }
}

