import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javax.swing.BoxLayout;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;



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
		XYSeries sup2;
		Boolean begin = false;
		Equation supply;
		int intersection;
		Double min_price;
		JPanel top;
		JLabel commodityName;
		JPanel surplus;
		JLabel consumerSurplus;
		JLabel producerSurplus;
		JLabel consumerSurplusLabel;
		JLabel producerSurplusLabel;
		Double max_price;
		XYSeries price_equilibrium;
		Double current_price;
		int counter;
		XYSeriesCollection dataset;
		JFreeChart chart;
		Double consumer_surplus;
		Double area_under;
		//public String petStrings[];
		public static void main(String[] args) {
			//System.out.println("Read...");
			Main m = new Main();
			quantity_bound = 200;
			//format for input of equations is k*math.pow(x,eps) 
			Equation line = new Equation("5*Math.pow(x,-1)",m, 1);
			//System.out.println(line.integral()[0]);

		}
		private void updateWindow(String checkbox){
			List<XYDataItem> items = demand.graph(demand.curve).getItems();
		
			/*
			int dist = (int) Math.abs(items.get(0).getYValue() - current_price);
			int closest_index = 0;
			for(int i=0; i<items.size();i++){
				if((int) Math.abs(items.get(i).getYValue() - current_price) < dist){
					dist = (int) Math.abs(items.get(i).getYValue() - current_price);
					closest_index = i;
				}
			}*/

			//area_under = integral[intersection][1] - integral[0][1];
			XYPlot plot = (XYPlot) chart.getPlot();
			XYSeriesCollection new_data = new XYSeriesCollection();
			//new_data.addSeries(supply.graph("" + intersection));
			counter+=1;
			new_data.addSeries(demand.graph(demand.curve));
			counter += 1;
			//new_data.addSeries(supply.graph(supply.curve));
			List<XYDataItem> integral = demand.integral().getItems();
			double consumer_surp = 0; 
			double prod_surp = 0;
			if(checkbox.equals("Tobacco")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 2.8238;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				prod_surp = quantity * current_price;
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);

			}else if(checkbox.equals("Footwear")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 8.77925;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				prod_surp = quantity * current_price;
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);
			}else if(checkbox.equals("Jewelry")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 6.01925;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				prod_surp = quantity * current_price;
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);
			}else if(checkbox.equals("Electricity")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 4.13812;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				prod_surp = quantity * current_price;
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);
			}else if(checkbox.equals("Taxi")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 3.44532;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);
			}else if(checkbox.equals("Newspapers")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 5.4177;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				prod_surp = quantity * current_price;
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);
			}else if(checkbox.equals("Movies")){
				XYSeries new_suptemp = new XYSeries("Supply");
				double quantity = 9.77154;
				for(double i=0.0;i<10;i++){
					new_suptemp.add(i,quantity);
				}
				new_data.addSeries(new_suptemp);
				consumer_surp = integral.get((int)(quantity * 100)).getYValue() - integral.get(0).getYValue() - (quantity*current_price);
				prod_surp = quantity * current_price;
				consumerSurplus.setText("$ "+Double.toString(consumer_surp)+" "+demand_number);
				producerSurplus.setText("$ "+Double.toString(prod_surp)+" "+demand_number);
			}
			if(price_equilibrium != null){
				new_data.addSeries(price_equilibrium);
			}
			
			
			
			System.out.println(consumer_surp +" " + prod_surp);
			plot.setDataset(new_data);
			//System.out.println(area_under);
		}

		private void SetUpWindow() {
			counter = 100;
			setLayout(new BorderLayout());
			
			
			String[] commodity = {"Tobacco", "Footwear", "Jewelry", "Electricity", "Taxi", "Newspapers", "Movies" };

			commodityList = new JComboBox<String>(commodity);
			commodityList.setSelectedIndex(0);
			commodityList.addActionListener(this);
			add(commodityList,BorderLayout.SOUTH);
			//price_floor = new XYSeries(1 + counter - counter * 2, false, false);
			//price_ceiling = new XYSeries(1 + counter + counter * 2, false, false);
			String stringCommodity = (String) commodityList.getSelectedItem();
			if(stringCommodity.equals("Tobacco")) {
				
				current_price = .1050;
				demand_elasticity = -0.4556;
				demand_constant = 1.005890000; //note this in billions
				demand_number = "in Billions";
				demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
				/*double[][] func = demand.graph(demand.curve).toArray();
				for(int i =0;i<func.length;i++){
					if(func[i][1] == current_price){
						intersection = i;
					}
				}*/
				supply = new Equation("" + intersection, this, 1);
				
				
			}

				commodityName = new JLabel("Pick Product Below to Start",SwingConstants.CENTER);

			commodityName.setFont (commodityName.getFont().deriveFont (30.0f));
			top = new JPanel();
			GridLayout twobyone = new GridLayout(2,1);
			BoxLayout boxlayout = new BoxLayout(top, BoxLayout.Y_AXIS);
			top.setLayout(twobyone);
			top.setBackground(Color.WHITE);
			top.setAlignmentX(Component.CENTER_ALIGNMENT);
			surplus = new JPanel();
			GridLayout twobytwo = new GridLayout(2,2);
			surplus.setLayout(twobytwo);
			surplus.setAlignmentX(Component.CENTER_ALIGNMENT);
			consumerSurplusLabel = new JLabel("<HTML><U>Consumer Surplus</U></HTML>",SwingConstants.CENTER);
			producerSurplusLabel = new JLabel("<HTML><U>Producer Surplus</U></HTML>",SwingConstants.CENTER);
			consumerSurplus = new JLabel();
			producerSurplus = new JLabel();
			consumerSurplus.setHorizontalAlignment(SwingConstants.CENTER);
			producerSurplus.setHorizontalAlignment(SwingConstants.CENTER);
			surplus.add(consumerSurplusLabel);
			surplus.add(producerSurplusLabel);
			surplus.add(consumerSurplus);
			surplus.add(producerSurplus);
			surplus.setBackground(Color.WHITE);

			top.add(commodityName);
			top.add(surplus);
			add(top,BorderLayout.NORTH);


				top.setVisible(true);



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
			
			dataset = new XYSeriesCollection();
			dataset.addSeries(demand.graph(demand.curve));
			counter+=1;
			dataset.addSeries(supply.graph(supply.curve));
			chart = ChartFactory.createXYLineChart("", "Quantity (in Billions)", "Price", dataset, PlotOrientation.HORIZONTAL, true, true, true);
			ChartPanel chartpanel = new ChartPanel(chart);


				chartpanel.setVisible(true);

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
			counter += 1;
			String stringCommodity = "";
			if(e.getActionCommand().equals("comboBoxChanged")){
				stringCommodity = (String) commodityList.getSelectedItem();
				commodityName.setText(stringCommodity);
				if(stringCommodity.equals("Tobacco")) {
					demand_elasticity = -0.4556;
					demand_constant = 1.005890000; //note this in billions
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					XYSeries temp2 = new XYSeries("Supply");
					current_price = .105;
					for(double i = 0.0; i < 10; i+=.1){
						temp_series.add(.105, i);

						//temp2.add(2.80112,i);
					}

					//find intersection point, use integral to find area
					sup2 = temp2;
					price_equilibrium = temp_series;

					//commodityName = new JLabel(stringCommodity,SwingConstants.CENTER);
					//printChart();
				}
				if(stringCommodity.equals("Footwear")) {
					demand_elasticity = -0.9135;
					demand_constant = 4.42665;
					current_price = .4726;
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					//supply = new Equation("2.8", this, 1);
					
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					for(double i = 0.0; i < 100; i+=.1){
						temp_series.add(.4726, i);
					}
					//find intersection point, use integral to find area

					price_equilibrium = temp_series;

					//printChart();
					//commodityName = new JLabel(stringCommodity,SwingConstants.CENTER);
					
				}
				if(stringCommodity.equals("Jewelry")) {
					demand_elasticity = -0.41;
					demand_constant = 4.42665;
					current_price = .1162;
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					for(double i = 0.0; i < 100; i+=.1){
						temp_series.add(.1162, i);
					}
					demand_number = "in Hundred Millions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					//supply = new Equation(supply_constant + "*Math.pow(x," + supply_elasticity + ")", this, 1);
					//printChart();
					price_equilibrium = temp_series;
					//commodityName = new JLabel(stringCommodity,SwingConstants.CENTER);

				}
				if(stringCommodity.equals("Electricity")) {
					demand_elasticity = -0.1289;
					demand_constant = 3.08597;
					current_price = .1028;
					demand_number = "in Trillions";
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					for(double i = 0.0; i < 100; i+=.1){
						temp_series.add(.1028, i);
					}
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					//printChart();
					price_equilibrium = temp_series;
					//commodityName = new JLabel(stringCommodity,SwingConstants.CENTER);

				}
				if(stringCommodity.equals("Taxi")) {
					demand_elasticity = -0.6299;
					demand_constant = 1.00574;
					current_price = .1410;
					demand_number = "in Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					//printChart();
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					for(double i = 0.0; i < 100; i+=.1){
						temp_series.add(.1410, i);
					}
					price_equilibrium = temp_series;
					//commodityName = new JLabel(stringCommodity,SwingConstants.CENTER);

				}
				if(stringCommodity.equals("Newspapers")) {
					System.out.println("This is new demand:"+demand);
					demand_elasticity = -0.4185;
					demand_constant = 2.26812;
					current_price = .125;
					demand_number = "in Ten Billions";
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					for(double i = 0.0; i < 100; i+=.1){
						temp_series.add(.125, i);
					}
					price_equilibrium = temp_series;
					//commodityName = new JLabel(stringCommodity,SwingConstants.CENTER);

					//printChart();
				}
				if(stringCommodity.equals("Movies")) {
					demand_elasticity = -0.8748;
					demand_constant = 8.72892;
					demand_number = "in Billions";
					current_price = .879;
					demand = new Equation(demand_constant + "*Math.pow(x," + demand_elasticity + ")",this, 0);
					//printChart();
					XYSeries temp_series = new XYSeries("Equilibrium Price");
					for(double i = 0.0; i < 100; i+=.1){
						temp_series.add(.879, i);
					}
					price_equilibrium = temp_series;


				}
			}

			updateWindow(stringCommodity);
		}
		
}
