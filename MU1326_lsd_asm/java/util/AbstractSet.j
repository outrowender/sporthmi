.version 50 0 
.class public super abstract [93] 
.super [95] 
.implements [97] 

.method protected annotation [99] : [100] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     instanceof [4] 
L11:    ifeq L44 
L14:    aload_1 
L15:    checkcast [4] 
L18:    astore_2 
L19:    aload_0 
L20:    invokevirtual [8] 
L23:    aload_2 
L24:    invokeinterface [14] 0 
L29:    if_icmpne L42 
L32:    aload_0 
L33:    aload_2 
L34:    invokevirtual [9] 
L37:    ifeq L42 
L40:    iconst_1 
L41:    areturn 
L42:    iconst_0 
L43:    areturn 
L44:    iconst_0 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 2 locals 3 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     invokevirtual [10] 
L6:     astore_2 
L7:     goto L32 
L10:    aload_2 
L11:    invokeinterface [15] 0 
L16:    astore_3 
L17:    iload_1 
L18:    aload_3 
L19:    ifnonnull L26 
L22:    iconst_0 
L23:    goto L30 
L26:    aload_3 
L27:    invokevirtual [11] 
L30:    iadd 
L31:    istore_1 
L32:    aload_2 
L33:    invokeinterface [16] 0 
L38:    ifne L10 
L41:    iload_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     invokevirtual [8] 
L6:     aload_1 
L7:     invokeinterface [17] 0 
L12:    if_icmpgt L58 
L15:    aload_0 
L16:    invokevirtual [10] 
L19:    astore_3 
L20:    goto L46 
L23:    aload_1 
L24:    aload_3 
L25:    invokeinterface [15] 0 
L30:    invokeinterface [18] 0 
L35:    ifeq L46 
L38:    aload_3 
L39:    invokeinterface [19] 0 
L44:    iconst_1 
L45:    istore_2 
L46:    aload_3 
L47:    invokeinterface [16] 0 
L52:    ifne L23 
L55:    goto L100 
L58:    aload_1 
L59:    invokeinterface [20] 0 
L64:    astore_3 
L65:    goto L91 
L68:    aload_0 
L69:    aload_3 
L70:    invokeinterface [15] 0 
L75:    invokevirtual [12] 
L78:    ifne L89 
L81:    iload_2 
L82:    ifne L89 
L85:    iconst_0 
L86:    goto L90 
L89:    iconst_1 
L90:    istore_2 
L91:    aload_3 
L92:    invokeinterface [16] 0 
L97:    ifne L68 
L100:   iload_2 
L101:   areturn 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Method [27] [28] 
.const [9] = Method [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = InterfaceMethod [39] [40] 
.const [15] = InterfaceMethod [41] [42] 
.const [16] = InterfaceMethod [43] [44] 
.const [17] = InterfaceMethod [45] [46] 
.const [18] = InterfaceMethod [47] [48] 
.const [19] = InterfaceMethod [49] [50] 
.const [20] = InterfaceMethod [51] [52] 
.const [21] = Utf8 java/util/AbstractSet 
.const [22] = Utf8 java/util/AbstractCollection 
.const [23] = Utf8 java/util/Set 
.const [24] = Utf8 java/util/Iterator 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 java/util/Collection 
.const [27] = Class [53] 
.const [28] = NameAndType [54] [55] 
.const [29] = Class [56] 
.const [30] = NameAndType [57] [58] 
.const [31] = Class [59] 
.const [32] = NameAndType [60] [61] 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
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
.const [53] = Utf8 java/util/AbstractSet 
.const [54] = Utf8 size 
.const [55] = Utf8 ()I 
.const [56] = Utf8 java/util/AbstractSet 
.const [57] = Utf8 containsAll 
.const [58] = Utf8 (Ljava/util/Collection;)Z 
.const [59] = Utf8 java/util/AbstractSet 
.const [60] = Utf8 iterator 
.const [61] = Utf8 ()Ljava/util/Iterator; 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 hashCode 
.const [64] = Utf8 ()I 
.const [65] = Utf8 java/util/AbstractSet 
.const [66] = Utf8 remove 
.const [67] = Utf8 (Ljava/lang/Object;)Z 
.const [68] = Utf8 java/util/AbstractCollection 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 java/util/Set 
.const [72] = Utf8 size 
.const [73] = Utf8 ()I 
.const [74] = Utf8 java/util/Iterator 
.const [75] = Utf8 next 
.const [76] = Utf8 ()Ljava/lang/Object; 
.const [77] = Utf8 java/util/Iterator 
.const [78] = Utf8 hasNext 
.const [79] = Utf8 ()Z 
.const [80] = Utf8 java/util/Collection 
.const [81] = Utf8 size 
.const [82] = Utf8 ()I 
.const [83] = Utf8 java/util/Collection 
.const [84] = Utf8 contains 
.const [85] = Utf8 (Ljava/lang/Object;)Z 
.const [86] = Utf8 java/util/Iterator 
.const [87] = Utf8 remove 
.const [88] = Utf8 ()V 
.const [89] = Utf8 java/util/Collection 
.const [90] = Utf8 iterator 
.const [91] = Utf8 ()Ljava/util/Iterator; 
.const [92] = Utf8 java/util/AbstractSet 
.const [93] = Class [92] 
.const [94] = Utf8 java/util/AbstractCollection 
.const [95] = Class [94] 
.const [96] = Utf8 java/util/Set 
.const [97] = Class [96] 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 equals 
.const [102] = Utf8 (Ljava/lang/Object;)Z 
.const [103] = Utf8 hashCode 
.const [104] = Utf8 ()I 
.const [105] = Utf8 removeAll 
.const [106] = Utf8 (Ljava/util/Collection;)Z 
.end class 
