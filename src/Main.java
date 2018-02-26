import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.*;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class Main extends JFrame implements ActionListener{
		String demand;
		String supply;
		static int quantity_bound;
		int supply_bound;
		//public String petStrings[];
		public static void main(String[] args) {
			//System.out.println("Read...");
			Main m = new Main();
			quantity_bound = 200;
			//format for input of equations is k*math.pow(x,eps) 
			Equation line = new Equation("5*Math.pow(x,-1)",m);
			for(double i=0.0;i<line.graph(line.curve).length;i += .25){
				//System.out.println(line.graph(line.curve)[(int) (i/.25)]);
			}
			//System.out.println(line.integral()[0]);
			
			Equation supply = new Equation("5*Math.pow(x,2)", m);
			

		}

		private void SetUpWindow() {
			setLayout(new BorderLayout());

			XYSeriesCollection dataset = new XYSeriesCollection();
			JFreeChart chart = ChartFactory.createXYLineChart("Berman is Stupid", null, null, dataset, PlotOrientation.HORIZONTAL, true, true, true);
			ChartPanel chartpanel = new ChartPanel(chart);
			chartpanel.setDomainZoomable(true);
			add(chartpanel,BorderLayout.CENTER);

			String[] commodity = { "Tobacco", "Footwear", "Jewelry", "Electricity", "Taxi", "Newspapers", "Movies" };
			final JComboBox<String> commodityList = new JComboBox<String>(commodity);
			commodityList.setSelectedIndex(0);
			commodityList.addActionListener(this);
			add(commodityList,BorderLayout.SOUTH);
			String stringCommodity = (String) commodityList.getSelectedItem();

			if(stringCommodity.equals("Tobacco")) {

			}
			if(stringCommodity.equals("Footwear")) {

			}
			if(stringCommodity.equals("Jewelry")) {

			}
			if(stringCommodity.equals("Electricity")) {

			}
			if(stringCommodity.equals("Taxi")) {

			}
			if(stringCommodity.equals("Newspapers")) {

			}
			if(stringCommodity.equals("Movies")) {

			}

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600, 600);
			setVisible(true);

		}
		private Main()
		{
			SetUpWindow();
		}

		public void actionPerformed(ActionEvent e) {

			System.out.println("Button clicked  " + e.getActionCommand());

			

		}
		
}
