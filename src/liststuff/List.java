package liststuff;

public interface List<E> {
  public boolean isEmpty();
  public int sizeIterative();
  public int sizeRecursive(Link<E> aLink);
  public void addFirst(E item);
  public void addLast(E item);
  public E add(int anIndex, E anItem);
  public E removeFirst();
  public E removeLast();
}
