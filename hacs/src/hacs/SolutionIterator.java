package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionIterator implements Iterator {
  SolutionList solutionlist;
  int currentSolutionNumber = -1;

  public SolutionIterator() {
  }

  public SolutionIterator(SolutionList thesolutionlist) {
    solutionlist = thesolutionlist;
    moveToHead();
  }

  public void moveToHead() {
    currentSolutionNumber = -1;
  }

  public boolean hasNext() {
    if (currentSolutionNumber >= solutionlist.size() - 1)
      return false;
    else
      return true;
  }

  public Object next() {
    if (hasNext() == true) {
      currentSolutionNumber++;
      return solutionlist.get(currentSolutionNumber);
    } else {
      return null;
    }
  }

  /// get the next Solution that fits the Username;
  /**
   * Get the next Solution that fits the Username
   * 
   * @param UserName
   * @return
   */
  public Object next(String UserName) {
    Solution theSolution;
    theSolution = (Solution) next();
    while (theSolution != null) {
      if (UserName.compareTo(theSolution.theAuthor) == 0) {
        return theSolution;
      }
      theSolution = (Solution) next();
    }
    return null;
  }

  public void remove() {
    solutionlist.remove(currentSolutionNumber);
  }

}