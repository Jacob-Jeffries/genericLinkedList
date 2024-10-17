package liststuff;

public class LinkedList {
  private Link first;
  private Link last;

  /**
   * Getter - added to facilitate the recursive sizeRecursive().
   *
   * @return
   */
  public Link getFirst() {
    return first;
  }

  /**
   * Getter - added to facilitate the recursive sizeRecursive().
   *
   * @return
   */
  public Link getLast() {
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
  Link aLink = this.first;
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
  public int sizeRecursive(Link aLink) {
    Link head = aLink;

    if (head == null) {
      return 0;
    }
    // It took a second to understand how to return this:
    // (1 + (1 + (1 + (0)))
    return 1 + this.sizeRecursive(head.getAfter());
  }

  public String get(int index) {
    if (index < 0 || index > (this.sizeRecursive(this.getFirst()) - 1) || this.isEmpty()) {
      return null;
    }
    Link aLink = this.first;
    int count = 0;
    while (count < index && aLink != null) {
      aLink = aLink.getAfter();
      ++count;
    }
    return aLink.getItem();
  }

  public Link getLink(int index){
    if (index < 0 || index > (this.sizeRecursive(this.getFirst()) - 1) || this.isEmpty()) {
      return null;
    }
    Link aLink = this.first;
    int count = 0;
    while (count < index && aLink != null) {
      aLink = aLink.getAfter();
      ++count;
    }
    return aLink;
  }

  public void addFirst(String anItem) {
    Link oldFirstLink = this.first;
    Link aLink = new Link(anItem);
    this.first = aLink;
    if (this.last != null) {
      aLink.setAfter(oldFirstLink);
      oldFirstLink.setBefore(aLink);
    } else {
      this.last = aLink;
    }
    return;
  }

  public void addLast(String anItem) {
    Link oldLastLink = this.last;
    Link aLink = new Link(anItem);
    this.last = aLink;
    if (this.first != null) {
      aLink.setBefore(oldLastLink);
      oldLastLink.setAfter(aLink);
    } else {
      this.first = aLink;
    }
    return;
  }

  public String add(int anIndex, String anItem){
    Link aLink = new Link(anItem);
    if (anIndex < 0 || anIndex > this.sizeRecursive(first)){
      return null;
    } else if (anIndex == 0){
      this.addFirst(anItem);
      return getFirst().getItem();
    } else if (anIndex == (this.sizeRecursive(first))){
      this.addLast(anItem);
      return getLast().getItem();
    } else {
      Link after = this.getLink(anIndex);
      Link before = this.getLink(anIndex -1);
      after.setBefore(aLink);
      before.setAfter(aLink);
      aLink.setBefore(before);
      aLink.setAfter(after);
      return aLink.getItem();
    }
  }

  public String removeFirst() {
    if (this.isEmpty()) {
      return null;
    }
    Link oldFirstLink = this.first;
    this.first = oldFirstLink.getAfter();
    if (this.first == null) {
      this.last = null;
    } else {
      this.first.setBefore(null);
      oldFirstLink.setAfter(null);
    }
    return oldFirstLink.getItem();
  }

  public String removeLast() {
    if (this.isEmpty()) {
      return null;
    }
    Link oldLastLink = this.last;
    this.last = oldLastLink.getBefore();
    if (this.last == null) {
      this.first = null;
    } else {
      this.last.setAfter(null);
      oldLastLink.setBefore(null);
    }
    return oldLastLink.getItem();
  }

  public String remove(int anIndex){
    if (anIndex < 0 || anIndex > this.sizeRecursive(first)){
      return null;
    } else if (anIndex == 0){
       return this.removeFirst();
    } else if (anIndex == (this.sizeRecursive(first)-1)){
      return this.removeLast();
    } else {
      String removed = this.get(anIndex);
      Link after = this.getLink(anIndex).getAfter();
      Link before = this.getLink(anIndex).getBefore();
      after.setBefore(before);
      before.setAfter(after);
      return removed;
    }
  }

}
