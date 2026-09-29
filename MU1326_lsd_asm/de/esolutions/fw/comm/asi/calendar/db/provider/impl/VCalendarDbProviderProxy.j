.version 50 0 
.class public super [193] 
.super [195] 
.implements [197] 
.implements [199] 
.field private static final [200] [201] 
.field private [202] [203] 

.method public [205] : [206] 
    .attribute [204] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     new [41] 
L7:     dup 
L8:     ldc [3] 
L10:    iload_1 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    invokespecial [31] 
L18:    astore_3 
L19:    new [42] 
L22:    dup 
L23:    aload_2 
L24:    invokespecial [32] 
L27:    astore 4 
L29:    aload_0 
L30:    new [43] 
L33:    dup 
L34:    aload_3 
L35:    aload 4 
L37:    getstatic [8] 
L40:    invokespecial [34] 
L43:    putfield [44] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [207] : [208] 
    .attribute [204] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [204] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     iconst_2 
L5:     aconst_null 
L6:     invokevirtual [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [204] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     iconst_4 
L5:     aconst_null 
L6:     invokevirtual [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [204] .code stack 6 locals 1 
L0:     new [45] 
L3:     dup 
L4:     aload_0 
L5:     iload_1 
L6:     iload_2 
L7:     aload_3 
L8:     invokespecial [35] 
L11:    astore 4 
L13:    aload_0 
L14:    getfield [21] 
L17:    bipush 18 
L19:    aload 4 
L21:    invokevirtual [22] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore 4 
        .catch [11] from L9 to L27 using L30 
L9:     aload 4 
L11:    iload_1 
L12:    invokevirtual [23] 
L15:    aload 4 
L17:    iload_2 
L18:    invokevirtual [23] 
L21:    aload 4 
L23:    aload_3 
L24:    invokevirtual [24] 
L27:    goto L45 
L30:    astore 5 
L32:    new [47] 
L35:    dup 
L36:    aload 5 
L38:    invokevirtual [25] 
L41:    invokespecial [37] 
L44:    athrow 
L45:    aload_0 
L46:    getfield [21] 
L49:    bipush 12 
L51:    aload 4 
L53:    invokevirtual [22] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_2 
        .catch [11] from L8 to L13 using L16 
L8:     aload_2 
L9:     iload_1 
L10:    invokevirtual [23] 
L13:    goto L29 
L16:    astore_3 
L17:    new [47] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [25] 
L25:    invokespecial [37] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [21] 
L33:    bipush 14 
L35:    aload_2 
L36:    invokevirtual [22] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [204] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     bipush 10 
L6:     aconst_null 
L7:     invokevirtual [22] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [204] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     bipush 8 
L6:     aconst_null 
L7:     invokevirtual [22] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_2 
        .catch [11] from L8 to L13 using L16 
L8:     aload_2 
L9:     aload_1 
L10:    invokevirtual [26] 
L13:    goto L29 
L16:    astore_3 
L17:    new [47] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [25] 
L25:    invokespecial [37] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [21] 
L33:    bipush 16 
L35:    aload_2 
L36:    invokevirtual [22] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_2 
        .catch [11] from L8 to L13 using L16 
L8:     aload_2 
L9:     iload_1 
L10:    invokevirtual [27] 
L13:    goto L29 
L16:    astore_3 
L17:    new [47] 
L20:    dup 
L21:    aload_3 
L22:    invokevirtual [25] 
L25:    invokespecial [37] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [21] 
L33:    bipush 7 
L35:    aload_2 
L36:    invokevirtual [22] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [204] .code stack 4 locals 1 
L0:     new [48] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     invokespecial [38] 
L9:     astore_2 
L10:    aload_0 
L11:    getfield [21] 
L14:    bipush 29 
L16:    aload_2 
L17:    invokevirtual [22] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_3 
        .catch [11] from L8 to L13 using L16 
L8:     aload_3 
L9:     lload_1 
L10:    invokevirtual [28] 
L13:    goto L31 
L16:    astore 4 
L18:    new [47] 
L21:    dup 
L22:    aload 4 
L24:    invokevirtual [25] 
L27:    invokespecial [37] 
L30:    athrow 
L31:    aload_0 
L32:    getfield [21] 
L35:    bipush 21 
L37:    aload_3 
L38:    invokevirtual [22] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [204] .code stack 4 locals 1 
L0:     new [49] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     invokespecial [39] 
L9:     astore_2 
L10:    aload_0 
L11:    getfield [21] 
L14:    bipush 31 
L16:    aload_2 
L17:    invokevirtual [22] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_3 
        .catch [11] from L8 to L13 using L16 
L8:     aload_3 
L9:     lload_1 
L10:    invokevirtual [29] 
L13:    goto L31 
L16:    astore 4 
L18:    new [47] 
L21:    dup 
L22:    aload 4 
L24:    invokevirtual [25] 
L27:    invokespecial [37] 
L30:    athrow 
L31:    aload_0 
L32:    getfield [21] 
L35:    bipush 23 
L37:    aload_3 
L38:    invokevirtual [22] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [204] .code stack 5 locals 1 
L0:     new [50] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     invokespecial [40] 
L10:    astore_3 
L11:    aload_0 
L12:    getfield [21] 
L15:    bipush 25 
L17:    aload_3 
L18:    invokevirtual [22] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [204] .code stack 3 locals 2 
L0:     new [46] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_3 
        .catch [11] from L8 to L13 using L16 
L8:     aload_3 
L9:     lload_1 
L10:    invokevirtual [28] 
L13:    goto L31 
L16:    astore 4 
L18:    new [47] 
L21:    dup 
L22:    aload 4 
L24:    invokevirtual [25] 
L27:    invokespecial [37] 
L30:    athrow 
L31:    aload_0 
L32:    getfield [21] 
L35:    bipush 19 
L37:    aload_3 
L38:    invokevirtual [22] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method static [239] : [240] 
    .attribute [204] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     invokestatic [17] 
L5:     putstatic [33] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = String [52] 
.const [4] = String [53] 
.const [5] = String [54] 
.const [6] = Class [55] 
.const [7] = Class [56] 
.const [8] = Field [57] [58] 
.const [9] = Class [59] 
.const [10] = Class [60] 
.const [11] = Class [61] 
.const [12] = Class [62] 
.const [13] = Class [63] 
.const [14] = Class [64] 
.const [15] = Class [65] 
.const [16] = String [66] 
.const [17] = Method [67] [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Field [72] [73] 
.const [22] = Method [74] [75] 
.const [23] = Method [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Method [108] [109] 
.const [40] = Method [110] [111] 
.const [41] = Class [112] 
.const [42] = Class [113] 
.const [43] = Class [114] 
.const [44] = Field [115] [116] 
.const [45] = Class [117] 
.const [46] = Class [118] 
.const [47] = Class [119] 
.const [48] = Class [120] 
.const [49] = Class [121] 
.const [50] = Class [122] 
.const [51] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [52] = Utf8 '70b84daa-4b74-4908-83c0-ef7f5a885f6e' 
.const [53] = Utf8 '612c617b-a23f-54f8-82dd-2e34540b7597' 
.const [54] = Utf8 'asi.calendar.db.provider.VCalendarDbProvider' 
.const [55] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [56] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [57] = Class [123] 
.const [58] = NameAndType [124] [125] 
.const [59] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$1 
.const [60] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [61] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [62] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [63] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$2 
.const [64] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$3 
.const [65] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$4 
.const [66] = Utf8 'PROXY.asi.calendar.db.provider.VCalendarDbProvider' 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Class [165] 
.const [97] = NameAndType [166] [167] 
.const [98] = Class [168] 
.const [99] = NameAndType [169] [170] 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Class [177] 
.const [105] = NameAndType [178] [179] 
.const [106] = Class [180] 
.const [107] = NameAndType [181] [182] 
.const [108] = Class [183] 
.const [109] = NameAndType [184] [185] 
.const [110] = Class [186] 
.const [111] = NameAndType [187] [188] 
.const [112] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [113] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [114] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [115] = Class [189] 
.const [116] = NameAndType [190] [191] 
.const [117] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$1 
.const [118] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [119] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [120] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$2 
.const [121] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$3 
.const [122] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$4 
.const [123] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy 
.const [124] = Utf8 context 
.const [125] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [126] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [127] = Utf8 getContext 
.const [128] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [129] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy 
.const [130] = Utf8 proxy 
.const [131] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [132] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [133] = Utf8 remoteCallMethod 
.const [134] = Utf8 (SLde/esolutions/fw/util/serializer/ISerializable;)V 
.const [135] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [136] = Utf8 putInt32 
.const [137] = Utf8 (I)V 
.const [138] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [139] = Utf8 putOptionalInt64VarArray 
.const [140] = Utf8 ([J)V 
.const [141] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [142] = Utf8 getMessage 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [145] = Utf8 putOptionalInt32VarArray 
.const [146] = Utf8 ([I)V 
.const [147] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [148] = Utf8 putEnum 
.const [149] = Utf8 (I)V 
.const [150] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [151] = Utf8 putInt64 
.const [152] = Utf8 (J)V 
.const [153] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [154] = Utf8 putUInt64 
.const [155] = Utf8 (J)V 
.const [156] = Utf8 java/lang/Object 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [162] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderReplyService 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply;)V 
.const [165] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy 
.const [166] = Utf8 context 
.const [167] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [168] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IReplyService;Lde/esolutions/fw/comm/core/CallContext;)V 
.const [171] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$1 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Lde/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy;II[Lorg/dsi/ifc/calendar/VCalendar;)V 
.const [174] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [175] = Utf8 <init> 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (Ljava/lang/String;)V 
.const [180] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$2 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Lde/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy;Lorg/dsi/ifc/calendar/CalendarConfig;)V 
.const [183] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$3 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Lde/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy;Lorg/dsi/ifc/calendar/ProfileInfo;)V 
.const [186] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy$4 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (Lde/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy;Lorg/dsi/ifc/global/DateTime;Lorg/dsi/ifc/global/DateTime;)V 
.const [189] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy 
.const [190] = Utf8 proxy 
.const [191] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [192] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy 
.const [193] = Class [192] 
.const [194] = Utf8 java/lang/Object 
.const [195] = Class [194] 
.const [196] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProvider 
.const [197] = Class [196] 
.const [198] = Utf8 de/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderC 
.const [199] = Class [198] 
.const [200] = Utf8 context 
.const [201] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [202] = Utf8 proxy 
.const [203] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [204] = Utf8 Code 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (ILde/esolutions/fw/comm/asi/calendar/db/provider/VCalendarDbProviderReply;)V 
.const [207] = Utf8 getProxy 
.const [208] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [209] = Utf8 beginTransaction 
.const [210] = Utf8 ()V 
.const [211] = Utf8 commitTransaction 
.const [212] = Utf8 ()V 
.const [213] = Utf8 addEntries 
.const [214] = Utf8 (II[Lorg/dsi/ifc/calendar/VCalendar;)V 
.const [215] = Utf8 removeEntries 
.const [216] = Utf8 (II[J)V 
.const [217] = Utf8 removeProfile 
.const [218] = Utf8 (I)V 
.const [219] = Utf8 removeAll 
.const [220] = Utf8 ()V 
.const [221] = Utf8 getVersion 
.const [222] = Utf8 ()V 
.const [223] = Utf8 setActiveProfiles 
.const [224] = Utf8 ([I)V 
.const [225] = Utf8 forceGetDataResult 
.const [226] = Utf8 (I)V 
.const [227] = Utf8 setCalendarConfig 
.const [228] = Utf8 (Lorg/dsi/ifc/calendar/CalendarConfig;)V 
.const [229] = Utf8 getCalendarConfig 
.const [230] = Utf8 (J)V 
.const [231] = Utf8 insertProfile 
.const [232] = Utf8 (Lorg/dsi/ifc/calendar/ProfileInfo;)V 
.const [233] = Utf8 getCalendarEntry 
.const [234] = Utf8 (J)V 
.const [235] = Utf8 getCalendarSummaries 
.const [236] = Utf8 (Lorg/dsi/ifc/global/DateTime;Lorg/dsi/ifc/global/DateTime;)V 
.const [237] = Utf8 deleteProfile 
.const [238] = Utf8 (J)V 
.const [239] = Utf8 <clinit> 
.const [240] = Utf8 ()V 
.end class 
