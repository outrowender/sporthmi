.version 50 0 
.class public super [231] 
.super [233] 
.implements [235] 
.field private volatile [236] [237] 
.field private volatile [238] [239] 
.field private [240] [241] 
.field static synthetic [242] [243] 

.method public [245] : [246] 
    .attribute [244] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [38] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [244] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     invokeinterface [43] 0 
L9:     aload_0 
L10:    invokeinterface [44] 0 
L15:    aload_0 
L16:    new [45] 
L19:    dup 
L20:    aload_0 
L21:    invokevirtual [27] 
L24:    invokeinterface [46] 0 
L29:    getstatic [7] 
L32:    ifnonnull L47 
L35:    ldc [8] 
L37:    invokestatic [9] 
L40:    dup 
L41:    putstatic [39] 
L44:    goto L50 
L47:    getstatic [7] 
L50:    invokevirtual [28] 
L53:    aload_0 
L54:    aload_0 
L55:    getfield [29] 
L58:    invokespecial [40] 
L61:    putfield [47] 
L64:    aload_0 
L65:    getfield [30] 
L68:    invokevirtual [31] 
L71:    return 
L72:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     invokeinterface [43] 0 
L9:     aload_0 
L10:    invokeinterface [48] 0 
L15:    aload_0 
L16:    getfield [30] 
L19:    invokevirtual [32] 
L22:    aload_0 
L23:    aconst_null 
L24:    putfield [47] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [244] .code stack 2 locals 2 
L0:     iload_1 
L1:     ldc [10] 
L3:     if_icmpeq L18 
L6:     iload_1 
L7:     ldc [11] 
L9:     if_icmpeq L18 
L12:    iload_1 
L13:    ldc [12] 
L15:    if_icmpne L73 
L18:    aload_2 
L19:    invokeinterface [49] 0 
L24:    astore_3 
L25:    aload_3 
L26:    ifnull L49 
L29:    aload_3 
L30:    invokeinterface [50] 0 
L35:    invokevirtual [33] 
L38:    ifne L45 
L41:    iconst_1 
L42:    goto L50 
L45:    iconst_0 
L46:    goto L50 
L49:    iconst_0 
L50:    istore 4 
L52:    iload 4 
L54:    aload_0 
L55:    getfield [34] 
L58:    if_icmpeq L73 
L61:    aload_0 
L62:    iload 4 
L64:    invokespecial [41] 
L67:    aload_0 
L68:    iload 4 
L70:    putfield [51] 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [253] : [254] 
    .attribute [244] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [35] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnull L29 
L9:     aload_0 
L10:    getfield [29] 
L13:    ldc [13] 
L15:    ldc [14] 
L17:    iload_1 
L18:    invokevirtual [36] 
L21:    pop 
L22:    aload_2 
L23:    iload_1 
L24:    invokeinterface [53] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [244] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     invokeinterface [46] 0 
L9:     aload_1 
L10:    invokeinterface [54] 0 
L15:    astore_2 
L16:    aload_2 
L17:    instanceof [15] 
L20:    ifeq L41 
L23:    aload_0 
L24:    aload_2 
L25:    checkcast [15] 
L28:    putfield [52] 
L31:    aload_0 
L32:    aload_0 
L33:    getfield [34] 
L36:    invokespecial [41] 
L39:    aload_2 
L40:    areturn 
L41:    aload_0 
L42:    invokevirtual [27] 
L45:    invokeinterface [46] 0 
L50:    aload_1 
L51:    invokeinterface [55] 0 
L56:    pop 
L57:    aconst_null 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public enum [257] : [258] 
    .attribute [244] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [15] 
L4:     ifeq L28 
L7:     aload_0 
L8:     invokevirtual [27] 
L11:    invokeinterface [46] 0 
L16:    aload_1 
L17:    invokeinterface [55] 0 
L22:    pop 
L23:    aload_0 
L24:    aconst_null 
L25:    putfield [52] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static synthetic [261] : [262] 
    .attribute [244] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [42] 
L9:     dup 
L10:    invokespecial [37] 
L13:    aload_1 
L14:    invokevirtual [26] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [56] [57] 
.const [3] = Class [58] 
.const [4] = Class [59] 
.const [5] = String [60] 
.const [6] = Class [61] 
.const [7] = Field [62] [63] 
.const [8] = String [64] 
.const [9] = Method [65] [66] 
.const [10] = Int 134217984 
.const [11] = Int 134218240 
.const [12] = Int 134218496 
.const [13] = Int 1078071040 
.const [14] = String [67] 
.const [15] = Class [68] 
.const [16] = Class [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Class [77] 
.const [25] = Class [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Field [85] [86] 
.const [30] = Field [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Field [95] [96] 
.const [35] = Field [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Field [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Class [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = Class [116] 
.const [46] = InterfaceMethod [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = InterfaceMethod [121] [122] 
.const [49] = InterfaceMethod [123] [124] 
.const [50] = InterfaceMethod [125] [126] 
.const [51] = Field [127] [128] 
.const [52] = Field [129] [130] 
.const [53] = InterfaceMethod [131] [132] 
.const [54] = InterfaceMethod [133] [134] 
.const [55] = InterfaceMethod [135] [136] 
.const [56] = Class [137] 
.const [57] = NameAndType [138] [139] 
.const [58] = Utf8 java/lang/ClassNotFoundException 
.const [59] = Utf8 java/lang/NoClassDefFoundError 
.const [60] = Utf8 'App.Phone.Main' 
.const [61] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [62] = Class [140] 
.const [63] = NameAndType [141] [142] 
.const [64] = Utf8 'de.audi.atip.interapp.CarPhoneService' 
.const [65] = Class [143] 
.const [66] = NameAndType [144] [145] 
.const [67] = Utf8 '[TelCarPhoneServiceHandler#updateGlobalTelephoneStateProperty] callActive=%1' 
.const [68] = Utf8 de/audi/atip/interapp/CarPhoneService 
.const [69] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [70] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [71] = Utf8 java/lang/Class 
.const [72] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [73] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [74] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [75] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [76] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Utf8 org/osgi/framework/BundleContext 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Class [149] 
.const [82] = NameAndType [150] [151] 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Class [158] 
.const [88] = NameAndType [159] [160] 
.const [89] = Class [161] 
.const [90] = NameAndType [162] [163] 
.const [91] = Class [164] 
.const [92] = NameAndType [165] [166] 
.const [93] = Class [167] 
.const [94] = NameAndType [168] [169] 
.const [95] = Class [170] 
.const [96] = NameAndType [171] [172] 
.const [97] = Class [173] 
.const [98] = NameAndType [174] [175] 
.const [99] = Class [176] 
.const [100] = NameAndType [177] [178] 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Class [188] 
.const [108] = NameAndType [189] [190] 
.const [109] = Class [191] 
.const [110] = NameAndType [192] [193] 
.const [111] = Utf8 java/lang/NoClassDefFoundError 
.const [112] = Class [194] 
.const [113] = NameAndType [195] [196] 
.const [114] = Class [197] 
.const [115] = NameAndType [198] [199] 
.const [116] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Class [215] 
.const [128] = NameAndType [216] [217] 
.const [129] = Class [218] 
.const [130] = NameAndType [219] [220] 
.const [131] = Class [221] 
.const [132] = NameAndType [222] [223] 
.const [133] = Class [224] 
.const [134] = NameAndType [225] [226] 
.const [135] = Class [227] 
.const [136] = NameAndType [228] [229] 
.const [137] = Utf8 java/lang/Class 
.const [138] = Utf8 forName 
.const [139] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [140] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [141] = Utf8 class$de$audi$atip$interapp$CarPhoneService 
.const [142] = Utf8 Ljava/lang/Class; 
.const [143] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [144] = Utf8 class$ 
.const [145] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [146] = Utf8 java/lang/NoClassDefFoundError 
.const [147] = Utf8 initCause 
.const [148] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [149] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [150] = Utf8 getApplication 
.const [151] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [152] = Utf8 java/lang/Class 
.const [153] = Utf8 getName 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [156] = Utf8 log 
.const [157] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [158] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [159] = Utf8 carPhoneServiceTracker 
.const [160] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [161] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [162] = Utf8 openTracker 
.const [163] = Utf8 ()V 
.const [164] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [165] = Utf8 closeTracker 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [168] = Utf8 isIdle 
.const [169] = Utf8 ()Z 
.const [170] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [171] = Utf8 callActive 
.const [172] = Utf8 Z 
.const [173] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [174] = Utf8 carPhoneService 
.const [175] = Utf8 Lde/audi/atip/interapp/CarPhoneService; 
.const [176] = Utf8 de/audi/atip/log/LogChannel 
.const [177] = Utf8 log 
.const [178] = Utf8 (ILjava/lang/String;Z)Z 
.const [179] = Utf8 java/lang/NoClassDefFoundError 
.const [180] = Utf8 <init> 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [185] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [186] = Utf8 class$de$audi$atip$interapp$CarPhoneService 
.const [187] = Utf8 Ljava/lang/Class; 
.const [188] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [191] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [192] = Utf8 updateCarPhoneService 
.const [193] = Utf8 (Z)V 
.const [194] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [195] = Utf8 getGlobalTelephoneStateManager 
.const [196] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [197] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [198] = Utf8 registerListener 
.const [199] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [200] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [201] = Utf8 getBundleContext 
.const [202] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [203] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [204] = Utf8 carPhoneServiceTracker 
.const [205] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [206] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [207] = Utf8 removeListener 
.const [208] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [209] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [210] = Utf8 getCallLeadingDevice 
.const [211] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [212] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [213] = Utf8 getCallState 
.const [214] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [215] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [216] = Utf8 callActive 
.const [217] = Utf8 Z 
.const [218] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [219] = Utf8 carPhoneService 
.const [220] = Utf8 Lde/audi/atip/interapp/CarPhoneService; 
.const [221] = Utf8 de/audi/atip/interapp/CarPhoneService 
.const [222] = Utf8 updateCallStatus 
.const [223] = Utf8 (Z)V 
.const [224] = Utf8 org/osgi/framework/BundleContext 
.const [225] = Utf8 getService 
.const [226] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [227] = Utf8 org/osgi/framework/BundleContext 
.const [228] = Utf8 ungetService 
.const [229] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [230] = Utf8 de/audi/app/phone/core/interapp/TelCarPhoneServiceHandler 
.const [231] = Class [230] 
.const [232] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [233] = Class [232] 
.const [234] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [235] = Class [234] 
.const [236] = Utf8 carPhoneServiceTracker 
.const [237] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [238] = Utf8 carPhoneService 
.const [239] = Utf8 Lde/audi/atip/interapp/CarPhoneService; 
.const [240] = Utf8 callActive 
.const [241] = Utf8 Z 
.const [242] = Utf8 class$de$audi$atip$interapp$CarPhoneService 
.const [243] = Utf8 Ljava/lang/Class; 
.const [244] = Utf8 Code 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [247] = Utf8 init 
.const [248] = Utf8 ()V 
.const [249] = Utf8 deinit 
.const [250] = Utf8 ()V 
.const [251] = Utf8 updateGlobalTelephoneStateProperty 
.const [252] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [253] = Utf8 updateCarPhoneService 
.const [254] = Utf8 (Z)V 
.const [255] = Utf8 addingService 
.const [256] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [257] = Utf8 modifiedService 
.const [258] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [259] = Utf8 removedService 
.const [260] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [261] = Utf8 class$ 
.const [262] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
