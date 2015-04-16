package pos;

public class MnMDecorator extends IcecreamDecorator {

	  public MnMDecorator(Icecream specialIcecream) {
	    super(specialIcecream);
	  }

	  public String makeIcecream() {
	    return specialIcecream.makeIcecream() + addNuts();
	  }

	  private String addNuts() {
	    return " + cruncy nuts";
	  }
}


