.version 50 0 
.class public super [87] 
.super [89] 
.field private static final [90] [91] 

.method public annotation [93] : [94] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [95] : [96] 
    .attribute [92] .code stack 3 locals 5 
L0:     getstatic [2] 
L3:     aload_0 
L4:     aload_2 
L5:     invokevirtual [12] 
L8:     astore_3 
L9:     aload_3 
L10:    ifnonnull L15 
L13:    aconst_null 
L14:    areturn 
L15:    new [19] 
L18:    dup 
L19:    iconst_5 
L20:    invokespecial [16] 
L23:    astore 4 
        .catch [4] from L25 to L71 using L85 
L25:    aload 4 
L27:    aload_1 
L28:    invokeinterface [20] 0 
L33:    pop 
L34:    iconst_0 
L35:    istore 5 
L37:    iload 5 
L39:    aload_3 
L40:    arraylength 
L41:    if_icmpge L82 
L44:    aload_3 
L45:    iload 5 
L47:    aaload 
L48:    astore 6 
L50:    aload 6 
L52:    aload_0 
L53:    aload 4 
L55:    invokevirtual [13] 
L58:    astore 7 
L60:    aload 7 
L62:    invokeinterface [21] 0 
L67:    ifne L72 
L70:    aconst_null 
L71:    areturn 
        .catch [4] from L72 to L82 using L85 
        .catch [5] from L25 to L71 using L93 
        .catch [5] from L72 to L82 using L93 
L72:    aload 7 
L74:    astore 4 
L76:    iinc 5 1 
L79:    goto L37 
L82:    goto L98 
L85:    astore 5 
L87:    aconst_null 
L88:    astore 4 
L90:    goto L98 
L93:    astore 5 
L95:    aconst_null 
L96:    astore 4 
L98:    new [22] 
L101:   dup 
L102:   aload 4 
L104:   invokespecial [17] 
L107:   areturn 
L108:   
    .end code 
.end method 

.method static [97] : [98] 
    .attribute [92] .code stack 2 locals 0 
L0:     new [23] 
L3:     dup 
L4:     invokespecial [18] 
L7:     putstatic [15] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [24] [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Class [49] 
.const [20] = InterfaceMethod [50] [51] 
.const [21] = InterfaceMethod [52] [53] 
.const [22] = Class [54] 
.const [23] = Class [55] 
.const [24] = Class [56] 
.const [25] = NameAndType [57] [58] 
.const [26] = Utf8 java/util/ArrayList 
.const [27] = Utf8 java/lang/NullPointerException 
.const [28] = Utf8 java/lang/Exception 
.const [29] = Utf8 de/eso/remotehmi/xpath/NodeListWrapper 
.const [30] = Utf8 de/eso/remotehmi/xpath/ExpressionCache 
.const [31] = Utf8 de/eso/remotehmi/xpath/PoorMansXPath 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 java/util/List 
.const [34] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Utf8 java/util/ArrayList 
.const [50] = Class [80] 
.const [51] = NameAndType [81] [82] 
.const [52] = Class [83] 
.const [53] = NameAndType [84] [85] 
.const [54] = Utf8 de/eso/remotehmi/xpath/NodeListWrapper 
.const [55] = Utf8 de/eso/remotehmi/xpath/ExpressionCache 
.const [56] = Utf8 de/eso/remotehmi/xpath/PoorMansXPath 
.const [57] = Utf8 cache 
.const [58] = Utf8 Lde/eso/remotehmi/xpath/ExpressionCache; 
.const [59] = Utf8 de/eso/remotehmi/xpath/ExpressionCache 
.const [60] = Utf8 get 
.const [61] = Utf8 (Ljava/util/Map;Ljava/lang/String;)[Lde/eso/remotehmi/xpath/AbstractPathEntry; 
.const [62] = Utf8 de/eso/remotehmi/xpath/AbstractPathEntry 
.const [63] = Utf8 matchList 
.const [64] = Utf8 (Ljava/util/Map;Ljava/util/List;)Ljava/util/List; 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/eso/remotehmi/xpath/PoorMansXPath 
.const [69] = Utf8 cache 
.const [70] = Utf8 Lde/eso/remotehmi/xpath/ExpressionCache; 
.const [71] = Utf8 java/util/ArrayList 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (I)V 
.const [74] = Utf8 de/eso/remotehmi/xpath/NodeListWrapper 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Ljava/util/List;)V 
.const [77] = Utf8 de/eso/remotehmi/xpath/ExpressionCache 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 java/util/List 
.const [81] = Utf8 add 
.const [82] = Utf8 (Ljava/lang/Object;)Z 
.const [83] = Utf8 java/util/List 
.const [84] = Utf8 size 
.const [85] = Utf8 ()I 
.const [86] = Utf8 de/eso/remotehmi/xpath/PoorMansXPath 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 cache 
.const [91] = Utf8 Lde/eso/remotehmi/xpath/ExpressionCache; 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 resolve 
.const [96] = Utf8 (Ljava/util/Map;Lorg/w3c/dom/Node;Ljava/lang/String;)Ljava/lang/Object; 
.const [97] = Utf8 <clinit> 
.const [98] = Utf8 ()V 
.end class 
