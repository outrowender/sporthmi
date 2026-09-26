.version 50 0 
.class public super abstract [304] 
.super [306] 
.field public static final [307] [308] 
.field public static final [309] [310] 
.field public static final [311] [312] 
.field public static final [313] [314] 
.field protected final [315] [316] 
.field private final [317] [318] 
.field protected final [319] [320] 
.field private final [321] [322] 
.field private final [323] [324] 
.field protected final [325] [326] 
.field private volatile [327] [328] 
.field private volatile [329] [330] 

.method public [332] : [333] 
    .attribute [331] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     invokevirtual [22] 
L5:     invokespecial [53] 
L8:     aload_0 
L9:     iconst_0 
L10:    putfield [57] 
L13:    aload_0 
L14:    iconst_m1 
L15:    putfield [58] 
L18:    aload_0 
L19:    aload_1 
L20:    putfield [59] 
L23:    aload_0 
L24:    aload_2 
L25:    putfield [60] 
L28:    aload_0 
L29:    aload_1 
L30:    iload_3 
L31:    invokevirtual [26] 
L34:    putfield [61] 
L37:    aload_0 
L38:    getfield [27] 
L41:    iconst_1 
L42:    invokevirtual [28] 
L45:    aload_0 
L46:    aload_1 
L47:    invokevirtual [29] 
L50:    putfield [62] 
L53:    aload_0 
L54:    iload 4 
L56:    putfield [63] 
L59:    aload_0 
L60:    aload_0 
L61:    invokevirtual [32] 
L64:    invokevirtual [33] 
L67:    pop 
L68:    aload_0 
L69:    aload_0 
L70:    new [64] 
L73:    dup 
L74:    aload_1 
L75:    aload_0 
L76:    invokespecial [54] 
L79:    dup_x1 
L80:    putfield [65] 
L83:    invokevirtual [33] 
L86:    pop 
L87:    aload_0 
L88:    aload_0 
L89:    invokevirtual [35] 
L92:    invokevirtual [33] 
L95:    pop 
L96:    aload_0 
L97:    invokevirtual [36] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method protected abstract [334] : [335] 
    .attribute [331] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [336] : [337] 
    .attribute [331] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [338] : [339] 
    .attribute [331] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [340] : [341] 
    .attribute [331] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public interface [342] : [343] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [344] : [345] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [37] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [346] : [347] 
    .attribute [331] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [38] 
L12:    aload_0 
L13:    getfield [25] 
L16:    iload_1 
L17:    invokevirtual [39] 
L20:    invokevirtual [40] 
L23:    aload_0 
L24:    iload_1 
L25:    putfield [57] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public interface [348] : [349] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [350] : [351] 
    .attribute [331] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     aload_0 
L9:     invokevirtual [38] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [41] 
L17:    pop 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [58] 
L23:    iload_1 
L24:    ifne L52 
L27:    aload_0 
L28:    getfield [30] 
L31:    ldc [3] 
L33:    ldc [6] 
L35:    aload_0 
L36:    invokevirtual [38] 
L39:    invokevirtual [42] 
L42:    pop 
L43:    aload_0 
L44:    ldc [7] 
L46:    invokevirtual [43] 
L49:    goto L135 
L52:    iload_1 
L53:    iconst_1 
L54:    if_icmpne L96 
L57:    aload_0 
L58:    getfield [30] 
L61:    ldc [3] 
L63:    ldc [8] 
L65:    invokevirtual [44] 
L68:    pop 
L69:    aload_0 
L70:    invokevirtual [45] 
L73:    aload_0 
L74:    getfield [34] 
L77:    if_acmpeq L87 
L80:    aload_0 
L81:    getfield [34] 
L84:    invokevirtual [46] 
L87:    aload_0 
L88:    ldc [9] 
L90:    invokevirtual [43] 
L93:    goto L135 
L96:    iload_1 
L97:    iconst_2 
L98:    if_icmpne L135 
L101:   aload_0 
L102:   getfield [30] 
L105:   ldc [3] 
L107:   ldc [10] 
L109:   invokevirtual [44] 
L112:   pop 
L113:   aload_0 
L114:   getfield [34] 
L117:   invokevirtual [46] 
L120:   aload_0 
L121:   invokevirtual [45] 
L124:   aload_0 
L125:   getfield [34] 
L128:   if_acmpne L135 
L131:   aload_0 
L132:   invokevirtual [47] 
L135:   return 
L136:   
    .end code 
.end method 

.method public [352] : [353] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     iconst_m1 
L5:     if_icmpeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [354] : [355] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [356] : [357] 
    .attribute [331] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [358] : [359] 
    .attribute [331] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     aload_1 
L5:     aload_2 
L6:     invokevirtual [48] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [360] : [361] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     invokevirtual [49] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [362] : [363] 
    .attribute [331] .code stack 3 locals 1 
L0:     new [66] 
L3:     dup 
L4:     invokespecial [55] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [12] 
L11:    invokevirtual [50] 
L14:    aload_0 
L15:    invokevirtual [38] 
L18:    invokevirtual [50] 
L21:    pop 
L22:    aload_1 
L23:    ldc [13] 
L25:    invokevirtual [50] 
L28:    aload_0 
L29:    getfield [25] 
L32:    aload_0 
L33:    getfield [23] 
L36:    invokevirtual [39] 
L39:    invokevirtual [50] 
L42:    pop 
L43:    aload_1 
L44:    ldc [14] 
L46:    invokevirtual [50] 
L49:    pop 
L50:    aload_1 
L51:    aload_0 
L52:    getfield [34] 
L55:    invokevirtual [51] 
L58:    invokevirtual [50] 
L61:    pop 
L62:    aload_1 
L63:    ldc [15] 
L65:    invokevirtual [50] 
L68:    pop 
L69:    aload_1 
L70:    aload_0 
L71:    invokespecial [56] 
L74:    invokevirtual [50] 
L77:    pop 
L78:    aload_1 
L79:    invokevirtual [52] 
L82:    areturn 
L83:    nop 
L84:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [67] 
.const [3] = Int -2137614336 
.const [4] = String [68] 
.const [5] = String [69] 
.const [6] = String [70] 
.const [7] = String [71] 
.const [8] = String [72] 
.const [9] = String [73] 
.const [10] = String [74] 
.const [11] = Class [75] 
.const [12] = String [76] 
.const [13] = String [77] 
.const [14] = String [78] 
.const [15] = String [79] 
.const [16] = Class [80] 
.const [17] = Class [81] 
.const [18] = Class [82] 
.const [19] = Class [83] 
.const [20] = Class [84] 
.const [21] = Class [85] 
.const [22] = Method [86] [87] 
.const [23] = Field [88] [89] 
.const [24] = Field [90] [91] 
.const [25] = Field [92] [93] 
.const [26] = Method [94] [95] 
.const [27] = Field [96] [97] 
.const [28] = Method [98] [99] 
.const [29] = Method [100] [101] 
.const [30] = Field [102] [103] 
.const [31] = Field [104] [105] 
.const [32] = Method [106] [107] 
.const [33] = Method [108] [109] 
.const [34] = Field [110] [111] 
.const [35] = Method [112] [113] 
.const [36] = Method [114] [115] 
.const [37] = Method [116] [117] 
.const [38] = Method [118] [119] 
.const [39] = Method [120] [121] 
.const [40] = Method [122] [123] 
.const [41] = Method [124] [125] 
.const [42] = Method [126] [127] 
.const [43] = Method [128] [129] 
.const [44] = Method [130] [131] 
.const [45] = Method [132] [133] 
.const [46] = Method [134] [135] 
.const [47] = Method [136] [137] 
.const [48] = Method [138] [139] 
.const [49] = Method [140] [141] 
.const [50] = Method [142] [143] 
.const [51] = Method [144] [145] 
.const [52] = Method [146] [147] 
.const [53] = Method [148] [149] 
.const [54] = Method [150] [151] 
.const [55] = Method [152] [153] 
.const [56] = Method [154] [155] 
.const [57] = Field [156] [157] 
.const [58] = Field [158] [159] 
.const [59] = Field [160] [161] 
.const [60] = Field [162] [163] 
.const [61] = Field [164] [165] 
.const [62] = Field [166] [167] 
.const [63] = Field [168] [169] 
.const [64] = Class [170] 
.const [65] = Field [171] [172] 
.const [66] = Class [173] 
.const [67] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [68] = Utf8 '[AbstractFunctionSynchronization#setSyncState] [%1] new state is %2' 
.const [69] = Utf8 '[AbstractFunctionSynchronization#cancel] [%1] reason: %2' 
.const [70] = Utf8 '[AbstractFunctionSynchronization#cancel] [%1] sync is restarted' 
.const [71] = Utf8 'Function sync restarted' 
.const [72] = Utf8 '[AbstractFunctionSynchronization#cancel] sync is aborted -> finish function sync immediately' 
.const [73] = Utf8 'Function sync aborted' 
.const [74] = Utf8 '[AbstractFunctionSynchronization#cancel] sync is completed -> skip update functions' 
.const [75] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [76] = Utf8 'syncType: ' 
.const [77] = Utf8 '\nsyncState: ' 
.const [78] = Utf8 '\nfunctions not updated yet:\n' 
.const [79] = Utf8 '\n' 
.const [80] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [81] = Utf8 de/audi/tghu/command/CommandList 
.const [82] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler 
.const [83] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [84] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Class [174] 
.const [87] = NameAndType [175] [176] 
.const [88] = Class [177] 
.const [89] = NameAndType [178] [179] 
.const [90] = Class [180] 
.const [91] = NameAndType [181] [182] 
.const [92] = Class [183] 
.const [93] = NameAndType [184] [185] 
.const [94] = Class [186] 
.const [95] = NameAndType [187] [188] 
.const [96] = Class [189] 
.const [97] = NameAndType [190] [191] 
.const [98] = Class [192] 
.const [99] = NameAndType [193] [194] 
.const [100] = Class [195] 
.const [101] = NameAndType [196] [197] 
.const [102] = Class [198] 
.const [103] = NameAndType [199] [200] 
.const [104] = Class [201] 
.const [105] = NameAndType [202] [203] 
.const [106] = Class [204] 
.const [107] = NameAndType [205] [206] 
.const [108] = Class [207] 
.const [109] = NameAndType [208] [209] 
.const [110] = Class [210] 
.const [111] = NameAndType [211] [212] 
.const [112] = Class [213] 
.const [113] = NameAndType [214] [215] 
.const [114] = Class [216] 
.const [115] = NameAndType [217] [218] 
.const [116] = Class [219] 
.const [117] = NameAndType [220] [221] 
.const [118] = Class [222] 
.const [119] = NameAndType [223] [224] 
.const [120] = Class [225] 
.const [121] = NameAndType [226] [227] 
.const [122] = Class [228] 
.const [123] = NameAndType [229] [230] 
.const [124] = Class [231] 
.const [125] = NameAndType [232] [233] 
.const [126] = Class [234] 
.const [127] = NameAndType [235] [236] 
.const [128] = Class [237] 
.const [129] = NameAndType [238] [239] 
.const [130] = Class [240] 
.const [131] = NameAndType [241] [242] 
.const [132] = Class [243] 
.const [133] = NameAndType [244] [245] 
.const [134] = Class [246] 
.const [135] = NameAndType [247] [248] 
.const [136] = Class [249] 
.const [137] = NameAndType [250] [251] 
.const [138] = Class [252] 
.const [139] = NameAndType [253] [254] 
.const [140] = Class [255] 
.const [141] = NameAndType [256] [257] 
.const [142] = Class [258] 
.const [143] = NameAndType [259] [260] 
.const [144] = Class [261] 
.const [145] = NameAndType [262] [263] 
.const [146] = Class [264] 
.const [147] = NameAndType [265] [266] 
.const [148] = Class [267] 
.const [149] = NameAndType [268] [269] 
.const [150] = Class [270] 
.const [151] = NameAndType [271] [272] 
.const [152] = Class [273] 
.const [153] = NameAndType [274] [275] 
.const [154] = Class [276] 
.const [155] = NameAndType [277] [278] 
.const [156] = Class [279] 
.const [157] = NameAndType [280] [281] 
.const [158] = Class [282] 
.const [159] = NameAndType [283] [284] 
.const [160] = Class [285] 
.const [161] = NameAndType [286] [287] 
.const [162] = Class [288] 
.const [163] = NameAndType [289] [290] 
.const [164] = Class [291] 
.const [165] = NameAndType [292] [293] 
.const [166] = Class [294] 
.const [167] = NameAndType [295] [296] 
.const [168] = Class [297] 
.const [169] = NameAndType [298] [299] 
.const [170] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [171] = Class [300] 
.const [172] = NameAndType [301] [302] 
.const [173] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [174] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler 
.const [175] = Utf8 getCommandListManager 
.const [176] = Utf8 ()Lde/audi/tghu/command/CommandListManager; 
.const [177] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [178] = Utf8 syncState 
.const [179] = Utf8 I 
.const [180] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [181] = Utf8 cancelReason 
.const [182] = Utf8 I 
.const [183] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [184] = Utf8 fctSyncHandler 
.const [185] = Utf8 Lde/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler; 
.const [186] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [187] = Utf8 getBAPFunctionPropertyFSG 
.const [188] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [189] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [190] = Utf8 fctSyncProperty 
.const [191] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [192] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [193] = Utf8 setIsFunctionSyncProperty 
.const [194] = Utf8 (Z)V 
.const [195] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [196] = Utf8 getLogChannel 
.const [197] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [198] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [199] = Utf8 logChannel 
.const [200] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [201] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [202] = Utf8 syncType 
.const [203] = Utf8 I 
.const [204] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [205] = Utf8 createOpenFunctionSyncCommand 
.const [206] = Utf8 ()Lde/audi/app/combi/bap/functionsync/AbstractCommandOpenFunctionSync; 
.const [207] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [208] = Utf8 add 
.const [209] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [210] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [211] = Utf8 updateFunctionsCommand 
.const [212] = Utf8 Lde/audi/app/combi/bap/functionsync/CommandUpdateFunctions; 
.const [213] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [214] = Utf8 createCloseFunctionSyncCommand 
.const [215] = Utf8 ()Lde/audi/app/combi/bap/functionsync/AbstractCommandCloseFunctionSync; 
.const [216] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [217] = Utf8 addAdditionalCommands 
.const [218] = Utf8 ()V 
.const [219] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [220] = Utf8 addMonitor 
.const [221] = Utf8 (Lde/audi/tghu/command/Monitor;)V 
.const [222] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [223] = Utf8 getSyncTypeDescription 
.const [224] = Utf8 ()Ljava/lang/String; 
.const [225] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler 
.const [226] = Utf8 getSyncStateDescription 
.const [227] = Utf8 (I)Ljava/lang/String; 
.const [228] = Utf8 de/audi/atip/log/LogChannel 
.const [229] = Utf8 log 
.const [230] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [231] = Utf8 de/audi/atip/log/LogChannel 
.const [232] = Utf8 log 
.const [233] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [234] = Utf8 de/audi/atip/log/LogChannel 
.const [235] = Utf8 log 
.const [236] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [237] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [238] = Utf8 stop 
.const [239] = Utf8 (Ljava/lang/String;)V 
.const [240] = Utf8 de/audi/atip/log/LogChannel 
.const [241] = Utf8 log 
.const [242] = Utf8 (ILjava/lang/String;)Z 
.const [243] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [244] = Utf8 getActiveCommand 
.const [245] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [246] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [247] = Utf8 abort 
.const [248] = Utf8 ()V 
.const [249] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [250] = Utf8 commandFinished 
.const [251] = Utf8 ()V 
.const [252] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [253] = Utf8 enqueuePropertyUpdate 
.const [254] = Utf8 (Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/vw/mib/bap/requests/StatusProperty;)Z 
.const [255] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [256] = Utf8 isQueuedPropertiesSent 
.const [257] = Utf8 ()Z 
.const [258] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [259] = Utf8 append 
.const [260] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [261] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [262] = Utf8 logPendingFunctions 
.const [263] = Utf8 ()Ljava/lang/String; 
.const [264] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [265] = Utf8 toString 
.const [266] = Utf8 ()Ljava/lang/String; 
.const [267] = Utf8 de/audi/tghu/command/CommandList 
.const [268] = Utf8 <init> 
.const [269] = Utf8 (Lde/audi/tghu/command/CommandListManager;)V 
.const [270] = Utf8 de/audi/app/combi/bap/functionsync/CommandUpdateFunctions 
.const [271] = Utf8 <init> 
.const [272] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization;)V 
.const [273] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [274] = Utf8 <init> 
.const [275] = Utf8 ()V 
.const [276] = Utf8 de/audi/tghu/command/CommandList 
.const [277] = Utf8 toString 
.const [278] = Utf8 ()Ljava/lang/String; 
.const [279] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [280] = Utf8 syncState 
.const [281] = Utf8 I 
.const [282] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [283] = Utf8 cancelReason 
.const [284] = Utf8 I 
.const [285] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [286] = Utf8 moduleFsg 
.const [287] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [288] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [289] = Utf8 fctSyncHandler 
.const [290] = Utf8 Lde/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler; 
.const [291] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [292] = Utf8 fctSyncProperty 
.const [293] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [294] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [295] = Utf8 logChannel 
.const [296] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [297] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [298] = Utf8 syncType 
.const [299] = Utf8 I 
.const [300] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [301] = Utf8 updateFunctionsCommand 
.const [302] = Utf8 Lde/audi/app/combi/bap/functionsync/CommandUpdateFunctions; 
.const [303] = Utf8 de/audi/app/combi/bap/functionsync/AbstractFunctionSynchronization 
.const [304] = Class [303] 
.const [305] = Utf8 de/audi/tghu/command/CommandList 
.const [306] = Class [305] 
.const [307] = Utf8 SYNC_TYPE_NO_SYNC 
.const [308] = Utf8 I 
.const [309] = Utf8 CANCEL_REASON_RESTART 
.const [310] = Utf8 I 
.const [311] = Utf8 CANCEL_REASON_ABORT 
.const [312] = Utf8 I 
.const [313] = Utf8 CANCEL_REASON_COMPLETE 
.const [314] = Utf8 I 
.const [315] = Utf8 logChannel 
.const [316] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [317] = Utf8 updateFunctionsCommand 
.const [318] = Utf8 Lde/audi/app/combi/bap/functionsync/CommandUpdateFunctions; 
.const [319] = Utf8 moduleFsg 
.const [320] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [321] = Utf8 fctSyncHandler 
.const [322] = Utf8 Lde/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler; 
.const [323] = Utf8 fctSyncProperty 
.const [324] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [325] = Utf8 syncType 
.const [326] = Utf8 I 
.const [327] = Utf8 syncState 
.const [328] = Utf8 I 
.const [329] = Utf8 cancelReason 
.const [330] = Utf8 I 
.const [331] = Utf8 Code 
.const [332] = Utf8 <init> 
.const [333] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/app/combi/bap/functionsync/AbstractFunctionSynchronizationHandler;II)V 
.const [334] = Utf8 addAdditionalCommands 
.const [335] = Utf8 ()V 
.const [336] = Utf8 createOpenFunctionSyncCommand 
.const [337] = Utf8 ()Lde/audi/app/combi/bap/functionsync/AbstractCommandOpenFunctionSync; 
.const [338] = Utf8 createCloseFunctionSyncCommand 
.const [339] = Utf8 ()Lde/audi/app/combi/bap/functionsync/AbstractCommandCloseFunctionSync; 
.const [340] = Utf8 getFunctionsToBeSynchronized 
.const [341] = Utf8 ()[I 
.const [342] = Utf8 getFctSyncProperty 
.const [343] = Utf8 ()Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [344] = Utf8 addEpilogueAction 
.const [345] = Utf8 (Lde/audi/app/combi/bap/functionsync/AbstractFunctionSyncEpilogueAction;)V 
.const [346] = Utf8 setSyncState 
.const [347] = Utf8 (I)V 
.const [348] = Utf8 getSyncState 
.const [349] = Utf8 ()I 
.const [350] = Utf8 cancel 
.const [351] = Utf8 (I)V 
.const [352] = Utf8 isCanceled 
.const [353] = Utf8 ()Z 
.const [354] = Utf8 getSyncType 
.const [355] = Utf8 ()I 
.const [356] = Utf8 getSyncTypeDescription 
.const [357] = Utf8 ()Ljava/lang/String; 
.const [358] = Utf8 enqueuePropertyUpdate 
.const [359] = Utf8 (Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/vw/mib/bap/requests/StatusProperty;)Z 
.const [360] = Utf8 isQueuedPropertiesSent 
.const [361] = Utf8 ()Z 
.const [362] = Utf8 toString 
.const [363] = Utf8 ()Ljava/lang/String; 
.end class 
