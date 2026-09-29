.version 50 0 
.class public super [137] 
.super [139] 
.implements [141] 
.field protected [142] [143] 

.method public annotation [145] : [146] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [10] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [151] : [152] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [144] .code stack 5 locals 10 
L0:     aload_1 
L1:     invokeinterface [25] 0 
L6:     astore_2 
L7:     aload_1 
L8:     invokeinterface [26] 0 
L13:    astore_3 
L14:    aload_2 
L15:    ifnonnull L24 
L18:    aload_3 
L19:    ifnonnull L24 
L22:    aconst_null 
L23:    areturn 
L24:    aload_0 
L25:    getfield [11] 
L28:    ifnull L162 
        .catch [3] from L31 to L130 using L134 
L31:    aload_0 
L32:    getfield [11] 
L35:    aload_2 
L36:    aload_3 
L37:    invokeinterface [27] 0 
L42:    astore 4 
L44:    aload 4 
L46:    ifnull L131 
L49:    aload 4 
L51:    invokevirtual [12] 
L54:    astore 5 
L56:    aload 4 
L58:    invokevirtual [13] 
L61:    astore 6 
L63:    aload_1 
L64:    invokeinterface [28] 0 
L69:    astore 7 
L71:    aload 4 
L73:    invokevirtual [14] 
L76:    astore 8 
L78:    aload 4 
L80:    invokevirtual [15] 
L83:    astore 9 
L85:    aload 4 
L87:    invokevirtual [16] 
L90:    astore 10 
L92:    new [29] 
L95:    dup 
L96:    aload 5 
L98:    aload 6 
L100:   aload 7 
L102:   invokespecial [22] 
L105:   astore 11 
L107:   aload 11 
L109:   aload 8 
L111:   invokevirtual [17] 
L114:   aload 11 
L116:   aload 9 
L118:   invokevirtual [18] 
L121:   aload 11 
L123:   aload 10 
L125:   invokevirtual [19] 
L128:   aload 11 
L130:   areturn 
L131:   goto L162 
L134:   astore 4 
L136:   aload 4 
L138:   invokevirtual [20] 
L141:   astore 5 
L143:   aload 5 
L145:   ifnonnull L152 
L148:   aload 4 
L150:   astore 5 
L152:   new [30] 
L155:   dup 
L156:   aload 5 
L158:   invokespecial [23] 
L161:   athrow 
L162:   aconst_null 
L163:   areturn 
L164:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
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
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Field [67] [68] 
.const [25] = InterfaceMethod [69] [70] 
.const [26] = InterfaceMethod [71] [72] 
.const [27] = InterfaceMethod [73] [74] 
.const [28] = InterfaceMethod [75] [76] 
.const [29] = Class [77] 
.const [30] = Class [78] 
.const [31] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [32] = Utf8 org/xml/sax/SAXException 
.const [33] = Utf8 org/apache/xerces/xni/XNIException 
.const [34] = Utf8 org/apache/xerces/util/EntityResolverWrapper 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [37] = Utf8 org/xml/sax/EntityResolver 
.const [38] = Utf8 org/xml/sax/InputSource 
.const [39] = Class [79] 
.const [40] = NameAndType [80] [81] 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Class [85] 
.const [44] = NameAndType [86] [87] 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Class [91] 
.const [48] = NameAndType [92] [93] 
.const [49] = Class [94] 
.const [50] = NameAndType [95] [96] 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Class [112] 
.const [62] = NameAndType [113] [114] 
.const [63] = Class [115] 
.const [64] = NameAndType [116] [117] 
.const [65] = Class [118] 
.const [66] = NameAndType [119] [120] 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [78] = Utf8 org/apache/xerces/xni/XNIException 
.const [79] = Utf8 org/apache/xerces/util/EntityResolverWrapper 
.const [80] = Utf8 setEntityResolver 
.const [81] = Utf8 (Lorg/xml/sax/EntityResolver;)V 
.const [82] = Utf8 org/apache/xerces/util/EntityResolverWrapper 
.const [83] = Utf8 fEntityResolver 
.const [84] = Utf8 Lorg/xml/sax/EntityResolver; 
.const [85] = Utf8 org/xml/sax/InputSource 
.const [86] = Utf8 getPublicId 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 org/xml/sax/InputSource 
.const [89] = Utf8 getSystemId 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 org/xml/sax/InputSource 
.const [92] = Utf8 getByteStream 
.const [93] = Utf8 ()Ljava/io/InputStream; 
.const [94] = Utf8 org/xml/sax/InputSource 
.const [95] = Utf8 getCharacterStream 
.const [96] = Utf8 ()Ljava/io/Reader; 
.const [97] = Utf8 org/xml/sax/InputSource 
.const [98] = Utf8 getEncoding 
.const [99] = Utf8 ()Ljava/lang/String; 
.const [100] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [101] = Utf8 setByteStream 
.const [102] = Utf8 (Ljava/io/InputStream;)V 
.const [103] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [104] = Utf8 setCharacterStream 
.const [105] = Utf8 (Ljava/io/Reader;)V 
.const [106] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [107] = Utf8 setEncoding 
.const [108] = Utf8 (Ljava/lang/String;)V 
.const [109] = Utf8 org/xml/sax/SAXException 
.const [110] = Utf8 getException 
.const [111] = Utf8 ()Ljava/lang/Exception; 
.const [112] = Utf8 java/lang/Object 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [118] = Utf8 org/apache/xerces/xni/XNIException 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/lang/Exception;)V 
.const [121] = Utf8 org/apache/xerces/util/EntityResolverWrapper 
.const [122] = Utf8 fEntityResolver 
.const [123] = Utf8 Lorg/xml/sax/EntityResolver; 
.const [124] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [125] = Utf8 getPublicId 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [128] = Utf8 getExpandedSystemId 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 org/xml/sax/EntityResolver 
.const [131] = Utf8 resolveEntity 
.const [132] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lorg/xml/sax/InputSource; 
.const [133] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [134] = Utf8 getBaseSystemId 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 org/apache/xerces/util/EntityResolverWrapper 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 org/apache/xerces/xni/parser/XMLEntityResolver 
.const [141] = Class [140] 
.const [142] = Utf8 fEntityResolver 
.const [143] = Utf8 Lorg/xml/sax/EntityResolver; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (Lorg/xml/sax/EntityResolver;)V 
.const [149] = Utf8 setEntityResolver 
.const [150] = Utf8 (Lorg/xml/sax/EntityResolver;)V 
.const [151] = Utf8 getEntityResolver 
.const [152] = Utf8 ()Lorg/xml/sax/EntityResolver; 
.const [153] = Utf8 resolveEntity 
.const [154] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Lorg/apache/xerces/xni/parser/XMLInputSource; 
.end class 
