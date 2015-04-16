package pos;

public class StrawberryDecorator extends IcecreamDecorator {

	  public StrawberryDecorator(Icecream specialIcecream) {
	    super(specialIcecream);
	  }

	  public String makeIcecream() {
	    return specialIcecream.makeIcecream() + addHoney();
	  }

	  private String addHoney() {
	    return " + sweet honey";
	  }
}
