.version 50 0 
.class super [145] 
.super [147] 
.field [148] [149] 
.field [150] [151] 
.field [152] [153] 
.field [154] [155] 

.method static [157] : [158] 
    .attribute [156] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_0 
L8:     ifnull L15 
L11:    aload_1 
L12:    ifnonnull L17 
L15:    iconst_0 
L16:    areturn 
L17:    aload_0 
L18:    arraylength 
L19:    aload_1 
L20:    arraylength 
L21:    if_icmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_0 
L27:    arraylength 
L28:    istore_2 
L29:    goto L43 
L32:    aload_0 
L33:    iload_2 
L34:    caload 
L35:    aload_1 
L36:    iload_2 
L37:    caload 
L38:    if_icmpeq L43 
L41:    iconst_0 
L42:    areturn 
L43:    iinc 2 -1 
L46:    iload_2 
L47:    ifge L32 
L50:    iconst_1 
L51:    areturn 
L52:    
    .end code 
.end method 

.method [159] : [160] 
    .attribute [156] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     iload_1 
L5:     bipush 13 
L7:     if_icmpge L13 
L10:    bipush 13 
L12:    istore_1 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [29] 
L18:    aload_0 
L19:    iload_1 
L20:    i2f 
L21:    ldc [4] 
L23:    fmul 
L24:    f2i 
L25:    putfield [30] 
L28:    aload_0 
L29:    iload_1 
L30:    multianewarray [5] 1 
L34:    putfield [31] 
L37:    aload_0 
L38:    iload_1 
L39:    newarray int 
L41:    putfield [32] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method [161] : [162] 
    .attribute [156] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [24] 
L5:     istore_2 
L6:     goto L39 
L9:     aload_0 
L10:    getfield [15] 
L13:    iload_2 
L14:    aaload 
L15:    aload_1 
L16:    invokestatic [6] 
L19:    ifeq L29 
L22:    aload_0 
L23:    getfield [16] 
L26:    iload_2 
L27:    iaload 
L28:    areturn 
L29:    iload_2 
L30:    iconst_1 
L31:    iadd 
L32:    aload_0 
L33:    getfield [15] 
L36:    arraylength 
L37:    irem 
L38:    istore_2 
L39:    aload_0 
L40:    getfield [15] 
L43:    iload_2 
L44:    aaload 
L45:    ifnonnull L9 
L48:    iconst_m1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [156] .code stack 3 locals 4 
L0:     aload_1 
L1:     arraylength 
L2:     istore_2 
L3:     iconst_0 
L4:     istore_3 
L5:     iconst_2 
L6:     istore 4 
L8:     iconst_0 
L9:     istore 5 
L11:    goto L28 
L14:    iload_3 
L15:    aload_1 
L16:    iload 5 
L18:    caload 
L19:    iadd 
L20:    istore_3 
L21:    iload 5 
L23:    iload 4 
L25:    iadd 
L26:    istore 5 
L28:    iload 5 
L30:    iload_2 
L31:    if_icmplt L14 
L34:    iload_3 
L35:    ldc [7] 
L37:    iand 
L38:    aload_0 
L39:    getfield [15] 
L42:    arraylength 
L43:    irem 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method [165] : [166] 
    .attribute [156] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [24] 
L5:     istore_3 
L6:     goto L41 
L9:     aload_0 
L10:    getfield [15] 
L13:    iload_3 
L14:    aaload 
L15:    aload_1 
L16:    invokestatic [6] 
L19:    ifeq L31 
L22:    aload_0 
L23:    getfield [16] 
L26:    iload_3 
L27:    iload_2 
L28:    dup_x2 
L29:    iastore 
L30:    areturn 
L31:    iload_3 
L32:    iconst_1 
L33:    iadd 
L34:    aload_0 
L35:    getfield [15] 
L38:    arraylength 
L39:    irem 
L40:    istore_3 
L41:    aload_0 
L42:    getfield [15] 
L45:    iload_3 
L46:    aaload 
L47:    ifnonnull L9 
L50:    aload_0 
L51:    getfield [15] 
L54:    iload_3 
L55:    aload_1 
L56:    aastore 
L57:    aload_0 
L58:    getfield [16] 
L61:    iload_3 
L62:    iload_2 
L63:    iastore 
L64:    aload_0 
L65:    dup 
L66:    getfield [13] 
L69:    iconst_1 
L70:    iadd 
L71:    dup_x1 
L72:    putfield [29] 
L75:    aload_0 
L76:    getfield [14] 
L79:    if_icmple L86 
L82:    aload_0 
L83:    invokespecial [25] 
L86:    iload_2 
L87:    areturn 
L88:    
    .end code 
.end method 

.method private [167] : [168] 
    .attribute [156] .code stack 4 locals 2 
L0:     new [28] 
L3:     dup 
L4:     aload_0 
L5:     getfield [15] 
L8:     arraylength 
L9:     iconst_2 
L10:    imul 
L11:    invokespecial [26] 
L14:    astore_1 
L15:    aload_0 
L16:    getfield [15] 
L19:    arraylength 
L20:    istore_2 
L21:    goto L50 
L24:    aload_0 
L25:    getfield [15] 
L28:    iload_2 
L29:    aaload 
L30:    ifnull L50 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [15] 
L38:    iload_2 
L39:    aaload 
L40:    aload_0 
L41:    getfield [16] 
L44:    iload_2 
L45:    iaload 
L46:    invokevirtual [17] 
L49:    pop 
L50:    iinc 2 -1 
L53:    iload_2 
L54:    ifge L24 
L57:    aload_0 
L58:    aload_1 
L59:    getfield [15] 
L62:    putfield [31] 
L65:    aload_0 
L66:    aload_1 
L67:    getfield [16] 
L70:    putfield [32] 
L73:    aload_0 
L74:    aload_1 
L75:    getfield [14] 
L78:    putfield [30] 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method interface [169] : [170] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [156] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokevirtual [18] 
L4:     istore_1 
L5:     new [33] 
L8:     dup 
L9:     invokespecial [27] 
L12:    astore_2 
L13:    aload_2 
L14:    ldc [9] 
L16:    invokevirtual [19] 
L19:    pop 
L20:    iconst_0 
L21:    istore_3 
L22:    goto L74 
L25:    aload_0 
L26:    getfield [15] 
L29:    iload_3 
L30:    aaload 
L31:    ifnull L59 
L34:    aload_2 
L35:    aload_0 
L36:    getfield [15] 
L39:    iload_3 
L40:    aaload 
L41:    invokevirtual [20] 
L44:    ldc [10] 
L46:    invokevirtual [19] 
L49:    aload_0 
L50:    getfield [16] 
L53:    iload_3 
L54:    iaload 
L55:    invokevirtual [21] 
L58:    pop 
L59:    iload_3 
L60:    iload_1 
L61:    if_icmpge L71 
L64:    aload_2 
L65:    ldc [11] 
L67:    invokevirtual [19] 
L70:    pop 
L71:    iinc 3 1 
L74:    iload_3 
L75:    iload_1 
L76:    if_icmplt L25 
L79:    aload_2 
L80:    ldc [12] 
L82:    invokevirtual [19] 
L85:    pop 
L86:    aload_2 
L87:    invokevirtual [22] 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Int -1007343553 
.const [5] = Class [36] 
.const [6] = Method [37] [38] 
.const [7] = Int -129 
.const [8] = Class [39] 
.const [9] = String [40] 
.const [10] = String [41] 
.const [11] = String [42] 
.const [12] = String [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Field [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Class [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Class [83] 
.const [34] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 [[C 
.const [37] = Class [84] 
.const [38] = NameAndType [85] [86] 
.const [39] = Utf8 java/lang/StringBuffer 
.const [40] = Utf8 '{' 
.const [41] = Utf8 '->' 
.const [42] = Utf8 ', ' 
.const [43] = Utf8 '}' 
.const [44] = Class [87] 
.const [45] = NameAndType [88] [89] 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [85] = Utf8 equals 
.const [86] = Utf8 ([C[C)Z 
.const [87] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [88] = Utf8 elementSize 
.const [89] = Utf8 I 
.const [90] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [91] = Utf8 threshold 
.const [92] = Utf8 I 
.const [93] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [94] = Utf8 keyTable 
.const [95] = Utf8 [[C 
.const [96] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [97] = Utf8 valueTable 
.const [98] = Utf8 [I 
.const [99] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [100] = Utf8 put 
.const [101] = Utf8 ([CI)I 
.const [102] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [103] = Utf8 size 
.const [104] = Utf8 ()I 
.const [105] = Utf8 java/lang/StringBuffer 
.const [106] = Utf8 append 
.const [107] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 append 
.const [110] = Utf8 ([C)Ljava/lang/StringBuffer; 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 append 
.const [113] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 toString 
.const [116] = Utf8 ()Ljava/lang/String; 
.const [117] = Utf8 java/lang/Object 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [121] = Utf8 hashCodeChar 
.const [122] = Utf8 ([C)I 
.const [123] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [124] = Utf8 rehash 
.const [125] = Utf8 ()V 
.const [126] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (I)V 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [133] = Utf8 elementSize 
.const [134] = Utf8 I 
.const [135] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [136] = Utf8 threshold 
.const [137] = Utf8 I 
.const [138] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [139] = Utf8 keyTable 
.const [140] = Utf8 [[C 
.const [141] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [142] = Utf8 valueTable 
.const [143] = Utf8 [I 
.const [144] = Utf8 com/ibm/oti/lang/reflect/ProxyCharArrayCache 
.const [145] = Class [144] 
.const [146] = Utf8 java/lang/Object 
.const [147] = Class [146] 
.const [148] = Utf8 keyTable 
.const [149] = Utf8 [[C 
.const [150] = Utf8 valueTable 
.const [151] = Utf8 [I 
.const [152] = Utf8 elementSize 
.const [153] = Utf8 I 
.const [154] = Utf8 threshold 
.const [155] = Utf8 I 
.const [156] = Utf8 Code 
.const [157] = Utf8 equals 
.const [158] = Utf8 ([C[C)Z 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (I)V 
.const [161] = Utf8 get 
.const [162] = Utf8 ([C)I 
.const [163] = Utf8 hashCodeChar 
.const [164] = Utf8 ([C)I 
.const [165] = Utf8 put 
.const [166] = Utf8 ([CI)I 
.const [167] = Utf8 rehash 
.const [168] = Utf8 ()V 
.const [169] = Utf8 size 
.const [170] = Utf8 ()I 
.const [171] = Utf8 toString 
.const [172] = Utf8 ()Ljava/lang/String; 
.end class 
