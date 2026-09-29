.version 50 0 
.class public super [117] 
.super [119] 
.field private final [120] [121] 
.field private [122] [123] 
.field private [124] [125] 
.field private static final [126] [127] 

.method public [129] : [130] 
    .attribute [128] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [25] 
L14:    aload_1 
L15:    ifnonnull L28 
L18:    new [26] 
L21:    dup 
L22:    ldc [3] 
L24:    invokespecial [20] 
L27:    athrow 
L28:    iload_3 
L29:    iconst_1 
L30:    if_icmpge L43 
L33:    new [27] 
L36:    dup 
L37:    ldc [5] 
L39:    invokespecial [21] 
L42:    athrow 
L43:    iload_3 
L44:    aload_1 
L45:    invokevirtual [15] 
L48:    if_icmpgt L61 
L51:    new [27] 
L54:    dup 
L55:    ldc [6] 
L57:    invokespecial [21] 
L60:    athrow 
L61:    aload_0 
L62:    iload_2 
L63:    putfield [24] 
L66:    aload_0 
L67:    aload_1 
L68:    putfield [28] 
L71:    iload_3 
L72:    aload_1 
L73:    invokevirtual [15] 
L76:    isub 
L77:    istore 4 
L79:    aload_0 
L80:    iload 4 
L82:    newarray char 
L84:    putfield [25] 
L87:    iconst_0 
L88:    istore 5 
L90:    iload 5 
L92:    iload 4 
L94:    if_icmpge L112 
L97:    aload_0 
L98:    getfield [14] 
L101:   iload 5 
L103:   bipush 48 
L105:   castore 
L106:   iinc 5 1 
L109:   goto L90 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public interface [131] : [132] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     arraylength 
L5:     aload_0 
L6:     getfield [16] 
L9:     invokevirtual [15] 
L12:    iadd 
L13:    i2l 
L14:    freturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     arraylength 
L5:     aload_0 
L6:     getfield [16] 
L9:     invokevirtual [15] 
L12:    iadd 
L13:    i2l 
L14:    freturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     arraylength 
L5:     aload_0 
L6:     getfield [16] 
L9:     invokevirtual [15] 
L12:    iadd 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [139] : [140] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [128] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     arraylength 
L5:     iconst_1 
L6:     isub 
L7:     istore_1 
L8:     iload_1 
L9:     iflt L84 
L12:    aload_0 
L13:    getfield [14] 
L16:    iload_1 
L17:    caload 
L18:    lookupswitch 
            57 : L36 
            default : L65 

L36:    aload_0 
L37:    getfield [14] 
L40:    iload_1 
L41:    bipush 48 
L43:    castore 
L44:    iload_1 
L45:    ifne L78 
L48:    aload_0 
L49:    getfield [13] 
L52:    ifne L78 
L55:    new [29] 
L58:    dup 
L59:    ldc [8] 
L61:    invokespecial [22] 
L64:    athrow 
L65:    aload_0 
L66:    getfield [14] 
L69:    iload_1 
L70:    dup2 
L71:    caload 
L72:    iconst_1 
L73:    iadd 
L74:    i2c 
L75:    castore 
L76:    iconst_m1 
L77:    istore_1 
L78:    iinc 1 -1 
L81:    goto L8 
L84:    new [30] 
L87:    dup 
L88:    aload_0 
L89:    getfield [16] 
L92:    invokespecial [23] 
L95:    astore_1 
L96:    aload_1 
L97:    aload_0 
L98:    getfield [14] 
L101:   invokevirtual [17] 
L104:   pop 
L105:   aload_1 
L106:   invokevirtual [18] 
L109:   areturn 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = String [32] 
.const [4] = Class [33] 
.const [5] = String [34] 
.const [6] = String [35] 
.const [7] = Class [36] 
.const [8] = String [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Class [68] 
.const [27] = Class [69] 
.const [28] = Field [70] [71] 
.const [29] = Class [72] 
.const [30] = Class [73] 
.const [31] = Utf8 java/lang/NullPointerException 
.const [32] = Utf8 'prefix must not be null' 
.const [33] = Utf8 java/lang/IllegalArgumentException 
.const [34] = Utf8 'size must be at least one' 
.const [35] = Utf8 'size less prefix length must be at least one' 
.const [36] = Utf8 java/lang/IllegalStateException 
.const [37] = Utf8 'The maximum number of identifiers has been reached' 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [40] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [41] = Utf8 java/lang/String 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Utf8 java/lang/NullPointerException 
.const [69] = Utf8 java/lang/IllegalArgumentException 
.const [70] = Class [113] 
.const [71] = NameAndType [114] [115] 
.const [72] = Utf8 java/lang/IllegalStateException 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [75] = Utf8 wrap 
.const [76] = Utf8 Z 
.const [77] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [78] = Utf8 count 
.const [79] = Utf8 [C 
.const [80] = Utf8 java/lang/String 
.const [81] = Utf8 length 
.const [82] = Utf8 ()I 
.const [83] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [84] = Utf8 prefix 
.const [85] = Utf8 Ljava/lang/String; 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 append 
.const [88] = Utf8 ([C)Ljava/lang/StringBuffer; 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 toString 
.const [91] = Utf8 ()Ljava/lang/String; 
.const [92] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 java/lang/NullPointerException 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Ljava/lang/String;)V 
.const [98] = Utf8 java/lang/IllegalArgumentException 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Ljava/lang/String;)V 
.const [101] = Utf8 java/lang/IllegalStateException 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Ljava/lang/String;)V 
.const [104] = Utf8 java/lang/StringBuffer 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/lang/String;)V 
.const [107] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [108] = Utf8 wrap 
.const [109] = Utf8 Z 
.const [110] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [111] = Utf8 count 
.const [112] = Utf8 [C 
.const [113] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [114] = Utf8 prefix 
.const [115] = Utf8 Ljava/lang/String; 
.const [116] = Utf8 org/apache/commons/id/serial/PrefixedLeftPaddedNumericGenerator 
.const [117] = Class [116] 
.const [118] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [119] = Class [118] 
.const [120] = Utf8 prefix 
.const [121] = Utf8 Ljava/lang/String; 
.const [122] = Utf8 wrap 
.const [123] = Utf8 Z 
.const [124] = Utf8 count 
.const [125] = Utf8 [C 
.const [126] = Utf8 NINE_CHAR 
.const [127] = Utf8 C 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/String;ZI)V 
.const [131] = Utf8 getPrefix 
.const [132] = Utf8 ()Ljava/lang/String; 
.const [133] = Utf8 maxLength 
.const [134] = Utf8 ()J 
.const [135] = Utf8 minLength 
.const [136] = Utf8 ()J 
.const [137] = Utf8 getSize 
.const [138] = Utf8 ()I 
.const [139] = Utf8 isWrap 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 setWrap 
.const [142] = Utf8 (Z)V 
.const [143] = Utf8 nextStringIdentifier 
.const [144] = Utf8 ()Ljava/lang/String; 
.end class 
