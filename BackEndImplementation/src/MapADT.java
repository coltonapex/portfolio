// --== CS400 File Header Information ==--
// Name: <Colton Carlino>
// Email: <ccarlino@wisc.edu>
// Team: CC
// TA: <Yeping>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {
  public boolean put(KeyType key, ValueType value);

  public ValueType get(KeyType key) throws NoSuchElementException;

  public int size();

  public boolean containsKey(KeyType key);

  public ValueType remove(KeyType key);

  public void clear();
}