package me.tbsten.kotlin.tuple

data object Tuple0 {
    override fun toString(): String = "()"
}

data class Tuple1<A0>(
    val a0: A0,
) {
    override fun toString(): String = "($a0)"
}

typealias Tuple2<A1, A2> = Pair<A1, A2>

typealias Tuple3<A1, A2, A3> = Triple<A1, A2, A3>

data class Tuple4<A0, A1, A2, A3>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3)"
}

data class Tuple5<A0, A1, A2, A3, A4>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4)"
}

data class Tuple6<A0, A1, A2, A3, A4, A5>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5)"
}

data class Tuple7<A0, A1, A2, A3, A4, A5, A6>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6)"
}

data class Tuple8<A0, A1, A2, A3, A4, A5, A6, A7>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7)"
}

data class Tuple9<A0, A1, A2, A3, A4, A5, A6, A7, A8>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8)"
}

data class Tuple10<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9)"
}

data class Tuple11<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10)"
}

data class Tuple12<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11)"
}

data class Tuple13<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12)"
}

data class Tuple14<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13)"
}

data class Tuple15<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
    val a14: A14,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13, $a14)"
}

data class Tuple16<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
    val a14: A14,
    val a15: A15,
) {
    override fun toString(): String =
        "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13, $a14, $a15)"
}

data class Tuple17<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
    val a14: A14,
    val a15: A15,
    val a16: A16,
) {
    override fun toString(): String =
        "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13, $a14, $a15, $a16)"
}

data class Tuple18<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
    val a14: A14,
    val a15: A15,
    val a16: A16,
    val a17: A17,
) {
    override fun toString(): String =
        "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13, $a14, $a15, $a16, $a17)"
}

data class Tuple19<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
    val a14: A14,
    val a15: A15,
    val a16: A16,
    val a17: A17,
    val a18: A18,
) {
    override fun toString(): String =
        "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13, $a14, $a15, $a16, $a17, $a18)"
}

data class Tuple20<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
    val a4: A4,
    val a5: A5,
    val a6: A6,
    val a7: A7,
    val a8: A8,
    val a9: A9,
    val a10: A10,
    val a11: A11,
    val a12: A12,
    val a13: A13,
    val a14: A14,
    val a15: A15,
    val a16: A16,
    val a17: A17,
    val a18: A18,
    val a19: A19,
) {
    override fun toString(): String =
        "($a0, $a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9, $a10, $a11, $a12, $a13, $a14, $a15, $a16, $a17, $a18, $a19)"
}

