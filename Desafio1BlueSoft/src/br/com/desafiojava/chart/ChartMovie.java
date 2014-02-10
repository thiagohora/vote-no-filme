package br.com.desafiojava.chart;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.desafiojava.model.Movie;

public class ChartMovie {

	private static JFreeChart chart;

	public static final JFreeChart getChart() {
		return chart;
	}
	
	public static void createChart(List<Movie>  movies){
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (Movie movie : movies) {
			dataset.addValue(movie.getPoints(), "Movies", movie.getName());
		}
		
		chart = ChartFactory.createBarChart3D("", "Movies", "Votes", dataset, PlotOrientation.VERTICAL, true, true, true);
		
	}
	
}
