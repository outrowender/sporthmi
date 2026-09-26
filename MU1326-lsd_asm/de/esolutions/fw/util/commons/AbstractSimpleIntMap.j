.version 50 0 
.class public super abstract [158] 
.super [160] 
.field protected static final [161] [162] 
.field protected static final [163] [164] 
.field private final [165] [166] 
.field private [167] [168] 
.field private [169] [170] 
.field protected [171] [172] 
.field private [173] [174] 

.method public [176] : [177] 
    .attribute [175] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     new [27] 
L8:     dup 
L9:     invokespecial [22] 
L12:    putfield [28] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [29] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [30] 
L25:    aload_0 
L26:    iload_1 
L27:    putfield [31] 
L30:    aload_0 
L31:    aload_0 
L32:    getfield [15] 
L35:    newarray int 
L37:    putfield [32] 
L40:    aload_0 
L41:    getfield [16] 
L44:    ldc [3] 
L46:    invokestatic [4] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [178] : [179] 
    .attribute [175] .code stack 2 locals 5 
L0:     aload_0 
L1:     getfield [12] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L118 using L121 
L7:     iload_1 
L8:     aload_0 
L9:     getfield [15] 
L12:    if_icmpeq L116 
L15:    aload_0 
L16:    iload_1 
L17:    invokespecial [23] 
L20:    aload_0 
L21:    iload_1 
L22:    invokevirtual [17] 
L25:    iload_1 
L26:    aload_0 
L27:    getfield [15] 
L30:    if_icmpge L92 
L33:    iconst_0 
L34:    istore_3 
L35:    iload_1 
L36:    istore 4 
L38:    aload_0 
L39:    getfield [16] 
L42:    arraylength 
L43:    istore 5 
L45:    iload 5 
L47:    iflt L78 
L50:    aload_0 
L51:    getfield [16] 
L54:    iload 5 
L56:    iaload 
L57:    ldc [3] 
L59:    if_icmpeq L68 
L62:    iinc 3 1 
L65:    goto L72 
L68:    iload 5 
L70:    istore 4 
L72:    iinc 5 -1 
L75:    goto L45 
L78:    aload_0 
L79:    iload_3 
L80:    putfield [29] 
L83:    aload_0 
L84:    iload 4 
L86:    putfield [30] 
L89:    goto L111 
L92:    aload_0 
L93:    getfield [14] 
L96:    aload_0 
L97:    getfield [15] 
L100:   if_icmple L111 
L103:   aload_0 
L104:   aload_0 
L105:   getfield [15] 
L108:   putfield [30] 
L111:   aload_0 
L112:   iload_1 
L113:   putfield [31] 
L116:   aload_2 
L117:   monitorexit 
L118:   goto L128 
        .catch [0] from L121 to L125 using L121 
L121:   astore 6 
L123:   aload_2 
L124:   monitorexit 
L125:   aload 6 
L127:   athrow 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method private [180] : [181] 
    .attribute [175] .code stack 5 locals 1 
L0:     iload_1 
L1:     newarray int 
L3:     astore_2 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [16] 
L9:     arraylength 
L10:    if_icmple L49 
L13:    aload_0 
L14:    getfield [16] 
L17:    iconst_0 
L18:    aload_2 
L19:    iconst_0 
L20:    aload_0 
L21:    getfield [16] 
L24:    arraylength 
L25:    invokestatic [5] 
L28:    aload_2 
L29:    aload_0 
L30:    getfield [16] 
L33:    arraylength 
L34:    aload_2 
L35:    arraylength 
L36:    ldc [3] 
L38:    invokestatic [6] 
L41:    aload_0 
L42:    aload_2 
L43:    putfield [32] 
L46:    goto L75 
L49:    iload_1 
L50:    aload_0 
L51:    getfield [16] 
L54:    arraylength 
L55:    if_icmpge L75 
L58:    aload_0 
L59:    getfield [16] 
L62:    iconst_0 
L63:    aload_2 
L64:    iconst_0 
L65:    aload_2 
L66:    arraylength 
L67:    invokestatic [5] 
L70:    aload_0 
L71:    aload_2 
L72:    putfield [32] 
L75:    return 
L76:    
    .end code 
.end method 

.method protected abstract [182] : [183] 
    .attribute [175] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public interface [184] : [185] 
    .attribute [175] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [186] : [187] 
    .attribute [175] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [175] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifne L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [175] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     invokevirtual [18] 
L8:     aload_0 
L9:     iconst_0 
L10:    putfield [29] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [30] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [192] : [193] 
    .attribute [175] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     invokestatic [4] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [194] : [195] 
    .attribute [175] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     iload_1 
L5:     ldc [3] 
L7:     iastore 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected abstract [196] : [197] 
    .attribute [175] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [198] : [199] 
    .attribute [175] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [175] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [13] 
L4:     newarray int 
L6:     astore_1 
L7:     iconst_0 
L8:     istore_2 
L9:     iconst_0 
L10:    istore_3 
L11:    iload_3 
L12:    aload_0 
L13:    getfield [16] 
L16:    arraylength 
L17:    if_icmpge L49 
L20:    aload_0 
L21:    getfield [16] 
L24:    iload_3 
L25:    iaload 
L26:    ldc [3] 
L28:    if_icmpeq L43 
L31:    aload_1 
L32:    iload_2 
L33:    aload_0 
L34:    getfield [16] 
L37:    iload_3 
L38:    iaload 
L39:    iastore 
L40:    iinc 2 1 
L43:    iinc 3 1 
L46:    goto L11 
L49:    aload_1 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected [202] : [203] 
    .attribute [175] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_0 
L4:     getfield [16] 
L7:     arraylength 
L8:     if_icmpge L29 
L11:    aload_0 
L12:    getfield [16] 
L15:    iload_2 
L16:    iaload 
L17:    iload_1 
L18:    if_icmpne L23 
L21:    iload_2 
L22:    areturn 
L23:    iinc 2 1 
L26:    goto L2 
L29:    iconst_m1 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [204] : [205] 
    .attribute [175] .code stack 4 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [19] 
L5:     istore_2 
L6:     iload_2 
L7:     iconst_m1 
L8:     if_icmpne L101 
L11:    aload_0 
L12:    getfield [14] 
L15:    aload_0 
L16:    getfield [15] 
L19:    if_icmplt L53 
L22:    aload_0 
L23:    getfield [15] 
L26:    iconst_2 
L27:    if_icmpge L38 
L30:    aload_0 
L31:    iconst_2 
L32:    invokespecial [25] 
L35:    goto L53 
L38:    aload_0 
L39:    aload_0 
L40:    getfield [15] 
L43:    aload_0 
L44:    getfield [15] 
L47:    iconst_2 
L48:    idiv 
L49:    iadd 
L50:    invokespecial [25] 
L53:    aload_0 
L54:    getfield [14] 
L57:    istore_2 
L58:    aload_0 
L59:    getfield [16] 
L62:    iload_2 
L63:    iload_1 
L64:    iastore 
L65:    aload_0 
L66:    dup 
L67:    getfield [13] 
L70:    iconst_1 
L71:    iadd 
L72:    putfield [29] 
L75:    aload_0 
L76:    aload_0 
L77:    ldc [3] 
L79:    invokevirtual [19] 
L82:    putfield [30] 
L85:    aload_0 
L86:    getfield [14] 
L89:    iconst_m1 
L90:    if_icmpne L101 
L93:    aload_0 
L94:    aload_0 
L95:    getfield [15] 
L98:    putfield [30] 
L101:   iload_2 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [175] .code stack 3 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [19] 
L5:     istore_2 
L6:     iload_2 
L7:     iconst_m1 
L8:     if_icmpeq L44 
L11:    aload_0 
L12:    iload_2 
L13:    invokevirtual [20] 
L16:    aload_0 
L17:    iload_2 
L18:    invokevirtual [21] 
L21:    aload_0 
L22:    dup 
L23:    getfield [13] 
L26:    iconst_1 
L27:    isub 
L28:    putfield [29] 
L31:    iload_2 
L32:    aload_0 
L33:    getfield [14] 
L36:    if_icmpge L44 
L39:    aload_0 
L40:    iload_2 
L41:    putfield [30] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method protected final [208] : [209] 
    .attribute [175] .code stack 3 locals 0 
L0:     iload_1 
L1:     ldc [3] 
L3:     if_icmpne L16 
L6:     new [33] 
L9:     dup 
L10:    ldc [8] 
L12:    invokespecial [26] 
L15:    athrow 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Int 128 
.const [4] = Method [35] [36] 
.const [5] = Method [37] [38] 
.const [6] = Method [39] [40] 
.const [7] = Class [41] 
.const [8] = String [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Field [46] [47] 
.const [13] = Field [48] [49] 
.const [14] = Field [50] [51] 
.const [15] = Field [52] [53] 
.const [16] = Field [54] [55] 
.const [17] = Method [56] [57] 
.const [18] = Method [58] [59] 
.const [19] = Method [60] [61] 
.const [20] = Method [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Class [76] 
.const [28] = Field [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Class [87] 
.const [34] = Utf8 java/lang/Object 
.const [35] = Class [88] 
.const [36] = NameAndType [89] [90] 
.const [37] = Class [91] 
.const [38] = NameAndType [92] [93] 
.const [39] = Class [94] 
.const [40] = NameAndType [95] [96] 
.const [41] = Utf8 java/lang/IllegalArgumentException 
.const [42] = Utf8 'Free entry marker is used as key or value!' 
.const [43] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [44] = Utf8 java/util/Arrays 
.const [45] = Utf8 java/lang/System 
.const [46] = Class [97] 
.const [47] = NameAndType [98] [99] 
.const [48] = Class [100] 
.const [49] = NameAndType [101] [102] 
.const [50] = Class [103] 
.const [51] = NameAndType [104] [105] 
.const [52] = Class [106] 
.const [53] = NameAndType [107] [108] 
.const [54] = Class [109] 
.const [55] = NameAndType [110] [111] 
.const [56] = Class [112] 
.const [57] = NameAndType [113] [114] 
.const [58] = Class [115] 
.const [59] = NameAndType [116] [117] 
.const [60] = Class [118] 
.const [61] = NameAndType [119] [120] 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Class [148] 
.const [82] = NameAndType [149] [150] 
.const [83] = Class [151] 
.const [84] = NameAndType [152] [153] 
.const [85] = Class [154] 
.const [86] = NameAndType [155] [156] 
.const [87] = Utf8 java/lang/IllegalArgumentException 
.const [88] = Utf8 java/util/Arrays 
.const [89] = Utf8 fill 
.const [90] = Utf8 ([II)V 
.const [91] = Utf8 java/lang/System 
.const [92] = Utf8 arraycopy 
.const [93] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [94] = Utf8 java/util/Arrays 
.const [95] = Utf8 fill 
.const [96] = Utf8 ([IIII)V 
.const [97] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [98] = Utf8 mutex 
.const [99] = Utf8 Ljava/lang/Object; 
.const [100] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [101] = Utf8 mappings 
.const [102] = Utf8 I 
.const [103] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [104] = Utf8 nextFreeIndex 
.const [105] = Utf8 I 
.const [106] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [107] = Utf8 capacity 
.const [108] = Utf8 I 
.const [109] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [110] = Utf8 keys 
.const [111] = Utf8 [I 
.const [112] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [113] = Utf8 resizeValueArray 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [116] = Utf8 clearValues 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [119] = Utf8 getKeyIndex 
.const [120] = Utf8 (I)I 
.const [121] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [122] = Utf8 clearKey 
.const [123] = Utf8 (I)V 
.const [124] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [125] = Utf8 clearValue 
.const [126] = Utf8 (I)V 
.const [127] = Utf8 java/lang/Object 
.const [128] = Utf8 <init> 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [131] = Utf8 resizeKeyArray 
.const [132] = Utf8 (I)V 
.const [133] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [134] = Utf8 clearKeys 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [137] = Utf8 resize 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 java/lang/IllegalArgumentException 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Ljava/lang/String;)V 
.const [142] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [143] = Utf8 mutex 
.const [144] = Utf8 Ljava/lang/Object; 
.const [145] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [146] = Utf8 mappings 
.const [147] = Utf8 I 
.const [148] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [149] = Utf8 nextFreeIndex 
.const [150] = Utf8 I 
.const [151] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [152] = Utf8 capacity 
.const [153] = Utf8 I 
.const [154] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [155] = Utf8 keys 
.const [156] = Utf8 [I 
.const [157] = Utf8 de/esolutions/fw/util/commons/AbstractSimpleIntMap 
.const [158] = Class [157] 
.const [159] = Utf8 java/lang/Object 
.const [160] = Class [159] 
.const [161] = Utf8 DEFAULT_SIZE 
.const [162] = Utf8 I 
.const [163] = Utf8 FREE_ENTRY_MARKER 
.const [164] = Utf8 I 
.const [165] = Utf8 mutex 
.const [166] = Utf8 Ljava/lang/Object; 
.const [167] = Utf8 capacity 
.const [168] = Utf8 I 
.const [169] = Utf8 mappings 
.const [170] = Utf8 I 
.const [171] = Utf8 keys 
.const [172] = Utf8 [I 
.const [173] = Utf8 nextFreeIndex 
.const [174] = Utf8 I 
.const [175] = Utf8 Code 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 resize 
.const [179] = Utf8 (I)V 
.const [180] = Utf8 resizeKeyArray 
.const [181] = Utf8 (I)V 
.const [182] = Utf8 resizeValueArray 
.const [183] = Utf8 (I)V 
.const [184] = Utf8 getCapacity 
.const [185] = Utf8 ()I 
.const [186] = Utf8 size 
.const [187] = Utf8 ()I 
.const [188] = Utf8 isEmpty 
.const [189] = Utf8 ()Z 
.const [190] = Utf8 clear 
.const [191] = Utf8 ()V 
.const [192] = Utf8 clearKeys 
.const [193] = Utf8 ()V 
.const [194] = Utf8 clearKey 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 clearValues 
.const [197] = Utf8 ()V 
.const [198] = Utf8 clearValue 
.const [199] = Utf8 (I)V 
.const [200] = Utf8 getKeys 
.const [201] = Utf8 ()[I 
.const [202] = Utf8 getKeyIndex 
.const [203] = Utf8 (I)I 
.const [204] = Utf8 addKey 
.const [205] = Utf8 (I)I 
.const [206] = Utf8 remove 
.const [207] = Utf8 (I)V 
.const [208] = Utf8 checkFreeEntryMarker 
.const [209] = Utf8 (I)V 
.end class 
