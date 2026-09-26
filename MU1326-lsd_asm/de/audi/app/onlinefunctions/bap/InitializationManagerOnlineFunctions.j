.version 50 0 
.class super [227] 
.super [229] 

.method public annotation [231] : [232] 
    .attribute [230] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [46] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [233] : [234] 
    .attribute [230] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [235] : [236] 
    .attribute [230] .code stack 8 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [22] 
L12:    invokevirtual [23] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [24] 
L20:    ifne L28 
L23:    iconst_0 
L24:    istore_1 
L25:    goto L95 
L28:    aload_0 
L29:    invokevirtual [25] 
L32:    ifne L45 
L35:    iconst_0 
L36:    istore_1 
L37:    aload_0 
L38:    iconst_0 
L39:    invokevirtual [26] 
L42:    goto L95 
L45:    aload_0 
L46:    invokevirtual [25] 
L49:    iconst_1 
L50:    if_icmpne L72 
L53:    aload_0 
L54:    invokevirtual [27] 
L57:    bipush 9 
L59:    if_icmplt L67 
L62:    iconst_2 
L63:    istore_1 
L64:    goto L95 
L67:    iconst_1 
L68:    istore_1 
L69:    goto L95 
L72:    aload_0 
L73:    getfield [21] 
L76:    sipush 10000 
L79:    ldc [4] 
L81:    aload_0 
L82:    getfield [22] 
L85:    aload_0 
L86:    invokevirtual [25] 
L89:    i2l 
L90:    invokevirtual [28] 
L93:    pop 
L94:    return 
L95:    aload_0 
L96:    invokevirtual [29] 
L99:    iload_1 
L100:   if_icmpeq L181 
L103:   aload_0 
L104:   getfield [21] 
L107:   ldc [5] 
L109:   ldc [6] 
L111:   aload_0 
L112:   getfield [22] 
L115:   iload_1 
L116:   invokestatic [7] 
L119:   invokevirtual [30] 
L122:   iload_1 
L123:   iconst_1 
L124:   if_icmpne L135 
L127:   aload_0 
L128:   iconst_2 
L129:   invokevirtual [26] 
L132:   goto L161 
L135:   iload_1 
L136:   iconst_2 
L137:   if_icmpne L149 
L140:   aload_0 
L141:   bipush 10 
L143:   invokevirtual [26] 
L146:   goto L161 
L149:   aload_0 
L150:   iload_1 
L151:   invokevirtual [31] 
L154:   aload_0 
L155:   getfield [32] 
L158:   invokevirtual [33] 
L161:   aload_0 
L162:   getfield [34] 
L165:   aload_0 
L166:   getfield [32] 
L169:   invokevirtual [35] 
L172:   iload_1 
L173:   invokeinterface [49] 0 
L178:   goto L225 
L181:   aload_0 
L182:   getfield [21] 
L185:   ldc [5] 
L187:   ldc [8] 
L189:   new [50] 
L192:   dup 
L193:   aload_0 
L194:   invokevirtual [29] 
L197:   invokespecial [47] 
L200:   new [50] 
L203:   dup 
L204:   aload_0 
L205:   invokevirtual [25] 
L208:   invokespecial [47] 
L211:   new [50] 
L214:   dup 
L215:   aload_0 
L216:   invokevirtual [27] 
L219:   invokespecial [47] 
L222:   invokevirtual [36] 
L225:   return 
L226:   nop 
L227:   nop 
L228:   
    .end code 
.end method 

.method public enum [237] : [238] 
    .attribute [230] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [230] .code stack 2 locals 1 
L0:     new [51] 
L3:     dup 
L4:     invokespecial [48] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [11] 
L11:    invokevirtual [37] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [38] 
L20:    invokevirtual [39] 
L23:    pop 
L24:    aload_1 
L25:    bipush 10 
L27:    invokevirtual [40] 
L30:    pop 
L31:    aload_1 
L32:    invokevirtual [41] 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [230] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [42] 
L4:     invokevirtual [43] 
L7:     checkcast [12] 
L10:    astore_1 
L11:    aload_1 
L12:    getfield [44] 
L15:    ifne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [230] .code stack 5 locals 2 
L0:     iload_1 
L1:     tableswitch 0 
            L32 
            L37 
            L42 
            L47 
            default : L53 

L32:    iconst_0 
L33:    istore_2 
L34:    goto L70 
L37:    iconst_1 
L38:    istore_2 
L39:    goto L70 
L42:    iconst_3 
L43:    istore_2 
L44:    goto L70 
L47:    bipush 15 
L49:    istore_2 
L50:    goto L70 
L53:    aload_0 
L54:    getfield [21] 
L57:    sipush 10000 
L60:    ldc [13] 
L62:    iload_1 
L63:    i2l 
L64:    invokevirtual [45] 
L67:    pop 
L68:    iconst_0 
L69:    areturn 
L70:    aload_0 
L71:    getfield [42] 
L74:    invokevirtual [43] 
L77:    checkcast [12] 
L80:    astore_3 
L81:    aload_3 
L82:    getfield [44] 
L85:    iload_2 
L86:    if_icmpeq L96 
L89:    aload_3 
L90:    iload_2 
L91:    putfield [52] 
L94:    iconst_1 
L95:    areturn 
L96:    iconst_0 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 14808325 
.const [3] = String [53] 
.const [4] = String [54] 
.const [5] = Int -2137614336 
.const [6] = String [55] 
.const [7] = Method [56] [57] 
.const [8] = String [58] 
.const [9] = Class [59] 
.const [10] = Class [60] 
.const [11] = String [61] 
.const [12] = Class [62] 
.const [13] = String [63] 
.const [14] = Class [64] 
.const [15] = Class [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Field [71] [72] 
.const [22] = Field [73] [74] 
.const [23] = Method [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Field [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Field [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Method [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Method [109] [110] 
.const [41] = Method [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Method [115] [116] 
.const [44] = Field [117] [118] 
.const [45] = Method [119] [120] 
.const [46] = Method [121] [122] 
.const [47] = Method [123] [124] 
.const [48] = Method [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = Class [129] 
.const [51] = Class [130] 
.const [52] = Field [131] [132] 
.const [53] = Utf8 '[InitializationManagerOnlineFunctions#updateHMIState] called for lsgID=%1' 
.const [54] = Utf8 '[InitializationManagerOnlineFunctions#updateHMIState] module: %1 invalid bapStackState: %2' 
.const [55] = Utf8 '[InitializationManagerOnlineFunctions#updateHMIState] new hmi state for lsgID=%1 is now: %2' 
.const [56] = Class [133] 
.const [57] = NameAndType [134] [135] 
.const [58] = Utf8 "[InitializationManagerOnlineFunctions#updateHMIState] hmi state didn't change (hmiState=%1, bapStackState=%2, initstate=%3)" 
.const [59] = Utf8 java/lang/Integer 
.const [60] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [61] = Utf8 'appStateOnlineFunctions = ' 
.const [62] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/FSG_OperationState_Status 
.const [63] = Utf8 '[InitializationManagerOnlineFunctions#setFSGOperationStateValue] invalid opState: %1' 
.const [64] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [65] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 de/audi/app/bap/utils/LoggingUtils 
.const [68] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [69] = Utf8 de/audi/app/bap/dsi/bap/IDSIBAPController 
.const [70] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [71] = Class [136] 
.const [72] = NameAndType [137] [138] 
.const [73] = Class [139] 
.const [74] = NameAndType [140] [141] 
.const [75] = Class [142] 
.const [76] = NameAndType [143] [144] 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Class [175] 
.const [98] = NameAndType [176] [177] 
.const [99] = Class [178] 
.const [100] = NameAndType [179] [180] 
.const [101] = Class [181] 
.const [102] = NameAndType [182] [183] 
.const [103] = Class [184] 
.const [104] = NameAndType [185] [186] 
.const [105] = Class [187] 
.const [106] = NameAndType [188] [189] 
.const [107] = Class [190] 
.const [108] = NameAndType [191] [192] 
.const [109] = Class [193] 
.const [110] = NameAndType [194] [195] 
.const [111] = Class [196] 
.const [112] = NameAndType [197] [198] 
.const [113] = Class [199] 
.const [114] = NameAndType [200] [201] 
.const [115] = Class [202] 
.const [116] = NameAndType [203] [204] 
.const [117] = Class [205] 
.const [118] = NameAndType [206] [207] 
.const [119] = Class [208] 
.const [120] = NameAndType [209] [210] 
.const [121] = Class [211] 
.const [122] = NameAndType [212] [213] 
.const [123] = Class [214] 
.const [124] = NameAndType [215] [216] 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Class [220] 
.const [128] = NameAndType [221] [222] 
.const [129] = Utf8 java/lang/Integer 
.const [130] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [131] = Class [223] 
.const [132] = NameAndType [224] [225] 
.const [133] = Utf8 de/audi/app/bap/utils/LoggingUtils 
.const [134] = Utf8 getHMIStateDescription 
.const [135] = Utf8 (I)Ljava/lang/String; 
.const [136] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [137] = Utf8 logChannel 
.const [138] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [139] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [140] = Utf8 lsgIDDescription 
.const [141] = Utf8 Ljava/lang/String; 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [145] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [146] = Utf8 isDsiBapAvailable 
.const [147] = Utf8 ()Z 
.const [148] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [149] = Utf8 getBapStackState 
.const [150] = Utf8 ()I 
.const [151] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [152] = Utf8 setInitState 
.const [153] = Utf8 (I)V 
.const [154] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [155] = Utf8 getInitState 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/audi/atip/log/LogChannel 
.const [158] = Utf8 log 
.const [159] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [160] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [161] = Utf8 getHMIState 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/audi/atip/log/LogChannel 
.const [164] = Utf8 log 
.const [165] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [166] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [167] = Utf8 setHMIState 
.const [168] = Utf8 (I)V 
.const [169] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [170] = Utf8 'module' 
.const [171] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [172] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [173] = Utf8 resetBAPFunctions 
.const [174] = Utf8 ()V 
.const [175] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [176] = Utf8 dsiController 
.const [177] = Utf8 Lde/audi/app/bap/dsi/bap/IDSIBAPController; 
.const [178] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [179] = Utf8 getLSGID 
.const [180] = Utf8 ()I 
.const [181] = Utf8 de/audi/atip/log/LogChannel 
.const [182] = Utf8 log 
.const [183] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [184] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [185] = Utf8 append 
.const [186] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [187] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [188] = Utf8 getAppState 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [191] = Utf8 append 
.const [192] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [193] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [194] = Utf8 append 
.const [195] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [196] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [197] = Utf8 toString 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [200] = Utf8 fsgOperationStateFunction 
.const [201] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [202] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [203] = Utf8 getLastStatus 
.const [204] = Utf8 ()Lde/vw/mib/bap/requests/StatusProperty; 
.const [205] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/FSG_OperationState_Status 
.const [206] = Utf8 op_State 
.const [207] = Utf8 I 
.const [208] = Utf8 de/audi/atip/log/LogChannel 
.const [209] = Utf8 log 
.const [210] = Utf8 (ILjava/lang/String;J)Z 
.const [211] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [212] = Utf8 <init> 
.const [213] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/audi/app/bap/dsi/bap/IDSIBAPController;Lde/audi/app/bap/IPowerState;)V 
.const [214] = Utf8 java/lang/Integer 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (I)V 
.const [217] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [218] = Utf8 <init> 
.const [219] = Utf8 ()V 
.const [220] = Utf8 de/audi/app/bap/dsi/bap/IDSIBAPController 
.const [221] = Utf8 setHMIState 
.const [222] = Utf8 (II)V 
.const [223] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/FSG_OperationState_Status 
.const [224] = Utf8 op_State 
.const [225] = Utf8 I 
.const [226] = Utf8 de/audi/app/onlinefunctions/bap/InitializationManagerOnlineFunctions 
.const [227] = Class [226] 
.const [228] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [229] = Class [228] 
.const [230] = Utf8 Code 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/audi/app/bap/dsi/bap/IDSIBAPController;Lde/audi/app/bap/IPowerState;)V 
.const [233] = Utf8 getAppState 
.const [234] = Utf8 ()I 
.const [235] = Utf8 updateHMIState 
.const [236] = Utf8 ()V 
.const [237] = Utf8 appStateChanged 
.const [238] = Utf8 (Ljava/lang/String;I)V 
.const [239] = Utf8 appStatesToString 
.const [240] = Utf8 ()Ljava/lang/String; 
.const [241] = Utf8 isOpStateNormalOperation 
.const [242] = Utf8 ()Z 
.const [243] = Utf8 setFSGOperationStateValue 
.const [244] = Utf8 (I)Z 
.end class 
