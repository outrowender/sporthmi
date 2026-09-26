.version 50 0 
.class public super [87] 
.super [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 10 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_4 
L3:     lconst_0 
L4:     aconst_null 
L5:     dconst_0 
L6:     aconst_null 
L7:     aconst_null 
L8:     invokespecial [17] 
L11:    iload_2 
L12:    ifeq L23 
L15:    aload_0 
L16:    lconst_1 
L17:    putfield [20] 
L20:    goto L28 
L23:    aload_0 
L24:    lconst_0 
L25:    putfield [20] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [90] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     invokevirtual [11] 
L6:     invokespecial [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [90] .code stack 4 locals 1 
L0:     new [21] 
L3:     dup 
L4:     sipush 1400 
L7:     invokespecial [19] 
L10:    astore_1 
L11:    aload_1 
L12:    ldc [3] 
L14:    invokevirtual [12] 
L17:    pop 
L18:    aload_1 
L19:    aload_0 
L20:    getfield [13] 
L23:    invokevirtual [14] 
L26:    pop 
L27:    aload_1 
L28:    ldc [4] 
L30:    invokevirtual [12] 
L33:    pop 
L34:    aload_0 
L35:    getfield [10] 
L38:    lconst_1 
L39:    lcmp 
L40:    ifne L53 
L43:    aload_1 
L44:    ldc [5] 
L46:    invokevirtual [12] 
L49:    pop 
L50:    goto L60 
L53:    aload_1 
L54:    ldc [6] 
L56:    invokevirtual [12] 
L59:    pop 
L60:    aload_1 
L61:    bipush 41 
L63:    invokevirtual [15] 
L66:    pop 
L67:    aload_1 
L68:    invokevirtual [16] 
L71:    areturn 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = String [23] 
.const [4] = String [24] 
.const [5] = String [25] 
.const [6] = String [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Field [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Field [50] [51] 
.const [21] = Class [52] 
.const [22] = Utf8 java/lang/StringBuffer 
.const [23] = Utf8 'HASDataElement(elementId=' 
.const [24] = Utf8 ',booleanData=' 
.const [25] = Utf8 true 
.const [26] = Utf8 false 
.const [27] = Utf8 de/audi/tghu/exlap/dsi/BooleanElement 
.const [28] = Utf8 org/dsi/ifc/has/HASDataElement 
.const [29] = Utf8 java/lang/Boolean 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Utf8 java/lang/StringBuffer 
.const [53] = Utf8 de/audi/tghu/exlap/dsi/BooleanElement 
.const [54] = Utf8 numericData 
.const [55] = Utf8 J 
.const [56] = Utf8 java/lang/Boolean 
.const [57] = Utf8 booleanValue 
.const [58] = Utf8 ()Z 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 append 
.const [61] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [62] = Utf8 de/audi/tghu/exlap/dsi/BooleanElement 
.const [63] = Utf8 elementId 
.const [64] = Utf8 I 
.const [65] = Utf8 java/lang/StringBuffer 
.const [66] = Utf8 append 
.const [67] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Utf8 append 
.const [70] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 toString 
.const [73] = Utf8 ()Ljava/lang/String; 
.const [74] = Utf8 org/dsi/ifc/has/HASDataElement 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (IIJLjava/lang/String;D[BLorg/dsi/ifc/global/ResourceLocator;)V 
.const [77] = Utf8 de/audi/tghu/exlap/dsi/BooleanElement 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (IZ)V 
.const [80] = Utf8 java/lang/StringBuffer 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 de/audi/tghu/exlap/dsi/BooleanElement 
.const [84] = Utf8 numericData 
.const [85] = Utf8 J 
.const [86] = Utf8 de/audi/tghu/exlap/dsi/BooleanElement 
.const [87] = Class [86] 
.const [88] = Utf8 org/dsi/ifc/has/HASDataElement 
.const [89] = Class [88] 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (IZ)V 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (ILjava/lang/Boolean;)V 
.const [95] = Utf8 toString 
.const [96] = Utf8 ()Ljava/lang/String; 
.end class 
