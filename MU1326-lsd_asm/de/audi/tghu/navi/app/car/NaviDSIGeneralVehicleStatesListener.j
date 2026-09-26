.version 50 0 
.class public super [152] 
.super [154] 
.implements [156] 
.field private final [157] [158] 
.field private [159] [160] 

.method public [162] : [163] 
    .attribute [161] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [32] 
L9:     aload_0 
L10:    new [33] 
L13:    dup 
L14:    invokespecial [30] 
L17:    putfield [34] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [161] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokevirtual [23] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [161] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [24] 
L14:    pop 
L15:    iload_2 
L16:    iconst_1 
L17:    if_icmpeq L33 
L20:    aload_0 
L21:    getfield [21] 
L24:    ldc [3] 
L26:    ldc [5] 
L28:    invokevirtual [25] 
L31:    pop 
L32:    return 
L33:    aload_1 
L34:    ifnonnull L50 
L37:    aload_0 
L38:    getfield [21] 
L41:    ldc [3] 
L43:    ldc [6] 
L45:    invokevirtual [25] 
L48:    pop 
L49:    return 
L50:    aload_0 
L51:    getfield [22] 
L54:    dup 
L55:    astore_3 
L56:    monitorenter 
L57:    aload_0 
L58:    getfield [22] 
L61:    invokevirtual [26] 
L64:    astore 4 
L66:    aload 4 
L68:    invokeinterface [35] 0 
L73:    ifeq L117 
        .catch [8] from L76 to L96 using L99 
        .catch [0] from L57 to L119 using L122 
L76:    aload 4 
L78:    invokeinterface [36] 0 
L83:    checkcast [7] 
L86:    astore 5 
L88:    aload 5 
L90:    aload_1 
L91:    invokeinterface [37] 0 
L96:    goto L66 
L99:    astore 5 
L101:   aload_0 
L102:   getfield [21] 
L105:   sipush 10000 
L108:   ldc [9] 
L110:   invokevirtual [25] 
L113:   pop 
L114:   goto L66 
L117:   aload_3 
L118:   monitorexit 
L119:   goto L129 
        .catch [0] from L122 to L126 using L122 
L122:   astore 6 
L124:   aload_3 
L125:   monitorexit 
L126:   aload 6 
L128:   athrow 
L129:   return 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [161] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [10] 
L8:     iload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [27] 
L14:    pop 
L15:    iload_2 
L16:    iconst_1 
L17:    if_icmpeq L33 
L20:    aload_0 
L21:    getfield [21] 
L24:    ldc [3] 
L26:    ldc [11] 
L28:    invokevirtual [25] 
L31:    pop 
L32:    return 
L33:    aload_0 
L34:    getfield [22] 
L37:    dup 
L38:    astore_3 
L39:    monitorenter 
L40:    aload_0 
L41:    getfield [22] 
L44:    invokevirtual [26] 
L47:    astore 4 
L49:    aload 4 
L51:    invokeinterface [35] 0 
L56:    ifeq L100 
        .catch [8] from L59 to L79 using L82 
        .catch [0] from L40 to L102 using L105 
L59:    aload 4 
L61:    invokeinterface [36] 0 
L66:    checkcast [7] 
L69:    astore 5 
L71:    aload 5 
L73:    iload_1 
L74:    invokeinterface [38] 0 
L79:    goto L49 
L82:    astore 5 
L84:    aload_0 
L85:    getfield [21] 
L88:    sipush 10000 
L91:    ldc [12] 
L93:    invokevirtual [25] 
L96:    pop 
L97:    goto L49 
L100:   aload_3 
L101:   monitorexit 
L102:   goto L112 
        .catch [0] from L105 to L109 using L105 
L105:   astore 6 
L107:   aload_3 
L108:   monitorexit 
L109:   aload 6 
L111:   athrow 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [161] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [3] 
L6:     ldc [13] 
L8:     iload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [27] 
L14:    pop 
L15:    iload_2 
L16:    iconst_1 
L17:    if_icmpeq L33 
L20:    aload_0 
L21:    getfield [21] 
L24:    ldc [3] 
L26:    ldc [14] 
L28:    invokevirtual [25] 
L31:    pop 
L32:    return 
L33:    aload_0 
L34:    getfield [22] 
L37:    dup 
L38:    astore_3 
L39:    monitorenter 
L40:    aload_0 
L41:    getfield [22] 
L44:    invokevirtual [26] 
L47:    astore 4 
L49:    aload 4 
L51:    invokeinterface [35] 0 
L56:    ifeq L100 
        .catch [8] from L59 to L79 using L82 
        .catch [0] from L40 to L102 using L105 
L59:    aload 4 
L61:    invokeinterface [36] 0 
L66:    checkcast [7] 
L69:    astore 5 
L71:    aload 5 
L73:    iload_1 
L74:    invokeinterface [39] 0 
L79:    goto L49 
L82:    astore 5 
L84:    aload_0 
L85:    getfield [21] 
L88:    sipush 10000 
L91:    ldc [15] 
L93:    invokevirtual [25] 
L96:    pop 
L97:    goto L49 
L100:   aload_3 
L101:   monitorexit 
L102:   goto L112 
        .catch [0] from L105 to L109 using L105 
L105:   astore 6 
L107:   aload_3 
L108:   monitorexit 
L109:   aload 6 
L111:   athrow 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [172] : [173] 
    .attribute [161] .code stack 4 locals 0 
L0:     iconst_3 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     iconst_4 
L6:     iastore 
L7:     dup 
L8:     iconst_1 
L9:     bipush 16 
L11:    iastore 
L12:    dup 
L13:    iconst_2 
L14:    bipush 22 
L16:    iastore 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [174] : [175] 
    .attribute [161] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L30 using L33 
L7:     aload_1 
L8:     ifnonnull L19 
L11:    new [40] 
L14:    dup 
L15:    invokespecial [31] 
L18:    athrow 
L19:    aload_0 
L20:    getfield [22] 
L23:    aload_1 
L24:    invokevirtual [28] 
L27:    pop 
L28:    aload_2 
L29:    monitorexit 
L30:    goto L38 
        .catch [0] from L33 to L36 using L33 
L33:    astore_3 
L34:    aload_2 
L35:    monitorexit 
L36:    aload_3 
L37:    athrow 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public enum [176] : [177] 
    .attribute [161] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Int 1078071040 
.const [4] = String [42] 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = Class [45] 
.const [8] = Class [46] 
.const [9] = String [47] 
.const [10] = String [48] 
.const [11] = String [49] 
.const [12] = String [50] 
.const [13] = String [51] 
.const [14] = String [52] 
.const [15] = String [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Class [83] 
.const [34] = Field [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = InterfaceMethod [88] [89] 
.const [37] = InterfaceMethod [90] [91] 
.const [38] = InterfaceMethod [92] [93] 
.const [39] = InterfaceMethod [94] [95] 
.const [40] = Class [96] 
.const [41] = Utf8 java/util/ArrayList 
.const [42] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateTankInfo( %1, %2 )' 
.const [43] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateTankInfo() - update is invalid' 
.const [44] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateTankInfo() - tankInfo are null' 
.const [45] = Utf8 de/audi/tghu/navi/app/car/IVehicleStatesObserver 
.const [46] = Utf8 java/lang/Exception 
.const [47] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateBCViewOptions() - observer failed' 
.const [48] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateDisplayDayNightDesign( %1, %2 )' 
.const [49] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateDisplayDayNightDesign() - update is invalid' 
.const [50] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateDisplayDayNightDesign() - observer failed' 
.const [51] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateVehicleStandstill( %1, %2 )' 
.const [52] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateVehicleStandstill() - update is invalid' 
.const [53] = Utf8 'NaviDSIGeneralVehicleStatesListener#updateVehicleStandstill() - observer failed' 
.const [54] = Utf8 java/lang/IllegalArgumentException 
.const [55] = Utf8 de/audi/tghu/navi/app/car/NaviDSIGeneralVehicleStatesListener 
.const [56] = Utf8 de/audi/tghu/navi/app/car/AbstractNaviDSIGeneralVehicleStatesListener 
.const [57] = Utf8 de/audi/atip/log/LogChannel 
.const [58] = Utf8 java/util/Iterator 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Class [109] 
.const [68] = NameAndType [110] [111] 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Class [118] 
.const [74] = NameAndType [119] [120] 
.const [75] = Class [121] 
.const [76] = NameAndType [122] [123] 
.const [77] = Class [124] 
.const [78] = NameAndType [125] [126] 
.const [79] = Class [127] 
.const [80] = NameAndType [128] [129] 
.const [81] = Class [130] 
.const [82] = NameAndType [131] [132] 
.const [83] = Utf8 java/util/ArrayList 
.const [84] = Class [133] 
.const [85] = NameAndType [134] [135] 
.const [86] = Class [136] 
.const [87] = NameAndType [137] [138] 
.const [88] = Class [139] 
.const [89] = NameAndType [140] [141] 
.const [90] = Class [142] 
.const [91] = NameAndType [143] [144] 
.const [92] = Class [145] 
.const [93] = NameAndType [146] [147] 
.const [94] = Class [148] 
.const [95] = NameAndType [149] [150] 
.const [96] = Utf8 java/lang/IllegalArgumentException 
.const [97] = Utf8 de/audi/tghu/navi/app/car/NaviDSIGeneralVehicleStatesListener 
.const [98] = Utf8 logChannel 
.const [99] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [100] = Utf8 de/audi/tghu/navi/app/car/NaviDSIGeneralVehicleStatesListener 
.const [101] = Utf8 observersList 
.const [102] = Utf8 Ljava/util/ArrayList; 
.const [103] = Utf8 java/util/ArrayList 
.const [104] = Utf8 clear 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [109] = Utf8 de/audi/atip/log/LogChannel 
.const [110] = Utf8 log 
.const [111] = Utf8 (ILjava/lang/String;)Z 
.const [112] = Utf8 java/util/ArrayList 
.const [113] = Utf8 iterator 
.const [114] = Utf8 ()Ljava/util/Iterator; 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;ZJ)Z 
.const [118] = Utf8 java/util/ArrayList 
.const [119] = Utf8 add 
.const [120] = Utf8 (Ljava/lang/Object;)Z 
.const [121] = Utf8 de/audi/tghu/navi/app/car/AbstractNaviDSIGeneralVehicleStatesListener 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 java/util/ArrayList 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 java/lang/IllegalArgumentException 
.const [128] = Utf8 <init> 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/audi/tghu/navi/app/car/NaviDSIGeneralVehicleStatesListener 
.const [131] = Utf8 logChannel 
.const [132] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [133] = Utf8 de/audi/tghu/navi/app/car/NaviDSIGeneralVehicleStatesListener 
.const [134] = Utf8 observersList 
.const [135] = Utf8 Ljava/util/ArrayList; 
.const [136] = Utf8 java/util/Iterator 
.const [137] = Utf8 hasNext 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 java/util/Iterator 
.const [140] = Utf8 next 
.const [141] = Utf8 ()Ljava/lang/Object; 
.const [142] = Utf8 de/audi/tghu/navi/app/car/IVehicleStatesObserver 
.const [143] = Utf8 updateTankInfo 
.const [144] = Utf8 (Lorg/dsi/ifc/generalvehiclestates/TankInfo;)V 
.const [145] = Utf8 de/audi/tghu/navi/app/car/IVehicleStatesObserver 
.const [146] = Utf8 updateDisplayDayNightDesign 
.const [147] = Utf8 (Z)V 
.const [148] = Utf8 de/audi/tghu/navi/app/car/IVehicleStatesObserver 
.const [149] = Utf8 updateVehicleStandstill 
.const [150] = Utf8 (Z)V 
.const [151] = Utf8 de/audi/tghu/navi/app/car/NaviDSIGeneralVehicleStatesListener 
.const [152] = Class [151] 
.const [153] = Utf8 de/audi/tghu/navi/app/car/AbstractNaviDSIGeneralVehicleStatesListener 
.const [154] = Class [153] 
.const [155] = Utf8 de/audi/tghu/navi/app/car/IVehicleStatesEventsProvider 
.const [156] = Class [155] 
.const [157] = Utf8 logChannel 
.const [158] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [159] = Utf8 observersList 
.const [160] = Utf8 Ljava/util/ArrayList; 
.const [161] = Utf8 Code 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [164] = Utf8 cleanUp 
.const [165] = Utf8 ()V 
.const [166] = Utf8 updateTankInfo 
.const [167] = Utf8 (Lorg/dsi/ifc/generalvehiclestates/TankInfo;I)V 
.const [168] = Utf8 updateDisplayDayNightDesign 
.const [169] = Utf8 (ZI)V 
.const [170] = Utf8 updateVehicleStandstill 
.const [171] = Utf8 (ZI)V 
.const [172] = Utf8 getAutoNotifications 
.const [173] = Utf8 ()[I 
.const [174] = Utf8 registerListener 
.const [175] = Utf8 (Lde/audi/tghu/navi/app/car/IVehicleStatesObserver;)V 
.const [176] = Utf8 unregisterListener 
.const [177] = Utf8 (Lde/audi/tghu/navi/app/car/IVehicleStatesObserver;)V 
.end class 
