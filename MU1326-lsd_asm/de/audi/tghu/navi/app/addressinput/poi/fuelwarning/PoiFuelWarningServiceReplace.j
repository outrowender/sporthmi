.version 50 0 
.class public super [525] 
.super [527] 
.implements [529] 
.implements [531] 
.field private static final [532] [533] 
.field private static final [534] [535] 
.field private static final [536] [537] 
.field private static final [538] [539] 
.field private static final [540] [541] 
.field private static final [542] [543] 
.field private static final [544] [545] 
.field private static final [546] [547] 
.field private final [548] [549] 
.field private final [550] [551] 
.field private final [552] [553] 
.field private final [554] [555] 
.field private final [556] [557] 
.field private final [558] [559] 
.field private [560] [561] 
.field private [562] [563] 
.field private [564] [565] 
.field private [566] [567] 
.field private [568] [569] 
.field private [570] [571] 
.field private [572] [573] 

.method public [575] : [576] 
    .attribute [574] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [89] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [96] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [97] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [98] 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [99] 
L24:    aload_0 
L25:    bipush 101 
L27:    putfield [100] 
L30:    aload_0 
L31:    aload_1 
L32:    putfield [101] 
L35:    aload_0 
L36:    aload_1 
L37:    invokevirtual [60] 
L40:    putfield [102] 
L43:    aload_0 
L44:    aload_2 
L45:    putfield [103] 
L48:    aload_0 
L49:    aload_3 
L50:    putfield [104] 
L53:    aload_0 
L54:    aload 4 
L56:    putfield [105] 
L59:    aload_0 
L60:    aload 5 
L62:    putfield [106] 
L65:    aload_0 
L66:    aload 6 
L68:    putfield [107] 
L71:    aload_0 
L72:    new [108] 
L75:    dup 
L76:    aload_0 
L77:    getfield [59] 
L80:    aload_0 
L81:    getfield [61] 
L84:    aload_0 
L85:    invokespecial [90] 
L88:    putfield [109] 
L91:    aload_0 
L92:    invokespecial [91] 
L95:    return 
L96:    
    .end code 
.end method 

.method public [577] : [578] 
    .attribute [574] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [61] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [54] 
L12:    invokevirtual [68] 
L15:    pop 
L16:    aload_0 
L17:    getfield [59] 
L20:    invokevirtual [69] 
L23:    invokeinterface [110] 0 
L28:    ifne L44 
L31:    aload_0 
L32:    getfield [61] 
L35:    ldc [5] 
L37:    ldc [6] 
L39:    invokevirtual [70] 
L42:    pop 
L43:    return 
L44:    aload_0 
L45:    getfield [65] 
L48:    invokevirtual [71] 
L51:    ifne L67 
L54:    aload_0 
L55:    getfield [61] 
L58:    ldc [5] 
L60:    ldc [7] 
L62:    invokevirtual [70] 
L65:    pop 
L66:    return 
L67:    aload_0 
L68:    getfield [66] 
L71:    invokevirtual [72] 
L74:    ifne L90 
L77:    aload_0 
L78:    getfield [61] 
L81:    ldc [5] 
L83:    ldc [8] 
L85:    invokevirtual [70] 
L88:    pop 
L89:    return 
L90:    invokestatic [9] 
L93:    ifeq L109 
L96:    aload_0 
L97:    getfield [61] 
L100:   ldc [5] 
L102:   ldc [10] 
L104:   invokevirtual [70] 
L107:   pop 
L108:   return 
L109:   aload_0 
L110:   getfield [54] 
L113:   ifeq L163 
L116:   aload_0 
L117:   getfield [55] 
L120:   iconst_2 
L121:   if_icmpne L150 
L124:   aload_0 
L125:   getfield [62] 
L128:   invokeinterface [111] 0 
L133:   iconst_3 
L134:   if_icmpne L150 
L137:   aload_0 
L138:   getfield [61] 
L141:   ldc [11] 
L143:   ldc [12] 
L145:   invokevirtual [70] 
L148:   pop 
L149:   return 
L150:   aload_0 
L151:   aload_0 
L152:   getfield [55] 
L155:   invokespecial [92] 
L158:   aload_0 
L159:   iconst_0 
L160:   putfield [96] 
L163:   return 
L164:   
    .end code 
.end method 

.method public [579] : [580] 
    .attribute [574] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [61] 
L4:     ldc [5] 
L6:     ldc [13] 
L8:     aload_1 
L9:     invokevirtual [73] 
L12:    pop 
L13:    iconst_1 
L14:    istore_2 
L15:    iconst_0 
L16:    istore_3 
L17:    aload_0 
L18:    getfield [56] 
L21:    aload_1 
L22:    invokevirtual [74] 
L25:    if_icmpeq L65 
L28:    aload_1 
L29:    invokevirtual [74] 
L32:    ifeq L65 
L35:    iconst_1 
L36:    istore_3 
L37:    aload_0 
L38:    getfield [57] 
L41:    aload_1 
L42:    invokevirtual [75] 
L45:    if_icmpeq L60 
L48:    aload_1 
L49:    invokevirtual [75] 
L52:    ifeq L60 
L55:    iconst_3 
L56:    istore_2 
L57:    goto L87 
L60:    iconst_1 
L61:    istore_2 
L62:    goto L87 
L65:    aload_0 
L66:    getfield [57] 
L69:    aload_1 
L70:    invokevirtual [75] 
L73:    if_icmpeq L87 
L76:    aload_1 
L77:    invokevirtual [75] 
L80:    ifeq L87 
L83:    iconst_1 
L84:    istore_3 
L85:    iconst_2 
L86:    istore_2 
L87:    aload_0 
L88:    aload_1 
L89:    invokevirtual [74] 
L92:    putfield [98] 
L95:    aload_0 
L96:    aload_1 
L97:    invokevirtual [75] 
L100:   putfield [99] 
L103:   iload_3 
L104:   ifeq L141 
L107:   aload_0 
L108:   getfield [61] 
L111:   ldc [3] 
L113:   ldc [14] 
L115:   iload_2 
L116:   i2l 
L117:   invokevirtual [76] 
L120:   pop 
L121:   aload_0 
L122:   getfield [67] 
L125:   invokevirtual [77] 
L128:   aload_0 
L129:   iconst_1 
L130:   putfield [96] 
L133:   aload_0 
L134:   iload_2 
L135:   putfield [97] 
L138:   goto L157 
L141:   aload_0 
L142:   getfield [67] 
L145:   invokevirtual [78] 
L148:   aload_0 
L149:   getfield [63] 
L152:   invokeinterface [112] 0 
L157:   return 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method public interface [581] : [582] 
    .attribute [574] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [58] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [583] : [584] 
    .attribute [574] .code stack 4 locals 2 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [93] 
L5:     istore_2 
L6:     aload_0 
L7:     aload_0 
L8:     getfield [64] 
L11:    invokeinterface [113] 0 
L16:    iload_2 
L17:    invokespecial [94] 
L20:    istore_3 
L21:    aload_0 
L22:    getfield [61] 
L25:    ldc [3] 
L27:    ldc [15] 
L29:    iload_3 
L30:    invokevirtual [68] 
L33:    pop 
L34:    aload_0 
L35:    iload_2 
L36:    putfield [100] 
L39:    iload_3 
L40:    ifne L53 
L43:    aload_0 
L44:    getfield [63] 
L47:    iload_2 
L48:    invokeinterface [114] 0 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [585] : [586] 
    .attribute [574] .code stack 2 locals 4 
L0:     aload_0 
L1:     getfield [59] 
L4:     invokevirtual [79] 
L7:     invokevirtual [80] 
L10:    ifne L15 
L13:    iconst_0 
L14:    areturn 
L15:    aload_1 
L16:    invokestatic [16] 
L19:    ifgt L24 
L22:    iconst_0 
L23:    areturn 
L24:    aload_1 
L25:    invokevirtual [81] 
L28:    astore_3 
L29:    aload_1 
L30:    invokevirtual [82] 
L33:    l2i 
L34:    istore 4 
L36:    iload 4 
L38:    aload_3 
L39:    arraylength 
L40:    if_icmpge L86 
L43:    aload_3 
L44:    iload 4 
L46:    aaload 
L47:    invokevirtual [83] 
L50:    astore 5 
L52:    aload 5 
L54:    invokestatic [17] 
L57:    invokeinterface [115] 0 
L62:    istore 6 
L64:    iload 6 
L66:    bipush 56 
L68:    if_icmpeq L78 
L71:    iload 6 
L73:    bipush 101 
L75:    if_icmpne L80 
L78:    iconst_1 
L79:    areturn 
L80:    iinc 4 1 
L83:    goto L36 
L86:    iconst_0 
L87:    areturn 
L88:    
    .end code 
.end method 

.method public static [587] : [588] 
    .attribute [574] .code stack 2 locals 1 
L0:     aload_0 
L1:     iload_2 
L2:     invokestatic [18] 
L5:     astore_3 
L6:     aload_1 
L7:     aload_3 
L8:     invokestatic [19] 
L11:    return 
L12:    
    .end code 
.end method 

.method private [589] : [590] 
    .attribute [574] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [61] 
L4:     ldc [11] 
L6:     ldc [20] 
L8:     invokevirtual [70] 
L11:    pop 
L12:    aload_0 
L13:    getfield [62] 
L16:    invokeinterface [116] 0 
L21:    istore_2 
L22:    iload_1 
L23:    iconst_2 
L24:    if_icmpeq L32 
L27:    iload_1 
L28:    iconst_3 
L29:    if_icmpne L42 
L32:    aload_0 
L33:    getfield [62] 
L36:    invokeinterface [111] 0 
L41:    istore_2 
L42:    aload_0 
L43:    iload_2 
L44:    invokespecial [95] 
L47:    areturn 
L48:    
    .end code 
.end method 

.method private [591] : [592] 
    .attribute [574] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [61] 
L4:     ldc [11] 
L6:     ldc [21] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [76] 
L13:    pop 
L14:    bipush 101 
L16:    istore_2 
L17:    iload_1 
L18:    iconst_3 
L19:    if_icmpne L29 
L22:    sipush 134 
L25:    istore_2 
L26:    goto L132 
L29:    iload_1 
L30:    iconst_2 
L31:    if_icmpne L51 
L34:    aload_0 
L35:    getfield [61] 
L38:    ldc [11] 
L40:    ldc [22] 
L42:    iload_1 
L43:    i2l 
L44:    invokevirtual [76] 
L47:    pop 
L48:    goto L132 
L51:    iload_1 
L52:    bipush 8 
L54:    if_icmpne L64 
L57:    sipush 135 
L60:    istore_2 
L61:    goto L132 
L64:    iload_1 
L65:    bipush 9 
L67:    if_icmpne L77 
L70:    sipush 136 
L73:    istore_2 
L74:    goto L132 
L77:    iload_1 
L78:    iconst_1 
L79:    if_icmpne L88 
L82:    bipush 101 
L84:    istore_2 
L85:    goto L132 
L88:    iload_1 
L89:    bipush 6 
L91:    if_icmpne L106 
L94:    invokestatic [23] 
L97:    ifeq L132 
L100:   bipush 121 
L102:   istore_2 
L103:   goto L132 
L106:   iload_1 
L107:   bipush 7 
L109:   if_icmpne L118 
L112:   bipush 101 
L114:   istore_2 
L115:   goto L132 
L118:   aload_0 
L119:   getfield [61] 
L122:   ldc [11] 
L124:   ldc [24] 
L126:   iload_1 
L127:   i2l 
L128:   invokevirtual [76] 
L131:   pop 
L132:   aload_0 
L133:   getfield [61] 
L136:   ldc [11] 
L138:   ldc [25] 
L140:   iload_1 
L141:   i2l 
L142:   iload_2 
L143:   i2l 
L144:   invokevirtual [84] 
L147:   pop 
L148:   iload_2 
L149:   areturn 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method private static [593] : [594] 
    .attribute [574] .code stack 6 locals 1 
L0:     aload_0 
L1:     ldc [11] 
L3:     ldc [26] 
L5:     iload_1 
L6:     i2l 
L7:     invokevirtual [76] 
L10:    pop 
L11:    ldc [27] 
L13:    astore_2 
L14:    iload_1 
L15:    bipush 101 
L17:    if_icmpne L26 
L20:    ldc [27] 
L22:    astore_2 
L23:    goto L88 
L26:    iload_1 
L27:    sipush 134 
L30:    if_icmpne L39 
L33:    ldc [28] 
L35:    astore_2 
L36:    goto L88 
L39:    iload_1 
L40:    sipush 135 
L43:    if_icmpne L52 
L46:    ldc [29] 
L48:    astore_2 
L49:    goto L88 
L52:    iload_1 
L53:    sipush 136 
L56:    if_icmpne L65 
L59:    ldc [30] 
L61:    astore_2 
L62:    goto L88 
L65:    iload_1 
L66:    bipush 121 
L68:    if_icmpne L77 
L71:    ldc [31] 
L73:    astore_2 
L74:    goto L88 
L77:    aload_0 
L78:    ldc [11] 
L80:    ldc [32] 
L82:    iload_1 
L83:    i2l 
L84:    invokevirtual [76] 
L87:    pop 
L88:    aload_0 
L89:    ldc [11] 
L91:    ldc [33] 
L93:    aload_2 
L94:    iload_1 
L95:    i2l 
L96:    invokevirtual [85] 
L99:    pop 
L100:   aload_2 
L101:   areturn 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [595] : [596] 
    .attribute [574] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [61] 
L4:     invokevirtual [86] 
L7:     ifeq L22 
L10:    aload_0 
L11:    getfield [61] 
L14:    ldc [34] 
L16:    ldc [35] 
L18:    invokevirtual [70] 
L21:    pop 
L22:    aload_0 
L23:    getfield [65] 
L26:    invokevirtual [71] 
L29:    ifne L36 
L32:    iconst_1 
L33:    goto L37 
L36:    iconst_0 
L37:    istore_1 
L38:    aload_0 
L39:    getfield [65] 
L42:    iload_1 
L43:    iconst_1 
L44:    invokevirtual [87] 
L47:    aload_0 
L48:    getfield [63] 
L51:    iload_1 
L52:    invokeinterface [117] 0 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [597] : [598] 
    .attribute [574] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [61] 
L4:     invokevirtual [86] 
L7:     ifeq L22 
L10:    aload_0 
L11:    getfield [61] 
L14:    ldc [34] 
L16:    ldc [36] 
L18:    invokevirtual [70] 
L21:    pop 
L22:    aload_0 
L23:    getfield [65] 
L26:    invokevirtual [71] 
L29:    istore_1 
L30:    aload_0 
L31:    getfield [63] 
L34:    iload_1 
L35:    invokeinterface [117] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [599] : [600] 
    .attribute [574] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [65] 
L4:     invokevirtual [88] 
L7:     aload_0 
L8:     invokespecial [91] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [601] : [602] 
    .attribute [574] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [63] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [63] 
L11:    invokeinterface [118] 0 
L16:    aload_0 
L17:    getfield [67] 
L20:    ifnull L30 
L23:    aload_0 
L24:    getfield [67] 
L27:    invokevirtual [78] 
L30:    aload_0 
L31:    aconst_null 
L32:    putfield [107] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [603] : [604] 
    .attribute [574] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [63] 
L4:     invokeinterface [119] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [605] : [606] 
    .attribute [574] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [63] 
L4:     iload_1 
L5:     invokeinterface [120] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [121] 
.const [3] = Int -1601830656 
.const [4] = String [122] 
.const [5] = Int -2137614336 
.const [6] = String [123] 
.const [7] = String [124] 
.const [8] = String [125] 
.const [9] = Method [126] [127] 
.const [10] = String [128] 
.const [11] = Int 1078071040 
.const [12] = String [129] 
.const [13] = String [130] 
.const [14] = String [131] 
.const [15] = String [132] 
.const [16] = Method [133] [134] 
.const [17] = Method [135] [136] 
.const [18] = Method [137] [138] 
.const [19] = Method [139] [140] 
.const [20] = String [141] 
.const [21] = String [142] 
.const [22] = String [143] 
.const [23] = Method [144] [145] 
.const [24] = String [146] 
.const [25] = String [147] 
.const [26] = String [148] 
.const [27] = String [149] 
.const [28] = String [150] 
.const [29] = String [151] 
.const [30] = String [152] 
.const [31] = String [153] 
.const [32] = String [154] 
.const [33] = String [155] 
.const [34] = Int 14808325 
.const [35] = String [156] 
.const [36] = String [157] 
.const [37] = Class [158] 
.const [38] = Class [159] 
.const [39] = Class [160] 
.const [40] = Class [161] 
.const [41] = Class [162] 
.const [42] = Class [163] 
.const [43] = Class [164] 
.const [44] = Class [165] 
.const [45] = Class [166] 
.const [46] = Class [167] 
.const [47] = Class [168] 
.const [48] = Class [169] 
.const [49] = Class [170] 
.const [50] = Class [171] 
.const [51] = Class [172] 
.const [52] = Class [173] 
.const [53] = Class [174] 
.const [54] = Field [175] [176] 
.const [55] = Field [177] [178] 
.const [56] = Field [179] [180] 
.const [57] = Field [181] [182] 
.const [58] = Field [183] [184] 
.const [59] = Field [185] [186] 
.const [60] = Method [187] [188] 
.const [61] = Field [189] [190] 
.const [62] = Field [191] [192] 
.const [63] = Field [193] [194] 
.const [64] = Field [195] [196] 
.const [65] = Field [197] [198] 
.const [66] = Field [199] [200] 
.const [67] = Field [201] [202] 
.const [68] = Method [203] [204] 
.const [69] = Method [205] [206] 
.const [70] = Method [207] [208] 
.const [71] = Method [209] [210] 
.const [72] = Method [211] [212] 
.const [73] = Method [213] [214] 
.const [74] = Method [215] [216] 
.const [75] = Method [217] [218] 
.const [76] = Method [219] [220] 
.const [77] = Method [221] [222] 
.const [78] = Method [223] [224] 
.const [79] = Method [225] [226] 
.const [80] = Method [227] [228] 
.const [81] = Method [229] [230] 
.const [82] = Method [231] [232] 
.const [83] = Method [233] [234] 
.const [84] = Method [235] [236] 
.const [85] = Method [237] [238] 
.const [86] = Method [239] [240] 
.const [87] = Method [241] [242] 
.const [88] = Method [243] [244] 
.const [89] = Method [245] [246] 
.const [90] = Method [247] [248] 
.const [91] = Method [249] [250] 
.const [92] = Method [251] [252] 
.const [93] = Method [253] [254] 
.const [94] = Method [255] [256] 
.const [95] = Method [257] [258] 
.const [96] = Field [259] [260] 
.const [97] = Field [261] [262] 
.const [98] = Field [263] [264] 
.const [99] = Field [265] [266] 
.const [100] = Field [267] [268] 
.const [101] = Field [269] [270] 
.const [102] = Field [271] [272] 
.const [103] = Field [273] [274] 
.const [104] = Field [275] [276] 
.const [105] = Field [277] [278] 
.const [106] = Field [279] [280] 
.const [107] = Field [281] [282] 
.const [108] = Class [283] 
.const [109] = Field [284] [285] 
.const [110] = InterfaceMethod [286] [287] 
.const [111] = InterfaceMethod [288] [289] 
.const [112] = InterfaceMethod [290] [291] 
.const [113] = InterfaceMethod [292] [293] 
.const [114] = InterfaceMethod [294] [295] 
.const [115] = InterfaceMethod [296] [297] 
.const [116] = InterfaceMethod [298] [299] 
.const [117] = InterfaceMethod [300] [301] 
.const [118] = InterfaceMethod [302] [303] 
.const [119] = InterfaceMethod [304] [305] 
.const [120] = InterfaceMethod [306] [307] 
.const [121] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer 
.const [122] = Utf8 'PoiFuelWarningServiceReplace#checkPendingEvents() - pendingFuelWarning: %1 ' 
.const [123] = Utf8 'PoiFuelWarningServiceReplace#checkPendingEvents() - not supported for RSE!' 
.const [124] = Utf8 'PoiFuelWarningServiceReplace#checkPendingEvents() - fuelWarningRecommendation off.' 
.const [125] = Utf8 'PoiFuelWarningServiceReplace#checkPendingEvents() - navigation currently not fully operable.' 
.const [126] = Class [308] 
.const [127] = NameAndType [309] [310] 
.const [128] = Utf8 'PoiFuelWarningServiceReplace#checkPendingEvents() - not supported for RS-etron!' 
.const [129] = Utf8 'PoiFuelWarningServiceReplace#checkPendingEvents() - fuel warning is for electric -> ignore event!' 
.const [130] = Utf8 'PoiFuelWarningServiceReplace#updateTankInfo( %1 ) ' 
.const [131] = Utf8 'PoiFuelWarningServiceReplace#updateFuelWarning( %1 ) ' 
.const [132] = Utf8 'PoiFuelWarningServiceReplace#fuelLevelLow() - routeContainsPetrolStation: %1 ' 
.const [133] = Class [311] 
.const [134] = NameAndType [312] [313] 
.const [135] = Class [314] 
.const [136] = NameAndType [315] [316] 
.const [137] = Class [317] 
.const [138] = NameAndType [318] [319] 
.const [139] = Class [320] 
.const [140] = NameAndType [321] [322] 
.const [141] = Utf8 'PoiFuelWarningServiceReplace#determinePOICategory()' 
.const [142] = Utf8 'PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 )' 
.const [143] = Utf8 'PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 ) - Unsupported BCENGINETYPE_GAS.' 
.const [144] = Class [323] 
.const [145] = NameAndType [324] [325] 
.const [146] = Utf8 'PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 ) - No match found.' 
.const [147] = Utf8 'PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 ) - result category ( %2 )' 
.const [148] = Utf8 'PoiFuelWarningServiceReplace#getPOICatogoryPersistencyConst( %1 )' 
.const [149] = Utf8 CATEGORY_NEXT_PETROLSTATION 
.const [150] = Utf8 CATEGORY_NEXT_CHARGINGSTATION 
.const [151] = Utf8 CATEGORY_NEXT_CNGSTATION 
.const [152] = Utf8 CATEGORY_NEXT_LPGSTATION 
.const [153] = Utf8 CATEGORY_NEXT_PETROLSTATION_DIESEL_NAR 
.const [154] = Utf8 'PoiFuelWarningServiceReplace#getPOICatogoryPersistencyConst( %1 ) - no match found' 
.const [155] = Utf8 'PoiFuelWarningServiceReplace#getPOICatogoryPersistencyConst( %2 ) - result ( %1 )' 
.const [156] = Utf8 'PoiFuelWarningServiceReplace#toggleFuelWarningSelection()' 
.const [157] = Utf8 'PoiFuelWarningServiceReplace#setFuelWarningSelection()' 
.const [158] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [159] = Utf8 java/lang/Object 
.const [160] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [161] = Utf8 de/audi/atip/log/LogChannel 
.const [162] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [163] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [164] = Utf8 de/audi/tghu/navi/app/OperationManager 
.const [165] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [166] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [167] = Utf8 org/dsi/ifc/generalvehiclestates/TankInfo 
.const [168] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [169] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [170] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [171] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [172] = Utf8 org/dsi/ifc/navigation/Route 
.const [173] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [174] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [175] = Class [326] 
.const [176] = NameAndType [327] [328] 
.const [177] = Class [329] 
.const [178] = NameAndType [330] [331] 
.const [179] = Class [332] 
.const [180] = NameAndType [333] [334] 
.const [181] = Class [335] 
.const [182] = NameAndType [336] [337] 
.const [183] = Class [338] 
.const [184] = NameAndType [339] [340] 
.const [185] = Class [341] 
.const [186] = NameAndType [342] [343] 
.const [187] = Class [344] 
.const [188] = NameAndType [345] [346] 
.const [189] = Class [347] 
.const [190] = NameAndType [348] [349] 
.const [191] = Class [350] 
.const [192] = NameAndType [351] [352] 
.const [193] = Class [353] 
.const [194] = NameAndType [354] [355] 
.const [195] = Class [356] 
.const [196] = NameAndType [357] [358] 
.const [197] = Class [359] 
.const [198] = NameAndType [360] [361] 
.const [199] = Class [362] 
.const [200] = NameAndType [363] [364] 
.const [201] = Class [365] 
.const [202] = NameAndType [366] [367] 
.const [203] = Class [368] 
.const [204] = NameAndType [369] [370] 
.const [205] = Class [371] 
.const [206] = NameAndType [372] [373] 
.const [207] = Class [374] 
.const [208] = NameAndType [375] [376] 
.const [209] = Class [377] 
.const [210] = NameAndType [378] [379] 
.const [211] = Class [380] 
.const [212] = NameAndType [381] [382] 
.const [213] = Class [383] 
.const [214] = NameAndType [384] [385] 
.const [215] = Class [386] 
.const [216] = NameAndType [387] [388] 
.const [217] = Class [389] 
.const [218] = NameAndType [390] [391] 
.const [219] = Class [392] 
.const [220] = NameAndType [393] [394] 
.const [221] = Class [395] 
.const [222] = NameAndType [396] [397] 
.const [223] = Class [398] 
.const [224] = NameAndType [399] [400] 
.const [225] = Class [401] 
.const [226] = NameAndType [402] [403] 
.const [227] = Class [404] 
.const [228] = NameAndType [405] [406] 
.const [229] = Class [407] 
.const [230] = NameAndType [408] [409] 
.const [231] = Class [410] 
.const [232] = NameAndType [411] [412] 
.const [233] = Class [413] 
.const [234] = NameAndType [414] [415] 
.const [235] = Class [416] 
.const [236] = NameAndType [417] [418] 
.const [237] = Class [419] 
.const [238] = NameAndType [420] [421] 
.const [239] = Class [422] 
.const [240] = NameAndType [423] [424] 
.const [241] = Class [425] 
.const [242] = NameAndType [426] [427] 
.const [243] = Class [428] 
.const [244] = NameAndType [429] [430] 
.const [245] = Class [431] 
.const [246] = NameAndType [432] [433] 
.const [247] = Class [434] 
.const [248] = NameAndType [435] [436] 
.const [249] = Class [437] 
.const [250] = NameAndType [438] [439] 
.const [251] = Class [440] 
.const [252] = NameAndType [441] [442] 
.const [253] = Class [443] 
.const [254] = NameAndType [444] [445] 
.const [255] = Class [446] 
.const [256] = NameAndType [447] [448] 
.const [257] = Class [449] 
.const [258] = NameAndType [450] [451] 
.const [259] = Class [452] 
.const [260] = NameAndType [453] [454] 
.const [261] = Class [455] 
.const [262] = NameAndType [456] [457] 
.const [263] = Class [458] 
.const [264] = NameAndType [459] [460] 
.const [265] = Class [461] 
.const [266] = NameAndType [462] [463] 
.const [267] = Class [464] 
.const [268] = NameAndType [465] [466] 
.const [269] = Class [467] 
.const [270] = NameAndType [468] [469] 
.const [271] = Class [470] 
.const [272] = NameAndType [471] [472] 
.const [273] = Class [473] 
.const [274] = NameAndType [474] [475] 
.const [275] = Class [476] 
.const [276] = NameAndType [477] [478] 
.const [277] = Class [479] 
.const [278] = NameAndType [480] [481] 
.const [279] = Class [482] 
.const [280] = NameAndType [483] [484] 
.const [281] = Class [485] 
.const [282] = NameAndType [486] [487] 
.const [283] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer 
.const [284] = Class [488] 
.const [285] = NameAndType [489] [490] 
.const [286] = Class [491] 
.const [287] = NameAndType [492] [493] 
.const [288] = Class [494] 
.const [289] = NameAndType [495] [496] 
.const [290] = Class [497] 
.const [291] = NameAndType [498] [499] 
.const [292] = Class [500] 
.const [293] = NameAndType [501] [502] 
.const [294] = Class [503] 
.const [295] = NameAndType [504] [505] 
.const [296] = Class [506] 
.const [297] = NameAndType [507] [508] 
.const [298] = Class [509] 
.const [299] = NameAndType [510] [511] 
.const [300] = Class [512] 
.const [301] = NameAndType [513] [514] 
.const [302] = Class [515] 
.const [303] = NameAndType [516] [517] 
.const [304] = Class [518] 
.const [305] = NameAndType [519] [520] 
.const [306] = Class [521] 
.const [307] = NameAndType [522] [523] 
.const [308] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [309] = Utf8 isEtronActivated 
.const [310] = Utf8 ()Z 
.const [311] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [312] = Utf8 getRouteLength 
.const [313] = Utf8 (Lorg/dsi/ifc/navigation/Route;)I 
.const [314] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [315] = Utf8 getLocationAccessor 
.const [316] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lde/audi/atip/interapp/locationaccessor/IMyLocationAccessor; 
.const [317] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [318] = Utf8 getPOICatogoryPersistencyConst 
.const [319] = Utf8 (Lde/audi/atip/log/LogChannel;I)Ljava/lang/String; 
.const [320] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [321] = Utf8 setPetrolStationValue 
.const [322] = Utf8 (Lorg/dsi/ifc/global/NavLocation;Ljava/lang/String;)V 
.const [323] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [324] = Utf8 isHURegionNAR 
.const [325] = Utf8 ()Z 
.const [326] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [327] = Utf8 pendingFuelWarning 
.const [328] = Utf8 Z 
.const [329] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [330] = Utf8 pendingFuelWarningTankIndex 
.const [331] = Utf8 I 
.const [332] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [333] = Utf8 fuelWarningValue 
.const [334] = Utf8 Z 
.const [335] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [336] = Utf8 fuelWarningSecondaryValue 
.const [337] = Utf8 Z 
.const [338] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [339] = Utf8 pendingWarningCategory 
.const [340] = Utf8 I 
.const [341] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [342] = Utf8 env 
.const [343] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [344] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [345] = Utf8 getLogChannel 
.const [346] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [347] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [348] = Utf8 logChannel 
.const [349] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [350] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [351] = Utf8 carKombiService 
.const [352] = Utf8 Lde/audi/tghu/navi/app/car/kombi/ICarKombiService; 
.const [353] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [354] = Utf8 fuelWarningModelAccess 
.const [355] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess; 
.const [356] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [357] = Utf8 routeManager 
.const [358] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [359] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [360] = Utf8 poiFuelWarningSetup 
.const [361] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup; 
.const [362] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [363] = Utf8 operationManager 
.const [364] = Utf8 Lde/audi/tghu/navi/app/OperationManager; 
.const [365] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [366] = Utf8 fuelWarningTimer 
.const [367] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer; 
.const [368] = Utf8 de/audi/atip/log/LogChannel 
.const [369] = Utf8 log 
.const [370] = Utf8 (ILjava/lang/String;Z)Z 
.const [371] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [372] = Utf8 getFramework 
.const [373] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [374] = Utf8 de/audi/atip/log/LogChannel 
.const [375] = Utf8 log 
.const [376] = Utf8 (ILjava/lang/String;)Z 
.const [377] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [378] = Utf8 isFuelWarningActive 
.const [379] = Utf8 ()Z 
.const [380] = Utf8 de/audi/tghu/navi/app/OperationManager 
.const [381] = Utf8 isFullyOperable 
.const [382] = Utf8 ()Z 
.const [383] = Utf8 de/audi/atip/log/LogChannel 
.const [384] = Utf8 log 
.const [385] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [386] = Utf8 org/dsi/ifc/generalvehiclestates/TankInfo 
.const [387] = Utf8 isFuelWarning 
.const [388] = Utf8 ()Z 
.const [389] = Utf8 org/dsi/ifc/generalvehiclestates/TankInfo 
.const [390] = Utf8 isFuelWarningSecondary 
.const [391] = Utf8 ()Z 
.const [392] = Utf8 de/audi/atip/log/LogChannel 
.const [393] = Utf8 log 
.const [394] = Utf8 (ILjava/lang/String;J)Z 
.const [395] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer 
.const [396] = Utf8 start 
.const [397] = Utf8 ()V 
.const [398] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer 
.const [399] = Utf8 stop 
.const [400] = Utf8 ()V 
.const [401] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [402] = Utf8 getContainer 
.const [403] = Utf8 ()Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [404] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [405] = Utf8 isRgActive 
.const [406] = Utf8 ()Z 
.const [407] = Utf8 org/dsi/ifc/navigation/Route 
.const [408] = Utf8 getRoutelist 
.const [409] = Utf8 ()[Lorg/dsi/ifc/navigation/RouteDestination; 
.const [410] = Utf8 org/dsi/ifc/navigation/Route 
.const [411] = Utf8 getIndexOfCurrentDestination 
.const [412] = Utf8 ()J 
.const [413] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [414] = Utf8 getRouteLocation 
.const [415] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [416] = Utf8 de/audi/atip/log/LogChannel 
.const [417] = Utf8 log 
.const [418] = Utf8 (ILjava/lang/String;JJ)Z 
.const [419] = Utf8 de/audi/atip/log/LogChannel 
.const [420] = Utf8 log 
.const [421] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [422] = Utf8 de/audi/atip/log/LogChannel 
.const [423] = Utf8 isDebug2 
.const [424] = Utf8 ()Z 
.const [425] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [426] = Utf8 setFuelWarningActive 
.const [427] = Utf8 (ZZ)V 
.const [428] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup 
.const [429] = Utf8 resetSettings 
.const [430] = Utf8 ()V 
.const [431] = Utf8 java/lang/Object 
.const [432] = Utf8 <init> 
.const [433] = Utf8 ()V 
.const [434] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer 
.const [435] = Utf8 <init> 
.const [436] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/IPoiFuelWarningService;)V 
.const [437] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [438] = Utf8 setFuelWarningSelection 
.const [439] = Utf8 ()V 
.const [440] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [441] = Utf8 fuelLevelLow 
.const [442] = Utf8 (I)V 
.const [443] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [444] = Utf8 determinePOICategory 
.const [445] = Utf8 (I)I 
.const [446] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [447] = Utf8 routeContainsPetrolStation 
.const [448] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)Z 
.const [449] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [450] = Utf8 getPOICategoryForFuelType 
.const [451] = Utf8 (I)I 
.const [452] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [453] = Utf8 pendingFuelWarning 
.const [454] = Utf8 Z 
.const [455] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [456] = Utf8 pendingFuelWarningTankIndex 
.const [457] = Utf8 I 
.const [458] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [459] = Utf8 fuelWarningValue 
.const [460] = Utf8 Z 
.const [461] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [462] = Utf8 fuelWarningSecondaryValue 
.const [463] = Utf8 Z 
.const [464] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [465] = Utf8 pendingWarningCategory 
.const [466] = Utf8 I 
.const [467] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [468] = Utf8 env 
.const [469] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [470] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [471] = Utf8 logChannel 
.const [472] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [473] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [474] = Utf8 carKombiService 
.const [475] = Utf8 Lde/audi/tghu/navi/app/car/kombi/ICarKombiService; 
.const [476] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [477] = Utf8 fuelWarningModelAccess 
.const [478] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess; 
.const [479] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [480] = Utf8 routeManager 
.const [481] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [482] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [483] = Utf8 poiFuelWarningSetup 
.const [484] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup; 
.const [485] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [486] = Utf8 operationManager 
.const [487] = Utf8 Lde/audi/tghu/navi/app/OperationManager; 
.const [488] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [489] = Utf8 fuelWarningTimer 
.const [490] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer; 
.const [491] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [492] = Utf8 isFrontMU 
.const [493] = Utf8 ()Z 
.const [494] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [495] = Utf8 getEngineTypeSecondary 
.const [496] = Utf8 ()I 
.const [497] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [498] = Utf8 hidePopUp 
.const [499] = Utf8 ()V 
.const [500] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [501] = Utf8 getRoute 
.const [502] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [503] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [504] = Utf8 showPopUp 
.const [505] = Utf8 (I)V 
.const [506] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [507] = Utf8 getPoiCategoryNumber 
.const [508] = Utf8 ()I 
.const [509] = Utf8 de/audi/tghu/navi/app/car/kombi/ICarKombiService 
.const [510] = Utf8 getEngineTypePrimary 
.const [511] = Utf8 ()I 
.const [512] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [513] = Utf8 setFuelWarningChoiceModel 
.const [514] = Utf8 (Z)V 
.const [515] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [516] = Utf8 cleanup 
.const [517] = Utf8 ()V 
.const [518] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [519] = Utf8 isFuelWarningActive 
.const [520] = Utf8 ()Z 
.const [521] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess 
.const [522] = Utf8 setFuelWarningActive 
.const [523] = Utf8 (Z)V 
.const [524] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningServiceReplace 
.const [525] = Class [524] 
.const [526] = Utf8 java/lang/Object 
.const [527] = Class [526] 
.const [528] = Utf8 de/audi/tghu/navi/app/addressinput/poi/fuelwarning/IPoiFuelWarningService 
.const [529] = Class [528] 
.const [530] = Utf8 de/audi/tghu/navi/app/car/IUpdateTankInfoObserver 
.const [531] = Class [530] 
.const [532] = Utf8 FUEL_TANK_INDEX_PRIMARY 
.const [533] = Utf8 I 
.const [534] = Utf8 FUEL_TANK_INDEX_SECONDARY 
.const [535] = Utf8 I 
.const [536] = Utf8 FUEL_TANK_INDEX_PRIMARY_SECONDARY 
.const [537] = Utf8 I 
.const [538] = Utf8 CATEGORY_NEXT_PETROLSTATION 
.const [539] = Utf8 Ljava/lang/String; 
.const [540] = Utf8 CATEGORY_NEXT_CHARGINGSTATION 
.const [541] = Utf8 Ljava/lang/String; 
.const [542] = Utf8 CATEGORY_NEXT_CNGSTATION 
.const [543] = Utf8 Ljava/lang/String; 
.const [544] = Utf8 CATEGORY_NEXT_LPGSTATION 
.const [545] = Utf8 Ljava/lang/String; 
.const [546] = Utf8 CATEGORY_NEXT_PETROLSTATION_DIESEL_NAR 
.const [547] = Utf8 Ljava/lang/String; 
.const [548] = Utf8 carKombiService 
.const [549] = Utf8 Lde/audi/tghu/navi/app/car/kombi/ICarKombiService; 
.const [550] = Utf8 env 
.const [551] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [552] = Utf8 logChannel 
.const [553] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [554] = Utf8 routeManager 
.const [555] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [556] = Utf8 fuelWarningModelAccess 
.const [557] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess; 
.const [558] = Utf8 poiFuelWarningSetup 
.const [559] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup; 
.const [560] = Utf8 operationManager 
.const [561] = Utf8 Lde/audi/tghu/navi/app/OperationManager; 
.const [562] = Utf8 pendingFuelWarning 
.const [563] = Utf8 Z 
.const [564] = Utf8 pendingFuelWarningTankIndex 
.const [565] = Utf8 I 
.const [566] = Utf8 fuelWarningTimer 
.const [567] = Utf8 Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/FuelWarningTimer; 
.const [568] = Utf8 fuelWarningValue 
.const [569] = Utf8 Z 
.const [570] = Utf8 fuelWarningSecondaryValue 
.const [571] = Utf8 Z 
.const [572] = Utf8 pendingWarningCategory 
.const [573] = Utf8 I 
.const [574] = Utf8 Code 
.const [575] = Utf8 <init> 
.const [576] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/car/kombi/ICarKombiService;Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/IFuelWarningModelAccess;Lde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/addressinput/poi/fuelwarning/PoiFuelWarningSetup;Lde/audi/tghu/navi/app/OperationManager;)V 
.const [577] = Utf8 checkPendingEvents 
.const [578] = Utf8 ()V 
.const [579] = Utf8 updateTankInfo 
.const [580] = Utf8 (Lorg/dsi/ifc/generalvehiclestates/TankInfo;)V 
.const [581] = Utf8 getPendingWarningCategory 
.const [582] = Utf8 ()I 
.const [583] = Utf8 fuelLevelLow 
.const [584] = Utf8 (I)V 
.const [585] = Utf8 routeContainsPetrolStation 
.const [586] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)Z 
.const [587] = Utf8 setPetrolStationFlagToLocation 
.const [588] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/global/NavLocation;I)V 
.const [589] = Utf8 determinePOICategory 
.const [590] = Utf8 (I)I 
.const [591] = Utf8 getPOICategoryForFuelType 
.const [592] = Utf8 (I)I 
.const [593] = Utf8 getPOICatogoryPersistencyConst 
.const [594] = Utf8 (Lde/audi/atip/log/LogChannel;I)Ljava/lang/String; 
.const [595] = Utf8 toggleFuelWarningSelection 
.const [596] = Utf8 ()V 
.const [597] = Utf8 setFuelWarningSelection 
.const [598] = Utf8 ()V 
.const [599] = Utf8 resetSettings 
.const [600] = Utf8 ()V 
.const [601] = Utf8 cleanUp 
.const [602] = Utf8 ()V 
.const [603] = Utf8 isFuelWarningActive 
.const [604] = Utf8 ()Z 
.const [605] = Utf8 setFuelWarningActive 
.const [606] = Utf8 (Z)V 
.end class 
