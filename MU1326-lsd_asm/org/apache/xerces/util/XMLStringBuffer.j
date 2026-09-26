.version 50 0 
.class public super [113] 
.super [115] 
.field public static final [116] [117] 

.method public [119] : [120] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 32 
L3:     invokespecial [18] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     iload_1 
L6:     newarray char 
L8:     putfield [20] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [18] 
L5:     aload_0 
L6:     iload_1 
L7:     invokevirtual [8] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [9] 
L5:     invokespecial [18] 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [10] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [118] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_3 
L2:     invokespecial [18] 
L5:     aload_0 
L6:     aload_1 
L7:     iload_2 
L8:     iload_3 
L9:     invokevirtual [11] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [12] 
L5:     invokespecial [18] 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [13] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [21] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [22] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [118] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     iconst_1 
L5:     iadd 
L6:     aload_0 
L7:     getfield [7] 
L10:    arraylength 
L11:    if_icmple L66 
L14:    aload_0 
L15:    getfield [7] 
L18:    arraylength 
L19:    iconst_2 
L20:    imul 
L21:    istore_2 
L22:    iload_2 
L23:    aload_0 
L24:    getfield [7] 
L27:    arraylength 
L28:    bipush 32 
L30:    iadd 
L31:    if_icmpge L43 
L34:    aload_0 
L35:    getfield [7] 
L38:    arraylength 
L39:    bipush 32 
L41:    iadd 
L42:    istore_2 
L43:    iload_2 
L44:    newarray char 
L46:    astore_3 
L47:    aload_0 
L48:    getfield [7] 
L51:    iconst_0 
L52:    aload_3 
L53:    iconst_0 
L54:    aload_0 
L55:    getfield [14] 
L58:    invokestatic [2] 
L61:    aload_0 
L62:    aload_3 
L63:    putfield [20] 
L66:    aload_0 
L67:    getfield [7] 
L70:    aload_0 
L71:    getfield [14] 
L74:    iload_1 
L75:    castore 
L76:    aload_0 
L77:    dup 
L78:    getfield [14] 
L81:    iconst_1 
L82:    iadd 
L83:    putfield [22] 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [118] .code stack 5 locals 3 
L0:     aload_1 
L1:     invokevirtual [9] 
L4:     istore_2 
L5:     aload_0 
L6:     getfield [14] 
L9:     iload_2 
L10:    iadd 
L11:    aload_0 
L12:    getfield [7] 
L15:    arraylength 
L16:    if_icmple L77 
L19:    aload_0 
L20:    getfield [7] 
L23:    arraylength 
L24:    iconst_2 
L25:    imul 
L26:    istore_3 
L27:    iload_3 
L28:    aload_0 
L29:    getfield [14] 
L32:    iload_2 
L33:    iadd 
L34:    bipush 32 
L36:    iadd 
L37:    if_icmpge L51 
L40:    aload_0 
L41:    getfield [7] 
L44:    arraylength 
L45:    iload_2 
L46:    iadd 
L47:    bipush 32 
L49:    iadd 
L50:    istore_3 
L51:    iload_3 
L52:    newarray char 
L54:    astore 4 
L56:    aload_0 
L57:    getfield [7] 
L60:    iconst_0 
L61:    aload 4 
L63:    iconst_0 
L64:    aload_0 
L65:    getfield [14] 
L68:    invokestatic [2] 
L71:    aload_0 
L72:    aload 4 
L74:    putfield [20] 
L77:    aload_1 
L78:    iconst_0 
L79:    iload_2 
L80:    aload_0 
L81:    getfield [7] 
L84:    aload_0 
L85:    getfield [14] 
L88:    invokevirtual [15] 
L91:    aload_0 
L92:    dup 
L93:    getfield [14] 
L96:    iload_2 
L97:    iadd 
L98:    putfield [22] 
L101:   return 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [118] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     iload_3 
L5:     iadd 
L6:     aload_0 
L7:     getfield [7] 
L10:    arraylength 
L11:    if_icmple L49 
L14:    aload_0 
L15:    getfield [7] 
L18:    arraylength 
L19:    iload_3 
L20:    iadd 
L21:    bipush 32 
L23:    iadd 
L24:    newarray char 
L26:    astore 4 
L28:    aload_0 
L29:    getfield [7] 
L32:    iconst_0 
L33:    aload 4 
L35:    iconst_0 
L36:    aload_0 
L37:    getfield [14] 
L40:    invokestatic [2] 
L43:    aload_0 
L44:    aload 4 
L46:    putfield [20] 
L49:    aload_1 
L50:    iload_2 
L51:    aload_0 
L52:    getfield [7] 
L55:    aload_0 
L56:    getfield [14] 
L59:    iload_3 
L60:    invokestatic [2] 
L63:    aload_0 
L64:    dup 
L65:    getfield [14] 
L68:    iload_3 
L69:    iadd 
L70:    putfield [22] 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [118] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [16] 
L5:     aload_1 
L6:     getfield [17] 
L9:     aload_1 
L10:    getfield [12] 
L13:    invokevirtual [11] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Field [29] [30] 
.const [8] = Method [31] [32] 
.const [9] = Method [33] [34] 
.const [10] = Method [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Field [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Class [61] 
.const [24] = NameAndType [62] [63] 
.const [25] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [26] = Utf8 org/apache/xerces/xni/XMLString 
.const [27] = Utf8 java/lang/String 
.const [28] = Utf8 java/lang/System 
.const [29] = Class [64] 
.const [30] = NameAndType [65] [66] 
.const [31] = Class [67] 
.const [32] = NameAndType [68] [69] 
.const [33] = Class [70] 
.const [34] = NameAndType [71] [72] 
.const [35] = Class [73] 
.const [36] = NameAndType [74] [75] 
.const [37] = Class [76] 
.const [38] = NameAndType [77] [78] 
.const [39] = Class [79] 
.const [40] = NameAndType [80] [81] 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Class [85] 
.const [44] = NameAndType [86] [87] 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Class [91] 
.const [48] = NameAndType [92] [93] 
.const [49] = Class [94] 
.const [50] = NameAndType [95] [96] 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Utf8 java/lang/System 
.const [62] = Utf8 arraycopy 
.const [63] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [64] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [65] = Utf8 ch 
.const [66] = Utf8 [C 
.const [67] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [68] = Utf8 append 
.const [69] = Utf8 (C)V 
.const [70] = Utf8 java/lang/String 
.const [71] = Utf8 length 
.const [72] = Utf8 ()I 
.const [73] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [74] = Utf8 append 
.const [75] = Utf8 (Ljava/lang/String;)V 
.const [76] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [77] = Utf8 append 
.const [78] = Utf8 ([CII)V 
.const [79] = Utf8 org/apache/xerces/xni/XMLString 
.const [80] = Utf8 length 
.const [81] = Utf8 I 
.const [82] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [83] = Utf8 append 
.const [84] = Utf8 (Lorg/apache/xerces/xni/XMLString;)V 
.const [85] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [86] = Utf8 length 
.const [87] = Utf8 I 
.const [88] = Utf8 java/lang/String 
.const [89] = Utf8 getChars 
.const [90] = Utf8 (II[CI)V 
.const [91] = Utf8 org/apache/xerces/xni/XMLString 
.const [92] = Utf8 ch 
.const [93] = Utf8 [C 
.const [94] = Utf8 org/apache/xerces/xni/XMLString 
.const [95] = Utf8 offset 
.const [96] = Utf8 I 
.const [97] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (I)V 
.const [100] = Utf8 org/apache/xerces/xni/XMLString 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [104] = Utf8 ch 
.const [105] = Utf8 [C 
.const [106] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [107] = Utf8 offset 
.const [108] = Utf8 I 
.const [109] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [110] = Utf8 length 
.const [111] = Utf8 I 
.const [112] = Utf8 org/apache/xerces/util/XMLStringBuffer 
.const [113] = Class [112] 
.const [114] = Utf8 org/apache/xerces/xni/XMLString 
.const [115] = Class [114] 
.const [116] = Utf8 DEFAULT_SIZE 
.const [117] = Utf8 I 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (I)V 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (C)V 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Ljava/lang/String;)V 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ([CII)V 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Lorg/apache/xerces/xni/XMLString;)V 
.const [131] = Utf8 clear 
.const [132] = Utf8 ()V 
.const [133] = Utf8 append 
.const [134] = Utf8 (C)V 
.const [135] = Utf8 append 
.const [136] = Utf8 (Ljava/lang/String;)V 
.const [137] = Utf8 append 
.const [138] = Utf8 ([CII)V 
.const [139] = Utf8 append 
.const [140] = Utf8 (Lorg/apache/xerces/xni/XMLString;)V 
.end class 
