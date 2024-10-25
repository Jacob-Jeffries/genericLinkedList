package liststuff;

public interface List<E> {
  public boolean isEmpty();
  public int size();
  public void addFirst(E item);
  public void addLast(E item);
  public E removeFirst();
  public E removeLast();
}
