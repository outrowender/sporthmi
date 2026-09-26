.version 50 0 
.class public super [293] 
.super [295] 
.field private [296] [297] 
.field private [298] [299] 
.field private [300] [301] 
.field static synthetic [302] [303] 

.method public [305] : [306] 
    .attribute [304] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [57] 
L5:     aload_0 
L6:     aload_1 
L7:     putfield [62] 
L10:    aload_0 
L11:    iload_2 
L12:    putfield [63] 
L15:    aload_0 
L16:    iload_3 
L17:    putfield [64] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [307] : [308] 
    .attribute [304] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_0 
L13:    getfield [38] 
L16:    lconst_0 
L17:    iconst_4 
L18:    iconst_1 
L19:    iconst_1 
L20:    invokevirtual [39] 
L23:    istore_1 
L24:    iload_1 
L25:    ifne L50 
L28:    aload_0 
L29:    getfield [36] 
L32:    sipush 10000 
L35:    ldc [7] 
L37:    invokevirtual [37] 
L40:    pop 
L41:    aload_0 
L42:    getfield [40] 
L45:    invokeinterface [65] 0 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [309] : [310] 
    .attribute [304] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [5] 
L6:     ldc [8] 
L8:     iload_1 
L9:     invokestatic [9] 
L12:    iload_3 
L13:    invokestatic [10] 
L16:    aload_0 
L17:    getfield [34] 
L20:    invokestatic [11] 
L23:    invokevirtual [41] 
L26:    aload_0 
L27:    getfield [36] 
L30:    invokevirtual [42] 
L33:    ifeq L70 
L36:    aload_0 
L37:    getfield [36] 
L40:    ldc [12] 
L42:    ldc [13] 
L44:    aload_2 
L45:    iload_1 
L46:    invokestatic [9] 
L49:    iload_3 
L50:    i2l 
L51:    invokevirtual [43] 
L54:    aload_0 
L55:    getfield [36] 
L58:    ldc [12] 
L60:    ldc [14] 
L62:    aload_2 
L63:    invokestatic [15] 
L66:    invokevirtual [44] 
L69:    pop 
L70:    iload_1 
L71:    ifne L168 
L74:    aload_0 
L75:    getfield [33] 
L78:    invokevirtual [45] 
L81:    invokevirtual [46] 
L84:    istore 4 
L86:    aload_0 
L87:    getfield [34] 
L90:    ifeq L131 
L93:    iload 4 
L95:    iload_3 
L96:    if_icmpne L106 
L99:    aload_0 
L100:   getfield [35] 
L103:   ifeq L131 
L106:   aload_0 
L107:   getfield [33] 
L110:   invokevirtual [45] 
L113:   iload_3 
L114:   invokevirtual [47] 
L117:   aload_0 
L118:   getfield [33] 
L121:   invokevirtual [48] 
L124:   iload_3 
L125:   invokevirtual [49] 
L128:   goto L168 
L131:   aload_0 
L132:   getfield [33] 
L135:   invokevirtual [45] 
L138:   invokevirtual [50] 
L141:   iconst_1 
L142:   if_icmpne L168 
L145:   aload_0 
L146:   getfield [33] 
L149:   invokevirtual [48] 
L152:   iconst_1 
L153:   iload_3 
L154:   invokevirtual [51] 
L157:   aload_0 
L158:   getfield [33] 
L161:   invokevirtual [48] 
L164:   iload_3 
L165:   invokevirtual [49] 
L168:   aload_0 
L169:   getfield [40] 
L172:   invokeinterface [65] 0 
L177:   return 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method public static [311] : [312] 
    .attribute [304] .code stack 5 locals 2 
L0:     new [66] 
L3:     dup 
L4:     aload_0 
L5:     iload_1 
L6:     iload_2 
L7:     invokespecial [58] 
L10:    astore_3 
L11:    new [67] 
L14:    dup 
L15:    aload_0 
L16:    invokevirtual [52] 
L19:    invokespecial [59] 
L22:    astore 4 
L24:    aload 4 
L26:    aload_3 
L27:    invokevirtual [53] 
L30:    pop 
L31:    aload 4 
L33:    getstatic [18] 
L36:    ifnonnull L51 
L39:    ldc [19] 
L41:    invokestatic [20] 
L44:    dup 
L45:    putstatic [60] 
L48:    goto L54 
L51:    getstatic [18] 
L54:    invokevirtual [54] 
L57:    invokevirtual [55] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method static synthetic [313] : [314] 
    .attribute [304] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [61] 
L9:     dup 
L10:    invokespecial [56] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [68] [69] 
.const [3] = Class [70] 
.const [4] = Class [71] 
.const [5] = Int 1078071040 
.const [6] = String [72] 
.const [7] = String [73] 
.const [8] = String [74] 
.const [9] = Method [75] [76] 
.const [10] = Method [77] [78] 
.const [11] = Method [79] [80] 
.const [12] = Int -2137614336 
.const [13] = String [81] 
.const [14] = String [82] 
.const [15] = Method [83] [84] 
.const [16] = Class [85] 
.const [17] = Class [86] 
.const [18] = Field [87] [88] 
.const [19] = String [89] 
.const [20] = Method [90] [91] 
.const [21] = Class [92] 
.const [22] = Class [93] 
.const [23] = Class [94] 
.const [24] = Class [95] 
.const [25] = Class [96] 
.const [26] = Class [97] 
.const [27] = Class [98] 
.const [28] = Class [99] 
.const [29] = Class [100] 
.const [30] = Class [101] 
.const [31] = Class [102] 
.const [32] = Method [103] [104] 
.const [33] = Field [105] [106] 
.const [34] = Field [107] [108] 
.const [35] = Field [109] [110] 
.const [36] = Field [111] [112] 
.const [37] = Method [113] [114] 
.const [38] = Field [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Field [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Method [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Method [131] [132] 
.const [47] = Method [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Method [139] [140] 
.const [51] = Method [141] [142] 
.const [52] = Method [143] [144] 
.const [53] = Method [145] [146] 
.const [54] = Method [147] [148] 
.const [55] = Method [149] [150] 
.const [56] = Method [151] [152] 
.const [57] = Method [153] [154] 
.const [58] = Method [155] [156] 
.const [59] = Method [157] [158] 
.const [60] = Field [159] [160] 
.const [61] = Class [161] 
.const [62] = Field [162] [163] 
.const [63] = Field [164] [165] 
.const [64] = Field [166] [167] 
.const [65] = InterfaceMethod [168] [169] 
.const [66] = Class [170] 
.const [67] = Class [171] 
.const [68] = Class [172] 
.const [69] = NameAndType [173] [174] 
.const [70] = Utf8 java/lang/ClassNotFoundException 
.const [71] = Utf8 java/lang/NoClassDefFoundError 
.const [72] = Utf8 'GetCombiViewSizeCommand#execute()' 
.const [73] = Utf8 'GetCombiViewSizeCommand#execute(): dsi call was not successful, finishing command.' 
.const [74] = Utf8 'GetCombiViewSizeCommand#getViewWindowResult(): success: %1, totalEntries: %2, sendPhonebookChanged:%3 ' 
.const [75] = Class [175] 
.const [76] = NameAndType [176] [177] 
.const [77] = Class [178] 
.const [78] = NameAndType [179] [180] 
.const [79] = Class [181] 
.const [80] = NameAndType [182] [183] 
.const [81] = Utf8 'GetCombiViewSizeCommand#getViewWindowResult(): dataSetList: %1, success: %2; totalEntries: %3' 
.const [82] = Utf8 'GetCombiViewSizeCommand#getViewWindowResult(): dataSetList: %1' 
.const [83] = Class [184] 
.const [84] = NameAndType [185] [186] 
.const [85] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [86] = Utf8 de/audi/tghu/command/CommandList 
.const [87] = Class [187] 
.const [88] = NameAndType [188] [189] 
.const [89] = Utf8 'de.audi.app.addressbook.core.combi.bap.commands.GetCombiViewSizeCommand' 
.const [90] = Class [190] 
.const [91] = NameAndType [191] [192] 
.const [92] = Utf8 de/audi/app/addressbook/core/common/commands/AbstractADBCommand 
.const [93] = Utf8 java/lang/Class 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 de/audi/app/addressbook/core/common/commands/ADBDSIAccess 
.const [96] = Utf8 de/audi/tghu/command/ICommandList 
.const [97] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [98] = Utf8 java/lang/Integer 
.const [99] = Utf8 java/lang/Boolean 
.const [100] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [101] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [102] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler 
.const [103] = Class [193] 
.const [104] = NameAndType [194] [195] 
.const [105] = Class [196] 
.const [106] = NameAndType [197] [198] 
.const [107] = Class [199] 
.const [108] = NameAndType [200] [201] 
.const [109] = Class [202] 
.const [110] = NameAndType [203] [204] 
.const [111] = Class [205] 
.const [112] = NameAndType [206] [207] 
.const [113] = Class [208] 
.const [114] = NameAndType [209] [210] 
.const [115] = Class [211] 
.const [116] = NameAndType [212] [213] 
.const [117] = Class [214] 
.const [118] = NameAndType [215] [216] 
.const [119] = Class [217] 
.const [120] = NameAndType [218] [219] 
.const [121] = Class [220] 
.const [122] = NameAndType [221] [222] 
.const [123] = Class [223] 
.const [124] = NameAndType [224] [225] 
.const [125] = Class [226] 
.const [126] = NameAndType [227] [228] 
.const [127] = Class [229] 
.const [128] = NameAndType [230] [231] 
.const [129] = Class [232] 
.const [130] = NameAndType [233] [234] 
.const [131] = Class [235] 
.const [132] = NameAndType [236] [237] 
.const [133] = Class [238] 
.const [134] = NameAndType [239] [240] 
.const [135] = Class [241] 
.const [136] = NameAndType [242] [243] 
.const [137] = Class [244] 
.const [138] = NameAndType [245] [246] 
.const [139] = Class [247] 
.const [140] = NameAndType [248] [249] 
.const [141] = Class [250] 
.const [142] = NameAndType [251] [252] 
.const [143] = Class [253] 
.const [144] = NameAndType [254] [255] 
.const [145] = Class [256] 
.const [146] = NameAndType [257] [258] 
.const [147] = Class [259] 
.const [148] = NameAndType [260] [261] 
.const [149] = Class [262] 
.const [150] = NameAndType [263] [264] 
.const [151] = Class [265] 
.const [152] = NameAndType [266] [267] 
.const [153] = Class [268] 
.const [154] = NameAndType [269] [270] 
.const [155] = Class [271] 
.const [156] = NameAndType [272] [273] 
.const [157] = Class [274] 
.const [158] = NameAndType [275] [276] 
.const [159] = Class [277] 
.const [160] = NameAndType [278] [279] 
.const [161] = Utf8 java/lang/NoClassDefFoundError 
.const [162] = Class [280] 
.const [163] = NameAndType [281] [282] 
.const [164] = Class [283] 
.const [165] = NameAndType [284] [285] 
.const [166] = Class [286] 
.const [167] = NameAndType [287] [288] 
.const [168] = Class [289] 
.const [169] = NameAndType [290] [291] 
.const [170] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [171] = Utf8 de/audi/tghu/command/CommandList 
.const [172] = Utf8 java/lang/Class 
.const [173] = Utf8 forName 
.const [174] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [175] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [176] = Utf8 dbgSuccessFlag 
.const [177] = Utf8 (I)Ljava/lang/String; 
.const [178] = Utf8 java/lang/Integer 
.const [179] = Utf8 toString 
.const [180] = Utf8 (I)Ljava/lang/String; 
.const [181] = Utf8 java/lang/Boolean 
.const [182] = Utf8 toString 
.const [183] = Utf8 (Z)Ljava/lang/String; 
.const [184] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [185] = Utf8 dbg 
.const [186] = Utf8 ([Lorg/dsi/ifc/organizer/DataSet;)Ljava/lang/String; 
.const [187] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [188] = Utf8 class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand 
.const [189] = Utf8 Ljava/lang/Class; 
.const [190] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [191] = Utf8 class$ 
.const [192] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [193] = Utf8 java/lang/NoClassDefFoundError 
.const [194] = Utf8 initCause 
.const [195] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [196] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [197] = Utf8 adbHandler 
.const [198] = Utf8 Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler; 
.const [199] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [200] = Utf8 sendPhonebookChanged 
.const [201] = Utf8 Z 
.const [202] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [203] = Utf8 sortOrderChanged 
.const [204] = Utf8 Z 
.const [205] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [206] = Utf8 logger 
.const [207] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [208] = Utf8 de/audi/atip/log/LogChannel 
.const [209] = Utf8 log 
.const [210] = Utf8 (ILjava/lang/String;)Z 
.const [211] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [212] = Utf8 adbDSIAccess 
.const [213] = Utf8 Lde/audi/app/addressbook/core/common/commands/ADBDSIAccess; 
.const [214] = Utf8 de/audi/app/addressbook/core/common/commands/ADBDSIAccess 
.const [215] = Utf8 getViewWindow 
.const [216] = Utf8 (JIII)Z 
.const [217] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [218] = Utf8 commandList 
.const [219] = Utf8 Lde/audi/tghu/command/ICommandList; 
.const [220] = Utf8 de/audi/atip/log/LogChannel 
.const [221] = Utf8 log 
.const [222] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [223] = Utf8 de/audi/atip/log/LogChannel 
.const [224] = Utf8 isDebug 
.const [225] = Utf8 ()Z 
.const [226] = Utf8 de/audi/atip/log/LogChannel 
.const [227] = Utf8 log 
.const [228] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [229] = Utf8 de/audi/atip/log/LogChannel 
.const [230] = Utf8 log 
.const [231] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [232] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [233] = Utf8 getStateHandler 
.const [234] = Utf8 ()Lde/audi/app/addressbook/core/combi/bap/CombiADBStateHandler; 
.const [235] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [236] = Utf8 getEntryCount 
.const [237] = Utf8 ()I 
.const [238] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [239] = Utf8 setEntryCount 
.const [240] = Utf8 (I)V 
.const [241] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [242] = Utf8 getCombiService 
.const [243] = Utf8 ()Lde/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler; 
.const [244] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler 
.const [245] = Utf8 phonebookChanged 
.const [246] = Utf8 (I)V 
.const [247] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [248] = Utf8 computePbState 
.const [249] = Utf8 ()I 
.const [250] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler 
.const [251] = Utf8 updatePbState 
.const [252] = Utf8 (II)V 
.const [253] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [254] = Utf8 getCommandListManager 
.const [255] = Utf8 ()Lde/audi/tghu/command/CommandListManager; 
.const [256] = Utf8 de/audi/tghu/command/CommandList 
.const [257] = Utf8 add 
.const [258] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [259] = Utf8 java/lang/Class 
.const [260] = Utf8 getName 
.const [261] = Utf8 ()Ljava/lang/String; 
.const [262] = Utf8 de/audi/tghu/command/CommandList 
.const [263] = Utf8 execute 
.const [264] = Utf8 (Ljava/lang/String;)V 
.const [265] = Utf8 java/lang/NoClassDefFoundError 
.const [266] = Utf8 <init> 
.const [267] = Utf8 ()V 
.const [268] = Utf8 de/audi/app/addressbook/core/common/commands/AbstractADBCommand 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Lde/audi/app/addressbook/core/common/ADBApplication;)V 
.const [271] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [272] = Utf8 <init> 
.const [273] = Utf8 (Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler;ZZ)V 
.const [274] = Utf8 de/audi/tghu/command/CommandList 
.const [275] = Utf8 <init> 
.const [276] = Utf8 (Lde/audi/tghu/command/CommandListManager;)V 
.const [277] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [278] = Utf8 class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand 
.const [279] = Utf8 Ljava/lang/Class; 
.const [280] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [281] = Utf8 adbHandler 
.const [282] = Utf8 Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler; 
.const [283] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [284] = Utf8 sendPhonebookChanged 
.const [285] = Utf8 Z 
.const [286] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [287] = Utf8 sortOrderChanged 
.const [288] = Utf8 Z 
.const [289] = Utf8 de/audi/tghu/command/ICommandList 
.const [290] = Utf8 commandFinished 
.const [291] = Utf8 ()V 
.const [292] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [293] = Class [292] 
.const [294] = Utf8 de/audi/app/addressbook/core/common/commands/AbstractADBCommand 
.const [295] = Class [294] 
.const [296] = Utf8 adbHandler 
.const [297] = Utf8 Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler; 
.const [298] = Utf8 sendPhonebookChanged 
.const [299] = Utf8 Z 
.const [300] = Utf8 sortOrderChanged 
.const [301] = Utf8 Z 
.const [302] = Utf8 class$de$audi$app$addressbook$core$combi$bap$commands$GetCombiViewSizeCommand 
.const [303] = Utf8 Ljava/lang/Class; 
.const [304] = Utf8 Code 
.const [305] = Utf8 <init> 
.const [306] = Utf8 (Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler;ZZ)V 
.const [307] = Utf8 execute 
.const [308] = Utf8 ()V 
.const [309] = Utf8 getViewWindowResult 
.const [310] = Utf8 (I[Lorg/dsi/ifc/organizer/DataSet;I)V 
.const [311] = Utf8 createGetCombiViewSizeCommand 
.const [312] = Utf8 (Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler;ZZ)V 
.const [313] = Utf8 class$ 
.const [314] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
