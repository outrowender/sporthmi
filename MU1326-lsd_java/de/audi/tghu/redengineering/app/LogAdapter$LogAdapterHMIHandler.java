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
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.LogAdapter;
import java.util.Arrays;
import java.util.Map;

class LogAdapter$LogAdapterHMIHandler
implements ListListener,
ChoiceListener,
ButtonListener {
    private static final int LIST_COLLS;
    private static final int LIST_TYPE_NAME;
    private static final int LIST_TYPE_CAT;
    private final LogAdapter adapter;
    private final EngineeringEnv engineeringEnv;
    private boolean catlistFilled = false;
    private boolean namelistFilled = false;
    private final /* synthetic */ LogAdapter this$0;

    public LogAdapter$LogAdapterHMIHandler(LogAdapter logAdapter, LogAdapter logAdapter2, EngineeringEnv engineeringEnv) {
        ChoiceModelApp choiceModelApp;
        ChoiceModelApp choiceModelApp2;
        ButtonModelApp buttonModelApp;
        ButtonModelApp buttonModelApp2;
        this.this$0 = logAdapter;
        this.adapter = logAdapter2;
        this.engineeringEnv = engineeringEnv;
        ListModelApp listModelApp = this.getHMIService().getListModel(1037439744);
        if (null != listModelApp) {
            listModelApp.setListListener(this);
            listModelApp.setMaxRows(250);
            listModelApp.setMaxColumns(3);
            listModelApp = this.getHMIService().getListModel(1054216960);
            listModelApp.setListListener(this);
            listModelApp.setMaxRows(250);
            listModelApp.setMaxColumns(3);
        }
        if (null != (buttonModelApp2 = this.getHMIService().getButtonModel(1070994176))) {
            buttonModelApp2.setButtonListener(this);
        }
        if (null != (buttonModelApp = this.getHMIService().getButtonModel(1087771392))) {
            buttonModelApp.setButtonListener(this);
        }
        if (null != (choiceModelApp2 = this.getHMIService().getChoiceModel(1104548608))) {
            choiceModelApp2.setChoiceListener(this);
        }
        if (null != (choiceModelApp = this.getHMIService().getChoiceModel(1121325824))) {
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void setOperationStateChoice(int n) {
        ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(1121325824);
        choiceModelApp.setValue(n);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 1300033: {
                ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(1104548608);
                if (choiceModelApp.getValue() == n2) break;
                LogAdapter.access$000(this.adapter, n2);
                choiceModelApp.setValue(n2);
                break;
            }
            case 1300034: {
                ChoiceModelApp choiceModelApp = this.getHMIService().getChoiceModel(1121325824);
                if (choiceModelApp.getValue() == 1) {
                    LogAdapter.access$100(this.adapter, false);
                    choiceModelApp.setValue(0);
                    break;
                }
                if (choiceModelApp.getValue() != 0) break;
                LogAdapter.access$100(this.adapter, true);
                choiceModelApp.setValue(1);
                break;
            }
            case 1300029: {
                ListModelApp listModelApp = this.getHMIService().getListModel(1037439744);
                if (this.getIntegerValue(listModelApp, n2, 1) == 0) {
                    String string = this.getStringValue(listModelApp, n2, 0);
                    LogAdapter.access$200(this.adapter, string.substring(0, string.length() - 4));
                    listModelApp.setCell(n2, 1, new IntegerListCell(1, 255));
                    String string2 = this.getStringValue(listModelApp, n2, 0);
                    int n5 = string2.indexOf(91);
                    if (n5 <= 0) break;
                    String string3 = new StringBuffer().append(string2.substring(0, n5 + 1)).append("X").append(string2.substring(n5 + 2)).toString();
                    listModelApp.setCell(n2, 0, new TextListCell(string3));
                    break;
                }
                String string = this.getStringValue(listModelApp, n2, 0);
                LogAdapter.access$300(this.adapter, string.substring(0, string.length() - 4));
                listModelApp.setCell(n2, 1, new IntegerListCell(0, 255));
                String string4 = this.getStringValue(listModelApp, n2, 0);
                int n6 = string4.indexOf(91);
                if (n6 <= 0) break;
                String string5 = new StringBuffer().append(string4.substring(0, n6 + 1)).append("-").append(string4.substring(n6 + 2)).toString();
                listModelApp.setCell(n2, 0, new TextListCell(string5));
                break;
            }
            case 1300030: {
                ListModelApp listModelApp = this.getHMIService().getListModel(1054216960);
                if (this.getIntegerValue(listModelApp, n2, 1) == 0) {
                    String string = this.getStringValue(listModelApp, n2, 0);
                    LogAdapter.access$400(this.adapter, string.substring(0, string.length() - 4));
                    listModelApp.setCell(n2, 1, new IntegerListCell(1, 255));
                    String string6 = this.getStringValue(listModelApp, n2, 0);
                    int n7 = string6.indexOf(91);
                    if (n7 <= 0) break;
                    String string7 = new StringBuffer().append(string6.substring(0, n7 + 1)).append("X").append(string6.substring(n7 + 2)).toString();
                    listModelApp.setCell(n2, 0, new TextListCell(string7));
                    break;
                }
                String string = this.getStringValue(listModelApp, n2, 0);
                LogAdapter.access$500(this.adapter, string.substring(0, string.length() - 4));
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
                this.this$0.storeEngState(choiceModelApp.getValue());
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

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
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
                this.this$0.storeEngState(choiceModelApp.getValue());
                break;
            }
        }
    }

    @Override
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
                map = LogAdapter.access$600(this.adapter);
                listModelApp = this.getHMIService().getListModel(1037439744);
                this.catlistFilled = true;
            }
        } else {
            if (this.namelistFilled) {
                bl = true;
            }
            map = LogAdapter.access$700(this.adapter);
            listModelApp = this.getHMIService().getListModel(1054216960);
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

