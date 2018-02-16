import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;


public class Main extends JFrame implements ActionListener{
		String demand;
		String supply;
		static int quantity_bound;
		int supply_bound;
		public static void main(String[] args) {
			//System.out.println("Read...");
			Main m = new Main();
			quantity_bound = 20;
			Equation line = new Equation("3^2",m);
			for(int i=0;i<line.graph().length;i++){
				System.out.println(line.graph()[i]);
			}

		}

		public void actionPerformed(ActionEvent e) {

			System.out.println("Button clicked  " + e.getActionCommand());


		}
		
}
