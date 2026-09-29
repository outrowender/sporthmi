.version 50 0 
.class public super abstract [97] 
.super [99] 
.field public [100] [101] 
.field public [102] [103] 

.method public [105] : [106] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public abstract [107] : [108] 
    .attribute [104] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [104] .code stack 4 locals 4 
L0:     new [20] 
L3:     dup 
L4:     iconst_5 
L5:     invokespecial [15] 
L8:     astore_3 
L9:     iconst_0 
L10:    istore 4 
L12:    iload 4 
L14:    aload_2 
L15:    invokeinterface [21] 0 
L20:    if_icmpge L90 
L23:    aload_2 
L24:    iload 4 
L26:    invokeinterface [22] 0 
L31:    astore 5 
L33:    aload 5 
L35:    instanceof [3] 
L38:    ifne L69 
L41:    new [23] 
L44:    dup 
L45:    new [24] 
L48:    dup 
L49:    invokespecial [16] 
L52:    ldc [6] 
L54:    invokevirtual [10] 
L57:    aload 5 
L59:    invokevirtual [11] 
L62:    invokevirtual [12] 
L65:    invokespecial [17] 
L68:    athrow 
L69:    aload 5 
L71:    checkcast [3] 
L74:    astore 6 
L76:    aload_0 
L77:    aload_1 
L78:    aload 6 
L80:    aload_3 
L81:    invokevirtual [13] 
L84:    iinc 4 1 
L87:    goto L12 
L90:    aload_3 
L91:    areturn 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = String [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Class [53] 
.const [21] = InterfaceMethod [54] [55] 
.const [22] = InterfaceMethod [56] [57] 
.const [23] = Class [58] 
.const [24] = Class [59] 
.const [25] = Utf8 java/util/ArrayList 
.const [26] = Utf8 org/w3c/dom/Node 
.const [27] = Utf8 java/lang/RuntimeException 
.const [28] = Utf8 java/lang/StringBuffer 
.const [29] = Utf8 'Invalid child ' 
.const [30] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 java/util/List 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Utf8 java/util/ArrayList 
.const [54] = Class [90] 
.const [55] = NameAndType [91] [92] 
.const [56] = Class [93] 
.const [57] = NameAndType [94] [95] 
.const [58] = Utf8 java/lang/RuntimeException 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 append 
.const [62] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 append 
.const [65] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 toString 
.const [68] = Utf8 ()Ljava/lang/String; 
.const [69] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [70] = Utf8 match 
.const [71] = Utf8 (Ljava/util/Map;Lorg/w3c/dom/Node;Ljava/util/List;)V 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/util/ArrayList 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (I)V 
.const [78] = Utf8 java/lang/StringBuffer 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/lang/RuntimeException 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (Ljava/lang/String;)V 
.const [84] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [85] = Utf8 name 
.const [86] = Utf8 Ljava/lang/String; 
.const [87] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [88] = Utf8 ns 
.const [89] = Utf8 Ljava/lang/String; 
.const [90] = Utf8 java/util/List 
.const [91] = Utf8 size 
.const [92] = Utf8 ()I 
.const [93] = Utf8 java/util/List 
.const [94] = Utf8 get 
.const [95] = Utf8 (I)Ljava/lang/Object; 
.const [96] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [97] = Class [96] 
.const [98] = Utf8 java/lang/Object 
.const [99] = Class [98] 
.const [100] = Utf8 name 
.const [101] = Utf8 Ljava/lang/String; 
.const [102] = Utf8 ns 
.const [103] = Utf8 Ljava/lang/String; 
.const [104] = Utf8 Code 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [107] = Utf8 match 
.const [108] = Utf8 (Ljava/util/Map;Lorg/w3c/dom/Node;Ljava/util/List;)V 
.const [109] = Utf8 matchList 
.const [110] = Utf8 (Ljava/util/Map;Ljava/util/List;)Ljava/util/List; 
.end class 
