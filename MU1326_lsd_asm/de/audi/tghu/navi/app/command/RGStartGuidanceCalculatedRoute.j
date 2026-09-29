.version 50 0 
.class public super [222] 
.super [224] 
.field private [225] [226] 
.field private [227] [228] 
.field private [229] [230] 

.method public [232] : [233] 
    .attribute [231] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [46] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [47] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [48] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [231] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokevirtual [27] 
L7:     istore_1 
L8:     aload_0 
L9:     invokespecial [40] 
L12:    istore_2 
L13:    iload_2 
L14:    ifeq L54 
L17:    aload_0 
L18:    getfield [28] 
L21:    ldc [2] 
L23:    ldc [3] 
L25:    aload_0 
L26:    getfield [23] 
L29:    i2l 
L30:    invokevirtual [29] 
L33:    pop 
L34:    aload_0 
L35:    invokevirtual [30] 
L38:    aload_0 
L39:    getfield [23] 
L42:    invokeinterface [49] 0 
L47:    iload_1 
L48:    ifeq L75 
L51:    goto L75 
L54:    aload_0 
L55:    getfield [28] 
L58:    ldc [4] 
L60:    ldc [5] 
L62:    invokevirtual [31] 
L65:    pop 
L66:    aload_0 
L67:    invokevirtual [32] 
L70:    invokeinterface [50] 0 
L75:    return 
L76:    
    .end code 
.end method 

.method private [236] : [237] 
    .attribute [231] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokevirtual [33] 
L7:     istore_1 
L8:     aload_0 
L9:     getfield [26] 
L12:    invokevirtual [34] 
L15:    astore_2 
L16:    aload_0 
L17:    getfield [28] 
L20:    invokevirtual [35] 
L23:    ifeq L64 
L26:    new [51] 
L29:    dup 
L30:    invokespecial [41] 
L33:    astore_3 
L34:    aload_3 
L35:    aload_2 
L36:    invokestatic [7] 
L39:    aload_0 
L40:    getfield [28] 
L43:    invokevirtual [35] 
L46:    ifeq L64 
L49:    aload_0 
L50:    getfield [28] 
L53:    ldc [8] 
L55:    ldc [9] 
L57:    aload_3 
L58:    iload_1 
L59:    i2l 
L60:    invokevirtual [36] 
L63:    pop 
L64:    iload_1 
L65:    iconst_1 
L66:    if_icmpeq L79 
L69:    iload_1 
L70:    iconst_2 
L71:    if_icmpeq L79 
L74:    iload_1 
L75:    iconst_3 
L76:    if_icmpne L83 
L79:    iconst_1 
L80:    goto L84 
L83:    iconst_0 
L84:    istore_3 
L85:    aload_2 
L86:    ifnull L115 
L89:    aload_2 
L90:    arraylength 
L91:    aload_0 
L92:    getfield [23] 
L95:    if_icmple L115 
L98:    aload_0 
L99:    aload_2 
L100:   aload_0 
L101:   getfield [23] 
L104:   aaload 
L105:   invokespecial [42] 
L108:   ifeq L115 
L111:   iconst_1 
L112:   goto L116 
L115:   iconst_0 
L116:   istore 4 
L118:   iload_3 
L119:   ifeq L131 
L122:   iload 4 
L124:   ifeq L131 
L127:   iconst_1 
L128:   goto L132 
L131:   iconst_0 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method private [238] : [239] 
    .attribute [231] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [37] 
L4:     iconst_3 
L5:     if_icmpeq L24 
L8:     aload_1 
L9:     invokevirtual [37] 
L12:    iconst_2 
L13:    if_icmpeq L24 
L16:    aload_1 
L17:    invokevirtual [37] 
L20:    iconst_5 
L21:    if_icmpne L28 
L24:    iconst_1 
L25:    goto L29 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [240] : [241] 
    .attribute [231] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifne L17 
L7:     aload_0 
L8:     getfield [26] 
L11:    invokevirtual [27] 
L14:    ifeq L45 
L17:    aload_0 
L18:    getfield [25] 
L21:    ifeq L45 
L24:    aload_0 
L25:    getfield [28] 
L28:    ldc [2] 
L30:    ldc [10] 
L32:    invokevirtual [31] 
L35:    pop 
L36:    aload_0 
L37:    invokevirtual [32] 
L40:    invokeinterface [50] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [231] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [11] 
L8:     iload_1 
L9:     invokevirtual [38] 
L12:    pop 
L13:    aload_0 
L14:    iload_1 
L15:    invokespecial [43] 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [47] 
L23:    aload_0 
L24:    invokespecial [44] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [231] .code stack 5 locals 0 
L0:     iload_1 
L1:     ifne L28 
L4:     aload_0 
L5:     getfield [28] 
L8:     ldc [2] 
L10:    ldc [12] 
L12:    invokevirtual [31] 
L15:    pop 
L16:    aload_0 
L17:    iconst_1 
L18:    putfield [48] 
L21:    aload_0 
L22:    invokespecial [44] 
L25:    goto L54 
L28:    aload_0 
L29:    getfield [28] 
L32:    sipush 10000 
L35:    ldc [13] 
L37:    iload_1 
L38:    i2l 
L39:    invokevirtual [29] 
L42:    pop 
L43:    aload_0 
L44:    invokevirtual [32] 
L47:    iload_1 
L48:    i2l 
L49:    invokeinterface [52] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [231] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     sipush 10000 
L7:     ldc [14] 
L9:     iload_1 
L10:    i2l 
L11:    invokevirtual [29] 
L14:    pop 
L15:    aload_0 
L16:    iload_1 
L17:    invokespecial [45] 
L20:    aload_0 
L21:    invokevirtual [32] 
L24:    iload_1 
L25:    i2l 
L26:    invokeinterface [52] 0 
L31:    return 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [53] 
.const [4] = Int -1601830656 
.const [5] = String [54] 
.const [6] = Class [55] 
.const [7] = Method [56] [57] 
.const [8] = Int 14808325 
.const [9] = String [58] 
.const [10] = String [59] 
.const [11] = String [60] 
.const [12] = String [61] 
.const [13] = String [62] 
.const [14] = String [63] 
.const [15] = Class [64] 
.const [16] = Class [65] 
.const [17] = Class [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Field [72] [73] 
.const [24] = Field [74] [75] 
.const [25] = Field [76] [77] 
.const [26] = Field [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Method [114] [115] 
.const [45] = Method [116] [117] 
.const [46] = Field [118] [119] 
.const [47] = Field [120] [121] 
.const [48] = Field [122] [123] 
.const [49] = InterfaceMethod [124] [125] 
.const [50] = InterfaceMethod [126] [127] 
.const [51] = Class [128] 
.const [52] = InterfaceMethod [129] [130] 
.const [53] = Utf8 'RGStartGuidanceCalculatedRoute#execute() - calling rgStartGuidanceCalculatedRoute( %1 ) ' 
.const [54] = Utf8 'RGStartGuidanceCalculatedRoute#execute() - route calculation state is not valid, do not start guidance!' 
.const [55] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [56] = Class [131] 
.const [57] = NameAndType [132] [133] 
.const [58] = Utf8 'RGStartGuidanceCalculatedRoute#checkRouteCalculation() - rgRouteCalculationState: %2, rgCalculatedRoutes: %1' 
.const [59] = Utf8 'RGStartGuidanceCalculatedRoute#checkFinished() - guidance has been started successfully!' 
.const [60] = Utf8 'RGStartGuidanceCalculatedRoute#updateRgActive( %1 ) ' 
.const [61] = Utf8 'RGStartGuidanceCalculatedRoute#rgStartGuidanceCalculatedRouteResult()' 
.const [62] = Utf8 'RGStartGuidanceCalculatedRoute#rgStartGuidanceCalculatedRouteResult() - got error code %1 !' 
.const [63] = Utf8 'RGStartGuidanceCalculatedRoute#rgNotPossible( %1 )' 
.const [64] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [65] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [66] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [69] = Utf8 de/audi/tghu/command/ICommandList 
.const [70] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [71] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [72] = Class [134] 
.const [73] = NameAndType [135] [136] 
.const [74] = Class [137] 
.const [75] = NameAndType [138] [139] 
.const [76] = Class [140] 
.const [77] = NameAndType [141] [142] 
.const [78] = Class [143] 
.const [79] = NameAndType [144] [145] 
.const [80] = Class [146] 
.const [81] = NameAndType [147] [148] 
.const [82] = Class [149] 
.const [83] = NameAndType [150] [151] 
.const [84] = Class [152] 
.const [85] = NameAndType [153] [154] 
.const [86] = Class [155] 
.const [87] = NameAndType [156] [157] 
.const [88] = Class [158] 
.const [89] = NameAndType [159] [160] 
.const [90] = Class [161] 
.const [91] = NameAndType [162] [163] 
.const [92] = Class [164] 
.const [93] = NameAndType [165] [166] 
.const [94] = Class [167] 
.const [95] = NameAndType [168] [169] 
.const [96] = Class [170] 
.const [97] = NameAndType [171] [172] 
.const [98] = Class [173] 
.const [99] = NameAndType [174] [175] 
.const [100] = Class [176] 
.const [101] = NameAndType [177] [178] 
.const [102] = Class [179] 
.const [103] = NameAndType [180] [181] 
.const [104] = Class [182] 
.const [105] = NameAndType [183] [184] 
.const [106] = Class [185] 
.const [107] = NameAndType [186] [187] 
.const [108] = Class [188] 
.const [109] = NameAndType [189] [190] 
.const [110] = Class [191] 
.const [111] = NameAndType [192] [193] 
.const [112] = Class [194] 
.const [113] = NameAndType [195] [196] 
.const [114] = Class [197] 
.const [115] = NameAndType [198] [199] 
.const [116] = Class [200] 
.const [117] = NameAndType [201] [202] 
.const [118] = Class [203] 
.const [119] = NameAndType [204] [205] 
.const [120] = Class [206] 
.const [121] = NameAndType [207] [208] 
.const [122] = Class [209] 
.const [123] = NameAndType [210] [211] 
.const [124] = Class [212] 
.const [125] = NameAndType [213] [214] 
.const [126] = Class [215] 
.const [127] = NameAndType [216] [217] 
.const [128] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [129] = Class [218] 
.const [130] = NameAndType [219] [220] 
.const [131] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [132] = Utf8 appendObjectArray 
.const [133] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;[Ljava/lang/Object;)V 
.const [134] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [135] = Utf8 index 
.const [136] = Utf8 I 
.const [137] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [138] = Utf8 rgActiveSent 
.const [139] = Utf8 Z 
.const [140] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [141] = Utf8 resultSent 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [144] = Utf8 dsiResponseContainer 
.const [145] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [146] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [147] = Utf8 isRgActive 
.const [148] = Utf8 ()Z 
.const [149] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [150] = Utf8 logger 
.const [151] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [152] = Utf8 de/audi/atip/log/LogChannel 
.const [153] = Utf8 log 
.const [154] = Utf8 (ILjava/lang/String;J)Z 
.const [155] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [156] = Utf8 getDSINavigation 
.const [157] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [158] = Utf8 de/audi/atip/log/LogChannel 
.const [159] = Utf8 log 
.const [160] = Utf8 (ILjava/lang/String;)Z 
.const [161] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [162] = Utf8 getCommandList 
.const [163] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [164] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [165] = Utf8 getRgRouteCalculationState 
.const [166] = Utf8 ()I 
.const [167] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [168] = Utf8 getCalculatedRoutes 
.const [169] = Utf8 ()[Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 isDebug2 
.const [172] = Utf8 ()Z 
.const [173] = Utf8 de/audi/atip/log/LogChannel 
.const [174] = Utf8 log 
.const [175] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [176] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [177] = Utf8 getCalculationState 
.const [178] = Utf8 ()I 
.const [179] = Utf8 de/audi/atip/log/LogChannel 
.const [180] = Utf8 log 
.const [181] = Utf8 (ILjava/lang/String;Z)Z 
.const [182] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [183] = Utf8 <init> 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [186] = Utf8 checkRouteCalculation 
.const [187] = Utf8 ()Z 
.const [188] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [189] = Utf8 <init> 
.const [190] = Utf8 ()V 
.const [191] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [192] = Utf8 isCRLElementCalculated 
.const [193] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;)Z 
.const [194] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [195] = Utf8 updateRgActive 
.const [196] = Utf8 (Z)V 
.const [197] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [198] = Utf8 checkFinished 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [201] = Utf8 rgNotPossible 
.const [202] = Utf8 (I)V 
.const [203] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [204] = Utf8 index 
.const [205] = Utf8 I 
.const [206] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [207] = Utf8 rgActiveSent 
.const [208] = Utf8 Z 
.const [209] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [210] = Utf8 resultSent 
.const [211] = Utf8 Z 
.const [212] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [213] = Utf8 rgStartGuidanceCalculatedRoute 
.const [214] = Utf8 (I)V 
.const [215] = Utf8 de/audi/tghu/command/ICommandList 
.const [216] = Utf8 commandFinished 
.const [217] = Utf8 ()V 
.const [218] = Utf8 de/audi/tghu/command/ICommandList 
.const [219] = Utf8 commandAborted 
.const [220] = Utf8 (J)V 
.const [221] = Utf8 de/audi/tghu/navi/app/command/RGStartGuidanceCalculatedRoute 
.const [222] = Class [221] 
.const [223] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [224] = Class [223] 
.const [225] = Utf8 index 
.const [226] = Utf8 I 
.const [227] = Utf8 rgActiveSent 
.const [228] = Utf8 Z 
.const [229] = Utf8 resultSent 
.const [230] = Utf8 Z 
.const [231] = Utf8 Code 
.const [232] = Utf8 <init> 
.const [233] = Utf8 (I)V 
.const [234] = Utf8 execute 
.const [235] = Utf8 ()V 
.const [236] = Utf8 checkRouteCalculation 
.const [237] = Utf8 ()Z 
.const [238] = Utf8 isCRLElementCalculated 
.const [239] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;)Z 
.const [240] = Utf8 checkFinished 
.const [241] = Utf8 ()V 
.const [242] = Utf8 updateRgActive 
.const [243] = Utf8 (Z)V 
.const [244] = Utf8 rgStartGuidanceCalculatedRouteResult 
.const [245] = Utf8 (I)V 
.const [246] = Utf8 rgNotPossible 
.const [247] = Utf8 (I)V 
.end class 
