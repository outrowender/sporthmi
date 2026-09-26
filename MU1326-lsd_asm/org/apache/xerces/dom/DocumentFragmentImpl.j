.version 50 0 
.class public super [99] 
.super [101] 
.implements [103] 
.field static final [104] [105] 

.method public annotation [107] : [108] 
    .attribute [106] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [109] : [110] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [106] .code stack 1 locals 0 
L0:     bipush 11 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [106] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [106] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual [8] 
L4:     ifeq L8 
L7:     return 
L8:     aload_0 
L9:     invokevirtual [9] 
L12:    ifeq L19 
L15:    aload_0 
L16:    invokevirtual [10] 
L19:    aload_0 
L20:    getfield [11] 
L23:    astore_1 
L24:    aload_1 
L25:    ifnull L109 
L28:    aload_1 
L29:    getfield [12] 
L32:    astore_2 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    iconst_3 
L38:    if_icmpne L100 
L41:    aload_2 
L42:    ifnull L77 
L45:    aload_2 
L46:    invokevirtual [13] 
L49:    iconst_3 
L50:    if_icmpne L77 
L53:    aload_1 
L54:    checkcast [3] 
L57:    aload_2 
L58:    invokevirtual [14] 
L61:    invokeinterface [21] 0 
L66:    aload_0 
L67:    aload_2 
L68:    invokevirtual [15] 
L71:    pop 
L72:    aload_1 
L73:    astore_2 
L74:    goto L100 
L77:    aload_1 
L78:    invokevirtual [14] 
L81:    ifnull L94 
L84:    aload_1 
L85:    invokevirtual [14] 
L88:    invokevirtual [16] 
L91:    ifne L100 
L94:    aload_0 
L95:    aload_1 
L96:    invokevirtual [15] 
L99:    pop 
L100:   aload_1 
L101:   invokevirtual [17] 
L104:   aload_2 
L105:   astore_1 
L106:   goto L24 
L109:   aload_0 
L110:   iconst_1 
L111:   invokevirtual [18] 
L114:   return 
L115:   nop 
L116:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Method [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Field [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = InterfaceMethod [54] [55] 
.const [22] = Utf8 '#document-fragment' 
.const [23] = Utf8 org/w3c/dom/Text 
.const [24] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [25] = Utf8 org/apache/xerces/dom/ParentNode 
.const [26] = Utf8 org/apache/xerces/dom/ChildNode 
.const [27] = Utf8 java/lang/String 
.const [28] = Class [56] 
.const [29] = NameAndType [57] [58] 
.const [30] = Class [59] 
.const [31] = NameAndType [60] [61] 
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
.const [56] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [57] = Utf8 isNormalized 
.const [58] = Utf8 ()Z 
.const [59] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [60] = Utf8 needsSyncChildren 
.const [61] = Utf8 ()Z 
.const [62] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [63] = Utf8 synchronizeChildren 
.const [64] = Utf8 ()V 
.const [65] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [66] = Utf8 firstChild 
.const [67] = Utf8 Lorg/apache/xerces/dom/ChildNode; 
.const [68] = Utf8 org/apache/xerces/dom/ChildNode 
.const [69] = Utf8 nextSibling 
.const [70] = Utf8 Lorg/apache/xerces/dom/ChildNode; 
.const [71] = Utf8 org/apache/xerces/dom/ChildNode 
.const [72] = Utf8 getNodeType 
.const [73] = Utf8 ()S 
.const [74] = Utf8 org/apache/xerces/dom/ChildNode 
.const [75] = Utf8 getNodeValue 
.const [76] = Utf8 ()Ljava/lang/String; 
.const [77] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [78] = Utf8 removeChild 
.const [79] = Utf8 (Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node; 
.const [80] = Utf8 java/lang/String 
.const [81] = Utf8 length 
.const [82] = Utf8 ()I 
.const [83] = Utf8 org/apache/xerces/dom/ChildNode 
.const [84] = Utf8 normalize 
.const [85] = Utf8 ()V 
.const [86] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [87] = Utf8 isNormalized 
.const [88] = Utf8 (Z)V 
.const [89] = Utf8 org/apache/xerces/dom/ParentNode 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (Lorg/apache/xerces/dom/CoreDocumentImpl;)V 
.const [92] = Utf8 org/apache/xerces/dom/ParentNode 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 org/w3c/dom/Text 
.const [96] = Utf8 appendData 
.const [97] = Utf8 (Ljava/lang/String;)V 
.const [98] = Utf8 org/apache/xerces/dom/DocumentFragmentImpl 
.const [99] = Class [98] 
.const [100] = Utf8 org/apache/xerces/dom/ParentNode 
.const [101] = Class [100] 
.const [102] = Utf8 org/w3c/dom/DocumentFragment 
.const [103] = Class [102] 
.const [104] = Utf8 serialVersionUID 
.const [105] = Utf8 J 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lorg/apache/xerces/dom/CoreDocumentImpl;)V 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 getNodeType 
.const [112] = Utf8 ()S 
.const [113] = Utf8 getNodeName 
.const [114] = Utf8 ()Ljava/lang/String; 
.const [115] = Utf8 normalize 
.const [116] = Utf8 ()V 
.end class 
