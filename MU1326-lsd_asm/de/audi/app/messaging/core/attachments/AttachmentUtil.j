.version 50 0 
.class public final super [87] 
.super [89] 
.field private static final [90] [91] 
.field private static final [92] [93] 
.field private static final [94] [95] 

.method public annotation [97] : [98] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [99] : [100] 
    .attribute [96] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     astore_1 
L5:     iconst_0 
L6:     istore_2 
L7:     aload_0 
L8:     invokevirtual [16] 
L11:    invokestatic [2] 
L14:    ifne L27 
L17:    aload_0 
L18:    invokevirtual [16] 
L21:    ldc [3] 
L23:    invokevirtual [17] 
L26:    istore_2 
L27:    ldc [4] 
L29:    aload_1 
L30:    invokevirtual [18] 
L33:    ifne L49 
L36:    ldc [5] 
L38:    aload_1 
L39:    invokevirtual [18] 
L42:    ifne L49 
L45:    iload_2 
L46:    ifeq L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public static [101] : [102] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [103] : [104] 
    .attribute [96] .code stack 4 locals 4 
L0:     iconst_0 
L1:     istore_2 
L2:     iconst_0 
L3:     istore_3 
L4:     iload_3 
L5:     aload_0 
L6:     arraylength 
L7:     if_icmpge L28 
L10:    aload_0 
L11:    iload_3 
L12:    aaload 
L13:    invokestatic [7] 
L16:    ifeq L22 
L19:    iinc 2 1 
L22:    iinc 3 1 
L25:    goto L4 
L28:    iload_2 
L29:    aload_0 
L30:    arraylength 
L31:    if_icmpne L39 
L34:    aload_0 
L35:    astore_1 
L36:    goto L82 
L39:    iload_2 
L40:    anewarray [8] 
L43:    astore_1 
L44:    iconst_0 
L45:    istore_3 
L46:    iconst_0 
L47:    istore 4 
L49:    iload 4 
L51:    aload_0 
L52:    arraylength 
L53:    if_icmpge L82 
L56:    aload_0 
L57:    iload 4 
L59:    aaload 
L60:    invokestatic [7] 
L63:    ifeq L76 
L66:    aload_1 
L67:    iload_3 
L68:    iinc 3 1 
L71:    aload_0 
L72:    iload 4 
L74:    aaload 
L75:    aastore 
L76:    iinc 4 1 
L79:    goto L49 
L82:    aload_1 
L83:    areturn 
L84:    
    .end code 
.end method 

.method public static [105] : [106] 
    .attribute [96] .code stack 2 locals 7 
L0:     iconst_1 
L1:     istore_3 
L2:     iload_0 
L3:     ifeq L124 
L6:     iload_1 
L7:     ifeq L124 
L10:    aload_2 
L11:    ifnull L19 
L14:    aload_2 
L15:    arraylength 
L16:    ifne L24 
L19:    iconst_0 
L20:    istore_3 
L21:    goto L124 
L24:    iconst_0 
L25:    istore 4 
L27:    iload_1 
L28:    iconst_2 
L29:    if_icmpne L36 
L32:    iconst_1 
L33:    goto L37 
L36:    iconst_0 
L37:    istore 5 
L39:    iload_1 
L40:    iconst_1 
L41:    if_icmpne L48 
L44:    iconst_1 
L45:    goto L49 
L48:    iconst_0 
L49:    istore 6 
L51:    iconst_0 
L52:    istore 7 
L54:    iload 7 
L56:    aload_2 
L57:    arraylength 
L58:    if_icmpge L117 
L61:    aload_2 
L62:    iload 7 
L64:    aaload 
L65:    astore 8 
L67:    aload 8 
L69:    invokestatic [7] 
L72:    ifne L111 
L75:    iload 5 
L77:    ifne L93 
L80:    iload 6 
L82:    ifeq L97 
L85:    aload 8 
L87:    invokestatic [9] 
L90:    ifeq L97 
L93:    iconst_1 
L94:    goto L98 
L97:    iconst_0 
L98:    istore 9 
L100:   iload 9 
L102:   ifeq L111 
L105:   iconst_1 
L106:   istore 4 
L108:   goto L117 
L111:   iinc 7 1 
L114:   goto L54 
L117:   iload 4 
L119:   ifeq L124 
L122:   iconst_0 
L123:   istore_3 
L124:   iload_3 
L125:   areturn 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public static [107] : [108] 
    .attribute [96] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_2 
L2:     if_icmpne L9 
L5:     iconst_1 
L6:     goto L10 
L9:     iconst_0 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method private static [109] : [110] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     invokevirtual [20] 
L7:     ifnull L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = String [24] 
.const [4] = String [25] 
.const [5] = String [26] 
.const [6] = Method [27] [28] 
.const [7] = Method [29] [30] 
.const [8] = Class [31] 
.const [9] = Method [32] [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Class [53] 
.const [23] = NameAndType [54] [55] 
.const [24] = Utf8 '.vcf' 
.const [25] = Utf8 text/vcard 
.const [26] = Utf8 text/x-vcard 
.const [27] = Class [56] 
.const [28] = NameAndType [57] [58] 
.const [29] = Class [59] 
.const [30] = NameAndType [60] [61] 
.const [31] = Utf8 org/dsi/ifc/messaging/AttachmentInformation 
.const [32] = Class [62] 
.const [33] = NameAndType [63] [64] 
.const [34] = Utf8 de/audi/app/messaging/core/attachments/AttachmentUtil 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [37] = Utf8 java/lang/String 
.const [38] = Utf8 org/dsi/ifc/global/ResourceLocator 
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
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [54] = Utf8 isNullOrEmpty 
.const [55] = Utf8 (Ljava/lang/String;)Z 
.const [56] = Utf8 de/audi/app/messaging/core/attachments/AttachmentUtil 
.const [57] = Utf8 isVCardAttachment 
.const [58] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.const [59] = Utf8 de/audi/app/messaging/core/attachments/AttachmentUtil 
.const [60] = Utf8 isDownloadedAttachment 
.const [61] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.const [62] = Utf8 de/audi/app/messaging/core/attachments/AttachmentUtil 
.const [63] = Utf8 isSupportedAttachment 
.const [64] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.const [65] = Utf8 org/dsi/ifc/messaging/AttachmentInformation 
.const [66] = Utf8 getMimeType 
.const [67] = Utf8 ()Ljava/lang/String; 
.const [68] = Utf8 org/dsi/ifc/messaging/AttachmentInformation 
.const [69] = Utf8 getName 
.const [70] = Utf8 ()Ljava/lang/String; 
.const [71] = Utf8 java/lang/String 
.const [72] = Utf8 endsWith 
.const [73] = Utf8 (Ljava/lang/String;)Z 
.const [74] = Utf8 java/lang/String 
.const [75] = Utf8 equals 
.const [76] = Utf8 (Ljava/lang/Object;)Z 
.const [77] = Utf8 org/dsi/ifc/messaging/AttachmentInformation 
.const [78] = Utf8 getAttachmentPath 
.const [79] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [80] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [81] = Utf8 getUrl 
.const [82] = Utf8 ()Ljava/lang/String; 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/app/messaging/core/attachments/AttachmentUtil 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 MIME_TYPE_VCARD 
.const [91] = Utf8 Ljava/lang/String; 
.const [92] = Utf8 MIME_TYPE_X_VCARD 
.const [93] = Utf8 Ljava/lang/String; 
.const [94] = Utf8 VCARD_SUFFIX 
.const [95] = Utf8 Ljava/lang/String; 
.const [96] = Utf8 Code 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 isVCardAttachment 
.const [100] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.const [101] = Utf8 isSupportedAttachment 
.const [102] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.const [103] = Utf8 getDownloadedAttachments 
.const [104] = Utf8 ([Lorg/dsi/ifc/messaging/AttachmentInformation;)[Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [105] = Utf8 isAttachmentDownloadComplete 
.const [106] = Utf8 (ZI[Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.const [107] = Utf8 isMimeEncoded 
.const [108] = Utf8 (I)Z 
.const [109] = Utf8 isDownloadedAttachment 
.const [110] = Utf8 (Lorg/dsi/ifc/messaging/AttachmentInformation;)Z 
.end class 
