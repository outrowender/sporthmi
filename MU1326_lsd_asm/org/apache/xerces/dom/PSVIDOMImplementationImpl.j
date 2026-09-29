.version 50 0 
.class public super [103] 
.super [105] 
.field static [106] [107] 

.method public annotation [109] : [110] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [111] : [112] 
    .attribute [108] .code stack 1 locals 0 
L0:     getstatic [2] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [108] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [20] 
L6:     ifne L18 
L9:     aload_1 
L10:    ldc [3] 
L12:    invokevirtual [15] 
L15:    ifeq L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [108] .code stack 6 locals 2 
L0:     aload_3 
L1:     ifnull L30 
L4:     aload_3 
L5:     invokeinterface [24] 0 
L10:    ifnull L30 
L13:    new [25] 
L16:    dup 
L17:    iconst_4 
L18:    ldc [5] 
L20:    ldc [6] 
L22:    aconst_null 
L23:    invokestatic [7] 
L26:    invokespecial [21] 
L29:    athrow 
L30:    new [26] 
L33:    dup 
L34:    aload_3 
L35:    invokespecial [22] 
L38:    astore 4 
L40:    aload 4 
L42:    aload_1 
L43:    aload_2 
L44:    invokevirtual [16] 
L47:    astore 5 
L49:    aload 4 
L51:    aload 5 
L53:    invokevirtual [17] 
L56:    pop 
L57:    aload 4 
L59:    areturn 
L60:    
    .end code 
.end method 

.method static [117] : [118] 
    .attribute [108] .code stack 2 locals 0 
L0:     new [27] 
L3:     dup 
L4:     invokespecial [23] 
L7:     putstatic [19] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [28] [29] 
.const [3] = String [30] 
.const [4] = Class [31] 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = Method [34] [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = InterfaceMethod [61] [62] 
.const [25] = Class [63] 
.const [26] = Class [64] 
.const [27] = Class [65] 
.const [28] = Class [66] 
.const [29] = NameAndType [67] [68] 
.const [30] = Utf8 psvi 
.const [31] = Utf8 org/w3c/dom/DOMException 
.const [32] = Utf8 'http://www.w3.org/TR/1998/REC-xml-19980210' 
.const [33] = Utf8 WRONG_DOCUMENT_ERR 
.const [34] = Class [69] 
.const [35] = NameAndType [70] [71] 
.const [36] = Utf8 org/apache/xerces/dom/PSVIDocumentImpl 
.const [37] = Utf8 org/apache/xerces/dom/PSVIDOMImplementationImpl 
.const [38] = Utf8 org/apache/xerces/dom/CoreDOMImplementationImpl 
.const [39] = Utf8 java/lang/String 
.const [40] = Utf8 org/w3c/dom/DocumentType 
.const [41] = Utf8 org/apache/xerces/dom/DOMMessageFormatter 
.const [42] = Utf8 org/apache/xerces/dom/DocumentImpl 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Class [93] 
.const [58] = NameAndType [94] [95] 
.const [59] = Class [96] 
.const [60] = NameAndType [97] [98] 
.const [61] = Class [99] 
.const [62] = NameAndType [100] [101] 
.const [63] = Utf8 org/w3c/dom/DOMException 
.const [64] = Utf8 org/apache/xerces/dom/PSVIDocumentImpl 
.const [65] = Utf8 org/apache/xerces/dom/PSVIDOMImplementationImpl 
.const [66] = Utf8 org/apache/xerces/dom/PSVIDOMImplementationImpl 
.const [67] = Utf8 singleton 
.const [68] = Utf8 Lorg/apache/xerces/dom/PSVIDOMImplementationImpl; 
.const [69] = Utf8 org/apache/xerces/dom/DOMMessageFormatter 
.const [70] = Utf8 formatMessage 
.const [71] = Utf8 (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String; 
.const [72] = Utf8 java/lang/String 
.const [73] = Utf8 equalsIgnoreCase 
.const [74] = Utf8 (Ljava/lang/String;)Z 
.const [75] = Utf8 org/apache/xerces/dom/DocumentImpl 
.const [76] = Utf8 createElementNS 
.const [77] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/Element; 
.const [78] = Utf8 org/apache/xerces/dom/DocumentImpl 
.const [79] = Utf8 appendChild 
.const [80] = Utf8 (Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node; 
.const [81] = Utf8 org/apache/xerces/dom/CoreDOMImplementationImpl 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 org/apache/xerces/dom/PSVIDOMImplementationImpl 
.const [85] = Utf8 singleton 
.const [86] = Utf8 Lorg/apache/xerces/dom/PSVIDOMImplementationImpl; 
.const [87] = Utf8 org/apache/xerces/dom/CoreDOMImplementationImpl 
.const [88] = Utf8 hasFeature 
.const [89] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [90] = Utf8 org/w3c/dom/DOMException 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (SLjava/lang/String;)V 
.const [93] = Utf8 org/apache/xerces/dom/PSVIDocumentImpl 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (Lorg/w3c/dom/DocumentType;)V 
.const [96] = Utf8 org/apache/xerces/dom/PSVIDOMImplementationImpl 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 org/w3c/dom/DocumentType 
.const [100] = Utf8 getOwnerDocument 
.const [101] = Utf8 ()Lorg/w3c/dom/Document; 
.const [102] = Utf8 org/apache/xerces/dom/PSVIDOMImplementationImpl 
.const [103] = Class [102] 
.const [104] = Utf8 org/apache/xerces/dom/CoreDOMImplementationImpl 
.const [105] = Class [104] 
.const [106] = Utf8 singleton 
.const [107] = Utf8 Lorg/apache/xerces/dom/PSVIDOMImplementationImpl; 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 getDOMImplementation 
.const [112] = Utf8 ()Lorg/w3c/dom/DOMImplementation; 
.const [113] = Utf8 hasFeature 
.const [114] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [115] = Utf8 createDocument 
.const [116] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/DocumentType;)Lorg/w3c/dom/Document; 
.const [117] = Utf8 <clinit> 
.const [118] = Utf8 ()V 
.end class 
