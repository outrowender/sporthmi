.version 50 0 
.class public final super [108] 
.super [110] 
.field private static final [111] [112] 

.method [114] : [115] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [26] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method [116] : [117] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [26] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [27] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [118] : [119] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     baload 
L6:     sipush 240 
L9:     iand 
L10:    sipush 224 
L13:    if_icmpne L18 
L16:    iconst_1 
L17:    areturn 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [120] : [121] 
    .attribute [113] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     goto L19 
L5:     aload_0 
L6:     getfield [15] 
L9:     iload_1 
L10:    baload 
L11:    ifeq L16 
L14:    iconst_0 
L15:    areturn 
L16:    iinc 1 1 
L19:    iload_1 
L20:    aload_0 
L21:    getfield [15] 
L24:    arraylength 
L25:    if_icmplt L5 
L28:    iconst_1 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [122] : [123] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     baload 
L6:     sipush 255 
L9:     iand 
L10:    bipush 127 
L12:    if_icmpne L17 
L15:    iconst_1 
L16:    areturn 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [124] : [125] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     baload 
L6:     sipush 255 
L9:     iand 
L10:    sipush 169 
L13:    if_icmpne L34 
L16:    aload_0 
L17:    getfield [15] 
L20:    iconst_1 
L21:    baload 
L22:    sipush 255 
L25:    iand 
L26:    sipush 254 
L29:    if_icmpne L34 
L32:    iconst_1 
L33:    areturn 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [126] : [127] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     baload 
L6:     sipush 255 
L9:     iand 
L10:    bipush 10 
L12:    if_icmpeq L93 
L15:    aload_0 
L16:    getfield [15] 
L19:    iconst_0 
L20:    baload 
L21:    sipush 255 
L24:    iand 
L25:    sipush 172 
L28:    if_icmpne L61 
L31:    aload_0 
L32:    getfield [15] 
L35:    iconst_1 
L36:    baload 
L37:    sipush 255 
L40:    iand 
L41:    bipush 15 
L43:    if_icmple L61 
L46:    aload_0 
L47:    getfield [15] 
L50:    iconst_1 
L51:    baload 
L52:    sipush 255 
L55:    iand 
L56:    bipush 32 
L58:    if_icmplt L93 
L61:    aload_0 
L62:    getfield [15] 
L65:    iconst_0 
L66:    baload 
L67:    sipush 255 
L70:    iand 
L71:    sipush 192 
L74:    if_icmpne L95 
L77:    aload_0 
L78:    getfield [15] 
L81:    iconst_1 
L82:    baload 
L83:    sipush 255 
L86:    iand 
L87:    sipush 168 
L90:    if_icmpne L95 
L93:    iconst_1 
L94:    areturn 
L95:    iconst_0 
L96:    areturn 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [128] : [129] 
    .attribute [113] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [17] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [15] 
L13:    iconst_0 
L14:    invokestatic [4] 
L17:    istore_1 
L18:    iload_1 
L19:    bipush 8 
L21:    iushr 
L22:    ldc [5] 
L24:    if_icmpge L29 
L27:    iconst_0 
L28:    areturn 
L29:    iload_1 
L30:    bipush 24 
L32:    iushr 
L33:    sipush 238 
L36:    if_icmple L41 
L39:    iconst_0 
L40:    areturn 
L41:    iconst_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [130] : [131] 
    .attribute [113] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     invokestatic [4] 
L8:     bipush 8 
L10:    iushr 
L11:    ldc [6] 
L13:    if_icmpne L18 
L16:    iconst_1 
L17:    areturn 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     invokestatic [4] 
L8:     bipush 16 
L10:    iushr 
L11:    ldc [7] 
L13:    if_icmpne L18 
L16:    iconst_1 
L17:    areturn 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [113] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     invokestatic [4] 
L8:     bipush 16 
L10:    iushr 
L11:    istore_1 
L12:    iload_1 
L13:    ldc [8] 
L15:    if_icmplt L26 
L18:    iload_1 
L19:    ldc [9] 
L21:    if_icmpgt L26 
L24:    iconst_1 
L25:    areturn 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [113] .code stack 3 locals 2 
L0:     ldc [10] 
L2:     astore_1 
L3:     iconst_0 
L4:     istore_2 
L5:     goto L64 
L8:     new [28] 
L11:    dup 
L12:    aload_1 
L13:    invokestatic [13] 
L16:    invokespecial [22] 
L19:    aload_0 
L20:    getfield [15] 
L23:    iload_2 
L24:    baload 
L25:    sipush 255 
L28:    iand 
L29:    invokevirtual [18] 
L32:    invokevirtual [19] 
L35:    astore_1 
L36:    iload_2 
L37:    iconst_3 
L38:    if_icmpeq L61 
L41:    new [28] 
L44:    dup 
L45:    aload_1 
L46:    invokestatic [13] 
L49:    invokespecial [22] 
L52:    ldc [14] 
L54:    invokevirtual [20] 
L57:    invokevirtual [19] 
L60:    astore_1 
L61:    iinc 2 1 
L64:    iload_2 
L65:    iconst_4 
L66:    if_icmplt L8 
L69:    aload_1 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     invokestatic [4] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [23] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [144] : [145] 
    .attribute [113] .code stack 4 locals 0 
L0:     new [25] 
L3:     dup 
L4:     aload_0 
L5:     getfield [15] 
L8:     aload_0 
L9:     getfield [16] 
L12:    invokespecial [24] 
L15:    areturn 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Method [31] [32] 
.const [5] = Int 16834560 
.const [6] = Int 57344 
.const [7] = Int -1114112 
.const [8] = Int -1058078720 
.const [9] = Int -1007747072 
.const [10] = String [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Method [36] [37] 
.const [14] = String [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Method [55] [56] 
.const [24] = Method [57] [58] 
.const [25] = Class [59] 
.const [26] = Field [60] [61] 
.const [27] = Field [62] [63] 
.const [28] = Class [64] 
.const [29] = Utf8 java/net/Inet4Address 
.const [30] = Utf8 java/net/InetAddress 
.const [31] = Class [65] 
.const [32] = NameAndType [66] [67] 
.const [33] = Utf8 '' 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 java/lang/String 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Utf8 '.' 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Utf8 java/net/InetAddress 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Utf8 java/lang/StringBuffer 
.const [65] = Utf8 java/net/InetAddress 
.const [66] = Utf8 bytesToInt 
.const [67] = Utf8 ([BI)I 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 valueOf 
.const [70] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [71] = Utf8 java/net/Inet4Address 
.const [72] = Utf8 ipaddress 
.const [73] = Utf8 [B 
.const [74] = Utf8 java/net/Inet4Address 
.const [75] = Utf8 hostName 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 java/net/Inet4Address 
.const [78] = Utf8 isMulticastAddress 
.const [79] = Utf8 ()Z 
.const [80] = Utf8 java/lang/StringBuffer 
.const [81] = Utf8 append 
.const [82] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Utf8 toString 
.const [85] = Utf8 ()Ljava/lang/String; 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 append 
.const [88] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [89] = Utf8 java/net/InetAddress 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Ljava/lang/String;)V 
.const [95] = Utf8 java/net/InetAddress 
.const [96] = Utf8 equals 
.const [97] = Utf8 (Ljava/lang/Object;)Z 
.const [98] = Utf8 java/net/InetAddress 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ([BLjava/lang/String;)V 
.const [101] = Utf8 java/net/Inet4Address 
.const [102] = Utf8 ipaddress 
.const [103] = Utf8 [B 
.const [104] = Utf8 java/net/Inet4Address 
.const [105] = Utf8 hostName 
.const [106] = Utf8 Ljava/lang/String; 
.const [107] = Utf8 java/net/Inet4Address 
.const [108] = Class [107] 
.const [109] = Utf8 java/net/InetAddress 
.const [110] = Class [109] 
.const [111] = Utf8 serialVersionUID 
.const [112] = Utf8 J 
.const [113] = Utf8 Code 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ([B)V 
.const [116] = Utf8 <init> 
.const [117] = Utf8 ([BLjava/lang/String;)V 
.const [118] = Utf8 isMulticastAddress 
.const [119] = Utf8 ()Z 
.const [120] = Utf8 isAnyLocalAddress 
.const [121] = Utf8 ()Z 
.const [122] = Utf8 isLoopbackAddress 
.const [123] = Utf8 ()Z 
.const [124] = Utf8 isLinkLocalAddress 
.const [125] = Utf8 ()Z 
.const [126] = Utf8 isSiteLocalAddress 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 isMCGlobal 
.const [129] = Utf8 ()Z 
.const [130] = Utf8 isMCNodeLocal 
.const [131] = Utf8 ()Z 
.const [132] = Utf8 isMCLinkLocal 
.const [133] = Utf8 ()Z 
.const [134] = Utf8 isMCSiteLocal 
.const [135] = Utf8 ()Z 
.const [136] = Utf8 isMCOrgLocal 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 getHostAddress 
.const [139] = Utf8 ()Ljava/lang/String; 
.const [140] = Utf8 hashCode 
.const [141] = Utf8 ()I 
.const [142] = Utf8 equals 
.const [143] = Utf8 (Ljava/lang/Object;)Z 
.const [144] = Utf8 writeReplace 
.const [145] = Utf8 ()Ljava/lang/Object; 
.end class 
