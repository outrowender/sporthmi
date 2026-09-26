.version 50 0 
.class public super [79] 
.super [81] 
.field [82] [83] 

.method public [85] : [86] 
    .attribute [84] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [87] : [88] 
    .attribute [84] .code stack 4 locals 1 
L0:     iload_3 
L1:     ifge L12 
L4:     new [18] 
L7:     dup 
L8:     invokespecial [13] 
L11:    athrow 
L12:    iload_3 
L13:    iconst_2 
L14:    if_icmpge L19 
L17:    iconst_0 
L18:    areturn 
L19:    aload_0 
L20:    getfield [10] 
L23:    ifeq L86 
L26:    aload_1 
L27:    iload_2 
L28:    baload 
L29:    sipush 255 
L32:    iand 
L33:    bipush 8 
L35:    ishl 
L36:    aload_1 
L37:    iload_2 
L38:    iconst_1 
L39:    iadd 
L40:    baload 
L41:    sipush 255 
L44:    iand 
L45:    iadd 
L46:    istore 5 
L48:    iload 5 
L50:    ldc [5] 
L52:    if_icmpne L66 
L55:    aload 4 
L57:    iconst_0 
L58:    iconst_1 
L59:    bastore 
L60:    iload_3 
L61:    iconst_2 
L62:    idiv 
L63:    iconst_1 
L64:    isub 
L65:    areturn 
L66:    iload 5 
L68:    ldc [6] 
L70:    if_icmpne L84 
L73:    aload 4 
L75:    iconst_0 
L76:    iconst_0 
L77:    bastore 
L78:    iload_3 
L79:    iconst_2 
L80:    idiv 
L81:    iconst_1 
L82:    isub 
L83:    areturn 
L84:    iconst_m1 
L85:    areturn 
L86:    iload_3 
L87:    iconst_2 
L88:    idiv 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method private [89] : [90] 
    .attribute [84] .code stack 6 locals 2 
L0:     iload 5 
L2:     ifne L7 
L5:     iload_2 
L6:     areturn 
L7:     aload_0 
L8:     getfield [10] 
L11:    ifeq L29 
L14:    iinc 2 2 
L17:    aload_0 
L18:    getfield [11] 
L21:    ifeq L29 
L24:    aload_0 
L25:    iconst_0 
L26:    putfield [19] 
L29:    iload_2 
L30:    iload 5 
L32:    iconst_1 
L33:    ishl 
L34:    iadd 
L35:    istore 7 
L37:    iload 6 
L39:    ifeq L91 
L42:    iload_2 
L43:    istore 8 
L45:    goto L81 
L48:    aload_3 
L49:    iload 4 
L51:    iinc 4 1 
L54:    aload_1 
L55:    iload 8 
L57:    baload 
L58:    sipush 255 
L61:    iand 
L62:    bipush 8 
L64:    ishl 
L65:    aload_1 
L66:    iload 8 
L68:    iconst_1 
L69:    iadd 
L70:    baload 
L71:    sipush 255 
L74:    iand 
L75:    iadd 
L76:    i2c 
L77:    castore 
L78:    iinc 8 2 
L81:    iload 8 
L83:    iload 7 
L85:    if_icmplt L48 
L88:    goto L137 
L91:    iload_2 
L92:    istore 8 
L94:    goto L130 
L97:    aload_3 
L98:    iload 4 
L100:   iinc 4 1 
L103:   aload_1 
L104:   iload 8 
L106:   iconst_1 
L107:   iadd 
L108:   baload 
L109:   sipush 255 
L112:   iand 
L113:   bipush 8 
L115:   ishl 
L116:   aload_1 
L117:   iload 8 
L119:   baload 
L120:   sipush 255 
L123:   iand 
L124:   iadd 
L125:   i2c 
L126:   castore 
L127:   iinc 8 2 
L130:   iload 8 
L132:   iload 7 
L134:   if_icmplt L97 
L137:   iload 7 
L139:   areturn 
L140:   
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [84] .code stack 8 locals 3 
L0:     iconst_1 
L1:     newarray boolean 
L3:     astore 4 
L5:     aload_0 
L6:     aload_1 
L7:     iload_2 
L8:     iload_3 
L9:     aload 4 
L11:    invokespecial [14] 
L14:    istore 5 
L16:    iload 5 
L18:    iconst_m1 
L19:    if_icmpne L26 
L22:    iconst_0 
L23:    newarray char 
L25:    areturn 
L26:    iload 5 
L28:    newarray char 
L30:    astore 6 
L32:    aload_0 
L33:    aload_1 
L34:    iload_2 
L35:    aload 6 
L37:    iconst_0 
L38:    iload 5 
L40:    aload 4 
L42:    iconst_0 
L43:    baload 
L44:    invokespecial [15] 
L47:    pop 
L48:    aload 6 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [84] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifne L17 
L7:     new [20] 
L10:    dup 
L11:    ldc [8] 
L13:    invokespecial [16] 
L16:    athrow 
L17:    iconst_1 
L18:    newarray boolean 
L20:    astore 4 
L22:    aload_0 
L23:    aload_1 
L24:    iload_2 
L25:    iload_3 
L26:    aload 4 
L28:    invokespecial [14] 
L31:    istore 5 
L33:    aload_0 
L34:    aload 4 
L36:    iconst_0 
L37:    baload 
L38:    putfield [17] 
L41:    iload 5 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [84] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifne L17 
L7:     new [20] 
L10:    dup 
L11:    ldc [8] 
L13:    invokespecial [16] 
L16:    athrow 
L17:    aload_0 
L18:    aload_1 
L19:    iload_2 
L20:    aload_3 
L21:    iload 4 
L23:    iload 5 
L25:    aload_0 
L26:    getfield [9] 
L29:    invokespecial [15] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Int -131072 
.const [6] = Int -16842752 
.const [7] = Class [24] 
.const [8] = String [25] 
.const [9] = Field [26] [27] 
.const [10] = Field [28] [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Class [44] 
.const [19] = Field [45] [46] 
.const [20] = Class [47] 
.const [21] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [22] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [23] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [24] = Utf8 java/lang/RuntimeException 
.const [25] = Utf8 IllegalStateException 
.const [26] = Class [48] 
.const [27] = NameAndType [49] [50] 
.const [28] = Class [51] 
.const [29] = NameAndType [52] [53] 
.const [30] = Class [54] 
.const [31] = NameAndType [55] [56] 
.const [32] = Class [57] 
.const [33] = NameAndType [58] [59] 
.const [34] = Class [60] 
.const [35] = NameAndType [61] [62] 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Utf8 java/lang/RuntimeException 
.const [48] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [49] = Utf8 bigEndian 
.const [50] = Utf8 Z 
.const [51] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [52] = Utf8 readTag 
.const [53] = Utf8 Z 
.const [54] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [55] = Utf8 isModal 
.const [56] = Utf8 Z 
.const [57] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [64] = Utf8 countChars 
.const [65] = Utf8 ([BII[Z)I 
.const [66] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [67] = Utf8 convert 
.const [68] = Utf8 ([BI[CIIZ)I 
.const [69] = Utf8 java/lang/RuntimeException 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Ljava/lang/String;)V 
.const [72] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [73] = Utf8 bigEndian 
.const [74] = Utf8 Z 
.const [75] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [76] = Utf8 readTag 
.const [77] = Utf8 Z 
.const [78] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODE 
.const [79] = Class [78] 
.const [80] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [81] = Class [80] 
.const [82] = Utf8 bigEndian 
.const [83] = Utf8 Z 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 countChars 
.const [88] = Utf8 ([BII[Z)I 
.const [89] = Utf8 convert 
.const [90] = Utf8 ([BI[CIIZ)I 
.const [91] = Utf8 convert 
.const [92] = Utf8 ([BII)[C 
.const [93] = Utf8 countChars 
.const [94] = Utf8 ([BII)I 
.const [95] = Utf8 convert 
.const [96] = Utf8 ([BI[CII)I 
.end class 
