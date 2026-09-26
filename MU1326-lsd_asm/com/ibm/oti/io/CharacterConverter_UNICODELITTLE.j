.version 50 0 
.class public super [61] 
.super [63] 
.field [64] [65] 
.field [66] [67] 
.field [68] [69] 

.method public [71] : [72] 
    .attribute [70] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [12] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [13] 
L14:    aload_0 
L15:    iconst_1 
L16:    putfield [14] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [70] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [14] 
L5:     aload_0 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [70] .code stack 3 locals 1 
L0:     iload_3 
L1:     ifge L12 
L4:     new [15] 
L7:     dup 
L8:     invokespecial [11] 
L11:    athrow 
L12:    iload_3 
L13:    iconst_2 
L14:    if_icmpge L19 
L17:    iconst_0 
L18:    areturn 
L19:    aload_0 
L20:    getfield [7] 
L23:    ifeq L82 
L26:    aload_1 
L27:    iload_2 
L28:    iconst_1 
L29:    iadd 
L30:    baload 
L31:    sipush 255 
L34:    iand 
L35:    bipush 8 
L37:    ishl 
L38:    aload_1 
L39:    iload_2 
L40:    baload 
L41:    sipush 255 
L44:    iand 
L45:    iadd 
L46:    istore 4 
L48:    iload 4 
L50:    ldc [5] 
L52:    if_icmpne L61 
L55:    iload_3 
L56:    iconst_2 
L57:    idiv 
L58:    iconst_1 
L59:    isub 
L60:    areturn 
L61:    iload 4 
L63:    ldc [6] 
L65:    if_icmpne L70 
L68:    iconst_m1 
L69:    areturn 
L70:    aload_0 
L71:    getfield [9] 
L74:    ifeq L82 
L77:    aload_0 
L78:    iconst_0 
L79:    putfield [12] 
L82:    iload_3 
L83:    iconst_2 
L84:    idiv 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [70] .code stack 5 locals 2 
L0:     iload 5 
L2:     ifne L7 
L5:     iload_2 
L6:     areturn 
L7:     aload_0 
L8:     getfield [7] 
L11:    ifeq L29 
L14:    iinc 2 2 
L17:    aload_0 
L18:    getfield [9] 
L21:    ifeq L29 
L24:    aload_0 
L25:    iconst_0 
L26:    putfield [12] 
L29:    iload_2 
L30:    iload 5 
L32:    iconst_1 
L33:    ishl 
L34:    iadd 
L35:    istore 6 
L37:    iload_2 
L38:    istore 7 
L40:    goto L76 
L43:    aload_3 
L44:    iload 4 
L46:    iinc 4 1 
L49:    aload_1 
L50:    iload 7 
L52:    iconst_1 
L53:    iadd 
L54:    baload 
L55:    sipush 255 
L58:    iand 
L59:    bipush 8 
L61:    ishl 
L62:    aload_1 
L63:    iload 7 
L65:    baload 
L66:    sipush 255 
L69:    iand 
L70:    iadd 
L71:    i2c 
L72:    castore 
L73:    iinc 7 2 
L76:    iload 7 
L78:    iload 6 
L80:    if_icmplt L43 
L83:    iload 6 
L85:    areturn 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [70] .code stack 4 locals 5 
L0:     iload_3 
L1:     iconst_1 
L2:     ishl 
L3:     aload_0 
L4:     getfield [8] 
L7:     ifeq L14 
L10:    iconst_2 
L11:    goto L15 
L14:    iconst_0 
L15:    iadd 
L16:    istore 4 
L18:    iload 4 
L20:    newarray byte 
L22:    astore 5 
L24:    iconst_0 
L25:    istore 6 
L27:    aload_0 
L28:    getfield [8] 
L31:    ifeq L65 
L34:    aload 5 
L36:    iload 6 
L38:    iinc 6 1 
L41:    iconst_m1 
L42:    bastore 
L43:    aload 5 
L45:    iload 6 
L47:    iinc 6 1 
L50:    bipush -2 
L52:    bastore 
L53:    aload_0 
L54:    getfield [9] 
L57:    ifeq L65 
L60:    aload_0 
L61:    iconst_0 
L62:    putfield [13] 
L65:    iload_2 
L66:    iload_3 
L67:    iadd 
L68:    istore 7 
L70:    iload_2 
L71:    istore 8 
L73:    goto L108 
L76:    aload 5 
L78:    iload 6 
L80:    iinc 6 1 
L83:    aload_1 
L84:    iload 8 
L86:    caload 
L87:    i2b 
L88:    bastore 
L89:    aload 5 
L91:    iload 6 
L93:    iinc 6 1 
L96:    aload_1 
L97:    iload 8 
L99:    caload 
L100:   bipush 8 
L102:   ishr 
L103:   i2b 
L104:   bastore 
L105:   iinc 8 1 
L108:   iload 8 
L110:   iload 7 
L112:   if_icmplt L76 
L115:   aload 5 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Int -131072 
.const [6] = Int -16842752 
.const [7] = Field [19] [20] 
.const [8] = Field [21] [22] 
.const [9] = Field [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Field [31] [32] 
.const [14] = Field [33] [34] 
.const [15] = Class [35] 
.const [16] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [17] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [18] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [19] = Class [36] 
.const [20] = NameAndType [37] [38] 
.const [21] = Class [39] 
.const [22] = NameAndType [40] [41] 
.const [23] = Class [42] 
.const [24] = NameAndType [43] [44] 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Class [48] 
.const [28] = NameAndType [49] [50] 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [36] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [37] = Utf8 readTag 
.const [38] = Utf8 Z 
.const [39] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [40] = Utf8 writeTag 
.const [41] = Utf8 Z 
.const [42] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [43] = Utf8 isModal 
.const [44] = Utf8 Z 
.const [45] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [46] = Utf8 <init> 
.const [47] = Utf8 ()V 
.const [48] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [49] = Utf8 <init> 
.const [50] = Utf8 ()V 
.const [51] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [52] = Utf8 readTag 
.const [53] = Utf8 Z 
.const [54] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [55] = Utf8 writeTag 
.const [56] = Utf8 Z 
.const [57] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [58] = Utf8 isModal 
.const [59] = Utf8 Z 
.const [60] = Utf8 com/ibm/oti/io/CharacterConverter_UNICODELITTLE 
.const [61] = Class [60] 
.const [62] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [63] = Class [62] 
.const [64] = Utf8 readTag 
.const [65] = Utf8 Z 
.const [66] = Utf8 writeTag 
.const [67] = Utf8 Z 
.const [68] = Utf8 isModal 
.const [69] = Utf8 Z 
.const [70] = Utf8 Code 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 getModeless 
.const [74] = Utf8 ()Lcom/ibm/oti/io/CharacterConverter; 
.const [75] = Utf8 countChars 
.const [76] = Utf8 ([BII)I 
.const [77] = Utf8 convert 
.const [78] = Utf8 ([BI[CII)I 
.const [79] = Utf8 convert 
.const [80] = Utf8 ([CII)[B 
.end class 
