.version 50 0 
.class public super abstract [235] 
.super [237] 
.field private final [238] [239] 
.field private final [240] [241] 

.method private static [243] : [244] 
    .attribute [242] .code stack 2 locals 3 
L0:     aload_0 
L1:     ifnull L49 
L4:     aload_0 
L5:     invokevirtual [26] 
L8:     istore_1 
L9:     iload_1 
L10:    iconst_2 
L11:    iand 
L12:    iconst_2 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    istore_2 
L22:    iload_1 
L23:    iconst_4 
L24:    iand 
L25:    iconst_4 
L26:    if_icmpne L33 
L29:    iconst_1 
L30:    goto L34 
L33:    iconst_0 
L34:    istore_3 
L35:    iload_2 
L36:    ifne L43 
L39:    iload_3 
L40:    ifeq L47 
L43:    iconst_1 
L44:    goto L48 
L47:    iconst_0 
L48:    areturn 
L49:    iconst_0 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method private static [245] : [246] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L25 
L4:     aload_0 
L5:     invokeinterface [41] 0 
L10:    ifnull L25 
L13:    aload_0 
L14:    invokeinterface [41] 0 
L19:    invokevirtual [27] 
L22:    goto L27 
L25:    ldc [3] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method private static [247] : [248] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L25 
L4:     aload_0 
L5:     invokeinterface [41] 0 
L10:    ifnull L25 
L13:    aload_0 
L14:    invokeinterface [41] 0 
L19:    invokevirtual [28] 
L22:    goto L27 
L25:    ldc [3] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method private static [249] : [250] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L13 
L4:     aload_0 
L5:     invokeinterface [42] 0 
L10:    goto L16 
L13:    sipush 255 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [242] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [4] 
L4:     invokespecial [34] 
L7:     aload_0 
L8:     new [43] 
L11:    dup 
L12:    aload_0 
L13:    aconst_null 
L14:    invokespecial [35] 
L17:    putfield [44] 
L20:    aload_0 
L21:    new [45] 
L24:    dup 
L25:    invokespecial [36] 
L28:    putfield [40] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [242] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     aload_0 
L5:     invokevirtual [30] 
L8:     invokeinterface [46] 0 
L13:    aload_0 
L14:    getfield [29] 
L17:    invokeinterface [47] 0 
L22:    aload_0 
L23:    invokevirtual [30] 
L26:    invokeinterface [48] 0 
L31:    aload_0 
L32:    invokeinterface [49] 0 
L37:    aload_0 
L38:    invokevirtual [30] 
L41:    new [50] 
L44:    dup 
L45:    aload_0 
L46:    invokespecial [38] 
L49:    invokeinterface [51] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [242] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     invokevirtual [30] 
L8:     invokeinterface [48] 0 
L13:    aload_0 
L14:    invokeinterface [52] 0 
L19:    aload_0 
L20:    invokevirtual [30] 
L23:    invokeinterface [46] 0 
L28:    aload_0 
L29:    getfield [29] 
L32:    invokeinterface [53] 0 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [242] .code stack 4 locals 4 
L0:     aload_2 
L1:     ifnonnull L17 
L4:     aload_0 
L5:     getfield [24] 
L8:     sipush 10000 
L11:    ldc [8] 
L13:    invokevirtual [31] 
L16:    pop 
L17:    aload_2 
L18:    invokeinterface [54] 0 
L23:    astore_3 
L24:    aload_3 
L25:    invokestatic [9] 
L28:    astore 4 
L30:    aload_3 
L31:    invokestatic [10] 
L34:    astore 5 
L36:    aload_3 
L37:    invokestatic [11] 
L40:    istore 6 
L42:    iload_1 
L43:    ldc [12] 
L45:    if_icmpeq L54 
L48:    iload_1 
L49:    ldc [13] 
L51:    if_icmpne L64 
L54:    aload_0 
L55:    aload 5 
L57:    aload 4 
L59:    iload 6 
L61:    invokevirtual [32] 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method protected [259] : [260] 
    .attribute [242] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L17 using L18 
L7:     aload_0 
L8:     getfield [25] 
L11:    aload_1 
L12:    invokevirtual [33] 
L15:    aload_2 
L16:    monitorexit 
L17:    areturn 
        .catch [0] from L18 to L21 using L18 
L18:    astore_3 
L19:    aload_2 
L20:    monitorexit 
L21:    aload_3 
L22:    athrow 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected abstract [261] : [262] 
    .attribute [242] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static synthetic [263] : [264] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [265] : [266] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [267] : [268] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [269] : [270] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [271] : [272] 
    .attribute [242] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [55] [56] 
.const [3] = String [57] 
.const [4] = String [58] 
.const [5] = Class [59] 
.const [6] = Class [60] 
.const [7] = Class [61] 
.const [8] = String [62] 
.const [9] = Method [63] [64] 
.const [10] = Method [65] [66] 
.const [11] = Method [67] [68] 
.const [12] = Int 100663552 
.const [13] = Int 301990144 
.const [14] = Class [69] 
.const [15] = Class [70] 
.const [16] = Class [71] 
.const [17] = Class [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Class [78] 
.const [24] = Field [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Field [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Field [111] [112] 
.const [41] = InterfaceMethod [113] [114] 
.const [42] = InterfaceMethod [115] [116] 
.const [43] = Class [117] 
.const [44] = Field [118] [119] 
.const [45] = Class [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = Class [129] 
.const [51] = InterfaceMethod [130] [131] 
.const [52] = InterfaceMethod [132] [133] 
.const [53] = InterfaceMethod [134] [135] 
.const [54] = InterfaceMethod [136] [137] 
.const [55] = Class [138] 
.const [56] = NameAndType [139] [140] 
.const [57] = Utf8 '' 
.const [58] = Utf8 'App.Phone.Main' 
.const [59] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [60] = Utf8 java/util/LinkedList 
.const [61] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryDiag 
.const [62] = Utf8 'AbstractTelBatteryHandler#updateGlobalTelephoneStateProperty stateStruct is null' 
.const [63] = Class [141] 
.const [64] = NameAndType [142] [143] 
.const [65] = Class [144] 
.const [66] = NameAndType [145] [146] 
.const [67] = Class [147] 
.const [68] = NameAndType [148] [149] 
.const [69] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [70] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [71] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [72] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [73] = Utf8 org/dsi/ifc/telephoneng/PhoneInformation 
.const [74] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [75] = Utf8 de/audi/app/phone/core/bluetooth/ITelBluetoothHandler 
.const [76] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [79] = Class [150] 
.const [80] = NameAndType [151] [152] 
.const [81] = Class [153] 
.const [82] = NameAndType [154] [155] 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Class [159] 
.const [86] = NameAndType [160] [161] 
.const [87] = Class [162] 
.const [88] = NameAndType [163] [164] 
.const [89] = Class [165] 
.const [90] = NameAndType [166] [167] 
.const [91] = Class [168] 
.const [92] = NameAndType [169] [170] 
.const [93] = Class [171] 
.const [94] = NameAndType [172] [173] 
.const [95] = Class [174] 
.const [96] = NameAndType [175] [176] 
.const [97] = Class [177] 
.const [98] = NameAndType [178] [179] 
.const [99] = Class [180] 
.const [100] = NameAndType [181] [182] 
.const [101] = Class [183] 
.const [102] = NameAndType [184] [185] 
.const [103] = Class [186] 
.const [104] = NameAndType [187] [188] 
.const [105] = Class [189] 
.const [106] = NameAndType [190] [191] 
.const [107] = Class [192] 
.const [108] = NameAndType [193] [194] 
.const [109] = Class [195] 
.const [110] = NameAndType [196] [197] 
.const [111] = Class [198] 
.const [112] = NameAndType [199] [200] 
.const [113] = Class [201] 
.const [114] = NameAndType [202] [203] 
.const [115] = Class [204] 
.const [116] = NameAndType [205] [206] 
.const [117] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Utf8 java/util/LinkedList 
.const [121] = Class [210] 
.const [122] = NameAndType [211] [212] 
.const [123] = Class [213] 
.const [124] = NameAndType [214] [215] 
.const [125] = Class [216] 
.const [126] = NameAndType [217] [218] 
.const [127] = Class [219] 
.const [128] = NameAndType [220] [221] 
.const [129] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryDiag 
.const [130] = Class [222] 
.const [131] = NameAndType [223] [224] 
.const [132] = Class [225] 
.const [133] = NameAndType [226] [227] 
.const [134] = Class [228] 
.const [135] = NameAndType [229] [230] 
.const [136] = Class [231] 
.const [137] = NameAndType [232] [233] 
.const [138] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [139] = Utf8 isDeviceViaHFPOrSAPConnected 
.const [140] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [141] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [142] = Utf8 getMEMacAddress 
.const [143] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Ljava/lang/String; 
.const [144] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [145] = Utf8 getMEFriendlyName 
.const [146] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Ljava/lang/String; 
.const [147] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [148] = Utf8 getBatteryChargeLevel 
.const [149] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [150] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [151] = Utf8 log 
.const [152] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [153] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [154] = Utf8 btTelephoneConnectedDeviceList 
.const [155] = Utf8 Ljava/util/LinkedList; 
.const [156] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [157] = Utf8 getActiveServiceTypes 
.const [158] = Utf8 ()I 
.const [159] = Utf8 org/dsi/ifc/telephoneng/PhoneInformation 
.const [160] = Utf8 getMeBtAddress 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 org/dsi/ifc/telephoneng/PhoneInformation 
.const [163] = Utf8 getMeFriendlyName 
.const [164] = Utf8 ()Ljava/lang/String; 
.const [165] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [166] = Utf8 bluetoothListener 
.const [167] = Utf8 Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener; 
.const [168] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [169] = Utf8 getApplication 
.const [170] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [171] = Utf8 de/audi/atip/log/LogChannel 
.const [172] = Utf8 log 
.const [173] = Utf8 (ILjava/lang/String;)Z 
.const [174] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [175] = Utf8 handleBatteryChargeLevel 
.const [176] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [177] = Utf8 java/util/LinkedList 
.const [178] = Utf8 contains 
.const [179] = Utf8 (Ljava/lang/Object;)Z 
.const [180] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [183] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler$1;)V 
.const [186] = Utf8 java/util/LinkedList 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [190] = Utf8 init 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryDiag 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)V 
.const [195] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [196] = Utf8 deinit 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [199] = Utf8 btTelephoneConnectedDeviceList 
.const [200] = Utf8 Ljava/util/LinkedList; 
.const [201] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [202] = Utf8 getPhoneInformation 
.const [203] = Utf8 ()Lorg/dsi/ifc/telephoneng/PhoneInformation; 
.const [204] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [205] = Utf8 getBatteryChargeLevel 
.const [206] = Utf8 ()I 
.const [207] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [208] = Utf8 bluetoothListener 
.const [209] = Utf8 Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener; 
.const [210] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [211] = Utf8 getBluetoothHandler 
.const [212] = Utf8 ()Lde/audi/app/phone/core/bluetooth/ITelBluetoothHandler; 
.const [213] = Utf8 de/audi/app/phone/core/bluetooth/ITelBluetoothHandler 
.const [214] = Utf8 addBluetoothListener 
.const [215] = Utf8 (Lde/audi/app/phone/core/bluetooth/ITelBluetoothListener;)V 
.const [216] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [217] = Utf8 getGlobalTelephoneStateManager 
.const [218] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [219] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [220] = Utf8 registerListener 
.const [221] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [222] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [223] = Utf8 addDiagnosisComponent 
.const [224] = Utf8 (Lde/mib/swdiagnosis/phone/IPhoneDiagComponent;)V 
.const [225] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [226] = Utf8 removeListener 
.const [227] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [228] = Utf8 de/audi/app/phone/core/bluetooth/ITelBluetoothHandler 
.const [229] = Utf8 removeBluetoothListener 
.const [230] = Utf8 (Lde/audi/app/phone/core/bluetooth/ITelBluetoothListener;)V 
.const [231] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [232] = Utf8 getPrimaryDeviceState 
.const [233] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [234] = Utf8 de/audi/app/phone/core/battery/AbstractTelBatteryHandler 
.const [235] = Class [234] 
.const [236] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [237] = Class [236] 
.const [238] = Utf8 bluetoothListener 
.const [239] = Utf8 Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler$TelBatteryBluetoothListener; 
.const [240] = Utf8 btTelephoneConnectedDeviceList 
.const [241] = Utf8 Ljava/util/LinkedList; 
.const [242] = Utf8 Code 
.const [243] = Utf8 isDeviceViaHFPOrSAPConnected 
.const [244] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [245] = Utf8 getMEMacAddress 
.const [246] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Ljava/lang/String; 
.const [247] = Utf8 getMEFriendlyName 
.const [248] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Ljava/lang/String; 
.const [249] = Utf8 getBatteryChargeLevel 
.const [250] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [251] = Utf8 <init> 
.const [252] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [253] = Utf8 init 
.const [254] = Utf8 ()V 
.const [255] = Utf8 deinit 
.const [256] = Utf8 ()V 
.const [257] = Utf8 updateGlobalTelephoneStateProperty 
.const [258] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [259] = Utf8 isConnectedViaSAPOrHFP 
.const [260] = Utf8 (Ljava/lang/String;)Z 
.const [261] = Utf8 handleBatteryChargeLevel 
.const [262] = Utf8 (Ljava/lang/String;Ljava/lang/String;I)V 
.const [263] = Utf8 access$100 
.const [264] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)Z 
.const [265] = Utf8 access$200 
.const [266] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Lde/audi/atip/log/LogChannel; 
.const [267] = Utf8 access$300 
.const [268] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Lde/audi/atip/log/LogChannel; 
.const [269] = Utf8 access$400 
.const [270] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Ljava/util/LinkedList; 
.const [271] = Utf8 access$500 
.const [272] = Utf8 (Lde/audi/app/phone/core/battery/AbstractTelBatteryHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
