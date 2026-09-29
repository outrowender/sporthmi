.version 50 0 
.class public super [163] 
.super [165] 
.implements [167] 
.implements [169] 
.field private static final [170] [171] 
.field private [172] [173] 

.method public [175] : [176] 
    .attribute [174] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     new [35] 
L7:     dup 
L8:     ldc [3] 
L10:    iload_1 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    invokespecial [28] 
L18:    astore_3 
L19:    new [36] 
L22:    dup 
L23:    aload_2 
L24:    invokespecial [29] 
L27:    astore 4 
L29:    aload_0 
L30:    new [37] 
L33:    dup 
L34:    aload_3 
L35:    aload 4 
L37:    getstatic [8] 
L40:    invokespecial [31] 
L43:    putfield [38] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [177] : [178] 
    .attribute [174] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     bipush 8 
L6:     aconst_null 
L7:     invokevirtual [19] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     bipush 10 
L6:     aconst_null 
L7:     invokevirtual [19] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore 5 
        .catch [10] from L9 to L21 using L24 
L9:     aload 5 
L11:    lload_1 
L12:    invokevirtual [20] 
L15:    aload 5 
L17:    lload_3 
L18:    invokevirtual [20] 
L21:    goto L39 
L24:    astore 6 
L26:    new [40] 
L29:    dup 
L30:    aload 6 
L32:    invokevirtual [21] 
L35:    invokespecial [33] 
L38:    athrow 
L39:    aload_0 
L40:    getfield [18] 
L43:    bipush 12 
L45:    aload 5 
L47:    invokevirtual [19] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     bipush 13 
L6:     aconst_null 
L7:     invokevirtual [19] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [174] .code stack 5 locals 1 
L0:     new [41] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     iload_2 
L7:     invokespecial [34] 
L10:    astore_3 
L11:    aload_0 
L12:    getfield [18] 
L15:    bipush 6 
L17:    aload_3 
L18:    invokevirtual [19] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_3 
        .catch [10] from L8 to L18 using L21 
L8:     aload_3 
L9:     aload_1 
L10:    invokevirtual [22] 
L13:    aload_3 
L14:    iload_2 
L15:    invokevirtual [23] 
L18:    goto L36 
L21:    astore 4 
L23:    new [40] 
L26:    dup 
L27:    aload 4 
L29:    invokevirtual [21] 
L32:    invokespecial [33] 
L35:    athrow 
L36:    aload_0 
L37:    getfield [18] 
L40:    iconst_4 
L41:    aload_3 
L42:    invokevirtual [19] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_2 
        .catch [10] from L8 to L13 using L16 
L8:     aload_2 
L9:     aload_1 
L10:    invokevirtual [24] 
L13:    goto L29 
L16:    astore_3 
L17:    new [40] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [21] 
L25:    invokespecial [33] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [18] 
L33:    bipush 16 
L35:    aload_2 
L36:    invokevirtual [19] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_2 
        .catch [10] from L8 to L13 using L16 
L8:     aload_2 
L9:     iload_1 
L10:    invokevirtual [25] 
L13:    goto L29 
L16:    astore_3 
L17:    new [40] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [21] 
L25:    invokespecial [33] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [18] 
L33:    bipush 17 
L35:    aload_2 
L36:    invokevirtual [19] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     bipush 15 
L6:     aconst_null 
L7:     invokevirtual [19] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_2 
        .catch [10] from L8 to L13 using L16 
L8:     aload_2 
L9:     aload_1 
L10:    invokevirtual [24] 
L13:    goto L29 
L16:    astore_3 
L17:    new [40] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [21] 
L25:    invokespecial [33] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [18] 
L33:    iconst_2 
L34:    aload_2 
L35:    invokevirtual [19] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_2 
        .catch [10] from L8 to L13 using L16 
L8:     aload_2 
L9:     iload_1 
L10:    invokevirtual [25] 
L13:    goto L29 
L16:    astore_3 
L17:    new [40] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [21] 
L25:    invokespecial [33] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [18] 
L33:    iconst_3 
L34:    aload_2 
L35:    invokevirtual [19] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     iconst_1 
L5:     aconst_null 
L6:     invokevirtual [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [174] .code stack 3 locals 2 
L0:     new [39] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_3 
        .catch [10] from L8 to L18 using L21 
L8:     aload_3 
L9:     aload_1 
L10:    invokevirtual [26] 
L13:    aload_3 
L14:    aload_2 
L15:    invokevirtual [26] 
L18:    goto L36 
L21:    astore 4 
L23:    new [40] 
L26:    dup 
L27:    aload 4 
L29:    invokevirtual [21] 
L32:    invokespecial [33] 
L35:    athrow 
L36:    aload_0 
L37:    getfield [18] 
L40:    bipush 20 
L42:    aload_3 
L43:    invokevirtual [19] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method static [205] : [206] 
    .attribute [174] .code stack 1 locals 0 
L0:     ldc [13] 
L2:     invokestatic [14] 
L5:     putstatic [30] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = String [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = Class [46] 
.const [7] = Class [47] 
.const [8] = Field [48] [49] 
.const [9] = Class [50] 
.const [10] = Class [51] 
.const [11] = Class [52] 
.const [12] = Class [53] 
.const [13] = String [54] 
.const [14] = Method [55] [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Field [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Class [94] 
.const [36] = Class [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = Class [99] 
.const [40] = Class [100] 
.const [41] = Class [101] 
.const [42] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [43] = Utf8 '44d50592-991b-517a-926e-e7513bf821ce' 
.const [44] = Utf8 a18091b4-6261-5e53-af9e-c31b1f36c4d0 
.const [45] = Utf8 'dsi.map.DSIMapViewerRouteBlock' 
.const [46] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [47] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [48] = Class [102] 
.const [49] = NameAndType [103] [104] 
.const [50] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [51] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [52] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [53] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy$1 
.const [54] = Utf8 'PROXY.dsi.map.DSIMapViewerRouteBlock' 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Class [111] 
.const [63] = NameAndType [112] [113] 
.const [64] = Class [114] 
.const [65] = NameAndType [115] [116] 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [95] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [96] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [97] = Class [159] 
.const [98] = NameAndType [160] [161] 
.const [99] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [100] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [101] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy$1 
.const [102] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy 
.const [103] = Utf8 context 
.const [104] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [105] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [106] = Utf8 getContext 
.const [107] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [108] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy 
.const [109] = Utf8 proxy 
.const [110] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [111] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [112] = Utf8 remoteCallMethod 
.const [113] = Utf8 (SLde/esolutions/fw/util/serializer/ISerializable;)V 
.const [114] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [115] = Utf8 putInt64 
.const [116] = Utf8 (J)V 
.const [117] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [118] = Utf8 getMessage 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [121] = Utf8 putOptionalInt64VarArray 
.const [122] = Utf8 ([J)V 
.const [123] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [124] = Utf8 putBool 
.const [125] = Utf8 (Z)V 
.const [126] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [127] = Utf8 putOptionalInt32VarArray 
.const [128] = Utf8 ([I)V 
.const [129] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [130] = Utf8 putInt32 
.const [131] = Utf8 (I)V 
.const [132] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [133] = Utf8 putOptionalString 
.const [134] = Utf8 (Ljava/lang/String;)V 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [141] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockReplyService 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Lde/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply;)V 
.const [144] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy 
.const [145] = Utf8 context 
.const [146] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [147] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IReplyService;Lde/esolutions/fw/comm/core/CallContext;)V 
.const [150] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Ljava/lang/String;)V 
.const [156] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy$1 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy;Lorg/dsi/ifc/map/Point;I)V 
.const [159] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy 
.const [160] = Utf8 proxy 
.const [161] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [162] = Utf8 de/esolutions/fw/comm/dsi/map/impl/DSIMapViewerRouteBlockProxy 
.const [163] = Class [162] 
.const [164] = Utf8 java/lang/Object 
.const [165] = Class [164] 
.const [166] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlock 
.const [167] = Class [166] 
.const [168] = Utf8 de/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockC 
.const [169] = Class [168] 
.const [170] = Utf8 context 
.const [171] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [172] = Utf8 proxy 
.const [173] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [174] = Utf8 Code 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (ILde/esolutions/fw/comm/dsi/map/DSIMapViewerRouteBlockReply;)V 
.const [177] = Utf8 getProxy 
.const [178] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [179] = Utf8 rBMarkNextSegment 
.const [180] = Utf8 ()V 
.const [181] = Utf8 rBMarkPreviousSegment 
.const [182] = Utf8 ()V 
.const [183] = Utf8 rBSetSegmentScales 
.const [184] = Utf8 (JJ)V 
.const [185] = Utf8 rBStartOfSelection 
.const [186] = Utf8 ()V 
.const [187] = Utf8 pickSegmentUidsInScreenSpace 
.const [188] = Utf8 (Lorg/dsi/ifc/map/Point;I)V 
.const [189] = Utf8 highLightSegmentUidsInMap 
.const [190] = Utf8 ([JZ)V 
.const [191] = Utf8 setNotification 
.const [192] = Utf8 ([I)V 
.const [193] = Utf8 setNotification 
.const [194] = Utf8 (I)V 
.const [195] = Utf8 setNotification 
.const [196] = Utf8 ()V 
.const [197] = Utf8 clearNotification 
.const [198] = Utf8 ([I)V 
.const [199] = Utf8 clearNotification 
.const [200] = Utf8 (I)V 
.const [201] = Utf8 clearNotification 
.const [202] = Utf8 ()V 
.const [203] = Utf8 yySet 
.const [204] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [205] = Utf8 <clinit> 
.const [206] = Utf8 ()V 
.end class 
