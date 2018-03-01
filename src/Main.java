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
		Double demand_elasticity;
		Double demand_constant;
		Double supply_constant;
		Double supply_elasticity;
		String demand_number;
	private JComboBox<String> commodityList;
		static int quantity_bound;
		int supply_bound;
		Equation demand;
		Equation supply;
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
			
			
			String[] commodity = {"Tobacco", "Footwear", "Jewelry", "Electricity", "Taxi", "Newspapers", "Movies" };

			commodityList = new JComboBox<String>(commodity);
			commodityList.setSelectedIndex(0);
			commodityList.addActionListener(this);
			add(commodityList,BorderLayout.SOUTH);

			String stringCommodity = (String) commodityList.getSelectedItem();
			if(stringCommodity.equals("Tobacco")) {
				demand_elasticity = -0.4556;
				demand_constant = 1.005890000; //note this in billions
				demand_number = "in Billions";
				demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
				supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
			}



			printChart();

			//System.out.println(demand.graph(demand.curve)[1]);
			//supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
			//after these functions are declared then evaluate and plot the points on the chart
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600, 600);
			setVisible(true);
			
		}

		private void printChart()
		{
			XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(demand.graph(demand.curve));
			//dataset.addSeries(supply.graph(supply.curve));
			JFreeChart chart = ChartFactory.createXYLineChart("Supply and Demand", null, null, dataset, PlotOrientation.HORIZONTAL, true, true, true);
			ChartPanel chartpanel = new ChartPanel(chart);
			chartpanel.setDomainZoomable(true);
			add(chartpanel,BorderLayout.CENTER);
			chartpanel.repaint();


		}
		private Main()
		{
			SetUpWindow();
		}

		public void actionPerformed(ActionEvent e) {

			System.out.println("Button clicked  " + e.getActionCommand());

			if(e.getActionCommand().equals("comboBoxChanged")){
				String stringCommodity = (String) commodityList.getSelectedItem();

				if(stringCommodity.equals("Tobacco")) {
					demand_elasticity = -0.4556;
					demand_constant = 1.005890000; //note this in billions
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
					printChart();
				}
				if(stringCommodity.equals("Footwear")) {
					demand_elasticity = -0.9135;
					demand_constant = 4.42665;
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
					printChart();
					
				}
				if(stringCommodity.equals("Jewelry")) {
					demand_elasticity = -0.41;
					demand_constant = 4.42665;
					demand_number = "in Hundred Millions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
					printChart();

				}
				if(stringCommodity.equals("Electricity")) {
					demand_elasticity = -0.1289;
					demand_constant = 3.08597;
					demand_number = "in Trillions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
					printChart();

				}
				if(stringCommodity.equals("Taxi")) {
					demand_elasticity = -0.6299;
					demand_constant = 1.00574;
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
					printChart();
				}
				if(stringCommodity.equals("Newspapers")) {
					System.out.println("This is new demand:"+demand);
					demand_elasticity = -0.4185;
					demand_constant = 2.26812;
					demand_number = "in Ten Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);

					printChart();
				}
				if(stringCommodity.equals("Movies")) {
					demand_elasticity = -0.8748;
					demand_constant = 8.72892;
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this);
					supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this);
					System.out.println("This is new demand:"+demand);
					printChart();


				}
			}

		}
		
}
