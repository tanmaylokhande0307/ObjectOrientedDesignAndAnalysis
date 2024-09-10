package applyOOPS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List guitars;

  public Inventory() {
    guitars = new LinkedList<>();
  }

  public void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  public List search(GuitarSpec searchSpec) {
	  List<Guitar> matchingGuitars = new LinkedList<Guitar>();
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      GuitarSpec guitarSpec = guitar.getSpec();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      Builder builder = searchSpec.getBuilder();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitarSpec.getBuilder())))
        continue;
      String model = searchSpec.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitarSpec.getModel())))
        continue;
      Type type = searchSpec.getType();
      if ((type != null) && (!searchSpec.equals("")) &&
          (!type.equals(guitarSpec.getType())))
        continue;
      Wood backWood = searchSpec.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitarSpec.getBackWood())))
        continue;
      Wood topWood = searchSpec.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitarSpec.getTopWood())))
        continue;
      matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
}