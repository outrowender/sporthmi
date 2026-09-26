.version 50 0 
.class public super [216] 
.super [218] 
.field private final [219] [220] 
.field private volatile [221] [222] 

.method public [224] : [225] 
    .attribute [223] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [39] 
L7:     aload_0 
L8:     new [44] 
L11:    dup 
L12:    invokespecial [40] 
L15:    putfield [45] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [223] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [41] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [228] : [229] 
    .attribute [223] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     checkcast [4] 
L7:     invokevirtual [24] 
L10:    iload_1 
L11:    ifeq L18 
L14:    iconst_0 
L15:    goto L19 
L18:    iconst_1 
L19:    iload_2 
L20:    iload_3 
L21:    iload 4 
L23:    invokeinterface [46] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [223] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [223] .code stack 6 locals 5 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_0 
L9:     getfield [26] 
L12:    aload_1 
L13:    arraylength 
L14:    i2l 
L15:    invokevirtual [27] 
L18:    pop 
L19:    aload_0 
L20:    getfield [23] 
L23:    invokevirtual [28] 
L26:    invokeinterface [47] 0 
L31:    ifeq L66 
L34:    aload_0 
L35:    getfield [23] 
L38:    invokevirtual [28] 
L41:    invokeinterface [47] 0 
L46:    iconst_2 
L47:    if_icmpeq L66 
L50:    aload_0 
L51:    getfield [23] 
L54:    invokevirtual [28] 
L57:    invokeinterface [47] 0 
L62:    iconst_5 
L63:    if_icmpne L70 
L66:    iconst_1 
L67:    goto L71 
L70:    iconst_0 
L71:    istore_2 
L72:    aload_0 
L73:    invokevirtual [29] 
L76:    aload_1 
L77:    invokestatic [7] 
L80:    astore_3 
L81:    iload_2 
L82:    ifeq L177 
L85:    aload_0 
L86:    getfield [25] 
L89:    ldc [5] 
L91:    ldc [8] 
L93:    aload_0 
L94:    getfield [26] 
L97:    aload_0 
L98:    getfield [23] 
L101:   invokevirtual [28] 
L104:   invokeinterface [47] 0 
L109:   i2l 
L110:   invokevirtual [27] 
L113:   pop 
L114:   aload_0 
L115:   getfield [22] 
L118:   dup 
L119:   astore 4 
L121:   monitorenter 
        .catch [0] from L122 to L163 using L166 
L122:   aload_3 
L123:   invokevirtual [30] 
L126:   ifeq L136 
L129:   aload_0 
L130:   getfield [31] 
L133:   ifnull L160 
L136:   aload_0 
L137:   aload_1 
L138:   putfield [48] 
L141:   aload_0 
L142:   getfield [25] 
L145:   ldc [5] 
L147:   ldc [9] 
L149:   aload_0 
L150:   getfield [26] 
L153:   aload_0 
L154:   invokespecial [42] 
L157:   invokevirtual [32] 
L160:   aload 4 
L162:   monitorexit 
L163:   goto L174 
        .catch [0] from L166 to L171 using L166 
L166:   astore 5 
L168:   aload 4 
L170:   monitorexit 
L171:   aload 5 
L173:   athrow 
L174:   goto L215 
L177:   aload_0 
L178:   getfield [22] 
L181:   dup 
L182:   astore 4 
L184:   monitorenter 
        .catch [0] from L185 to L198 using L201 
L185:   aload_0 
L186:   aload_1 
L187:   putfield [49] 
L190:   aload_0 
L191:   aconst_null 
L192:   putfield [48] 
L195:   aload 4 
L197:   monitorexit 
L198:   goto L209 
        .catch [0] from L201 to L206 using L201 
L201:   astore 6 
L203:   aload 4 
L205:   monitorexit 
L206:   aload 6 
L208:   athrow 
L209:   aload_0 
L210:   aload_3 
L211:   invokevirtual [33] 
L214:   pop 
L215:   return 
L216:   
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [223] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [5] 
L6:     ldc [10] 
L8:     aload_0 
L9:     getfield [26] 
L12:    iload_1 
L13:    invokestatic [11] 
L16:    invokevirtual [32] 
L19:    aload_0 
L20:    getfield [22] 
L23:    dup 
L24:    astore_2 
L25:    monitorenter 
        .catch [0] from L26 to L64 using L125 
L26:    aload_0 
L27:    getfield [31] 
L30:    ifnonnull L65 
L33:    aload_0 
L34:    getfield [25] 
L37:    ldc [5] 
L39:    ldc [12] 
L41:    aload_0 
L42:    getfield [26] 
L45:    invokevirtual [34] 
L48:    pop 
L49:    iload_1 
L50:    ifeq L61 
L53:    aload_0 
L54:    invokevirtual [35] 
L57:    pop 
L58:    goto L121 
L61:    iconst_0 
L62:    aload_2 
L63:    monitorexit 
L64:    areturn 
        .catch [0] from L65 to L124 using L125 
L65:    iload_1 
L66:    ifeq L90 
L69:    aload_0 
L70:    aload_0 
L71:    getfield [31] 
L74:    putfield [49] 
L77:    aload_0 
L78:    aconst_null 
L79:    putfield [48] 
L82:    aload_0 
L83:    invokevirtual [35] 
L86:    pop 
L87:    goto L121 
L90:    aload_0 
L91:    invokevirtual [29] 
L94:    aload_0 
L95:    getfield [31] 
L98:    invokestatic [7] 
L101:   astore_3 
L102:   aload_0 
L103:   aload_0 
L104:   getfield [31] 
L107:   putfield [49] 
L110:   aload_0 
L111:   aconst_null 
L112:   putfield [48] 
L115:   aload_0 
L116:   aload_3 
L117:   invokevirtual [33] 
L120:   pop 
L121:   iconst_1 
L122:   aload_2 
L123:   monitorexit 
L124:   areturn 
        .catch [0] from L125 to L129 using L125 
L125:   astore 4 
L127:   aload_2 
L128:   monitorexit 
L129:   aload 4 
L131:   athrow 
L132:   
    .end code 
.end method 

.method private [236] : [237] 
    .attribute [223] .code stack 3 locals 2 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [43] 
L7:     astore_1 
L8:     iconst_0 
L9:     istore_2 
L10:    iload_2 
L11:    aload_0 
L12:    getfield [31] 
L15:    arraylength 
L16:    if_icmpge L43 
L19:    aload_1 
L20:    aload_0 
L21:    getfield [31] 
L24:    iload_2 
L25:    aaload 
L26:    invokevirtual [36] 
L29:    pop 
L30:    aload_1 
L31:    bipush 10 
L33:    invokevirtual [37] 
L36:    pop 
L37:    iinc 2 1 
L40:    goto L10 
L43:    aload_1 
L44:    invokevirtual [38] 
L47:    areturn 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [51] 
.const [3] = Class [52] 
.const [4] = Class [53] 
.const [5] = Int -2137614336 
.const [6] = String [54] 
.const [7] = Method [55] [56] 
.const [8] = String [57] 
.const [9] = String [58] 
.const [10] = String [59] 
.const [11] = Method [60] [61] 
.const [12] = String [62] 
.const [13] = Class [63] 
.const [14] = Class [64] 
.const [15] = Class [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Class [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Field [72] [73] 
.const [23] = Field [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Field [78] [79] 
.const [26] = Field [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Field [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Class [116] 
.const [45] = Field [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = InterfaceMethod [121] [122] 
.const [48] = Field [123] [124] 
.const [49] = Field [125] [126] 
.const [50] = Class [127] 
.const [51] = Utf8 RadioTVPresetListHandler 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/audi/app/combi/bap/app/audio/CombiModuleAudio 
.const [54] = Utf8 '[%1#updateList] presetListSize=%2' 
.const [55] = Class [128] 
.const [56] = NameAndType [129] [130] 
.const [57] = Utf8 '[%1#updateList] function sync %2 is opened' 
.const [58] = Utf8 '[%1#updateList] source change in progress, request deferred. New list:\n%2' 
.const [59] = Utf8 '[%1#updateDeferredList] forceFullRangeUpdate=%2' 
.const [60] = Class [131] 
.const [61] = NameAndType [132] [133] 
.const [62] = Utf8 '[%1#updateDeferredList] no deferred updates' 
.const [63] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [64] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [65] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [66] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceTuner 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [69] = Utf8 de/audi/app/bap/fw/functionsync/IFunctionSynchronizationHandler 
.const [70] = Utf8 de/audi/app/bap/fw/arrays/ListDelta 
.const [71] = Utf8 java/lang/Boolean 
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
.const [116] = Utf8 java/lang/Object 
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
.const [127] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [128] = Utf8 de/audi/app/bap/fw/arrays/ListDelta 
.const [129] = Utf8 compare 
.const [130] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)Lde/audi/app/bap/fw/arrays/ListDelta; 
.const [131] = Utf8 java/lang/Boolean 
.const [132] = Utf8 valueOf 
.const [133] = Utf8 (Z)Ljava/lang/Boolean; 
.const [134] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [135] = Utf8 mutex 
.const [136] = Utf8 Ljava/lang/Object; 
.const [137] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [138] = Utf8 moduleFsg 
.const [139] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [140] = Utf8 de/audi/app/combi/bap/app/audio/CombiModuleAudio 
.const [141] = Utf8 getTunerService 
.const [142] = Utf8 ()Lde/audi/atip/interapp/combi/bap/audio/CombiBAPServiceTuner; 
.const [143] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [144] = Utf8 logChannel 
.const [145] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [146] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [147] = Utf8 className 
.const [148] = Utf8 Ljava/lang/String; 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [152] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [153] = Utf8 getFunctionSynchronizationHandler 
.const [154] = Utf8 ()Lde/audi/app/bap/fw/functionsync/IFunctionSynchronizationHandler; 
.const [155] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [156] = Utf8 getManagedList 
.const [157] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [158] = Utf8 de/audi/app/bap/fw/arrays/ListDelta 
.const [159] = Utf8 isUnchanged 
.const [160] = Utf8 ()Z 
.const [161] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [162] = Utf8 deferredNewList 
.const [163] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [164] = Utf8 de/audi/atip/log/LogChannel 
.const [165] = Utf8 log 
.const [166] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [167] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [168] = Utf8 sendChangedArrayRequest 
.const [169] = Utf8 (Lde/audi/app/bap/fw/arrays/ListDelta;)Z 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [173] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [174] = Utf8 sendFullRangeUpdate 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [177] = Utf8 append 
.const [178] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [179] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [180] = Utf8 append 
.const [181] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [182] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [183] = Utf8 toString 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [188] = Utf8 java/lang/Object 
.const [189] = Utf8 <init> 
.const [190] = Utf8 ()V 
.const [191] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [192] = Utf8 getNextListPosForArbitraryIds 
.const [193] = Utf8 (II)V 
.const [194] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [195] = Utf8 deferredListToString 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [198] = Utf8 <init> 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [201] = Utf8 mutex 
.const [202] = Utf8 Ljava/lang/Object; 
.const [203] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceTuner 
.const [204] = Utf8 getNextListPosResult 
.const [205] = Utf8 (IIII)V 
.const [206] = Utf8 de/audi/app/bap/fw/functionsync/IFunctionSynchronizationHandler 
.const [207] = Utf8 getCurrentSyncType 
.const [208] = Utf8 ()I 
.const [209] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [210] = Utf8 deferredNewList 
.const [211] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [212] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [213] = Utf8 list 
.const [214] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [215] = Utf8 de/audi/app/combi/bap/app/audio/list/RadioTVPresetListHandler 
.const [216] = Class [215] 
.const [217] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [218] = Class [217] 
.const [219] = Utf8 mutex 
.const [220] = Utf8 Ljava/lang/Object; 
.const [221] = Utf8 deferredNewList 
.const [222] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [223] = Utf8 Code 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (Lde/audi/app/combi/bap/app/audio/CombiModuleAudio;)V 
.const [226] = Utf8 getNextListPos 
.const [227] = Utf8 (II)V 
.const [228] = Utf8 getNextListPosResult 
.const [229] = Utf8 (ZIII)V 
.const [230] = Utf8 getIndexSize 
.const [231] = Utf8 ()I 
.const [232] = Utf8 updateList 
.const [233] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [234] = Utf8 updateDeferredList 
.const [235] = Utf8 (Z)Z 
.const [236] = Utf8 deferredListToString 
.const [237] = Utf8 ()Ljava/lang/String; 
.end class 
