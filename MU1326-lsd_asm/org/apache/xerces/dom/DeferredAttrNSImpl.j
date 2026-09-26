.version 50 0 
.class public final super [137] 
.super [139] 
.implements [141] 
.field static final [142] [143] 
.field protected transient [144] [145] 

.method [147] : [148] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aconst_null 
L3:     invokespecial [21] 
L6:     aload_0 
L7:     iload_2 
L8:     putfield [22] 
L11:    aload_0 
L12:    iconst_1 
L13:    invokevirtual [7] 
L16:    aload_0 
L17:    iconst_1 
L18:    invokevirtual [8] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [149] : [150] 
    .attribute [146] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [151] : [152] 
    .attribute [146] .code stack 4 locals 4 
L0:     aload_0 
L1:     iconst_0 
L2:     invokevirtual [7] 
L5:     aload_0 
L6:     invokevirtual [9] 
L9:     checkcast [2] 
L12:    astore_1 
L13:    aload_0 
L14:    aload_1 
L15:    aload_0 
L16:    getfield [6] 
L19:    invokevirtual [10] 
L22:    putfield [23] 
L25:    aload_0 
L26:    getfield [11] 
L29:    bipush 58 
L31:    invokevirtual [12] 
L34:    istore_2 
L35:    iload_2 
L36:    ifge L50 
L39:    aload_0 
L40:    aload_0 
L41:    getfield [11] 
L44:    putfield [24] 
L47:    goto L64 
L50:    aload_0 
L51:    aload_0 
L52:    getfield [11] 
L55:    iload_2 
L56:    iconst_1 
L57:    iadd 
L58:    invokevirtual [13] 
L61:    putfield [24] 
L64:    aload_1 
L65:    aload_0 
L66:    getfield [6] 
L69:    invokevirtual [14] 
L72:    istore_3 
L73:    aload_0 
L74:    iload_3 
L75:    bipush 32 
L77:    iand 
L78:    ifeq L85 
L81:    iconst_1 
L82:    goto L86 
L85:    iconst_0 
L86:    invokevirtual [15] 
L89:    aload_0 
L90:    iload_3 
L91:    sipush 512 
L94:    iand 
L95:    ifeq L102 
L98:    iconst_1 
L99:    goto L103 
L102:   iconst_0 
L103:   invokevirtual [16] 
L106:   aload_0 
L107:   aload_1 
L108:   aload_0 
L109:   getfield [6] 
L112:   invokevirtual [17] 
L115:   putfield [25] 
L118:   aload_1 
L119:   aload_0 
L120:   getfield [6] 
L123:   invokevirtual [18] 
L126:   istore 4 
L128:   aload_0 
L129:   aload_1 
L130:   iload 4 
L132:   invokevirtual [19] 
L135:   putfield [26] 
L138:   return 
L139:   nop 
L140:   
    .end code 
.end method 

.method protected [153] : [154] 
    .attribute [146] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     checkcast [2] 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [6] 
L14:    invokevirtual [20] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Class [29] 
.const [5] = Class [30] 
.const [6] = Field [31] [32] 
.const [7] = Method [33] [34] 
.const [8] = Method [35] [36] 
.const [9] = Method [37] [38] 
.const [10] = Method [39] [40] 
.const [11] = Field [41] [42] 
.const [12] = Method [43] [44] 
.const [13] = Method [45] [46] 
.const [14] = Method [47] [48] 
.const [15] = Method [49] [50] 
.const [16] = Method [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Field [63] [64] 
.const [23] = Field [65] [66] 
.const [24] = Field [67] [68] 
.const [25] = Field [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [28] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [29] = Utf8 org/apache/xerces/dom/AttrNSImpl 
.const [30] = Utf8 java/lang/String 
.const [31] = Class [73] 
.const [32] = NameAndType [74] [75] 
.const [33] = Class [76] 
.const [34] = NameAndType [77] [78] 
.const [35] = Class [79] 
.const [36] = NameAndType [80] [81] 
.const [37] = Class [82] 
.const [38] = NameAndType [83] [84] 
.const [39] = Class [85] 
.const [40] = NameAndType [86] [87] 
.const [41] = Class [88] 
.const [42] = NameAndType [89] [90] 
.const [43] = Class [91] 
.const [44] = NameAndType [92] [93] 
.const [45] = Class [94] 
.const [46] = NameAndType [95] [96] 
.const [47] = Class [97] 
.const [48] = NameAndType [98] [99] 
.const [49] = Class [100] 
.const [50] = NameAndType [101] [102] 
.const [51] = Class [103] 
.const [52] = NameAndType [104] [105] 
.const [53] = Class [106] 
.const [54] = NameAndType [107] [108] 
.const [55] = Class [109] 
.const [56] = NameAndType [110] [111] 
.const [57] = Class [112] 
.const [58] = NameAndType [113] [114] 
.const [59] = Class [115] 
.const [60] = NameAndType [116] [117] 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Class [124] 
.const [66] = NameAndType [125] [126] 
.const [67] = Class [127] 
.const [68] = NameAndType [128] [129] 
.const [69] = Class [130] 
.const [70] = NameAndType [131] [132] 
.const [71] = Class [133] 
.const [72] = NameAndType [134] [135] 
.const [73] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [74] = Utf8 fNodeIndex 
.const [75] = Utf8 I 
.const [76] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [77] = Utf8 needsSyncData 
.const [78] = Utf8 (Z)V 
.const [79] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [80] = Utf8 needsSyncChildren 
.const [81] = Utf8 (Z)V 
.const [82] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [83] = Utf8 ownerDocument 
.const [84] = Utf8 ()Lorg/apache/xerces/dom/CoreDocumentImpl; 
.const [85] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [86] = Utf8 getNodeName 
.const [87] = Utf8 (I)Ljava/lang/String; 
.const [88] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [89] = Utf8 name 
.const [90] = Utf8 Ljava/lang/String; 
.const [91] = Utf8 java/lang/String 
.const [92] = Utf8 indexOf 
.const [93] = Utf8 (I)I 
.const [94] = Utf8 java/lang/String 
.const [95] = Utf8 substring 
.const [96] = Utf8 (I)Ljava/lang/String; 
.const [97] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [98] = Utf8 getNodeExtra 
.const [99] = Utf8 (I)I 
.const [100] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [101] = Utf8 isSpecified 
.const [102] = Utf8 (Z)V 
.const [103] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [104] = Utf8 isIdAttribute 
.const [105] = Utf8 (Z)V 
.const [106] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [107] = Utf8 getNodeURI 
.const [108] = Utf8 (I)Ljava/lang/String; 
.const [109] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [110] = Utf8 getLastChild 
.const [111] = Utf8 (I)I 
.const [112] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [113] = Utf8 getTypeInfo 
.const [114] = Utf8 (I)Ljava/lang/Object; 
.const [115] = Utf8 org/apache/xerces/dom/DeferredDocumentImpl 
.const [116] = Utf8 synchronizeChildren 
.const [117] = Utf8 (Lorg/apache/xerces/dom/AttrImpl;I)V 
.const [118] = Utf8 org/apache/xerces/dom/AttrNSImpl 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lorg/apache/xerces/dom/CoreDocumentImpl;Ljava/lang/String;)V 
.const [121] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [122] = Utf8 fNodeIndex 
.const [123] = Utf8 I 
.const [124] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [125] = Utf8 name 
.const [126] = Utf8 Ljava/lang/String; 
.const [127] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [128] = Utf8 localName 
.const [129] = Utf8 Ljava/lang/String; 
.const [130] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [131] = Utf8 namespaceURI 
.const [132] = Utf8 Ljava/lang/String; 
.const [133] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [134] = Utf8 type 
.const [135] = Utf8 Ljava/lang/Object; 
.const [136] = Utf8 org/apache/xerces/dom/DeferredAttrNSImpl 
.const [137] = Class [136] 
.const [138] = Utf8 org/apache/xerces/dom/AttrNSImpl 
.const [139] = Class [138] 
.const [140] = Utf8 org/apache/xerces/dom/DeferredNode 
.const [141] = Class [140] 
.const [142] = Utf8 serialVersionUID 
.const [143] = Utf8 J 
.const [144] = Utf8 fNodeIndex 
.const [145] = Utf8 I 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Lorg/apache/xerces/dom/DeferredDocumentImpl;I)V 
.const [149] = Utf8 getNodeIndex 
.const [150] = Utf8 ()I 
.const [151] = Utf8 synchronizeData 
.const [152] = Utf8 ()V 
.const [153] = Utf8 synchronizeChildren 
.const [154] = Utf8 ()V 
.end class 
