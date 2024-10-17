package liststuff;

public class LinkedList<E> {
  private Link<E> first;
  private Link<E> last;

  /**
   * Getter - added to facilitate the recursive sizeRecursive().
   *
   * @return
   */
  public Link<E> getFirst() {
    return first;
  }

  /**
   * Getter - added to facilitate the recursive sizeRecursive().
   *
   * @return
   */
  public Link<E> getLast() {
    return last;
  }

  public boolean isEmpty() {
    return ((this.first == null) && (this.last == null));
  }

  /**
   * Iterative sizeRecursive method.
   *
   * @return
   *         It returns an int.
   */
  public int sizeIterative(){
  if(this.isEmpty()){
  return 0;
  }
  Link<E> aLink = this.first;
  int count = 0;
  while(aLink != null){
  ++count;
  aLink = aLink.getAfter();
  }
  return count;
  }

  /**
   * Recursive sizeRecursive method.
   *
   * @param aLink
   *              This is the first link in the linked list.
   * @return
   *         It return an int.
   */
  public int sizeRecursive(Link<E> aLink) {
    Link<E> head = aLink;

    if (head == null) {
      return 0;
    }
    // It took a second to understand how to return this:
    // (1 + (1 + (1 + (0)))
    return 1 + this.sizeRecursive(head.getAfter());
  }

  public E get(int index) {
    if (index < 0 || index > (this.sizeRecursive(this.getFirst()) - 1) || this.isEmpty()) {
      return null;
    }
    Link<E> aLink = this.first;
    int count = 0;
    while (count < index && aLink != null) {
      aLink = aLink.getAfter();
      ++count;
    }
    return aLink.getItem();
  }

  public Link<E> getLink(int index){
    if (index < 0 || index > (this.sizeRecursive(this.getFirst()) - 1) || this.isEmpty()) {
      return null;
    }
    Link<E> aLink = this.first;
    int count = 0;
    while (count < index && aLink != null) {
      aLink = aLink.getAfter();
      ++count;
    }
    return aLink;
  }

  public void addFirst(E anItem) {
    Link<E> oldFirstLink = this.first;
    Link<E> aLink = new Link<E>(anItem);
    this.first = aLink;
    if (this.last != null) {
      aLink.setAfter(oldFirstLink);
      oldFirstLink.setBefore(aLink);
    } else {
      this.last = aLink;
    }
    return;
  }

  public void addLast(E anItem) {
    Link<E> oldLastLink = this.last;
    Link<E> aLink = new Link<E>(anItem);
    this.last = aLink;
    if (this.first != null) {
      aLink.setBefore(oldLastLink);
      oldLastLink.setAfter(aLink);
    } else {
      this.first = aLink;
    }
    return;
  }

  public E add(int anIndex, E anItem){
    Link<E> aLink = new Link<E>(anItem);
    if (anIndex < 0 || anIndex > this.sizeRecursive(first)){
      return null;
    } else if (anIndex == 0){
      this.addFirst(anItem);
      return getFirst().getItem();
    } else if (anIndex == (this.sizeRecursive(first))){
      this.addLast(anItem);
      return getLast().getItem();
    } else {
      Link<E> after = this.getLink(anIndex);
      Link<E> before = this.getLink(anIndex -1);
      after.setBefore(aLink);
      before.setAfter(aLink);
      aLink.setBefore(before);
      aLink.setAfter(after);
      return aLink.getItem();
    }
  }

  public E removeFirst() {
    if (this.isEmpty()) {
      return null;
    }
    Link<E> oldFirstLink = this.first;
    this.first = oldFirstLink.getAfter();
    if (this.first == null) {
      this.last = null;
    } else {
      this.first.setBefore(null);
      oldFirstLink.setAfter(null);
    }
    return oldFirstLink.getItem();
  }

  public E removeLast() {
    if (this.isEmpty()) {
      return null;
    }
    Link<E> oldLastLink = this.last;
    this.last = oldLastLink.getBefore();
    if (this.last == null) {
      this.first = null;
    } else {
      this.last.setAfter(null);
      oldLastLink.setBefore(null);
    }
    return oldLastLink.getItem();
  }

  public E remove(int anIndex){
    if (anIndex < 0 || anIndex > this.sizeRecursive(first)){
      return null;
    } else if (anIndex == 0){
       return this.removeFirst();
    } else if (anIndex == (this.sizeRecursive(first)-1)){
      return this.removeLast();
    } else {
      E removed = this.get(anIndex);
      Link<E> after = this.getLink(anIndex).getAfter();
      Link<E> before = this.getLink(anIndex).getBefore();
      after.setBefore(before);
      before.setAfter(after);
      return removed;
    }
  }

}
