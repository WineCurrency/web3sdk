package org.fisco.bcos.web3j.crypto;

import org.fisco.bcos.web3j.tx.TransactionConstant;
import org.fisco.bcos.web3j.utils.Numeric;

import java.math.BigInteger;

/**
 * Transaction class used for signing transactions locally.<br>
 * For the specification, refer to p4 of the <a href="http://gavwood.com/paper.pdf">
 * yellow paper</a>.
 */
public class RawTransaction {

    private BigInteger randomid;
    private BigInteger gasPrice;
    private BigInteger gasLimit;
    private BigInteger blockLimit;
    private String to;
    private BigInteger value;
    private String data;
    private String contractName;
    private BigInteger version = TransactionConstant.version;
    private BigInteger type;//0 new合约,1 call

    protected RawTransaction(BigInteger randomid, BigInteger gasPrice, BigInteger gasLimit, BigInteger blockLimit, String to,
                           BigInteger value, String data) {
        this.randomid = randomid;
        this.gasPrice = gasPrice;
        this.gasLimit = gasLimit;
        this.blockLimit = blockLimit;

            this.to = to;

        this.value = value;

        if (data != null) {
            this.data = Numeric.cleanHexPrefix(data);
        }
    }

    public static RawTransaction createContractTransaction(
            BigInteger randomid, BigInteger gasPrice, BigInteger gasLimit, BigInteger blockLimit, BigInteger value,
            String init) {

        return new RawTransaction(randomid, gasPrice, gasLimit, blockLimit,"", value, init);
    }

    public static RawTransaction createEtherTransaction(
            BigInteger randomid, BigInteger gasPrice, BigInteger gasLimit, BigInteger blockLimit, String to,
            BigInteger value) {

        return new RawTransaction(randomid, gasPrice, gasLimit, blockLimit, to, value, "");

    }

    public static RawTransaction createTransaction(
            BigInteger randomid, BigInteger gasPrice, BigInteger gasLimit, BigInteger blockLimit, String to,
            String data) {
        return createTransaction(randomid, gasPrice, gasLimit, blockLimit, to, BigInteger.ZERO, data);
    }

    public static RawTransaction createTransaction(
            BigInteger randomid, BigInteger gasPrice, BigInteger gasLimit, BigInteger blockLimit, String to,
            BigInteger value, String data) {

        return new RawTransaction(randomid, gasPrice, gasLimit, blockLimit, to, value, data);
    }

    public BigInteger getRandomid() {
        return randomid;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public BigInteger getBlockLimit() {
        return blockLimit;
    }

    public String getTo() {
        return to;
    }

    public BigInteger getValue() {
        return value;
    }

    public String getData() {
        return data;
    }

    public BigInteger getType() { return type; }

    public BigInteger getVersion() { return version; }

    public String getContractName() { return contractName; }
}