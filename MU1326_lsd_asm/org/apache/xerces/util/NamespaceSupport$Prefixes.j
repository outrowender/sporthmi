.version 50 0 
.class public final super [105] 
.super [107] 
.implements [109] 
.field private [110] [111] 
.field private [112] [113] 
.field private [114] [115] 
.field private final synthetic [116] [117] 

.method public [119] : [120] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     aload_0 
L6:     invokespecial [16] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [20] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [21] 
L19:    aload_0 
L20:    aload_2 
L21:    putfield [22] 
L24:    aload_0 
L25:    iload_3 
L26:    putfield [21] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_0 
L5:     getfield [11] 
L8:     if_icmpge L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_0 
L5:     getfield [11] 
L8:     if_icmpge L31 
L11:    aload_0 
L12:    getfield [9] 
L15:    getfield [13] 
L18:    aload_0 
L19:    dup 
L20:    getfield [10] 
L23:    dup_x1 
L24:    iconst_1 
L25:    iadd 
L26:    putfield [20] 
L29:    aaload 
L30:    areturn 
L31:    new [23] 
L34:    dup 
L35:    ldc [3] 
L37:    invokespecial [17] 
L40:    athrow 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 3 locals 2 
L0:     new [24] 
L3:     dup 
L4:     invokespecial [18] 
L7:     astore_1 
L8:     iconst_0 
L9:     istore_2 
L10:    iload_2 
L11:    aload_0 
L12:    getfield [11] 
L15:    if_icmpge L42 
L18:    aload_1 
L19:    aload_0 
L20:    getfield [12] 
L23:    iload_2 
L24:    aaload 
L25:    invokevirtual [14] 
L28:    pop 
L29:    aload_1 
L30:    ldc [5] 
L32:    invokevirtual [14] 
L35:    pop 
L36:    iinc 2 1 
L39:    goto L10 
L42:    aload_1 
L43:    invokevirtual [15] 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = String [26] 
.const [4] = Class [27] 
.const [5] = String [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Field [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Field [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Field [40] [41] 
.const [14] = Method [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = Class [60] 
.const [24] = Class [61] 
.const [25] = Utf8 java/util/NoSuchElementException 
.const [26] = Utf8 'Illegal access to Namespace prefixes enumeration.' 
.const [27] = Utf8 java/lang/StringBuffer 
.const [28] = Utf8 ' ' 
.const [29] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 org/apache/xerces/util/NamespaceSupport 
.const [32] = Class [62] 
.const [33] = NameAndType [63] [64] 
.const [34] = Class [65] 
.const [35] = NameAndType [66] [67] 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Class [74] 
.const [41] = NameAndType [75] [76] 
.const [42] = Class [77] 
.const [43] = NameAndType [78] [79] 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Utf8 java/util/NoSuchElementException 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [63] = Utf8 this$0 
.const [64] = Utf8 Lorg/apache/xerces/util/NamespaceSupport; 
.const [65] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [66] = Utf8 counter 
.const [67] = Utf8 I 
.const [68] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [69] = Utf8 size 
.const [70] = Utf8 I 
.const [71] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [72] = Utf8 prefixes 
.const [73] = Utf8 [Ljava/lang/String; 
.const [74] = Utf8 org/apache/xerces/util/NamespaceSupport 
.const [75] = Utf8 fPrefixes 
.const [76] = Utf8 [Ljava/lang/String; 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 append 
.const [79] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [80] = Utf8 java/lang/StringBuffer 
.const [81] = Utf8 toString 
.const [82] = Utf8 ()Ljava/lang/String; 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 java/util/NoSuchElementException 
.const [87] = Utf8 <init> 
.const [88] = Utf8 (Ljava/lang/String;)V 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [93] = Utf8 this$0 
.const [94] = Utf8 Lorg/apache/xerces/util/NamespaceSupport; 
.const [95] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [96] = Utf8 counter 
.const [97] = Utf8 I 
.const [98] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [99] = Utf8 size 
.const [100] = Utf8 I 
.const [101] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [102] = Utf8 prefixes 
.const [103] = Utf8 [Ljava/lang/String; 
.const [104] = Utf8 org/apache/xerces/util/NamespaceSupport$Prefixes 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 java/util/Enumeration 
.const [109] = Class [108] 
.const [110] = Utf8 prefixes 
.const [111] = Utf8 [Ljava/lang/String; 
.const [112] = Utf8 counter 
.const [113] = Utf8 I 
.const [114] = Utf8 size 
.const [115] = Utf8 I 
.const [116] = Utf8 this$0 
.const [117] = Utf8 Lorg/apache/xerces/util/NamespaceSupport; 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lorg/apache/xerces/util/NamespaceSupport;[Ljava/lang/String;I)V 
.const [121] = Utf8 hasMoreElements 
.const [122] = Utf8 ()Z 
.const [123] = Utf8 nextElement 
.const [124] = Utf8 ()Ljava/lang/Object; 
.const [125] = Utf8 toString 
.const [126] = Utf8 ()Ljava/lang/String; 
.end class 
