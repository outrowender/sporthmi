.version 50 0 
.class public final super [117] 
.super [119] 
.implements [121] 
.field protected static final [122] [123] 

.method public annotation [125] : [126] 
    .attribute [124] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [124] .code stack 4 locals 5 
L0:     new [25] 
L3:     dup 
L4:     iload_2 
L5:     iload_1 
L6:     isub 
L7:     invokespecial [22] 
L10:    astore 5 
L12:    iload_1 
L13:    istore 6 
L15:    iload 6 
L17:    iload_2 
L18:    if_icmpge L126 
L21:    aload 4 
L23:    iload 6 
L25:    invokeinterface [26] 0 
L30:    checkcast [3] 
L33:    astore 7 
L35:    aload 7 
L37:    iconst_0 
L38:    invokevirtual [17] 
L41:    istore 8 
L43:    iload 6 
L45:    iload_1 
L46:    isub 
L47:    ifne L53 
L50:    goto L112 
L53:    aload_0 
L54:    iload_1 
L55:    iload_2 
L56:    aload 4 
L58:    invokespecial [23] 
L61:    istore 9 
L63:    iload 9 
L65:    lookupswitch 
            3 : L92 
            4 : L102 
            default : L112 

L92:    iload 8 
L94:    invokestatic [4] 
L97:    istore 8 
L99:    goto L112 
L102:   iload 8 
L104:   invokestatic [5] 
L107:   istore 8 
L109:   goto L112 
L112:   aload 5 
L114:   iload 8 
L116:   invokevirtual [18] 
L119:   pop 
L120:   iinc 6 1 
L123:   goto L15 
L126:   aload 5 
L128:   invokevirtual [19] 
L131:   areturn 
L132:   
    .end code 
.end method 

.method private [129] : [130] 
    .attribute [124] .code stack 3 locals 8 
L0:     aload_3 
L1:     iload_1 
L2:     invokeinterface [26] 0 
L7:     checkcast [3] 
L10:    astore 4 
L12:    aload 4 
L14:    iconst_0 
L15:    invokevirtual [17] 
L18:    istore 5 
L20:    iload 5 
L22:    invokestatic [6] 
L25:    istore 6 
L27:    iload 5 
L29:    invokestatic [7] 
L32:    istore 7 
L34:    iload 6 
L36:    ifeq L41 
L39:    iconst_3 
L40:    areturn 
L41:    iload 7 
L43:    ifeq L103 
L46:    iload_2 
L47:    iload_1 
L48:    isub 
L49:    iconst_1 
L50:    if_icmple L103 
L53:    aload_3 
L54:    iload_1 
L55:    iconst_1 
L56:    iadd 
L57:    invokeinterface [26] 0 
L62:    checkcast [3] 
L65:    astore 8 
L67:    aload 8 
L69:    iconst_0 
L70:    invokevirtual [17] 
L73:    istore 9 
L75:    iload 9 
L77:    invokestatic [6] 
L80:    istore 10 
L82:    iload 9 
L84:    invokestatic [7] 
L87:    istore 11 
L89:    iload 10 
L91:    ifeq L96 
L94:    iconst_3 
L95:    areturn 
L96:    iload 11 
L98:    ifeq L103 
L101:   iconst_4 
L102:   areturn 
L103:   iconst_2 
L104:   areturn 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [124] .code stack 2 locals 1 
L0:     getstatic [8] 
L3:     iload_1 
L4:     invokestatic [9] 
L7:     iflt L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    istore_2 
L16:    iload_2 
L17:    iload_1 
L18:    invokestatic [10] 
L21:    ior 
L22:    istore_2 
L23:    iload_2 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [133] : [134] 
    .attribute [124] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [135] : [136] 
    .attribute [124] .code stack 4 locals 0 
L0:     bipush 19 
L2:     newarray char 
L4:     dup 
L5:     iconst_0 
L6:     bipush 32 
L8:     castore 
L9:     dup 
L10:    iconst_1 
L11:    bipush 33 
L13:    castore 
L14:    dup 
L15:    iconst_2 
L16:    bipush 39 
L18:    castore 
L19:    dup 
L20:    iconst_3 
L21:    bipush 40 
L23:    castore 
L24:    dup 
L25:    iconst_4 
L26:    bipush 41 
L28:    castore 
L29:    dup 
L30:    iconst_5 
L31:    bipush 43 
L33:    castore 
L34:    dup 
L35:    bipush 6 
L37:    bipush 44 
L39:    castore 
L40:    dup 
L41:    bipush 7 
L43:    bipush 45 
L45:    castore 
L46:    dup 
L47:    bipush 8 
L49:    bipush 46 
L51:    castore 
L52:    dup 
L53:    bipush 9 
L55:    bipush 47 
L57:    castore 
L58:    dup 
L59:    bipush 10 
L61:    bipush 58 
L63:    castore 
L64:    dup 
L65:    bipush 11 
L67:    bipush 59 
L69:    castore 
L70:    dup 
L71:    bipush 12 
L73:    bipush 63 
L75:    castore 
L76:    dup 
L77:    bipush 13 
L79:    bipush 95 
L81:    castore 
L82:    dup 
L83:    bipush 14 
L85:    sipush 161 
L88:    castore 
L89:    dup 
L90:    bipush 15 
L92:    sipush 191 
L95:    castore 
L96:    dup 
L97:    bipush 16 
L99:    sipush 12290 
L102:   castore 
L103:   dup 
L104:   bipush 17 
L106:   sipush 12298 
L109:   castore 
L110:   dup 
L111:   bipush 18 
L113:   sipush 12299 
L116:   castore 
L117:   putstatic [24] 
L120:   return 
L121:   nop 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Method [29] [30] 
.const [5] = Method [31] [32] 
.const [6] = Method [33] [34] 
.const [7] = Method [35] [36] 
.const [8] = Field [37] [38] 
.const [9] = Method [39] [40] 
.const [10] = Method [41] [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Class [65] 
.const [26] = InterfaceMethod [66] [67] 
.const [27] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [28] = Utf8 java/lang/String 
.const [29] = Class [68] 
.const [30] = NameAndType [69] [70] 
.const [31] = Class [71] 
.const [32] = NameAndType [72] [73] 
.const [33] = Class [74] 
.const [34] = NameAndType [75] [76] 
.const [35] = Class [77] 
.const [36] = NameAndType [78] [79] 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Class [83] 
.const [40] = NameAndType [84] [85] 
.const [41] = Class [86] 
.const [42] = NameAndType [87] [88] 
.const [43] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/CaseBalancingStrategyAsia 
.const [44] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/CaseBalancingStrategyEU 
.const [45] = Utf8 java/util/List 
.const [46] = Utf8 java/lang/Character 
.const [47] = Utf8 java/util/Arrays 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/StringUtility 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Utf8 java/lang/Character 
.const [69] = Utf8 toLowerCase 
.const [70] = Utf8 (C)C 
.const [71] = Utf8 java/lang/Character 
.const [72] = Utf8 toUpperCase 
.const [73] = Utf8 (C)C 
.const [74] = Utf8 java/lang/Character 
.const [75] = Utf8 isLowerCase 
.const [76] = Utf8 (C)Z 
.const [77] = Utf8 java/lang/Character 
.const [78] = Utf8 isUpperCase 
.const [79] = Utf8 (C)Z 
.const [80] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/CaseBalancingStrategyAsia 
.const [81] = Utf8 WORD_SEPERATORS_ASIA 
.const [82] = Utf8 [C 
.const [83] = Utf8 java/util/Arrays 
.const [84] = Utf8 binarySearch 
.const [85] = Utf8 ([CC)I 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/base/StringUtility 
.const [87] = Utf8 isAsiaCharacter 
.const [88] = Utf8 (C)Z 
.const [89] = Utf8 java/lang/String 
.const [90] = Utf8 charAt 
.const [91] = Utf8 (I)C 
.const [92] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [95] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [96] = Utf8 toString 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/CaseBalancingStrategyAsia 
.const [99] = Utf8 isHandwrittenActive 
.const [100] = Utf8 Z 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/CaseBalancingStrategyEU 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/CaseBalancingStrategyAsia 
.const [108] = Utf8 calculateCaseForRange 
.const [109] = Utf8 (IILjava/util/List;)I 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/CaseBalancingStrategyAsia 
.const [111] = Utf8 WORD_SEPERATORS_ASIA 
.const [112] = Utf8 [C 
.const [113] = Utf8 java/util/List 
.const [114] = Utf8 get 
.const [115] = Utf8 (I)Ljava/lang/Object; 
.const [116] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/CaseBalancingStrategyAsia 
.const [117] = Class [116] 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/CaseBalancingStrategyEU 
.const [119] = Class [118] 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ICaseBalancingStrategy 
.const [121] = Class [120] 
.const [122] = Utf8 WORD_SEPERATORS_ASIA 
.const [123] = Utf8 [C 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 refreshForDisplayCaseBalancingText 
.const [128] = Utf8 (IILde/esolutions/fw/util/commons/IntList;Ljava/util/List;)Ljava/lang/String; 
.const [129] = Utf8 calculateCaseForRange 
.const [130] = Utf8 (IILjava/util/List;)I 
.const [131] = Utf8 isWordSeparator 
.const [132] = Utf8 (C)Z 
.const [133] = Utf8 needRefreshDisplayTextAfterTextChange 
.const [134] = Utf8 ()Z 
.const [135] = Utf8 <clinit> 
.const [136] = Utf8 ()V 
.end class 
