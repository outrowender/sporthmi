.version 50 0 
.class public final super [141] 
.super [143] 
.field public static final [144] [145] 
.field public static final [146] [147] 
.field public static final [148] [149] 
.field public static final [150] [151] 
.field public static final [152] [153] 
.field public static final [154] [155] 
.field public static final [156] [157] 
.field public static final [158] [159] 
.field public static final [160] [161] 
.field public static final [162] [163] 
.field public static final [164] [165] 
.field public static final [166] [167] 
.field public static final [168] [169] 
.field public static final [170] [171] 
.field public static final [172] [173] 
.field public static final [174] [175] 
.field public static final [176] [177] 
.field public static final [178] [179] 
.field public static final [180] [181] 
.field public static final [182] [183] 
.field public static final [184] [185] 
.field public static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 
.field public static final [192] [193] 
.field public static final [194] [195] 
.field public static final [196] [197] 
.field public static final [198] [199] 
.field public static final [200] [201] 
.field public static final [202] [203] 
.field public static final [204] [205] 
.field private static volatile [206] [207] 
.field private volatile [208] [209] 
.field private volatile [210] [211] 

.method private [213] : [214] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [34] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [215] : [216] 
    .attribute [212] .code stack 1 locals 1 
L0:     iconst_1 
L1:     istore_1 
L2:     iload_0 
L3:     lookupswitch 
            5 : L28 
            6 : L33 
            default : L38 

L28:    iconst_1 
L29:    istore_1 
L30:    goto L40 
L33:    iconst_2 
L34:    istore_1 
L35:    goto L40 
L38:    iconst_0 
L39:    istore_1 
L40:    iload_1 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static synchronized [217] : [218] 
    .attribute [212] .code stack 6 locals 3 
L0:     getstatic [2] 
L3:     ifnonnull L178 
L6:     getstatic [3] 
L9:     invokevirtual [23] 
L12:    getstatic [4] 
L15:    ifnull L178 
L18:    iconst_3 
L19:    getstatic [4] 
L22:    arraylength 
L23:    if_icmpne L178 
L26:    getstatic [5] 
L29:    ifnull L178 
L32:    iconst_3 
L33:    getstatic [5] 
L36:    arraylength 
L37:    if_icmpne L178 
L40:    getstatic [4] 
L43:    arraylength 
L44:    anewarray [6] 
L47:    astore_0 
L48:    iconst_0 
L49:    istore_1 
L50:    iload_1 
L51:    aload_0 
L52:    arraylength 
L53:    if_icmpge L103 
L56:    getstatic [4] 
L59:    iload_1 
L60:    aaload 
L61:    ifnull L95 
L64:    aload_0 
L65:    iload_1 
L66:    getstatic [4] 
L69:    iload_1 
L70:    aaload 
L71:    arraylength 
L72:    newarray int 
L74:    aastore 
L75:    getstatic [4] 
L78:    iload_1 
L79:    aaload 
L80:    iconst_0 
L81:    aload_0 
L82:    iload_1 
L83:    aaload 
L84:    iconst_0 
L85:    aload_0 
L86:    iload_1 
L87:    aaload 
L88:    arraylength 
L89:    invokestatic [7] 
L92:    goto L97 
L95:    aconst_null 
L96:    areturn 
L97:    iinc 1 1 
L100:   goto L50 
L103:   getstatic [5] 
L106:   arraylength 
L107:   anewarray [8] 
L110:   astore_1 
L111:   iconst_0 
L112:   istore_2 
L113:   iload_2 
L114:   aload_1 
L115:   arraylength 
L116:   if_icmpge L166 
L119:   getstatic [5] 
L122:   iload_2 
L123:   aaload 
L124:   ifnull L158 
L127:   aload_1 
L128:   iload_2 
L129:   getstatic [5] 
L132:   iload_2 
L133:   aaload 
L134:   arraylength 
L135:   newarray float 
L137:   aastore 
L138:   getstatic [5] 
L141:   iload_2 
L142:   aaload 
L143:   iconst_0 
L144:   aload_1 
L145:   iload_2 
L146:   aaload 
L147:   iconst_0 
L148:   aload_1 
L149:   iload_2 
L150:   aaload 
L151:   arraylength 
L152:   invokestatic [7] 
L155:   goto L160 
L158:   aconst_null 
L159:   areturn 
L160:   iinc 2 1 
L163:   goto L113 
L166:   new [35] 
L169:   dup 
L170:   aload_0 
L171:   aload_1 
L172:   invokespecial [28] 
L175:   putstatic [25] 
L178:   getstatic [2] 
L181:   areturn 
L182:   nop 
L183:   nop 
L184:   
    .end code 
.end method 

.method private [219] : [220] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnull L34 
L7:     iload_1 
L8:     iconst_m1 
L9:     if_icmple L34 
L12:    iload_1 
L13:    aload_0 
L14:    getfield [22] 
L17:    arraylength 
L18:    if_icmpge L34 
L21:    aload_0 
L22:    getfield [22] 
L25:    iload_1 
L26:    aaload 
L27:    ifnull L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method private [221] : [222] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [29] 
L5:     ifeq L28 
L8:     iload_2 
L9:     iconst_m1 
L10:    if_icmple L28 
L13:    iload_2 
L14:    aload_0 
L15:    getfield [22] 
L18:    iload_1 
L19:    aaload 
L20:    arraylength 
L21:    if_icmpge L28 
L24:    iconst_1 
L25:    goto L29 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [223] : [224] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L34 
L7:     iload_1 
L8:     iconst_m1 
L9:     if_icmple L34 
L12:    iload_1 
L13:    aload_0 
L14:    getfield [21] 
L17:    arraylength 
L18:    if_icmpge L34 
L21:    aload_0 
L22:    getfield [21] 
L25:    iload_1 
L26:    aaload 
L27:    ifnull L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method private [225] : [226] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [30] 
L5:     ifeq L28 
L8:     iload_2 
L9:     iconst_m1 
L10:    if_icmple L28 
L13:    iload_2 
L14:    aload_0 
L15:    getfield [21] 
L18:    iload_1 
L19:    aaload 
L20:    arraylength 
L21:    if_icmpge L28 
L24:    iconst_1 
L25:    goto L29 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [31] 
L6:     ifeq L18 
L9:     aload_0 
L10:    getfield [22] 
L13:    iload_1 
L14:    aaload 
L15:    iload_2 
L16:    fload_3 
L17:    fastore 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [31] 
L6:     ifeq L18 
L9:     aload_0 
L10:    getfield [22] 
L13:    iload_1 
L14:    aaload 
L15:    iload_2 
L16:    faload 
L17:    areturn 
L18:    ldc [10] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [231] : [232] 
    .attribute [212] .code stack 6 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [29] 
L5:     ifeq L43 
L8:     aload_2 
L9:     ifnull L43 
L12:    aload_0 
L13:    getfield [22] 
L16:    iload_1 
L17:    aaload 
L18:    arraylength 
L19:    aload_2 
L20:    arraylength 
L21:    if_icmpgt L43 
L24:    aload_2 
L25:    iconst_0 
L26:    aload_0 
L27:    getfield [22] 
L30:    iload_1 
L31:    aaload 
L32:    iconst_0 
L33:    aload_0 
L34:    getfield [22] 
L37:    iload_1 
L38:    aaload 
L39:    arraylength 
L40:    invokestatic [7] 
L43:    return 
L44:    
    .end code 
.end method 

.method public synchronized [233] : [234] 
    .attribute [212] .code stack 5 locals 1 
L0:     aconst_null 
L1:     astore_3 
L2:     aload_0 
L3:     iload_1 
L4:     invokespecial [29] 
L7:     ifeq L54 
L10:    aload_2 
L11:    ifnull L30 
L14:    aload_2 
L15:    arraylength 
L16:    aload_0 
L17:    getfield [22] 
L20:    iload_1 
L21:    aaload 
L22:    arraylength 
L23:    if_icmplt L30 
L26:    aload_2 
L27:    goto L39 
L30:    aload_0 
L31:    getfield [22] 
L34:    iload_1 
L35:    aaload 
L36:    arraylength 
L37:    newarray float 
L39:    astore_3 
L40:    aload_0 
L41:    getfield [22] 
L44:    iload_1 
L45:    aaload 
L46:    iconst_0 
L47:    aload_3 
L48:    iconst_0 
L49:    aload_3 
L50:    arraylength 
L51:    invokestatic [7] 
L54:    aload_3 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public synchronized [235] : [236] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [32] 
L6:     ifeq L18 
L9:     aload_0 
L10:    getfield [21] 
L13:    iload_1 
L14:    aaload 
L15:    iload_2 
L16:    iload_3 
L17:    iastore 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [237] : [238] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [32] 
L6:     ifeq L18 
L9:     aload_0 
L10:    getfield [21] 
L13:    iload_1 
L14:    aaload 
L15:    iload_2 
L16:    iaload 
L17:    areturn 
L18:    iconst_m1 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public synchronized [239] : [240] 
    .attribute [212] .code stack 6 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [30] 
L5:     ifeq L43 
L8:     aload_2 
L9:     ifnull L43 
L12:    aload_0 
L13:    getfield [21] 
L16:    iload_1 
L17:    aaload 
L18:    arraylength 
L19:    aload_2 
L20:    arraylength 
L21:    if_icmpgt L43 
L24:    aload_2 
L25:    iconst_0 
L26:    aload_0 
L27:    getfield [21] 
L30:    iload_1 
L31:    aaload 
L32:    iconst_0 
L33:    aload_0 
L34:    getfield [21] 
L37:    iload_1 
L38:    aaload 
L39:    arraylength 
L40:    invokestatic [7] 
L43:    return 
L44:    
    .end code 
.end method 

.method public synchronized [241] : [242] 
    .attribute [212] .code stack 5 locals 1 
L0:     aconst_null 
L1:     astore_3 
L2:     aload_0 
L3:     iload_1 
L4:     invokespecial [30] 
L7:     ifeq L54 
L10:    aload_2 
L11:    ifnull L30 
L14:    aload_2 
L15:    arraylength 
L16:    aload_0 
L17:    getfield [21] 
L20:    iload_1 
L21:    aaload 
L22:    arraylength 
L23:    if_icmplt L30 
L26:    aload_2 
L27:    goto L39 
L30:    aload_0 
L31:    getfield [21] 
L34:    iload_1 
L35:    aaload 
L36:    arraylength 
L37:    newarray int 
L39:    astore_3 
L40:    aload_0 
L41:    getfield [21] 
L44:    iload_1 
L45:    aaload 
L46:    iconst_0 
L47:    aload_3 
L48:    iconst_0 
L49:    aload_3 
L50:    arraylength 
L51:    invokestatic [7] 
L54:    aload_3 
L55:    areturn 
L56:    
    .end code 
.end method 

.method static [243] : [244] 
    .attribute [212] .code stack 7 locals 0 
L0:     iconst_3 
L1:     anewarray [6] 
L4:     dup 
L5:     iconst_0 
L6:     iconst_5 
L7:     newarray int 
L9:     dup 
L10:    iconst_0 
L11:    sipush 1500 
L14:    iastore 
L15:    dup 
L16:    iconst_1 
L17:    sipush 350 
L20:    iastore 
L21:    dup 
L22:    iconst_2 
L23:    iconst_2 
L24:    iastore 
L25:    dup 
L26:    iconst_3 
L27:    bipush 10 
L29:    iastore 
L30:    dup 
L31:    iconst_4 
L32:    iconst_2 
L33:    iastore 
L34:    aastore 
L35:    dup 
L36:    iconst_1 
L37:    iconst_5 
L38:    newarray int 
L40:    dup 
L41:    iconst_0 
L42:    sipush 1500 
L45:    iastore 
L46:    dup 
L47:    iconst_1 
L48:    sipush 350 
L51:    iastore 
L52:    dup 
L53:    iconst_2 
L54:    iconst_2 
L55:    iastore 
L56:    dup 
L57:    iconst_3 
L58:    bipush 10 
L60:    iastore 
L61:    dup 
L62:    iconst_4 
L63:    iconst_2 
L64:    iastore 
L65:    aastore 
L66:    dup 
L67:    iconst_2 
L68:    iconst_5 
L69:    newarray int 
L71:    dup 
L72:    iconst_0 
L73:    sipush 1500 
L76:    iastore 
L77:    dup 
L78:    iconst_1 
L79:    sipush 350 
L82:    iastore 
L83:    dup 
L84:    iconst_2 
L85:    iconst_2 
L86:    iastore 
L87:    dup 
L88:    iconst_3 
L89:    bipush 10 
L91:    iastore 
L92:    dup 
L93:    iconst_4 
L94:    iconst_2 
L95:    iastore 
L96:    aastore 
L97:    putstatic [26] 
L100:   iconst_3 
L101:   anewarray [8] 
L104:   dup 
L105:   iconst_0 
L106:   iconst_5 
L107:   newarray float 
L109:   dup 
L110:   iconst_0 
L111:   ldc [11] 
L113:   fastore 
L114:   dup 
L115:   iconst_1 
L116:   ldc [12] 
L118:   fastore 
L119:   dup 
L120:   iconst_2 
L121:   ldc [13] 
L123:   fastore 
L124:   dup 
L125:   iconst_3 
L126:   ldc [14] 
L128:   fastore 
L129:   dup 
L130:   iconst_4 
L131:   ldc [15] 
L133:   fastore 
L134:   aastore 
L135:   dup 
L136:   iconst_1 
L137:   iconst_5 
L138:   newarray float 
L140:   dup 
L141:   iconst_0 
L142:   ldc [11] 
L144:   fastore 
L145:   dup 
L146:   iconst_1 
L147:   ldc [12] 
L149:   fastore 
L150:   dup 
L151:   iconst_2 
L152:   ldc [13] 
L154:   fastore 
L155:   dup 
L156:   iconst_3 
L157:   ldc [14] 
L159:   fastore 
L160:   dup 
L161:   iconst_4 
L162:   ldc [15] 
L164:   fastore 
L165:   aastore 
L166:   dup 
L167:   iconst_2 
L168:   iconst_5 
L169:   newarray float 
L171:   dup 
L172:   iconst_0 
L173:   ldc [11] 
L175:   fastore 
L176:   dup 
L177:   iconst_1 
L178:   ldc [12] 
L180:   fastore 
L181:   dup 
L182:   iconst_2 
L183:   ldc [13] 
L185:   fastore 
L186:   dup 
L187:   iconst_3 
L188:   ldc [14] 
L190:   fastore 
L191:   dup 
L192:   iconst_4 
L193:   ldc [15] 
L195:   fastore 
L196:   aastore 
L197:   putstatic [27] 
L200:   aconst_null 
L201:   putstatic [25] 
L204:   return 
L205:   nop 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [36] [37] 
.const [3] = Field [38] [39] 
.const [4] = Field [40] [41] 
.const [5] = Field [42] [43] 
.const [6] = Class [44] 
.const [7] = Method [45] [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = Int 49279 
.const [11] = Int 1718003263 
.const [12] = Int 49215 
.const [13] = Int -842265536 
.const [14] = Int -1701209793 
.const [15] = Int 858993471 
.const [16] = Class [49] 
.const [17] = String [50] 
.const [18] = String [51] 
.const [19] = Class [52] 
.const [20] = Class [53] 
.const [21] = Field [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Field [62] [63] 
.const [26] = Field [64] [65] 
.const [27] = Field [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = Method [70] [71] 
.const [30] = Method [72] [73] 
.const [31] = Method [74] [75] 
.const [32] = Method [76] [77] 
.const [33] = Field [78] [79] 
.const [34] = Field [80] [81] 
.const [35] = Class [82] 
.const [36] = Class [83] 
.const [37] = NameAndType [84] [85] 
.const [38] = Class [86] 
.const [39] = NameAndType [87] [88] 
.const [40] = Class [89] 
.const [41] = NameAndType [90] [91] 
.const [42] = Class [92] 
.const [43] = NameAndType [93] [94] 
.const [44] = Utf8 [I 
.const [45] = Class [95] 
.const [46] = NameAndType [96] [97] 
.const [47] = Utf8 [F 
.const [48] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 '{ MAX_DELTA_TIME, SPEEDUP_MAX_DELTA_TIME, SLOWDOWN_STEP, MAX_SPEED, SCROLL_DELETE_FACTOR };' 
.const [51] = Utf8 '{ SPEEDUP_FACTOR, SLOWDOWN_FACTOR, RESET_FACTOR, MAX_SPEED_FACTOR, MAX_SPEED_ADD };' 
.const [52] = Utf8 java/lang/System 
.const [53] = Utf8 java/io/PrintStream 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Class [104] 
.const [59] = NameAndType [105] [106] 
.const [60] = Class [107] 
.const [61] = NameAndType [108] [109] 
.const [62] = Class [110] 
.const [63] = NameAndType [111] [112] 
.const [64] = Class [113] 
.const [65] = NameAndType [114] [115] 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [83] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [84] = Utf8 thisIsJimmy 
.const [85] = Utf8 Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [86] = Utf8 java/lang/System 
.const [87] = Utf8 out 
.const [88] = Utf8 Ljava/io/PrintStream; 
.const [89] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [90] = Utf8 INT_DEFAULT_CONFIG 
.const [91] = Utf8 [[I 
.const [92] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [93] = Utf8 FLOAT_DEFAULT_CONFIG 
.const [94] = Utf8 [[F 
.const [95] = Utf8 java/lang/System 
.const [96] = Utf8 arraycopy 
.const [97] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [98] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [99] = Utf8 m_intConfig 
.const [100] = Utf8 [[I 
.const [101] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [102] = Utf8 m_floatConfig 
.const [103] = Utf8 [[F 
.const [104] = Utf8 java/io/PrintStream 
.const [105] = Utf8 println 
.const [106] = Utf8 ()V 
.const [107] = Utf8 java/lang/Object 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [111] = Utf8 thisIsJimmy 
.const [112] = Utf8 Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [113] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [114] = Utf8 INT_DEFAULT_CONFIG 
.const [115] = Utf8 [[I 
.const [116] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [117] = Utf8 FLOAT_DEFAULT_CONFIG 
.const [118] = Utf8 [[F 
.const [119] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ([[I[[F)V 
.const [122] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [123] = Utf8 checkFMat 
.const [124] = Utf8 (I)Z 
.const [125] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [126] = Utf8 checkIMat 
.const [127] = Utf8 (I)Z 
.const [128] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [129] = Utf8 checkFArr 
.const [130] = Utf8 (II)Z 
.const [131] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [132] = Utf8 checkIArr 
.const [133] = Utf8 (II)Z 
.const [134] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [135] = Utf8 m_intConfig 
.const [136] = Utf8 [[I 
.const [137] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [138] = Utf8 m_floatConfig 
.const [139] = Utf8 [[F 
.const [140] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [141] = Class [140] 
.const [142] = Utf8 java/lang/Object 
.const [143] = Class [142] 
.const [144] = Utf8 MAX_DELTA_TIME 
.const [145] = Utf8 I 
.const [146] = Utf8 SPEEDUP_MAX_DELTA_TIME 
.const [147] = Utf8 I 
.const [148] = Utf8 SLOWDOWN_STEP 
.const [149] = Utf8 I 
.const [150] = Utf8 MAX_SPEED 
.const [151] = Utf8 I 
.const [152] = Utf8 SCROLL_DELETE_FACTOR 
.const [153] = Utf8 I 
.const [154] = Utf8 IDX_INT_MAX_DELTA_TIME 
.const [155] = Utf8 I 
.const [156] = Utf8 IDX_INT_SPEEDUP_MAX_DELTA_TIME 
.const [157] = Utf8 I 
.const [158] = Utf8 IDX_INT_SLOWDOWN_STEP 
.const [159] = Utf8 I 
.const [160] = Utf8 IDX_INT_MAX_SPEED 
.const [161] = Utf8 I 
.const [162] = Utf8 IDX_INT_SCROLL_DELETE_FACTOR 
.const [163] = Utf8 I 
.const [164] = Utf8 NO_IDX_INT 
.const [165] = Utf8 I 
.const [166] = Utf8 INT_DEFAULT_CONFIG 
.const [167] = Utf8 [[I 
.const [168] = Utf8 INT_ARRAY_EL_NAMES 
.const [169] = Utf8 Ljava/lang/String; 
.const [170] = Utf8 SPEEDUP_FACTOR 
.const [171] = Utf8 F 
.const [172] = Utf8 SLOWDOWN_FACTOR 
.const [173] = Utf8 F 
.const [174] = Utf8 RESET_FACTOR 
.const [175] = Utf8 F 
.const [176] = Utf8 MAX_SPEED_FACTOR 
.const [177] = Utf8 F 
.const [178] = Utf8 MAX_SPEED_ADD 
.const [179] = Utf8 F 
.const [180] = Utf8 IDX_FLOAT_SPEEDUP_FACTOR 
.const [181] = Utf8 I 
.const [182] = Utf8 IDX_FLOAT_SLOWDOWN_FACTOR 
.const [183] = Utf8 I 
.const [184] = Utf8 IDX_FLOAT_RESET_FACTOR 
.const [185] = Utf8 I 
.const [186] = Utf8 IDX_FLOAT_MAX_SPEED_FACTOR 
.const [187] = Utf8 I 
.const [188] = Utf8 IDX_FLOAT_MAX_SPEED_ADD 
.const [189] = Utf8 I 
.const [190] = Utf8 NO_IDX_FLOAT 
.const [191] = Utf8 I 
.const [192] = Utf8 FLOAT_DEFAULT_CONFIG 
.const [193] = Utf8 [[F 
.const [194] = Utf8 FLOAT_ARRAY_EL_NAMES 
.const [195] = Utf8 Ljava/lang/String; 
.const [196] = Utf8 IDX_KEYPNL_FIRST 
.const [197] = Utf8 I 
.const [198] = Utf8 IDX_KEYPNL_OLD 
.const [199] = Utf8 I 
.const [200] = Utf8 IDX_KEYPNL_NEW_ROTARY 
.const [201] = Utf8 I 
.const [202] = Utf8 IDX_KEYPNL_NEW_BIG 
.const [203] = Utf8 I 
.const [204] = Utf8 IDX_KEYPNL_LAST 
.const [205] = Utf8 I 
.const [206] = Utf8 thisIsJimmy 
.const [207] = Utf8 Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [208] = Utf8 m_intConfig 
.const [209] = Utf8 [[I 
.const [210] = Utf8 m_floatConfig 
.const [211] = Utf8 [[F 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 ([[I[[F)V 
.const [215] = Utf8 getTouchPadType 
.const [216] = Utf8 (I)I 
.const [217] = Utf8 getInstance 
.const [218] = Utf8 ()Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [219] = Utf8 checkFMat 
.const [220] = Utf8 (I)Z 
.const [221] = Utf8 checkFArr 
.const [222] = Utf8 (II)Z 
.const [223] = Utf8 checkIMat 
.const [224] = Utf8 (I)Z 
.const [225] = Utf8 checkIArr 
.const [226] = Utf8 (II)Z 
.const [227] = Utf8 setConfigFloat 
.const [228] = Utf8 (IIF)V 
.const [229] = Utf8 getConfigFloat 
.const [230] = Utf8 (II)F 
.const [231] = Utf8 setConfigFloats 
.const [232] = Utf8 (I[F)V 
.const [233] = Utf8 getConfigFloats 
.const [234] = Utf8 (I[F)[F 
.const [235] = Utf8 setConfigInt 
.const [236] = Utf8 (III)V 
.const [237] = Utf8 getConfigInt 
.const [238] = Utf8 (II)I 
.const [239] = Utf8 setConfigInts 
.const [240] = Utf8 (I[I)V 
.const [241] = Utf8 getConfigInts 
.const [242] = Utf8 (I[I)[I 
.const [243] = Utf8 <clinit> 
.const [244] = Utf8 ()V 
.end class 
