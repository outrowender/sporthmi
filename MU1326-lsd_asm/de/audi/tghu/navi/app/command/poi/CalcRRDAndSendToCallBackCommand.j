.version 50 0 
.class public super [146] 
.super [148] 
.field private static final [149] [150] 
.field private final [151] [152] 
.field private final [153] [154] 

.method public [156] : [157] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [30] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [31] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [155] .code stack 5 locals 1 
L0:     iconst_1 
L1:     anewarray [2] 
L4:     dup 
L5:     iconst_0 
L6:     aload_0 
L7:     getfield [17] 
L10:    aastore 
L11:    astore_1 
L12:    aload_0 
L13:    getfield [19] 
L16:    ldc [3] 
L18:    ldc [4] 
L20:    aload_1 
L21:    arraylength 
L22:    i2l 
L23:    invokevirtual [20] 
L26:    pop 
L27:    aload_0 
L28:    invokevirtual [21] 
L31:    aload_1 
L32:    invokeinterface [32] 0 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [155] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [22] 
L12:    aload_1 
L13:    invokevirtual [23] 
L16:    aload_1 
L17:    ifnonnull L40 
L20:    aload_0 
L21:    getfield [19] 
L24:    sipush 10000 
L27:    ldc [6] 
L29:    aload_0 
L30:    getfield [22] 
L33:    invokevirtual [24] 
L36:    pop 
L37:    goto L124 
L40:    aload_1 
L41:    arraylength 
L42:    iconst_1 
L43:    if_icmpeq L68 
L46:    aload_0 
L47:    getfield [19] 
L50:    ldc [7] 
L52:    ldc [8] 
L54:    aload_0 
L55:    getfield [22] 
L58:    aload_1 
L59:    arraylength 
L60:    i2l 
L61:    invokevirtual [25] 
L64:    pop 
L65:    goto L124 
L68:    aload_1 
L69:    iconst_0 
L70:    aaload 
L71:    ifnonnull L94 
L74:    aload_0 
L75:    getfield [19] 
L78:    sipush 10000 
L81:    ldc [9] 
L83:    aload_0 
L84:    getfield [22] 
L87:    invokevirtual [24] 
L90:    pop 
L91:    goto L124 
L94:    aload_0 
L95:    getfield [18] 
L98:    aload_1 
L99:    iconst_0 
L100:   aaload 
L101:   getfield [26] 
L104:   aload_1 
L105:   iconst_0 
L106:   aaload 
L107:   getfield [27] 
L110:   invokeinterface [33] 0 
L115:   aload_0 
L116:   invokevirtual [28] 
L119:   invokeinterface [34] 0 
L124:   return 
L125:   nop 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [155] .code stack 2 locals 0 
L0:     ldc_w [1] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [155] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokeinterface [35] 0 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Int 1078071040 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = Int -2137614336 
.const [8] = String [41] 
.const [9] = String [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Field [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Field [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = InterfaceMethod [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = Int -1741029376 
.const [37] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [38] = Utf8 'CalcRRDAndSendToCallBackCommand#execute() - calling rrdStartCalculationForPosition(), length: %1 ' 
.const [39] = Utf8 '%1#updateRrdCalculationInfo() - rrdCalculationInfo = %2' 
.const [40] = Utf8 '%1#updateRrdCalculationInfo() - array rrdCalculationInfo is null' 
.const [41] = Utf8 '%1#updateRrdCalculationInfo() - invalid size=%2' 
.const [42] = Utf8 '%1#updateRrdCalculationInfo() - array element at 0 of rrdCalculationInfo is null' 
.const [43] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [44] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [45] = Utf8 de/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [48] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [49] = Utf8 de/audi/tghu/command/ICommandList 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [89] = Utf8 navLocation 
.const [90] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [91] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [92] = Utf8 callback 
.const [93] = Utf8 Lde/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone; 
.const [94] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [95] = Utf8 logger 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;J)Z 
.const [100] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [101] = Utf8 getDSINavigation 
.const [102] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [103] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [104] = Utf8 CLASS_NAME 
.const [105] = Utf8 Ljava/lang/String; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [109] = Utf8 de/audi/atip/log/LogChannel 
.const [110] = Utf8 log 
.const [111] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [115] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [116] = Utf8 rrdInfo 
.const [117] = Utf8 I 
.const [118] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [119] = Utf8 rttInfo 
.const [120] = Utf8 J 
.const [121] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [122] = Utf8 getCommandList 
.const [123] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [124] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [128] = Utf8 navLocation 
.const [129] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [130] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [131] = Utf8 callback 
.const [132] = Utf8 Lde/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone; 
.const [133] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [134] = Utf8 rrdStartCalculationForPosition 
.const [135] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [136] = Utf8 de/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone 
.const [137] = Utf8 update 
.const [138] = Utf8 (IJ)V 
.const [139] = Utf8 de/audi/tghu/command/ICommandList 
.const [140] = Utf8 commandFinished 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone 
.const [143] = Utf8 resetRRDCalculationFlag 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/tghu/navi/app/command/poi/CalcRRDAndSendToCallBackCommand 
.const [146] = Class [145] 
.const [147] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [148] = Class [147] 
.const [149] = Utf8 TIMEOUT 
.const [150] = Utf8 J 
.const [151] = Utf8 navLocation 
.const [152] = Utf8 Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [153] = Utf8 callback 
.const [154] = Utf8 Lde/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone; 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lorg/dsi/ifc/global/NavLocationWgs84;Lde/audi/tghu/navi/app/map/NaviInterface$INotifyWhenRealRouteCalulcationisDone;)V 
.const [158] = Utf8 execute 
.const [159] = Utf8 ()V 
.const [160] = Utf8 updateRrdCalculationInfo 
.const [161] = Utf8 ([Lorg/dsi/ifc/navigation/RrdCalculationInfo;)V 
.const [162] = Utf8 getTimeout 
.const [163] = Utf8 ()J 
.const [164] = Utf8 resetRRDCalculationFlag 
.const [165] = Utf8 ()V 
.end class 
