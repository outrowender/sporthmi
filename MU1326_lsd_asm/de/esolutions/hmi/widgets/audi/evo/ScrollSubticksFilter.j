.version 50 0 
.class public super [361] 
.super [363] 
.implements [365] 
.field static final [366] [367] 
.field static final [368] [369] 
.field static final [370] [371] 
.field private static final [372] [373] 
.field private static final [374] [375] 
.field private static final [376] [377] 
.field private static final [378] [379] 
.field private static final [380] [381] 
.field private static final [382] [383] 
.field private static final [384] [385] 
.field private [386] [387] 
.field private [388] [389] 
.field private [390] [391] 
.field private [392] [393] 
.field private [394] [395] 
.field private [396] [397] 
.field private [398] [399] 
.field private [400] [401] 
.field private [402] [403] 
.field private [404] [405] 
.field private [406] [407] 
.field private final [408] [409] 

.method public [411] : [412] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [51] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [63] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [64] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [413] : [414] 
    .attribute [410] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [65] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [66] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [67] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [68] 
L20:    aload_0 
L21:    aload_0 
L22:    invokevirtual [32] 
L25:    putfield [69] 
L28:    aload_0 
L29:    ldc [2] 
L31:    putfield [70] 
L34:    aload_0 
L35:    iconst_0 
L36:    putfield [63] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [415] : [416] 
    .attribute [410] .code stack 6 locals 3 
L0:     aload_0 
L1:     invokevirtual [32] 
L4:     lstore 4 
L6:     aload_0 
L7:     lload 4 
L9:     invokespecial [52] 
L12:    istore 6 
L14:    aload_0 
L15:    getfield [30] 
L18:    ifeq L33 
L21:    aload_0 
L22:    getfield [29] 
L25:    ifne L33 
L28:    iload 6 
L30:    ifeq L66 
L33:    aload_0 
L34:    iload_2 
L35:    putfield [70] 
L38:    aload_0 
L39:    iconst_0 
L40:    putfield [65] 
L43:    aload_0 
L44:    getfield [27] 
L47:    ldc [3] 
L49:    ldc [4] 
L51:    aload_0 
L52:    getfield [30] 
L55:    aload_0 
L56:    getfield [29] 
L59:    iload 6 
L61:    invokevirtual [35] 
L64:    fconst_0 
L65:    areturn 
L66:    aload_0 
L67:    iload_2 
L68:    lload 4 
L70:    invokespecial [53] 
L73:    aload_0 
L74:    dup 
L75:    getfield [36] 
L78:    iload_3 
L79:    ifeq L86 
L82:    iload_1 
L83:    goto L88 
L86:    iload_1 
L87:    ineg 
L88:    iadd 
L89:    putfield [71] 
L92:    aload_0 
L93:    iload_2 
L94:    putfield [70] 
L97:    aload_0 
L98:    getfield [28] 
L101:   iconst_1 
L102:   if_icmpne L122 
L105:   aload_0 
L106:   iload_1 
L107:   ifeq L114 
L110:   iconst_1 
L111:   goto L115 
L114:   iconst_0 
L115:   iload_2 
L116:   lload 4 
L118:   invokespecial [54] 
L121:   areturn 
L122:   aload_0 
L123:   getfield [28] 
L126:   iconst_2 
L127:   if_icmpne L136 
L130:   aload_0 
L131:   iload_2 
L132:   invokespecial [55] 
L135:   areturn 
L136:   aload_0 
L137:   getfield [27] 
L140:   sipush 10000 
L143:   ldc [5] 
L145:   aload_0 
L146:   getfield [28] 
L149:   i2l 
L150:   invokevirtual [37] 
L153:   pop 
L154:   fconst_0 
L155:   areturn 
L156:   
    .end code 
.end method 

.method private [417] : [418] 
    .attribute [410] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ifeq L8 
L7:     return 
L8:     aload_0 
L9:     aload_0 
L10:    iload_1 
L11:    invokespecial [56] 
L14:    putfield [72] 
L17:    aload_0 
L18:    lload_2 
L19:    putfield [73] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [71] 
L27:    aload_0 
L28:    iconst_0 
L29:    putfield [74] 
L32:    aload_0 
L33:    iconst_1 
L34:    putfield [65] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [419] : [420] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [2] 
L6:     if_icmpeq L14 
L9:     aload_0 
L10:    getfield [34] 
L13:    areturn 
L14:    iload_1 
L15:    areturn 
L16:    
    .end code 
.end method 

.method private [421] : [422] 
    .attribute [410] .code stack 9 locals 2 
L0:     aload_0 
L1:     lload_3 
L2:     invokevirtual [41] 
L5:     fstore 5 
L7:     fload 5 
L9:     ldc [6] 
L11:    fmul 
L12:    fstore 6 
L14:    iload_1 
L15:    ifne L57 
L18:    iload_2 
L19:    aload_0 
L20:    getfield [38] 
L23:    isub 
L24:    invokestatic [7] 
L27:    i2f 
L28:    fload 6 
L30:    fcmpg 
L31:    ifge L57 
L34:    aload_0 
L35:    getfield [27] 
L38:    ldc [3] 
L40:    ldc [8] 
L42:    iload_2 
L43:    i2d 
L44:    fload 6 
L46:    f2d 
L47:    aload_0 
L48:    getfield [38] 
L51:    i2d 
L52:    invokevirtual [42] 
L55:    fconst_0 
L56:    areturn 
L57:    aload_0 
L58:    iconst_2 
L59:    putfield [65] 
L62:    aload_0 
L63:    iload_2 
L64:    invokespecial [55] 
L67:    areturn 
L68:    
    .end code 
.end method 

.method private [423] : [424] 
    .attribute [410] .code stack 5 locals 7 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     istore_2 
L5:     iload_1 
L6:     invokestatic [7] 
L9:     iload_2 
L10:    if_icmpge L44 
L13:    aload_0 
L14:    getfield [26] 
L17:    ifeq L37 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [63] 
L25:    aload_0 
L26:    getfield [27] 
L29:    ldc [3] 
L31:    ldc [9] 
L33:    invokevirtual [43] 
L36:    pop 
L37:    aload_0 
L38:    iconst_1 
L39:    putfield [74] 
L42:    fconst_0 
L43:    areturn 
L44:    aload_0 
L45:    iload_1 
L46:    invokespecial [58] 
L49:    ifeq L57 
L52:    aload_0 
L53:    iconst_1 
L54:    putfield [74] 
L57:    aload_0 
L58:    getfield [26] 
L61:    ifeq L80 
L64:    aload_0 
L65:    getfield [27] 
L68:    ldc [3] 
L70:    ldc [10] 
L72:    iload_1 
L73:    i2l 
L74:    invokevirtual [37] 
L77:    pop 
L78:    fconst_0 
L79:    areturn 
L80:    aload_0 
L81:    iload_1 
L82:    invokespecial [59] 
L85:    istore_3 
L86:    aload_0 
L87:    iload_1 
L88:    invokespecial [60] 
L91:    istore 4 
L93:    iload_1 
L94:    iload_3 
L95:    isub 
L96:    istore 5 
L98:    iload 5 
L100:   ifle L107 
L103:   iconst_1 
L104:   goto L108 
L107:   iconst_m1 
L108:   istore 6 
L110:   bipush 100 
L112:   iload 6 
L114:   imul 
L115:   iload_3 
L116:   isub 
L117:   iload 4 
L119:   iadd 
L120:   invokestatic [7] 
L123:   istore 7 
L125:   iload 5 
L127:   i2f 
L128:   iload 7 
L130:   i2f 
L131:   fdiv 
L132:   fstore 8 
L134:   fload 8 
L136:   fconst_1 
L137:   invokestatic [11] 
L140:   fstore 8 
L142:   fload 8 
L144:   ldc [12] 
L146:   invokestatic [13] 
L149:   fstore 8 
L151:   fload 8 
L153:   areturn 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 

.method private [425] : [426] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     iconst_1 
L5:     if_icmpgt L16 
L8:     aload_0 
L9:     getfield [36] 
L12:    iconst_m1 
L13:    if_icmpge L18 
L16:    iconst_1 
L17:    areturn 
L18:    aload_0 
L19:    getfield [36] 
L22:    iconst_1 
L23:    if_icmpne L36 
L26:    iload_1 
L27:    ifle L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    aload_0 
L37:    getfield [36] 
L40:    iconst_m1 
L41:    if_icmpne L54 
L44:    iload_1 
L45:    ifge L52 
L48:    iconst_1 
L49:    goto L53 
L52:    iconst_0 
L53:    areturn 
L54:    iconst_0 
L55:    areturn 
L56:    
    .end code 
.end method 

.method private [427] : [428] 
    .attribute [410] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     ifeq L12 
L7:     aload_0 
L8:     getfield [38] 
L11:    areturn 
L12:    iload_1 
L13:    ifle L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_m1 
L21:    istore_2 
L22:    bipush 15 
L24:    iload_2 
L25:    imul 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [429] : [430] 
    .attribute [410] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     ifeq L14 
L7:     iload_1 
L8:     aload_0 
L9:     getfield [38] 
L12:    isub 
L13:    istore_1 
L14:    aload_0 
L15:    iload_1 
L16:    invokespecial [62] 
L19:    ifeq L27 
L22:    aload_0 
L23:    getfield [38] 
L26:    areturn 
L27:    iload_1 
L28:    ifle L35 
L31:    iconst_1 
L32:    goto L36 
L35:    iconst_m1 
L36:    istore_2 
L37:    bipush 15 
L39:    iload_2 
L40:    imul 
L41:    iconst_m1 
L42:    imul 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private [431] : [432] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     ifeq L9 
L7:     iconst_0 
L8:     areturn 
L9:     bipush 15 
L11:    areturn 
L12:    
    .end code 
.end method 

.method private [433] : [434] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     ifne L18 
L7:     aload_0 
L8:     getfield [40] 
L11:    ifne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private [435] : [436] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ifeq L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [36] 
L13:    iconst_1 
L14:    if_icmpne L23 
L17:    iload_1 
L18:    ifge L23 
L21:    iconst_1 
L22:    areturn 
L23:    aload_0 
L24:    getfield [36] 
L27:    iconst_m1 
L28:    if_icmpne L37 
L31:    iload_1 
L32:    ifle L37 
L35:    iconst_1 
L36:    areturn 
L37:    iconst_0 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method [437] : [438] 
    .attribute [410] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifeq L15 
L7:     aload_0 
L8:     lload_1 
L9:     putfield [73] 
L12:    ldc [14] 
L14:    areturn 
L15:    lload_1 
L16:    aload_0 
L17:    getfield [39] 
L20:    lsub 
L21:    l2i 
L22:    istore_3 
L23:    iload_3 
L24:    i2f 
L25:    ldc [15] 
L27:    fdiv 
L28:    fstore 4 
L30:    fconst_1 
L31:    fload 4 
L33:    invokestatic [11] 
L36:    fstore 4 
L38:    ldc [14] 
L40:    ldc [16] 
L42:    fload 4 
L44:    fmul 
L45:    fsub 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method private [439] : [440] 
    .attribute [410] .code stack 4 locals 2 
L0:     lload_1 
L1:     aload_0 
L2:     getfield [33] 
L5:     lsub 
L6:     lstore_3 
L7:     lload_3 
L8:     ldc_w [1] 
L11:    lcmp 
L12:    ifge L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [441] : [442] 
    .attribute [410] .code stack 2 locals 0 
L0:     getstatic [17] 
L3:     invokeinterface [75] 0 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [443] : [444] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [445] : [446] 
    .attribute [410] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [66] 
L5:     iload_1 
L6:     ifne L17 
L9:     aload_0 
L10:    aload_0 
L11:    invokevirtual [32] 
L14:    putfield [69] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [447] : [448] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [449] : [450] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [68] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [451] : [452] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [453] : [454] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [67] 
L5:     iload_1 
L6:     ifne L14 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [65] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [455] : [456] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [457] : [458] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [459] : [460] 
    .attribute [410] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [461] : [462] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [463] : [464] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [45] 
L4:     ifne L12 
L7:     aload_0 
L8:     iconst_0 
L9:     invokevirtual [44] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [465] : [466] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [46] 
L5:     ifeq L13 
L8:     aload_0 
L9:     iconst_0 
L10:    invokevirtual [47] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [467] : [468] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [46] 
L5:     ifeq L13 
L8:     aload_0 
L9:     iconst_1 
L10:    invokevirtual [47] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [469] : [470] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [48] 
L4:     bipush 85 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [471] : [472] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [49] 
L4:     bipush 17 
L6:     if_icmpne L14 
L9:     aload_0 
L10:    iconst_1 
L11:    invokevirtual [50] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [473] : [474] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [49] 
L4:     bipush 17 
L6:     if_icmpne L14 
L9:     aload_0 
L10:    iconst_0 
L11:    invokevirtual [50] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [475] : [476] 
    .attribute [410] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [63] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1061293824 
.const [3] = Int -2137614336 
.const [4] = String [77] 
.const [5] = String [78] 
.const [6] = Int 51266 
.const [7] = Method [79] [80] 
.const [8] = String [81] 
.const [9] = String [82] 
.const [10] = String [83] 
.const [11] = Method [84] [85] 
.const [12] = Int 32959 
.const [13] = Method [86] [87] 
.const [14] = Int -1701242562 
.const [15] = Int 64067 
.const [16] = Int 1899825726 
.const [17] = Field [88] [89] 
.const [18] = Class [90] 
.const [19] = Class [91] 
.const [20] = Class [92] 
.const [21] = Class [93] 
.const [22] = Class [94] 
.const [23] = Class [95] 
.const [24] = Class [96] 
.const [25] = Class [97] 
.const [26] = Field [98] [99] 
.const [27] = Field [100] [101] 
.const [28] = Field [102] [103] 
.const [29] = Field [104] [105] 
.const [30] = Field [106] [107] 
.const [31] = Field [108] [109] 
.const [32] = Method [110] [111] 
.const [33] = Field [112] [113] 
.const [34] = Field [114] [115] 
.const [35] = Method [116] [117] 
.const [36] = Field [118] [119] 
.const [37] = Method [120] [121] 
.const [38] = Field [122] [123] 
.const [39] = Field [124] [125] 
.const [40] = Field [126] [127] 
.const [41] = Method [128] [129] 
.const [42] = Method [130] [131] 
.const [43] = Method [132] [133] 
.const [44] = Method [134] [135] 
.const [45] = Method [136] [137] 
.const [46] = Method [138] [139] 
.const [47] = Method [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Method [148] [149] 
.const [52] = Method [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Method [156] [157] 
.const [56] = Method [158] [159] 
.const [57] = Method [160] [161] 
.const [58] = Method [162] [163] 
.const [59] = Method [164] [165] 
.const [60] = Method [166] [167] 
.const [61] = Method [168] [169] 
.const [62] = Method [170] [171] 
.const [63] = Field [172] [173] 
.const [64] = Field [174] [175] 
.const [65] = Field [176] [177] 
.const [66] = Field [178] [179] 
.const [67] = Field [180] [181] 
.const [68] = Field [182] [183] 
.const [69] = Field [184] [185] 
.const [70] = Field [186] [187] 
.const [71] = Field [188] [189] 
.const [72] = Field [190] [191] 
.const [73] = Field [192] [193] 
.const [74] = Field [194] [195] 
.const [75] = InterfaceMethod [196] [197] 
.const [76] = Int -100663296 
.const [77] = Utf8 'ScrollSubticksFilter#calculateSubticksProgress: ignore subticks. HandsOnRing: %1, DDS Pressed: %2, click delay running: %3' 
.const [78] = Utf8 'ScrollSubticksFilter#calculateSubticksProgress: unknown state %1' 
.const [79] = Class [198] 
.const [80] = NameAndType [199] [200] 
.const [81] = Utf8 'ScrollSubticksFilter#handleStableState: ignore subticks, because subtickCount (%1) is below start threshhold (%2). Stable origin: %3' 
.const [82] = Utf8 'ScrollSubticksFilter#handleMoveState: unlock hDDS, because focus reached snap-in area' 
.const [83] = Utf8 'ScrollSubticksFilter#handleMoveState: ignore subticks, because hDDS is locked. (subticks from event: %1)' 
.const [84] = Class [201] 
.const [85] = NameAndType [202] [203] 
.const [86] = Class [204] 
.const [87] = NameAndType [205] [206] 
.const [88] = Class [207] 
.const [89] = NameAndType [208] [209] 
.const [90] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 java/lang/Math 
.const [94] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [95] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [96] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [97] = Utf8 de/audi/atip/hmi/event/KeyEvent 
.const [98] = Class [210] 
.const [99] = NameAndType [211] [212] 
.const [100] = Class [213] 
.const [101] = NameAndType [214] [215] 
.const [102] = Class [216] 
.const [103] = NameAndType [217] [218] 
.const [104] = Class [219] 
.const [105] = NameAndType [220] [221] 
.const [106] = Class [222] 
.const [107] = NameAndType [223] [224] 
.const [108] = Class [225] 
.const [109] = NameAndType [226] [227] 
.const [110] = Class [228] 
.const [111] = NameAndType [229] [230] 
.const [112] = Class [231] 
.const [113] = NameAndType [232] [233] 
.const [114] = Class [234] 
.const [115] = NameAndType [235] [236] 
.const [116] = Class [237] 
.const [117] = NameAndType [238] [239] 
.const [118] = Class [240] 
.const [119] = NameAndType [241] [242] 
.const [120] = Class [243] 
.const [121] = NameAndType [244] [245] 
.const [122] = Class [246] 
.const [123] = NameAndType [247] [248] 
.const [124] = Class [249] 
.const [125] = NameAndType [250] [251] 
.const [126] = Class [252] 
.const [127] = NameAndType [253] [254] 
.const [128] = Class [255] 
.const [129] = NameAndType [256] [257] 
.const [130] = Class [258] 
.const [131] = NameAndType [259] [260] 
.const [132] = Class [261] 
.const [133] = NameAndType [262] [263] 
.const [134] = Class [264] 
.const [135] = NameAndType [265] [266] 
.const [136] = Class [267] 
.const [137] = NameAndType [268] [269] 
.const [138] = Class [270] 
.const [139] = NameAndType [271] [272] 
.const [140] = Class [273] 
.const [141] = NameAndType [274] [275] 
.const [142] = Class [276] 
.const [143] = NameAndType [277] [278] 
.const [144] = Class [279] 
.const [145] = NameAndType [280] [281] 
.const [146] = Class [282] 
.const [147] = NameAndType [283] [284] 
.const [148] = Class [285] 
.const [149] = NameAndType [286] [287] 
.const [150] = Class [288] 
.const [151] = NameAndType [289] [290] 
.const [152] = Class [291] 
.const [153] = NameAndType [292] [293] 
.const [154] = Class [294] 
.const [155] = NameAndType [295] [296] 
.const [156] = Class [297] 
.const [157] = NameAndType [298] [299] 
.const [158] = Class [300] 
.const [159] = NameAndType [301] [302] 
.const [160] = Class [303] 
.const [161] = NameAndType [304] [305] 
.const [162] = Class [306] 
.const [163] = NameAndType [307] [308] 
.const [164] = Class [309] 
.const [165] = NameAndType [310] [311] 
.const [166] = Class [312] 
.const [167] = NameAndType [313] [314] 
.const [168] = Class [315] 
.const [169] = NameAndType [316] [317] 
.const [170] = Class [318] 
.const [171] = NameAndType [319] [320] 
.const [172] = Class [321] 
.const [173] = NameAndType [322] [323] 
.const [174] = Class [324] 
.const [175] = NameAndType [325] [326] 
.const [176] = Class [327] 
.const [177] = NameAndType [328] [329] 
.const [178] = Class [330] 
.const [179] = NameAndType [331] [332] 
.const [180] = Class [333] 
.const [181] = NameAndType [334] [335] 
.const [182] = Class [336] 
.const [183] = NameAndType [337] [338] 
.const [184] = Class [339] 
.const [185] = NameAndType [340] [341] 
.const [186] = Class [342] 
.const [187] = NameAndType [343] [344] 
.const [188] = Class [345] 
.const [189] = NameAndType [346] [347] 
.const [190] = Class [348] 
.const [191] = NameAndType [349] [350] 
.const [192] = Class [351] 
.const [193] = NameAndType [352] [353] 
.const [194] = Class [354] 
.const [195] = NameAndType [355] [356] 
.const [196] = Class [357] 
.const [197] = NameAndType [358] [359] 
.const [198] = Utf8 java/lang/Math 
.const [199] = Utf8 abs 
.const [200] = Utf8 (I)I 
.const [201] = Utf8 java/lang/Math 
.const [202] = Utf8 min 
.const [203] = Utf8 (FF)F 
.const [204] = Utf8 java/lang/Math 
.const [205] = Utf8 max 
.const [206] = Utf8 (FF)F 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [208] = Utf8 framework 
.const [209] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [211] = Utf8 hddsLockedForListEnd 
.const [212] = Utf8 Z 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [214] = Utf8 lc 
.const [215] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [217] = Utf8 state 
.const [218] = Utf8 I 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [220] = Utf8 ddsPressed 
.const [221] = Utf8 Z 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [223] = Utf8 handsOnRing 
.const [224] = Utf8 Z 
.const [225] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [226] = Utf8 fingersOnTouchpad 
.const [227] = Utf8 Z 
.const [228] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [229] = Utf8 getCurrentTime 
.const [230] = Utf8 ()J 
.const [231] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [232] = Utf8 lastClickTime 
.const [233] = Utf8 J 
.const [234] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [235] = Utf8 lastSubticks 
.const [236] = Utf8 I 
.const [237] = Utf8 de/audi/atip/log/LogChannel 
.const [238] = Utf8 log 
.const [239] = Utf8 (ILjava/lang/String;ZZZ)V 
.const [240] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [241] = Utf8 mainTickSum 
.const [242] = Utf8 I 
.const [243] = Utf8 de/audi/atip/log/LogChannel 
.const [244] = Utf8 log 
.const [245] = Utf8 (ILjava/lang/String;J)Z 
.const [246] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [247] = Utf8 stableOriginPosition 
.const [248] = Utf8 I 
.const [249] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [250] = Utf8 thresholdChangeStartTime 
.const [251] = Utf8 J 
.const [252] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [253] = Utf8 originSnapIn 
.const [254] = Utf8 Z 
.const [255] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [256] = Utf8 getCurrentStartThreshold 
.const [257] = Utf8 (J)F 
.const [258] = Utf8 de/audi/atip/log/LogChannel 
.const [259] = Utf8 log 
.const [260] = Utf8 (ILjava/lang/String;DDD)V 
.const [261] = Utf8 de/audi/atip/log/LogChannel 
.const [262] = Utf8 log 
.const [263] = Utf8 (ILjava/lang/String;)Z 
.const [264] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [265] = Utf8 setFingersOnTouchpad 
.const [266] = Utf8 (Z)V 
.const [267] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [268] = Utf8 getFingerCount 
.const [269] = Utf8 ()I 
.const [270] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [271] = Utf8 isHandsOnRingEvent 
.const [272] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)Z 
.const [273] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [274] = Utf8 setHandsOnRing 
.const [275] = Utf8 (Z)V 
.const [276] = Utf8 de/audi/atip/hmi/event/TouchEvent 
.const [277] = Utf8 getCode 
.const [278] = Utf8 ()I 
.const [279] = Utf8 de/audi/atip/hmi/event/KeyEvent 
.const [280] = Utf8 getKeyCode 
.const [281] = Utf8 ()I 
.const [282] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [283] = Utf8 setDdsPressed 
.const [284] = Utf8 (Z)V 
.const [285] = Utf8 java/lang/Object 
.const [286] = Utf8 <init> 
.const [287] = Utf8 ()V 
.const [288] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [289] = Utf8 isLastClickTimeoutRunning 
.const [290] = Utf8 (J)Z 
.const [291] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [292] = Utf8 initialize 
.const [293] = Utf8 (IJ)V 
.const [294] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [295] = Utf8 handleStableState 
.const [296] = Utf8 (ZIJ)F 
.const [297] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [298] = Utf8 handleMoveState 
.const [299] = Utf8 (I)F 
.const [300] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [301] = Utf8 calculateInitialStableOriginPosition 
.const [302] = Utf8 (I)I 
.const [303] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [304] = Utf8 getSnapInRange 
.const [305] = Utf8 ()I 
.const [306] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [307] = Utf8 hasSkippedNextMainTick 
.const [308] = Utf8 (I)Z 
.const [309] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [310] = Utf8 getNearestZeroOffset 
.const [311] = Utf8 (I)I 
.const [312] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [313] = Utf8 getOppositeZeroPos 
.const [314] = Utf8 (I)I 
.const [315] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [316] = Utf8 isNearOriginWithoutSnapIn 
.const [317] = Utf8 ()Z 
.const [318] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [319] = Utf8 isOppositeOriginWithoutSnapIn 
.const [320] = Utf8 (I)Z 
.const [321] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [322] = Utf8 hddsLockedForListEnd 
.const [323] = Utf8 Z 
.const [324] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [325] = Utf8 lc 
.const [326] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [327] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [328] = Utf8 state 
.const [329] = Utf8 I 
.const [330] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [331] = Utf8 ddsPressed 
.const [332] = Utf8 Z 
.const [333] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [334] = Utf8 handsOnRing 
.const [335] = Utf8 Z 
.const [336] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [337] = Utf8 fingersOnTouchpad 
.const [338] = Utf8 Z 
.const [339] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [340] = Utf8 lastClickTime 
.const [341] = Utf8 J 
.const [342] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [343] = Utf8 lastSubticks 
.const [344] = Utf8 I 
.const [345] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [346] = Utf8 mainTickSum 
.const [347] = Utf8 I 
.const [348] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [349] = Utf8 stableOriginPosition 
.const [350] = Utf8 I 
.const [351] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [352] = Utf8 thresholdChangeStartTime 
.const [353] = Utf8 J 
.const [354] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [355] = Utf8 originSnapIn 
.const [356] = Utf8 Z 
.const [357] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [358] = Utf8 getMonotonicTime 
.const [359] = Utf8 ()J 
.const [360] = Utf8 de/esolutions/hmi/widgets/audi/evo/ScrollSubticksFilter 
.const [361] = Class [360] 
.const [362] = Utf8 java/lang/Object 
.const [363] = Class [362] 
.const [364] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetConstants 
.const [365] = Class [364] 
.const [366] = Utf8 STATE_INIT 
.const [367] = Utf8 I 
.const [368] = Utf8 STATE_STABLE 
.const [369] = Utf8 I 
.const [370] = Utf8 STATE_MOVE 
.const [371] = Utf8 I 
.const [372] = Utf8 HDDS_SUBCLICKS_PER_MAINCLICK 
.const [373] = Utf8 I 
.const [374] = Utf8 HDDS_SNAP_IN_SUBTICKS 
.const [375] = Utf8 I 
.const [376] = Utf8 HDDS_START_THRESHOLD_BIG 
.const [377] = Utf8 F 
.const [378] = Utf8 HDDS_START_THRESHOLD_SMALL 
.const [379] = Utf8 F 
.const [380] = Utf8 HDDS_START_THRESHOLD_CHANGE_TIME 
.const [381] = Utf8 I 
.const [382] = Utf8 HDDS_CLICK_DELAY 
.const [383] = Utf8 I 
.const [384] = Utf8 UNDEFINED_SUBTICKS 
.const [385] = Utf8 I 
.const [386] = Utf8 state 
.const [387] = Utf8 I 
.const [388] = Utf8 fingersOnTouchpad 
.const [389] = Utf8 Z 
.const [390] = Utf8 handsOnRing 
.const [391] = Utf8 Z 
.const [392] = Utf8 ddsPressed 
.const [393] = Utf8 Z 
.const [394] = Utf8 lastClickTime 
.const [395] = Utf8 J 
.const [396] = Utf8 thresholdChangeStartTime 
.const [397] = Utf8 J 
.const [398] = Utf8 lastSubticks 
.const [399] = Utf8 I 
.const [400] = Utf8 stableOriginPosition 
.const [401] = Utf8 I 
.const [402] = Utf8 mainTickSum 
.const [403] = Utf8 I 
.const [404] = Utf8 originSnapIn 
.const [405] = Utf8 Z 
.const [406] = Utf8 hddsLockedForListEnd 
.const [407] = Utf8 Z 
.const [408] = Utf8 lc 
.const [409] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [410] = Utf8 Code 
.const [411] = Utf8 <init> 
.const [412] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [413] = Utf8 reset 
.const [414] = Utf8 ()V 
.const [415] = Utf8 calculateSubticksProgress 
.const [416] = Utf8 (IIZ)F 
.const [417] = Utf8 initialize 
.const [418] = Utf8 (IJ)V 
.const [419] = Utf8 calculateInitialStableOriginPosition 
.const [420] = Utf8 (I)I 
.const [421] = Utf8 handleStableState 
.const [422] = Utf8 (ZIJ)F 
.const [423] = Utf8 handleMoveState 
.const [424] = Utf8 (I)F 
.const [425] = Utf8 hasSkippedNextMainTick 
.const [426] = Utf8 (I)Z 
.const [427] = Utf8 getNearestZeroOffset 
.const [428] = Utf8 (I)I 
.const [429] = Utf8 getOppositeZeroPos 
.const [430] = Utf8 (I)I 
.const [431] = Utf8 getSnapInRange 
.const [432] = Utf8 ()I 
.const [433] = Utf8 isNearOriginWithoutSnapIn 
.const [434] = Utf8 ()Z 
.const [435] = Utf8 isOppositeOriginWithoutSnapIn 
.const [436] = Utf8 (I)Z 
.const [437] = Utf8 getCurrentStartThreshold 
.const [438] = Utf8 (J)F 
.const [439] = Utf8 isLastClickTimeoutRunning 
.const [440] = Utf8 (J)Z 
.const [441] = Utf8 getCurrentTime 
.const [442] = Utf8 ()J 
.const [443] = Utf8 isDdsPressed 
.const [444] = Utf8 ()Z 
.const [445] = Utf8 setDdsPressed 
.const [446] = Utf8 (Z)V 
.const [447] = Utf8 isFingersOnTouchpad 
.const [448] = Utf8 ()Z 
.const [449] = Utf8 setFingersOnTouchpad 
.const [450] = Utf8 (Z)V 
.const [451] = Utf8 isHandsOnRing 
.const [452] = Utf8 ()Z 
.const [453] = Utf8 setHandsOnRing 
.const [454] = Utf8 (Z)V 
.const [455] = Utf8 getStableOriginPosition 
.const [456] = Utf8 ()I 
.const [457] = Utf8 getState 
.const [458] = Utf8 ()I 
.const [459] = Utf8 isHddsLockedForListEnd 
.const [460] = Utf8 ()Z 
.const [461] = Utf8 touchPadPressed 
.const [462] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)V 
.const [463] = Utf8 touchPadReleased 
.const [464] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)V 
.const [465] = Utf8 touchPadAbandoned 
.const [466] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)V 
.const [467] = Utf8 touchPadApproached 
.const [468] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)V 
.const [469] = Utf8 isHandsOnRingEvent 
.const [470] = Utf8 (Lde/audi/atip/hmi/event/TouchEvent;)Z 
.const [471] = Utf8 keyPressed 
.const [472] = Utf8 (Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [473] = Utf8 keyReleased 
.const [474] = Utf8 (Lde/audi/atip/hmi/event/KeyEvent;)V 
.const [475] = Utf8 endOfListReached 
.const [476] = Utf8 ()V 
.end class 
