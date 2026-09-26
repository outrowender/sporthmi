.version 50 0 
.class public super [205] 
.super [207] 
.field private [208] [209] 
.field private final synthetic [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [44] 
L5:     aload_0 
L6:     aload_2 
L7:     aload_1 
L8:     invokestatic [2] 
L11:    invokespecial [35] 
L14:    aload_0 
L15:    invokespecial [36] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [215] : [216] 
    .attribute [212] .code stack 6 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     bipush 10 
L5:     anewarray [3] 
L8:     putfield [43] 
L11:    aload_0 
L12:    getfield [23] 
L15:    iconst_0 
L16:    new [45] 
L19:    dup 
L20:    iload_1 
L21:    bipush 13 
L23:    invokespecial [37] 
L26:    aastore 
L27:    aload_0 
L28:    getfield [23] 
L31:    iconst_1 
L32:    new [45] 
L35:    dup 
L36:    iload_1 
L37:    bipush 13 
L39:    invokespecial [37] 
L42:    aastore 
L43:    aload_0 
L44:    getfield [23] 
L47:    iconst_2 
L48:    new [45] 
L51:    dup 
L52:    iload_1 
L53:    bipush 10 
L55:    invokespecial [37] 
L58:    aastore 
L59:    aload_0 
L60:    getfield [23] 
L63:    iconst_3 
L64:    new [45] 
L67:    dup 
L68:    iload_1 
L69:    bipush 10 
L71:    invokespecial [37] 
L74:    aastore 
L75:    aload_0 
L76:    getfield [23] 
L79:    iconst_4 
L80:    new [45] 
L83:    dup 
L84:    iload_1 
L85:    bipush 10 
L87:    invokespecial [37] 
L90:    aastore 
L91:    aload_0 
L92:    getfield [23] 
L95:    iconst_5 
L96:    new [45] 
L99:    dup 
L100:   iload_1 
L101:   bipush 10 
L103:   invokespecial [37] 
L106:   aastore 
L107:   aload_0 
L108:   getfield [23] 
L111:   bipush 6 
L113:   new [45] 
L116:   dup 
L117:   iload_1 
L118:   bipush 10 
L120:   invokespecial [37] 
L123:   aastore 
L124:   aload_0 
L125:   getfield [23] 
L128:   bipush 7 
L130:   new [45] 
L133:   dup 
L134:   iload_1 
L135:   bipush 10 
L137:   invokespecial [37] 
L140:   aastore 
L141:   aload_0 
L142:   getfield [23] 
L145:   bipush 8 
L147:   new [45] 
L150:   dup 
L151:   iload_1 
L152:   bipush 10 
L154:   invokespecial [37] 
L157:   aastore 
L158:   aload_0 
L159:   getfield [23] 
L162:   bipush 9 
L164:   new [45] 
L167:   dup 
L168:   iload_1 
L169:   bipush 10 
L171:   invokespecial [37] 
L174:   aastore 
L175:   return 
L176:   
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [212] .code stack 5 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iload_3 
L4:     iload 4 
L6:     invokespecial [38] 
L9:     aload_0 
L10:    getfield [25] 
L13:    ldc [4] 
L15:    ldc [5] 
L17:    iload_2 
L18:    invokevirtual [26] 
L21:    pop 
L22:    iconst_0 
L23:    istore 5 
L25:    iload 5 
L27:    aload_0 
L28:    getfield [23] 
L31:    arraylength 
L32:    if_icmpge L85 
L35:    aload_0 
L36:    getfield [25] 
L39:    ldc [4] 
L41:    ldc [6] 
L43:    invokestatic [7] 
L46:    iload 5 
L48:    aaload 
L49:    invokevirtual [27] 
L52:    pop 
L53:    aload_0 
L54:    iload 5 
L56:    aload_0 
L57:    getfield [23] 
L60:    iload 5 
L62:    aaload 
L63:    invokevirtual [28] 
L66:    aload_0 
L67:    getfield [23] 
L70:    iload 5 
L72:    aaload 
L73:    invokevirtual [29] 
L76:    invokespecial [39] 
L79:    iinc 5 1 
L82:    goto L25 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 5 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [40] 
L5:     aload_0 
L6:     getfield [25] 
L9:     ldc [4] 
L11:    ldc [8] 
L13:    aload_0 
L14:    getfield [30] 
L17:    invokevirtual [26] 
L20:    pop 
L21:    iconst_0 
L22:    istore_2 
L23:    iload_2 
L24:    aload_0 
L25:    getfield [23] 
L28:    arraylength 
L29:    if_icmpge L61 
L32:    aload_0 
L33:    iload_2 
L34:    aload_0 
L35:    getfield [23] 
L38:    iload_2 
L39:    aaload 
L40:    invokevirtual [28] 
L43:    aload_0 
L44:    getfield [23] 
L47:    iload_2 
L48:    aaload 
L49:    invokevirtual [29] 
L52:    invokespecial [39] 
L55:    iinc 2 1 
L58:    goto L23 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [212] .code stack 5 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [41] 
L5:     aload_0 
L6:     getfield [25] 
L9:     ldc [4] 
L11:    ldc [9] 
L13:    aload_0 
L14:    getfield [30] 
L17:    invokevirtual [26] 
L20:    pop 
L21:    iconst_0 
L22:    istore_2 
L23:    iload_2 
L24:    aload_0 
L25:    getfield [23] 
L28:    arraylength 
L29:    if_icmpge L61 
L32:    aload_0 
L33:    iload_2 
L34:    aload_0 
L35:    getfield [23] 
L38:    iload_2 
L39:    aaload 
L40:    invokevirtual [28] 
L43:    aload_0 
L44:    getfield [23] 
L47:    iload_2 
L48:    aaload 
L49:    invokevirtual [29] 
L52:    invokespecial [39] 
L55:    iinc 2 1 
L58:    goto L23 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [212] .code stack 5 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [42] 
L5:     aload_0 
L6:     getfield [25] 
L9:     ldc [4] 
L11:    ldc [10] 
L13:    iload_1 
L14:    invokevirtual [26] 
L17:    pop 
L18:    iconst_0 
L19:    istore_2 
L20:    iload_2 
L21:    aload_0 
L22:    getfield [23] 
L25:    arraylength 
L26:    if_icmpge L58 
L29:    aload_0 
L30:    iload_2 
L31:    aload_0 
L32:    getfield [23] 
L35:    iload_2 
L36:    aaload 
L37:    invokevirtual [28] 
L40:    aload_0 
L41:    getfield [23] 
L44:    iload_2 
L45:    aaload 
L46:    invokevirtual [29] 
L49:    invokespecial [39] 
L52:    iinc 2 1 
L55:    goto L20 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [225] : [226] 
    .attribute [212] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [23] 
L5:     arraylength 
L6:     if_icmpge L19 
L9:     aload_0 
L10:    getfield [23] 
L13:    iload_1 
L14:    aaload 
L15:    iload_2 
L16:    invokevirtual [31] 
L19:    return 
L20:    
    .end code 
.end method 

.method private [227] : [228] 
    .attribute [212] .code stack 8 locals 1 
L0:     aload_0 
L1:     iload_2 
L2:     iload_3 
L3:     invokevirtual [32] 
L6:     istore 4 
L8:     iload_2 
L9:     bipush 13 
L11:    if_icmpne L32 
L14:    aload_0 
L15:    getfield [24] 
L18:    iload 4 
L20:    invokestatic [11] 
L23:    aload_0 
L24:    getfield [24] 
L27:    iload 4 
L29:    invokestatic [12] 
L32:    iload 4 
L34:    aload_0 
L35:    getfield [24] 
L38:    invokestatic [13] 
L41:    iload_1 
L42:    iaload 
L43:    if_icmpne L52 
L46:    iload 4 
L48:    iconst_3 
L49:    if_icmpne L102 
L52:    iload_2 
L53:    bipush 10 
L55:    if_icmpne L102 
L58:    aload_0 
L59:    getfield [25] 
L62:    ldc [14] 
L64:    ldc [15] 
L66:    getstatic [16] 
L69:    iload_3 
L70:    aaload 
L71:    getstatic [16] 
L74:    iload 4 
L76:    aaload 
L77:    getstatic [16] 
L80:    aload_0 
L81:    getfield [24] 
L84:    invokestatic [13] 
L87:    iload_1 
L88:    iaload 
L89:    aaload 
L90:    invokevirtual [33] 
L93:    aload_0 
L94:    getfield [24] 
L97:    iload 4 
L99:    invokestatic [17] 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 

.method static synthetic [229] : [230] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [34] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [231] : [232] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [46] [47] 
.const [3] = Class [48] 
.const [4] = Int 1078071040 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Method [51] [52] 
.const [8] = String [53] 
.const [9] = String [54] 
.const [10] = String [55] 
.const [11] = Method [56] [57] 
.const [12] = Method [58] [59] 
.const [13] = Method [60] [61] 
.const [14] = Int -2137614336 
.const [15] = String [62] 
.const [16] = Field [63] [64] 
.const [17] = Method [65] [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Field [72] [73] 
.const [24] = Field [74] [75] 
.const [25] = Field [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Field [86] [87] 
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
.const [43] = Field [112] [113] 
.const [44] = Field [114] [115] 
.const [45] = Class [116] 
.const [46] = Class [117] 
.const [47] = NameAndType [118] [119] 
.const [48] = Utf8 de/audi/app/car/sdis/base/VisibilityEntry 
.const [49] = Utf8 '[updateClampState] clamp15=%1' 
.const [50] = Utf8 '[updateClampState: call updateVisibilityAfterCarStateChange] =%1' 
.const [51] = Class [120] 
.const [52] = NameAndType [121] [122] 
.const [53] = Utf8 '[exceedsUpperThreshold] =%1' 
.const [54] = Utf8 '[belowLowerThreshold] =%1' 
.const [55] = Utf8 '[updateStandStill] =%1' 
.const [56] = Class [123] 
.const [57] = NameAndType [124] [125] 
.const [58] = Class [126] 
.const [59] = NameAndType [127] [128] 
.const [60] = Class [129] 
.const [61] = NameAndType [130] [131] 
.const [62] = Utf8 'updateVisibilityAfterCarStateChange BC: trigger update to tablet: visib: %1, new: %2,latest: %3' 
.const [63] = Class [132] 
.const [64] = NameAndType [133] [134] 
.const [65] = Class [135] 
.const [66] = NameAndType [136] [137] 
.const [67] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [68] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [69] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 de/audi/app/car/sdis/base/IVisibility 
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
.const [116] = Utf8 de/audi/app/car/sdis/base/VisibilityEntry 
.const [117] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [118] = Utf8 access$200 
.const [119] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent;)Lde/audi/app/car/sdis/base/ISDISFramework; 
.const [120] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [121] = Utf8 access$300 
.const [122] = Utf8 ()[Ljava/lang/String; 
.const [123] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [124] = Utf8 access$400 
.const [125] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent;I)V 
.const [126] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [127] = Utf8 access$500 
.const [128] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent;I)V 
.const [129] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [130] = Utf8 access$600 
.const [131] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent;)[I 
.const [132] = Utf8 de/audi/app/car/sdis/base/IVisibility 
.const [133] = Utf8 TEXT_TO_STATE 
.const [134] = Utf8 [Ljava/lang/String; 
.const [135] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent 
.const [136] = Utf8 access$700 
.const [137] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent;I)V 
.const [138] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [139] = Utf8 visibilityEntryStructure 
.const [140] = Utf8 [Lde/audi/app/car/sdis/base/VisibilityEntry; 
.const [141] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [142] = Utf8 this$0 
.const [143] = Utf8 Lde/audi/app/car/sdis/comp/CarKombiComponent; 
.const [144] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [145] = Utf8 logger 
.const [146] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;Z)Z 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [153] = Utf8 de/audi/app/car/sdis/base/VisibilityEntry 
.const [154] = Utf8 getCoding 
.const [155] = Utf8 ()S 
.const [156] = Utf8 de/audi/app/car/sdis/base/VisibilityEntry 
.const [157] = Utf8 getVisibility 
.const [158] = Utf8 ()I 
.const [159] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [160] = Utf8 isUnderVThr 
.const [161] = Utf8 Z 
.const [162] = Utf8 de/audi/app/car/sdis/base/VisibilityEntry 
.const [163] = Utf8 setVisibility 
.const [164] = Utf8 (I)V 
.const [165] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [166] = Utf8 updateMenuEntryVisibility 
.const [167] = Utf8 (SI)I 
.const [168] = Utf8 de/audi/atip/log/LogChannel 
.const [169] = Utf8 log 
.const [170] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [171] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [172] = Utf8 setVisibilityState 
.const [173] = Utf8 (II)V 
.const [174] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/car/sdis/base/ISDISFramework;)V 
.const [177] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [178] = Utf8 init 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/audi/app/car/sdis/base/VisibilityEntry 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (IS)V 
.const [183] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [184] = Utf8 updateClampState 
.const [185] = Utf8 (ZZZZ)V 
.const [186] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [187] = Utf8 updateVisibilityAfterCarStateChange 
.const [188] = Utf8 (ISI)V 
.const [189] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [190] = Utf8 exceedsUpperThreshold 
.const [191] = Utf8 (I)V 
.const [192] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [193] = Utf8 belowLowerThreshold 
.const [194] = Utf8 (I)V 
.const [195] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [196] = Utf8 updateStandStill 
.const [197] = Utf8 (Z)V 
.const [198] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [199] = Utf8 visibilityEntryStructure 
.const [200] = Utf8 [Lde/audi/app/car/sdis/base/VisibilityEntry; 
.const [201] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [202] = Utf8 this$0 
.const [203] = Utf8 Lde/audi/app/car/sdis/comp/CarKombiComponent; 
.const [204] = Utf8 de/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler 
.const [205] = Class [204] 
.const [206] = Utf8 de/audi/app/car/sdis/base/AbstractCarStateHandler 
.const [207] = Class [206] 
.const [208] = Utf8 visibilityEntryStructure 
.const [209] = Utf8 [Lde/audi/app/car/sdis/base/VisibilityEntry; 
.const [210] = Utf8 this$0 
.const [211] = Utf8 Lde/audi/app/car/sdis/comp/CarKombiComponent; 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent;Lde/audi/atip/log/LogChannel;)V 
.const [215] = Utf8 init 
.const [216] = Utf8 ()V 
.const [217] = Utf8 updateClampState 
.const [218] = Utf8 (ZZZZ)V 
.const [219] = Utf8 exceedsUpperThreshold 
.const [220] = Utf8 (I)V 
.const [221] = Utf8 belowLowerThreshold 
.const [222] = Utf8 (I)V 
.const [223] = Utf8 updateStandStill 
.const [224] = Utf8 (Z)V 
.const [225] = Utf8 setVisibilityState 
.const [226] = Utf8 (II)V 
.const [227] = Utf8 updateVisibilityAfterCarStateChange 
.const [228] = Utf8 (ISI)V 
.const [229] = Utf8 access$000 
.const [230] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler;II)V 
.const [231] = Utf8 access$100 
.const [232] = Utf8 (Lde/audi/app/car/sdis/comp/CarKombiComponent$CarStateHandler;)[Lde/audi/app/car/sdis/base/VisibilityEntry; 
.end class 
