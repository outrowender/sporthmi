.version 50 0 
.class public super [11] 
.super [13] 
.field private static final [14] [15] 
.field private static final [16] [17] 
.field private static final [18] [19] 
.field private static final [20] [21] 
.field private static final [22] [23] 
.field private static final [24] [25] 
.field private static final [26] [27] 
.field private static final [28] [29] 
.field private static final [30] [31] 
.field private static final [32] [33] 
.field private static final [34] [35] 
.field private static final [36] [37] 
.field private static final [38] [39] 
.field private static final [40] [41] 

.method public annotation [43] : [44] 
    .attribute [42] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [3] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [45] : [46] 
    .attribute [42] .code stack 2 locals 2 
L0:     iload_0 
L1:     sipush 8184 
L4:     iand 
L5:     istore_1 
L6:     iload_0 
L7:     bipush 6 
L9:     iand 
L10:    istore_2 
L11:    iload_1 
L12:    lookupswitch 
            8 : L186 
            16 : L218 
            24 : L218 
            64 : L152 
            72 : L152 
            80 : L218 
            1032 : L186 
            1040 : L218 
            1048 : L218 
            1088 : L152 
            1096 : L152 
            1104 : L218 
            2048 : L186 
            2056 : L186 
            2064 : L218 
            2072 : L218 
            default : L253 

L152:   iload_2 
L153:   lookupswitch 
            2 : L182 
            4 : L180 
            default : L184 

L180:   iconst_4 
L181:   areturn 
L182:   iconst_5 
L183:   areturn 
L184:   iconst_3 
L185:   areturn 
L186:   iload_2 
L187:   lookupswitch 
            2 : L214 
            4 : L212 
            default : L216 

L212:   iconst_1 
L213:   areturn 
L214:   iconst_2 
L215:   areturn 
L216:   iconst_0 
L217:   areturn 
L218:   iload_2 
L219:   lookupswitch 
            2 : L247 
            4 : L244 
            default : L250 

L244:   bipush 7 
L246:   areturn 
L247:   bipush 8 
L249:   areturn 
L250:   bipush 6 
L252:   areturn 
L253:   iload_2 
L254:   lookupswitch 
            2 : L283 
            4 : L280 
            default : L286 

L280:   bipush 10 
L282:   areturn 
L283:   bipush 11 
L285:   areturn 
L286:   bipush 9 
L288:   areturn 
L289:   nop 
L290:   nop 
L291:   nop 
L292:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [4] 
.const [3] = Method [5] [6] 
.const [4] = Utf8 java/lang/Object 
.const [5] = Class [7] 
.const [6] = NameAndType [8] [9] 
.const [7] = Utf8 java/lang/Object 
.const [8] = Utf8 <init> 
.const [9] = Utf8 ()V 
.const [10] = Utf8 de/audi/app/sdsmanager/apps/adb/ADBSDSUtils$TelNumberTypeToModelValueMapping 
.const [11] = Class [10] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [12] 
.const [14] = Utf8 ADB_SELECTED_NUMBER_TYPE_FIX 
.const [15] = Utf8 I 
.const [16] = Utf8 ADB_SELECTED_NUMBER_TYPE_FIX_PRIVATE 
.const [17] = Utf8 I 
.const [18] = Utf8 ADB_SELECTED_NUMBER_TYPE_FIX_WORK 
.const [19] = Utf8 I 
.const [20] = Utf8 ADB_SELECTED_NUMBER_TYPE_MOBILE 
.const [21] = Utf8 I 
.const [22] = Utf8 ADB_SELECTED_NUMBER_TYPE_MOBILE_PRIVATE 
.const [23] = Utf8 I 
.const [24] = Utf8 ADB_SELECTED_NUMBER_TYPE_MOBILE_WORK 
.const [25] = Utf8 I 
.const [26] = Utf8 ADB_SELECTED_NUMBER_TYPE_FAX 
.const [27] = Utf8 I 
.const [28] = Utf8 ADB_SELECTED_NUMBER_TYPE_FAX_PRIVATE 
.const [29] = Utf8 I 
.const [30] = Utf8 ADB_SELECTED_NUMBER_TYPE_FAX_WORK 
.const [31] = Utf8 I 
.const [32] = Utf8 ADB_SELECTED_NUMBER_TYPE_NONE 
.const [33] = Utf8 I 
.const [34] = Utf8 ADB_SELECTED_NUMBER_TYPE_PRIVATE 
.const [35] = Utf8 I 
.const [36] = Utf8 ADB_SELECTED_NUMBER_TYPE_WORK 
.const [37] = Utf8 I 
.const [38] = Utf8 PHONETYPES_ALL_CATS_PATTERN 
.const [39] = Utf8 I 
.const [40] = Utf8 PHONETYPES_ALL_TYPES_PATTERN 
.const [41] = Utf8 I 
.const [42] = Utf8 Code 
.const [43] = Utf8 <init> 
.const [44] = Utf8 ()V 
.const [45] = Utf8 getModelValueForTelNumberType 
.const [46] = Utf8 (I)I 
.end class 
