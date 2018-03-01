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
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class Main extends JFrame implements ActionListener{
		Double demand_elasticity;
		Double demand_constant;
		Double supply_constant;
		Double supply_elasticity;
		static int quantity_bound;
		int supply_bound;
		Equation demand;
		Equation supply;
		JFreeChart chart;
		XYSeriesCollection dataset;
		ChartPanel chartpanel;
		String[] commodity;
		//public String petStrings[];
		public static void main(String[] args) {
			//System.out.println("Read...");
			Main m = new Main();
			quantity_bound = 200;
			//format for input of equations is k*math.pow(x,eps) 
			Equation line = new Equation("5*Math.pow(x,-1)",m);
			//System.out.println(line.integral()[0]);
			

		}
		private void SetUpWindow() {
			setLayout(new BorderLayout());
			dataset = new XYSeriesCollection();
			chart = ChartFactory.createXYLineChart("Supply and Demand", null, null, dataset, PlotOrientation.HORIZONTAL, true, true, true);
			chartpanel = new ChartPanel(chart);
			
			chartpanel.setDomainZoomable(true);
			add(chartpanel,BorderLayout.CENTER);
			
			commodity = new String[7];
			commodity[0] = "Tobacco";
			commodity[1] = "Footwear";
			commodity[2] = "Jewelry";
			commodity[3] = "Electricity";
			commodity[4] = "Taxi";
			commodity[5] = "Newspapers";
			commodity[6] = "Movies";
			///commodity = ["Tobacco", "Footwear", "Jewelry", "Electricity", "Taxi", "Newspapers", "Movies"];
			final JComboBox<String> commodityList = new JComboBox<String>(commodity);
			commodityList.setSelectedIndex(0);
			commodityList.addActionListener(this);
			add(commodityList,BorderLayout.SOUTH);
			String stringCommodity = (String) commodityList.getSelectedItem();

			if(stringCommodity.equals("Tobacco")) {
				demand_elasticity = -0.4556;
				demand_constant = 1.005890000; //note this in billions
			}
			if(stringCommodity.equals("Footwear")) {
				System.out.println("foot selected");
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
			demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
			supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
			System.out.println("ethan");
			
			dataset.addSeries(demand.graph(demand.curve));
			//dataset.addSeries(supply.graph(supply.curve));
			

			//System.out.println(demand.graph(demand.curve)[1]);
			//supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
			//after these functions are declared then evaluate and plot the points on the chart
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600, 600);
			setVisible(true);
			
		}
		private void updateWindow(){
			XYPlot plot = (XYPlot) chart.getPlot();
			XYSeriesCollection new_data = new XYSeriesCollection();
			
			demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
			supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
			
			dataset.addSeries(demand.graph(demand.curve));
			//dataset.addSeries(supply.graph(supply.curve));
			
			plot.setDataset(new_data);
		}
		private Main()
		{
			SetUpWindow();
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Button clicked  " + e.getActionCommand());
			

		}
		
}
