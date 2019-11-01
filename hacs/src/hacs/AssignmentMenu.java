package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog
{
    public static final int LENGTH = 575;
    public static final int BREADTH = 330;
    
    abstract void showMenu(Assignment assignment, Person person);
    
    public AssignmentMenu()
    {
      setModal(true);
      setSize(LENGTH, BREADTH);
    }
}