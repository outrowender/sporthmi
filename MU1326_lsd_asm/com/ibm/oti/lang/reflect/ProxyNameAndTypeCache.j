.version 50 0 
.class super [138] 
.super [140] 
.field [141] [142] 
.field [143] [144] 
.field [145] [146] 
.field [147] [148] 

.method [150] : [151] 
    .attribute [149] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     iload_1 
L5:     bipush 13 
L7:     if_icmpge L13 
L10:    bipush 13 
L12:    istore_1 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [27] 
L18:    aload_0 
L19:    iload_1 
L20:    i2f 
L21:    ldc [4] 
L23:    fmul 
L24:    f2i 
L25:    putfield [28] 
L28:    aload_0 
L29:    iload_1 
L30:    multianewarray [5] 1 
L34:    putfield [29] 
L37:    aload_0 
L38:    iload_1 
L39:    newarray int 
L41:    putfield [30] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method [152] : [153] 
    .attribute [149] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [15] 
L5:     istore_2 
L6:     goto L54 
L9:     aload_0 
L10:    getfield [13] 
L13:    iload_2 
L14:    aaload 
L15:    iconst_0 
L16:    iaload 
L17:    aload_1 
L18:    iconst_0 
L19:    iaload 
L20:    if_icmpne L44 
L23:    aload_0 
L24:    getfield [13] 
L27:    iload_2 
L28:    aaload 
L29:    iconst_1 
L30:    iaload 
L31:    aload_1 
L32:    iconst_1 
L33:    iaload 
L34:    if_icmpne L44 
L37:    aload_0 
L38:    getfield [14] 
L41:    iload_2 
L42:    iaload 
L43:    areturn 
L44:    iload_2 
L45:    iconst_1 
L46:    iadd 
L47:    aload_0 
L48:    getfield [13] 
L51:    arraylength 
L52:    irem 
L53:    istore_2 
L54:    aload_0 
L55:    getfield [13] 
L58:    iload_2 
L59:    aaload 
L60:    ifnonnull L9 
L63:    iconst_m1 
L64:    areturn 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method [154] : [155] 
    .attribute [149] .code stack 3 locals 0 
L0:     aload_1 
L1:     iconst_0 
L2:     iaload 
L3:     aload_1 
L4:     iconst_1 
L5:     iaload 
L6:     iadd 
L7:     aload_0 
L8:     getfield [13] 
L11:    arraylength 
L12:    irem 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [156] : [157] 
    .attribute [149] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [15] 
L5:     istore_3 
L6:     goto L56 
L9:     aload_0 
L10:    getfield [13] 
L13:    iload_3 
L14:    aaload 
L15:    iconst_0 
L16:    iaload 
L17:    aload_1 
L18:    iconst_0 
L19:    iaload 
L20:    if_icmpne L46 
L23:    aload_0 
L24:    getfield [13] 
L27:    iload_3 
L28:    aaload 
L29:    iconst_1 
L30:    iaload 
L31:    aload_1 
L32:    iconst_1 
L33:    iaload 
L34:    if_icmpne L46 
L37:    aload_0 
L38:    getfield [14] 
L41:    iload_3 
L42:    iload_2 
L43:    dup_x2 
L44:    iastore 
L45:    areturn 
L46:    iload_3 
L47:    iconst_1 
L48:    iadd 
L49:    aload_0 
L50:    getfield [13] 
L53:    arraylength 
L54:    irem 
L55:    istore_3 
L56:    aload_0 
L57:    getfield [13] 
L60:    iload_3 
L61:    aaload 
L62:    ifnonnull L9 
L65:    aload_0 
L66:    getfield [13] 
L69:    iload_3 
L70:    aload_1 
L71:    aastore 
L72:    aload_0 
L73:    getfield [14] 
L76:    iload_3 
L77:    iload_2 
L78:    iastore 
L79:    aload_0 
L80:    dup 
L81:    getfield [11] 
L84:    iconst_1 
L85:    iadd 
L86:    dup_x1 
L87:    putfield [27] 
L90:    aload_0 
L91:    getfield [12] 
L94:    if_icmple L101 
L97:    aload_0 
L98:    invokespecial [23] 
L101:   iload_2 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method private [158] : [159] 
    .attribute [149] .code stack 4 locals 2 
L0:     new [26] 
L3:     dup 
L4:     aload_0 
L5:     getfield [13] 
L8:     arraylength 
L9:     iconst_2 
L10:    imul 
L11:    invokespecial [24] 
L14:    astore_1 
L15:    aload_0 
L16:    getfield [13] 
L19:    arraylength 
L20:    istore_2 
L21:    goto L50 
L24:    aload_0 
L25:    getfield [13] 
L28:    iload_2 
L29:    aaload 
L30:    ifnull L50 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [13] 
L38:    iload_2 
L39:    aaload 
L40:    aload_0 
L41:    getfield [14] 
L44:    iload_2 
L45:    iaload 
L46:    invokevirtual [16] 
L49:    pop 
L50:    iinc 2 -1 
L53:    iload_2 
L54:    ifge L24 
L57:    aload_0 
L58:    aload_1 
L59:    getfield [13] 
L62:    putfield [29] 
L65:    aload_0 
L66:    aload_1 
L67:    getfield [14] 
L70:    putfield [30] 
L73:    aload_0 
L74:    aload_1 
L75:    getfield [12] 
L78:    putfield [28] 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method interface [160] : [161] 
    .attribute [149] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [149] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokevirtual [17] 
L4:     istore_1 
L5:     new [31] 
L8:     dup 
L9:     invokespecial [25] 
L12:    astore_2 
L13:    aload_2 
L14:    ldc [7] 
L16:    invokevirtual [18] 
L19:    pop 
L20:    iconst_0 
L21:    istore_3 
L22:    goto L74 
L25:    aload_0 
L26:    getfield [13] 
L29:    iload_3 
L30:    aaload 
L31:    ifnull L59 
L34:    aload_2 
L35:    aload_0 
L36:    getfield [13] 
L39:    iload_3 
L40:    aaload 
L41:    invokevirtual [19] 
L44:    ldc [8] 
L46:    invokevirtual [18] 
L49:    aload_0 
L50:    getfield [14] 
L53:    iload_3 
L54:    iaload 
L55:    invokevirtual [20] 
L58:    pop 
L59:    iload_3 
L60:    iload_1 
L61:    if_icmpge L71 
L64:    aload_2 
L65:    ldc [9] 
L67:    invokevirtual [18] 
L70:    pop 
L71:    iinc 3 1 
L74:    iload_3 
L75:    iload_1 
L76:    if_icmplt L25 
L79:    aload_2 
L80:    ldc [10] 
L82:    invokevirtual [18] 
L85:    pop 
L86:    aload_2 
L87:    invokevirtual [21] 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Int -1007343553 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = String [36] 
.const [8] = String [37] 
.const [9] = String [38] 
.const [10] = String [39] 
.const [11] = Field [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Method [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Class [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Class [79] 
.const [32] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 [[I 
.const [35] = Utf8 java/lang/StringBuffer 
.const [36] = Utf8 '{' 
.const [37] = Utf8 '->' 
.const [38] = Utf8 ', ' 
.const [39] = Utf8 '}' 
.const [40] = Class [80] 
.const [41] = NameAndType [81] [82] 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Class [110] 
.const [61] = NameAndType [111] [112] 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Class [116] 
.const [65] = NameAndType [117] [118] 
.const [66] = Class [119] 
.const [67] = NameAndType [120] [121] 
.const [68] = Class [122] 
.const [69] = NameAndType [123] [124] 
.const [70] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [81] = Utf8 elementSize 
.const [82] = Utf8 I 
.const [83] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [84] = Utf8 threshold 
.const [85] = Utf8 I 
.const [86] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [87] = Utf8 keyTable 
.const [88] = Utf8 [[I 
.const [89] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [90] = Utf8 valueTable 
.const [91] = Utf8 [I 
.const [92] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [93] = Utf8 hashCode 
.const [94] = Utf8 ([I)I 
.const [95] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [96] = Utf8 put 
.const [97] = Utf8 ([II)I 
.const [98] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [99] = Utf8 size 
.const [100] = Utf8 ()I 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Utf8 append 
.const [103] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [104] = Utf8 java/lang/StringBuffer 
.const [105] = Utf8 append 
.const [106] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 append 
.const [109] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 toString 
.const [112] = Utf8 ()Ljava/lang/String; 
.const [113] = Utf8 java/lang/Object 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [117] = Utf8 rehash 
.const [118] = Utf8 ()V 
.const [119] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (I)V 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [126] = Utf8 elementSize 
.const [127] = Utf8 I 
.const [128] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [129] = Utf8 threshold 
.const [130] = Utf8 I 
.const [131] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [132] = Utf8 keyTable 
.const [133] = Utf8 [[I 
.const [134] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [135] = Utf8 valueTable 
.const [136] = Utf8 [I 
.const [137] = Utf8 com/ibm/oti/lang/reflect/ProxyNameAndTypeCache 
.const [138] = Class [137] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [139] 
.const [141] = Utf8 keyTable 
.const [142] = Utf8 [[I 
.const [143] = Utf8 valueTable 
.const [144] = Utf8 [I 
.const [145] = Utf8 elementSize 
.const [146] = Utf8 I 
.const [147] = Utf8 threshold 
.const [148] = Utf8 I 
.const [149] = Utf8 Code 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (I)V 
.const [152] = Utf8 get 
.const [153] = Utf8 ([I)I 
.const [154] = Utf8 hashCode 
.const [155] = Utf8 ([I)I 
.const [156] = Utf8 put 
.const [157] = Utf8 ([II)I 
.const [158] = Utf8 rehash 
.const [159] = Utf8 ()V 
.const [160] = Utf8 size 
.const [161] = Utf8 ()I 
.const [162] = Utf8 toString 
.const [163] = Utf8 ()Ljava/lang/String; 
.end class 
