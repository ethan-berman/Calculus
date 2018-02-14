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

<<<<<<< HEAD

public class Main extends JFrame implements ActionListener{

		public static void main(String[] args) {
			//System.out.println("Read...");
			Main m = new Main();


		}

		public void actionPerformed(ActionEvent e) {

			System.out.println("Button clicked  " + e.getActionCommand());


		}
=======
public class Main extends Applet{
	
	public void init(){
		setSize(1024, 768);
	}
	
	public void paint(Graphics g){
		
	}
>>>>>>> f883808f9159f654c198fb68832e75e3cc6b9d56
}
