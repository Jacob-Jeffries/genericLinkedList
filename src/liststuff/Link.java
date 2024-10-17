package liststuff;

public class Link {
  private Link after;
  private Link before;
  private String item;

  public Link(String anItem) {
    this.after = null;
    this.before = null;
    this.item = anItem;
  }

  public Link getAfter() {
    return this.after;
  }

  public Link getBefore() {
    return this.before;
  }

  public String getItem() {
    return this.item;
  }

  public Link setAfter(Link aLink){
    this.after = aLink;
    return this.after;
  }

  public Link setBefore(Link aLink){
    this.before = aLink;
    return this.before;
  }
}
