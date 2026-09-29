.version 50 0 
.class public super [426] 
.super [428] 
.field public static final [429] [430] 
.field private static final [431] [432] 
.field private static final [433] [434] 
.field private static final [435] [436] 
.field private static final [437] [438] 
.field private static final [439] [440] 
.field private static final [441] [442] 
.field private static final [443] [444] 
.field private static final [445] [446] 
.field private final [447] [448] 
.field private final [449] [450] 
.field private final [451] [452] 
.field private final [453] [454] 
.field private final [455] [456] 
.field private final [457] [458] 

.method private static [460] : [461] 
    .attribute [459] .code stack 1 locals 0 
L0:     iload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static [462] : [463] 
    .attribute [459] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 1 
            L52 
            L52 
            L48 
            L50 
            L54 
            L56 
            L61 
            L58 
            default : L61 

L48:    iconst_1 
L49:    areturn 
L50:    iconst_2 
L51:    areturn 
L52:    iconst_3 
L53:    areturn 
L54:    iconst_4 
L55:    areturn 
L56:    iconst_5 
L57:    areturn 
L58:    bipush 8 
L60:    areturn 
L61:    iconst_0 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method static [464] : [465] 
    .attribute [459] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L56 
            L76 
            L66 
            L68 
            L78 
            L73 
            L70 
            L78 
            L56 
            L56 
            default : L78 

L56:    iload_1 
L57:    ifne L64 
L60:    iconst_1 
L61:    goto L65 
L64:    iconst_5 
L65:    areturn 
L66:    iconst_3 
L67:    areturn 
L68:    iconst_4 
L69:    areturn 
L70:    bipush 7 
L72:    areturn 
L73:    bipush 6 
L75:    areturn 
L76:    iconst_2 
L77:    areturn 
L78:    iconst_0 
L79:    areturn 
L80:    
    .end code 
.end method 

.method private static [466] : [467] 
    .attribute [459] .code stack 5 locals 9 
L0:     iconst_0 
L1:     istore_3 
L2:     aload_0 
L3:     ifnull L234 
L6:     aload_1 
L7:     ifnull L234 
L10:    aload_1 
L11:    invokeinterface [70] 0 
L16:    ifnull L234 
L19:    aload_1 
L20:    invokeinterface [70] 0 
L25:    astore 4 
L27:    aload_1 
L28:    invokeinterface [71] 0 
L33:    istore 5 
L35:    aload_1 
L36:    invokeinterface [72] 0 
L41:    istore 6 
L43:    aload 4 
L45:    invokevirtual [33] 
L48:    istore 7 
L50:    aload_0 
L51:    getfield [34] 
L54:    iconst_1 
L55:    if_icmpne L62 
L58:    iconst_1 
L59:    goto L63 
L62:    iconst_0 
L63:    istore 8 
L65:    iload 8 
L67:    ifeq L88 
L70:    iload 5 
L72:    ifeq L88 
L75:    aload_1 
L76:    invokeinterface [73] 0 
L81:    ifeq L88 
L84:    iconst_1 
L85:    goto L89 
L88:    iconst_0 
L89:    istore 9 
L91:    aload 4 
L93:    invokevirtual [35] 
L96:    bipush 15 
L98:    if_icmpeq L111 
L101:   aload 4 
L103:   invokevirtual [35] 
L106:   bipush 27 
L108:   if_icmpne L124 
L111:   aload_1 
L112:   invokeinterface [74] 0 
L117:   ifeq L124 
L120:   iconst_1 
L121:   goto L125 
L124:   iconst_0 
L125:   istore 10 
L127:   aload_0 
L128:   invokevirtual [36] 
L131:   istore 11 
L133:   iload 11 
L135:   tableswitch 1 
            L197 
            L197 
            L218 
            L180 
            L200 
            L203 
            L234 
            L203 
            default : L234 

L180:   aload 4 
L182:   iload 5 
L184:   iload 6 
L186:   iload 7 
L188:   iload 9 
L190:   invokestatic [3] 
L193:   istore_3 
L194:   goto L234 
L197:   goto L234 
L200:   goto L234 
L203:   aload 4 
L205:   iload 5 
L207:   iload 6 
L209:   iload 7 
L211:   invokestatic [4] 
L214:   istore_3 
L215:   goto L234 
L218:   iload_2 
L219:   aload 4 
L221:   iload 5 
L223:   iload 7 
L225:   iload 10 
L227:   invokestatic [5] 
L230:   istore_3 
L231:   goto L234 
L234:   iload_3 
L235:   areturn 
L236:   
    .end code 
.end method 

.method private static [468] : [469] 
    .attribute [459] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore 5 
L3:     iload_3 
L4:     ifne L11 
L7:     iload_0 
L8:     ifne L17 
L11:    iconst_4 
L12:    istore 5 
L14:    goto L87 
L17:    iload_2 
L18:    ifeq L52 
L21:    aload_1 
L22:    invokevirtual [37] 
L25:    ifeq L34 
L28:    iconst_2 
L29:    istore 5 
L31:    goto L87 
L34:    iconst_1 
L35:    istore 5 
L37:    iload 4 
L39:    ifeq L87 
L42:    iload 5 
L44:    bipush 8 
L46:    ior 
L47:    istore 5 
L49:    goto L87 
L52:    aload_1 
L53:    invokevirtual [37] 
L56:    ifne L66 
L59:    aload_1 
L60:    invokevirtual [38] 
L63:    ifeq L72 
L66:    iconst_4 
L67:    istore 5 
L69:    goto L87 
L72:    iconst_1 
L73:    istore 5 
L75:    iload 4 
L77:    ifeq L87 
L80:    iload 5 
L82:    bipush 8 
L84:    ior 
L85:    istore 5 
L87:    iload 5 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method private static [470] : [471] 
    .attribute [459] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [39] 
L4:     ifeq L13 
L7:     iconst_0 
L8:     istore 4 
L10:    goto L47 
L13:    iload_1 
L14:    ifeq L43 
L17:    iload_3 
L18:    ifeq L43 
L21:    bipush 32 
L23:    istore 4 
L25:    iload 4 
L27:    iload_2 
L28:    ifeq L36 
L31:    bipush 64 
L33:    goto L37 
L36:    iconst_0 
L37:    ior 
L38:    istore 4 
L40:    goto L47 
L43:    bipush 16 
L45:    istore 4 
L47:    iload 4 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private static [472] : [473] 
    .attribute [459] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore 5 
L3:     iload_1 
L4:     ifeq L60 
L7:     aload_0 
L8:     invokevirtual [39] 
L11:    ifne L60 
L14:    aload_0 
L15:    invokevirtual [40] 
L18:    ifne L60 
L21:    iload_3 
L22:    ifeq L43 
L25:    bipush 32 
L27:    istore 5 
L29:    iload_2 
L30:    ifeq L47 
L33:    iload 5 
L35:    bipush 64 
L37:    ior 
L38:    istore 5 
L40:    goto L47 
L43:    bipush 8 
L45:    istore 5 
L47:    iload 4 
L49:    ifeq L60 
L52:    iload 5 
L54:    sipush 128 
L57:    ior 
L58:    istore 5 
L60:    iload 5 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method private static [474] : [475] 
    .attribute [459] .code stack 5 locals 4 
L0:     aload_0 
L1:     ifnull L60 
L4:     aload_1 
L5:     ifnull L60 
L8:     aload_0 
L9:     invokevirtual [41] 
L12:    istore_3 
L13:    aload_0 
L14:    invokevirtual [36] 
L17:    istore 4 
L19:    aload_0 
L20:    invokevirtual [42] 
L23:    istore 5 
L25:    new [75] 
L28:    dup 
L29:    iload 4 
L31:    invokestatic [7] 
L34:    iload 5 
L36:    iload_3 
L37:    invokestatic [8] 
L40:    iload_3 
L41:    invokespecial [64] 
L44:    astore 6 
L46:    aload 6 
L48:    aload_0 
L49:    aload_1 
L50:    iload_2 
L51:    invokestatic [9] 
L54:    invokevirtual [43] 
L57:    aload 6 
L59:    areturn 
L60:    aconst_null 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method private static [476] : [477] 
    .attribute [459] .code stack 8 locals 4 
L0:     aload_0 
L1:     ifnull L115 
L4:     aload_1 
L5:     ifnull L115 
L8:     aload_0 
L9:     invokevirtual [44] 
L12:    astore_3 
L13:    aload_0 
L14:    invokevirtual [41] 
L17:    istore 4 
L19:    aload_0 
L20:    invokevirtual [42] 
L23:    istore 5 
L25:    aconst_null 
L26:    astore 6 
L28:    aload_3 
L29:    invokestatic [10] 
L32:    ifeq L79 
L35:    new [76] 
L38:    dup 
L39:    aload_0 
L40:    aload_1 
L41:    aload_2 
L42:    invokestatic [12] 
L45:    aload_0 
L46:    invokevirtual [45] 
L49:    iload 5 
L51:    iload 4 
L53:    invokestatic [8] 
L56:    aload_0 
L57:    invokevirtual [46] 
L60:    invokestatic [13] 
L63:    aload_3 
L64:    invokevirtual [47] 
L67:    aload_3 
L68:    invokevirtual [48] 
L71:    invokespecial [65] 
L74:    astore 6 
L76:    goto L112 
L79:    new [76] 
L82:    dup 
L83:    aload_0 
L84:    aload_1 
L85:    aload_2 
L86:    invokestatic [12] 
L89:    aload_0 
L90:    invokevirtual [45] 
L93:    iload 5 
L95:    iload 4 
L97:    invokestatic [8] 
L100:   aload_0 
L101:   invokevirtual [46] 
L104:   invokestatic [13] 
L107:   invokespecial [66] 
L110:   astore 6 
L112:   aload 6 
L114:   areturn 
L115:   aconst_null 
L116:   areturn 
L117:   nop 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method private static [478] : [479] 
    .attribute [459] .code stack 2 locals 3 
L0:     aload_0 
L1:     ifnull L130 
L4:     aload_0 
L5:     invokevirtual [42] 
L8:     istore_3 
L9:     iload_3 
L10:    lookupswitch 
            65536 : L53 
            131072 : L61 
            196608 : L44 
            default : L70 

L44:    aload_2 
L45:    bipush 7 
L47:    invokeinterface [77] 0 
L52:    areturn 
L53:    aload_2 
L54:    iconst_5 
L55:    invokeinterface [77] 0 
L60:    areturn 
L61:    aload_2 
L62:    bipush 6 
L64:    invokeinterface [77] 0 
L69:    areturn 
L70:    aload_0 
L71:    invokevirtual [49] 
L74:    astore 4 
L76:    aload_0 
L77:    invokevirtual [45] 
L80:    astore 5 
L82:    aload_1 
L83:    aload 5 
L85:    invokeinterface [78] 0 
L90:    ifeq L101 
L93:    aload_2 
L94:    iconst_0 
L95:    invokeinterface [77] 0 
L100:   areturn 
L101:   aload 4 
L103:   ifnull L127 
L106:   aload 4 
L108:   invokevirtual [50] 
L111:   ifle L127 
L114:   aload 4 
L116:   aload 5 
L118:   invokevirtual [51] 
L121:   ifne L127 
L124:   aload 4 
L126:   areturn 
L127:   ldc [14] 
L129:   areturn 
L130:   ldc [14] 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [480] : [481] 
    .attribute [459] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [67] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [79] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [80] 
L14:    aload_0 
L15:    aload_2 
L16:    invokeinterface [81] 0 
L21:    putfield [82] 
L24:    aload_0 
L25:    aload_1 
L26:    aload_2 
L27:    iload_3 
L28:    invokestatic [15] 
L31:    putfield [83] 
L34:    aload_0 
L35:    aload_1 
L36:    aload_2 
L37:    aload 4 
L39:    invokestatic [16] 
L42:    putfield [84] 
L45:    aload_1 
L46:    invokevirtual [57] 
L49:    istore 5 
L51:    aload_0 
L52:    iload 5 
L54:    iconst_m1 
L55:    if_icmpeq L70 
L58:    new [85] 
L61:    dup 
L62:    iload 5 
L64:    invokespecial [68] 
L67:    goto L79 
L70:    new [85] 
L73:    dup 
L74:    ldc [18] 
L76:    invokespecial [68] 
L79:    putfield [86] 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public interface [482] : [483] 
    .attribute [459] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [54] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [484] : [485] 
    .attribute [459] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [55] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [486] : [487] 
    .attribute [459] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [56] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [488] : [489] 
    .attribute [459] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [58] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [490] : [491] 
    .attribute [459] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [52] 
L4:     invokevirtual [59] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public interface [492] : [493] 
    .attribute [459] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [52] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [494] : [495] 
    .attribute [459] .code stack 2 locals 1 
L0:     new [87] 
L3:     dup 
L4:     invokespecial [69] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [20] 
L11:    invokevirtual [60] 
L14:    pop 
L15:    aload_1 
L16:    ldc [21] 
L18:    invokevirtual [60] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [52] 
L27:    invokevirtual [61] 
L30:    pop 
L31:    aload_1 
L32:    ldc [21] 
L34:    invokevirtual [60] 
L37:    pop 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [55] 
L43:    invokevirtual [61] 
L46:    pop 
L47:    aload_1 
L48:    ldc [21] 
L50:    invokevirtual [60] 
L53:    pop 
L54:    aload_1 
L55:    aload_0 
L56:    getfield [56] 
L59:    invokevirtual [61] 
L62:    pop 
L63:    aload_1 
L64:    ldc [21] 
L66:    invokevirtual [60] 
L69:    pop 
L70:    aload_1 
L71:    aload_0 
L72:    getfield [58] 
L75:    invokevirtual [61] 
L78:    pop 
L79:    aload_1 
L80:    ldc [21] 
L82:    invokevirtual [60] 
L85:    pop 
L86:    aload_1 
L87:    ldc [22] 
L89:    invokevirtual [60] 
L92:    pop 
L93:    aload_1 
L94:    aload_0 
L95:    getfield [53] 
L98:    invokevirtual [62] 
L101:   pop 
L102:   aload_1 
L103:   invokevirtual [63] 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [88] [89] 
.const [3] = Method [90] [91] 
.const [4] = Method [92] [93] 
.const [5] = Method [94] [95] 
.const [6] = Class [96] 
.const [7] = Method [97] [98] 
.const [8] = Method [99] [100] 
.const [9] = Method [101] [102] 
.const [10] = Method [103] [104] 
.const [11] = Class [105] 
.const [12] = Method [106] [107] 
.const [13] = Method [108] [109] 
.const [14] = String [110] 
.const [15] = Method [111] [112] 
.const [16] = Method [113] [114] 
.const [17] = Class [115] 
.const [18] = Int -65536 
.const [19] = Class [116] 
.const [20] = String [117] 
.const [21] = String [118] 
.const [22] = String [119] 
.const [23] = Class [120] 
.const [24] = Class [121] 
.const [25] = Class [122] 
.const [26] = Class [123] 
.const [27] = Class [124] 
.const [28] = Class [125] 
.const [29] = Class [126] 
.const [30] = Class [127] 
.const [31] = Class [128] 
.const [32] = Class [129] 
.const [33] = Method [130] [131] 
.const [34] = Field [132] [133] 
.const [35] = Method [134] [135] 
.const [36] = Method [136] [137] 
.const [37] = Method [138] [139] 
.const [38] = Method [140] [141] 
.const [39] = Method [142] [143] 
.const [40] = Method [144] [145] 
.const [41] = Method [146] [147] 
.const [42] = Method [148] [149] 
.const [43] = Method [150] [151] 
.const [44] = Method [152] [153] 
.const [45] = Method [154] [155] 
.const [46] = Method [156] [157] 
.const [47] = Method [158] [159] 
.const [48] = Method [160] [161] 
.const [49] = Method [162] [163] 
.const [50] = Method [164] [165] 
.const [51] = Method [166] [167] 
.const [52] = Field [168] [169] 
.const [53] = Field [170] [171] 
.const [54] = Field [172] [173] 
.const [55] = Field [174] [175] 
.const [56] = Field [176] [177] 
.const [57] = Method [178] [179] 
.const [58] = Field [180] [181] 
.const [59] = Method [182] [183] 
.const [60] = Method [184] [185] 
.const [61] = Method [186] [187] 
.const [62] = Method [188] [189] 
.const [63] = Method [190] [191] 
.const [64] = Method [192] [193] 
.const [65] = Method [194] [195] 
.const [66] = Method [196] [197] 
.const [67] = Method [198] [199] 
.const [68] = Method [200] [201] 
.const [69] = Method [202] [203] 
.const [70] = InterfaceMethod [204] [205] 
.const [71] = InterfaceMethod [206] [207] 
.const [72] = InterfaceMethod [208] [209] 
.const [73] = InterfaceMethod [210] [211] 
.const [74] = InterfaceMethod [212] [213] 
.const [75] = Class [214] 
.const [76] = Class [215] 
.const [77] = InterfaceMethod [216] [217] 
.const [78] = InterfaceMethod [218] [219] 
.const [79] = Field [220] [221] 
.const [80] = Field [222] [223] 
.const [81] = InterfaceMethod [224] [225] 
.const [82] = Field [226] [227] 
.const [83] = Field [228] [229] 
.const [84] = Field [230] [231] 
.const [85] = Class [232] 
.const [86] = Field [233] [234] 
.const [87] = Class [235] 
.const [88] = Class [236] 
.const [89] = NameAndType [237] [238] 
.const [90] = Class [239] 
.const [91] = NameAndType [240] [241] 
.const [92] = Class [242] 
.const [93] = NameAndType [243] [244] 
.const [94] = Class [245] 
.const [95] = NameAndType [246] [247] 
.const [96] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [97] = Class [248] 
.const [98] = NameAndType [249] [250] 
.const [99] = Class [251] 
.const [100] = NameAndType [252] [253] 
.const [101] = Class [254] 
.const [102] = NameAndType [255] [256] 
.const [103] = Class [257] 
.const [104] = NameAndType [258] [259] 
.const [105] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [106] = Class [260] 
.const [107] = NameAndType [261] [262] 
.const [108] = Class [263] 
.const [109] = NameAndType [264] [265] 
.const [110] = Utf8 '' 
.const [111] = Class [266] 
.const [112] = NameAndType [267] [268] 
.const [113] = Class [269] 
.const [114] = NameAndType [270] [271] 
.const [115] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CallStartTime 
.const [116] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [117] = Utf8 'TelBAPCall: ' 
.const [118] = Utf8 '\n\t' 
.const [119] = Utf8 'callLeading=' 
.const [120] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [121] = Utf8 java/lang/Object 
.const [122] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBUtils 
.const [123] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [124] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [125] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [126] = Utf8 de/audi/app/phone/core/util/PhoneUtils 
.const [127] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [128] = Utf8 de/audi/app/phone/core/ITelTextFactory 
.const [129] = Utf8 java/lang/String 
.const [130] = Class [272] 
.const [131] = NameAndType [273] [274] 
.const [132] = Class [275] 
.const [133] = NameAndType [276] [277] 
.const [134] = Class [278] 
.const [135] = NameAndType [279] [280] 
.const [136] = Class [281] 
.const [137] = NameAndType [282] [283] 
.const [138] = Class [284] 
.const [139] = NameAndType [285] [286] 
.const [140] = Class [287] 
.const [141] = NameAndType [288] [289] 
.const [142] = Class [290] 
.const [143] = NameAndType [291] [292] 
.const [144] = Class [293] 
.const [145] = NameAndType [294] [295] 
.const [146] = Class [296] 
.const [147] = NameAndType [297] [298] 
.const [148] = Class [299] 
.const [149] = NameAndType [300] [301] 
.const [150] = Class [302] 
.const [151] = NameAndType [303] [304] 
.const [152] = Class [305] 
.const [153] = NameAndType [306] [307] 
.const [154] = Class [308] 
.const [155] = NameAndType [309] [310] 
.const [156] = Class [311] 
.const [157] = NameAndType [312] [313] 
.const [158] = Class [314] 
.const [159] = NameAndType [315] [316] 
.const [160] = Class [317] 
.const [161] = NameAndType [318] [319] 
.const [162] = Class [320] 
.const [163] = NameAndType [321] [322] 
.const [164] = Class [323] 
.const [165] = NameAndType [324] [325] 
.const [166] = Class [326] 
.const [167] = NameAndType [327] [328] 
.const [168] = Class [329] 
.const [169] = NameAndType [330] [331] 
.const [170] = Class [332] 
.const [171] = NameAndType [333] [334] 
.const [172] = Class [335] 
.const [173] = NameAndType [336] [337] 
.const [174] = Class [338] 
.const [175] = NameAndType [339] [340] 
.const [176] = Class [341] 
.const [177] = NameAndType [342] [343] 
.const [178] = Class [344] 
.const [179] = NameAndType [345] [346] 
.const [180] = Class [347] 
.const [181] = NameAndType [348] [349] 
.const [182] = Class [350] 
.const [183] = NameAndType [351] [352] 
.const [184] = Class [353] 
.const [185] = NameAndType [354] [355] 
.const [186] = Class [356] 
.const [187] = NameAndType [357] [358] 
.const [188] = Class [359] 
.const [189] = NameAndType [360] [361] 
.const [190] = Class [362] 
.const [191] = NameAndType [363] [364] 
.const [192] = Class [365] 
.const [193] = NameAndType [366] [367] 
.const [194] = Class [368] 
.const [195] = NameAndType [369] [370] 
.const [196] = Class [371] 
.const [197] = NameAndType [372] [373] 
.const [198] = Class [374] 
.const [199] = NameAndType [375] [376] 
.const [200] = Class [377] 
.const [201] = NameAndType [378] [379] 
.const [202] = Class [380] 
.const [203] = NameAndType [381] [382] 
.const [204] = Class [383] 
.const [205] = NameAndType [384] [385] 
.const [206] = Class [386] 
.const [207] = NameAndType [387] [388] 
.const [208] = Class [389] 
.const [209] = NameAndType [390] [391] 
.const [210] = Class [392] 
.const [211] = NameAndType [393] [394] 
.const [212] = Class [395] 
.const [213] = NameAndType [396] [397] 
.const [214] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [215] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [216] = Class [398] 
.const [217] = NameAndType [399] [400] 
.const [218] = Class [401] 
.const [219] = NameAndType [402] [403] 
.const [220] = Class [404] 
.const [221] = NameAndType [405] [406] 
.const [222] = Class [407] 
.const [223] = NameAndType [408] [409] 
.const [224] = Class [410] 
.const [225] = NameAndType [411] [412] 
.const [226] = Class [413] 
.const [227] = NameAndType [414] [415] 
.const [228] = Class [416] 
.const [229] = NameAndType [417] [418] 
.const [230] = Class [419] 
.const [231] = NameAndType [420] [421] 
.const [232] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CallStartTime 
.const [233] = Class [422] 
.const [234] = NameAndType [423] [424] 
.const [235] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [236] = Utf8 de/audi/app/addressbook/core/combi/bap/CombiADBUtils 
.const [237] = Utf8 getCombiPhoneType 
.const [238] = Utf8 (I)I 
.const [239] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [240] = Utf8 computeCallOptionsActive 
.const [241] = Utf8 (Lde/audi/app/phone/core/state/CallStateStruct;ZZZZ)I 
.const [242] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [243] = Utf8 computeCallOptionsHold 
.const [244] = Utf8 (Lde/audi/app/phone/core/state/CallStateStruct;ZZZ)I 
.const [245] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [246] = Utf8 computeCallOptionsRinging 
.const [247] = Utf8 (ZLde/audi/app/phone/core/state/CallStateStruct;ZZZ)I 
.const [248] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [249] = Utf8 getCallState 
.const [250] = Utf8 (I)I 
.const [251] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [252] = Utf8 getCallType 
.const [253] = Utf8 (II)I 
.const [254] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [255] = Utf8 getCallOptions 
.const [256] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Z)I 
.const [257] = Utf8 de/audi/app/phone/core/util/PhoneUtils 
.const [258] = Utf8 isPictureAvailable 
.const [259] = Utf8 (Lorg/dsi/ifc/global/ResourceLocator;)Z 
.const [260] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [261] = Utf8 getDisplayName 
.const [262] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Lde/audi/app/phone/core/ITelTextFactory;)Ljava/lang/String; 
.const [263] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [264] = Utf8 getBapCategory 
.const [265] = Utf8 (I)I 
.const [266] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [267] = Utf8 getCombiCallState 
.const [268] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Z)Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [269] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [270] = Utf8 getCombiCallInfo 
.const [271] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Lde/audi/app/phone/core/ITelTextFactory;)Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [272] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [273] = Utf8 isMultipartyActive 
.const [274] = Utf8 ()Z 
.const [275] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [276] = Utf8 telMpty 
.const [277] = Utf8 I 
.const [278] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [279] = Utf8 getMpCallState 
.const [280] = Utf8 ()I 
.const [281] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [282] = Utf8 getTelCallState 
.const [283] = Utf8 ()I 
.const [284] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [285] = Utf8 isHasActiveCall 
.const [286] = Utf8 ()Z 
.const [287] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [288] = Utf8 isHasOnHoldCall 
.const [289] = Utf8 ()Z 
.const [290] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [291] = Utf8 isHasIncomingCall 
.const [292] = Utf8 ()Z 
.const [293] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [294] = Utf8 isHasOutgoingCall 
.const [295] = Utf8 ()Z 
.const [296] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [297] = Utf8 getTelMpty 
.const [298] = Utf8 ()I 
.const [299] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [300] = Utf8 getTelCallType 
.const [301] = Utf8 ()I 
.const [302] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [303] = Utf8 setCallOptions 
.const [304] = Utf8 (I)V 
.const [305] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [306] = Utf8 getTelRemPictureId 
.const [307] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [308] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [309] = Utf8 getTelRemNumber 
.const [310] = Utf8 ()Ljava/lang/String; 
.const [311] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [312] = Utf8 getTelRemNumberType 
.const [313] = Utf8 ()I 
.const [314] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [315] = Utf8 getUrl 
.const [316] = Utf8 ()Ljava/lang/String; 
.const [317] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [318] = Utf8 getId 
.const [319] = Utf8 ()I 
.const [320] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [321] = Utf8 getTelRemName 
.const [322] = Utf8 ()Ljava/lang/String; 
.const [323] = Utf8 java/lang/String 
.const [324] = Utf8 length 
.const [325] = Utf8 ()I 
.const [326] = Utf8 java/lang/String 
.const [327] = Utf8 equals 
.const [328] = Utf8 (Ljava/lang/Object;)Z 
.const [329] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [330] = Utf8 phoneCall 
.const [331] = Utf8 Lorg/dsi/ifc/telephoneng/CallInformation; 
.const [332] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [333] = Utf8 callLeading 
.const [334] = Utf8 Z 
.const [335] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [336] = Utf8 deviceRole 
.const [337] = Utf8 I 
.const [338] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [339] = Utf8 callState 
.const [340] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [341] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [342] = Utf8 callInfo 
.const [343] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [344] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [345] = Utf8 getTelCallStartingTime 
.const [346] = Utf8 ()I 
.const [347] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [348] = Utf8 callStartTime 
.const [349] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CallStartTime; 
.const [350] = Utf8 org/dsi/ifc/telephoneng/CallInformation 
.const [351] = Utf8 getTelCallID 
.const [352] = Utf8 ()S 
.const [353] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [354] = Utf8 append 
.const [355] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [356] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [357] = Utf8 append 
.const [358] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [359] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [360] = Utf8 append 
.const [361] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [362] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [363] = Utf8 toString 
.const [364] = Utf8 ()Ljava/lang/String; 
.const [365] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [366] = Utf8 <init> 
.const [367] = Utf8 (III)V 
.const [368] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [369] = Utf8 <init> 
.const [370] = Utf8 (Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V 
.const [371] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [372] = Utf8 <init> 
.const [373] = Utf8 (Ljava/lang/String;Ljava/lang/String;II)V 
.const [374] = Utf8 java/lang/Object 
.const [375] = Utf8 <init> 
.const [376] = Utf8 ()V 
.const [377] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CallStartTime 
.const [378] = Utf8 <init> 
.const [379] = Utf8 (I)V 
.const [380] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [381] = Utf8 <init> 
.const [382] = Utf8 ()V 
.const [383] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [384] = Utf8 getCallState 
.const [385] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [386] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [387] = Utf8 isMultipartySupported 
.const [388] = Utf8 ()Z 
.const [389] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [390] = Utf8 isAddToConferenceSupported 
.const [391] = Utf8 ()Z 
.const [392] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [393] = Utf8 isEnhancedCallFeaturesSupported 
.const [394] = Utf8 ()Z 
.const [395] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [396] = Utf8 isResponseAndHoldSupported 
.const [397] = Utf8 ()Z 
.const [398] = Utf8 de/audi/app/phone/core/ITelTextFactory 
.const [399] = Utf8 getText 
.const [400] = Utf8 (I)Ljava/lang/String; 
.const [401] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [402] = Utf8 isMailboxNumber 
.const [403] = Utf8 (Ljava/lang/String;)Z 
.const [404] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [405] = Utf8 phoneCall 
.const [406] = Utf8 Lorg/dsi/ifc/telephoneng/CallInformation; 
.const [407] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [408] = Utf8 callLeading 
.const [409] = Utf8 Z 
.const [410] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [411] = Utf8 getDeviceRole 
.const [412] = Utf8 ()I 
.const [413] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [414] = Utf8 deviceRole 
.const [415] = Utf8 I 
.const [416] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [417] = Utf8 callState 
.const [418] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [419] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [420] = Utf8 callInfo 
.const [421] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [422] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [423] = Utf8 callStartTime 
.const [424] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CallStartTime; 
.const [425] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [426] = Class [425] 
.const [427] = Utf8 java/lang/Object 
.const [428] = Class [427] 
.const [429] = Utf8 STARTING_TIME_INVALID 
.const [430] = Utf8 I 
.const [431] = Utf8 CALL_OPTION_ACCEPT_CALL 
.const [432] = Utf8 I 
.const [433] = Utf8 CALL_OPTION_MP_CALL_HOLD_ACCEPT_WAITING_CALL 
.const [434] = Utf8 I 
.const [435] = Utf8 CALL_OPTION_MP_RELEASE_ACTIVE_CALL_ACCEPT_WAITING_CALL 
.const [436] = Utf8 I 
.const [437] = Utf8 CALL_OPTION_CALL_HOLD 
.const [438] = Utf8 I 
.const [439] = Utf8 CALL_OPTION_RESUME_CALL 
.const [440] = Utf8 I 
.const [441] = Utf8 CALL_OPTION_MP_SWAP 
.const [442] = Utf8 I 
.const [443] = Utf8 CALL_OPTION_CC_JOIN 
.const [444] = Utf8 I 
.const [445] = Utf8 CALL_OPTION_CC_SPLIT 
.const [446] = Utf8 I 
.const [447] = Utf8 phoneCall 
.const [448] = Utf8 Lorg/dsi/ifc/telephoneng/CallInformation; 
.const [449] = Utf8 callState 
.const [450] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [451] = Utf8 callInfo 
.const [452] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [453] = Utf8 callStartTime 
.const [454] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/data/CallStartTime; 
.const [455] = Utf8 callLeading 
.const [456] = Utf8 Z 
.const [457] = Utf8 deviceRole 
.const [458] = Utf8 I 
.const [459] = Utf8 Code 
.const [460] = Utf8 getBapCategory 
.const [461] = Utf8 (I)I 
.const [462] = Utf8 getCallState 
.const [463] = Utf8 (I)I 
.const [464] = Utf8 getCallType 
.const [465] = Utf8 (II)I 
.const [466] = Utf8 getCallOptions 
.const [467] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Z)I 
.const [468] = Utf8 computeCallOptionsRinging 
.const [469] = Utf8 (ZLde/audi/app/phone/core/state/CallStateStruct;ZZZ)I 
.const [470] = Utf8 computeCallOptionsHold 
.const [471] = Utf8 (Lde/audi/app/phone/core/state/CallStateStruct;ZZZ)I 
.const [472] = Utf8 computeCallOptionsActive 
.const [473] = Utf8 (Lde/audi/app/phone/core/state/CallStateStruct;ZZZZ)I 
.const [474] = Utf8 getCombiCallState 
.const [475] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Z)Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [476] = Utf8 getCombiCallInfo 
.const [477] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Lde/audi/app/phone/core/ITelTextFactory;)Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [478] = Utf8 getDisplayName 
.const [479] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;Lde/audi/app/phone/core/ITelTextFactory;)Ljava/lang/String; 
.const [480] = Utf8 <init> 
.const [481] = Utf8 (Lorg/dsi/ifc/telephoneng/CallInformation;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;ZLde/audi/app/phone/core/ITelTextFactory;)V 
.const [482] = Utf8 getDeviceRole 
.const [483] = Utf8 ()I 
.const [484] = Utf8 getCallState 
.const [485] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [486] = Utf8 getCallInfo 
.const [487] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [488] = Utf8 getCallStartTime 
.const [489] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/data/CallStartTime; 
.const [490] = Utf8 getCallID 
.const [491] = Utf8 ()I 
.const [492] = Utf8 getPhoneCall 
.const [493] = Utf8 ()Lorg/dsi/ifc/telephoneng/CallInformation; 
.const [494] = Utf8 toString 
.const [495] = Utf8 ()Ljava/lang/String; 
.end class 
