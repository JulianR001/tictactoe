
/**
 * Write a description of class negative here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.ArrayList;
public class negative
{
   public ArrayList<Integer> apcsaListAddNegations(ArrayList<Integer> lst) {
 int x = 0;
  for(int z = 0; z < lst.size(); z++) {
    for(int y = z; y < lst.size(); y++) {
      if(lst.get(y) < 0)
      inverse(lst, lst.get(y));
    }
  }
  return lst;
}
  public void inverse(ArrayList<Integer> lst, int x) {
    for(int i = lst.indexOf(x) + 1; i < lst.size(); i++) {
      if(lst.get(i) == x*-1)
      x++;
      else lst.add(lst.indexOf(x) + 1, x*-1);
    }
  }
}
