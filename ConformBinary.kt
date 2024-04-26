/**
  In this problem we consider unsigned 30-bit integers, i.e. all integers B such that 0 ≤ B < 230.
  
  We say that integer A conforms to integer B if, in all positions where B has bits set to 1, A has corresponding bits set to 1.
  
  For example:
  
  00 0000 1111 0111 1101 1110 0000 1111(BIN) = 16,244,239 conforms to
  00 0000 1100 0110 1101 1110 0000 0001(BIN) = 13,032,961, but
  11 0000 1101 0111 0000 1010 0000 0101(BIN) = 819,399,173 does not conform to
  00 0000 1001 0110 0011 0011 0000 1111(BIN) = 9,843,471.

  For example, for integers:

  A = 11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1,073,741,727,
  B = 11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1,073,741,631, and
  C = 11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1,073,741,679,
  the function should return 8, since there are 8 unsigned 30-bit integers conforming to A, B or C
**/
fun searchNumConforms(A: Int, B: Int, C: Int): Int {
    val conformNumbers = mutableSetOf<String>()
    val binaryStringA = A.toBitBinaryString()
  getConformNumbers(binaryStringA, conformNumbers = conformNumbers)
    
    val binaryStringB = B.toBitBinaryString()
  getConformNumbers(binaryStringB, conformNumbers = conformNumbers)
    
    val binaryStringC = C.toBitBinaryString()
  getConformNumbers(binaryStringC, conformNumbers = conformNumbers)
    
    return conformNumbers.size
}

fun Int.toBitBinaryString(): String = toUInt().toString(2)

tailrec fun getConformNumbers(
    numberString: String, index: Int = 0, 
    conformNumbers: MutableSet<String> = mutableSetOf<String>(), 
    currentConformNumber: String = ""
) {
    if (currentConformNumber.length == numberString.length) {
        conformNumbers.add(currentConformNumber)
    } else {
        val currentBit = numberString[index]
        if (currentBit == '0') {
          getConformNumbers(numberString, index + 1, conformNumbers, currentConformNumber + "0")
            getConformNumbers(numberString, index + 1, conformNumbers, currentConformNumber + "1")
        } else {
            getConformNumbers(numberString, index + 1, conformNumbers, currentConformNumber + "1")
        }

    }
    
}

fun main() {
    val solution = searchNumConforms(1073741727, 1073741631, 1073741679)
    println(solution)
}
