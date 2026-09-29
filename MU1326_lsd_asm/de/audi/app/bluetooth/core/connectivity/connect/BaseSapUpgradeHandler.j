.version 50 0 
.class public super [229] 
.super [231] 
.implements [233] 
.field private static final [234] [235] 
.field private final [236] [237] 
.field private volatile [238] [239] 
.field private volatile [240] [241] 
.field private volatile [242] [243] 

.method public [245] : [246] 
    .attribute [244] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [36] 
L5:     aload_0 
L6:     aload_0 
L7:     ldc [2] 
L9:     invokevirtual [22] 
L12:    putfield [42] 
L15:    return 
L16:    
    .end code 
.end method 

.method protected [247] : [248] 
    .attribute [244] .code stack 1 locals 0 
L0:     getstatic [3] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method private [249] : [250] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     iconst_1 
L5:     invokeinterface [43] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [251] : [252] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     iconst_0 
L5:     invokeinterface [43] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method [253] : [254] 
    .attribute [244] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     iload_1 
L9:     invokevirtual [25] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    putfield [44] 
L18:    iload_1 
L19:    ifeq L26 
L22:    aload_0 
L23:    invokespecial [38] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [244] .code stack 5 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpeq L6 
L5:     return 
L6:     aload_0 
L7:     getfield [24] 
L10:    ldc [4] 
L12:    ldc [6] 
L14:    iload_1 
L15:    i2l 
L16:    invokevirtual [27] 
L19:    pop 
L20:    aload_0 
L21:    iload_1 
L22:    iconst_4 
L23:    iand 
L24:    ifle L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    putfield [45] 
L35:    aload_0 
L36:    getfield [24] 
L39:    ldc [4] 
L41:    ldc [7] 
L43:    aload_0 
L44:    getfield [28] 
L47:    invokevirtual [25] 
L50:    pop 
L51:    aload_0 
L52:    getfield [28] 
L55:    ifne L62 
L58:    aload_0 
L59:    invokespecial [38] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [257] : [258] 
    .attribute [244] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [4] 
L6:     ldc [8] 
L8:     aload_1 
L9:     invokevirtual [29] 
L12:    pop 
L13:    aload_0 
L14:    getfield [28] 
L17:    ifeq L48 
L20:    aload_0 
L21:    getfield [26] 
L24:    ifne L48 
L27:    aload_0 
L28:    getfield [24] 
L31:    ldc [9] 
L33:    ldc [10] 
L35:    invokevirtual [30] 
L38:    pop 
L39:    aload_0 
L40:    aload_1 
L41:    putfield [46] 
L44:    aload_0 
L45:    invokespecial [39] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected [259] : [260] 
    .attribute [244] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [4] 
L6:     ldc [11] 
L8:     invokevirtual [30] 
L11:    pop 
L12:    aload_0 
L13:    aconst_null 
L14:    putfield [46] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [244] .code stack 6 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [23] 
L5:     invokeinterface [47] 0 
L10:    if_icmpne L103 
L13:    aload_0 
L14:    getfield [31] 
L17:    ifnonnull L35 
L20:    aload_0 
L21:    getfield [24] 
L24:    ldc [12] 
L26:    ldc [13] 
L28:    invokevirtual [30] 
L31:    pop 
L32:    goto L92 
L35:    aload_0 
L36:    getfield [24] 
L39:    ldc [9] 
L41:    ldc [14] 
L43:    invokevirtual [30] 
L46:    pop 
L47:    aload_0 
L48:    getfield [32] 
L51:    invokeinterface [48] 0 
L56:    aload_0 
L57:    getfield [31] 
L60:    invokevirtual [33] 
L63:    iconst_4 
L64:    aload_0 
L65:    getfield [31] 
L68:    invokevirtual [34] 
L71:    aload_0 
L72:    getfield [31] 
L75:    invokevirtual [35] 
L78:    iconst_1 
L79:    if_icmpne L86 
L82:    iconst_1 
L83:    goto L87 
L86:    iconst_0 
L87:    invokeinterface [49] 0 
L92:    aload_0 
L93:    getfield [23] 
L96:    iload_3 
L97:    invokeinterface [50] 0 
L102:   pop 
L103:   return 
L104:   
    .end code 
.end method 

.method public enum [263] : [264] 
    .attribute [244] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [265] : [266] 
    .attribute [244] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [267] : [268] 
    .attribute [244] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     getfield [23] 
L8:     aload_0 
L9:     invokeinterface [51] 0 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [244] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokeinterface [52] 0 
L9:     aload_0 
L10:    invokespecial [41] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static [273] : [274] 
    .attribute [244] .code stack 4 locals 0 
L0:     iconst_3 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 7 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 6 
L12:    iastore 
L13:    dup 
L14:    iconst_2 
L15:    bipush 12 
L17:    iastore 
L18:    putstatic [37] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -517593600 
.const [3] = Field [53] [54] 
.const [4] = Int -2137614336 
.const [5] = String [55] 
.const [6] = String [56] 
.const [7] = String [57] 
.const [8] = String [58] 
.const [9] = Int 1078071040 
.const [10] = String [59] 
.const [11] = String [60] 
.const [12] = Int -1601830656 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Method [70] [71] 
.const [23] = Field [72] [73] 
.const [24] = Field [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Field [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Field [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Field [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = Field [114] [115] 
.const [45] = Field [116] [117] 
.const [46] = Field [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = InterfaceMethod [124] [125] 
.const [50] = InterfaceMethod [126] [127] 
.const [51] = InterfaceMethod [128] [129] 
.const [52] = InterfaceMethod [130] [131] 
.const [53] = Class [132] 
.const [54] = NameAndType [133] [134] 
.const [55] = Utf8 'BaseSapUpgradeHandler#updateConnectionActive(): %1' 
.const [56] = Utf8 'BaseSapUpgradeHandler#updateSupportedBTProfiles(): %1' 
.const [57] = Utf8 'BaseSapUpgradeHandler#updateSupportedBTProfiles(): SAP supported: %1' 
.const [58] = Utf8 'BaseSapUpgradeHandler#handleNewDevice(): %1' 
.const [59] = Utf8 'BaseSapUpgradeHandler#handleNewDevice(): Activating SAP upgrade' 
.const [60] = Utf8 'BaseSapUpgradeHandler#cleanupAfterPairing()' 
.const [61] = Utf8 "BaseSapUpgradeHandler#keyTyped(): device is null, can't upgrade" 
.const [62] = Utf8 'BaseSapUpgradeHandler#keyTyped(): Initiating SAP upgrade' 
.const [63] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [64] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [65] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelApp 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [68] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [69] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/IConnection 
.const [70] = Class [135] 
.const [71] = NameAndType [136] [137] 
.const [72] = Class [138] 
.const [73] = NameAndType [139] [140] 
.const [74] = Class [141] 
.const [75] = NameAndType [142] [143] 
.const [76] = Class [144] 
.const [77] = NameAndType [145] [146] 
.const [78] = Class [147] 
.const [79] = NameAndType [148] [149] 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Class [162] 
.const [89] = NameAndType [163] [164] 
.const [90] = Class [165] 
.const [91] = NameAndType [166] [167] 
.const [92] = Class [168] 
.const [93] = NameAndType [169] [170] 
.const [94] = Class [171] 
.const [95] = NameAndType [172] [173] 
.const [96] = Class [174] 
.const [97] = NameAndType [175] [176] 
.const [98] = Class [177] 
.const [99] = NameAndType [178] [179] 
.const [100] = Class [180] 
.const [101] = NameAndType [181] [182] 
.const [102] = Class [183] 
.const [103] = NameAndType [184] [185] 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Class [201] 
.const [115] = NameAndType [202] [203] 
.const [116] = Class [204] 
.const [117] = NameAndType [205] [206] 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Class [210] 
.const [121] = NameAndType [211] [212] 
.const [122] = Class [213] 
.const [123] = NameAndType [214] [215] 
.const [124] = Class [216] 
.const [125] = NameAndType [217] [218] 
.const [126] = Class [219] 
.const [127] = NameAndType [220] [221] 
.const [128] = Class [222] 
.const [129] = NameAndType [223] [224] 
.const [130] = Class [225] 
.const [131] = NameAndType [226] [227] 
.const [132] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [133] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [134] = Utf8 [I 
.const [135] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [136] = Utf8 getButtonModel 
.const [137] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [138] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [139] = Utf8 sapUpgradeButton 
.const [140] = Utf8 Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [141] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [142] = Utf8 log 
.const [143] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;Z)Z 
.const [147] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [148] = Utf8 connectionRequestOngoing 
.const [149] = Utf8 Z 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;J)Z 
.const [153] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [154] = Utf8 sapSupported 
.const [155] = Utf8 Z 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [159] = Utf8 de/audi/atip/log/LogChannel 
.const [160] = Utf8 log 
.const [161] = Utf8 (ILjava/lang/String;)Z 
.const [162] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [163] = Utf8 device 
.const [164] = Utf8 Lorg/dsi/ifc/bluetooth/TrustedDevice; 
.const [165] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [166] = Utf8 bluetoothApplication 
.const [167] = Utf8 Lde/audi/app/bluetooth/core/IBluetoothApplication; 
.const [168] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [169] = Utf8 getDeviceAddress 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [172] = Utf8 getDeviceName 
.const [173] = Utf8 ()Ljava/lang/String; 
.const [174] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [175] = Utf8 getDeviceRole 
.const [176] = Utf8 ()I 
.const [177] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Lde/audi/app/bluetooth/core/IBluetoothApplication;)V 
.const [180] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [181] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [182] = Utf8 [I 
.const [183] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [184] = Utf8 disableSapUpgrade 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [187] = Utf8 activateSapUpgrade 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [190] = Utf8 init 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [193] = Utf8 deinit 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [196] = Utf8 sapUpgradeButton 
.const [197] = Utf8 Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [198] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelApp 
.const [199] = Utf8 setStatus 
.const [200] = Utf8 (I)V 
.const [201] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [202] = Utf8 connectionRequestOngoing 
.const [203] = Utf8 Z 
.const [204] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [205] = Utf8 sapSupported 
.const [206] = Utf8 Z 
.const [207] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [208] = Utf8 device 
.const [209] = Utf8 Lorg/dsi/ifc/bluetooth/TrustedDevice; 
.const [210] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelApp 
.const [211] = Utf8 getID 
.const [212] = Utf8 ()I 
.const [213] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [214] = Utf8 getConnection 
.const [215] = Utf8 ()Lde/audi/app/bluetooth/core/connectivity/connect/IConnection; 
.const [216] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/IConnection 
.const [217] = Utf8 connectService 
.const [218] = Utf8 (Ljava/lang/String;ILjava/lang/String;Z)V 
.const [219] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelApp 
.const [220] = Utf8 fireEvent 
.const [221] = Utf8 (I)Z 
.const [222] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelApp 
.const [223] = Utf8 setButtonListener 
.const [224] = Utf8 (Lde/audi/atip/hmi/model/ButtonListener;)V 
.const [225] = Utf8 de/audi/atip/hmi/modelaccess/ButtonModelApp 
.const [226] = Utf8 resetListener 
.const [227] = Utf8 ()V 
.const [228] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/BaseSapUpgradeHandler 
.const [229] = Class [228] 
.const [230] = Utf8 de/audi/app/bluetooth/core/security/AbstractPostPairingHandler 
.const [231] = Class [230] 
.const [232] = Utf8 de/audi/atip/hmi/model/ButtonListener 
.const [233] = Class [232] 
.const [234] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [235] = Utf8 [I 
.const [236] = Utf8 sapUpgradeButton 
.const [237] = Utf8 Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [238] = Utf8 device 
.const [239] = Utf8 Lorg/dsi/ifc/bluetooth/TrustedDevice; 
.const [240] = Utf8 connectionRequestOngoing 
.const [241] = Utf8 Z 
.const [242] = Utf8 sapSupported 
.const [243] = Utf8 Z 
.const [244] = Utf8 Code 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/audi/app/bluetooth/core/IBluetoothApplication;)V 
.const [247] = Utf8 getAttributeNotifications 
.const [248] = Utf8 ()[I 
.const [249] = Utf8 activateSapUpgrade 
.const [250] = Utf8 ()V 
.const [251] = Utf8 disableSapUpgrade 
.const [252] = Utf8 ()V 
.const [253] = Utf8 updateConnectionActive 
.const [254] = Utf8 (Z)V 
.const [255] = Utf8 updateSupportedBTProfiles 
.const [256] = Utf8 (II)V 
.const [257] = Utf8 handleNewDevice 
.const [258] = Utf8 (Lorg/dsi/ifc/bluetooth/TrustedDevice;)V 
.const [259] = Utf8 cleanupAfterPairing 
.const [260] = Utf8 ()V 
.const [261] = Utf8 keyTyped 
.const [262] = Utf8 (III)V 
.const [263] = Utf8 keyPressed 
.const [264] = Utf8 (III)V 
.const [265] = Utf8 keyReleased 
.const [266] = Utf8 (III)V 
.const [267] = Utf8 keyLongTyped 
.const [268] = Utf8 (III)V 
.const [269] = Utf8 init 
.const [270] = Utf8 ()V 
.const [271] = Utf8 deinit 
.const [272] = Utf8 ()V 
.const [273] = Utf8 <clinit> 
.const [274] = Utf8 ()V 
.end class 
