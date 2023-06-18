// --== CS400 File Header Information ==--
// Name: Casey Lin
// Email: cmlin@wisc.edu
// Team: CC
// TA: Yeping
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * HashPair class, provides a wrapper class for the pairs of values needed
 * for the assignment
 * @param <KeyType> generic key type
 * @param <ValueType> generic value type
 */
public class HashPair<KeyType, ValueType> {
    private KeyType k;
    private ValueType v;

    /*
     * instantiates a new instance of HashPair.
     */
    public HashPair(KeyType k, ValueType v) {
        this.k = k;
        this.v = v;
    }

    /*
     * returns the key of this HashPair.
     */
    public KeyType getKey() {
        return k;
    }

    /*
     * returns the value of this HashPair.
     */
    public ValueType getValue() {
        return v;
    }

    /**
     * equals method for HashPair, just for sanity
     * @param pair another HashPair
     * @return whether the 2 HashPairs are identical
     */
    public boolean equals(HashPair pair) {
        return pair.getKey().equals(k);
    }

    /**
     * returns the string rep of HashPair.
     * @return the string representation of this HashPair
     */
    @Override
    public String toString() {
        return k.toString() + ", " + v.toString();
    }
}