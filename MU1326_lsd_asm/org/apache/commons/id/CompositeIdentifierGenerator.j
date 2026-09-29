.version 50 0 
.class public super [131] 
.super [133] 
.implements [135] 
.field private static final [136] [137] 
.field private final [138] [139] 

.method public static [141] : [142] 
    .attribute [140] .code stack 4 locals 2 
L0:     aload_0 
L1:     ifnonnull L14 
L4:     new [23] 
L7:     dup 
L8:     ldc [3] 
L10:    invokespecial [19] 
L13:    athrow 
L14:    aload_0 
L15:    arraylength 
L16:    ifne L29 
L19:    new [23] 
L22:    dup 
L23:    ldc [4] 
L25:    invokespecial [19] 
L28:    athrow 
L29:    aload_0 
L30:    arraylength 
L31:    anewarray [5] 
L34:    astore_1 
L35:    iconst_0 
L36:    istore_2 
L37:    iload_2 
L38:    aload_0 
L39:    arraylength 
L40:    if_icmpge L71 
L43:    aload_0 
L44:    iload_2 
L45:    aaload 
L46:    ifnonnull L59 
L49:    new [23] 
L52:    dup 
L53:    ldc [6] 
L55:    invokespecial [19] 
L58:    athrow 
L59:    aload_1 
L60:    iload_2 
L61:    aload_0 
L62:    iload_2 
L63:    aaload 
L64:    aastore 
L65:    iinc 2 1 
L68:    goto L37 
L71:    new [24] 
L74:    dup 
L75:    aload_1 
L76:    invokespecial [20] 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [140] .code stack 3 locals 3 
L0:     aload_0 
L1:     ifnonnull L14 
L4:     new [23] 
L7:     dup 
L8:     ldc [8] 
L10:    invokespecial [19] 
L13:    athrow 
L14:    aload_0 
L15:    invokeinterface [25] 0 
L20:    ifne L33 
L23:    new [23] 
L26:    dup 
L27:    ldc [9] 
L29:    invokespecial [19] 
L32:    athrow 
L33:    aload_0 
L34:    invokeinterface [25] 0 
L39:    anewarray [5] 
L42:    astore_1 
L43:    iconst_0 
L44:    istore_2 
L45:    aload_0 
L46:    invokeinterface [26] 0 
L51:    astore_3 
L52:    aload_3 
L53:    invokeinterface [27] 0 
L58:    ifeq L95 
L61:    aload_1 
L62:    iload_2 
L63:    aload_3 
L64:    invokeinterface [28] 0 
L69:    checkcast [5] 
L72:    aastore 
L73:    aload_1 
L74:    iload_2 
L75:    aaload 
L76:    ifnonnull L89 
L79:    new [23] 
L82:    dup 
L83:    ldc [6] 
L85:    invokespecial [19] 
L88:    athrow 
L89:    iinc 2 1 
L92:    goto L52 
L95:    new [24] 
L98:    dup 
L99:    aload_1 
L100:   invokespecial [20] 
L103:   areturn 
L104:   
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [29] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [140] .code stack 3 locals 2 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [22] 
L7:     astore_1 
L8:     iconst_0 
L9:     istore_2 
L10:    iload_2 
L11:    aload_0 
L12:    getfield [16] 
L15:    arraylength 
L16:    if_icmpge L41 
L19:    aload_1 
L20:    aload_0 
L21:    getfield [16] 
L24:    iload_2 
L25:    aaload 
L26:    invokeinterface [31] 0 
L31:    invokevirtual [17] 
L34:    pop 
L35:    iinc 2 1 
L38:    goto L10 
L41:    aload_1 
L42:    invokevirtual [18] 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [140] .code stack 4 locals 3 
L0:     lconst_0 
L1:     lstore_1 
L2:     iconst_0 
L3:     istore_3 
L4:     iload_3 
L5:     aload_0 
L6:     getfield [16] 
L9:     arraylength 
L10:    if_icmpge L33 
L13:    lload_1 
L14:    aload_0 
L15:    getfield [16] 
L18:    iload_3 
L19:    aaload 
L20:    invokeinterface [32] 0 
L25:    ladd 
L26:    lstore_1 
L27:    iinc 3 1 
L30:    goto L4 
L33:    lload_1 
L34:    freturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [140] .code stack 4 locals 3 
L0:     lconst_0 
L1:     lstore_1 
L2:     iconst_0 
L3:     istore_3 
L4:     iload_3 
L5:     aload_0 
L6:     getfield [16] 
L9:     arraylength 
L10:    if_icmpge L33 
L13:    lload_1 
L14:    aload_0 
L15:    getfield [16] 
L18:    iload_3 
L19:    aaload 
L20:    invokeinterface [33] 0 
L25:    ladd 
L26:    lstore_1 
L27:    iinc 3 1 
L30:    goto L4 
L33:    lload_1 
L34:    freturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     arraylength 
L5:     istore_1 
L6:     iload_1 
L7:     anewarray [5] 
L10:    astore_2 
L11:    aload_0 
L12:    getfield [16] 
L15:    iconst_0 
L16:    aload_2 
L17:    iconst_0 
L18:    iload_1 
L19:    invokestatic [11] 
L22:    aload_2 
L23:    areturn 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = String [35] 
.const [4] = String [36] 
.const [5] = Class [37] 
.const [6] = String [38] 
.const [7] = Class [39] 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = Method [43] [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Field [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Class [63] 
.const [24] = Class [64] 
.const [25] = InterfaceMethod [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = InterfaceMethod [71] [72] 
.const [29] = Field [73] [74] 
.const [30] = Class [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = InterfaceMethod [78] [79] 
.const [33] = InterfaceMethod [80] [81] 
.const [34] = Utf8 java/lang/IllegalArgumentException 
.const [35] = Utf8 'Generator array must not be null' 
.const [36] = Utf8 'Generator array must not be empty' 
.const [37] = Utf8 org/apache/commons/id/StringIdentifierGenerator 
.const [38] = Utf8 'Generators must not be null' 
.const [39] = Utf8 org/apache/commons/id/CompositeIdentifierGenerator 
.const [40] = Utf8 'Generator collection must not be null' 
.const [41] = Utf8 'Generator collection must not be empty' 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Class [82] 
.const [44] = NameAndType [83] [84] 
.const [45] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [46] = Utf8 java/util/Collection 
.const [47] = Utf8 java/util/Iterator 
.const [48] = Utf8 java/lang/System 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
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
.const [63] = Utf8 java/lang/IllegalArgumentException 
.const [64] = Utf8 org/apache/commons/id/CompositeIdentifierGenerator 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Class [109] 
.const [68] = NameAndType [110] [111] 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Class [118] 
.const [74] = NameAndType [119] [120] 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Class [121] 
.const [77] = NameAndType [122] [123] 
.const [78] = Class [124] 
.const [79] = NameAndType [125] [126] 
.const [80] = Class [127] 
.const [81] = NameAndType [128] [129] 
.const [82] = Utf8 java/lang/System 
.const [83] = Utf8 arraycopy 
.const [84] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [85] = Utf8 org/apache/commons/id/CompositeIdentifierGenerator 
.const [86] = Utf8 identifierGenerators 
.const [87] = Utf8 [Lorg/apache/commons/id/StringIdentifierGenerator; 
.const [88] = Utf8 java/lang/StringBuffer 
.const [89] = Utf8 append 
.const [90] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [91] = Utf8 java/lang/StringBuffer 
.const [92] = Utf8 toString 
.const [93] = Utf8 ()Ljava/lang/String; 
.const [94] = Utf8 java/lang/IllegalArgumentException 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Ljava/lang/String;)V 
.const [97] = Utf8 org/apache/commons/id/CompositeIdentifierGenerator 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ([Lorg/apache/commons/id/StringIdentifierGenerator;)V 
.const [100] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/util/Collection 
.const [107] = Utf8 size 
.const [108] = Utf8 ()I 
.const [109] = Utf8 java/util/Collection 
.const [110] = Utf8 iterator 
.const [111] = Utf8 ()Ljava/util/Iterator; 
.const [112] = Utf8 java/util/Iterator 
.const [113] = Utf8 hasNext 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 java/util/Iterator 
.const [116] = Utf8 next 
.const [117] = Utf8 ()Ljava/lang/Object; 
.const [118] = Utf8 org/apache/commons/id/CompositeIdentifierGenerator 
.const [119] = Utf8 identifierGenerators 
.const [120] = Utf8 [Lorg/apache/commons/id/StringIdentifierGenerator; 
.const [121] = Utf8 org/apache/commons/id/StringIdentifierGenerator 
.const [122] = Utf8 nextStringIdentifier 
.const [123] = Utf8 ()Ljava/lang/String; 
.const [124] = Utf8 org/apache/commons/id/StringIdentifierGenerator 
.const [125] = Utf8 maxLength 
.const [126] = Utf8 ()J 
.const [127] = Utf8 org/apache/commons/id/StringIdentifierGenerator 
.const [128] = Utf8 minLength 
.const [129] = Utf8 ()J 
.const [130] = Utf8 org/apache/commons/id/CompositeIdentifierGenerator 
.const [131] = Class [130] 
.const [132] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [133] = Class [132] 
.const [134] = Utf8 java/io/Serializable 
.const [135] = Class [134] 
.const [136] = Utf8 serialVersionUID 
.const [137] = Utf8 J 
.const [138] = Utf8 identifierGenerators 
.const [139] = Utf8 [Lorg/apache/commons/id/StringIdentifierGenerator; 
.const [140] = Utf8 Code 
.const [141] = Utf8 getInstance 
.const [142] = Utf8 ([Lorg/apache/commons/id/StringIdentifierGenerator;)Lorg/apache/commons/id/StringIdentifierGenerator; 
.const [143] = Utf8 getInstance 
.const [144] = Utf8 (Ljava/util/Collection;)Lorg/apache/commons/id/StringIdentifierGenerator; 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ([Lorg/apache/commons/id/StringIdentifierGenerator;)V 
.const [147] = Utf8 nextStringIdentifier 
.const [148] = Utf8 ()Ljava/lang/String; 
.const [149] = Utf8 maxLength 
.const [150] = Utf8 ()J 
.const [151] = Utf8 minLength 
.const [152] = Utf8 ()J 
.const [153] = Utf8 getIdentifierGenerators 
.const [154] = Utf8 ()[Lorg/apache/commons/id/StringIdentifierGenerator; 
.end class 
