package liststuff;

/**
 * Generic version of the Link class.
 * @param <E> the type of object being stored.
 */
public class Link<E> {
  // The Link Class is now generic and can put any object in as its item.
  private Link<E> after;
  private Link<E> before;
  private E item;

  public Link(E anItem) {
    this.after = null;
    this.before = null;
    this.item = anItem;
  }

  public Link<E> getAfter() {
    return this.after;
  }

  public Link<E> getBefore() {
    return this.before;
  }

  public E getItem() {
    return this.item;
  }

  public Link<E> setAfter(Link<E> aLink){
    this.after = aLink;
    return this.after;
  }

  public Link<E> setBefore(Link<E> aLink){
    this.before = aLink;
    return this.before;
  }
}
