.version 50 0 
.class super [125] 
.super [127] 
.field static final [128] [129] 
.field final [130] [131] 
.field [132] [133] 
.field private final synthetic [134] [135] 

.method [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [21] 
L10:    aload_0 
L11:    bipush 20 
L13:    anewarray [2] 
L16:    putfield [26] 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [27] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [136] .code stack 3 locals 0 
L0:     new [28] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [22] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [136] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_0 
L4:     getfield [14] 
L7:     iconst_2 
L8:     imul 
L9:     if_icmpge L41 
L12:    aload_0 
L13:    getfield [13] 
L16:    iload_2 
L17:    aaload 
L18:    aload_1 
L19:    invokevirtual [15] 
L22:    ifeq L34 
L25:    aload_0 
L26:    getfield [13] 
L29:    iload_2 
L30:    iconst_1 
L31:    iadd 
L32:    aaload 
L33:    areturn 
L34:    iload_2 
L35:    iconst_2 
L36:    iadd 
L37:    istore_2 
L38:    goto L2 
L41:    aconst_null 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [136] .code stack 3 locals 2 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_3 
L3:     aload_0 
L4:     getfield [14] 
L7:     iconst_2 
L8:     imul 
L9:     if_icmpge L54 
L12:    aload_0 
L13:    getfield [13] 
L16:    iload_3 
L17:    aaload 
L18:    aload_1 
L19:    invokevirtual [15] 
L22:    ifeq L47 
L25:    aload_0 
L26:    getfield [13] 
L29:    iload_3 
L30:    iconst_1 
L31:    iadd 
L32:    aaload 
L33:    astore 4 
L35:    aload_0 
L36:    getfield [13] 
L39:    iload_3 
L40:    iconst_1 
L41:    iadd 
L42:    aload_2 
L43:    aastore 
L44:    aload 4 
L46:    areturn 
L47:    iload_3 
L48:    iconst_2 
L49:    iadd 
L50:    istore_3 
L51:    goto L2 
L54:    aload_0 
L55:    getfield [13] 
L58:    aload_0 
L59:    getfield [14] 
L62:    iconst_2 
L63:    imul 
L64:    aload_1 
L65:    aastore 
L66:    aload_0 
L67:    getfield [13] 
L70:    aload_0 
L71:    getfield [14] 
L74:    iconst_2 
L75:    imul 
L76:    iconst_1 
L77:    iadd 
L78:    aload_2 
L79:    aastore 
L80:    aload_0 
L81:    dup 
L82:    getfield [14] 
L85:    iconst_1 
L86:    iadd 
L87:    putfield [27] 
L90:    aconst_null 
L91:    areturn 
L92:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [136] .code stack 5 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_0 
L4:     getfield [14] 
L7:     iconst_2 
L8:     imul 
L9:     if_icmpge L140 
L12:    aload_0 
L13:    getfield [13] 
L16:    iload_2 
L17:    aaload 
L18:    aload_1 
L19:    invokevirtual [15] 
L22:    ifeq L133 
L25:    aload_0 
L26:    getfield [13] 
L29:    iload_2 
L30:    iconst_1 
L31:    iadd 
L32:    aaload 
L33:    astore_3 
L34:    iload_2 
L35:    istore 4 
L37:    iload 4 
L39:    aload_0 
L40:    getfield [14] 
L43:    iconst_2 
L44:    imul 
L45:    iconst_2 
L46:    isub 
L47:    if_icmpge L93 
L50:    aload_0 
L51:    getfield [13] 
L54:    iload 4 
L56:    aload_0 
L57:    getfield [13] 
L60:    iload 4 
L62:    iconst_2 
L63:    iadd 
L64:    aaload 
L65:    aastore 
L66:    aload_0 
L67:    getfield [13] 
L70:    iload 4 
L72:    iconst_1 
L73:    iadd 
L74:    aload_0 
L75:    getfield [13] 
L78:    iload 4 
L80:    iconst_3 
L81:    iadd 
L82:    aaload 
L83:    aastore 
L84:    iload 4 
L86:    iconst_2 
L87:    iadd 
L88:    istore 4 
L90:    goto L37 
L93:    aload_0 
L94:    getfield [13] 
L97:    aload_0 
L98:    getfield [14] 
L101:   iconst_2 
L102:   imul 
L103:   iconst_2 
L104:   isub 
L105:   aconst_null 
L106:   aastore 
L107:   aload_0 
L108:   getfield [13] 
L111:   aload_0 
L112:   getfield [14] 
L115:   iconst_2 
L116:   imul 
L117:   iconst_1 
L118:   isub 
L119:   aconst_null 
L120:   aastore 
L121:   aload_0 
L122:   dup 
L123:   getfield [14] 
L126:   iconst_1 
L127:   isub 
L128:   putfield [27] 
L131:   aload_3 
L132:   areturn 
L133:   iload_2 
L134:   iconst_2 
L135:   iadd 
L136:   istore_2 
L137:   goto L2 
L140:   aconst_null 
L141:   areturn 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [136] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iload_1 
L3:     aload_0 
L4:     getfield [14] 
L7:     iconst_2 
L8:     imul 
L9:     if_icmpge L35 
L12:    aload_0 
L13:    getfield [13] 
L16:    iload_1 
L17:    aconst_null 
L18:    aastore 
L19:    aload_0 
L20:    getfield [13] 
L23:    iload_1 
L24:    iconst_1 
L25:    iadd 
L26:    aconst_null 
L27:    aastore 
L28:    iload_1 
L29:    iconst_2 
L30:    iadd 
L31:    istore_1 
L32:    goto L2 
L35:    aload_0 
L36:    iconst_0 
L37:    putfield [27] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     bipush 10 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [136] .code stack 5 locals 2 
L0:     new [29] 
L3:     dup 
L4:     aload_0 
L5:     getfield [12] 
L8:     invokespecial [23] 
L11:    astore_1 
L12:    iconst_0 
L13:    istore_2 
L14:    iload_2 
L15:    aload_0 
L16:    getfield [14] 
L19:    iconst_2 
L20:    imul 
L21:    if_icmpge L50 
L24:    aload_1 
L25:    aload_0 
L26:    getfield [13] 
L29:    iload_2 
L30:    aaload 
L31:    aload_0 
L32:    getfield [13] 
L35:    iload_2 
L36:    iconst_1 
L37:    iadd 
L38:    aaload 
L39:    invokevirtual [16] 
L42:    pop 
L43:    iload_2 
L44:    iconst_2 
L45:    iadd 
L46:    istore_2 
L47:    goto L14 
L50:    aload_1 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [136] .code stack 4 locals 2 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [24] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [17] 
L14:    aload_0 
L15:    getfield [14] 
L18:    invokevirtual [18] 
L21:    pop 
L22:    iconst_0 
L23:    istore_2 
L24:    iload_2 
L25:    bipush 20 
L27:    if_icmpge L103 
L30:    aload_1 
L31:    ldc [7] 
L33:    invokevirtual [17] 
L36:    pop 
L37:    aload_1 
L38:    iload_2 
L39:    invokevirtual [18] 
L42:    pop 
L43:    aload_1 
L44:    ldc [8] 
L46:    invokevirtual [17] 
L49:    pop 
L50:    aload_1 
L51:    aload_0 
L52:    getfield [13] 
L55:    iload_2 
L56:    aaload 
L57:    invokevirtual [19] 
L60:    pop 
L61:    aload_1 
L62:    ldc [9] 
L64:    invokevirtual [17] 
L67:    pop 
L68:    aload_1 
L69:    iload_2 
L70:    iconst_1 
L71:    iadd 
L72:    invokevirtual [18] 
L75:    pop 
L76:    aload_1 
L77:    ldc [8] 
L79:    invokevirtual [17] 
L82:    pop 
L83:    aload_1 
L84:    aload_0 
L85:    getfield [13] 
L88:    iload_2 
L89:    iconst_1 
L90:    iadd 
L91:    aaload 
L92:    invokevirtual [19] 
L95:    pop 
L96:    iload_2 
L97:    iconst_2 
L98:    iadd 
L99:    istore_2 
L100:   goto L24 
L103:   aload_1 
L104:   invokevirtual [20] 
L107:   areturn 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = Class [34] 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = String [37] 
.const [9] = String [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Class [73] 
.const [29] = Class [74] 
.const [30] = Class [75] 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [33] = Utf8 org/apache/xerces/util/AugmentationsImpl$LargeContainer 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 'SmallContainer - fNumEntries == ' 
.const [36] = Utf8 '\nfAugmentations[' 
.const [37] = Utf8 '] == ' 
.const [38] = Utf8 '; fAugmentations[' 
.const [39] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [40] = Utf8 org/apache/xerces/util/AugmentationsImpl$AugmentationsItemsContainer 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [74] = Utf8 org/apache/xerces/util/AugmentationsImpl$LargeContainer 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [77] = Utf8 this$0 
.const [78] = Utf8 Lorg/apache/xerces/util/AugmentationsImpl; 
.const [79] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [80] = Utf8 fAugmentations 
.const [81] = Utf8 [Ljava/lang/Object; 
.const [82] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [83] = Utf8 fNumEntries 
.const [84] = Utf8 I 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 equals 
.const [87] = Utf8 (Ljava/lang/Object;)Z 
.const [88] = Utf8 org/apache/xerces/util/AugmentationsImpl$LargeContainer 
.const [89] = Utf8 putItem 
.const [90] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [91] = Utf8 java/lang/StringBuffer 
.const [92] = Utf8 append 
.const [93] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Utf8 append 
.const [96] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 toString 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 org/apache/xerces/util/AugmentationsImpl$AugmentationsItemsContainer 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lorg/apache/xerces/util/AugmentationsImpl;)V 
.const [106] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lorg/apache/xerces/util/AugmentationsImpl$SmallContainer;)V 
.const [109] = Utf8 org/apache/xerces/util/AugmentationsImpl$LargeContainer 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Lorg/apache/xerces/util/AugmentationsImpl;)V 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [116] = Utf8 this$0 
.const [117] = Utf8 Lorg/apache/xerces/util/AugmentationsImpl; 
.const [118] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [119] = Utf8 fAugmentations 
.const [120] = Utf8 [Ljava/lang/Object; 
.const [121] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [122] = Utf8 fNumEntries 
.const [123] = Utf8 I 
.const [124] = Utf8 org/apache/xerces/util/AugmentationsImpl$SmallContainer 
.const [125] = Class [124] 
.const [126] = Utf8 org/apache/xerces/util/AugmentationsImpl$AugmentationsItemsContainer 
.const [127] = Class [126] 
.const [128] = Utf8 SIZE_LIMIT 
.const [129] = Utf8 I 
.const [130] = Utf8 fAugmentations 
.const [131] = Utf8 [Ljava/lang/Object; 
.const [132] = Utf8 fNumEntries 
.const [133] = Utf8 I 
.const [134] = Utf8 this$0 
.const [135] = Utf8 Lorg/apache/xerces/util/AugmentationsImpl; 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Lorg/apache/xerces/util/AugmentationsImpl;)V 
.const [139] = Utf8 keys 
.const [140] = Utf8 ()Ljava/util/Enumeration; 
.const [141] = Utf8 getItem 
.const [142] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [143] = Utf8 putItem 
.const [144] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [145] = Utf8 removeItem 
.const [146] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [147] = Utf8 clear 
.const [148] = Utf8 ()V 
.const [149] = Utf8 isFull 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 expand 
.const [152] = Utf8 ()Lorg/apache/xerces/util/AugmentationsImpl$AugmentationsItemsContainer; 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.end class 
