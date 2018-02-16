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

		public static void main(String[] args) {
			//System.out.println("Read...");
			Main m = new Main();


		}

		private void SetUpWindow() {
			setLayout(new BorderLayout());

			XYSeriesCollection dataset = new XYSeriesCollection();
			JFreeChart chart = ChartFactory.createXYLineChart("Berman is Stupid", null, null, dataset, PlotOrientation.HORIZONTAL, true, true, true);
			ChartPanel chartpanel = new ChartPanel(chart);
			chartpanel.setDomainZoomable(true);
			add(chartpanel,BorderLayout.CENTER);



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
