package org.bcos.web3j.abi.datatypes.generated;

import java.math.BigInteger;
import org.bcos.web3j.abi.datatypes.Ufixed;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modifiy!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.AbiTypesGenerator} to update.</p>
 */
public class Ufixed216x32 extends Ufixed {
    public static final Ufixed216x32 DEFAULT = new Ufixed216x32(BigInteger.ZERO);

    public Ufixed216x32(BigInteger value) {
        super(216, 32, value);
    }

    public Ufixed216x32(int mBitSize, int nBitSize, BigInteger m, BigInteger n) {
        super(216, 32, m, n);
    }
}