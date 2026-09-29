.version 50 0 
.class public super [137] 
.super [139] 
.field private [140] [141] 
.field private [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [29] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [30] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [29] 
L19:    aconst_null 
L20:    aload_0 
L21:    getfield [17] 
L24:    if_acmpeq L69 
L27:    aload_0 
L28:    getfield [17] 
L31:    invokevirtual [19] 
L34:    ifeq L69 
L37:    aload_0 
L38:    getfield [17] 
L41:    invokevirtual [20] 
L44:    l2i 
L45:    iconst_2 
L46:    imul 
L47:    istore_3 
L48:    aload_0 
L49:    iload_3 
L50:    newarray int 
L52:    putfield [30] 
L55:    aload_1 
L56:    aload_0 
L57:    getfield [17] 
L60:    aload_0 
L61:    getfield [18] 
L64:    iload_3 
L65:    invokevirtual [21] 
L68:    pop 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 4 locals 1 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [18] 
L5:     if_acmpeq L46 
L8:     new [31] 
L11:    dup 
L12:    invokespecial [27] 
L15:    astore_2 
L16:    aload_2 
L17:    aload_0 
L18:    getfield [18] 
L21:    iload_1 
L22:    iconst_2 
L23:    imul 
L24:    iconst_0 
L25:    iadd 
L26:    iaload 
L27:    putfield [32] 
L30:    aload_2 
L31:    aload_0 
L32:    getfield [18] 
L35:    iload_1 
L36:    iconst_2 
L37:    imul 
L38:    iconst_1 
L39:    iadd 
L40:    iaload 
L41:    putfield [33] 
L44:    aload_2 
L45:    areturn 
L46:    aconst_null 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 5 locals 1 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [18] 
L5:     if_acmpeq L124 
L8:     getstatic [3] 
L11:    ldc [4] 
L13:    invokevirtual [22] 
L16:    iconst_0 
L17:    istore_1 
L18:    iload_1 
L19:    aload_0 
L20:    getfield [18] 
L23:    arraylength 
L24:    if_icmpge L116 
L27:    getstatic [3] 
L30:    new [34] 
L33:    dup 
L34:    invokespecial [28] 
L37:    ldc [6] 
L39:    invokevirtual [23] 
L42:    iload_1 
L43:    iconst_2 
L44:    idiv 
L45:    invokevirtual [24] 
L48:    ldc [7] 
L50:    invokevirtual [23] 
L53:    aload_0 
L54:    getfield [18] 
L57:    iload_1 
L58:    iaload 
L59:    invokevirtual [24] 
L62:    ldc [8] 
L64:    invokevirtual [23] 
L67:    aload_0 
L68:    getfield [18] 
L71:    iload_1 
L72:    iconst_1 
L73:    iadd 
L74:    iaload 
L75:    invokevirtual [24] 
L78:    ldc [9] 
L80:    invokevirtual [23] 
L83:    aload_0 
L84:    getfield [18] 
L87:    iconst_1 
L88:    iaload 
L89:    aload_0 
L90:    getfield [18] 
L93:    iconst_0 
L94:    iaload 
L95:    isub 
L96:    invokevirtual [24] 
L99:    ldc [10] 
L101:   invokevirtual [23] 
L104:   invokevirtual [25] 
L107:   invokevirtual [22] 
L110:   iinc 1 2 
L113:   goto L18 
L116:   getstatic [3] 
L119:   ldc [10] 
L121:   invokevirtual [22] 
L124:   return 
L125:   nop 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public enum [151] : [152] 
    .attribute [144] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Field [36] [37] 
.const [4] = String [38] 
.const [5] = Class [39] 
.const [6] = String [40] 
.const [7] = String [41] 
.const [8] = String [42] 
.const [9] = String [43] 
.const [10] = String [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Class [50] 
.const [17] = Field [51] [52] 
.const [18] = Field [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Class [79] 
.const [32] = Field [80] [81] 
.const [33] = Field [82] [83] 
.const [34] = Class [84] 
.const [35] = Utf8 de/esolutions/graphics/eal/text/TextInformation$GlyphInformation 
.const [36] = Class [85] 
.const [37] = NameAndType [86] [87] 
.const [38] = Utf8 'glyphlist {' 
.const [39] = Utf8 java/lang/StringBuffer 
.const [40] = Utf8 '\t' 
.const [41] = Utf8 ' : {start=' 
.const [42] = Utf8 ', end=' 
.const [43] = Utf8 ', width=' 
.const [44] = Utf8 '}' 
.const [45] = Utf8 de/esolutions/graphics/eal/text/TextInformation 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [48] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [49] = Utf8 java/lang/System 
.const [50] = Utf8 java/io/PrintStream 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Class [121] 
.const [74] = NameAndType [122] [123] 
.const [75] = Class [124] 
.const [76] = NameAndType [125] [126] 
.const [77] = Class [127] 
.const [78] = NameAndType [128] [129] 
.const [79] = Utf8 de/esolutions/graphics/eal/text/TextInformation$GlyphInformation 
.const [80] = Class [130] 
.const [81] = NameAndType [131] [132] 
.const [82] = Class [133] 
.const [83] = NameAndType [134] [135] 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Utf8 java/lang/System 
.const [86] = Utf8 out 
.const [87] = Utf8 Ljava/io/PrintStream; 
.const [88] = Utf8 de/esolutions/graphics/eal/text/TextInformation 
.const [89] = Utf8 result 
.const [90] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayoutResult; 
.const [91] = Utf8 de/esolutions/graphics/eal/text/TextInformation 
.const [92] = Utf8 glyphInformation 
.const [93] = Utf8 [I 
.const [94] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [95] = Utf8 isValid 
.const [96] = Utf8 ()Z 
.const [97] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [98] = Utf8 getGlyphCount 
.const [99] = Utf8 ()J 
.const [100] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [101] = Utf8 layoutGetWidth 
.const [102] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayoutResult;[II)Z 
.const [103] = Utf8 java/io/PrintStream 
.const [104] = Utf8 println 
.const [105] = Utf8 (Ljava/lang/String;)V 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 append 
.const [108] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 append 
.const [111] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 toString 
.const [114] = Utf8 ()Ljava/lang/String; 
.const [115] = Utf8 java/lang/Object 
.const [116] = Utf8 <init> 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/esolutions/graphics/eal/text/TextInformation$GlyphInformation 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/esolutions/graphics/eal/text/TextInformation 
.const [125] = Utf8 result 
.const [126] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayoutResult; 
.const [127] = Utf8 de/esolutions/graphics/eal/text/TextInformation 
.const [128] = Utf8 glyphInformation 
.const [129] = Utf8 [I 
.const [130] = Utf8 de/esolutions/graphics/eal/text/TextInformation$GlyphInformation 
.const [131] = Utf8 start 
.const [132] = Utf8 I 
.const [133] = Utf8 de/esolutions/graphics/eal/text/TextInformation$GlyphInformation 
.const [134] = Utf8 end 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/graphics/eal/text/TextInformation 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 result 
.const [141] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayoutResult; 
.const [142] = Utf8 glyphInformation 
.const [143] = Utf8 [I 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lde/esolutions/graphics/eal/api/IManager;Lde/esolutions/graphics/eal/api/ITextLayoutResult;)V 
.const [147] = Utf8 layoutGetWidth 
.const [148] = Utf8 (I)Lde/esolutions/graphics/eal/text/TextInformation$GlyphInformation; 
.const [149] = Utf8 dump 
.const [150] = Utf8 ()V 
.const [151] = Utf8 dispose 
.const [152] = Utf8 ()V 
.end class 
