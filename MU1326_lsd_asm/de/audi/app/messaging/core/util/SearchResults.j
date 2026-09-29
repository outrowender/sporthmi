.version 50 0 
.class public final super [103] 
.super [105] 

.method public annotation [107] : [108] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [109] : [110] 
    .attribute [106] .code stack 5 locals 5 
L0:     iconst_0 
L1:     istore_1 
L2:     iconst_0 
L3:     istore_2 
L4:     aconst_null 
L5:     astore_3 
L6:     aconst_null 
L7:     astore 4 
L9:     aload_0 
L10:    ifnull L57 
L13:    aload_0 
L14:    invokevirtual [10] 
L17:    dup 
L18:    astore 5 
L20:    invokestatic [2] 
L23:    ifne L57 
L26:    aload_0 
L27:    invokevirtual [11] 
L30:    istore_2 
L31:    aload 5 
L33:    invokevirtual [12] 
L36:    astore_3 
L37:    aload_3 
L38:    aload 5 
L40:    invokevirtual [13] 
L43:    ifne L57 
L46:    iconst_1 
L47:    istore_1 
L48:    aload_0 
L49:    aload 5 
L51:    aload_3 
L52:    invokestatic [3] 
L55:    astore 4 
L57:    iload_1 
L58:    ifeq L75 
L61:    new [22] 
L64:    dup 
L65:    iload_2 
L66:    aload_3 
L67:    aload 4 
L69:    invokespecial [20] 
L72:    goto L76 
L75:    aload_0 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private static [111] : [112] 
    .attribute [106] .code stack 7 locals 5 
L0:     aload_2 
L1:     invokevirtual [14] 
L4:     iconst_1 
L5:     if_icmpge L16 
L8:     iconst_0 
L9:     anewarray [5] 
L12:    astore_3 
L13:    goto L121 
L16:    aload_1 
L17:    aload_2 
L18:    invokevirtual [15] 
L21:    istore 4 
L23:    iload 4 
L25:    ifle L116 
L28:    aload_0 
L29:    ifnull L39 
L32:    aload_0 
L33:    invokevirtual [16] 
L36:    goto L40 
L39:    aconst_null 
L40:    astore 5 
L42:    aload 5 
L44:    ifnull L108 
L47:    aload 5 
L49:    arraylength 
L50:    anewarray [5] 
L53:    astore_3 
L54:    iconst_0 
L55:    istore 6 
L57:    iload 6 
L59:    aload 5 
L61:    arraylength 
L62:    if_icmpge L105 
L65:    aload 5 
L67:    iload 6 
L69:    aaload 
L70:    astore 7 
L72:    aload_3 
L73:    iload 6 
L75:    new [23] 
L78:    dup 
L79:    aload 7 
L81:    invokevirtual [17] 
L84:    iload 4 
L86:    isub 
L87:    aload 7 
L89:    invokevirtual [18] 
L92:    iload 4 
L94:    isub 
L95:    invokespecial [21] 
L98:    aastore 
L99:    iinc 6 1 
L102:   goto L57 
L105:   goto L113 
L108:   iconst_0 
L109:   anewarray [5] 
L112:   astore_3 
L113:   goto L121 
L116:   aload_0 
L117:   invokevirtual [16] 
L120:   astore_3 
L121:   aload_3 
L122:   areturn 
L123:   nop 
L124:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [24] [25] 
.const [3] = Method [26] [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Method [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Method [38] [39] 
.const [13] = Method [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Class [58] 
.const [23] = Class [59] 
.const [24] = Class [60] 
.const [25] = NameAndType [61] [62] 
.const [26] = Class [63] 
.const [27] = NameAndType [64] [65] 
.const [28] = Utf8 org/dsi/ifc/search/Token 
.const [29] = Utf8 org/dsi/ifc/search/Highlight 
.const [30] = Utf8 de/audi/app/messaging/core/util/SearchResults 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [33] = Utf8 java/lang/String 
.const [34] = Class [66] 
.const [35] = NameAndType [67] [68] 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Class [75] 
.const [41] = NameAndType [76] [77] 
.const [42] = Class [78] 
.const [43] = NameAndType [79] [80] 
.const [44] = Class [81] 
.const [45] = NameAndType [82] [83] 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Class [87] 
.const [49] = NameAndType [88] [89] 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Class [96] 
.const [55] = NameAndType [97] [98] 
.const [56] = Class [99] 
.const [57] = NameAndType [100] [101] 
.const [58] = Utf8 org/dsi/ifc/search/Token 
.const [59] = Utf8 org/dsi/ifc/search/Highlight 
.const [60] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [61] = Utf8 isNullOrEmpty 
.const [62] = Utf8 (Ljava/lang/String;)Z 
.const [63] = Utf8 de/audi/app/messaging/core/util/SearchResults 
.const [64] = Utf8 fillTrimmedHighlightsArray 
.const [65] = Utf8 (Lorg/dsi/ifc/search/Token;Ljava/lang/String;Ljava/lang/String;)[Lorg/dsi/ifc/search/Highlight; 
.const [66] = Utf8 org/dsi/ifc/search/Token 
.const [67] = Utf8 getToken 
.const [68] = Utf8 ()Ljava/lang/String; 
.const [69] = Utf8 org/dsi/ifc/search/Token 
.const [70] = Utf8 getWordType 
.const [71] = Utf8 ()I 
.const [72] = Utf8 java/lang/String 
.const [73] = Utf8 trim 
.const [74] = Utf8 ()Ljava/lang/String; 
.const [75] = Utf8 java/lang/String 
.const [76] = Utf8 equals 
.const [77] = Utf8 (Ljava/lang/Object;)Z 
.const [78] = Utf8 java/lang/String 
.const [79] = Utf8 length 
.const [80] = Utf8 ()I 
.const [81] = Utf8 java/lang/String 
.const [82] = Utf8 indexOf 
.const [83] = Utf8 (Ljava/lang/String;)I 
.const [84] = Utf8 org/dsi/ifc/search/Token 
.const [85] = Utf8 getHighlights 
.const [86] = Utf8 ()[Lorg/dsi/ifc/search/Highlight; 
.const [87] = Utf8 org/dsi/ifc/search/Highlight 
.const [88] = Utf8 getHighlightStart 
.const [89] = Utf8 ()I 
.const [90] = Utf8 org/dsi/ifc/search/Highlight 
.const [91] = Utf8 getHighlightEnd 
.const [92] = Utf8 ()I 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 org/dsi/ifc/search/Token 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (ILjava/lang/String;[Lorg/dsi/ifc/search/Highlight;)V 
.const [99] = Utf8 org/dsi/ifc/search/Highlight 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (II)V 
.const [102] = Utf8 de/audi/app/messaging/core/util/SearchResults 
.const [103] = Class [102] 
.const [104] = Utf8 java/lang/Object 
.const [105] = Class [104] 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 trimForSingleLineDisplay 
.const [110] = Utf8 (Lorg/dsi/ifc/search/Token;)Lorg/dsi/ifc/search/Token; 
.const [111] = Utf8 fillTrimmedHighlightsArray 
.const [112] = Utf8 (Lorg/dsi/ifc/search/Token;Ljava/lang/String;Ljava/lang/String;)[Lorg/dsi/ifc/search/Highlight; 
.end class 
