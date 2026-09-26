.version 50 0 
.class public super [238] 
.super [240] 
.field private [241] [242] 
.field private [243] [244] 
.field private [245] [246] 
.field private [247] [248] 
.field private [249] [250] 
.field private [251] [252] 
.field private [253] [254] 
.field private [255] [256] 
.field private [257] [258] 

.method public [260] : [261] 
    .attribute [259] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [39] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [40] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [41] 
L19:    aload_0 
L20:    iconst_m1 
L21:    putfield [42] 
L24:    aload_0 
L25:    iconst_m1 
L26:    putfield [43] 
L29:    aload_0 
L30:    aload_1 
L31:    putfield [44] 
L34:    aload_0 
L35:    aload_1 
L36:    invokevirtual [23] 
L39:    putfield [45] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [259] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [39] 
L5:     aload_0 
L6:     invokevirtual [25] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [264] : [265] 
    .attribute [259] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [266] : [267] 
    .attribute [259] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     if_icmpeq L22 
L8:     aload_0 
L9:     iload_1 
L10:    putfield [40] 
L13:    aload_0 
L14:    getfield [22] 
L17:    iconst_0 
L18:    iconst_0 
L19:    invokestatic [2] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [268] : [269] 
    .attribute [259] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [41] 
L5:     aload_0 
L6:     invokevirtual [25] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [270] : [271] 
    .attribute [259] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [272] : [273] 
    .attribute [259] .code stack 6 locals 1 
L0:     aload_0 
L1:     invokevirtual [26] 
L4:     istore_1 
L5:     iload_1 
L6:     aload_0 
L7:     getfield [20] 
L10:    if_icmpne L24 
L13:    aload_0 
L14:    getfield [19] 
L17:    aload_0 
L18:    getfield [21] 
L21:    if_icmpeq L73 
L24:    aload_0 
L25:    getfield [24] 
L28:    ldc [3] 
L30:    ldc [4] 
L32:    iload_1 
L33:    invokestatic [5] 
L36:    aload_0 
L37:    getfield [19] 
L40:    i2l 
L41:    invokevirtual [27] 
L44:    pop 
L45:    aload_0 
L46:    getfield [22] 
L49:    invokevirtual [28] 
L52:    iload_1 
L53:    aload_0 
L54:    getfield [19] 
L57:    invokevirtual [29] 
L60:    aload_0 
L61:    iload_1 
L62:    putfield [42] 
L65:    aload_0 
L66:    aload_0 
L67:    getfield [19] 
L70:    putfield [43] 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [274] : [275] 
    .attribute [259] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [18] 
L13:    ifeq L25 
L16:    aload_0 
L17:    getfield [19] 
L20:    ifne L25 
L23:    iconst_1 
L24:    areturn 
L25:    iconst_2 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [276] : [277] 
    .attribute [259] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [3] 
L6:     ldc [6] 
L8:     aload_1 
L9:     invokevirtual [30] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [46] 
L18:    aload_0 
L19:    invokevirtual [32] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [259] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     aload_1 
L9:     invokevirtual [30] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [47] 
L18:    aload_0 
L19:    invokevirtual [32] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [280] : [281] 
    .attribute [259] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    aload_0 
L13:    getfield [31] 
L16:    ifnull L35 
L19:    aload_0 
L20:    getfield [31] 
L23:    iconst_0 
L24:    putfield [48] 
L27:    aload_0 
L28:    getfield [31] 
L31:    iconst_m1 
L32:    putfield [49] 
L35:    aload_0 
L36:    getfield [33] 
L39:    ifnull L58 
L42:    aload_0 
L43:    getfield [33] 
L46:    iconst_0 
L47:    putfield [48] 
L50:    aload_0 
L51:    getfield [33] 
L54:    iconst_m1 
L55:    putfield [49] 
L58:    aload_0 
L59:    invokevirtual [32] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [259] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifnonnull L11 
L7:     iconst_0 
L8:     goto L18 
L11:    aload_0 
L12:    getfield [31] 
L15:    getfield [35] 
L18:    istore_1 
L19:    aload_0 
L20:    getfield [33] 
L23:    ifnonnull L30 
L26:    iconst_0 
L27:    goto L37 
L30:    aload_0 
L31:    getfield [33] 
L34:    getfield [35] 
L37:    istore_2 
L38:    iconst_m1 
L39:    istore_3 
L40:    aload_0 
L41:    getfield [31] 
L44:    ifnull L58 
L47:    aload_0 
L48:    getfield [31] 
L51:    getfield [36] 
L54:    iconst_m1 
L55:    if_icmpne L76 
L58:    aload_0 
L59:    getfield [33] 
L62:    ifnull L138 
L65:    aload_0 
L66:    getfield [33] 
L69:    getfield [36] 
L72:    iconst_m1 
L73:    if_icmpeq L138 
L76:    aload_0 
L77:    getfield [31] 
L80:    ifnull L104 
L83:    aload_0 
L84:    getfield [31] 
L87:    getfield [36] 
L90:    iconst_m1 
L91:    if_icmpeq L104 
L94:    aload_0 
L95:    getfield [31] 
L98:    getfield [36] 
L101:   goto L105 
L104:   iconst_0 
L105:   istore_3 
L106:   iload_3 
L107:   aload_0 
L108:   getfield [33] 
L111:   ifnull L135 
L114:   aload_0 
L115:   getfield [33] 
L118:   getfield [36] 
L121:   iconst_m1 
L122:   if_icmpeq L135 
L125:   aload_0 
L126:   getfield [33] 
L129:   getfield [36] 
L132:   goto L136 
L135:   iconst_0 
L136:   iadd 
L137:   istore_3 
L138:   aload_0 
L139:   getfield [22] 
L142:   invokevirtual [28] 
L145:   aload_0 
L146:   invokevirtual [26] 
L149:   iconst_m1 
L150:   iload_3 
L151:   iload_1 
L152:   iload_2 
L153:   iadd 
L154:   invokevirtual [37] 
L157:   return 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [50] [51] 
.const [3] = Int 1078071040 
.const [4] = String [52] 
.const [5] = Method [53] [54] 
.const [6] = String [55] 
.const [7] = String [56] 
.const [8] = String [57] 
.const [9] = Class [58] 
.const [10] = Class [59] 
.const [11] = Class [60] 
.const [12] = Class [61] 
.const [13] = Class [62] 
.const [14] = Class [63] 
.const [15] = Class [64] 
.const [16] = Class [65] 
.const [17] = Field [66] [67] 
.const [18] = Field [68] [69] 
.const [19] = Field [70] [71] 
.const [20] = Field [72] [73] 
.const [21] = Field [74] [75] 
.const [22] = Field [76] [77] 
.const [23] = Method [78] [79] 
.const [24] = Field [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Field [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Field [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = Field [112] [113] 
.const [41] = Field [114] [115] 
.const [42] = Field [116] [117] 
.const [43] = Field [118] [119] 
.const [44] = Field [120] [121] 
.const [45] = Field [122] [123] 
.const [46] = Field [124] [125] 
.const [47] = Field [126] [127] 
.const [48] = Field [128] [129] 
.const [49] = Field [130] [131] 
.const [50] = Class [132] 
.const [51] = NameAndType [133] [134] 
.const [52] = Utf8 'CombiADBStateHandler#updateCombiPbState(): pbState: %1, entryCount: %2' 
.const [53] = Class [135] 
.const [54] = NameAndType [136] [137] 
.const [55] = Utf8 'CombiADBStateHandler#updateDownloadCountMe(): downloadCountMe: %1' 
.const [56] = Utf8 'CombiADBStateHandler#updateDownloadCountSim(): downloadCountSim: %1' 
.const [57] = Utf8 'CombiADBStateHandler#resetDownloadProgress()' 
.const [58] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [61] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [62] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler 
.const [65] = Utf8 org/dsi/ifc/organizer/DownloadInfo 
.const [66] = Class [138] 
.const [67] = NameAndType [139] [140] 
.const [68] = Class [141] 
.const [69] = NameAndType [142] [143] 
.const [70] = Class [144] 
.const [71] = NameAndType [145] [146] 
.const [72] = Class [147] 
.const [73] = NameAndType [148] [149] 
.const [74] = Class [150] 
.const [75] = NameAndType [151] [152] 
.const [76] = Class [153] 
.const [77] = NameAndType [154] [155] 
.const [78] = Class [156] 
.const [79] = NameAndType [157] [158] 
.const [80] = Class [159] 
.const [81] = NameAndType [160] [161] 
.const [82] = Class [162] 
.const [83] = NameAndType [163] [164] 
.const [84] = Class [165] 
.const [85] = NameAndType [166] [167] 
.const [86] = Class [168] 
.const [87] = NameAndType [169] [170] 
.const [88] = Class [171] 
.const [89] = NameAndType [172] [173] 
.const [90] = Class [174] 
.const [91] = NameAndType [175] [176] 
.const [92] = Class [177] 
.const [93] = NameAndType [178] [179] 
.const [94] = Class [180] 
.const [95] = NameAndType [181] [182] 
.const [96] = Class [183] 
.const [97] = NameAndType [184] [185] 
.const [98] = Class [186] 
.const [99] = NameAndType [187] [188] 
.const [100] = Class [189] 
.const [101] = NameAndType [190] [191] 
.const [102] = Class [192] 
.const [103] = NameAndType [193] [194] 
.const [104] = Class [195] 
.const [105] = NameAndType [196] [197] 
.const [106] = Class [198] 
.const [107] = NameAndType [199] [200] 
.const [108] = Class [201] 
.const [109] = NameAndType [202] [203] 
.const [110] = Class [204] 
.const [111] = NameAndType [205] [206] 
.const [112] = Class [207] 
.const [113] = NameAndType [208] [209] 
.const [114] = Class [210] 
.const [115] = NameAndType [211] [212] 
.const [116] = Class [213] 
.const [117] = NameAndType [214] [215] 
.const [118] = Class [216] 
.const [119] = NameAndType [217] [218] 
.const [120] = Class [219] 
.const [121] = NameAndType [220] [221] 
.const [122] = Class [222] 
.const [123] = NameAndType [223] [224] 
.const [124] = Class [225] 
.const [125] = NameAndType [226] [227] 
.const [126] = Class [228] 
.const [127] = NameAndType [229] [230] 
.const [128] = Class [231] 
.const [129] = NameAndType [232] [233] 
.const [130] = Class [234] 
.const [131] = NameAndType [235] [236] 
.const [132] = Utf8 de/audi/app/addressbook/core/combi/bap/commands/GetCombiViewSizeCommand 
.const [133] = Utf8 createGetCombiViewSizeCommand 
.const [134] = Utf8 (Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler;ZZ)V 
.const [135] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [136] = Utf8 dbgCombiPbState 
.const [137] = Utf8 (I)Ljava/lang/String; 
.const [138] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [139] = Utf8 adbReady 
.const [140] = Utf8 Z 
.const [141] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [142] = Utf8 downloadActive 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [145] = Utf8 entryCount 
.const [146] = Utf8 I 
.const [147] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [148] = Utf8 lastPbState 
.const [149] = Utf8 I 
.const [150] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [151] = Utf8 lastEntryCount 
.const [152] = Utf8 I 
.const [153] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [154] = Utf8 adbHandler 
.const [155] = Utf8 Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler; 
.const [156] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [157] = Utf8 getLog 
.const [158] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [159] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [160] = Utf8 log 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [163] = Utf8 updateCombiPbState 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [166] = Utf8 computePbState 
.const [167] = Utf8 ()I 
.const [168] = Utf8 de/audi/atip/log/LogChannel 
.const [169] = Utf8 log 
.const [170] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [171] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBHandler 
.const [172] = Utf8 getCombiService 
.const [173] = Utf8 ()Lde/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler; 
.const [174] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler 
.const [175] = Utf8 updatePbState 
.const [176] = Utf8 (II)V 
.const [177] = Utf8 de/audi/atip/log/LogChannel 
.const [178] = Utf8 log 
.const [179] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [180] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [181] = Utf8 downloadCountMe 
.const [182] = Utf8 Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [183] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [184] = Utf8 updateCombiDownloadProgress 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [187] = Utf8 downloadCountSim 
.const [188] = Utf8 Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;)Z 
.const [192] = Utf8 org/dsi/ifc/organizer/DownloadInfo 
.const [193] = Utf8 count 
.const [194] = Utf8 I 
.const [195] = Utf8 org/dsi/ifc/organizer/DownloadInfo 
.const [196] = Utf8 numberOfItems 
.const [197] = Utf8 I 
.const [198] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiBAPServiceHandler 
.const [199] = Utf8 updatePhonebookDownloadProgress 
.const [200] = Utf8 (IIII)V 
.const [201] = Utf8 java/lang/Object 
.const [202] = Utf8 <init> 
.const [203] = Utf8 ()V 
.const [204] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [205] = Utf8 adbReady 
.const [206] = Utf8 Z 
.const [207] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [208] = Utf8 downloadActive 
.const [209] = Utf8 Z 
.const [210] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [211] = Utf8 entryCount 
.const [212] = Utf8 I 
.const [213] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [214] = Utf8 lastPbState 
.const [215] = Utf8 I 
.const [216] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [217] = Utf8 lastEntryCount 
.const [218] = Utf8 I 
.const [219] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [220] = Utf8 adbHandler 
.const [221] = Utf8 Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler; 
.const [222] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [223] = Utf8 log 
.const [224] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [225] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [226] = Utf8 downloadCountMe 
.const [227] = Utf8 Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [228] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [229] = Utf8 downloadCountSim 
.const [230] = Utf8 Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [231] = Utf8 org/dsi/ifc/organizer/DownloadInfo 
.const [232] = Utf8 count 
.const [233] = Utf8 I 
.const [234] = Utf8 org/dsi/ifc/organizer/DownloadInfo 
.const [235] = Utf8 numberOfItems 
.const [236] = Utf8 I 
.const [237] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBStateHandler 
.const [238] = Class [237] 
.const [239] = Utf8 java/lang/Object 
.const [240] = Class [239] 
.const [241] = Utf8 adbHandler 
.const [242] = Utf8 Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler; 
.const [243] = Utf8 log 
.const [244] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [245] = Utf8 adbReady 
.const [246] = Utf8 Z 
.const [247] = Utf8 downloadActive 
.const [248] = Utf8 Z 
.const [249] = Utf8 entryCount 
.const [250] = Utf8 I 
.const [251] = Utf8 downloadCountMe 
.const [252] = Utf8 Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [253] = Utf8 downloadCountSim 
.const [254] = Utf8 Lorg/dsi/ifc/organizer/DownloadInfo; 
.const [255] = Utf8 lastPbState 
.const [256] = Utf8 I 
.const [257] = Utf8 lastEntryCount 
.const [258] = Utf8 I 
.const [259] = Utf8 Code 
.const [260] = Utf8 <init> 
.const [261] = Utf8 (Lde/audi/app/addressbook/core/combi/bap/CombiADBHandler;)V 
.const [262] = Utf8 setAdbReady 
.const [263] = Utf8 (Z)V 
.const [264] = Utf8 isAdbReady 
.const [265] = Utf8 ()Z 
.const [266] = Utf8 setDownloadActive 
.const [267] = Utf8 (Z)V 
.const [268] = Utf8 setEntryCount 
.const [269] = Utf8 (I)V 
.const [270] = Utf8 getEntryCount 
.const [271] = Utf8 ()I 
.const [272] = Utf8 updateCombiPbState 
.const [273] = Utf8 ()V 
.const [274] = Utf8 computePbState 
.const [275] = Utf8 ()I 
.const [276] = Utf8 updateDownloadCountMe 
.const [277] = Utf8 (Lorg/dsi/ifc/organizer/DownloadInfo;)V 
.const [278] = Utf8 updateDownloadCountSim 
.const [279] = Utf8 (Lorg/dsi/ifc/organizer/DownloadInfo;)V 
.const [280] = Utf8 resetDownloadProgress 
.const [281] = Utf8 ()V 
.const [282] = Utf8 updateCombiDownloadProgress 
.const [283] = Utf8 ()V 
.end class 
